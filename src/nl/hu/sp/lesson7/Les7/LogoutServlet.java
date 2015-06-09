package nl.hu.sp.lesson7.Les7;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutServlet extends HttpServlet 
{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		
		Object o = req.getSession().getAttribute("user");
		User u = (User)o;
		String userName = u.getUsername();
		
		Logger logger = Logger.getLogger("nl.hu.sp.lesson7.Les7");
		
		ServletContext sc = req.getServletContext();
		
		FileHandler fh = (FileHandler)sc.getAttribute("filehandler");
		fh.setFormatter(new BlogLogFormatter());
		logger.addHandler(fh);
		
		logger.info("User <"+userName+"> logged out!");
		
		req.getSession().removeAttribute("user");
		
		HttpSession session = req.getSession(false);
		if(session!=null)
		{
			session.invalidate();
		}
		
	}
}
