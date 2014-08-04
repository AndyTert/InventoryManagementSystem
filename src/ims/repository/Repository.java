package ims.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.CallableStatement;
import com.mysql.jdbc.Connection;

public class Repository {
	Connection conn = new MySqlConnection().getConn();

	protected boolean callStoredProcedure(String sp, Object... param) throws SQLException {
		// prepare statement
		CallableStatement stmt = (CallableStatement) conn.prepareCall(sp);
		int position = 1;
		for (Object obj : param) {
			stmt.setObject(position, obj);
			position = position + 1;
		}

		// execute
		int rowcount = stmt.executeUpdate();

		// result
		return rowcount > 0 ? true : false;
	}
	
	protected ResultSet callStoredProcedureWithResultSet(String sp, Object... param) throws SQLException {
		// prepare statement
		CallableStatement stmt = (CallableStatement) conn.prepareCall(sp);
		int position = 1;
		for (Object obj : param) {
			stmt.setObject(position, obj);
		}

		// execute
		stmt.executeUpdate();

		// result
		return stmt.getResultSet();
	}
}
