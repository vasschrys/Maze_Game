
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class URLTest.
 */
public class URLTest
{
    @Test 
    public void testCreatePriority(){
        String Url = "cats.com";
        String priority = "high"; 
        String textFile = "www.cats.com"; 

        double pr= .3;
        float pr1 = (float)pr;

        URL url = new URL(Url, priority, textFile);

        url.createPriority();
        System.out.println("P" + url.getPriority());
        assertTrue(url.getPriority()== pr1); 

    }

    @Test
    public void testCreatePriority2(){
        String Url = "cats.com";
        String priority = "low"; 
        String textFile = "www.cats.com"; 

        double pr= .1;
        float pr1 = (float)pr;

        URL url = new URL(Url, priority, textFile);

        url.createPriority();

        assertTrue(url.getPriority()==pr1); 

    }

    @Test 
    public void testcompareTo(){
        String Url = "dogs.com";
        String priority = "medium";
        String textFile = "www.cats.com"; 

        String Url2 = "cats.com";
        String priority2 = "high";
        String textFile2 = "www.animals.com"; 

        URL url2 = new URL(Url,priority,textFile );
        URL url = new URL (Url2,priority2,textFile2); 

        url2.createPriority();
        url.createPriority(); 

        url2.compareTo(url);

        assertEquals(url2.compareTo(url) ,1);
    }

    @Test 
    public void testcompareTo2(){
        String Url = "dogs.com";
        String priority = "high";
        String textFile = "www.cats.com"; 

        String Url2 = "cats.com";
        String priority2 = "high";
        String textFile2 = "www.animals.com"; 

        URL url2 = new URL(Url,priority,textFile );
        URL url = new URL (Url2,priority2,textFile2); 

        url2.createPriority();
        url2.compareTo(url);
        assertEquals(url2.compareTo(url) ,0);
    }

    @Test 
    public void testcompareTo3(){
        String Url = "dogs.com";
        String priority = "high";
        String textFile = "www.cats.com"; 

        String Url2 = "cats.com";
        String priority2 = "low";
        String textFile2 = "www.animals.com"; 

        URL url2 = new URL(Url,priority,textFile );
        URL url = new URL (Url2,priority2,textFile2); 

        url2.createPriority();

        url2.compareTo(url);
        assertTrue(url2.compareTo(url) < 0);
    }

    @Test 
    public void testcompareTo4(){
        String Url = "dogs.com";
        String priority = "high";
        String textFile = "www.cats.com"; 

        String Url2 = "cats.com";
        String priority2 = "low";
        String textFile2 = "www.animals.com"; 

        URL url2 = new URL(Url,priority,textFile );
        URL url = new URL (Url2,priority2,textFile2); 

        url.createPriority(); 

        url2.compareTo(url);
        assertTrue( url2.compareTo(url)<0);

    }

    @Test 
    public void TestaddToPriority(){
        String Url = "dogs.com";
        String priority = "high";
        String textFile = "www.cats.com"; 

        double pr = 1.3; 
        float pr1 = (float)pr; 
        URL url = new URL (Url, priority,textFile); 

        url.createPriority(); 

        url.addToPriority();

        assertTrue(url.getPriority()== pr1); 

    }

    @Test 
    public void TestaddToNegPrioirty(){
        String Url = "dogs.com";
        String priority = "high";
        String textFile = "www.cats.com"; 

        double pr = -99.7; 
        float pr1 = (float)pr; 
        URL url = new URL (Url, priority,textFile); 

        url.createPriority(); 

        url.addToNegPriority();
        System.out.println("neg p" + url.getPriority()); 

        assertTrue(url.getPriority()== pr1); 

    }

}
