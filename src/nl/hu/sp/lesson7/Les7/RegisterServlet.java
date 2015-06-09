package nl.hu.sp.lesson7.Les7;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Properties;
import java.util.logging.Logger;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;

public class RegisterServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		String username = req.getParameter("username");
		String realname = req.getParameter("realname");
		String password = req.getParameter("password");
		String retypedPassword = req.getParameter("passwordretyped");
		String emailaddress = req.getParameter("emailaddress");
		String retypedEmailaddress = req.getParameter("emailaddressretyped");
		String address = req.getParameter("address");
		String country = req.getParameter("country");
		ArrayList<User> registeredUsers = new ArrayList<User>();
		
		ServletContext sc = getServletContext();
		
		synchronized(sc)
		{
			registeredUsers = (ArrayList<User>)sc.getAttribute("registeredUsers");
		}
		
		
		BlogService bS = new BlogService(registeredUsers);
		
		RequestDispatcher rd = null;
		
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", 465);
		props.put("mail.smtp.ssl.enable", true);
		Session mailSession = Session.getInstance(props);
		
		if(bS.registerSuccess(username, realname, password, retypedPassword, emailaddress, retypedEmailaddress, address, country))
		{
			User u1 = new User(username, realname, password, emailaddress, address, country);
			bS.addUser(u1);
			
			try 
			{
			MimeMessage msg = new MimeMessage(mailSession);
			msg.setFrom(new InternetAddress("kirsten.spies@gmail.com", "Kirsten Spies"));
			msg.setRecipients(Message.RecipientType.TO, emailaddress);
			msg.setSubject("Your registration has been completed!");
			msg.setSentDate(Calendar.getInstance().getTime());
			msg.setText("Hello " + realname + "! \n\n Thank you for registering with us, your login details are as follows: \n\n"
					+ username + "\n" + password + "\n\n We hope you have a great time on our website ;)! \n\n Kind regards, \n Kirsten");
			Transport.send(msg, "kirsten.spies@gmail.com", "koekiemonsters12");

			}

			catch (Exception e) 
			{
			Logger.getLogger("sp.lesson7").warning("send failed: " +e.getMessage());
			}

			synchronized(sc)
			{
			sc.setAttribute("registeredUsers", bS.getAllUsers());
			}
			
			rd = req.getRequestDispatcher("login.jsp");
		}
		
		else
		{
			req.setAttribute("msgs", bS.getErrorMessage());
			rd = req.getRequestDispatcher("register.jsp");
		}
		
		rd.forward(req, resp);
		
		
	}

}

