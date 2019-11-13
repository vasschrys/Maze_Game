
/**
 * This class read in the Text file that contains the list of Commmon words
 * which will not be included in the TreeMap.
 *
 * 
 */
import java.io.*; 
import java.util.*; 

public class FileReader2
{
    private ArrayList<String> wordsList; 
    private String commonWord; 
    FileReader2(String commonWord){
       this.commonWord = commonWord;
       commonWordFile(); 
    }
    
    /** 
     * Reads in the common word File and stores the words in an arrayList called 
     * wordsList
     */
    public void commonWordFile(){
        //stores arrayList of Common words
        wordsList= new ArrayList<String>();

        try{

            //scan-in commonWordfile
            FileReader reader2 = new FileReader(commonWord);
            Scanner commonwordFile = new Scanner(reader2); 

            while(commonwordFile.hasNext()){
                String word = commonwordFile.next();
                //adds lists or words to arrayList

                wordsList.add(word);
            }
        }catch(Exception e){
            System.out.println("could not read file"); 
            System.out.println(e);
        }
    } 
    
    /**
     * Getter method for the private arrayList of commonWords
     * @Return arrayList of commmonWords
     */
    public ArrayList<String> getwordsList(){
        return wordsList;
    }
}
