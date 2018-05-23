package com.royalStoneFitnessClubManagementSystem.services;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.royalStoneFitnessClubManagementSystem.dao.UpdateInformationDao;

/**
 * Servlet implementation class UpdateInformationService
 */
@WebServlet("/UpdateInformationService")
public class UpdateInformationService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateInformationService() {
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
		
		String mobileNumber=request.getParameter("textAreaMobileNumber");
		String emailId=request.getParameter("textAreaEmailId");
		String clubAddress=request.getParameter("textAreaClubAddress");
		String mondayTiming=request.getParameter("textAreaMondayTiming");
		String tuesdayTiming=request.getParameter("textAreatuesdayTiming");
		String wednesdayTiming=request.getParameter("textAreaWednesdayTiming");
		String thursdayTiming=request.getParameter("textAreaThursdayTiming");
		String fridayTiming=request.getParameter("textAreaFridayTiming");
		String saturdayTiming=request.getParameter("textAreaSaturdayTiming");
		String sundayTiming=request.getParameter("textAreaSundayTiming");
		String services=request.getParameter("textAreaServices");
		String lastChangesBy=(String)session.getAttribute("session_id");
		if(UpdateInformationDao.update(mobileNumber, emailId, clubAddress, mondayTiming, tuesdayTiming, wednesdayTiming, thursdayTiming, fridayTiming, saturdayTiming, sundayTiming, services, lastChangesBy)){  
			out.println("<script type=\"text/javascript\">");
			out.println("alert('information updated');");
			out.println("location='updateInformation.jsp';");
			out.println("</script>");
		}  
	    else{  
	    	out.println("<script type=\"text/javascript\">");
	    	out.println("alert('failed to update information');");
	    	out.println("location='updateInformation.jsp';");
		    out.println("</script>");
	    }
		out.close();  
	}
}
