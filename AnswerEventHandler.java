import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class AnswerEventHandler implements EventHandler<ActionEvent>{   

        private String correctAnswer;
        private Button bn;
        private VBox vb;
        
        /**
         * 
         * @return Button
         */
        public Button getBn() {
            return bn;
        }
        
        /**
         * 
         * @param bn
         */

        public void setBn(Button bn) {
            this.bn = bn;
        }
        
        /**
         *  Getter for vb
         * @return VBox
         */
        public VBox getVb() {
            return vb;
        }
        
        /**
         * setter for vb
         * @param vb
         */

        public void setVb(VBox vb) {
            this.vb = vb;
        }
        
        /**
         * getter for correct answer
         * @return String 
         */

        public String getCorrectAnswer() {
            return correctAnswer;
        }

        /**
         * setter for correct answer
         * @param correctAnswer
         */
        public void setCorrectAnswer(String correctAnswer) {
            this.correctAnswer = correctAnswer;
        }

        /**
         * Constructor for the answer event handler 
         * @param bn
         * @param vb
         * @param correctAnswer
         */
        public AnswerEventHandler(Button bn, VBox vb, String correctAnswer){

            this.bn = bn;
            this.vb = vb;
            this.correctAnswer = correctAnswer;
}
    
    @Override
    /**
     * Handles the action even when the user selects an answer
     * Updates the GUI to display the selceted answer and modifies the score
     * 
     * @param arg0 
     * 
     * 
     */

    public void handle(ActionEvent arg0){
        int length = this.vb.getChildren().size();

        String text = this.bn.getText();//get the text of the answer selected
        Label lb = Design.labelFactory("You have selected: " + text, Color.WHITE);//adds it to a label
        
        if(vb.getChildren().size() == 3 || vb.getChildren().size() == 5){//checks whether question has been answered, if it hasnt, and it is correct, adds a point
            vb.getChildren().add(length,lb);//adds the label to the bottom
            if(text.equals(this.correctAnswer)){
                StartEventHandler.addFinalScore();

            }

        }
        else{
            String last = ((Label) this.vb.getChildren().get(length - 1)).getText();//get the previous answer
            String[] prev = last.split("You have selected: ");//splits it so i can get just the answer without selection
            String previousAnswer = prev[1];//gets answer

            if(text.equals(correctAnswer)){ 
                if(previousAnswer.equals(correctAnswer)){
                  
                }
                else{
                    System.out.println();
                    StartEventHandler.addFinalScore();
                }
            }

            else{
                if(previousAnswer.equals(correctAnswer)){
                    StartEventHandler.subFinalScore();
                }
            }
            

            vb.getChildren().remove(vb.getChildren().size()-1);//if user changes their answer, it must remove previous answer, and adds new one
            vb.getChildren().add(vb.getChildren().size(),lb);

            
            
        }
     


    }





    }
    
