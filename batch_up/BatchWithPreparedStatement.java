package batch_up;

import java.sql.Connection;
import java.sql.PreparedStatement;

import utility.DBUtil;

public class BatchWithPreparedStatement {

	public static void main(String[] args)throws Exception {

		String sql_del_query = "delete from AccountInfo where acn_number=7721";
		String sql_update_query = "update AccountInfo set acn_bal = acn_bal + 500 where acn_number=10845";
		Connection con = DBUtil.getConnection();
		PreparedStatement ps1 = con.prepareStatement(sql_update_query);
		
		/*
		       in case of prepared statement is we pass sql query inside
		       the PreparedStatement method then we can invoke addBatch() without parameter
		       but if you not pass the query inside that method then we can use 
		       addBatch(String sql)
		 */
		ps1.addBatch();
		
		PreparedStatement ps2 = con.prepareStatement(sql_del_query);
		ps2.addBatch();
		
		ps1.executeBatch();
		ps2.executeBatch();
		

	}

}
