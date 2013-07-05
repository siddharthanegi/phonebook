package net.example.web;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import net.example.model.phonedb;

@SuppressWarnings("serial")
public class phonebook extends HttpServlet {
	private phonedb db;
	Connection con;
	
	public void init(ServletConfig config) throws ServletException 
	{
	super.init(config);

	try{
		db= new phonedb();
		   
		  //1. get the connection to the database
		con = db.getConnection();
		   
	}
	catch(Exception E)
	{
	}

	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		
//		response.setContentType("text/html");
//		PrintWriter out=response.getWriter();
//		String name=request.getParameter("name");
//		out.print("<br>Name: "+name);
		List<String> params=new ArrayList<String>();
		params.add(request.getParameter("name"));
		params.add(request.getParameter("address"));
		params.add(request.getParameter("pnumber"));
		
		System.out.print(params.get(0));
		db.executeInsertQuery(con,params);
	RequestDispatcher view = request.getRequestDispatcher("query.html");
	view.forward(request,response);
			}

}
