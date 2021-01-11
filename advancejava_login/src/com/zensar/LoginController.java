package com.zensar;

import javax.servlet.http.*;

import com.zensar.LoginRepository;

public class LoginController extends HttpServlet
{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	{
		String requestAction = request.getParameter("requestAction");
		
		if(requestAction.equalsIgnoreCase("loginCheck"))
		{
		
			String userName = request.getParameter("userName");
			String password = request.getParameter("password");
		
			LoginRepository loginRepository = new LoginRepository();
			boolean loginResult = loginRepository.checkLogin(userName, password);
			
			if(loginResult)
			{
				try
				{  
					response.sendRedirect("welcome.jsp");
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
			}
			else
			{
				try
				{
					response.sendRedirect("index.jsp?status=fail");
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
			}
		}
		
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	{
		doGet(request, response);
	}
}
