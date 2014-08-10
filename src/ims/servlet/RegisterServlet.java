package ims.servlet;

import ims.domain.UserDto;
import ims.facade.FacadeFactory;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		UserDto userDto = new UserDto();
		userDto.setEmail(email);
		userDto.setPassword(password);
		FacadeFactory.getFacade().addUser(userDto);
		
		RequestDispatcher rd = request.getRequestDispatcher("User/Login.jsp");
		rd.forward(request, response);
	}

}
