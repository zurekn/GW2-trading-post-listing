package Core;


import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;


public class Search {

	private String name;
	
	
	public Search(){

	}
	
	public void updateName(String name){
		this.name = name;
		Data.getItem(name);
	}
}
