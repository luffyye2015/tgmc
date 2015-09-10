package com.gmc.topic.core.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 * Copyright(C)  
 *
 * Module: 
 * @author 叶子丰
 * @version
 * @see
 * @since 2013-10-31
 * @description: 字符串工具类
 * @log:
 */
public class StringUtils {

	/**
     * Used by the hash method.
     */
    private static Map digests = Collections.synchronizedMap(new HashMap());
	
	/**
     * Hashes a String using the Md5 algorithm and returns the result as a
     * String of hexadecimal numbers. This method is synchronized to avoid
     * excessive MessageDigest object creation. If calling this method becomes
     * a bottleneck in your code, you may wish to maintain a pool of
     * MessageDigest objects instead of using this method.
     * <p/>
     * A hash is a one-way function -- that is, given an
     * input, an output is easily computed. However, given the output, the
     * input is almost impossible to compute. This is useful for passwords
     * since we can store the hash and a hacker will then have a very hard time
     * determining the original password.
     * <p/>
     * In Jive, every time a user logs in, we simply
     * take their plain text password, compute the hash, and compare the
     * generated hash to the stored hash. Since it is almost impossible that
     * two passwords will generate the same hash, we know if the user gave us
     * the correct password or not. The only negative to this system is that
     * password recovery is basically impossible. Therefore, a reset password
     * method is used instead.
     *
     * @param data the String to compute the hash of.
     * @return a hashed version of the passed-in String
     */
	public static String hash(String data) {
        return hash(data, "MD5");
	}

	/**
     * Hashes a String using the specified algorithm and returns the result as a
     * String of hexadecimal numbers. This method is synchronized to avoid
     * excessive MessageDigest object creation. If calling this method becomes
     * a bottleneck in your code, you may wish to maintain a pool of
     * MessageDigest objects instead of using this method.
     * <p/>
     * A hash is a one-way function -- that is, given an
     * input, an output is easily computed. However, given the output, the
     * input is almost impossible to compute. This is useful for passwords
     * since we can store the hash and a hacker will then have a very hard time
     * determining the original password.
     * <p/>
     * In Jive, every time a user logs in, we simply
     * take their plain text password, compute the hash, and compare the
     * generated hash to the stored hash. Since it is almost impossible that
     * two passwords will generate the same hash, we know if the user gave us
     * the correct password or not. The only negative to this system is that
     * password recovery is basically impossible. Therefore, a reset password
     * method is used instead.
     *
     * @param data the String to compute the hash of.
     * @param algorithm the name of the algorithm requested.
     * @return a hashed version of the passed-in String
     */
    public static String hash(String data, String algorithm) {
        try {
            return hash(data.getBytes("utf-8"), algorithm);
        } catch (java.io.UnsupportedEncodingException e) {
            System.err.println(e);
        }
        return data;
    }
    
    /**
     * Hashes a byte array using the specified algorithm and returns the result as a
     * String of hexadecimal numbers. This method is synchronized to avoid
     * excessive MessageDigest object creation. If calling this method becomes
     * a bottleneck in your code, you may wish to maintain a pool of
     * MessageDigest objects instead of using this method.
     * <p/>
     * A hash is a one-way function -- that is, given an
     * input, an output is easily computed. However, given the output, the
     * input is almost impossible to compute. This is useful for passwords
     * since we can store the hash and a hacker will then have a very hard time
     * determining the original password.
     * <p/>
     * In Jive, every time a user logs in, we simply
     * take their plain text password, compute the hash, and compare the
     * generated hash to the stored hash. Since it is almost impossible that
     * two passwords will generate the same hash, we know if the user gave us
     * the correct password or not. The only negative to this system is that
     * password recovery is basically impossible. Therefore, a reset password
     * method is used instead.
     *
     * @param bytes the byte array to compute the hash of.
     * @param algorithm the name of the algorithm requested.
     * @return a hashed version of the passed-in String
     */
	public static String hash(byte[] bytes, String algorithm) {
        synchronized (algorithm.intern()) {
            MessageDigest digest = (MessageDigest)digests.get(algorithm);
            if (digest == null) {
                try {
                    digest = MessageDigest.getInstance(algorithm);
                    digests.put(algorithm, digest);
                } catch (NoSuchAlgorithmException nsae) {
                    System.err.println(
                                    "Failed to load the "
                                            + algorithm
                                            + " MessageDigest. "
                                            + "Jive will be unable to function normally."
                                            + nsae);
                    return null;
                }
            }
            // Now, compute hash.
            digest.update(bytes);
            return encodeHex(digest.digest());
        }
    }
	
	/**
     * Turns an array of bytes into a String representing each byte as an
     * unsigned hex number.
     * <p/>
     * Method by Santeri Paavolainen, Helsinki Finland 1996<br>
     * (c) Santeri Paavolainen, Helsinki Finland 1996<br>
     * Distributed under LGPL.
     *
     * @param bytes an array of bytes to convert to a hex-string
     * @return generated hex string
     */
    public static String encodeHex(byte[] bytes) {
        StringBuffer buf = new StringBuffer(bytes.length * 2);
        int i;

        for (i = 0; i < bytes.length; i++) {
            if (((int) bytes[i] & 0xff) < 0x10) {
                buf.append("0");
            }
            buf.append(Long.toString((int) bytes[i] & 0xff, 16));
        }
        return buf.toString();
    }
    
    /**
	 * 根据提交的参数生产url参数穿
	 * @param request
	 * @param excludeKey
	 * @return
	 */
	  public static String getQueryString(HttpServletRequest request,String... excludeKey)
	  {
	       Map<String,String[]> param=request.getParameterMap();
	        StringBuffer sb=new StringBuffer();
	        String[] value;
	        int i;
	        boolean hasExclude=excludeKey!=null&&excludeKey.length>0;
	        String amp="&amp;";
	       try
	        {
	            outer:for(String key:param.keySet())
	            {
	                if(hasExclude)
	                {
	                    for(int j=0;j<excludeKey.length;j++)
	                    {
	                        if(excludeKey[j].equals(key))
	                        {
	                            continue outer;
	            }
	        }
	                }
	                value=param.get(key);
	                if(param!=null)
	                {
	                    for(i=0;i<value.length;i++)
	                    {
	                        sb.append(amp);
	                        sb.append(key);
	                        sb.append('=');
	                        sb.append(URLEncoder.encode(value[i],"UTF-8"));
	                    }
	                }
	            }
	        }
	       catch (UnsupportedEncodingException e)
	       {
	                    e.printStackTrace(); 
	        }
	        return sb.length()>0?sb.substring(5):"";
	  }
}
