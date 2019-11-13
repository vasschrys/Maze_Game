
/**
 * This InputFile class takes in textFiles that is passed in through the main
 * and sorts through each word in the textFiles.
 */
import java.util.*;
import java.io.File;
import java.util.Scanner; 
import java.io.FileReader;
public class InputFile
{
    String config; 
    FileReader2 file2;
    private ArrayList<Word> totalWords;
    private ArrayList<URL> firstUrlList; 
    URL url;
    Word w;
    Treemap tm; 
    private String urlName;
    private String priority;
    private String textFile;

    InputFile(String configFile, String commonWord){
        
        this.config = configFile;  
        file2 = new FileReader2(commonWord); 
        firstUrlList = new ArrayList<URL>();         
        totalWords = new ArrayList<Word>(); 
        
        readUrls();
        readTextFile();
        tm = new Treemap(totalWords);
        

    }

    
    /**
     * Reads  in the first line of the textFile and sets the varibales 
     * urlName, prioirty, and textFile, to the correct index
     */
    public void readUrls(){
        try{
            FileReader reader = new FileReader(config); 
            Scanner Inputfile1 = new Scanner(reader); 
            while(Inputfile1.hasNextLine()){
                //read the first line
                String [] inputConfig = Inputfile1.nextLine().split(" "); 

                urlName = inputConfig[0]; 
                priority = inputConfig[1];
                textFile = inputConfig[2];

                //create URL 
                url = new URL(urlName, priority, textFile);
                firstUrlList.add(url); 
            }
        }catch(Exception e){
            System.out.println(e); 
        }

    }
    
    /**
     * Reads in the "websites" that holds the textfile information to all the 
     * websites. 
     * Filters through the commons words and textfile to remove any common words 
     * when ading the totalWords to the arrayList. 
     */
    public void readTextFile(){
        try{
            for(int i=0; i<firstUrlList.size(); i++){
                FileReader reader = new FileReader(firstUrlList.get(i).getTextFile());

                Scanner textFile = new Scanner(reader); 

                while(textFile.hasNext()){

                    //gets words in the textFile 
                    String textWord = textFile.next();

                    //replaces all uppercase letter to lower case and removes all punctuation
                    String [] splitline = textWord.replaceAll("[^a-zA-Z ]", "").toLowerCase().split(" ");
                    for(String word : splitline){

                        if(!file2.getwordsList().contains(word)){
                            Word w = new Word(word);
                            if(totalWords.size()==0){
                                totalWords.add(w);

                            }
                            for(int j = 0; j<= totalWords.size(); j++){
                                
                                if(totalWords.get(j).getKey().equals(w.getKey())){
                                    totalWords.get(j).addURL(firstUrlList.get(i));

                                    break;
                                }
                                else if(j == totalWords.size()-1){
                                    w.addURL(firstUrlList.get(i));

                                    totalWords.add(w);
                                }
                            }
                        }
                    }
                }
            }
        }catch(Exception e){
            System.out.println(e);
        }

    }
    
    public ArrayList<URL> getfirstUrlList(){
        return firstUrlList; 
    }
    
    /**
     * @Return- a String for the name of the URl 
     */
    public String getUrlName(){
        return urlName;
    }
    
    /**
     * @Return - an arrayList of object Word
     * This method returns the private arrayList of Words
     */
    public ArrayList<Word> getTotalWords(){
        return totalWords; 
    }

}
