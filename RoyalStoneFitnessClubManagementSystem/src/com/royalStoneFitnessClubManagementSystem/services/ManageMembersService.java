package com.royalStoneFitnessClubManagementSystem.services;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.royalStoneFitnessClubManagementSystem.dao.ManageMembersDao;

/**
 * Servlet implementation class ManageMembersService
 */
@WebServlet("/ManageMembersService")
public class ManageMembersService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageMembersService() {
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
		
		String memberId=request.getParameter("textFieldMemberId");
		String name=request.getParameter("textFieldName");
		String aadharId=request.getParameter("textFieldAadharId");
		String contactNumber=request.getParameter("textFieldContactNumber");
		String eMailAddress=request.getParameter("textFieldEMailAddress");
		String homeAddress=request.getParameter("textFieldHomeAddress");
		String packageId=request.getParameter("textFieldPackageId");
		String months=request.getParameter("textFieldMonths");
		
		if (request.getParameter("buttonAdd") != null) {
			if(ManageMembersDao.addMember(name, aadharId, contactNumber, eMailAddress, homeAddress, packageId, months)){  
				out.println("<script type=\"text/javascript\">");
				out.println("alert('member added');");
				out.println("location='membershipBill.jsp';");
				out.println("</script>");
			}  
		    else{  
		    	out.println("<script type=\"text/javascript\">");
		    	out.println("alert('failed to add member');");
		    	out.println("location='manageMembers.jsp';");
			    out.println("</script>");
		    }
		}
		else if (request.getParameter("buttonRemove") != null) {
			if(memberId != "") {
				if(ManageMembersDao.removeMember(memberId)){  
					out.println("<script type=\"text/javascript\">");
					out.println("alert('member removed');");
					out.println("location='manageMembers.jsp';");
					out.println("</script>");
				}  
			    else{  
			    	out.println("<script type=\"text/javascript\">");
			    	out.println("alert('failed to remove member');");
			    	out.println("location='manageMembers.jsp';");
				    out.println("</script>");
			    }
			}
			else {
				out.println("<script type=\"text/javascript\">");
		    	out.println("alert('enter member id');");
		    	out.println("location='manageMembers.jsp';");
			    out.println("</script>");
			}
		}else {
			if(memberId != "") {
				if(ManageMembersDao.updateMember(memberId, name, aadharId, contactNumber, eMailAddress, homeAddress, packageId, months)){  
					out.println("<script type=\"text/javascript\">");
					out.println("alert('member updated');");
					out.println("location='manageMembers.jsp';");
					out.println("</script>");
				}  
			    else{  
			    	out.println("<script type=\"text/javascript\">");
			    	out.println("alert('failed to update member');");
			    	out.println("location='manageMembers.jsp';");
				    out.println("</script>");
			    }
			}
			else {
				out.println("<script type=\"text/javascript\">");
		    	out.println("alert('enter member id');");
		    	out.println("location='manageMembers.jsp';");
			    out.println("</script>");
			}
		}
		
		out.close();
	}

}
