package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Inputs;

/**
 *  implementation class CalculatorServlet
 */
@WebServlet({ "/CalculatorServlet", "/calculate" })
public class CalculatorServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // Get input data from request object
	    String slabWidthParam = request.getParameter("slabWidth");
	    String slabHeightParam = request.getParameter("slabHeight");
	    String slabThicknessParam = request.getParameter("slabThickness");
	    String bagSizeParam = request.getParameter("bagSize");

	    // Check for null values and perform any necessary formatting
	    if (slabWidthParam != null && slabHeightParam != null &&
	        slabThicknessParam != null && bagSizeParam != null) {
	        double slabWidth = Double.parseDouble(slabWidthParam);
	        double slabHeight = Double.parseDouble(slabHeightParam);
	        double slabThickness = Double.parseDouble(slabThicknessParam);
	        int bagSize = Integer.parseInt(bagSizeParam);

	        // Create calculation input object
	        Inputs inputs = new Inputs(slabWidth, slabHeight, slabThickness, bagSize);
	        // Using input object, create HTML table as a string
	        String outputHTML = inputs.getOutputHTML();

	        // Store output values somewhere that the view can get at - request object
	        request.setAttribute("outputHTML", outputHTML);
	        request.setAttribute("inputs", inputs);
	    } else {
	        // Handle the case where one or more parameters are missing or null
	        // You can add error handling or redirection to an error page here.
	    }

	    // Pass control to the JSP view component
	    String url = "/result.jsp";
	    RequestDispatcher dispatcher = request.getRequestDispatcher(url);
	    dispatcher.forward(request, response);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	**/
}
