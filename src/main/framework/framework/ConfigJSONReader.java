package framework;

import java.io.FileReader;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ConfigJSONReader {
	
	public ArrayList<String> readJSON() {
		String url = null;
		String user = null; 
		String pwd = null;
		ArrayList<String> completeList = new ArrayList<String>();
		JSONParser parser = new JSONParser();
		try {
			FileReader reader = new FileReader("src/main/resources/configFile.json");
			Object obj = parser.parse(reader);
			JSONObject jsonObject = (JSONObject) obj;
			JSONArray jsonList = (JSONArray) jsonObject.get("data");
			JSONObject data = (JSONObject) jsonList.get(0);
			url = (String)data.get("url");
			user = (String)data.get("username");
			pwd = (String)data.get("password");
			completeList.add(url);
			completeList.add(user);
			completeList.add(pwd);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return completeList;
	}
}
