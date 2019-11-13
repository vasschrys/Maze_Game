
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*; 

/**
 * The test class InputFileTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class InputFileTest
{
    @Test 
    public void testReadURLS(){
        InputFile input = new InputFile("testURL.txt", "commonWords.txt");
        String urlName = input.getfirstUrlList().get(0).getURL();
        String expectedURL = "www.test.com"; 

        assertTrue(urlName.equals(expectedURL)); 

    }

    @Test 
    public void testReadurls2(){
        InputFile input = new InputFile("testURL.txt", "commonWords.txt");

        String textFile = input.getfirstUrlList().get(0).getTextFile();
        String expectedFile = "JunitTest.txt";

        assertTrue(textFile.equals(expectedFile)); 

    }

    @Test 
    public void testReadURl3(){
        InputFile input = new InputFile("testURL.txt", "commonWords.txt");
        String prioirty =input.getfirstUrlList().get(0).getP();
        String expectedPrioirty = "high";

        assertTrue(prioirty.equals(expectedPrioirty)); 
    }
    
    @Test 
    public void readTextFile(){
       InputFile input = new InputFile("testURL.txt", "commonWords.txt");
       
       String word =input.getTotalWords().get(0).getKey(); 
       System.out.println(input.getTotalWords().get(0).getKey()); 
       String expectedW = "test";
       
       assertTrue(word.equals(expectedW)); 
       
       
    }
}
