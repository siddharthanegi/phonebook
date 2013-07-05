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
public class phonequery extends HttpServlet {
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
			

			List<String> params=new ArrayList<String>();
			List<String> results=new ArrayList<String>();
			params.add(request.getParameter("name"));
						
			//System.out.print(params.get(0));
			results=db.executeSelectQuery(con,params);
			request.setAttribute("result",results);
		RequestDispatcher view = request.getRequestDispatcher("results.jsp");
		view.forward(request,response);
				}

	}



