package org.dtcubed.et;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EtDatabase {
	
	private static final String etdbsSubdir = "etdbs/";
		
	public static void createEtAdminDatabase(String adminPassword) throws ClassNotFoundException {
				
		String connectString = "jdbc:sqlite:" + etdbsSubdir + "admin.db";
			
		// load the sqlite-JDBC driver using the current class loader
		Class.forName("org.sqlite.JDBC");

		Connection connection = null;
		String sql = "";
		
		try {
			// create a database connection
			connection = DriverManager.getConnection(connectString);
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30); // set timeout to 30 sec.
			
			sql  = "DROP TABLE IF EXISTS info";
			
			statement.executeUpdate(sql);
			
			sql =  "CREATE TABLE info ";		
			sql += "(id INTEGER PRIMARY KEY AUTOINCREMENT, ";
	        sql += "password_digest TEXT NOT NULL)";
	        
			statement.executeUpdate(sql);
			
			sql =  "INSERT INTO info VALUES(1, '" + adminPassword + "')";
			statement.executeUpdate(sql);

		} catch (SQLException e) {
			// if the error message is "out of memory",
			// it probably means no database file is found
			System.err.println(e.getMessage());
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				// connection close failed.
				System.err.println(e);
			}
		}
	}
		
	public static void createEtDatabase(String basename) throws ClassNotFoundException {
		
		// The "admin" database is special in our application. 
		// Don't allow creation here.
		if (basename.compareToIgnoreCase("admin") == 0) {
			
			String msg = "Can not deal with admin databases, returning now.";
			System.out.println(msg);
			return;
		}
		
		String connectString = "jdbc:sqlite:" + etdbsSubdir + basename + ".db";
			
		// load the sqlite-JDBC driver using the current class loader
		Class.forName("org.sqlite.JDBC");

		Connection connection = null;
		String sql = "";
		
		try {
			// create a database connection
			// connection = DriverManager.getConnection("jdbc:sqlite:expensetracker.db");
			connection = DriverManager.getConnection(connectString);
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30); // set timeout to 30 sec.
			
			sql  = "DROP TABLE IF EXISTS expense";
			
			statement.executeUpdate(sql);
			
			sql =  "CREATE TABLE expense ";		
			sql += "(id INTEGER PRIMARY KEY AUTOINCREMENT, ";
	        sql += "incurred_date TEXT NOT NULL, ";
	        sql += "amount REAL NOT NULL, ";
	        sql += "category_code TEXT NOT NULL, ";
	        sql += "desc TEXT NOT NULL)";
	        
			statement.executeUpdate(sql);

		} catch (SQLException e) {
			// if the error message is "out of memory",
			// it probably means no database file is found
			System.err.println(e.getMessage());
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				// connection close failed.
				System.err.println(e);
			}
		}
	}
	
	public static String getAdminPassword() throws ClassNotFoundException {
		
		String connectString = "jdbc:sqlite:" + etdbsSubdir + "admin.db";
		String adminPassword = "";
			
		// load the sqlite-JDBC driver using the current class loader
		Class.forName("org.sqlite.JDBC");

		Connection connection = null;
		String sql = "SELECT password_digest FROM info WHERE id = '1'";
		
		try {
			// create a database connection
			connection = DriverManager.getConnection(connectString);
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30); // set timeout to 30 sec.
			
			
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				adminPassword = rs.getString("password_digest");
			}

		} catch (SQLException e) {
			// if the error message is "out of memory",
			// it probably means no database file is found
			System.err.println(e.getMessage());
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				// connection close failed.
				System.err.println(e);
			}
		}
		
		return adminPassword;
	}
	
	
	public static void oldoldcreateEtDatabaseOld() throws ClassNotFoundException {
		// load the sqlite-JDBC driver using the current class loader
		Class.forName("org.sqlite.JDBC");

		Connection connection = null;
		String sql = "";
		
		try {
			// create a database connection
			connection = DriverManager.getConnection("jdbc:sqlite:expensetracker.db");
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30); // set timeout to 30 sec.
			
			sql  = "DROP TABLE IF EXISTS expense";
			
			statement.executeUpdate(sql);
			
			sql =  "CREATE TABLE expense ";		
			sql += "(id INTEGER PRIMARY KEY AUTOINCREMENT, ";
	        sql += "incurred_date TEXT NOT NULL, ";
	        sql += "amount REAL NOT NULL, ";
	        sql += "category_code TEXT NOT NULL, ";
	        sql += "desc TEXT NOT NULL)";
	        
			statement.executeUpdate(sql);

		} catch (SQLException e) {
			// if the error message is "out of memory",
			// it probably means no database file is found
			System.err.println(e.getMessage());
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				// connection close failed.
				System.err.println(e);
			}
		}
	}
	
	public static void oldxxxcreateEtDatabase() throws ClassNotFoundException {
		// load the sqlite-JDBC driver using the current class loader
		Class.forName("org.sqlite.JDBC");

		Connection connection = null;
		try {
			// create a database connection
			connection = DriverManager.getConnection("jdbc:sqlite:expensetracker.db");
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30); // set timeout to 30 sec.

			statement.executeUpdate("drop table if exists expense");
			statement.executeUpdate("create table expense (id integer, amount string)");
			statement.executeUpdate("insert into expense values(1, '13.13')");
			statement.executeUpdate("insert into expense values(2, '14.14')");

		} catch (SQLException e) {
			// if the error message is "out of memory",
			// it probably means no database file is found
			System.err.println(e.getMessage());
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				// connection close failed.
				System.err.println(e);
			}
		}
	}

	public static void main(String[] args) throws ClassNotFoundException {
		// load the sqlite-JDBC driver using the current class loader
		Class.forName("org.sqlite.JDBC");

		Connection connection = null;
		try {
			// create a database connection
			connection = DriverManager.getConnection("jdbc:sqlite:sample.db");
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30); // set timeout to 30 sec.

			statement.executeUpdate("drop table if exists person");
			statement
					.executeUpdate("create table person (id integer, name string)");
			statement.executeUpdate("insert into person values(1, 'leo')");
			statement.executeUpdate("insert into person values(2, 'yui')");
			ResultSet rs = statement.executeQuery("select * from person");
			while (rs.next()) {
				// read the result set
				System.out.println("name = " + rs.getString("name"));
				System.out.println("id = " + rs.getInt("id"));
			}
		} catch (SQLException e) {
			// if the error message is "out of memory",
			// it probably means no database file is found
			System.err.println(e.getMessage());
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				// connection close failed.
				System.err.println(e);
			}
		}
	}
}
