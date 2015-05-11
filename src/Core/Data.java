package Core;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import IHM.Interface;
import cz.zweistein.gw2.api.GW2API;
import cz.zweistein.gw2.api.dao.OnlineJsonDao;
import cz.zweistein.gw2.api.util.SupportedLanguage;

public class Data {

	private static OnlineJsonDao apiJSON;

	private static GW2API api;
	private static ArrayList<ShortItem> items =new ArrayList<>();

	private static long beginTimer;
	private Interface inter;
	
	
	public Data(Interface inter){
		this.inter = inter;
	}
	
	public void initAPI() {
		Thread thread = new Thread(new InitClass());
		thread.start();
		
	}

	public void loadItem() throws RemoteException {

		List<Long> i = api.getItems();
		for (Long id : i) {
			try {
				String name = api.getItemDetails(id, SupportedLanguage.FRENCH)
						.getName();
				
				items.add(new ShortItem(id, name));
				inter.refreshCount(items.size());
			} catch (IllegalArgumentException e) {
				System.err.println("IllegalArgumentException for item [" + id
						+ "]");
			}
		}
		System.out.println("Load [" + items.size() + "] items in ["
				+ ((System.currentTimeMillis() - beginTimer) / 1000) + "]");
	}

	public ArrayList<ShortItem> getItems() {
		return items;
	}

	private class InitClass implements Runnable {

		@Override
		public void run() {
			System.out.println("Parallele run");
			beginTimer = System.currentTimeMillis();
			try {
				System.out.println("Trying to connect to the WebSite");
				api = new GW2API();
				System.out.println("Connected after : "+((System.currentTimeMillis() - beginTimer)/1000));
				inter.connected();
				System.out.println("API connected");
				loadItem();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
		}

	}

}
