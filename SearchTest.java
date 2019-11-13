

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class SearchTest.
 *
 */
public class SearchTest

{
    @Test 
    public void testsplitWords(){
        InputFile inputfile  = new InputFile("testURL.txt", "commonWords.txt");
        
        Treemap tm = inputfile.tm; 
        String userInput = "boy"; 
        
        Search s = new Search(tm, userInput); 
        assertTrue(s.checkContains(userInput) == false);
        
    }
    
    @Test 
    public void testsplitWords2(){
        InputFile inputfile  = new InputFile("testURL.txt", "commonWords.txt");
        Treemap tm = inputfile.tm; 
        String userInput = "test"; 
        
        Search s = new Search(tm, userInput); 
        
        assertFalse(s.checkContains("test") ==true);
        
    }
    
}
