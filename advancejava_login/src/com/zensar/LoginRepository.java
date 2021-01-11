package com.zensar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.zensar.utility.DBUtil;

public class LoginRepository 
{
	public boolean checkLogin(String userName, String password)
	{
		boolean result = false;
		Connection con = DBUtil.getMySqlDbConnection();
		String sql = "select * from login where username=?";
		try
		{
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, userName);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next())
			{
				String dbPassword = rs.getString("password");
				if(dbPassword.equals(password))
				{
					result = true;
				}
				else
				{
					result = false;
				}
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return result;
	}
}
