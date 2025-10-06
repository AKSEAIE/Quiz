import java.util.Arrays;

public class MCQQuestion implements Question {

    private String question;
    private String[] answers;
    private String correctAnswer;
    
    /**
     * constructor for MCQ question
     * @param question
     * @param answers
     * @param correctAnswer
     */
    public MCQQuestion(String question, String[] answers, String correctAnswer){
        this.question = question;
        this.answers = answers;
        this.correctAnswer = correctAnswer;
    }

    @Override
    /**
     * @return String 
     * getter for string 
     */
    public String getQuestion(){
        return this.question;
    }

    /**
     * setter for question
     * @param newQ
     */
    public void setQuestion(String newQ){
        this.question = newQ;
    }

    /**
     * setter for answer
     * @param newA
     */
    public void setAnswer(String[] newA){
        this.answers = newA;
    }
    @Override 

    /**
     * @return String 
     * getter for correct answer
     */
    public String getCorrectAnswer(){
        return this.correctAnswer;
    }

    /**
     * setter for correct answer
     * @param newCA
     */
    public void setCorrectAnswer(String newCA){
        this.correctAnswer = newCA;
    }

    /**
     * @return String 
     * tostring to output the question and correct answer
     */
    public String toString(){
        return " The question: " + this.question + ", correct answer is: " + this.correctAnswer;
    }

    /**
     * @param obj 
     * @return True if the object is instance of mcq question and has the same question
     * text, answer choices and correct answer or returns false if otherwise.
     */
    public boolean equals(Object obj){
        if (obj instanceof MCQQuestion){
            MCQQuestion other = (MCQQuestion)obj;
            return this.question.equals(other.getQuestion()) && Arrays.equals(this.answers, other.getAllAnswers()) && this.correctAnswer.equals(other.getCorrectAnswer());
        }
        else{
            return false;
        }

    }

    @Override
    /**
     * getter for allanswers 
     * 
     * @return String 
     */
    public String[] getAllAnswers() {
        return this.answers;
    }


    
}
