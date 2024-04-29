package controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import utility.DBUtil;

public class TestResultSetDemo4 {

	public static void main(String[] args) {
		try {
			Connection con =DBUtil.getConnection();
			Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);//Integer constant
			ResultSet rs=stmt.executeQuery("select * from FlightInfo");
			while(rs.next()) {//updating whole column
				rs.updateDouble(3,rs.getDouble(3)+5000);
				rs.updateRow();
				System.out.println("data updated");
			}
	}catch(Exception e) {
		System.out.println(e);
	}

	}

}
