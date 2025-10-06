import java.util.ArrayList;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Random;

public class QuizQuestions {
    private ArrayList<Question> allQuestions;
    private ArrayList<Question> selectedQuestions;

    /**
     * constructor for quizquestions
     * @param allQuestions
     * @param selecQuestions
     */
    public QuizQuestions(ArrayList<Question> allQuestions, ArrayList<Question> selecQuestions){
        this.allQuestions = allQuestions;
        this.selectedQuestions = selecQuestions;
    }


    /**
     * getter for array list
     * @return ArrayList
     */
    public ArrayList<Question> getAllQuestions() {
        return this.allQuestions;
    }

    /**
     * setter for all questions
     * @param allQuestions
     */
    public void setAllQuestions(ArrayList<Question> allQuestions) {
        this.allQuestions = allQuestions;
    }

    /**
     * getter for ArrayList 
     * @return ArrayList
     */
    public ArrayList<Question> getSelectedQuestions() {
        return selectedQuestions;
    }

    /**
     * setter for selected questions
     * @param selectedQuestions
     */
    public void setSelectedQuestions(ArrayList<Question> selectedQuestions) {
        this.selectedQuestions = selectedQuestions;
    }

    /**
     * 
     * @param filename
     * @throws IOException
     */
    public void load(String filename) throws IOException{
        FileReader fr = new FileReader(filename);//Instantiate Filereader
        BufferedReader bf = new BufferedReader(fr);//Instantiate Buffered Reader
        String line = bf.readLine();//Make a variable containing the the first line of the file(question)
        while(line != null){//while first line isnt empty
            if(line.endsWith("(T/F)")){//Determine if the question is a true or false, or mcq question
                TFQuestion tf = new TFQuestion(line, bf.readLine().split(","), bf.readLine()); //Instantiate TF question, and place the parameter, the second parameter we split into an array.
                this.allQuestions.add(tf);}//After creation of the tf question add it to the allQuestion list

            else{//Otherwise it must be a MCQ
                MCQQuestion mc = new MCQQuestion(line, bf.readLine().split(","), bf.readLine());//Instantiate the MCQ while also reading the next line(answer options), and the line after(the correct answer)
                this.allQuestions.add(mc);//Adds it to all questions

            }
            bf.readLine();//Skips null line
            line = bf.readLine();//Renters new line(questiosn)


        }       
    bf.close();//Close both readers
    fr.close();
}

        




/**
 * 
 * @param numberOfQuestions
 */
public void select(int numberOfQuestions){
    Random rand = new Random();//Instantiate a random object
    ArrayList<Integer> arr = new ArrayList<>();//Create new list
    for(int i = 0; i<numberOfQuestions;i++){//For loop based around number of questions picked
        int val = rand.nextInt(this.allQuestions.size());//pick a random value, and the bound is the number of questions in the list of questions
        while(arr.contains(val)){//This while loop prevents questions from being duplicated
            val = rand.nextInt(this.allQuestions.size());

        }
        arr.add(val);//otherwise it adds them to the array
        this.selectedQuestions.add(this.allQuestions.get(val));//afterwards it add the questions from the allquestions list to the selectedquestions list
    }
}


        
    
    /**
     * 
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
  
    }
}
    
