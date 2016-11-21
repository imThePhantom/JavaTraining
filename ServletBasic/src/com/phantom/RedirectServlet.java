package com.phantom;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/redirect")
public class RedirectServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		UserInfo loginedInfo = new UserInfo("Phantom", 37, "VN");
		session.setAttribute(Constants.SESSION_USER_KEY, loginedInfo);
		
		String redirect = request.getParameter("redirect");

		if ("true".equals(redirect)) {
			System.out.println("Redirect to Destination Page");
			String contextPath = request.getContextPath();
			response.sendRedirect(contextPath + "/destiPage");
			return;
		}

		ServletOutputStream out = response.getOutputStream();
		out.println("<h3>Text of ForwardServlet</h3>");
		out.println("- servletPath=" + request.getServletPath());
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
