import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class ThemeEventHandler implements EventHandler<ActionEvent>{
    private Button bn;
    private int count;
    private VBox vb;


    /**
     * construtor
     * @param bn
     * @param count
     * @param sp
     * @param vb
     */
    public ThemeEventHandler(Button bn,int count,ScrollPane sp, VBox vb){
        this.bn = bn;
        this.vb = vb;
    }

    /**
     * changes theme color fo the gui
     */
    @Override
    public void handle(ActionEvent arg0) {
       
        if(count == 0){
            this.bn.setTextFill(Color.WHITE);
        vb.setBackground(new Background(new BackgroundFill(Color.DARKGRAY,CornerRadii.EMPTY, Insets.EMPTY)));
        count++;
        }
        else{
            this.bn.setTextFill(Color.BLACK);
            vb.setBackground(new Background(new BackgroundFill(Color.WHITE,CornerRadii.EMPTY, Insets.EMPTY)));
            count--;
        }
}
}
