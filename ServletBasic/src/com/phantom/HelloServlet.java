package com.phantom;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/helloservlet/vi"}, initParams = {
		@WebInitParam(name = "welcomeMessage", value = "Xin chao!"),
		@WebInitParam(name = "sign", value = "from thePhantom") })

public class HelloServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String welcomeMessage;

	public HelloServlet() {

	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		this.welcomeMessage = config.getInitParameter("welcomeMessage");
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();

		String sign = this.getServletConfig().getInitParameter("sign");
		out.println("<html>");
		out.println("<head><title>Hello Servlet</title></head>");
		out.println("<body>");
		out.println("<h3>" + welcomeMessage + "</h3>");
		out.println("This is my first Servlet");
		out.println("<pre>" + sign + "</pre>");

		out.println("<style> span {color:blue;} </style>");

		String requestURL = request.getRequestURL().toString();
		out.println("<br><span>requestURL: " + requestURL + "</span>");

		String requestURI = request.getRequestURI();
		out.println("<br><span>requestURI: " + requestURI + "</span>");

		String contextPath = request.getContextPath();
		out.println("<br><span>contextPath: " + contextPath + "</span>");

		String servletPath = request.getServletPath();
		out.println("<br><span>servletPath: " + servletPath + "</span>");

		String queryString = request.getQueryString();
		out.println("<br><span>queryString: " + queryString + "</span>");

		String param1 = request.getParameter("text1");
		out.println("<br><span>getParameter text1: " + param1 + "</span>");

		String param2 = request.getParameter("text2");
		out.println("<br><span>getParameter text2: " + param2 + "</span>");

		// Server Infos
		out.println("<br><br><b>Server info:</b>");

		String serverName = request.getServerName();
		out.println("<br><span>serverName: " + serverName + "</span>");

		int serverPort = request.getServerPort();
		out.println("<br><span>serverPort: " + serverPort + "</span>");

		// Client Infos
		out.println("<br><br><b>Client info:</b>");

		String remoteAddr = request.getRemoteAddr();
		out.println("<br><span>remoteAddr: " + remoteAddr + "</span>");

		String remoteHost = request.getRemoteHost();
		out.println("<br><span>remoteHost: " + remoteHost + "</span>");

		int remotePort = request.getRemotePort();
		out.println("<br><span>remoteHost: " + remotePort + "</span>");

		String remoteUser = request.getRemoteUser();
		out.println("<br><span>remoteUser: " + remoteUser + "</span>");

		// Header Infos
		out.println("<br><br><b>headers:</b>");

		Enumeration<String> headers = request.getHeaderNames();
		while (headers.hasMoreElements()) {
			String header = headers.nextElement();
			out.println("<br><span>" + header + "</span>: " + request.getHeader(header));
		}

		// Servlet Context info:
		out.println("<br><br><b>Servlet Context info:</b>");
		ServletContext servletContext = request.getServletContext();

		// Location of web application in hard disk
		out.println("<br><span>realPath:</span>");
		String realPath = servletContext.getRealPath("");
		out.println(realPath);

		out.println("</body>");
		out.println("<html>");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}
}
