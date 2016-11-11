package renamefile;
import java.io.File;
import java.io.FilenameFilter;

/**
 * 
 */

/**
 * @author Phan Toan
 *
 */
public class ExtFilter implements FilenameFilter {

	/* (non-Javadoc)
	 * @see java.io.FilenameFilter#accept(java.io.File, java.lang.String)
	 */
	private String ext;
	File dir;
	
	public ExtFilter (File dir, String ext) {
		this.dir = dir;
		this.ext = ext;
	}
	
	@Override
	public boolean accept(File dir, String name) {
		return (name.endsWith(ext));
	}

}
