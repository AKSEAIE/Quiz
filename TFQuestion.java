public class TFQuestion implements Question {
    private String question;
    private String[] answers;
    private String correctAnswer;

    /**
     * constructor for TFquestion
     * @param question
     * @param answers
     * @param correctAnswer
     */
    public TFQuestion(String question,String[] answers,String correctAnswer){
        this.question = question;
        this.answers = new String[]{"True", "False"};
        this.correctAnswer = correctAnswer;
    }

    /**
     * getter for question
     * @return String 
     */
    public String getQuestion() {
        return this.question;
    }

    /**
     * setter for question
     * @param question
     */
    public void setQuestion(String question) {
        this.question = question;
    }

    /**
     * setter for answers 
     * @param answers
     */
    public void setAnswers(String[] answers) {
        this.answers = answers;
    }

    /**
     * getter for correct answer 
     * @return String
     */
    public String getCorrectAnswer() {
        return this.correctAnswer;
    }

    /**
     * setter for correct answer
     * @param correctAnswer
     */
    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
    
    /**
     * tostring returns the question and correct answer 
     */
    public String toString(){
        return "The question: " + this.question + ", correct answer is: " + this.correctAnswer;
    }

    @Override
    /**
     * @return array of String 
     */
    public String[] getAllAnswers() {
        return this.answers;
    }


    
}
