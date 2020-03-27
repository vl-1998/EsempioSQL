package it.polito.it.esempioSQL.model;
import java.util.List;

import it.polito.tdp.esempioSQL.db.BabsDAO;


//QUesti import non servono piu
/*import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;*/

//In questa classe vogliamo leggere i dati come database

public class LeggiBabs {

	public void run() {
		
		//TUTTO QUESTO SOTTO L'HO SPOSTATO NEL DAO
		/*String jdbcUrl = "jdbc:mysql://localhost/babs?user=root&password=Vale1998Giammy"; //stringa di connessione che identifica in modo preciso cosa vogliamo leggere
		
		
		/* Questo si chiama pattern di programmazione di tipo FACTORY, abbiamo creato un oggetto di una classe senza sapere come si chiama questa
		 * classe, quindi non potevo usare new, perche avrei dovuto dire qual era la classe. 
		 * Uso un metodo fornito da un'altra classe che internamente fara la new e conoscera il tipo di classe effettivo.
		 * Questo pattern e' molto utilizzato
		 //
		
		try {
		//Driver manager analizza la string, va a vedere quali classi implementano la collection e chiede a tutte le classi se qualcuna puo rispondere
		//a my sql, la prima che risponde prende ilcontrollo della connessione e apre la connessione, passandogli i parametri
			Connection conn = DriverManager.getConnection(jdbcUrl); //Driver manager è una classe della libreria java sql, connection che pero
		                                                            //e' un interfaccia. In tutte le operazioni di input output c'e un exception, per questo in blocco try catch
			//Statement st = conn.createStatement(); //chiedo alla connessione di crearmi una "navetta"
			
			//anche se in questo caso non stiamo facendo una query parametrica, possiamo usare il prepared statement
			//la query va anticipata alla creazione dello statement
			
			//String sql = "SELECT name FROM station"; //incollo un interrogazione che sono sicuro sia giusta dal punto di vista sintattico 
			String sql = "SELECT name FROM station WHERE landmark= ?"; //questa è una definizione parametrica
			PreparedStatement st= conn.prepareStatement(sql);
			
			st.setString(1, "Palo Alto");
			//ResultSet res = st.executeQuery(sql); //vai al database e digli di eseguire questa istruzione (Risultato creato sempre tramite factory) Questo contiene il modo per accedere al risultao
			ResultSet res = st.executeQuery();
			
			//questo ciclo while funzionerebbe anche se la query non restituisse alcun risultato, passa dalla riga prima della prima alla riga dopo l'ultima
			while (res.next()) { //finche è vero res.next, il cursore è su una riga che esiste
				String nomeStazione = res.getString("name");
				
				System.out.println(nomeStazione);
			}
			st.close();
			
			Statement st2= conn.createStatement(); //posso fare un nuovo statemente sulla stessa cnnessione, ma dovrei dire al database che lo statemente iniziale non mi serve piu 
			conn.close();
			
		
		} catch (SQLException e) {                            
			e.printStackTrace();
			}*/
		
		
		BabsDAO dao = new BabsDAO();	
		List <Station> tutte = dao.listStation(); //cosi restituisco un elenco di oggetti
		
		for (Station s : tutte) {
			System.out.println(s.getName());
		}
		
		System.out.println("____");

		//QUI l'ALTRO METODO
		List <Station> paloAlto = dao.listStationByLandmark("Palo ALto"); //qui specifico che voglio le stazioni di palo alto
		for (Station s : paloAlto) {
			System.out.println(s.getName());
		}
		
		
	}
		
	// Creo un'istanza di me stesso e la eseguo
	
	public static void main(String args[]) {
		LeggiBabs babs = new LeggiBabs();
		babs.run();
		
	}
}
