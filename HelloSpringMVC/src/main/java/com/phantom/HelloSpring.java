/**
 * 
 */
package com.phantom;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.http.*;

/**
 * @author Phan Toan
 *
 */
public class HelloSpring extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String message;

	public void init() throws ServletException {
		message = "Hello My Friend";
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!doctype html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Hello my friend</title>");
		out.println("</head>");
		out.println("<body>");
		if (request.getParameter("name").length() == 0) {
			out.println("<h1>" + message + "</h1>");
		} else {
			out.println("<h1> Hi, "
					+ (request.getParameter("isMarried").equals("mrs") ? "Mrs " : "Ms ")
					+ request.getParameter("name") + "!");
		}
		out.println("<h2><pre>     from ThePhantom</pre></h2>");
		out.println("</body>");
		out.println("</html>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	public void destroy() {

	}
}