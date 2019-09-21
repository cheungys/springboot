package com.zys.boot.base.utils.fileoperation;

import com.itextpdf.text.pdf.PdfReader;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

/**
 * @author zys
 * 系统名称:
 * 模块名称:
 * 类 名 称: PDFRenderUtil
 * 类 定 义:
 * 开发时间: 2019/09/09  23:55
 * 审核人员:
 * 相关文档:
 * 修改记录: 修改日期 修改人员 修改说明
 */

public class PDFRenderUtil {
    public static int convert(String inputPDFPath, String outputFDir) throws IOException, FileNotFoundException {
        long beginTime = System.nanoTime();
        //pdf文件存在校验，输出文件夹创建
        File file = new File(inputPDFPath);
        if(!file.exists()){
            throw new FileNotFoundException("文件不存在: " + inputPDFPath);
        }
        File outputFolder = new File(outputFDir);
        if(!outputFolder.exists()){
            outputFolder.mkdirs();
        }

        PdfReader reader = new PdfReader(inputPDFPath);
        int pages = reader.getNumberOfPages();
        PDDocument pdDocument = PDDocument.load(file);
        PDFRenderer renderer = new PDFRenderer(pdDocument);

        System.out.println("PDF页数： " +pages + " , " + inputPDFPath);
        int threadNumber = 0;
        if(pages % 4 != 0){
            threadNumber = pages / 4 + 1;
        }else{
            threadNumber = pages / 4 ;
        }
        CountDownLatch latch=new CountDownLatch(threadNumber);
        //转化处理
        int threadCount = 0;
        Map<Integer, PDFRenderer> map = new LinkedHashMap<Integer, PDFRenderer>();
        for (int i = 1; i <= pages; i++) {
            map.put(i-1, renderer);
            if(i % 4 == 0){
                PDFThread thread = new  PDFThread(map, outputFDir, latch);
                new Thread(thread).start();
                threadCount++;
                map = new LinkedHashMap<Integer, PDFRenderer>();
            }
        }
        System.out.println("threadCount = " + threadCount);
        if(map.size() > 0){
            PDFThread thread = new  PDFThread(map, outputFDir, latch);
            new Thread(thread).start();
            threadCount++;
        }
        System.out.println("threadCount = " + threadCount + " : map size = " + map.size());
        try {
            latch.await();
            long endTime = System.nanoTime();
            System.out.println("耗时: " + (endTime - beginTime) / 1000000000 + " 秒" );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return pages;
    }

    /**
     * @Description: 将base64编码字符串转换为图片
     * @Author:
     * @CreateTime:
     * @param imgStr base64编码字符串
     * @param path 图片路径-具体到文件
     * @return
     */
    public static boolean generateImage(String imgStr, String path) {
        if (imgStr == null) {
            return false;
        }
        File file = new File(path);
        File fileParent = file.getParentFile();
        if(!fileParent.exists()){
            fileParent.mkdirs();
        }
        BASE64Decoder decoder = new BASE64Decoder();
        OutputStream out = null;
        try {
            // 解密
            byte[] b = decoder.decodeBuffer(imgStr);
            // 处理数据
            for (int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {
                    b[i] += 256;
                }
            }
            out = new FileOutputStream(path);
            out.write(b);
            out.flush();
            IOUtils.closeQuietly(out);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            IOUtils.closeQuietly(out);
        }
        return false;
    }

    /**
     * @Description: 根据图片地址转换为base64编码字符串
     * @Author:
     * @CreateTime:
     * @return
     */
    public static String getImageStr(String imgFile) {
        InputStream inputStream = null;
        byte[] data = null;
        try {
            inputStream = new FileInputStream(imgFile);
            data = new byte[inputStream.available()];
            inputStream.read(data);
            IOUtils.closeQuietly(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 加密
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(data);
    }

    /***
     * 删除指定文件夹下所有图片文件
     * @param path 文件夹完整绝对路径
     * @return
     */
    public static  void delAllImageFileByPath(String path) {
        File file = new File(path);
        if (!file.exists()) {
            return;
        }
        File[] files = file.listFiles();
        if(files != null && files.length > 0){
            // 循环获取图片文件夹内的图片
            for (File file1 : files) {
                if (file1.getName().endsWith(".png")
                        || file1.getName().endsWith(".jpg")
                        || file1.getName().endsWith(".gif")
                        || file1.getName().endsWith(".jpeg")
                        || file1.getName().endsWith(".tif")) {
                    file1.delete();
                }
            }
        }
    }
    /**
     * 获取全部涂鸦
     * @param path
     * @return
     */
    public static  Map<String, Object> getAllPartAuthorityImageByPath(String path) {
        File file = new File(path);
        if (!file.exists()) {
            return new HashMap<String, Object>();
        }
        Map<String, Object> map = new HashMap<String, Object>();
        File[] files = file.listFiles();
        if(files != null && files.length > 0){
            // 循环获取图片文件夹内的图片
            for (File file1 : files) {
                if (file1.getName().endsWith(".png")
                        || file1.getName().endsWith(".jpg")
                        || file1.getName().endsWith(".gif")
                        || file1.getName().endsWith(".jpeg")
                        || file1.getName().endsWith(".tif")) {
                    String name = file1.getName().substring(0, file1.getName().lastIndexOf("."));
                    map.put(name, getImageStr(file1.getAbsolutePath()));
                }
            }
        }

        return map;
    }

    public static void main(final String[] args) throws FileNotFoundException, IOException {
//		String inputPDFPath = "D:\\pdf\\2010110东南大学档案管理系统需求分析说明书正式.pdf";
        String inputPDFPath = "c:\\upload\\2018-12-24\\11111111111111111111111111111111112.pdf";
//		String inputPDFPath = "D:\\pdf\\Linux命令行技术大全.pdf";
        String outputFDir = "c:\\upload\\2018-12-24\\1111111111111111111111111111111111\\";
        //PDFRenderUtil.convert(inputPDFPath, outputFDir);

        System.out.println(inputPDFPath.substring(0, inputPDFPath.lastIndexOf(".")));
    }
}
