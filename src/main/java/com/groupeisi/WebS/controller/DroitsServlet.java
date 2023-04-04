package com.groupeisi.WebS.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.groupeisi.WebS.dao.IDroits;
import com.groupeisi.WebS.dao.IDroitsImpl;
import com.groupeisi.WebS.entities.Comptes;
import com.groupeisi.WebS.entities.Droits;

/**
 * Servlet implementation class DroitsServlet
 */
@WebServlet("/droits")
public class DroitsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private IDroits idroitsimpl;
	
    public DroitsServlet() {
        super();
    }

	
	public void init(ServletConfig config) throws ServletException {
		
		this.idroitsimpl = new IDroitsImpl();
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Droits d = new Droits();
		List<Droits> droits = idroitsimpl.list(d);
		request.setAttribute("droits",droits);
		request.getRequestDispatcher("WEB-INF/views/droits/droit.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Droits droits = new Droits();
		if(request.getParameter("id") != null) {
			Droits d = new Droits();
			idroitsimpl.delete(Integer.parseInt(request.getParameter("id")),d);
		}else {
			droits.setName(request.getParameter("name"));
			idroitsimpl.add(droits);
		}
		doGet(request, response);
	}

}
