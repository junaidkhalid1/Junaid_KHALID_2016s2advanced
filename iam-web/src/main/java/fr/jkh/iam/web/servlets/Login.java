package fr.jkh.iam.web.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.jkh.iam.log.IAMLogger;
import fr.jkh.iam.log.impl.IAMLogManager;
import fr.jkh.iamcore.service.authentication.AuthenticationService;

/**
 * Servlet implementation class Login
 */

//Test Commit again

@WebServlet(name="Login", urlPatterns="/Login")
public class Login extends GenericSpringServlet {
	private static final long serialVersionUID = 1L;
	
	IAMLogger logger = IAMLogManager.getIAMLogger(Login.class);

    /**
     * Default constructor. 
     */
    public Login() {
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		logger.debug(login);
		logger.debug(password);
		
		AuthenticationService auth = new AuthenticationService();
		if (auth.authenticate(login, password)){
			response.sendRedirect("welcome.jsp");
		}else{
			response.sendRedirect("reconnect.jsp");
		}
		
		
		
	}

}