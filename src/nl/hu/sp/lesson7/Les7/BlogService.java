package nl.hu.sp.lesson7.Les7;

import java.util.ArrayList;

import javax.servlet.ServletContext;

public class BlogService 
{
	private String errorMessage = "";
	private ArrayList<User> users = new ArrayList<User>();
	
	public BlogService(ArrayList<User> users)
	{
		this.users = users;
	}
	
	public boolean registerSuccess(String username, String realname, String password, String retypedPassword, String emailaddress, String retypedEmailaddress, String address, String country)
	{
		boolean registerSuccess = false;
		
		if(username != "" && realname != "" && password != "" && retypedPassword != "" && emailaddress != "" && retypedEmailaddress != "" && address != "" && country != "" && retypedPassword.equals(password) && retypedEmailaddress.equals(emailaddress))
		{
			registerSuccess = true;
		}
		
		else
		{
			if(password.equals(""))
			{
				errorMessage += "\nNo password was given";
				registerSuccess = false;
			}
			
			if(retypedPassword.equals(""))
			{
				errorMessage += "\nPassword needs to be retyped";
				registerSuccess = false;
			}
			
			if(emailaddress.equals(""))
			{
				errorMessage += "\nNo email address was given";
				registerSuccess = false;
			}
			
			if(retypedEmailaddress.equals(""))
			{
				errorMessage += "\nEmail address needs to be retyped";
				registerSuccess = false;
			}
			
			if(username.equals(""))
			{
				errorMessage += "\nNo username was given";
				registerSuccess = false;
			}
			
			if(realname.equals(""))
			{
				errorMessage += "\nNo real name was given";
				registerSuccess = false;
			}
			
			
			
			if(address.equals(""))
			{
				errorMessage += "\nNo address was given";
			}
			
			if(country.equals(""))
			{
				errorMessage += "\nNo country was given";
			}
				
			
			if(!retypedPassword.equals(password))
			{
				errorMessage += "\nThe second password does not match the first password";
			}
			
			if(!retypedEmailaddress.equals(emailaddress))
			{
				errorMessage += "\nThe second email address does not match the first email address";
			}
		}
		return registerSuccess;	
	}
	
	public boolean loginSuccess(User u1)
	{
		boolean loginSuccess = false;
		
		if(u1.getUsername() != "" && u1.getPassword() != "")
		{
			for(User u : users)
			{
				if(u1.getUsername().equals(u.getUsername()))
				{
					if(u1.getPassword().equals(u.getPassword()))
					{
						loginSuccess = true;
					}
					
					else
					{
						errorMessage += "Password is incorrect";
					}
				}
				
				else
				{
					errorMessage += "Username doesn't exist";
				}
			}
		}
		
		else
		{
			if(u1.getUsername() == "")
			{
				errorMessage += "No username was given";
			}
			
			if(u1.getPassword() == "")
			{
				errorMessage += "No password was given";
			}
		}

			
		return loginSuccess;
	}
	
	public void addUser(User u)
	{
		users.add(u);
	}
	
	public ArrayList getAllUsers()
	{
		return users;
	}
	
	public String getErrorMessage()
	{
		return errorMessage;
	}
}

	
	