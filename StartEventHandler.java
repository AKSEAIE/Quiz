    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.io.PrintWriter;
    import java.net.Socket;
    import java.net.UnknownHostException;
    import java.util.ArrayList;
    import java.util.Collections;
    import java.util.Random;
    import javafx.application.Platform;
    import javafx.event.ActionEvent;
    import javafx.event.EventHandler;
    import javafx.geometry.Insets;
    import javafx.geometry.Pos;
    import javafx.scene.control.Button;
    import javafx.scene.control.Label;
    import javafx.scene.control.ScrollPane;
    import javafx.scene.control.TextField;
    import javafx.scene.layout.Background;
    import javafx.scene.layout.BackgroundFill;
    import javafx.scene.layout.CornerRadii;
    import javafx.scene.layout.VBox;
    import javafx.scene.paint.Color;


    public class StartEventHandler implements EventHandler<ActionEvent> {
        private int authenticate = 0;
        private ArrayList<String> scores = new ArrayList<>();
        private int timeSeconds;
        private String question;
        private Button self;
        private int count = 0;
        private ScrollPane sp;
        private Button theme;
        private TextField name;
        private VBox vb;
        private String correctAnswer;
        private Button submit;
        private static int finalScore = 0;
        private Label time = Design.labelFactory("");

    
    /**
     * getter for authenticate
     * @return int
     */
    public int getAuthenticate() {
        return authenticate;
    }

    /**
     * setter for authenticate
     * @param authenticate
     */
    public void setAuthenticate(int authenticate) {
        this.authenticate = authenticate;
    }

    /**
     * getter for timeSeconds
     * @return int
     */
    public int getTimeSeconds() {
        return timeSeconds;
    }

    /**
     * setter for timeSeconds
     * @param timeSeconds
     */
    public void setTimeSeconds(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    /**
     * getter for question
     * @return String
     */
    public String getQuestion() {
        return question;
    }

    /**
     * setter for question
     * @param question
     */
    public void setQuestion(String question) {
        this.question = question;
    }

    /**
     * getter for self
     * @return Button
     */
    public Button getSelf() {
        return self;
    }

    /**
     * setter for self
     * @param self
     */
    public void setSelf(Button self) {
        this.self = self;
    }

    /**
     * getter for count
     * @return int
     */
    public int getCount() {
        return count;
    }

    /**
     * setter for count
     * @param count
     */
    public void setCount(int count) {
        this.count = count;
    }

    /**
     * getter for sp
     * @return ScrollPane
     */
    public ScrollPane getSp() {
        return sp;
    }

    /**
     * setter for sp
     * @param sp
     */
    public void setSp(ScrollPane sp) {
        this.sp = sp;
    }

    /**
     * getter for theme
     * @return Button
     */
    public Button getTheme() {
        return theme;
    }

    /**
     * setter for theme
     * @param theme
     */
    public void setTheme(Button theme) {
        this.theme = theme;
    }

    /**
     * getter for time
     * @return Label
     */
    public Label getTime() {
        return time;
    }

    /**
     * setter for time
     * @param time
     */
    public void setTime(Label time) {
        this.time = time;
    }

        /**
         * getter for correct answer
         * 
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
         * Submit buttong getter
         * @return Button
         */
        public Button getSubmit() {
            return this.submit;
        }

        /**
         * setter for submit button
         * @param submit
         */
        public void setSubmit(Button submit) {
            this.submit = submit;
        }

        /**
         * getter for name
         * @return TextField
         */
        public TextField getName() {
            return this.name;
        }

        /**
         * setter for name
         * @param name
         */

        public void setName(TextField name) {
            this.name = name;
        }


        /**
         * getter for vb
         * @return VBox
         */
        public VBox getVb() {
            return this.vb;
        }

        /**
         * setter for vb
         * @param vb
         */

    /**
     * setter for vb
     * @param vb
     */
    public void setVb(VBox vb) {
        this.vb = vb;
    }

    /**
     * getter for finalScore
     * @return int
     */
    public static int getFinalScore() {
        return StartEventHandler.finalScore;
    }

    /**
     * setter for finalScore
     * @param finalScore
     */
    public static void setFinalScore(int finalScore) {
        StartEventHandler.finalScore = finalScore;
    }

    /**
     * method to subtract 1 from finalScore
     */
    public static void subFinalScore(){
        StartEventHandler.finalScore = StartEventHandler.finalScore - 1;
    }

    /**
     * method to add 1 to finalScore
     */
    public static void addFinalScore(){
        StartEventHandler.finalScore = StartEventHandler.finalScore + 1;
    }

    /**
     * getter for scores
     * @return ArrayList<String>
     */
    public ArrayList<String> getScores() {
        return this.scores;
    }

    /**
     * setter for scores
     * @param newScores
     */
    public void setScores(ArrayList<String> newScores) {
        this.scores = newScores;
    }

        /**
         * constructor for starteventhandler
         * @param self
         * @param sp
         * @param theme
         * @param name
         * @param vb
         */
        public StartEventHandler(Button self,ScrollPane sp,Button theme,TextField name, VBox vb){
            this.self = self;
            this.sp = sp;
            this.theme = theme;
            this.name = name;
            this.vb = vb;
            
        }
            /**
             * displays the top 5 highest scores from the leaderboard.
             */
        private void showScores() {
            int rank = 1;
            VBox leaderboard = new VBox();
            leaderboard.setAlignment(Pos.CENTER);
            int count = 0;
            for (String score : scores) {
                if (count >= 3){ 
                    break;}
                String[] scoreArrayed = score.split(" ");
                String check = scoreArrayed[2];
                if(check.equals(this.name.getText())){
                    leaderboard.getChildren().add(Design.labelFactory("--YOU-- " + score + " - " + rank,Color.DARKGRAY));
                    System.out.println("You are placed at rank "+ rank);

                }
                else{
                    leaderboard.getChildren().add(Design.labelFactory(score + " - " + rank,Color.DARKGRAY));
                }
                rank++;
                count++;
            }
            
            this.vb.setAlignment(Pos.CENTER);
            this.vb.getChildren().add(leaderboard);
        }

    

        /**
         * method for timer that will continously update timer and handle the submission of the quiz.
         * @param timeNow
         * @param vb
         */
        private void updatingTime(long timeNow, VBox vb){

            long timeDifference = timeSeconds - timeNow;
            if(timeDifference <= 0 ||(this.submit.isPressed() && this.authenticate == 0)){
                this.authenticate = 1;
                Label firstNode = (Label) this.vb.getChildren().get(0);
                String name = firstNode.getText();
                System.out.println(name);
                this.vb.getChildren().clear();
                this.vb.getChildren().add(Design.labelFactory(("Your final score is " + StartEventHandler.getFinalScore() + " out of 10" ),Color.WHITE));
                Label wait = new Label("Connection Pending...");
                try {
                    Socket client = new Socket("localhost", 12345);
                    PrintWriter pw = new PrintWriter(client.getOutputStream(), true);
                                    
                    pw.println(""+name+":"+StartEventHandler.getFinalScore()+":"+timeNow);
                    BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
                    String line = br.readLine();
                    while(line != null){
                        scores.add(line);
                        line = br.readLine();
                    }

                    
                    client.close();


                } catch (UnknownHostException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                loadScreen(wait);


                

            }
            //For color changing timer
            time.setText("You have: " + timeDifference);
            
            ArrayList<Color> colors = new ArrayList<>();
            Collections.addAll(colors, Color.RED, Color.BLUE, Color.GREEN, Color.BLACK, Color.PINK, Color.ORANGE,Color.AQUA, Color.BEIGE, Color.BROWN, Color.CORAL, Color.CYAN, Color.DARKBLUE, Color.DARKCYAN, Color.DARKGOLDENROD, Color.DARKGRAY, Color.DARKGREEN, Color.DARKKHAKI, Color.DARKMAGENTA, Color.DARKOLIVEGREEN, Color.DARKORANGE, Color.DARKRED, Color.DARKSALMON, Color.DARKSEAGREEN, Color.DARKSLATEBLUE, Color.DARKTURQUOISE, Color.DARKVIOLET);
            Random rand = new Random();
            int value = rand.nextInt(0,26);
            time.setBackground(new Background(new BackgroundFill(colors.get(value), new CornerRadii(30), new Insets(2.5))));
            time.setTextFill(Color.WHITE);
        }

    


        /**
         * method that runs timer in background thread.
         */

        public void timer() {
            Runnable run = new Runnable() {
                public void run(){
                    try {
                        for(int i = 0; i <= timeSeconds; i++) {
                            if(authenticate == 1){
                            break;
                            }
                            guiAccess(i);
                                // Handle the timer running out logic here if needed

                            Thread.sleep(1000); // Wait for 1 second
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };
            Thread actualRunner = new Thread(run);
            actualRunner.start();
        }

        /**
         * method used in updatingTime method to make edits to the GUI
         * @param i
         */
        public void guiAccess(int i){
            Platform.runLater(new Runnable(){
                public void run(){
                    updatingTime(i, vb); // Update the time on each iteration

                }
            });
        }

        /**
         * will add the label to load
         * @param wait
         */
        public void loading(Label wait){
            Platform.runLater(new Runnable(){
                public void run(){
                    vb.getChildren().add(wait);
                
                }
            });
        }

        /**
         * will make this thread sleep so you can properly see loading screen
         * @param wait
         */
        public void loadScreen(Label wait){
            Runnable load = new Runnable() {
                public void run(){
                    loading(wait);
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    removeLoading(wait);
                }
            };
            Thread loader = new Thread(load);
            loader.start();
        }

        /**
         * will remove the loading screen and show the leaderboard
         * @param wait
         */

        public void removeLoading(Label wait){
            Platform.runLater(new Runnable(){
                public void run(){
                    vb.getChildren().remove(wait);
                    
                    showScores();
                    scores.clear();
                    
                    Label lb = new Label("Connection Established");
                    vb.getChildren().add(lb);
                }
            });
        }
        
    /**
         * Loads the questions displays them in the gui and starts the countdown timer
         * @param arg0
         * @throws exception 
         */
        @Override
        public void handle(ActionEvent arg0){

            
            Label l = Design.labelFactory(this.name.getText());
            
            vb.getChildren().add(time);
            vb.getChildren().remove(0);
            vb.getChildren().add(0, l);
            theme.setOnAction(new ThemeEventHandler(theme,count,sp, vb));
            vb.getChildren().add(theme);

            ArrayList<Question> al = new ArrayList<>();
            ArrayList<Question> sl = new ArrayList<>();
            QuizQuestions q = new QuizQuestions(al, sl);
            try {
                if(self.getText().equals("Easy")){
                    question = "questionsBase.txt";
                    timeSeconds = 60;
                }
                else if(self.getText().equals("Medium")){
                    question = "mediumQuestions.txt";
                    timeSeconds = 120;
                }
                else{
                    question = "hardQuestions.txt";
                    timeSeconds = 180;
                }
                q.load(question);
                q.select(9);
            } catch (IOException e) {
                return;
            }

            for(int i = 0; i < sl.size(); i++){
                VBox box = new VBox();
                Label ll = Design.labelFactory(sl.get(i).getQuestion(), Color.LIGHTGRAY);
                ll.setTextFill(Color.DARKSLATEGRAY);
                correctAnswer = sl.get(i).getCorrectAnswer();
                box.getChildren().add(ll);
                for(int j = 0; j < sl.get(i).getAllAnswers().length; j++){
                    Button bn = Design.buttonFactory(sl.get(i).getAllAnswers()[j], Color.GRAY);
                    bn.setTextFill(Color.WHITE);
                    box.getChildren().add(bn);
                    bn.setOnAction(new AnswerEventHandler(bn, box, correctAnswer));
                }
                vb.getChildren().addAll(box);
            }

            this.submit = Design.buttonFactory("Submit", Color.GREEN);

            this.submit.setTextFill(Color.WHITE);
            vb.getChildren().add(this.submit);

            // Start the new timer
            timer();
        }
    }
