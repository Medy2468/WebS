package com.groupeisi.WebS.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.groupeisi.WebS.dao.IComptes;
import com.groupeisi.WebS.dao.IComptesImpl;
import com.groupeisi.WebS.entities.Comptes;

/**
 * Servlet implementation class ComptesServlet
 */
@WebServlet("/comptes")
public class ComptesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private IComptes icomptesimpl;
	
    public ComptesServlet() {
        super();
    }

	
	public void init(ServletConfig config) throws ServletException {
		
		this.icomptesimpl = new IComptesImpl();
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Comptes c = new Comptes();
		List<Comptes> comptes = icomptesimpl.list(c);
		request.setAttribute("comptes",comptes);
		request.getRequestDispatcher("WEB-INF/views/comptes/compte.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Comptes comptes = new Comptes();
		if(request.getParameter("id") != null) {
			Comptes c = new Comptes();
			icomptesimpl.delete(Integer.parseInt(request.getParameter("id")),c);
		}else {
			comptes.setUsername(request.getParameter("username"));
			comptes.setPassword(request.getParameter("password"));
			icomptesimpl.add(comptes);
		}
		doGet(request, response);
		
	}

}
