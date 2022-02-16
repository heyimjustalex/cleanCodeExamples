package BetterCode;

import BetterCode.Readers.FileReader;
import BetterCode.Structures.Tuple;
import BetterCode.Writers.FileWriter;
import BetterCode.Writers.PdfWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MyCustomFilesCreator
{

    public static void createCustomFiles(String fileToRead, List<String> myWordsAsInput) throws IOException
    {
        List<String> listOfReadStrings = FileReader.readFile(fileToRead);
        String readFileContent = combineListIntoString(listOfReadStrings);
        String inputWordsContent = combineListIntoString(myWordsAsInput);

        FileWriter.generateFile("outputFile", "txt",readFileContent+inputWordsContent);

        PdfWriter pdfWriter = new PdfWriter("outputPDF");
        pdfWriter.addParagraph(readFileContent+inputWordsContent);
        pdfWriter.addMetaInfo("TITLEEEE_TEST",new Tuple("KEYHERE","VALUEHERE"));
        pdfWriter.closeDocument();

    }

    public static String combineListIntoString(List<String> input)
    {
        String combinedString = "";
        for (String str:
                input) {
            combinedString += str+'\n';
        }

        return combinedString;
    }

    public static void generateALotOfFiles()
    {
        List<String> myWordsToSave = new ArrayList<>(5);
        myWordsToSave.add("Test1");
        myWordsToSave.add("Test2");

        for (Integer i=0;i<10000;i++)
        {
            String s = Integer.toString(i);
            try
            {
                MyCustomFilesCreator.createCustomFiles("input"+s+".txt", myWordsToSave);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }

}
