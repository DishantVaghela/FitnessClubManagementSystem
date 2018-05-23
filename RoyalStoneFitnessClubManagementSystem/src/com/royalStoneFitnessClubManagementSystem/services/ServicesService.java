package com.royalStoneFitnessClubManagementSystem.services;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.royalStoneFitnessClubManagementSystem.dao.ServicesDao;

/**
 * Servlet implementation class ServicesService
 */
@WebServlet("/ServicesService")
public class ServicesService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServicesService() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		HttpSession session=request.getSession();  
		
		RequestDispatcher rd = null;
		
		if(request.getParameter("buttonLogout") != null)
		{
			session.invalidate();
			
			rd=request.getRequestDispatcher("index.jsp");  
		}
		if(request.getParameter("buttonPackages") != null)
		{
			rd=request.getRequestDispatcher("managePackages.jsp");  
	 	}
		if(request.getParameter("buttonInformation") != null)
		{
			rd=request.getRequestDispatcher("updateInformation.jsp");  
	 	}
		if(request.getParameter("buttonManagers") != null)
		{
			String managerId=(String)session.getAttribute("session_id");
			if (ServicesDao.validate(managerId)) {
				rd=request.getRequestDispatcher("manageManagers.jsp");  
		  	}
			else{
				out.println("<script type=\"text/javascript\">");
		    	out.println("alert('you are not authorized for the service');");
		    	out.println("location='services.jsp';");
		    	out.println("</script>");
			}
		}
		if(request.getParameter("buttonMembers") != null)
		{
			rd=request.getRequestDispatcher("manageMembers.jsp");  
	 	}
		rd.forward(request,response);
		
		out.close();
	}

}
