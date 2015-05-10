package Core;

import java.rmi.RemoteException;

import cz.zweistein.gw2.api.GW2API;;

public class Search {

	private String name;
	
	
	public Search(){
		try {
			GW2API api = new GW2API();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateName(String name){
		this.name = name;
		Data.getItem(name);
	}
}
