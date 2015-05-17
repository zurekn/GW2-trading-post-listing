package test;

import java.beans.Statement;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import Core.Data;

public class databaseImportation {

	public static void main(String[] args) throws ParseException, IOException {

		// Connection BDD
		Connection connect;
		java.sql.Statement statement = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String host = "jdbc:mysql://192.168.1.17/gw2";
			String database = "gw2";
			String password = "";
			String user = "root";
			connect = DriverManager.getConnection(host, user, password);
			statement = connect.createStatement();
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(0);
		}

		JSONArray items;
		JSONParser parser = new JSONParser();
		String txtItems = Data.readUrl(Data.GW2_OFFICIAL_API + "/items");
		System.out.println(txtItems);
		items = (JSONArray) parser.parse(txtItems);

		Iterator it = items.iterator();

		String csvDelimiter = ";";
		String csvLineSeparator = "\n";
		String csvHeader = "item_id;item_eng_name;item_fr_name;item_type;item_icon;item_salable";

		File csv = new File("items.csv");
		if (!csv.exists())
			csv.createNewFile();

		FileWriter fw = new FileWriter(csv);
		fw.append(csvHeader);
		fw.append(csvHeader);

		while (it.hasNext()) {
			Long id = (Long) it.next();
			JSONObject eng = (JSONObject) parser.parse(Data
					.readUrl(Data.GW2_OFFICIAL_API + "/items/" + id));

			JSONObject fr = (JSONObject) parser.parse(Data
					.readUrl(Data.GW2_OFFICIAL_API + "/items/" + id
							+ "?lang=fr"));

			String engName = (String) eng.get("name");
			String frName = (String) fr.get("name");
			frName = new String(frName.getBytes(), "UTF-8");
			String type = (String) eng.get("type");
			String icon = (String) eng.get("icon");
			Boolean sell = true;
			if (eng.containsKey("flags")) {
				JSONArray array = (JSONArray) eng.get("flags");
				if (array.contains("NoSell"))
					;
				sell = false;
			}

			if (engName == null || engName.equals("") || frName == null
					|| frName.equals(""))
				System.err.println("Une des valeurs est vide pour l'id [" + id
						+ "]");

			System.out.println(id + ",  " + engName + ", " + frName + ", "
					+ type + ", " + sell);
			String out = "" + id + csvDelimiter + engName + csvDelimiter
					+ frName + csvDelimiter + type + csvDelimiter + icon
					+ csvDelimiter + sell;
			fw.append(out);
			fw.append(csvLineSeparator);
			String query = "INSERT INTO `u885950292_gw2`.`items` (`item_id`, `item_eng_name`, `item_fr_name`, `item_type`, `item_icon`, `item_salable`) VALUES ('"
					+ id
					+ "', '"
					+ engName
					+ "', ''"
					+ frName
					+ "', ''"
					+ type
					+ "', ''" + icon + "', ''" + sell + "');";
			fw.flush();
			// statement.executeQuery(query);
		}
		fw.close();
	}
}
