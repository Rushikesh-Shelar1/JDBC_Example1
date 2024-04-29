package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import utility.DBUtil;

public class TestResultSetDemo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Connection con =DBUtil.getConnection();
			PreparedStatement pst=con.prepareStatement("select * from flightinfo",ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs=pst.executeQuery();
			// boolean absolute(2)
			rs.absolute(3);
			System.out.println(rs.getInt(1)+ " "+rs.getString(2)+" "+rs.getDouble(3));
			//boolean first()
			rs.first();
			System.out.println(rs.getInt(1)+ " "+rs.getString(2)+" "+rs.getDouble(3)+" "+rs.getString(4));
			
			rs.relative(2);
			System.out.println(rs.getInt(1)+ " "+rs.getString(2)+" "+rs.getDouble(3)+" "+rs.getString(4));
		}
		catch(Exception e) {
			
		}

	}

}
