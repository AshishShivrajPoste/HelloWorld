package com.ashish.edu.jdbcds;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

public class DataSourceTest {

	public void testDataSource(String dbType){
		DataSource dataSource = null;
		if(dbType.equalsIgnoreCase(JDBCConstants.ORACLE)){
			dataSource = MyDataSourceFactory.getMyORACLEDataSource();
		}else if(dbType.equalsIgnoreCase(JDBCConstants.MYSQL)){
			dataSource = MyDataSourceFactory.getMySQLDataSource();
		}else{
			System.out.println("DB TYPE NOT SUPPORTED");
		}
		Connection con =null;
		Statement stmt = null;
		ResultSet resultSet = null;
		try {
			con = dataSource.getConnection();
			stmt = con.createStatement();
			resultSet = stmt.executeQuery(JDBCConstants.SELECT_ALL_EMPLOYEE_QUERY);
			while(resultSet.next()){
				System.out.println("EMPLOYEE_NAME="+resultSet.getString("NAME")+"     EMPLOYEE_ID="+resultSet.getString("ID")+"      EMPLOYEE_SALARY="+resultSet.getString("SALARY"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			con.close();
		}

		
	}
	public static void main(String[] args) {
		DataSourceTest dataSourceTest = new DataSourceTest();
		dataSourceTest.testDataSource(JDBCConstants.ORACLE);
	}
}
