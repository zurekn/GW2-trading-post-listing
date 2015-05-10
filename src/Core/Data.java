package Core;


import java.io.IOException;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.List;

import cz.zweistein.gw2.api.GW2API;
import cz.zweistein.gw2.api.dao.OnlineJsonDao;
import cz.zweistein.gw2.api.dto.items.Item;
import cz.zweistein.gw2.api.util.SupportedLanguage;


public class Data {

	private static OnlineJsonDao apiJSON;

	private static GW2API api;
	private static HashMap<Long, String> items = new HashMap<Long, String>();
	public static void initAPI(){
		
	
		try {
			
			api = new GW2API();
			loadItem();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public static void loadItem() throws RemoteException{
		List<Long> items;
		try {
			items = api.getItems();

			System.out.println("Load ["+items.toString()+"] items");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}
	
	public static String getItem(String name){
		return "";
	}
}
