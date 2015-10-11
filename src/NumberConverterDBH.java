import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;


/**
 * Created by David on 10/10/2015.
 */
public class NumberConverterDBH extends Application {
    private int x = 600;
    private int y = 250;
    private int decimalVal;
    private String hexVal;
    private long binaryVal;
    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane pane = new GridPane();
        Text decimal = new Text("Decimal");
        Text binary = new Text("Binary");
        Text hexadecimal = new Text("Hexadecimal");
        TextField hex = new TextField();
        TextField de = new TextField();
        TextField bi = new TextField();

        hex.setOnKeyPressed(a -> {
            if(a.getCode().equals(KeyCode.ENTER)){
                setHexVal(hex.getText());
                de.setText(String.valueOf(Integer.parseInt(getHexVal(), 16)));
                bi.setText(Integer.toBinaryString(Integer.parseInt(getHexVal(), 16)));
            }
        });

        de.setOnKeyPressed(b -> {
            if (b.getCode().equals(KeyCode.ENTER)) {
                setDecimalVal(Integer.parseInt(de.getText()));
                hex.setText(Integer.toHexString(getDecimalVal()));
                bi.setText(Integer.toBinaryString(getDecimalVal()));
            }

        });

        bi.setOnKeyPressed(c -> {
            if(c.getCode().equals(KeyCode.ENTER)) {
                setBinaryVal(Long.parseLong(bi.getText()));
                de.setText(String.valueOf(Integer.parseInt(String.valueOf(getBinaryVal()), 2)));
                hex.setText(Long.toHexString(Long.valueOf(String.valueOf(getBinaryVal()), 2)));
            }
        });

        pane.add(hexadecimal, 0, 0);
        pane.add(decimal, 0, 1);
        pane.add(binary, 0, 2);
        pane.add(hex, 1, 0);
        pane.add(de, 1, 1);
        pane.add(bi, 1, 2);
        Scene scene = new Scene(pane, x, y);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public int getDecimalVal() {
        return decimalVal;
    }

    public String getHexVal() {
        return hexVal;
    }

    public long getBinaryVal() {
        return binaryVal;
    }

    public void setDecimalVal(int decimalVal) {
        this.decimalVal = decimalVal;
    }

    public void setHexVal(String hexVal) {
        this.hexVal = hexVal;
    }

    public void setBinaryVal(long binaryVal) {
        this.binaryVal = binaryVal;
    }
}
