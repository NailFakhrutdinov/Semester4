package ru.kpfu.itis;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloUser
 */
public class HelloUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String userName = request.getParameter("userName");
		if(userName.equals("")) {
			response.sendRedirect("form.html");
		}
		PrintWriter out = response.getWriter();
		out.write("<html><body>");
		out.write("Hello, " + userName);
		out.write("<form action=\"form.html\">");
		out.write("<button type=\"submit\"> Back </button>");
		out.write("</form>");
		out.write("</html></body>");
		out.close();
	}

}
