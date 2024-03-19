import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Assignment14_GUIMeasurement extends Application {
    public static void main(String[] args) throws Exception {
        launch(args);
    }


    @Override
    public void start(Stage stage) throws Exception {
        BorderPane borderPane = new BorderPane();
        StackPane stackPane = new StackPane();
        VBox root = new VBox(10);
        borderPane.setTop(stackPane);
        borderPane.setCenter(root);
        HBox root1 = new HBox(10);
        HBox root3 = new HBox(10);
        HBox root4 = new HBox(10);
        HBox root5 = new HBox();
        Label welcome = new Label("Welcome to the Measurement Converter! This convertor supports 4 Conversions." + "\n" +  "Enter the number that corresponds with the conversion you desire." + "\n" + "1. Meters to feet" + "\n" + "2. Feet to Meters" + "\n" + "3. Celsius to Fahrenheit" + "\n" + "4. Fahrenheit to Celsius");
        VBox.setMargin(welcome, new Insets(10));
        Label orgMeasure = new Label("Enter the original measurement: ");
        TextField orgMeasure1 = new TextField();
        orgMeasure1.setPrefSize(150, 30);
        Label valueMeasure = new Label("Enter the value that will be converted: ");
        TextField valueMeasure1 = new TextField();
        valueMeasure1.setPrefSize(200, 30);
        Label newlyMeasure = new Label("Newly converted measurement: ");
        TextField newlyMeasure1 = new TextField();
        newlyMeasure1.setPrefSize(350, 30);
        newlyMeasure1.setEditable(false);

        Button btConvert = new Button("Convert");
        root5.setAlignment(Pos.CENTER_LEFT);
        btConvert.setOnAction(event -> {
            String userInput = orgMeasure1.getText();
            try {
                int number = Integer.parseInt(userInput);
                if (number == 1){
                    String meters = valueMeasure1.getText();
                    Double value = Double.parseDouble(meters);
                    double feet = value * 3.28084;
                    String result = String.valueOf(feet);
                    newlyMeasure1.setText(result);
                } else if (number == 2){
                    String feet1 = valueMeasure1.getText();
                    Double value1 = Double.parseDouble(feet1);
                    double meter1 = value1/3.28084;
                    String result1 = String.valueOf(meter1);
                    newlyMeasure1.setText(result1);
                } else if (number == 3) {
                    String celsius = valueMeasure1.getText();
                    Double value1 = Double.parseDouble(celsius);
                    double Fahrenheit = (value1 * 9/5) + 32;
                    String result1 = String.valueOf(Fahrenheit);
                    newlyMeasure1.setText(result1);
                } else if (number == 4){
                    String fahrenheit = valueMeasure1.getText();
                    Double value1 = Double.parseDouble(fahrenheit);
                    double Celsius = (value1 - 32) * 5/9;
                    String result1 = String.valueOf(Celsius);
                    newlyMeasure1.setText(result1);
                } else{
                    newlyMeasure1.setText("Please enter an Integer from 1-4 inclusive.");
                }
                
            } catch (NumberFormatException e) {
                newlyMeasure1.setText("Invalid Input: Please enter an Integer from 1-4.");
            }
        });
        

        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(borderPane, 300, 300);
        root.setPadding(new Insets(10));
        
        root5.getChildren().addAll(btConvert);
        root4.getChildren().addAll(newlyMeasure, newlyMeasure1);
        root3.getChildren().addAll(valueMeasure, valueMeasure1);
        root1.getChildren().addAll(orgMeasure, orgMeasure1);
        root.getChildren().addAll(root1, root3, root4, root5, welcome);
        stage.setWidth(600);
        stage.setHeight(600);
        stage.setTitle("Measurement Convertor");
        stage.setScene(scene);
        stage.show();
    }
}



    
       
    
    

