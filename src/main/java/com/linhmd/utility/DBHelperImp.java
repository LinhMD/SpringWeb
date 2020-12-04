package com.linhmd.utility;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.Vector;

@Component
@Qualifier("sqlConnection")
public class DBHelperImp implements DBHelper {

	private Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String url = "jdbc:sqlserver://localhost:1433;databaseName=test";
		return DriverManager.getConnection(url, "sa", "123456");
	}

	public boolean executeNonQuery(String sqlStatement, Vector<Object> values) throws Exception {
		boolean result;
		try (Connection cnn = getConnection(); PreparedStatement ps = cnn.prepareStatement(sqlStatement)) {
			for ( int index = 0; index < values.size(); index++) {
				ps.setObject(index + 1, values.get(index));
			}
			result = (ps.executeUpdate() > 0);
			ps.close();
			cnn.close();
		}
		return result;
	}
	public Vector<Vector<String>> executeQuery(String sqlStatement, Vector<Object> values) throws Exception {
		Connection cnn = null;
		PreparedStatement pre = null;
		Vector<Vector<String>> dataTable = new Vector<>();
		int index, columnsNumber;
		try {
			cnn = this.getConnection();
			pre = cnn.prepareStatement(sqlStatement);
			for (index = 0; index < values.size(); index++) {
				pre.setObject(index + 1, values.get(index));
			}

			ResultSet rs = pre.executeQuery();
			columnsNumber = rs.getMetaData().getColumnCount();

			while (rs.next()) {
				Vector<String> rowData = new Vector<>();
				for (index = 1; index <= columnsNumber; index++)
					rowData.add(rs.getString(index));
				dataTable.add(rowData);
			}
		} catch (Exception ex) {
			throw new Exception(ex.getMessage());
		} finally {
			if(pre != null) pre.close();
			if (cnn != null) cnn.close();
		}
		return dataTable;
	}

	public static void main(String[] args) {
		DBHelperImp dbHelperImp = new DBHelperImp();
		try {
			System.out.println(dbHelperImp.getConnection());
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
