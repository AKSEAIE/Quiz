import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;


public class Design{
    
    /**
     * Label factory method used for designing and adding labels 
     * @param text
     * @param color
     * @return label object
     */
    public static Label labelFactory(String text, Color color){
        Label l = new Label(text);
        l.setFont(new Font(13));
        l.setTextFill(Color.BLACK);
        l.setPadding(new Insets(5));
        l.setBackground(new Background(new BackgroundFill(color, new CornerRadii(30), new Insets(2.5))));
        return l;
    }

    /**
     * 
     * @param text
     * @return label object
     */
    public static Label labelFactory(String text){//Overloading, so we can have defualt color if needed
        Label l = new Label(text);
        l.setFont(new Font(13));
        l.setTextFill(Color.BLACK);
        l.setPadding(new Insets(5));
        l.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, new CornerRadii(30), new Insets(2.5))));
        return l;
    }


    /**
     * Used for desigining the button 
     * @param text
     * @param color
     * @return button object
     */
    public static Button buttonFactory(String text,Color color){
        Button bn = new Button(text);
        bn.setFont(new Font(12));
        bn.setTextFill(Color.BLACK);
        bn.setPadding(new Insets(10));
        bn.setBackground(new Background(new BackgroundFill(color, new CornerRadii(30), new Insets(5))));
        return bn;
    }
}
