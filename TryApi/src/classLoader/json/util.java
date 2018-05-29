package classLoader.json;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class util {
	
	/*public static <T> String getResourceFilePath(Class<T> getClassObject, String fileName) {
		String absoluteFile = "";
		ClassLoader classLoader = getClassObject.getClassLoader();

		try {
			absoluteFile = classLoader.getResource(fileName).getFile();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return absoluteFile;
	}
	
	public static <T> T load(String sourceFile, String caseName, Class<T> clazz) {
		String jsonData = ReadJsonFile(sourceFile).get(caseName).toString();

		return deserialize(jsonData, clazz);
	}
	
	public static JSONObject ReadJsonFile(String filePath) {

		// Get file from resources folder

		JSONParser parser = new JSONParser();
		JSONObject jsonObject = null;
		try {
			Object obj = parser.parse(new FileReader(filePath));

			jsonObject = (JSONObject) obj;

			// loop array
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (org.json.simple.parser.ParseException e) {
			e.printStackTrace();
		}
		return jsonObject;
	}
	
	public static <T> T deserialize(String json, Class<T> clazz) {
		Gson gson = new Gson();
		T model = gson.fromJson(json, clazz);

		return model;
	}
*/
}
