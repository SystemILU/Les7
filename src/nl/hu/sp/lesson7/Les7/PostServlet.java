package nl.hu.sp.lesson7.Les7;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PostServlet extends HttpServlet
{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		
		ArrayList<User> registeredUsers = new ArrayList<User>();
		
		ServletContext sc = getServletContext();
		
		synchronized(sc)
		{
			registeredUsers = (ArrayList<User>)sc.getAttribute("registeredUsers");
		}
		
		Object o = req.getSession().getAttribute("user");
		User u1 = (User)o;
		
		System.out.println(u1);
		
		String post = req.getParameter("blogpost");
		BlogPost blogPost = new BlogPost(post);
		
		for(User u : registeredUsers)
		{
			if(u.equals(u1))
			{
				u.addBlogPost(blogPost);
			}
		}
		
		sc.setAttribute("registeredUsers", registeredUsers);
		
		RequestDispatcher rd = null;
		
		rd = req.getRequestDispatcher("allposts.jsp");
		
		rd.forward(req, resp);
	}

}
