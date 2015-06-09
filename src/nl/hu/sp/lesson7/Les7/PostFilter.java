package nl.hu.sp.lesson7.Les7;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class PostFilter implements Filter
{
	public void init(FilterConfig arg0) throws ServletException
	{
		
	}
	
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException
	{
		HttpServletRequest r2 = (HttpServletRequest)req;
		
		if(r2.getSession().getAttribute("user") == null)
		{
			r2.getRequestDispatcher("/login.jsp").forward(req, resp);
		}
		
		else
		{
			chain.doFilter(req, resp);
		}
	}
	
	public void destroy()
	{
		
	}
}
