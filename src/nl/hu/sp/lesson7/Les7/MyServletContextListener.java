package nl.hu.sp.lesson7.Les7;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyServletContextListener implements ServletContextListener
{
	public void contextInitialized(ServletContextEvent sce)
	{
		Logger logger = Logger.getLogger("nl.hu.sp.lesson7.Les7");
		
		ServletContext sc = sce.getServletContext();
		
		try
		{
		FileHandler fh = new FileHandler("/Users/Kirsten/Documents/workspace/Les7/src/nl/hu/sp/lesson7/Les7/bloglog.xml");
		fh.setFormatter(new BlogLogFormatter());
		logger.addHandler(fh);
		sc.getAttribute("filehandler");
		sc.setAttribute("filehandler", fh);
		}
		
		catch (IOException ioe)
		{
			ioe.printStackTrace();
		}
		
		logger.setLevel(Level.ALL);
		logger.info("Logger initialized");
		
		ArrayList<User> registeredUsers = new ArrayList<User>();
		
		try
        {
            FileInputStream fis = new FileInputStream("/Users/Kirsten/Documents/workspace/Les7/src/nl/hu/sp/lesson7/Les7/registeredUsers.obj");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object obj = ois.readObject();
            registeredUsers = (ArrayList<User>)obj;
            ois.close();
        }

        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }

        catch (ClassNotFoundException cnfe)
        {
            cnfe.printStackTrace();
        }
		
		
		sc.getAttribute("registeredUsers");
		
		sc.setAttribute("registeredUsers", registeredUsers);
	}
	
	public void contextDestroyed(ServletContextEvent sce)
	{
		ArrayList<User> registeredUsers = new ArrayList<User>();
		
		Object o = sce.getServletContext().getAttribute("registeredUsers");
		registeredUsers = (ArrayList<User>)o;
		
		try{
			FileOutputStream fos = new FileOutputStream("/Users/Kirsten/Documents/workspace/Les7/src/nl/hu/sp/lesson7/Les7/registeredUsers.obj");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(registeredUsers);
			oos.close();
		}
		
		catch(IOException ioe){
			ioe.printStackTrace();
		}
		
	}
}
