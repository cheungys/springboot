package com.zys.boot.base.utils;

import org.apache.commons.lang.RandomStringUtils;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Vector;

/**
 * @author zys
 * 系统名称:
 * 模块名称: 公共模块
 * 类 名 称: StringUtil
 * 类 定 义: 字符串处理工具类
 * 开发时间: 2019/06/09  22:12
 * 审核人员:
 * 相关文档:
 * 修改记录: 修改日期 修改人员 修改说明
 */

public class StringUtil {
    /**
     * 判断是否为空
     *
     * @param obj
     * @return
     */
    public static boolean isNull(Object obj) {
        if ((obj != null) && (!"".equals(obj))) {
            return false;
        }
        return true;
    }

    /**
     * 判断是否为非空
     *
     * @param obj
     * @return
     */
    public static boolean isNotNull(Object obj) {
        if ((obj != null) && (!"".equals(obj.toString()))) {
            return true;
        }
        return false;
    }

    /**
     * 判断是否为非空(忽略前导空白和尾部空白)
     *
     * @param obj
     * @return
     */
    public static boolean isTrimNotNull(Object obj) {
        if ((obj != null) && (!"".equals(obj.toString().trim()))) {
            return true;
        }
        return false;
    }

    /**
     * 得到不为null得字符串
     *
     * @param obj
     * @return
     */
    public static String toNotNullString(Object obj) {
        return obj == null ? "" : obj.toString();
    }

    /**
     * 将 null 转为0
     */
    public static String nullToZero(Object obj) {
        return toNotNullString(obj).equals("") ? "0" : obj.toString();
    }


    /**
     * 将 null 转为空串
     */
    public static String nullToSpace(String str) {
        if (str == null) {
            return "";
        } else {
            return str;
        }
    }

    /**
     * 将 null 转为HTML空格
     */
    public static String nullToHtmlSpace(Object obj) {
        return toNotNullString(obj).trim().equals("") ? "&nbsp;" : obj.toString();
    }

    /**
     * 给字符串（可以是以逗号分开的字符串）加上单引号，
     *
     * @param strOld 字符串（可以是以逗号分开的字符串）
     * @return
     */
    public static String addSingleQuotes(String strOld) {
        if (isNull(strOld)) {
            return "";
        }
        String strNew = "";
        StringTokenizer st = new StringTokenizer(strOld, ",");
        while (st.hasMoreTokens()) {
            String temp = st.nextToken();
            strNew += "'" + temp + "',";
        }
        strNew = strNew.substring(0, strNew.length() - 1);
        return strNew;
    }

    /**
     * 替换String中的字符串. 在标准的String类中只有将String中的某一个字符替换成另一个字符，该函数可以将String
     * 中的某一字符串替换成另一个字符串.
     *
     * @param str0 源字符串 tag 将要被替换的字符串 news 将要替换的字符串
     * @return 将源字符串替换后的字符串
     */
    public static String replace(String str, String tag, String news) {
        if (str == null || str.length() == 0 || tag == null
                || tag.length() == 0)
            return (str);
        String ret = str, temp = "";
        String l_str;
        int len_s = str.length();
        int len_t = tag.length();
        int pos_1 = 0, pos_2 = 0;
        int i = 0;
        while (i < len_s) {
            if (i >= (len_s - len_t))
                l_str = str.substring(i);
            else
                l_str = str.substring(i, i + len_t);
            if (l_str.equals(tag)) {
                pos_2 = i;
                temp = temp + str.substring(pos_1, pos_2) + news;
                i = i + len_t;
                pos_1 = i;
            } else
                i++;
        }
        if (pos_1 < len_s)
            temp = temp + str.substring(pos_1);

        if (temp.length() > 0)
            ret = temp;

        return (ret);
    }

    /**
     * 查找某一字符串包含另一字符串的个数. 此处规定已匹配过的字符
     *
     * @param str1 源字符串 str2 将要被替换的字符串
     * @return 包含的个数
     */
    public static int hasStr(String str1, String str2) {
        int sum = 0;
        String sTemp = new String(str1);
        while (sTemp.indexOf(str2) != -1) {
            sum++;
            sTemp = sTemp.substring(sTemp.indexOf(str2) + str2.length());
            // System.out.println(sTemp);
        }
        return sum;
    }

