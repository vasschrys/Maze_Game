

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class FileReader2Test.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class FileReader2Test
{
   @Test 
   public void testCommonWordFile(){
       FileReader2 f = new FileReader2("commonWords.txt"); 
       
       String word = f.getwordsList().get(0);
       String expectedW = "i";
       
    }
    
    @Test 
    public void testCommonWordFile2(){
        FileReader2 f = new FileReader2("commonWords.txt"); 
       
       String word = f.getwordsList().get(5);
       String expectedW = "as";
        
    }
}
