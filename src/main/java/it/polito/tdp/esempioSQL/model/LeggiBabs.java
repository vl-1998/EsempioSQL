package it.polito.tdp.esempioSQL.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LeggiBabs {
	
	public void run() {
		String jdbcURL = "jdbc:mysql://localhost/babs?user=root&password=root" ;
		
		try {
			Connection conn = DriverManager.getConnection(jdbcURL) ;
			
			String sql = "SELECT name FROM station WHERE landmark = ? " ;

			PreparedStatement st = conn.prepareStatement(sql) ;
			
			
			st.setString(1, "Palo Alto");
			ResultSet res = st.executeQuery() ;
			
			while(res.next()) {
				String nomeStazione = res.getString("name") ;
				
				System.out.println(nomeStazione) ;
			}
			st.close();
						
			conn.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		// FACTORY: creazione di un oggetto di una classe, senza
		// conoscere il tipo della classe (NON potevo usare new)
		// Uso un metodo fornito da un'altra classe che internamente
		// farà new e conoscerà il tipo di classe effettivo.
	}
	
	public static void main(String args[]) {
		LeggiBabs babs = new LeggiBabs() ;
		babs.run();
	}

}
