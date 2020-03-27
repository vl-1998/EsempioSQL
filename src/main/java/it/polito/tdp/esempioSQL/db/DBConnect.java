package it.polito.tdp.esempioSQL.db;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

//non sara pubblica, perchè non deve vederla al di fuori, ma solo il DAO
 class DBConnect {
	
	//Metodo fittizio
	public static Connection getConnection() throws SQLException {
		String jdbcUrl = "jdbc:mysql://localhost/babs?user=root&password=Vale1998Giammy"; //jdbc url con cui prendo la connessione
		return DriverManager.getConnection(jdbcUrl);
	}

}
