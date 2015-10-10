import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Created by David on 10/8/2015.
 */
public class RadioButtonsDBH extends Application{
    private int X = 1600;
    private int Y = 1000;
    @Override
    public void start(Stage primaryStage) {
        BorderPane pane = new BorderPane();

        //creates the buttons for movement and places them at the bottom
        Button leftBt = new Button("<=");
        Button rightBt = new Button("=>");
        HBox hBottomBox = new HBox(25);
        hBottomBox.setPadding(new Insets(20, 20, 20, 20));
        hBottomBox.getChildren().addAll(leftBt, rightBt);
        hBottomBox.setAlignment(Pos.CENTER);

        //Radio Buttons created and grouped
        final ToggleGroup TG = new ToggleGroup();
        final RadioButton BLUE = new RadioButton("Blue");
        final RadioButton BLACK = new RadioButton("Black");
        final RadioButton PURPLE = new RadioButton("Purple");
        final RadioButton PINK = new RadioButton("Pink");
        final RadioButton GREEN = new RadioButton("Green");

        BLACK.setToggleGroup(TG);
        BLUE.setToggleGroup(TG);
        GREEN.setToggleGroup(TG);
        PINK.setToggleGroup(TG);
        PURPLE.setToggleGroup(TG);

        //Initialize and set radio buttions
        HBox hTopBox = new HBox(25);
        hTopBox.setPadding(new Insets(20, 20, 20, 20));
        hTopBox.getChildren().addAll(BLACK, BLUE, PINK, PURPLE, GREEN);
        hTopBox.setAlignment(Pos.CENTER);

        //Pane to be set in the center Hbox
        Pane smallPane = new Pane();
        Text text = new Text("JAVA++");
        smallPane.setTranslateY(Y / 2);
        smallPane.getChildren().add(text);

        //Center HBox contains text
        HBox hCenterBox = new HBox(25);
        hCenterBox.setPadding(new Insets(20, 20, 20, 20));
        hCenterBox.getChildren().add(smallPane);
        hCenterBox.setAlignment(Pos.CENTER);

        pane.setTop(hTopBox);
        pane.setCenter(hCenterBox);
        pane.setBottom(hBottomBox);

        //Create Actions
        leftBt.setOnAction(e -> {
            smallPane.setTranslateX(smallPane.getTranslateX() - 5);
        });

        rightBt.setOnAction(e -> {
            smallPane.setTranslateX(smallPane.getTranslateX() + 5);
        });

        BLACK.setOnAction(e -> {
            text.setFill(Color.BLACK);
        });

        BLUE.setOnAction(e -> {
            text.setFill(Color.BLUE);
        });

        GREEN.setOnAction(e -> {
            text.setFill(Color.GREEN);
        });

        PINK.setOnAction(e -> {
            text.setFill(Color.PINK);
        });

        PURPLE.setOnAction(e -> {
            text.setFill(Color.PURPLE);
        });

        Scene scene = new Scene(pane, X, Y);
        primaryStage.setTitle("RadioButtons");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}