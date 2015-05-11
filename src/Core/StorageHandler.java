package Core;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.FileSystem;
import java.util.Scanner;

import javax.swing.filechooser.FileSystemView;

public class StorageHandler {
	public static String storageEmplacement = "";
	public enum files {search, other};
	
	public StorageHandler() throws IOException{
		FileSystemView fsv = FileSystemView.getFileSystemView();
		File mydocs = fsv.getDefaultDirectory();
		storageEmplacement += mydocs.getAbsolutePath()+File.separator+"GW2Storage"+File.separator;
		System.out.println("Inititalize storage emplacement to : "+storageEmplacement);
		File file = new File(storageEmplacement);
		if(!file.exists())
			file.createNewFile();
	}
	
	public void saveSearch(String name, String id) throws IOException{
		File f = new File(storageEmplacement+files.search);
		Scanner sc = new Scanner(f);
		String exist = sc.findInLine(id+";"+name);
		sc.close();
		if(exist != null)
			return ;
		FileWriter fw = new FileWriter(f);
		fw.write(id+";"+name+"\n");
		
		fw.close();
		
	}
}
