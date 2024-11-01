package dao;

public class AccountsDAO {
	private final String JDBC_URL=
			"";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";
	
	try {
		Class.forName("org.h2.Driver");
	}catch(ClassNotFoundException e){
		throw new IllegalStateException(
				"JDBCドライバを読み込めませんでした");
		
	}
}
