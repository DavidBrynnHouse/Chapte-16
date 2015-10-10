import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * Created by David on 10/10/2015.
 */
public class TrafficLightDBH extends Application {
    private int x = 500;
    private int y = 500;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane pane = new Pane();
        Circle green = new Circle(50);
        Circle yellow = new Circle(50);
        Circle red = new Circle(50);

        green.setStroke(Color.BLACK);
        yellow.setStroke(Color.BLACK);
        red.setStroke(Color.BLACK);
        green.setFill(Color.WHITE);
        yellow.setFill(Color.WHITE);
        red.setFill(Color.WHITE);

        red.setCenterX(250);
        red.setCenterY(100);
        yellow.setCenterX(250);
        yellow.setCenterY(250);
        green.setCenterX(250);
        green.setCenterY(400);

        ToggleGroup TG = new ToggleGroup();
        RadioButton redBT = new RadioButton("Red");
        RadioButton yellowBT = new RadioButton("Yellow");
        RadioButton greenBT = new RadioButton("Green");

        redBT.setToggleGroup(TG);
        yellowBT.setToggleGroup(TG);
        greenBT.setToggleGroup(TG);

        VBox select = new VBox(20);
        select.setPadding(new Insets(20, 20, 20, 20));
        select.getChildren().addAll(redBT, yellowBT, greenBT);

        redBT.setOnAction(e -> {
            red.setFill(Color.RED);
            yellow.setFill(Color.WHITE);
            green.setFill(Color.WHITE);
        });

        yellowBT.setOnAction(e -> {
            yellow.setFill(Color.YELLOW);
            green.setFill(Color.WHITE);
            red.setFill(Color.WHITE);
        });

        greenBT.setOnAction(event -> {
            green.setFill(Color.GREEN);
            red.setFill(Color.WHITE);
            yellow.setFill(Color.WHITE);
        });

        pane.getChildren().addAll(green, yellow, red, select);
        Scene scene = new Scene(pane, x, y);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
