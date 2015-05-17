package Core;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class Data {

	public static final String GW2_OFFICIAL_API = "https://api.guildwars2.com/v2";
	private static final String gw2url = "http://www.gw2shinies.com/api/json/";
	public static final String idTag = "item_id";
	public static final String nameTag = "name";
	public static StorageHandler storageHandler;
	public static final int maxArraySize = 30;

	public static enum apiFunction {
		idbyname, recipe, item, forge
	};

	public static ArrayList<ShortItem> itemSuggestor = new ArrayList<ShortItem>();

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

	public static String readUrl(String urlString) throws IOException {
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
		if (name.length() < 3)
			return null;
		name = parseForURL(name);
		String url = gw2url + apiFunction.idbyname + "/" + name;
		System.out.println("Connecting to " + url);
		JSONObject json = new JSONObject();
		JSONParser parser = new JSONParser();
		JSONArray array = null;
		try {
			array = (JSONArray) parser.parse(readUrl(url));
			if (array == null)
				return null;
			while (array.size() > maxArraySize)
				array.remove(array.size());
			// json = (JSONObject) parser.parse(readUrl(url));
			System.out.println("---------------Info sur le JSON--------------");
			System.out.println("ToString : " + array.toJSONString());
			// array = (JSONArray) json.get("results");
			Iterator it = array.iterator();
			JSONObject obj;

		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
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
