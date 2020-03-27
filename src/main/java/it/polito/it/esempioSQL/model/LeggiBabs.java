package it.polito.it.esempioSQL.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//In questa classe vogliamo leggere i dati come database

public class LeggiBabs {

	public void run() {
		String jdbcUrl = "jdbc:mysql://localhost/babs?user=root&password=Vale1998Giammy"; //stringa di connessione che identifica in modo preciso cosa vogliamo leggere
		
		
		/* Questo si chiama pattern di programmazione di tipo FACTORY, abbiamo creato un oggetto di una classe senza sapere come si chiama questa
		 * classe, quindi non potevo usare new, perche avrei dovuto dire qual era la classe. 
		 * Uso un metodo fornito da un'altra classe che internamente fara la new e conoscera il tipo di classe effettivo.
		 * Questo pattern e' molto utilizzato
		 */
		
		try {
		//Driver manager analizza la string, va a vedere quali classi implementano la collection e chiede a tutte le classi se qualcuna puo rispondere
		//a my sql, la prima che risponde prende ilcontrollo della connessione e apre la connessione, passandogli i parametri
			Connection conn = DriverManager.getConnection(jdbcUrl); //Driver manager è una classe della libreria java sql, connection che pero
		                                                            //e' un interfaccia. In tutte le operazioni di input output c'e un exception, per questo in blocco try catch
			Statement st = conn.createStatement(); //chiedo alla connessione di crearmi una "navetta"
			
			String sql = "SELECT NAME FROM station"; //incollo un interrogazione che sono sicuro sia giusta dal punto di vista sintattico 
			
			ResultSet res = st.executeQuery(sql); //vai al database e digli di eseguire questa istruzione (Risultato creato sempre tramite factory) Questo contiene il modo per accedere al risultao
			
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
			}
		}
		
	// Creo un'istanza di me stesso e la eseguo
	
	public static void main(String args[]) {
		LeggiBabs babs = new LeggiBabs();
		babs.run();
		
	}
}
