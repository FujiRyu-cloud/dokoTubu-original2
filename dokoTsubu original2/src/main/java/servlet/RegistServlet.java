package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Account;
import model.RegistLogic;


@WebServlet("/RegistServlet")
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(
				"WEB-INF/jsp/regist.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String userId = request.getParameter("userId");
		String pass = request.getParameter("pass");
		String mail = request.getParameter("mail");
		String name = request.getParameter("name");
		int age  = Integer.parseInt(request.getParameter("age"));
		
		Account account = new Account(userId,pass,mail,name,age);
		RegistLogic registLogic = new RegistLogic();
		boolean registResult = registLogic.execute(account);
		
		if(registResult) {
			HttpSession session = request.getSession();
			session.setAttribute("account", account);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(
					"WEB-INF/jsp/RegistOK.jsp");
			dispatcher.forward(request, response);
		}else {
			response.sendRedirect("RegistServlet");
		}
		
	}

}
