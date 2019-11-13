
/**
 * This search Class takes in UserInput and interprets it in the below methods
 */
import java.util.*;
import java.util.TreeMap;
public class Search
{
    ArrayList<String> noNegation; 
    ArrayList<String> negation;
    ArrayList<URL> printUrlList;
    ArrayList<URL> finalUrl ;
    float endPriority;
    Treemap tm;
    String userInput; 
    PriorityQueue <URL> priorityQ;

    Search(Treemap tm, String userInput){
        this.tm = tm; 
        this.userInput = userInput; 
        noNegation = new ArrayList<String> (); 
        negation = new ArrayList<String> (); 

        priorityQ = new PriorityQueue <URL>(); 
        printUrlList = new ArrayList<URL>(); 

        finalUrl = new ArrayList<URL>(); 

        checkSplitWords(userInput);

        addToPrioirty(finalUrl); 
        //Print out priority Queue 
        while(!priorityQ.isEmpty()){
            System.out.println(priorityQ.remove()); 
        }

    }

    /**
     * @Param - a String of what the user enters into the command line
     * reads whether or not the user inputted the word "or"
     */
    public void checkSplitWords(String userInput){
        //if search contains the word "or"
        if(userInput.contains("or ")){
            orPriority(userInput);

        }
        else if(!userInput.contains(" or ")){
            andPriority(userInput); 

        }
    }

    /**
     * @param- String of what the user has entered
     * if the user has not put the word or in, the string immediately comes here
     * This method splits up the string by the word "and" and analyzes each word
     */
    public void andPriority(String s){
        //split by the word and
        String[] splitHalf = s.split(" and ");
        for(int i=0; i<splitHalf.length; i++){
            //doesnt have negation an is in the tree
            if(checkNegation(splitHalf[i]) ==false){
                if(checkContains(splitHalf[i])==true){
                    findURL(splitHalf[i]);

                } else{
                    //if word not found
                    System.out.println("words not found"); 
                }

            }
            else if(checkNegation(splitHalf[i]) ==true){
                //checkNegation is TRUE
                findNegURL(negation.get(i));

            }
        }
        AddtoFirstURlList();

    }

    /**
     * @Param - the string of the user input
     * if the user has inputted the word "or" the string immediately comes here
     * if the stirng contains the word and then the method brings the string 
     * to the andPriority method. 
     */
    public void orPriority(String userInput){
        //split input up by "or" and turn everything to lowerCase
        String[] split = userInput.toLowerCase().split(" or ");

        //get String between or
        for(String s2: split){
            //check if one half contains "and"
            if(s2.contains("and")){
                andPriority(s2); 
            }
            //if no "and"
            else{              
                if(checkNegation(s2) ==false){
                    if(checkContains(s2)==true){
                        findURL(s2);
                    }else{
                        System.out.println(s2 + "word not found"); 
                    }
                }else{
                    break;                    
                }
            }           
        }
        AddtoFirstURlList();

    }

    /**
     * @Param - String of a single word that comes in from the andPriority or orPriority
     * method. 
     * @Return - boolean - true if the tree contains the word, false if it doesn't
     */

    public boolean checkContains(String w){
        if(tm.tree.containsKey(w)){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * @Param - String of a single word that comes in from the andPriority or orPriority
     * method. 
     * @Return - boolean - true if the word contians a negation symbol, false if it
     * doesnt. 
     * The method also checks if the tree contains the word after it takes out the 
     * negation sign. 
     * 
     */
    public boolean checkNegation(String s){
        if(s.contains("-")){
            //add to string array negation
            negation.add(s.substring(1)); 
            if(checkContains(s.substring(1))==true){
                return true; 
            }
            return true; 
        }
        else{
            //add to string array not-negation
            noNegation.add(s);
            return false; 
        }
    }

    /**
     * @Param - String of a single word that comes in from the andPriority or orPriority
     * method. 
     * This method find the URls that correspond to that word in the tree map if the
     * word did not contain a negation sign and adds it to an arrayList
     */
    public void findURL(String s){ 
        for(int i=0; i<tm.tree.get(s).size(); i++){
            //call method to add to priority
            tm.tree.get(s).get(i).addToPriority();

            //add to printList arrayList
            printUrlList.add(tm.tree.get(s).get(i)); 
        }        
    }

    /**
     * @Param - String of a single word that comes in from the andPriority or orPriority
     * method.
     * This method find the URls that correspond to that word in the tree map if the
     * word did contain a negation sign ,and adds it to an arrayList.
     */

    public void findNegURL(String s){
        for(int i=0; i<tm.tree.get(s).size(); i++){ 
            //calls method to add to URL prioirty (with negation)
            tm.tree.get(s).get(i).addToNegPriority();

            //add to the printurlList
            printUrlList.add(tm.tree.get(s).get(i)); 
        }
    }

    /**
     * This method checks if the prioirty of the URL is greater than the amount of 
     * non-negation words that were entered between an and sign. If that is true
     * it adds that word to an arrayList of FinalUrls. 
     * If the priority of the URL is less than the amount of non-negation words, it 
     * means that the word was a negation word. or was not in both URls, so it does 
     * not add that URL to the list 
     */
    public void AddtoFirstURlList(){
        for(int j=0; j<printUrlList.size(); j++){
            if(printUrlList.get(j).getPriority() > noNegation.size()){
                //check if URL is already in the list
                if(!finalUrl.contains(printUrlList.get(j))&&
                printUrlList.get(j).getPriority() > noNegation.size() ){
                    //add to final URl List
                    finalUrl.add(printUrlList.get(j)); 
                }else{
                    continue;
                }
            }else{
                continue; 
            }
        }

    }

    /**
     * This method takes an arrayList and adds it to a prioirtyQueue. 
     */
    public void addToPrioirty(ArrayList<URL> a){
        for(int i=0; i<a.size(); i++){
            priorityQ.add(a.get(i));
        }
    }

}