    /**
     * 将字符串转化成gb2312的编码格式
     */
    public static String parseChinese(String strChinese) {
        try {
            return new String(strChinese.trim().getBytes("8859_1"), "GB2312");
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * 将一个字符串根据一个标示拆分成一个字符串数组.例如",1,2,3,"如果使用“,”分解，将被分成长度为5的字符串数组
     *
     * @param source 源字符串,str 拆分标示字符。
     * @return 被拆分的字符串
     */
    public static String[] toArray(String source, String str) {
        Vector vResult = new Vector();
        if (source == null || source.equals(""))
            return new String[0];
        if (str == null || "".equals(str))
            return new String[]{source};
        int pos1 = 0;
        int pos2 = 0;
        pos2 = source.indexOf(str);
        String strItem = "";
        if (pos2 < 0) {
            pos2 = source.length();
            strItem = source;
        }
        while (pos2 >= pos1 && pos1 < source.length()) {
            strItem = source.substring(pos1, pos2);
            /**
             * if("".equals(strItem)||str.equals(strItem)){ pos1 = pos2 + 1;
             * pos2 = source.indexOf(str,pos1); if(pos2<=0)pos2=source.length();
             * continue; }
             */
            vResult.add(strItem);
            pos1 = pos2 + 1;
            pos2 = source.indexOf(str, pos1);
            if (pos2 <= 0)
                pos2 = source.length();

        }
        return toArray(vResult);
    }

    public static String[] split(String source, String token) {
        // return toArray(source,token);
        return stringToArray(source, token);
    }

    public static String[] splitString(String source, String token) {
        return stringToArray(source, token);
    }

    public static String[] stringToArray(String source, String str) {
        Vector vResult = new Vector();
        if (source == null || source.equals(""))
            return new String[0];
        if (str == null || "".equals(str))
            return new String[]{source};
        int pos1 = 0;
        int pos2 = 0;
        pos2 = source.indexOf(str);
        String strItem = "";
        if (pos2 < 0) {
            pos2 = source.length();
            strItem = source;
        }
        while (pos2 >= pos1 && pos1 <= source.length()) {
            if (pos2 == source.length() && pos1 == source.length()) {
                strItem = source.substring(pos2);
                vResult.add(strItem);
                break;
            }
            strItem = source.substring(pos1, pos2);
            vResult.add(strItem);
            pos1 = pos2 + 1;
            pos2 = source.indexOf(str, pos1);
            if (pos2 <= 0)
                pos2 = source.length();
        }
        return toArray(vResult);
    }

    public static String[] toArray(Vector vec) {
        int intSize = vec.size();
        String str[] = new String[intSize];
        for (int i = 0; i < intSize; i++)
            str[i] = vec.elementAt(i).toString();
        return str;
    }

    public static String[] clearElement(String[] sources, String str) {
        sources = moveToEnd(sources, str);
        int size = 0;
        for (; size < sources.length; size++) {
            if (sources[size].equals(str))
                break;
        }
        String[] temp = new String[size];
        for (int i = 0; i < size; i++)
            temp[i] = sources[i];
        return temp;
    }

    /**
     * 将一个String[]中的某种字符串移到数组的末尾.
     *
     * @param sources 源字符串数组 str 将要移动的字符串
     * @return 移动后的字符串数组
     */
    public static String[] moveToEnd(String[] sources, String str) {
        int head = 0;
        int end = sources.length - 1;
        while (head != end) {
            while (head != end) {
                if (sources[head].equals(str))
                    break;
                head++;
            }
            while (head != end) {
                if (!sources[end].equals(str))
                    break;
                end--;
            }
            if (head != end) {
                String temp = sources[head];
                sources[head] = sources[end];
                sources[end] = temp;
            }
        }
        return sources;
    }

    /**
     * 将字符串数组转化成int型数组.
     *
     * @param sources 源字符串数组
     * @return int[]
     */
    public static int[] pareInts(String[] sources) {
        int[] temp = new int[sources.length];
        for (int i = 0; i < sources.length; i++) {
            temp[i] = Integer.parseInt(sources[i]);
        }
        return temp;
    }

    /**
     *
     */
    public static String toString(Vector vec, String str) {
        String s = "";
        for (int i = 0; i < vec.size(); i++) {
            if (i != 0)
                s += str;
            s += vec.elementAt(i).toString().trim();
        }
        return s;
    }

    /**
     *
     */
    public static String toString(String[] scr, String str) {
        String s = "";
        for (int i = 0; i < scr.length; i++) {
            if (i != 0)
                s += str;
            s += scr[i];
        }
        return s;
    }

    /**
     * 从字符串中取出一个单词
     */
    public static String getWord(String str, int index) throws Exception {
        if (index < 1)
            throw new Exception("getWord error,index less than 1");
        String word = null;
        for (int i = 0; i < index; i++) {
            word = getFirstWord(str, true);
        }
        return word;
    }

    /**
     * 从字符串中取出第一个单词,并且将分隔符（'，'、‘ ’）也作为一个单词
     */
    public static String getFirstWord(String str, boolean hasSeparator)
            throws Exception {
        if (str.equals(""))
            return "";
        char ch = str.charAt(0);
        if (ch == '(' || ch == '[' || ch == '{')
            return getBracket(str, ch);
        if (ch == '\'')
            return getString(str, ch);
        int offs = str.indexOf(" ") == -1 ? str.length() : str.indexOf(" ");
        String separator = " ";
        if (str.indexOf(",") != -1 && str.indexOf(",") < offs) {
            offs = str.indexOf(",");
            separator = ",";
        }
        if (str.indexOf("-") != -1 && str.indexOf("-") < offs) {
            offs = str.indexOf("-");
            separator = "-";
        }
        if (str.indexOf("+") != -1 && str.indexOf("+") < offs) {
            offs = str.indexOf("+");
            separator = "+";
        }
        if (str.indexOf("*") != -1 && str.indexOf("*") < offs) {
            offs = str.indexOf("*");
            separator = "*";
        }
        if (str.indexOf("=") != -1 && str.indexOf("=") < offs) {
            offs = str.indexOf("=");
            separator = "=";
        }
        if (str.indexOf("||") != -1 && str.indexOf("||") < offs) {
            offs = str.indexOf("||");
            separator = "||";
        }
        if (str.indexOf("(") != -1 && str.indexOf("(") < offs) {
            offs = str.indexOf("(");
            return str.substring(0, offs)
                    + getBracket(str.substring(offs), '(');
        }
        if (offs == -1)
            return str;
        if (hasSeparator && offs == 0)
            return separator;
        return str.substring(0, offs);
    }

    /**
     * 从字符串中取出第一个单词,但将分隔符（'，'、‘ ’）也作为一个单词
     */
    public static String getFirstWord(String str) throws Exception {
        return getFirstWord(str, false);
    }

    /**
     * 匹配一个字符串中的第一个刮号. 这里假定该字符串的的刮号是正确的
     */
    public static String getBracket(String str, char bracketType)
            throws Exception {
        char endType = ')';
        if (bracketType == '[')
            endType = ']';
        else if (bracketType == '{')
            endType = '}';
        else if (bracketType != '(')
            throw new Exception(bracketType + " not a type of bracket");

        char[] c = str.toCharArray();
        int sum = 1;
        String s = null;
        for (int i = 1; i < c.length; i++) {
            if (c[i] == bracketType) {
                sum++;
                continue;
            }
            if (c[i] == endType) {
                if (--sum == 0) {
                    s = String.valueOf(c, 0, i + 1);
                    break;
                }
            }
        }
        if (s == null)
            throw new Exception("bracket not suited");
        return s;
    }

    public static String ltrim(String str) {
        char[] c = str.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] != ' ') {
                str = String.valueOf(c, i, c.length - i);
                break;
            }
        }
        return str;
    }


    /**
     * 根据标示符取一个字符串
     */
    public static String getString(String str, char c) {
        char[] ch = str.toCharArray();
        for (int i = 1; i < ch.length; i++) {
            if (ch[i] == c) {
                if (i == ch.length - 1) {
                    str = String.valueOf(ch, 0, i + 1);
                    break;
                }
                if (ch[i + 1] != c) {
                    str = String.valueOf(ch, 0, i + 1);
                    break;
                } else {
                    i++;
                }
            }
        }
        return str;
    }

    /**
     * 将ISO的字符转换为GBK编码
     * @throws UnsupportedEncodingException
     */

