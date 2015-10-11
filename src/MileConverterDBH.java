import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;


/**
 * Created by David on 10/10/2015.
 */
public class MileConverterDBH extends Application {
    private int x = 600;
    private int y = 150;
    private double milesVal;
    private double kilometersVal;
    final double KM_IN_MI = 1.60934;
    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane pane = new GridPane();
        Text miles = new Text("Miles");
        Text kilometers = new Text("Kilometers");
        TextField mi = new TextField();
        TextField km = new TextField();

        mi.setOnKeyPressed(e -> {
            if(e.getCode().equals(KeyCode.ENTER)){
                setKilometersVal(Double.parseDouble(mi.getCharacters().toString()));
                km.setText(Double.toString(getKilometersVal() * KM_IN_MI));
            }
        });

        km.setOnKeyPressed(e -> {
            if (e.getCode().equals(KeyCode.ENTER)) {
                setMilesVal(Double.parseDouble(km.getCharacters().toString()));
                mi.setText(Double.toString(getMilesVal() / KM_IN_MI));
            }

        });

        pane.add(miles, 0, 0);
        pane.add(kilometers, 0, 1);
        pane.add(mi, 1, 0);
        pane.add(km, 1, 1);
        Scene scene = new Scene(pane, x, y);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public double getKilometersVal() {
        return kilometersVal;
    }

    public void setKilometersVal(double kilometersVal) {
        this.kilometersVal = kilometersVal;
    }

    public double getMilesVal() {
        return milesVal;
    }

    public void setMilesVal(double milesVal) {
        this.milesVal = milesVal;
    }

}
