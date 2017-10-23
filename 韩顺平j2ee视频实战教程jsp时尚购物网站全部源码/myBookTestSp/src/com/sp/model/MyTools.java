//工具类，一些常用的方法等等.
package com.sp.model;

public class MyTools {

	//转换中文乱码
	public static String changeToGB2312(String srcString){
		
		String newString="";
		try {
			
			newString=new String(srcString.getBytes("iso-8859-1"),"gb2312");
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		return newString;
	}
}
