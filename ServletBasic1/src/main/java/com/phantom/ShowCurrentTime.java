package com.phantom;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowCurrentTime extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setIntHeader("Refresh", 1);
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		Calendar calendar = new GregorianCalendar();
		String am_pm = calendar.get(Calendar.AM_PM) == 0 ? "AM" : "PM";
		int hour = calendar.get(Calendar.HOUR);
		int minute = calendar.get(Calendar.MINUTE);
		int second = calendar.get(Calendar.SECOND);
		String currentTime = hour + ":" + minute + ":" + second + " " + am_pm;
		
		PrintWriter out = response.getWriter();
		out.write("<h1>Current Time is:  " + currentTime +"</h1>");
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
