package nl.hu.sp.lesson7.Les7;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{	
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		User u1 = new User(username, "", password, "", "", "");
		ArrayList<User> registeredUsers = new ArrayList<User>();
		
		ServletContext sc = getServletContext();
		
		synchronized(sc)
		{
		registeredUsers = (ArrayList<User>)sc.getAttribute("registeredUsers");
		}
		
		BlogService bS = new BlogService(registeredUsers);
		
		RequestDispatcher rd = null;
		
		if(bS.loginSuccess(u1))
		{
			
			req.getSession().removeAttribute("user");
			req.getSession().setAttribute("user", u1);
			
			Cookie cookie = new Cookie("username", username);
			cookie.setMaxAge(30*60);
			resp.addCookie(cookie);
			
			Logger logger = Logger.getLogger("nl.hu.sp.lesson7.Les7");
			
			FileHandler fh = (FileHandler)sc.getAttribute("filehandler");
			fh.setFormatter(new BlogLogFormatter());
			logger.addHandler(fh);
			
			
			
			logger.info("User <"+username+"> logged in!");
			
			rd = req.getRequestDispatcher("welcome.jsp");
		}
		
		else
		{
			Logger logger = Logger.getLogger("nl.hu.sp.lesson7.Les7");
			
			FileHandler fh = (FileHandler)sc.getAttribute("filehandler");
			fh.setFormatter(new BlogLogFormatter());
			logger.addHandler(fh);
			
			req.setAttribute("msgs", bS.getErrorMessage());
			
			logger.warning("Login failed for <"+username+">!");
			rd = req.getRequestDispatcher("login.jsp");
		}
		
		rd.forward(req, resp);
		
	}
	
}
