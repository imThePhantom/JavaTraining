/**
 * 
 */
package collection;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Phan Toan
 *
 */
public class Dictionary {
	private Map<Key, Object> dictionary = new HashMap<>();

	/**
	 * @param dictionary
	 */

	public Object get(Object k1, Object k2) {
		Key key = new Key(k1, k2);
		return dictionary.get(key);
	}

	public Object put(Object k1, Object k2, Object value) {
		Key key = new Key(k1, k2);
		return dictionary.put(key, value);
	}

	public boolean containKet(Object k1, Object k2) {
		Key key = new Key(k1, k2);
		return dictionary.containsKey(key);
	}
}