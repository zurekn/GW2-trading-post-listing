package Core;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Search {

	private String name;

	private ArrayList<ShortItem> result = new ArrayList<ShortItem>();

	public Search() {

	}

	public void selectItem(String name) {
		try {
			Data.storageHandler.saveSearch(name, "2");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void validate(String name) {

	}

	public void updateName(String name) {
		if (name == null)
			return;
		this.result.clear();
		Data.itemSuggestor.clear();
		this.name = name;
		JSONArray result = Data.getItem(name);
		if (result == null)
			return;
		Iterator it = result.iterator();
		JSONParser parser = new JSONParser();
		JSONObject obj;
		ShortItem item;
		while (it.hasNext()) {
			try {
				obj = (JSONObject) parser.parse(it.next().toString());
				item = new ShortItem(Long.parseLong(obj.get(Data.idTag)
						.toString()), obj.get(Data.nameTag).toString());
				this.result.add(item);
				Data.itemSuggestor.add(item);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		System.out.println("Listing finish");
	}
}
