package Core;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
 
import java.io.FileReader;
import java.util.Iterator;
 

public class PropertyReader {
	
		@SuppressWarnings("unchecked")
		public static String getProperty(String key ) {
			JSONParser parser = new JSONParser();
			String property= "";
			try {
				Object obj = parser.parse(new FileReader("src/test/resources/Config.json"));
	 
				
				JSONObject jsonObject = (JSONObject) obj;
	 
				
				 property    = (String) jsonObject.get(key);
			
	 
			} catch (Exception e) {
				e.printStackTrace();
			}
			return property;
			
		}
	
	

}
