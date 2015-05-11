package Core;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Search {

	private String name;

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

	public void updateName(String name) {
		this.name = name;
		JSONArray result = Data.getItem(name);
		Iterator it = result.iterator();
		JSONParser parser = new JSONParser();
		JSONObject obj;
		while (it.hasNext()) {
			try {
				obj = (JSONObject) parser.parse(it.next().toString());
				System.out.println(obj.get("name") + ", " + obj.get("data_id"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
}
