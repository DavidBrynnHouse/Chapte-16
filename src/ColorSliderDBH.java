import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Created by David on 10/12/2015.
 */
public class ColorSliderDBH extends Application {
    final int X = 800;
    final int Y = 500;
    ScrollBar redScrollBar = new ScrollBar();
    ScrollBar greenScrollBar = new ScrollBar();
    ScrollBar opacityScrollBar = new ScrollBar();
    ScrollBar blueScrollBar = new ScrollBar();
    Text label = new Text("Change my Color!");

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane outerPane = new BorderPane();
        BorderPane upperPane = new BorderPane();
        GridPane lowerPane = new GridPane();
        lowerPane.setHgap(10);
        lowerPane.setVgap(10);


        lowerPane.add(new Label("Red"), 0, 0);
        lowerPane.add(new Label("Green"), 0, 1);
        lowerPane.add(new Label("Blue"), 0, 2);
        lowerPane.add(new Label("Opacity"), 0, 3);

        lowerPane.add(redScrollBar, 1, 0);
        lowerPane.add(greenScrollBar, 1, 1);
        lowerPane.add(blueScrollBar, 1, 2);
        lowerPane.add(opacityScrollBar, 1, 3);

        upperPane.setCenter(label);
        outerPane.setCenter(upperPane);
        outerPane.setBottom(lowerPane);
        lowerPane.setAlignment(Pos.CENTER);

        redScrollBar.setMax(255);
        greenScrollBar.setMax(255);
        blueScrollBar.setMax(255);
        opacityScrollBar.setMax(100);

        redScrollBar.valueProperty().addListener(e -> {
            label.setFill(Color.rgb((int) redScrollBar.getValue(),
                    (int) greenScrollBar.getValue(),
                    (int) blueScrollBar.getValue(),
                    opacityScrollBar.getValue()));

        });

        greenScrollBar.valueProperty().addListener(e -> {
            label.setFill(Color.rgb((int) redScrollBar.getValue(),
                    (int) greenScrollBar.getValue(),
                    (int) blueScrollBar.getValue(),
                    opacityScrollBar.getValue()));

        });

        blueScrollBar.valueProperty().addListener(e -> {
            label.setFill(Color.rgb((int) redScrollBar.getValue(),
                    (int) greenScrollBar.getValue(),
                    (int) blueScrollBar.getValue(),
                    opacityScrollBar.getValue()));
        });

        opacityScrollBar.valueProperty().addListener(e -> {
            label.setFill(Color.rgb((int) redScrollBar.getValue(),
                    (int) greenScrollBar.getValue(),
                    (int) blueScrollBar.getValue(),
                    opacityScrollBar.getValue()));
        });

        Scene scene = new Scene(outerPane, X, Y);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
