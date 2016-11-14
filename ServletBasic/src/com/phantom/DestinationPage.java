package com.phantom;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/destiPage")
public class DestinationPage extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String value = (String) request.getAttribute(Constants.ATTRIBUTE_USER_NAME_KEY);
		
		HttpSession session = request.getSession();
		UserInfo loginedInfo = (UserInfo) session.getAttribute(Constants.SESSION_USER_KEY);
		
		ServletOutputStream out = response.getOutputStream();
		out.println("<h1> Destination Page </h1>");
		out.println(value);
		
		if (loginedInfo != null) {
			RequestDispatcher dispatcher = request.getServletContext()
					.getRequestDispatcher("/userdetail");
			dispatcher.forward(request, response);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}
}
