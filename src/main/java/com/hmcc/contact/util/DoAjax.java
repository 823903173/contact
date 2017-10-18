package com.hmcc.contact.util;

import com.alibaba.fastjson.JSONObject;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class DoAjax {
	public static void doAjax(HttpServletResponse response, JSONObject obj, String cb) {
		try {
			response.setHeader("Cache-Control", "no-cache");
			//response.setCharacterEncoding("utf-8");
			response.setContentType("application/json;charset=utf-8");
			PrintWriter out=response.getWriter();
			if (cb != null) {
				StringBuffer sb = new StringBuffer(cb);
			    sb.append("(");
			    sb.append(obj.toString());
			    sb.append(")");
			    out.print(sb.toString());
			    System.out.println(sb.toString());
			}else{
				out.print(obj.toString());
				System.out.println(obj.toString());
			}
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void doAjax(HttpServletResponse response, Object...data){
		response.setHeader("Cache-Control", "no-cache");
		response.setContentType("application/json;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		try {
			PrintWriter out=response.getWriter();
			String jsonString= JSONObject.toJSONString(data);
			out.print(jsonString);
			System.out.println(jsonString);
		} catch (IOException e) {
			e.printStackTrace();
		}
	} 
}