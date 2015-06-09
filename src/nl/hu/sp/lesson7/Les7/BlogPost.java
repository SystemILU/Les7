package nl.hu.sp.lesson7.Les7;

import java.io.Serializable;

public class BlogPost implements Serializable
{
	private String blogText;
	
	public BlogPost(String blogText1)
	{
		this.blogText = blogText1;
	}
	
	public String getBlogText()
	{
		return blogText;
	}
	
	public String toString()
	{
		return blogText;
	}

}
