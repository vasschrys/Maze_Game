
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*; 

/**
 * The test class WordTest.
 */
public class WordTest
{
    @Test 
    public void testaddURL(){
        Word w = new Word("cats"); 
        ArrayList<URL> u = new ArrayList<URL> (); 

        String Url = "animals.com";
        String priority = "high";
        String textFile = "www.cats.com"; 
        URL url = new URL (Url, priority,textFile); 

        assertTrue(w.addURL(url)==true); 
    }
    @Test 
    public void testadURl(){
        Word w = new Word("cats"); 
        ArrayList<URL> u = new ArrayList<URL> (); 

        String Url2 = "cats.com";
        String priority2 = "low";
        String textFile2 = "www.animals.com"; 
        URL url2 = new URL (Url2,priority2,textFile2); 

        w.addURL(url2); 
        assertTrue (w.addURL(url2) ==false); 
    }

    @Test 
    public void tesaddURL3(){
        Word w = new Word("cats"); 
        ArrayList<URL> u = new ArrayList<URL> (); 

        String Url2 = "cats.com";
        String priority2 = "low";
        String textFile2 = "www.animals.com"; 
        URL url2 = new URL (Url2,priority2,textFile2); 

        String Url3 = "animals.com";
        String priority3 = "high";
        String textFile3 = "www.cats.com"; 
        URL url3 = new URL (Url3, priority3,textFile3); 

        w.addURL(url2); 
        w.addURL(url3); 

        assertTrue(w.addURL(url3)==false); 
        
    }
    
}
