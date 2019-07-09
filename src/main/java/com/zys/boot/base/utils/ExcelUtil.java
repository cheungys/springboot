package com.zys.boot.base.utils;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import com.zys.boot.base.exception.CommonException;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * 系统名称: 智慧客服平台
 * 模块名称: 客户关系数据平台
 * 类 名 称: ExcelUtil
 * 软件版权: 远传股份有限公司
 * 功能说明：为智慧客服平台提供数据支撑
 * 系统版本：v5.0.1.0
 * 开发人员: zys
 * 开发时间: 2019/03/11  09:55
 * 审核人员:
 * 相关文档:
 * 修改记录: 修改日期 修改人员 修改说明
 */

public class ExcelUtil {
    public static void exportExcel(List<?> list, String title, String sheetName, Class<?> pojoClass, String fileName, boolean isCreateHeader, HttpServletResponse response) {
        ExportParams exportParams = new ExportParams(title, sheetName);
        exportParams.setCreateHeadRows(isCreateHeader);
        defaultExport(list, pojoClass, fileName, response, exportParams);

    }

    public static void exportExcel(List<?> list, String title, String sheetName, Class<?> pojoClass, String fileName, HttpServletResponse response) {
        defaultExport(list, pojoClass, fileName, response, new ExportParams(title, sheetName));
    }

    public static void exportExcel(List<Map<String, Object>> list, String fileName, HttpServletResponse response) {
        defaultExport(list, fileName, response);
    }

    private static void defaultExport(List<?> list, Class<?> pojoClass, String fileName, HttpServletResponse response, ExportParams exportParams) {
        Workbook workbook = ExcelExportUtil.exportExcel(exportParams, pojoClass, list);
        if (workbook != null) ;
        downLoadExcel(fileName, response, workbook);
    }

    private static void downLoadExcel(String fileName, HttpServletResponse response, Workbook workbook) {
        try {
            response.setCharacterEncoding("UTF-8");
            response.setHeader("content-Type", "application/vnd.ms-excel");
            response.setHeader("Content-Disposition",
                    "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
            workbook.write(response.getOutputStream());
        } catch (IOException e) {
            throw new CommonException(e.getMessage());
        }
    }

    private static void defaultExport(List<Map<String, Object>> list, String fileName, HttpServletResponse response) {
        Workbook workbook = ExcelExportUtil.exportExcel(list, ExcelType.HSSF);
        if (workbook != null) ;
        downLoadExcel(fileName, response, workbook);
    }

    public static <T> List<T> importExcel(String filePath, Integer titleRows, Integer headerRows, Class<T> pojoClass) {
        if (StringUtils.isBlank(filePath)) {
            return null;
        }
        ImportParams params = new ImportParams();
        params.setTitleRows(titleRows);
        params.setHeadRows(headerRows);
        List<T> list = null;
        try {
            list = ExcelImportUtil.importExcel(new File(filePath), pojoClass, params);
        } catch (NoSuchElementException e) {
            throw new CommonException("模板不能为空");
        } catch (Exception e) {
            e.printStackTrace();
            throw new CommonException(e.getMessage());
        }
        return list;
    }

    /* public static <T> List<T> importExcel(MultipartFile file, Integer titleRows, Integer headerRows,Class<T> pojoClass) {
         if (file == null) {
             return null;
         }
         ImportParams params = new ImportParams();
         params.setTitleRows(titleRows);
         params.setHeadRows(headerRows);
         List<T> list = null;
         try {
             list = ExcelImportUtil.importExcel(file.getInputStream(), pojoClass, params);
         } catch (NoSuchElementException e) {
             throw new CommonException("excel文件不能为空");
         } catch (Exception e) {
             throw new CommonException(e.getMessage());
         }
         return list;
     }*/
    public static <T> List<T> importExcel(MultipartFile file, Class<T> pojoClass) {
        if (file == null) {
            return null;
        }
        ImportParams params = new ImportParams();
      /* params.setTitleRows(titleRows);
       params.setHeadRows(headerRows);*/
        List<T> list = null;
        try {
            list = ExcelImportUtil.importExcel(file.getInputStream(), pojoClass, params);
        } catch (NoSuchElementException e) {
            throw new CommonException("excel文件不能为空");
        } catch (Exception e) {
            throw new CommonException(e.getMessage());
        }
        return list;
    }

}
