package controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import utility.DBUtil;

public class TestResultSetDemo3 {

	public static void main(String[] args) {
		try {
			Connection con =DBUtil.getConnection();
			Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);//Integer constant
			ResultSet rs=stmt.executeQuery("select * from flightinfo");
			rs.absolute(3);
			rs.updateDouble(3,10001);
			rs.updateRow();
			System.out.println("data updated");
	}catch(Exception e) {
		System.out.println(e);
	}

}
}
