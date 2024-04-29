package batch_up;

import java.sql.Connection;
import java.sql.DatabaseMetaData;

import utility.DBUtil;

public class DataBaseMetadataDemo {

	public static void main(String[] args) {
		try
		{
			Connection con=DBUtil.getConnection();
			DatabaseMetaData dbmt=con.getMetaData();
			System.out.println("server name:"+dbmt.getDatabaseProductName());
			System.out.println("server version "+dbmt.getDatabaseProductVersion());
			System.out.println("database name "+dbmt.getDriverName());
			System.out.println("database version "+dbmt.getDriverVersion());
			System.out.println("URL: "+dbmt.getURL());
			if(dbmt.supportsBatchUpdates())
			{
				System.out.println(dbmt.getDatabaseProductName()+" "+"support batch update");
			}
			else
			{
				System.out.println("do not support batch update");
			}
		}catch(Exception e) {
			System.out.println(e);
		}

	}

}
