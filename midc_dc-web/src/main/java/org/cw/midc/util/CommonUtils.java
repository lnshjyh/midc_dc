package org.cw.midc.util;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommonUtils {

	private static final Logger log = LoggerFactory.getLogger(CommonUtils.class);
	
	/**
	 * 获取当前文件存储基路径
	 * @return
	 */
	public static String getCurrentBaseDir(String studyInfoId)
	{
		String baseDirStr = "F:/dicomsave" + "/" + studyInfoId;
		File baseDir = new File(baseDirStr);
		if(!baseDir.exists() && !baseDir .isDirectory())
		{
			log.info("create new base path: {}", baseDirStr);
			baseDir.mkdir();
		}
		return baseDirStr;
	}
	
	/**
	 * 获取文件新名称
	 * @return
	 */
	public static String generateNewFileName()
	{
		UUID uuid = UUID.randomUUID();
		return uuid.toString().replace("-", "").toUpperCase();
	}
	
	/**
	 * 获取文件新名称
	 * @return
	 */
	public static String generateId()
	{
		UUID uuid = UUID.randomUUID();
		return uuid.toString().replace("-", "").toUpperCase();
	}
	
	/**
	 * 取MD5摘要
	 * @param sourceStr
	 * @return
	 */
	public static String MD5(String sourceStr) {  
        String result = "";  
        try {  
            MessageDigest md = MessageDigest.getInstance("MD5");  
            md.update(sourceStr.getBytes());  
            byte b[] = md.digest();  
            int i;  
            StringBuffer buf = new StringBuffer("");  
            for (int offset = 0; offset < b.length; offset++) {  
                i = b[offset];  
                if (i < 0)  
                    i += 256;  
                if (i < 16)  
                    buf.append("0");  
                buf.append(Integer.toHexString(i));  
            }  
            result = buf.toString();    
        } catch (NoSuchAlgorithmException e) {  
            System.out.println(e);  
        }  
        return result;  
    }
    
    public final static String MD52(String pwd) {  
        //用于加密的字符  
        char md5String[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',  
                'A', 'B', 'C', 'D', 'E', 'F' };  
        try {  
            //使用平台的默认字符集将此 String 编码为 byte序列，并将结果存储到一个新的 byte数组中  
            byte[] btInput = pwd.getBytes();  
               
            //信息摘要是安全的单向哈希函数，它接收任意大小的数据，并输出固定长度的哈希值。  
            MessageDigest mdInst = MessageDigest.getInstance("MD5");  
               
            //MessageDigest对象通过使用 update方法处理数据， 使用指定的byte数组更新摘要  
            mdInst.update(btInput);  
               
            // 摘要更新之后，通过调用digest（）执行哈希计算，获得密文  
            byte[] md = mdInst.digest();  
               
            // 把密文转换成十六进制的字符串形式  
            int j = md.length;  
            char str[] = new char[j * 2];  
            int k = 0;  
            for (int i = 0; i < j; i++) {   //  i = 0  
                byte byte0 = md[i];  //95  
                str[k++] = md5String[byte0 >>> 4 & 0xf];    //    5   
                str[k++] = md5String[byte0 & 0xf];   //   F  
            }  
               
            //返回经过加密后的字符串  
            return new String(str);  
               
        } catch (Exception e) {  
            return null;  
        }  
    }  
    /*public static void main(String[] args)
    {
    	long begin = System.currentTimeMillis();
    	MD52("1234151451");
    	String a = "12341515" + "31415145";
    	long end = System.currentTimeMillis();
    	System.out.println(end - begin);
    }*/
	
}
