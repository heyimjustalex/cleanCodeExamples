package BetterCode.Readers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReader
{
    public static List<String> readFileToSingleString(String filePath) throws IOException
    {
        File file = new File(filePath);
        BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(file));
        String str;
        List<String> listOfReadStrings = new ArrayList<>();

        while ((str = bufferedReader.readLine()) != null)
        {
            listOfReadStrings.add(str);
        }

        return listOfReadStrings;
    }

    public static List<String> readFile(String filePath)
    {
        List<String> listOfReadStrings = null;
       try
       {
           listOfReadStrings = readFileToSingleString(filePath);
       }
       catch (FileNotFoundException e)
       {
           System.out.println("There is no such file");
           e.printStackTrace();
       }
       catch (IOException e)
       {
           System.out.println("Reading file error");
           e.printStackTrace();
       }

       return listOfReadStrings;
    }

}

