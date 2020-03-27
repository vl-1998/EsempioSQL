package it.polito.it.esempioSQL.model;
//classe che rappresenta la stazione con attributi che rappresentano le colonne della tabella

//Cosi definisco un oggetto utilizzabile
public class Station {
	private int id;
	private String name;
	private int dockCount;
	private String landmark;
	/**
	 * @param id
	 * @param name
	 * @param dockCount
	 * @param landmark
	 */
	public Station(int id, String name, int dockCount, String landmark) {
		super();
		this.id = id;
		this.name = name;
		this.dockCount = dockCount;
		this.landmark = landmark;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDockCount() {
		return dockCount;
	}
	public void setDockCount(int dockCount) {
		this.dockCount = dockCount;
	}
	public String getLandmark() {
		return landmark;
	}
	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}
	
	

}
