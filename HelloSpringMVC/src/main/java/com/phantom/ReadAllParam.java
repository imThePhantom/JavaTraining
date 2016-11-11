package com.phantom;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReadAllParam
 */
public class ReadAllParam extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String message;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReadAllParam() {
		super();
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		message = "Hi, my friend!";
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String title = "";
		String head = "<!doctype html>\n" + "<html>\n" + "<head> <title>" + title
				+ "</title> </head>\n";

		out.println(head);
		out.println("<body>");
		out.println("<h1>" + message + "</h1>");

		Enumeration<String> paramNames = request.getParameterNames();
		out.println("<dl>");
		while (paramNames.hasMoreElements()) {
			String paramName = (String) paramNames.nextElement();
			out.println("<dt><b>" + paramName + "</b></dl>");
			String[] paramValues = request.getParameterValues(paramName);
			for (String value : paramValues) {
				if (value.isEmpty()) {
					out.println("<dd><i> No value </i></dd>");
				} else {
					out.println("<dd>" + value + "</dd>");
				}
			}
		}
		out.println("</dl>\n" + "</body>\n</html>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
