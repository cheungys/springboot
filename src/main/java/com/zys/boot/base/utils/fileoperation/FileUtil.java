package com.zys.boot.base.utils.fileoperation;

import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author zys
 * 系统名称:
 * 模块名称:
 * 类 名 称: FileUtil
 * 类 定 义: 文件操作类
 * 开发时间: 2019/09/10  0:14
 * 审核人员:
 * 相关文档:
 * 修改记录: 修改日期 修改人员 修改说明
 */

public class FileUtil {
    public static long ONE_KB = 1024;
    public static long ONE_MB = ONE_KB * 1024;
    public static long ONE_GB = ONE_MB * 1024;
    public static long ONE_TB = ONE_GB * (long) 1024;
    public static long ONE_PB = ONE_TB * (long) 1024;

    public static String getHumanReadableFileSize(Long fileSize) {
        if (fileSize == null) {
            return null;
        }
        return getHumanReadableFileSize(fileSize.longValue());
    }

    public static String getHumanReadableFileSize(long fileSize) {
        if (fileSize < 0) {
            return String.valueOf(fileSize);
        }
        String result = getHumanReadableFileSize(fileSize, ONE_PB, "PB");
        if (result != null) {
            return result;
        }

        result = getHumanReadableFileSize(fileSize, ONE_TB, "TB");
        if (result != null) {
            return result;
        }
        result = getHumanReadableFileSize(fileSize, ONE_GB, "GB");
        if (result != null) {
            return result;
        }
        result = getHumanReadableFileSize(fileSize, ONE_MB, "MB");
        if (result != null) {
            return result;
        }
        result = getHumanReadableFileSize(fileSize, ONE_KB, "KB");
        if (result != null) {
            return result;
        }
        return String.valueOf(fileSize) + "B";
    }

    private static String getHumanReadableFileSize(long fileSize, long unit, String unitName) {
        if (fileSize == 0) {
            return "0";
        }

        if (fileSize / unit >= 1) {
            double value = fileSize / (double) unit;
            DecimalFormat df = new DecimalFormat("######.##" + unitName);
            return df.format(value);
        }
        return null;
    }

    public static Long getFileSizeByte(String fileSize) {
        String decimalRegex = "(([1-9]\\d*\\.?\\d*)|(0\\.\\d*[1-9]))";
        String typeRegex = "(B|KB|MB|GB|TB|PB|b|kb|mb|gb|tb|pb|Kb|Mb|Gb|Tb|Pb)";
        Pattern compile = Pattern.compile(decimalRegex + typeRegex);
        Matcher matcher = compile.matcher(fileSize);
        if (!matcher.matches()) {
            return null;
        }
        int fileLength = fileSize.length();
        if (fileSize.substring(fileLength - 2, fileLength).equalsIgnoreCase("PB")) {
            return Double.valueOf(Double.valueOf(fileSize.substring(0, fileLength - 2)) * ONE_PB).longValue();
        }
        if (fileSize.substring(fileLength - 2, fileLength).equalsIgnoreCase("TB")) {
            return Double.valueOf(Double.valueOf(fileSize.substring(0, fileLength - 2)) * ONE_TB).longValue();
        }
        if (fileSize.substring(fileLength - 2, fileLength).equalsIgnoreCase("GB")) {
            return Double.valueOf(Double.valueOf(fileSize.substring(0, fileLength - 2)) * ONE_GB).longValue();
        }
        if (fileSize.substring(fileLength - 2, fileLength).equalsIgnoreCase("MB")) {
            return Double.valueOf(Double.valueOf(fileSize.substring(0, fileLength - 2)) * ONE_MB).longValue();
        }
        if (fileSize.substring(fileLength - 2, fileLength).equalsIgnoreCase("KB")) {
            return Double.valueOf(Double.valueOf(fileSize.substring(0, fileLength - 2)) * ONE_KB).longValue();
        }
        if (fileSize.substring(fileLength - 1, fileLength).equalsIgnoreCase("B")) {
            return Double.valueOf(fileSize.substring(0, fileLength - 1)).longValue();
        }
        return null;
    }

    public static String getHumanReadableFileSizeGB(Long fileSize) {
        if (fileSize == null) {
            return null;
        }
        return getHumanReadableFileSizeGB(fileSize.longValue());
    }

    public static String getHumanReadableFileSizeGB(long fileSize) {
        if (fileSize <= 0) {
            return String.valueOf(fileSize);
        }
        double value = fileSize / (double) ONE_GB;
        DecimalFormat df = new DecimalFormat("######.##" + "GB");
        return df.format(value);
    }

    /**
     * 获取文件后缀
     *
     * @param fileName
     * @return
     */
    public static String getSuffixFromFileName(String fileName) {
        String suffix = fileName.substring(fileName.lastIndexOf("."));
        return suffix;
    }
}
