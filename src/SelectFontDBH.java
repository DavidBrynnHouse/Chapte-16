import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.List;

/**
 * Created by David on 10/12/2015.
 */
public class SelectFontDBH extends Application {
    final int X = 1200;
    final int Y = 1000;
    private ComboBox<String> fontChoice = new ComboBox<>();
    private ComboBox<Integer> sizeChoice = new ComboBox<>();
    private Label fontName = new Label("Font Name:");
    private Label fontSize = new Label("Font Size:");
    private Label newText = new Label("I can change this text");
    private CheckBox bold = new CheckBox("Bold");
    private CheckBox italic = new CheckBox("Italic");

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane outerPane = new BorderPane();
        HBox topBox = new HBox(20);
        HBox bottomBox = new HBox(20);
        outerPane.setCenter(newText);

        fontChoice.setValue("Times New Roman");
        sizeChoice.setValue(12);

        topBox.setPadding(new Insets(20, 20, 20, 20));
        bottomBox.setPadding(new Insets(20, 20, 20, 20));

        List<String> items = Font.getFamilies();
        fontChoice.getItems().addAll(items);

        for(int i = 1; i <= 100; i++ )
            sizeChoice.getItems().add(i);

        topBox.getChildren().addAll(fontName, fontChoice, fontSize, sizeChoice);
        bottomBox.getChildren().addAll(bold, italic);
        topBox.setAlignment(Pos.CENTER);
        bottomBox.setAlignment(Pos.CENTER);

        outerPane.setTop(topBox);
        outerPane.setCenter(newText);
        outerPane.setBottom(bottomBox);

        fontChoice.setOnAction(e -> {
            setFont();
        });

        sizeChoice.setOnAction(e -> {
            setFont();
        });

        bold.setOnAction(e -> {
            setFont();
        });
        italic.setOnAction(e -> {
            setFont();
        });


        Scene scene = new Scene(outerPane, X, Y);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void setFont() {
        FontWeight weight;
        if (bold.isSelected()) {
            weight = FontWeight.BOLD;
        }
        else {
            weight = FontWeight.NORMAL;
        }

        FontPosture posture;
        if (italic.isSelected()) {
            posture = FontPosture.ITALIC;
        }
        else {
            posture = FontPosture.REGULAR;
        }

        newText.setFont(Font.font(fontChoice.getValue(), weight, posture,
                sizeChoice.getValue()));
    }
}
