

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*; 
/**
 * The test class TreemapTest.
 */
public class TreemapTest
{
    @Test 
    public void testAddToTree(){
        InputFile inputfile  = new InputFile("testURL.txt", "commonWords.txt");
        Treemap tm = new Treemap(inputfile.getTotalWords()); 
        Word w = new Word("test");

        String Url2 = "test.com";
        String priority2 = "low";
        String textFile2 = "JUnitTest.txt"; 
        
        URL url2 = new URL (Url2,priority2,textFile2); 
        
        
        w.addURL(url2); 
        
        tm.addToTree(); 
        
        assertEquals(true, tm.tree.containsKey("test"));

    }
    
     @Test 
    public void testAddToTree2(){
        InputFile inputfile  = new InputFile("testURL.txt", "commonWords.txt");
        Treemap tm = new Treemap(inputfile.getTotalWords()); 
        Word w = new Word("cats");

        String Url2 = "test.com";
        String priority2 = "low";
        String textFile2 = "JUnitTest.txt"; 
        
        URL url2 = new URL (Url2,priority2,textFile2); 
        
        
        w.addURL(url2); 
        
        tm.addToTree(); 
        
        assertEquals(false, tm.tree.containsKey("cats"));
 
    }
    
}
