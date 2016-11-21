package com.phantom.springmvc.customdispatcher;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.DispatcherServlet;

public class CustomDispatcher extends DispatcherServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doDispatch(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String browserDetail = request.getHeader("User-Agent").toLowerCase();
		System.out.println(browserDetail);

		if (browserDetail.contains("trident/7.0; rv:11.0") || browserDetail.contains("msie")
				|| browserDetail.contains("edge")) {
			response.sendError(406, "MS browser is not supported");
			return;
		}
		super.doDispatch(request, response);
	}
}
