package renamefile;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author Phan Toan
 *
 */
public class RenameFile {

	/**
	 * @param args
	 */

	static int totalFile = 0;
	static int renamedFile = 0;

	public static void main(String[] args) {
		Scanner keyboard;
		String folderPath;
		String[] fileFilter = null;
		do {
		System.out.println("Input absolute folder path:");
		keyboard = new Scanner(System.in);
		folderPath = keyboard.nextLine();
		} while (folderPath.isEmpty());
		
		System.out.println("Input file type:");
		String tmp = keyboard.nextLine();
		if (!tmp.isEmpty()) {
			fileFilter = tmp.toUpperCase().split(" ");
		}

		System.out.println("START PROCESS:");
		System.out.println("--------------------");
		renameAllFileInPath(folderPath, fileFilter);
		System.out.println("--------------------");
		System.out.println("PROCESS COMPLETE!");
		System.out.println("Number of renamed file: " + renamedFile + "/" + totalFile);

		keyboard.close();
	}

	/*
	 * rename all file in folder and subfolders to pattern decleared in
	 * FileExtension
	 * 
	 * @param folderPath String
	 * 
	 * @param filetyle Array of String
	 */

	private static void renameAllFileInPath(String folderPath, String[] filetype) {
		Map<FileExtension, Integer> indexMap = new HashMap<>(); 
		File folder = new File(folderPath);

		for (File fileEntry : folder.listFiles()) {
			String oldFileName = fileEntry.getName();
			String fileExtension = oldFileName.substring(oldFileName.lastIndexOf(".") + 1).toUpperCase();

			if (fileEntry.isDirectory()) {
				String subFolderPath = folderPath + "/" + oldFileName;
				renameAllFileInPath(subFolderPath, filetype);
			} else if (filetype == null || Arrays.asList(filetype).contains(fileExtension)) {
				System.out.println("Start rename file: " + fileEntry.getName());
				totalFile++;

				try {
					FileExtension ext = FileExtension.valueOf(fileExtension.toUpperCase());

					if (indexMap.get(ext) == null) {
						indexMap.put(ext, 0);
					}
					int index = indexMap.get(ext);
					File newFile = new File(folderPath + "/" + ext.prefix + index++ + ext.ext);

					if (fileEntry.renameTo(newFile)) {
						System.out.println("File " + oldFileName + " has been renamed to " + newFile.getName());
						renamedFile++;
						indexMap.put(ext, index);
					} else {
						System.out.println("Rename " + oldFileName + " failed!");
					}

				} catch (Exception e) {
					System.out.println("Extension " + fileExtension + " not declared yet");
				}
			}
		}
	}
}
