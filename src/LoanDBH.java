import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class LoanDBH extends Application{
    final int X = 1000;
    final int Y = 600;
    @Override
    public void start(Stage primaryStage) throws Exception {
        List<String> list = new ArrayList<>();
        BorderPane outerPane = new BorderPane();
        GridPane topPane = new GridPane();
        BorderPane bottomPane = new BorderPane();
        Loan loan = new Loan();

        NumberFormat percent = NumberFormat.getPercentInstance();
        percent.setMaximumFractionDigits(3);
        percent.setMinimumFractionDigits(3);
        NumberFormat dollars = NumberFormat.getCurrencyInstance();
        DecimalFormat fmt = new DecimalFormat ("0.###");

        Label loanAmt = new Label("Loan Amount:");
        Label numYears = new Label("Number of Years:");
        TextField years = new TextField();
        TextField amt = new TextField();
        Button viewBt = new Button("View");
        years.setMaxWidth(75);

        topPane.add(loanAmt, 0, 0);
        topPane.add(amt, 1, 0);
        topPane.add(numYears, 2, 0);
        topPane.add(years, 3, 0);
        topPane.add(viewBt, 4, 0);
        topPane.setHgap(5);

        Text loanGrid = new Text();
        TextArea grid = new TextArea();

        viewBt.setOnAction(e -> {
            loan.setLoanAmount(Double.parseDouble(amt.getText()));
            loan.setNumberOfYears(Integer.parseInt(years.getText()));
            grid.appendText("Interest Rate\tMonthly Payment\t Total Payment\n");
            for (double annualInterestRate = .05; annualInterestRate <= .08125; annualInterestRate += .00125) {
                grid.appendText(percent.format(annualInterestRate)+"\t\t"+ dollars.format(loan.getMonthlyPayment())+"\t\t\t "+ dollars.format(loan.getTotalPayment()) + "\n");
            }

        });

        outerPane.setTop(topPane);
        outerPane.setBottom(grid);

        Scene scene = new Scene(outerPane, X, Y);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}