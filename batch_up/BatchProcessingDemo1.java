package batch_up;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Arrays;

import utility.DBUtil;

public class BatchProcessingDemo1 {

	public static void main(String[] args)throws Exception {
		
		Connection con=DBUtil.getConnection();
		String insert_query1_account_table="insert into accountinfo values(19845,5600,'xyz','savings')";
		String insert_query2_flight_table="insert into flightinfo values(1418,'jet airways',55000,'kolkata','dubai','2024-08-25')";
		String update_query1="update flightinfo set flight_price=8800 where flight_id=9500";
		String delete_query1="delete from flightinfo where flight_id=1518";
		Statement stmt =con.createStatement();
		stmt.addBatch(insert_query1_account_table);
		stmt.addBatch(insert_query2_flight_table);
		stmt.addBatch(update_query1);
		stmt.addBatch(delete_query1);
		
		int[] result=stmt.executeBatch();
		System.out.println(Arrays.toString(result));
	}

}
