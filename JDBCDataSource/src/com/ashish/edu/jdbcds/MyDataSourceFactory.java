package com.ashish.edu.jdbcds;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import oracle.jdbc.pool.OracleDataSource;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class MyDataSourceFactory {

	public static DataSource getMySQLDataSource(){
		Properties properties = new Properties();
		FileInputStream fis = null;
		MysqlDataSource mySQLDS = null;
		try{
			fis = new FileInputStream(JDBCConstants.DB_PROPERTY_FILE);
			mySQLDS = new MysqlDataSource();
			mySQLDS.setURL(properties.getProperty(JDBCConstants.MYSQL_DB_URL));
			mySQLDS.setUser(properties.getProperty(JDBCConstants.MYSQL_DB_USERNAME));
			mySQLDS.setPassword(properties.getProperty(JDBCConstants.MYSQL_DB_PASSWORD));	
			properties.load(fis);
		}catch(IOException e){
			System.out.println("IOException Occured"+e.getStackTrace());
		}
		return mySQLDS;
	}
	
	public static DataSource getMyORACLEDataSource(){
		Properties properties = new Properties();
		FileInputStream fis = null;
		OracleDataSource oracleDataSource = null;
		try{
			fis = new FileInputStream(JDBCConstants.DB_PROPERTY_FILE);
			properties.load(fis);
			oracleDataSource = new OracleDataSource();
			oracleDataSource.setDataSourceName(properties.getProperty(JDBCConstants.ORACLE_DB_DRIVER_CLASS));
			oracleDataSource.setURL(properties.getProperty(JDBCConstants.ORACLE_DB_URL));
			oracleDataSource.setUser(properties.getProperty(JDBCConstants.ORACLE_DB_USERNAME));
			oracleDataSource.setPassword(properties.getProperty(JDBCConstants.ORACLE_DB_PASSWORD));		
		}catch(IOException e){

			e.printStackTrace();
		}catch(SQLException e){
			System.out.println("SQLException Occured"+e.getStackTrace());
		}
		return oracleDataSource;
	}
}
