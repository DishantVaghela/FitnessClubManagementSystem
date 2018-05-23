package com.royalStoneFitnessClubManagementSystem.services;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.royalStoneFitnessClubManagementSystem.dao.ManageManagersDao;

/**
 * Servlet implementation class ManageManagersService
 */
@WebServlet("/ManageManagersService")
public class ManageManagersService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageManagersService() {
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
		
		String managerId=request.getParameter("textFieldManagerId");
		String password=request.getParameter("textFieldPassword");
		String recoveryQuestion=request.getParameter("textFieldRecoveryQuestion");
		String recoveryAnswer=request.getParameter("textFieldRecoveryAnswer");
		
		if (request.getParameter("buttonAdd") != null) {
			if(ManageManagersDao.addManager(managerId, password, recoveryQuestion, recoveryAnswer)){  
				out.println("<script type=\"text/javascript\">");
				out.println("alert('manager added');");
				out.println("location='manageManagers.jsp';");
				out.println("</script>");
			}  
		    else{  
		    	out.println("<script type=\"text/javascript\">");
		    	out.println("alert('failed to add manager');");
		    	out.println("location='manageManagers.jsp';");
			    out.println("</script>");
		    }
		}
		else if (request.getParameter("buttonRemove") != null) {
			if(managerId != "") {
				if(ManageManagersDao.removeManager(managerId)){  
					out.println("<script type=\"text/javascript\">");
					out.println("alert('manager removed');");
					out.println("location='manageManagers.jsp';");
					out.println("</script>");
				}  
			    else{  
			    	out.println("<script type=\"text/javascript\">");
			    	out.println("alert('failed to remove manager');");
			    	out.println("location='manageManagers.jsp';");
				    out.println("</script>");
			    }
			}
			else {
				out.println("<script type=\"text/javascript\">");
		    	out.println("alert('enter manager id');");
		    	out.println("location='manageManagers.jsp';");
			    out.println("</script>");
			}
		}else {
			if(managerId != "") {
				if(ManageManagersDao.updateManager(managerId, password, recoveryQuestion, recoveryAnswer)){  
					out.println("<script type=\"text/javascript\">");
					out.println("alert('manager updated');");
					out.println("location='manageManagers.jsp';");
					out.println("</script>");
				}  
			    else{  
			    	out.println("<script type=\"text/javascript\">");
			    	out.println("alert('failed to update manager');");
			    	out.println("location='manageManagers.jsp';");
				    out.println("</script>");
			    }
			}
			else {
				out.println("<script type=\"text/javascript\">");
		    	out.println("alert('enter manager id');");
		    	out.println("location='manageManagers.jsp';");
			    out.println("</script>");
			}
		}
		
		out.close();
	}

}
