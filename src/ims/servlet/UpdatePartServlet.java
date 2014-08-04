package ims.servlet;

import ims.dto.PartDto;
import ims.facade.FacadeFactory;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdatePartServlet
 */
@WebServlet("/Part/UpdatePartServlet")
public class UpdatePartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * Gets the part by id and redirect to UpdatePart.jsp
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idString = request.getParameter("id");
		int id = Integer.parseInt(idString);
		PartDto partDto = FacadeFactory.getFacade().findPartByID(id);
		request.setAttribute("partDto", partDto);
		RequestDispatcher rd = request.getRequestDispatcher("Update.jsp");
		rd.forward(request, response);
	}

	/**
	 * Updates the part with new values from UpdatePart.jsp 
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PartDto partDto = new PartDto();
		partDto.setId(Integer.parseInt(request.getParameter("id")));
		partDto.setName(request.getParameter("name"));
		partDto.setPrice(Double.parseDouble(request.getParameter("price")));
		partDto.setQuantity(Integer.parseInt(request.getParameter("quantity")));
		
		FacadeFactory.getFacade().updatePart(partDto);

		response.sendRedirect("/InventoryManagementSystem/Part/PartListServlet");
	}

}
