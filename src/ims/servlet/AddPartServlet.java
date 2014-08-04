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

@WebServlet("/AddPartServlet")
public class AddPartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddPartServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String partName = request.getParameter("partName");
		String quantityString = request.getParameter("partQuantity");
		String priceString = request.getParameter("partPrice");
		
		int quantity = Integer.parseInt(quantityString);
		double price = Double.parseDouble(priceString);
		
		PartDto partDto = new PartDto();
		partDto.setName(partName);
		partDto.setQuantity(quantity);
		partDto.setPrice(price);
		
		FacadeFactory.getFacade().addPart(partDto);
		
		RequestDispatcher rd = request.getRequestDispatcher("ManagePart.jsp");
		rd.forward(request, response);
	}

}
