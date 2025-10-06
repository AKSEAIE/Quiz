import java.io.IOException;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * This Quiz class is used for setting up the primary stage
 */
public  class Quiz extends Application{
    
    /**
     * Starts the application by setting up the components(labels textfields etc)
     * 
     * @param Stage stage
     * void returns
     */
    @Override
    public void start(Stage arg0){
        Stage stage = new Stage();// Make a new Stage
        stage.setTitle("Quiz");
        ScrollPane sp = new ScrollPane();//Scrolling
        TextField name = new TextField("Enter your Name ");
        Button easy = Design.buttonFactory("Easy", Color.LIGHTGRAY);
        Button medium = Design.buttonFactory("Medium", Color.LIGHTGRAY);
        Button hard = Design.buttonFactory("Hard", Color.LIGHTGRAY);
        Button theme = Design.buttonFactory("Theme", Color.LIGHTGRAY);
        theme.setTextFill(Color.BLACK);
        Label rules = Design.labelFactory("This is a Timed Quiz about Java Concepts, you will have exactly 1 minute complete this quiz",Color.LIGHTGRAY);// Label that tells them they have 1 minute
        HBox hb = new HBox(name, easy,medium,hard);
        VBox vb = new VBox(hb,rules);       
        easy.setOnAction(new StartEventHandler(easy,sp, theme, name, vb));
        medium.setOnAction(new StartEventHandler(medium,sp, theme, name, vb));
        hard.setOnAction(new StartEventHandler(hard,sp, theme, name, vb));
        hb.setMaxWidth(Double.MAX_VALUE);
        vb.setMaxWidth(Double.MAX_VALUE);
        sp.setFitToHeight(true);
        sp.setFitToWidth(true);
        hb.setAlignment(Pos.CENTER);
        vb.setAlignment(Pos.CENTER);
        sp.setContent(vb);
        Scene scene = new Scene(sp,400,200);
        stage.setScene(scene);
        stage.show();
    }

   
    /** 
     * The main starts the quiz gui
     * 
     * @param args
     * void returns
     */
    
    public static void main(String[] args) throws IOException {
        launch(args);

        }   


    }