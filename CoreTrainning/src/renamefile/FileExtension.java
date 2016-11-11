package renamefile;
/**
 * 
 */

/**
 * @author Phan Toan
 *
 */
public enum FileExtension {
	HTML (".html", "web-page"),
	TXT (".txt", "text"),
	JPG (".jpg", "photo"),
	JPEG (".jpeg", "photo"),
	PNG (".png", "photo"),
	GIF (".gif", "images"),
	PDF (".pdf", "document"),
	CSS (".css", "style"),
	XLS (".xls", "worksheet"),
	XLSX (".xlsx", "worksheet"),
	GSHEET (".gsheet", "spreadsheet"),
	DOC (".doc", "word"),
	DOCX (".docx", "word"),
	GDOC (".gdoc", "gdocument"),
	PPT (".ppt", "powerpoint"),
	PPTX (".pptx", "powerpoint");
	
	String ext;
	String prefix;
	
	FileExtension(String ext, String prefix) {
		this.ext = ext;
		this.prefix = prefix;
	}
	
	public String getExtension() {
		return this.ext;
	}
	
	public String getPrefix() {
		return this.prefix;
	}
}
