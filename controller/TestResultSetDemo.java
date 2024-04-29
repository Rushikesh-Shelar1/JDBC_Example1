package controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import utility.DBUtil;

public class TestResultSetDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Connection con =DBUtil.getConnection();
			Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);//Integer constant
			ResultSet rs=stmt.executeQuery("select * from flightinfo");
			while(rs.next()) {
				System.out.println(rs.getInt(1)+" "+rs.getString(2));
			}
			System.out.println("**********");
			while(rs.previous()) {
		
			System.out.println(rs.getInt(1)+" "+rs.getString(2));
			}
		}catch(Exception e) {
			System.out.println(e);
		}

	}

}
