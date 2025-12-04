package activities;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

import org.apache.commons.io.FileUtils;

public class Activity14 {

	public static void main(String[] args) {
		try {
            File file = new File("src/main/resources/dummyFile.txt");
            boolean fStatus = file.createNewFile();
            if(fStatus) {
                FileUtils.writeStringToFile(file, "This is activity 14. To read and write files", Charset.defaultCharset());
            } else {
                System.out.println("File already exists, no changes made");
            }
 
            System.out.println("Reading the data from the file: \n" + FileUtils.readFileToString(file, "UTF8"));
 
            File destDir = new File("src/main/resources/destDir");
            FileUtils.copyFileToDirectory(file, destDir);
            
            File newFile = FileUtils.getFile(destDir, "dummyFile.txt");
            String newFileData = FileUtils.readFileToString(newFile, "UTF8");
            System.out.println("Reading the data in the copied file: \n" + newFileData);
            
        } catch(IOException e) {
            System.out.println(e.getMessage());
        } 

	}

}
