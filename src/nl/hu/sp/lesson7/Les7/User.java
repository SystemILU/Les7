package nl.hu.sp.lesson7.Les7;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable
{
	private String username;
	private String realname;
	private String password;
	private String emailaddress;
	private String address;
	private String country;
	private ArrayList<BlogPost> allBlogPosts;
	
	public User(String username1, String realname1, String password1, String emailaddress1, String address1, String country1)
	{
		this.username = username1;
		this.realname = realname1;
		this.password = password1;
		this.emailaddress = emailaddress1;
		this.address = address1;
		this.country = country1;
		allBlogPosts = new ArrayList<BlogPost>();
	}
	
	public String getUsername()
	{
		return username;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public void addBlogPost(BlogPost post)
	{
		allBlogPosts.add(post);
	}
	
	public ArrayList<BlogPost> getAllBlogposts()
	{
		return allBlogPosts;
	}
	
	
	
	public String toString()
	{
		String s = username + " posted the following: ";
		
		for(BlogPost bP : allBlogPosts)
		{
			s += "\n\n" + bP.getBlogText();
		}
		
		return s;
	}

}

