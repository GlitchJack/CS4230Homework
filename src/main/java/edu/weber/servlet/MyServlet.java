package edu.weber.servlet;

import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.HashMap;

//import com.fasterxml.jackson.databind.ObjectMapper;

import edu.weber.contact.ContactService;
import edu.weber.model.Contact;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(
	name="MyServlet",
	urlPatterns="/"
)
public class MyServlet extends HttpServlet {

//	private HashMap<String,Contact> map = new HashMap<String,Contact>();
	
	private ContactService service;
	
	public MyServlet() {
		service = ContactService.getInstance();
	}
	
	public MyServlet(ContactService serv) {
		service = serv;
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		ContactService service = ContactService.getInstance();
		
		req.setAttribute("errormessage", req.getParameter("errormessage"));
//		req.setAttribute("contacts", map);
		req.setAttribute("contacts", service.getContacts());		
		req.getRequestDispatcher("/jsp/index.jsp").forward(req, resp);
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//read form inputs
		String fname = req.getParameter("fname");
		String lname = req.getParameter("lname");
		String phonenum = req.getParameter("phonenum");
		String homeaddr = req.getParameter("homeaddr");
		String busiaddr = req.getParameter("busiaddr");
		
		//No duplicate keys(firstnames) for now
//		if(map.get(fname) != null) {
//			req.getRequestDispatcher("/").forward(req, resp);
//			resp.sendRedirect("./");
//			return;
//		}
		
		if(req.getParameter("homeaddr").equals("") && req.getParameter("busiaddr").equals("")) {
			resp.sendRedirect("./?errormessage=Must Have an address");
			return;
		}
		
		//add contact to map
		Contact temp = new Contact(fname, lname, phonenum, homeaddr, busiaddr);
		service.addContact(temp);
		
		//resp.sendRedirect("./");
		resp.sendRedirect("./");
	}

}
