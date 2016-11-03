package com.cqut.tool.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

public class SessionFilter  extends OncePerRequestFilter {
	
	@Override
	protected void doFilterInternal(HttpServletRequest request,
			HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String uri = request.getRequestURI();  
		System.out.println("请求 。。。 " + uri);
		
		if(!uri.endsWith("login.jsp")) {
			Object operatorCode = request.getSession().getAttribute("OPERATORCODE");  
			System.out.println(operatorCode);
			if(operatorCode == null) {
				// 如果session中不存在登录者实体，则弹出框提示重新登录  
                // 设置request和response的字符集，防止乱码  
				
				String path = request.getContextPath();
				String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
				
				//System.out.println(basePath);
				
                request.setCharacterEncoding("gb2312");  
                response.setCharacterEncoding("gb2312");  
                PrintWriter out = response.getWriter();  
                String loginPage = "login.jsp";  
                StringBuilder builder = new StringBuilder();  
                builder.append("<script type=\"text/javascript\">");  
                builder.append("alert('网页过期，请重新登录！');");  
                builder.append("window.top.location.href='");  
                builder.append(basePath  + loginPage);  
                builder.append("';");  
                builder.append("</script>");  
                out.print(builder.toString());  
			}
		}
		filterChain.doFilter(request, response);  
	} 
}
