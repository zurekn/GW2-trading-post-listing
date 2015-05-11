package Core;


import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;

import org.json.simple.JSONArray;


public class Search {

	private String name;
	
	
	public Search(){

	}
	
	public void selectItem(String nane){
		try {
			Data.storageHandler.saveSearch(name, "2");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateName(String name){
		this.name = name;
		JSONArray result = Data.getItem(name);
		
	}
}
