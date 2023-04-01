package test15A;

import java.util.*;
import java.math.*;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Test15A
 */
@WebServlet("/Test15A")
public class Test15A extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test15A() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		// Set the response message's MIME type
		response.setContentType("text/html;charset=UTF-8");
		// Allocate a output writer to write the response message into the network
		// socket
		PrintWriter out = response.getWriter();

		// Use ResourceBundle to keep localized string in "LocalStrings_xx.properties"
		// ResourceBundle rb = ResourceBundle.getBundle("LocalStrings",
		// request.getLocale());

		// Write the response message, in an HTML page
		out.println("<!DOCTYPE html"); // HTML 5
		out.println("<html><head>");
		out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
		String title = "Generator Server";
		out.println("<head><title>" + title + "</title></head>");
		out.println("<body>");
		out.println("<h3>" + title + "</h3>");
		
		Random rand = new Random(System.currentTimeMillis());
		
		out.println("<table>");
		out.println("<tr>");
		out.println("<td width=10>"+ "_ID_" + "</td>");
		out.println("<td col=45>"+ "_Name_" + "</td>");
		out.println("<td width=30>"+ "_Price_" + "</td>");
		out.println("<td width=15>"+ "_Quantity_" + "</td>");
		out.println("</tr>");

		
		for(int i=0; i<10; i++) {
			
			Good good = new Good();
			String id = "ID-" + i;
			String name = "good-" + rand.nextInt(1000);
					
			double value = rand.nextDouble();
			System.out.println("value:" + value);
			value *= 1000;
			System.out.println("value*1000:" + value);
			BigDecimal price = new BigDecimal(value, new MathContext(5));
			System.out.println("price:" + price.toString());
			int quantity = rand.nextInt(30);

			out.println("<tr>");
			out.println("<td>"+ id + "</td>");
			out.println("<td>"+ name + "</td>");
			out.println("<td>"+ price + "</td>");
			out.println("<td>"+ quantity + "</td>");
			out.println("</tr>");
			
		}
		out.println("</table>");

		out.println("</body></html>");
		out.close(); // Always close the output writer

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
