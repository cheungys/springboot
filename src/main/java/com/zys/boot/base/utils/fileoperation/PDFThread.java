package com.zys.boot.base.utils.fileoperation;

import org.apache.pdfbox.rendering.PDFRenderer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

/**
 * @author zys
 * 系统名称:
 * 模块名称:
 * 类 名 称: PDFThread
 * 类 定 义:
 * 开发时间: 2019/09/10  0:01
 * 审核人员:
 * 相关文档:
 * 修改记录: 修改日期 修改人员 修改说明
 */

public class PDFThread implements Runnable {
    private static final Logger logger = LoggerFactory.getLogger(PDFThread.class);
    private Map<Integer, PDFRenderer> map;
    private String outputFDir;
    private CountDownLatch latch;

    public PDFThread(Map<Integer, PDFRenderer> map, String outputFDir, CountDownLatch latch) {
        this.map = map;
        this.outputFDir = outputFDir;
        this.latch = latch;
    }

    @Override
    public void run() {
        for (Integer key : map.keySet()) {
            this.convert(map.get(key), key);
            logger.info("转换第几个" + key);
        }
        latch.countDown();
    }

    private void convert(PDFRenderer renderer, Integer i) {
        try {
            File dstFile = new File(outputFDir + (i + 1) + ".png");
            BufferedImage image = renderer.renderImageWithDPI(i, 100);
            ImageIO.write(image, "png", dstFile);
        } catch (Exception e) {
           logger.error(e.getMessage());
        }
    }
}
