/**
 * 
 */
package collection;

/**
 * @author Phan Toan
 *
 */
public class Key {
	Object k1;
	Object k2;

	/**
	 * @param k1
	 * @param k2
	 */
	public Key(Object k1, Object k2) {
		super();
		this.k1 = k1;
		this.k2 = k2;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Key))
			return false;
		Key key = (Key) obj;
		return k1 == key.k1 && k2 == key.k2;
	}

	@Override
	public int hashCode() {
		return k1.hashCode() ^ k2.hashCode();
	}
}