package edu.weber.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import com.fasterxml.jackson.databind.ObjectMapper;

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

	private HashMap<String,Contact> map = new HashMap<String,Contact>();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Contact con1 = new Contact("Brady", "Kurtz", "Wouldn't you like to know");
		Contact con2 = new Contact("Jack", "Nancarrow", "696-969-6969");
		con2.setHomeAddress("Mansion in Beverly Hills");
		Contact con3 = new Contact("Derek", "Burrola");
		con3.setBusinessAddress("All of Silicon Valley");
		Contact con4 = new Contact("Jazlyn", "Maxwell", "010-101-0101");
		con4.setHomeAddress("The Moon");
		Contact con5 = new Contact("Steven", "Sommer", "234-243-4367");
		con5.setBusinessAddress("The Death Star");
		Contact con6 = new Contact("Bruce", "Banner", "707-070-7034");
		Contact con7 = new Contact("Eddie", "Murphy", "213-415-4142");
		Contact con8 = new Contact("Peter", "Parker", "123-456-7890");
		con8.setHomeAddress("Aunt May's house");
		con8.setBusinessAddress("The Daily Bugle");
		Contact con9 = new Contact("Hillary", "Duff", "098-765-4321");
		Contact con10 = new Contact("Will", "Smith", "345-677-9876");
		con10.setHomeAddress("Bel-Air");
		con10.setBusinessAddress("Office of the Fresh Prince");
		
		
		map.put(con1.getFirstName(), con1);
		map.put(con2.getFirstName(), con2);
		map.put(con3.getFirstName(), con3);
		map.put(con4.getFirstName(), con4);
		map.put(con5.getFirstName(), con5);
		map.put(con6.getFirstName(), con6);
		map.put(con7.getFirstName(), con7);
		map.put(con8.getFirstName(), con8);
		map.put(con9.getFirstName(), con9);
		map.put(con10.getFirstName(), con10);
		
		PrintWriter writer = resp.getWriter();
		ObjectMapper objectMapper = new ObjectMapper();
//		for(String i : map.keySet())
//			writer.println(objectMapper.writeValueAsString(map.get(i)));
		
		req.setAttribute("contacts", map.keySet());
		req.setAttribute("contactMap", map);
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
		if(map.get(fname) != null) {
			resp.sendRedirect("./");
		}
		
		//add contact to map
		Contact temp = new Contact(fname, lname, phonenum, homeaddr, busiaddr);
		map.put(temp.getFirstName(), temp);
		
		resp.sendRedirect("./");
	}

}
