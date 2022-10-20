package com.example.ipAddressMatcher;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.util.Duration;
import com.example.passGen.PassGen;
import com.example.compare2Strings.Compare2Strings;

public class IpAddressMatcher extends Application {
    @Override
    public void start(Stage stage){

        IPList ipList = new IPList();

        VBox vbRoot = new VBox(),
                vbTextField = new VBox(10);
        HBox hbTop = new HBox(10),
                hbDone = new HBox(4),
                hbLabel = new HBox(5);

        Scene scene = new Scene(vbRoot, 410, 170);
        stage.setScene(scene);
        stage.show();
        vbRoot.requestFocus();

        Image falseImage = new Image("F:\\Betrieb\\Java\\IP-Address Checker JavaFX\\src\\main\\java\\Image\\falseImage.png");
        ImageView falseView = new ImageView(falseImage);
        Image trueImage = new Image("F:\\Betrieb\\Java\\IP-Address Checker JavaFX\\src\\main\\java\\Image\\trueI.png");
        ImageView trueView = new ImageView(trueImage);
        Label ipLabel = new Label("IP-Address:");
        Label resultLabel = new Label();
        TextField textField = new TextField();
        Button buttonCheck = new Button("Check");
        Button buttonExit = new Button("Exit");
        Button buttonClear = new Button("Clear");
        Button buttonScene1 = new Button("Pass Generator");
        Button buttonScene2 = new Button("IP Matcher");
        Button buttonScene3 = new Button("String Similarity");

        buttonExit.setCancelButton(true);
        buttonCheck.setDefaultButton(true);
        textField.setPromptText("10.18.1...."); // The text in textField
        textField.setFocusTraversable(true);  // When the window turn on select directly the textField

        falseView.setFitHeight(25);
        falseView.setPreserveRatio(true);
        trueView.setFitHeight(18);
        trueView.setPreserveRatio(true);
        buttonCheck.setPrefSize(70,25);
        buttonExit.setPrefSize(70,25);
        buttonClear.setPrefSize(70,25);
        buttonScene1.setPrefSize(120,25);
        buttonScene2.setPrefSize(120,25);
        buttonScene3.setPrefSize(120,25);

        buttonCheck.setFont(Font.font("Calibri", FontWeight.BOLD, 13.5));
        buttonScene1.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
        buttonScene2.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
        buttonScene3.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
        buttonScene1.setTextFill(Paint.valueOf("#C1CDC6"));
        buttonScene2.setTextFill(Paint.valueOf("#C1CDC6"));
        buttonScene3.setTextFill(Paint.valueOf("#C1CDC6"));

        ipLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 14.5));
        ipLabel.setTextFill(Paint.valueOf("#C1CDC6"));
        resultLabel.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 18));
        resultLabel.setTextFill(Color.GREEN);
        textField.setFont(new Font("Arial", 16));
        textField.setStyle("-fx-control-inner-background:#424242; -fx-highlight-fill: #C1CDC6; -fx-highlight-text-fill: #424242; -fx-text-fill: #C1CDC6; ");

        buttonScene1.setStyle("-fx-border-color: transparent;" + "-fx-border-width: 0;" + "-fx-background-radius: 0;" + "-fx-background-color: transparent;");
        buttonScene1.setOnMouseEntered(e -> buttonScene1.setStyle("-fx-background-radius: 0;" + "-fx-background-color: transparent;" + "-fx-border-color: #00ff66;" + "-fx-border-width: 0px 0px 3px 0px;" ));
        buttonScene1.setOnMouseExited(e -> buttonScene1.setStyle("-fx-border-color: transparent;" + "-fx-border-width: 0;" + "-fx-background-radius: 0;" + "-fx-background-color: transparent;"));

        buttonScene2.setStyle("-fx-border-color: transparent;" + "-fx-border-width: 0;" + "-fx-background-radius: 0;" + "-fx-background-color: transparent;");
        buttonScene2.setOnMouseEntered(e -> buttonScene2.setStyle("-fx-background-radius: 0;" + "-fx-background-color: transparent;" + "-fx-border-color: #0099ff;" + "-fx-border-width: 0px 0px 3px 0px;" ));
        buttonScene2.setOnMouseExited(e -> buttonScene2.setStyle("-fx-border-color: transparent;" + "-fx-border-width: 0;" + "-fx-background-radius: 0;" + "-fx-background-color: transparent;"));

        buttonScene3.setStyle("-fx-border-color: transparent;" + "-fx-border-width: 0;" + "-fx-background-radius: 0;" + "-fx-background-color: transparent;");
        buttonScene3.setOnMouseEntered(e -> buttonScene3.setStyle( "-fx-background-radius: 0;" + "-fx-background-color: transparent;" + "-fx-border-color: #ff0033;" + "-fx-border-width: 0px 0px 3px 0px;" ));
        buttonScene3.setOnMouseExited(e -> buttonScene3.setStyle("-fx-border-color: transparent;" + "-fx-border-width: 0;" + "-fx-background-radius: 0;" + "-fx-background-color: transparent;"));

        hbTop.setAlignment(Pos.TOP_CENTER);
        hbTop.setStyle("-fx-background-color: rgb(33,33,33);");
        hbTop.setPadding(new Insets(5, 0, 5, 0));

        vbTextField.setAlignment(Pos.CENTER);
        vbTextField.setStyle("-fx-background-color: rgb(48,48,48);");
        vbTextField.setPadding(new Insets(0, 0, 5, 0));

        hbLabel.setAlignment(Pos.CENTER);
        hbLabel.setStyle("-fx-background-color: rgb(48,48,48);");
        hbLabel.setPadding(new Insets(15, 5, 10, 5));

        hbDone.setAlignment(Pos.BOTTOM_RIGHT);
        hbDone.setStyle("-fx-background-color: rgb(33,33,33);");
        hbDone.setPadding(new Insets(10, 15, 10, 0));

        vbRoot.setStyle("-fx-background-color: rgb(33,33,33);");

        hbTop.getChildren().addAll(buttonScene1, buttonScene2, buttonScene3);
        vbTextField.getChildren().addAll(textField, resultLabel);
        hbLabel.getChildren().addAll(ipLabel, textField, buttonClear);
        hbDone.getChildren().addAll(buttonCheck, buttonExit);
        vbRoot.getChildren().addAll(hbTop, hbLabel, vbTextField, hbDone);

        DropShadow shadow = new DropShadow(10, Color.RED); // hovered Effect

        // Here we have defined what will happen when the mouse is hovered over the buttonSearch
        buttonCheck.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> buttonCheck.setEffect(shadow));
        // Here we have defined what will happen when the mouse is removed from the buttonSearch
        buttonCheck.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> buttonCheck.setEffect(null));

        buttonExit.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> buttonExit.setEffect(shadow));
        buttonExit.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> buttonExit.setEffect(null));

        buttonClear.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> buttonClear.setEffect(shadow));
        buttonClear.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> buttonClear.setEffect(null));

        // When the button is clicked, the textField will be fetched and placed as the text of the resultLabel
        buttonCheck.setOnAction(event -> {
            Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.05), evt -> resultLabel.setVisible(false)),
                    new KeyFrame(Duration.seconds( 0.1), evt -> resultLabel.setVisible(true)));
            timeline.setRate(3);
            timeline.play();

            String x = String.valueOf(IPList.containsString2(ipList.list(), textField.getText()));
            resultLabel.setText(x);

            if (x.equals("false")){
                resultLabel.setTextFill(Color.RED);
                resultLabel.setGraphic(falseView);
            }else {
                resultLabel.setTextFill(Color.GREEN);
                resultLabel.setGraphic(trueView);
            }

            if (textField.getText().equals("")){
                resultLabel.setText("");
                resultLabel.setGraphic(null);
            }
        });

        // If Exit button press, Exit the Program
        buttonExit.setOnAction(event -> Platform.exit());

        // If Clear button press, remove the Text and result
        buttonClear.setOnAction(event -> {
            textField.clear();
            resultLabel.setText("");
            resultLabel.setGraphic(null);
        });

        // If Ip Matcher press, go to the first Scene
        buttonScene2.setOnAction(e -> stage.setScene(scene));

        // If Pass Generator press, go to the second Scene
        buttonScene1.setOnAction(e ->{
            PassGen passGen = new PassGen();
            passGen.start(stage);
        });

        // If Pass String Similarity, go to the third Scene
        buttonScene3.setOnAction(e ->{
            Compare2Strings twoStringEquail = new Compare2Strings();
            twoStringEquail.start(stage);
        });

    }
}

