package Core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Data {

	private static final String gw2url = "http://www.gw2spidy.com/api/v0.9/json/";
	private static HashMap<Long, String> items = new HashMap<Long, String>();

	public static StorageHandler storageHandler;

	public static void initAPI() {
		try {
			storageHandler = new StorageHandler();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void loadItem() throws RemoteException {

	}

	private static String readUrl(String urlString) throws Exception {
		BufferedReader reader = null;
		try {
			URL url = new URL(urlString);
			reader = new BufferedReader(new InputStreamReader(url.openStream()));
			StringBuffer buffer = new StringBuffer();
			int read;
			char[] chars = new char[1024];
			while ((read = reader.read(chars)) != -1)
				buffer.append(chars, 0, read);

			return buffer.toString();
		} finally {
			if (reader != null)
				reader.close();
		}
	}

	public static JSONArray getItem(String name) {
		name = parseForURL(name);
		String url = gw2url + "item-search/" + name;
		System.out.println("Connecting to " + url);
		JSONObject json = new JSONObject();
		JSONParser parser = new JSONParser();
		JSONArray array = null;
		try {
			json = (JSONObject) parser.parse(readUrl(url));
			System.out.println("---------------Info sur le JSON--------------");
			System.out.println("ToString : " + json.toJSONString());

			array = (JSONArray) json.get("results");
			Iterator it = array.iterator();
			JSONObject obj;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return array;
	}

	public static String parseForURL(String s) {
		String[] split = s.split(" ");
		if (split.length > 1) {
			boolean first = true;
			s = "";
			for (String s1 : split) {
				if (!first)
					s += "%20";
				s += s1;
				first = false;
			}
		}
		return s;
	}
}
