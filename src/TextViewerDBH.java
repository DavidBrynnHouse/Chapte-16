import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by David on 10/11/2015.
 */
public class TextViewerDBH extends Application {
    final int X = 1000;
    final int Y = 1000;
    String fileLocation;
    String line;
    List<String> lines = new ArrayList<String>();

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane outerPane = new BorderPane();
        BorderPane innerPane = new BorderPane();
        Pane superInnerPane = new Pane();

        TextField field = new TextField("File Name:");
        Text area = new Text();

        superInnerPane.getChildren().add(area);
        field.setAlignment(Pos.BOTTOM_LEFT);

        ScrollBar vertical = new ScrollBar();
        ScrollBar horizontal = new ScrollBar();
        vertical.setOrientation(Orientation.VERTICAL);
        horizontal.setOrientation(Orientation.HORIZONTAL);

        innerPane.setRight(vertical);
        innerPane.setBottom(horizontal);
        innerPane.setCenter(superInnerPane);

        outerPane.setCenter(innerPane);
        outerPane.setBottom(field);

        field.setOnMouseClicked(e -> {
            field.clear();
        });

        field.setOnKeyPressed(e -> {
            if (e.getCode().equals(KeyCode.ENTER)) {
                fileLocation = field.getText();
                File file = new File(fileLocation);
                try {
                    BufferedReader br = new BufferedReader(new FileReader(file));

                    while ((line = br.readLine()) != null) {
                        lines.add(line);
                    }
                    br.close();
                } catch (IOException ex) {}
                StringBuilder sb = new StringBuilder();
                for(String s : lines)
                    sb.append(s + "\n");
                area.setText(String.valueOf(sb));
                area.setX(10);
                area.setY(40);
            }
        });

        horizontal.valueProperty().addListener(e -> {
            area.setX(horizontal.getValue() * superInnerPane.getWidth() /
                    horizontal.getMax());
            });

        vertical.valueProperty().addListener(e -> {
                area.setY(vertical.getValue() * superInnerPane.getHeight() /
                        vertical.getMax());
            });

            Scene scene = new Scene(outerPane, X, Y);
            primaryStage.setScene(scene);
            primaryStage.show();
        }
    }
