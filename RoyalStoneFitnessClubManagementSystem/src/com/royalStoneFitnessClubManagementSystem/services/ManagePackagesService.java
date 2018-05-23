package com.royalStoneFitnessClubManagementSystem.services;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.royalStoneFitnessClubManagementSystem.dao.ManagePackagesDao;

/**
 * Servlet implementation class ManagePackagesService
 */
@WebServlet("/ManagePackagesService")
public class ManagePackagesService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagePackagesService() {
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
		
		String id=request.getParameter("textFieldId");
		String name=request.getParameter("textFieldName");
		String price=request.getParameter("textFieldPrice");
		
		if (request.getParameter("buttonAdd") != null) {
			if(ManagePackagesDao.add(name, price)){  
				out.println("<script type=\"text/javascript\">");
				out.println("alert('package added');");
				out.println("location='managePackages.jsp';");
				out.println("</script>");
			}  
		    else{  
		    	out.println("<script type=\"text/javascript\">");
		    	out.println("alert('failed to add package');");
		    	out.println("location='managePackages.jsp';");
			    out.println("</script>");
		    }
		}
		else if (request.getParameter("buttonRemove") != null) {
			if(id != "") {
				if(ManagePackagesDao.remove(id)){  
					out.println("<script type=\"text/javascript\">");
					out.println("alert('package removed');");
					out.println("location='managePackages.jsp';");
					out.println("</script>");
				}  
			    else{  
			    	out.println("<script type=\"text/javascript\">");
			    	out.println("alert('failed to remove package');");
			    	out.println("location='managePackages.jsp';");
				    out.println("</script>");
			    }
			}
			else {
				out.println("<script type=\"text/javascript\">");
		    	out.println("alert('enter id');");
		    	out.println("location='managePackages.jsp';");
			    out.println("</script>");
			}
		}else {
			if(id != "") {
				if(ManagePackagesDao.update(id, name, price)){  
					out.println("<script type=\"text/javascript\">");
					out.println("alert('package updated');");
					out.println("location='managePackages.jsp';");
					out.println("</script>");
				}  
			    else{  
			    	out.println("<script type=\"text/javascript\">");
			    	out.println("alert('failed to update package');");
			    	out.println("location='managePackages.jsp';");
				    out.println("</script>");
			    }
			}
			else {
				out.println("<script type=\"text/javascript\">");
		    	out.println("alert('enter id');");
		    	out.println("location='managePackages.jsp';");
			    out.println("</script>");
			}
		}
		
		out.close();
	}

}
