package util;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Locale;
import java.util.ResourceBundle;
import org.springframework.stereotype.Component;

@Component
public class LanguageHelper {

	public HashMap<String, String> getLocalLanguageName(Class<?> className, Locale locale) {
		ResourceBundle labels = ResourceBundle.getBundle("messages", locale);
		HashMap<String, String> map = new HashMap<String, String>();
		for (String s : labels.keySet()) {
			if (s.contains(className.getSimpleName() + ".option")) {
				String key = s.substring(s.indexOf(".option")+8);
				
				try {
					map.put(key, new String(labels.getString(s).getBytes("ISO-8859-1"), "UTF-8"));
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return map;
	}
}
