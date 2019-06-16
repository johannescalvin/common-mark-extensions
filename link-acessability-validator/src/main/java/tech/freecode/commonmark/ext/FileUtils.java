package tech.freecode.commonmark.ext;

import java.io.*;

public class FileUtils {
    public static String  getFileContentFromDisk(File file){
        if(!file.exists()){
            return "";
        }
        StringBuilder builder = new StringBuilder();
        try{
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            String line = null;
            while ((line = reader.readLine()) != null){
                builder.append(line+"\r\n");
            }
            reader.close();

        }catch (IOException ex){
            ex.printStackTrace();
        }
        String str = builder.toString();
        builder = null;
        return str;
    }

    public static String  getFileContentFromDisk(String fileName){
        return getFileContentFromDisk(new File(fileName));
    }
}
