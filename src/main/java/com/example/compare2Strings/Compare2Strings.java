package com.example.compare2Strings;

import com.example.ipAddressMatcher.IpAddressMatcher;
import com.example.passGen.PassGen;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Compare2Strings extends Application {
    public void start(Stage stage) {

        VBox vbRoot = new VBox(),
                vbResult = new VBox(10),
                vrCharL = new VBox(5),
                vrCharR = new VBox(5);
        HBox hbTop = new HBox(10),
                hbDone = new HBox(4),
                hbTextArea = new HBox(10),
                hbButCR = new HBox(5),
                hbButCL = new HBox(5);

        Scene scene = new Scene(vbRoot, 800, 530);
        stage.setScene(scene);
        stage.show();
        vbRoot.requestFocus();

        Image falseImage = new Image("F:\\Betrieb\\Java\\IP-Address Checker JavaFX\\src\\main\\java\\Image\\falseImage.png");
        ImageView falseView = new ImageView(falseImage);
        Image trueImage = new Image("F:\\Betrieb\\Java\\IP-Address Checker JavaFX\\src\\main\\java\\Image\\trueI.png");
        ImageView trueView = new ImageView(trueImage);
        TextArea textAreaRight = new TextArea();
        TextArea textAreaLeft = new TextArea();
        Label charsLabelL = new Label("Characters: 0");
        Label charsLabelR = new Label("Characters: 0");
        Label resultLabel = new Label();
        Button buttonCheck = new Button("Check");
        Button buttonExit = new Button("Exit");
        Button buttonCR = new Button("C");
        Button buttonCL = new Button("C");
        Button buttonCAll = new Button("CAll");
        Button buttonScene1 = new Button("Pass Generator");
        Button buttonScene2 = new Button("IP Matcher");
        Button buttonScene3 = new Button("String Similarity");

        buttonExit.setCancelButton(true);
        buttonCheck.setDefaultButton(true);
        textAreaRight.setWrapText(true);
        textAreaLeft.setWrapText(true);

        falseView.setFitHeight(25);
        falseView.setPreserveRatio(true);
        trueView.setFitHeight(18);
        trueView.setPreserveRatio(true);
        textAreaRight.setPrefSize(360,350);
        textAreaLeft.setPrefSize(360,350);
        buttonCheck.setPrefSize(70,25);
        buttonExit.setPrefSize(70,25);
        buttonCAll.setPrefSize(70,25);
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

        charsLabelL.setFont(Font.font("Verdana", FontPosture.ITALIC, 14));
        charsLabelL.setStyle("-fx-control-inner-background:#424242; -fx-highlight-fill: #C1CDC6; -fx-highlight-text-fill: #424242; -fx-text-fill: #C1CDC6; ");
        charsLabelR.setFont(Font.font("Verdana", FontPosture.ITALIC, 14));
        charsLabelR.setStyle("-fx-control-inner-background:#424242; -fx-highlight-fill: #C1CDC6; -fx-highlight-text-fill: #424242; -fx-text-fill: #C1CDC6; ");
        resultLabel.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 20));
        textAreaLeft.setFont(new Font("Calibri", 16));
        textAreaLeft.setStyle("-fx-control-inner-background:#424242; -fx-highlight-fill: #C1CDC6; -fx-highlight-text-fill: #424242; -fx-text-fill: #C1CDC6; ");
        textAreaRight.setFont(new Font("Calibri", 16));
        textAreaRight.setStyle("-fx-control-inner-background:#424242; -fx-highlight-fill: #C1CDC6; -fx-highlight-text-fill: #424242; -fx-text-fill: #C1CDC6; ");

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

        hbTextArea.setAlignment(Pos.CENTER);
        hbTextArea.setStyle("-fx-background-color: rgb(48,48,48);");
        hbTextArea.setPadding(new Insets(10, 0, 5, 0));

        vbResult.setAlignment(Pos.CENTER);
        vbResult.setStyle("-fx-background-color: rgb(48,48,48);");
        vbResult.setPadding(new Insets(10, 0, 5, 0));

        hbDone.setAlignment(Pos.BOTTOM_RIGHT);
        hbDone.setStyle("-fx-background-color: rgb(33,33,33);");
        hbDone.setPadding(new Insets(10, 15, 10, 0));

        vbRoot.setStyle("-fx-background-color: rgb(33,33,33);");

        hbTop.getChildren().addAll(buttonScene1, buttonScene2, buttonScene3);
        vrCharL.getChildren().addAll(textAreaLeft, charsLabelL);
        hbButCL.getChildren().addAll(buttonCL, vrCharL);


        vrCharR.getChildren().addAll(textAreaRight, charsLabelR);
        hbButCR.getChildren().addAll(vrCharR, buttonCR);
        hbTextArea.getChildren().addAll(hbButCL, hbButCR);

        vbResult.getChildren().addAll(hbTextArea , resultLabel);
        hbDone.getChildren().addAll(buttonCheck, buttonCAll, buttonExit);
        vbRoot.getChildren().addAll(hbTop, vbResult, hbDone);

        DropShadow shadow = new DropShadow(10, Color.RED); // hovered Effect

        buttonCheck.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> buttonCheck.setEffect(shadow));
        buttonCheck.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> buttonCheck.setEffect(null));

        buttonExit.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> buttonExit.setEffect(shadow));
        buttonExit.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> buttonExit.setEffect(null));

        buttonCAll.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> buttonCAll.setEffect(shadow));
        buttonCAll.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> buttonCAll.setEffect(null));

        buttonCL.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> buttonCL.setEffect(shadow));
        buttonCL.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> buttonCL.setEffect(null));

        buttonCR.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> buttonCR.setEffect(shadow));
        buttonCR.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> buttonCR.setEffect(null));

        buttonCheck.setOnAction(event -> {
            Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.05), evt -> resultLabel.setVisible(false)),
                    new KeyFrame(Duration.seconds( 0.1), evt -> resultLabel.setVisible(true)));
            timeline.setRate(3);
            timeline.play();

            String x = CheckEq2Stringh.checkStr(textAreaLeft.getText(), textAreaRight.getText());
            resultLabel.setText(x);

            if (x.equals("false")){
                resultLabel.setTextFill(Color.RED);
                resultLabel.setGraphic(falseView);
            }else if(x.equals("true")){
                resultLabel.setTextFill(Color.GREEN);
                resultLabel.setGraphic(trueView);
            }
        });

        textAreaLeft.setOnKeyReleased(e -> { charsLabelL.setText("Characters: " + textAreaLeft.getText().length()); });
        textAreaRight.setOnKeyReleased(e -> { charsLabelR.setText("Characters: " + textAreaRight.getText().length()); });

        buttonCL.setOnAction(event -> {textAreaLeft.clear(); charsLabelL.setText("Characters: 0"); resultLabel.setText(""); resultLabel.setGraphic(null);});
        buttonCR.setOnAction(event -> {textAreaRight.clear(); charsLabelR.setText("Characters: 0"); resultLabel.setText(""); resultLabel.setGraphic(null);});

        buttonCAll.setOnAction(event -> {
            textAreaRight.clear();
            textAreaLeft.clear();
            resultLabel.setText("");
            resultLabel.setGraphic(null);
            charsLabelL.setText("Characters: 0");
            charsLabelR.setText("Characters: 0");
        });

        buttonExit.setOnAction(event -> Platform.exit());

        // If Pass Generator press, go to the second Scene
        buttonScene1.setOnAction(e ->{
            PassGen passGen = new PassGen();
            passGen.start(stage);
        });

        // If Ip Matcher press, go to the first Scene
        buttonScene2.setOnAction(e ->{
            IpAddressMatcher helloApplication = new IpAddressMatcher();
            helloApplication.start(stage);
        });

        buttonScene3.setOnAction(e -> stage.setScene(scene));


    }
}

//java -jar IP-AddressCheckerJavaFX.jar

