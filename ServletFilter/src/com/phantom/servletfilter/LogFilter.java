package com.phantom.servletfilter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class LogFilter implements Filter {
	private String logFile;
	
	public LogFilter() {
	
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.logFile = filterConfig.getInitParameter("logFile");
		System.out.println("LogFilter init");
		System.out.println("Log File: " + logFile);
	}

	@Override
	public void destroy() {
		System.out.println("LogFilter destroy");

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		String servletPath = req.getServletPath();
		
		try {
			PrintWriter writer = new PrintWriter(logFile, "UTF-8");
			writer.println("#INFO " + new Date() + " - Servlet Path: " + servletPath + ", URL: "
					+ req.getRequestURL());
			System.out.println("#INFO " + new Date() + " - Servlet Path: " + servletPath + ", URL: "
					+ req.getRequestURL());
			writer.close();
		} catch (Exception e) {
		}
		
		chain.doFilter(request, response);
	}

}
