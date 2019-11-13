
/**
 * This class holds the object which is my treeMap. This is my data base. 
 */
import java.util.TreeMap; 
import java.util.Iterator; 
import java.util.Map; 
import java.util.*;

public class Treemap
{
    TreeMap<String, ArrayList<URL>> tree; 
    ArrayList<Word> totalWords;

    public Treemap(ArrayList<Word> totalWords){
        this.totalWords = totalWords;
        tree = new TreeMap<String, ArrayList<URL>> ();
    }

    /**
     * @Return true or false if the tree contains a key.
     */
    public boolean printTree(){
        if(tree.containsKey("cats"))
            return true;  
        else{
            return false; 
        }
    }
    

    /**
     * Adds the total words one by one to the treeMap, using the String key and the 
     * ArrayList of URLs specified for each word
     */
    public void addToTree(){
        for(int i=0; i<totalWords.size(); i++){
            //put words in tree
            tree.put(totalWords.get(i).getKey(), totalWords.get(i).getURLlist());
        }
    }

}
