package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Account;
import model.User;

public class AccountsDAO {
	private final String JDBC_URL=
			"jdbc:h2:tcp://localhost/~/dokoOriginal_2";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";
	
	public Account findByLogin(User user) {
		Account account = null;
		
		try {
			Class.forName("org.h2.Driver");
		}catch(ClassNotFoundException e){
			throw new IllegalStateException(
					"JDBCドライバを読み込めませんでした");
		}
		
		try(Connection conn = DriverManager.getConnection(
				JDBC_URL, DB_USER, DB_PASS)){
			String sql = "SELECT * FROM ACCOUNTS WHERE USER_ID = ? AND PASS = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1,user.getUserId());
			pStmt.setString(2, user.getPass());
			
			ResultSet rs = pStmt.executeQuery();
			
			if(rs.next()) {
				String userId = rs.getString("USER_ID");
				String pass = rs.getString("PASS");
				String mail = rs.getString("MAIL");
				String name = rs.getString("NAME");
				int age = rs.getInt("AGE");
				
				account = new Account(userId,pass,mail,name,age);
			}	
				
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}
		return account;
		
	}
}
