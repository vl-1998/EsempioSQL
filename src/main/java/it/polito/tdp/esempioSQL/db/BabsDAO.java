package it.polito.tdp.esempioSQL.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.esempioSQL.model.Station;

public class BabsDAO {
	
	public List<Station> listStation() {
		List<Station> result = new ArrayList<>() ;
		
		String sql = "SELECT station_id, name, dockcount, landmark FROM station ORDER BY name" ;
				
		try {
			Connection conn = DBConnect.getConnection() ;
			
			PreparedStatement st = conn.prepareStatement(sql) ;
			
			ResultSet res = st.executeQuery() ;
			
			while(res.next()) {
				Station s = new Station(res.getInt("station_id"),
						res.getString("name"),
						res.getInt("dockcount"),
						res.getString("landmark")) ;
				
				result.add(s) ;				
			}
			st.close();
						
			conn.close();
			
			return result ;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return null ;
	}

	
	public List<Station> listStationByLandmark(String landmark) {
		List<Station> result = new ArrayList<>() ;
		
		String sql = "SELECT station_id, name, dockcount, landmark FROM station "
				+ "WHERE landmark=? ORDER BY name" ;
				
		try {
			Connection conn = DBConnect.getConnection() ;
			
			PreparedStatement st = conn.prepareStatement(sql) ;
			
			st.setString(1, landmark) ;
			ResultSet res = st.executeQuery() ;
			
			while(res.next()) {
				Station s = new Station(res.getInt("station_id"),
						res.getString("name"),
						res.getInt("dockcount"),
						res.getString("landmark")) ;
				
				result.add(s) ;				
			}
			st.close();
						
			conn.close();
			
			return result ;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return null ;
	}
}