//		public static String toGBKString(String str) throws UnsupportedEncodingException {
//			 if(str==null){
//				 return "";
//			 }
//			 	return new String(str.getBytes("ISO-8859-1"),"GBK");
//		}

    /**
     * 剪切字符串
     *
     * @param source        源字符
     * @param length        需要剪切的长度
     * @param replaceString 剪切后的字符尾 默认是(...)
     * @return
     */
    public static String cutString(String source, int length, String replaceString) {
        if (source == null) {
            return "";
        }
        if (length == 0) {
            return toNotNullString(source);
        }
        ;
        if (isNull(replaceString)) {
            replaceString = "...";
        }
        if (source.length() <= length) {
            return source;
        } else {
            length = length - replaceString.length();
            if (length > 0) {
                return source.substring(0, length) + replaceString;
            } else {
                return source.substring(0, length + replaceString.length()) + replaceString;
            }
        }

    }

    public static boolean equals(String str1, String str2) {
        boolean rs = true;
        if (!(str1 == null && str2 == null)) {
            if (str1 == null && str2 != null) rs = false;
            else if (str2 == null && str1 != null) rs = false;
            else if (!str1.equals(str2)) rs = false;
        }
        return rs;
    }

    public static String nullPass(String str1) {
        return str1 == null ? "" : str1;
    }

    public static void main(String[] param) {
        String a = "abcefg";
        String b = "bc";
        String c = "z";
        //System.out.println(replace(a, b, c));


    }

    /**
     * 把字符串分割后返回分隔完成的字符集合
     *
     * @param nextOpertors
     * @return
     */
    public static List getListFromString(String nextOpertors) {
        List resultList = new ArrayList();
        String[] array = split(nextOpertors, ",");
        for (int i = 0; i < array.length; i++) {
            resultList.add(array[i]);
        }
        return resultList;
    }

    /**
     * @param sourceStr
     * @param targetStr
     * @return
     */
    public static boolean testStringIsSame(String sourceStr, String targetStr) {
        try {
            int index = sourceStr.length();
            if (sourceStr.indexOf("*") != -1) {
                index = sourceStr.indexOf("*");
                String targetStrSubStr = targetStr.substring(index + 1);
                String sourceStrSubStr = sourceStr.substring(index + 1);
                if (!targetStrSubStr.endsWith(sourceStrSubStr)) {
                    return false;
                }
            }
            for (int i = 0; i < index; i++) {
                if ('?' != (sourceStr.charAt(i)) && sourceStr.charAt(i) != (targetStr.charAt(i))) {
                    return false;
                }
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /***
     * MD5加码 生成32位md5码
     */
    public static String string2MD5(String inStr) {
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            //System.out.println(e.toString());
            e.printStackTrace();
            return "";
        }
        byte[] charArray = inStr.getBytes();
        byte[] byteArray = new byte[charArray.length];

        for (int i = 0; i < charArray.length; i++)
            byteArray[i] = (byte) charArray[i];
        byte[] md5Bytes = md5.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++) {
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16)
                hexValue.append("0");
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();

    }

    /**
     * 判断空字符串 null和"" 时就都返回 true 不是返回false
     *
     * @param s
     * @return
     * @author wang wen
     */
    public static boolean isEmpty(String s) {
        if (s != null && !s.equals("")) {
            return false;
        }
        return true;
    }

    public static String getEmptyString() {
        return "";
    }

    /**
     * 判断对象是否为空
     *
     * @param str
     * @return
     */
    public static boolean isNotEmpty(Object str) {
        boolean flag = true;
        if (str != null && !str.equals("")) {
            if (str.toString().length() > 0) {
                flag = true;
            }
        } else {
            flag = false;
        }
        return flag;
    }

    /**
     * StringUtils.isBlank(null)      = true
     * StringUtils.isBlank("")        = true
     * StringUtils.isBlank(" ")       = true
     * StringUtils.isBlank("bob")     = false
     * StringUtils.isBlank("  bob  ") = false
     *
     * @param str
     * @return
     */
    public static boolean isBlank(String str) {
        int strLen;
        if (str == null || (strLen = str.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if ((Character.isWhitespace(str.charAt(i)) == false)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isNotBlank(String str) {
        return !isBlank(str);
    }

    /**
     * 存文本替换
     *
     * @param s  源字符串
     * @param sf 子字符串
     * @param sb 替换字符串      用sb 替换sf
     * @return 替换后的字符串
     */
    public static String replaceAll(String s, String sf, String sb) {
        int i = 0, j = 0;
        int l = sf.length();
        boolean b = true;
        boolean o = true;
        String str = "";
        do {
            j = i;
            i = s.indexOf(sf, j);
            if (i > j) {
                str += s.substring(j, i);
                str += sb;
                i += l;
                o = false;
            } else {
                str += s.substring(j);
                b = false;
            }
        } while (b);
        if (o) {
            str = s;
        }
        return str;
    }

    /**
     * 首字母大写
     *
     * @param realName
     * @return
     */
    public static String firstUpperCase(String realName) {
        return org.apache.commons.lang.StringUtils.replaceChars(realName, realName.substring(0, 1), realName.substring(0, 1).toUpperCase());
    }

    /**
     * 随即生成指定位数的含验证码字符串
     *
     * @param bit 指定生成验证码位数
     * @return String
     * @author Peltason
     */
    public static String random(int bit) {
        if (bit == 0)
            bit = 6; // 默认6位
        // 因为o和0,l和1很难区分,所以,去掉大小写的o和l
        String str = "";
        str = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijkmnpqrstuvwxyz";// 初始化种子
        return RandomStringUtils.random(bit, str);// 返回6位的字符串
    }
}
