import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class Main {

    /**
     * 
     * @param args
     */
    public static void main(String[] args) {
        int score = 0;
        try{
        Scanner scan = new Scanner(System.in);
        FileReader fr = new FileReader("questionsBase.txt");
        BufferedReader br = new BufferedReader(fr);
        String line = br.readLine();
        while(line != null){//while first line isnt empty
            if(line.endsWith("(T/F)")){//Determine if the question is a true or false, or mcq question
                TFQuestion tf = new TFQuestion(line, br.readLine().split(","), br.readLine()); //Instantiate TF question, and place the parameter, the second parameter we split into an array.
                System.out.println(tf.getQuestion());
                for(String answer: tf.getAllAnswers()){
                    System.out.println(answer);
                }
                String value = scan.nextLine();
                if (value.equals(tf.getCorrectAnswer())){
                    score++;
                }

            }
            else{//Otherwise it must be a MCQ
                MCQQuestion mc = new MCQQuestion(line, br.readLine().split(","), br.readLine());//Instantiate the MCQ while also reading the next line(answer options), and the line after(the correct answer)
                System.out.println(mc.getQuestion());
                for(String answer: mc.getAllAnswers()){
                    System.out.println(answer);
                }
                String value = scan.nextLine();
                String correctLetter = mc.getCorrectAnswer().split(":")[0];
                if (value.equals(correctLetter)){
                    score++;
                }
            }
            br.readLine();//Skips null line
            line = br.readLine();//Renters new line(questiosn)


            }
            br.close();
            scan.close();
            System.out.println(score + "/10");
        }
        catch (FileNotFoundException e){
            System.out.println("Error");
        }
        catch(IOException m){
            System.out.println("Error");
        }


    }
}
