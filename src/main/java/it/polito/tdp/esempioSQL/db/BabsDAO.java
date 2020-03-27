package it.polito.tdp.esempioSQL.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import it.polito.it.esempioSQL.model.Station;


//classe che contiene i metodi che devo implementare, la usera model ogni volta che ne ha bisogno

public class BabsDAO {
	
	public List <Station> listStation(){  
		List <Station> result = new ArrayList <>();
		
		String sql = "SELECT station_id, name, dockcount, landmark  FROM STATION ORDER BY name";
		
		//Questa stringa si cerca di portarla fuori per non impazzire in futuro
		//String jdbcUrl = "jdbc:mysql://localhost/babs?user=root&password=Vale1998Giammy"; //jdbc url con cui prendo la connessione
		
		try {
			//non prende piu la connessione dal driver manager, ma da DBConnect
			//Connection conn = DriverManager.getConnection(jdbcUrl); //prendo la connessione
			Connection conn = DBConnect.getConnection();
			
			PreparedStatement st= conn.prepareStatement(sql);
			
			ResultSet res = st.executeQuery(); //eseguo la query
			
			
			while (res.next()) { //analizzo i contenuti
				Station s = new Station (res.getInt("station_id"), res.getString("name"), res.getInt("dockcount"), res.getString("landmark"));
				//l'aggiungo alla lista 
				result.add(s);
			}
			st.close();
			
			Statement st2= conn.createStatement(); 
			conn.close();
			
			return result;
			
		
		} catch (SQLException e) {                            
			e.printStackTrace();
		}
		
		return null;
		}
	
	public List <Station> listStationByLandmark (String landmark){
		List <Station> result = new ArrayList <>();
		
		String sql = "SELECT station_id, name, dockcount, landmark  FROM STATION WHERE landmark=? ORDER BY name";
		
		
		try {
			Connection conn = DBConnect.getConnection();

			PreparedStatement st= conn.prepareStatement(sql);
			
			st.setString(1, landmark); 
			ResultSet res = st.executeQuery(); //eseguo la query
			
			
			while (res.next()) { //analizzo i contenuti
				Station s = new Station (res.getInt("station_id"), res.getString("name"), res.getInt("dockcount"), res.getString("landmark"));
				//l'aggiungo alla lista 
				result.add(s);
			}
			st.close();
			
			Statement st2= conn.createStatement(); 
			conn.close();
			
			return result;
			
		
		} catch (SQLException e) {                            
			e.printStackTrace();
		}
		
		return null;
		
	}
	}
		

