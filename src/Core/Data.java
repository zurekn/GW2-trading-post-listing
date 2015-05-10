package Core;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.List;

import cz.zweistein.gw2.api.GW2API;
import cz.zweistein.gw2.api.dao.*;
import cz.zweistein.gw2.api.util.SupportedLanguage;

public class Data {

	private static OnlineJsonDao apiJSON;

	private static GW2API api;
	private static HashMap<Long, String> items = new HashMap<Long, String>();
	public static void initAPI(){
		
	
		try {
		
			
			api = new GW2API();
			loadItem();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public static void loadItem() throws RemoteException{
		List<Long> i = api.getItems();
        for (Long id : i) {
               String name =  api.getItemDetails(id, SupportedLanguage.FRENCH).getName();
               items.put(id, name);
        }
        System.out.println("Load ["+items.size()+"] items");
	}
	
	public static String getItem(String name){
		return "";
	}
}
