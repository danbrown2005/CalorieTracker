import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.nio.file.Paths;

public class fileController {

    public ArrayList<String> readFile(String dir){
        Scanner reader = null;
        try {
            reader = new Scanner(Paths.get(dir));
        } catch (IOException ignored) {
            return new ArrayList<String>();
        }
        ArrayList<String> data = new ArrayList<>();

        while (reader.hasNextLine()){

            data.add(reader.nextLine());
        }
        return data;
    }

    public ArrayList<String[]> formatFileData(ArrayList<String> data){
        ArrayList<String[]> formattedData = new ArrayList<>();
        for (String string : data){
            formattedData.add(string.split(","));
        }

        return formattedData;
    }

    public boolean fileExists(String directory){
        try{
            File file = new File(directory);
            return file.isFile();
        }catch (Exception e){
            return false;
        }
    }

    public boolean writeToFile(String directory, String data){
        if (!fileExists(directory)){
            return false;
        }
        try{
            ArrayList<String> currentContents = readFile(directory);
            FileWriter writer = new FileWriter(directory);
            PrintWriter printWriter = new PrintWriter(writer);
            for (String string : currentContents){printWriter.println(string);}
            printWriter.println(data);
            printWriter.close();
            return true;
        } catch(IOException e){
            return false;
        }
    }


}
