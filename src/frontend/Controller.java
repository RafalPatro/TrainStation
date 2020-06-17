package frontend;

import backend.Train;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    boolean isFirstRun=true;

    @FXML
    Button hello;

    @FXML
    Button world;

    @FXML
    Button exclamation;



    List<String> list = new ArrayList<>();

    {
        list.add("     ");
        list.add("     ");
        list.add("      ");
    }
        List<String> actualLabel = new ArrayList<>();

    {
        actualLabel.add("Hello");
        actualLabel.add("World");
        actualLabel.add("!!!!!!");
    }

    @FXML
    private void handleButtonAction(ActionEvent event) {
        ArrayList<Button> buttons = new ArrayList<>();
        buttons.add(hello);
        buttons.add(world);
        buttons.add(exclamation);

        for( int i=0;i<buttons.size();i++){
            if(event.getSource().equals(buttons.get(i))){
                if(actualLabel.get(i).equals(list.get(i))){
                    actualLabel.set(i,buttons.get(i).getText());
                } else {
                    actualLabel.set(i,list.get(i));
                }
            }
        }
        isFirstRun=false;
        String out ="";
        for (String s:actualLabel
             ) {
            out = out + " " + s;
        }
        label.setText(out);
    }

    @FXML
    Label label = new Label("");


    public static void readPositionsOfTrains(List<Train> trains){

    }


}
