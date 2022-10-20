package com.example.passGen;

//https://stackoverflow.com/questions/43554646/javafx-button-padding-changes-button-size
//Color: https://guigarage.com/2016/02/how-to-choose-the-right-color/

import com.example.ipAddressMatcher.IpAddressMatcher;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import com.example.compare2Strings.Compare2Strings;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;


public class PassGen extends Application {
    public void start(Stage stage) {

        Image helpIcon = new Image("F:\\Betrieb\\Java\\IP-Address Checker JavaFX\\src\\main\\java\\Image\\IconS.png");

        VBox vbRoot = new VBox(),
                vbTextField = new VBox(10);
        HBox hbTop = new HBox(10),
                hbDone = new HBox(4),
                hbLabel = new HBox(10),
                hbButTex = new HBox(5);

        Scene scene = new Scene(vbRoot, 440, 190, Paint.valueOf("#000000"));
        /*        scene.getStylesheets().add("java/com.example/passGen/StyleManager.css");*/
        stage.getIcons().add(helpIcon);
        stage.setTitle("Help Tool");
        stage.setScene(scene);
        stage.show();
        vbRoot.requestFocus();

        Label passLabel = new Label("Password length:");
        TextField textField = new TextField("12");
        TextField resultTextField = new TextField();
        Button buttonOk = new Button("Ok");
        Button buttonExit = new Button("Exit");
        Button buttonScene1 = new Button("Pass Generator");
        Button buttonScene2 = new Button("IP Matcher");
        Button buttonScene3 = new Button("String Similarity");

        buttonExit.setCancelButton(true);
        buttonOk.setDefaultButton(true);

        resultTextField.setPrefWidth(300);
        buttonOk.setPrefSize(70,25);
        buttonExit.setPrefSize(70,25);
        buttonScene1.setPrefSize(120,25);
        buttonScene2.setPrefSize(120,25);
        buttonScene3.setPrefSize(120,25);

        buttonOk.setFont(Font.font("Calibri", FontWeight.BOLD, 13.5));
        buttonScene1.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
        buttonScene2.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
        buttonScene3.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
        buttonScene1.setTextFill(Paint.valueOf("#C1CDC6"));
        buttonScene2.setTextFill(Paint.valueOf("#C1CDC6"));
        buttonScene3.setTextFill(Paint.valueOf("#C1CDC6"));

        passLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 14.5));
        passLabel.setTextFill(Paint.valueOf("#C1CDC6"));
        textField.setFont(new Font("Calibri", 12));
        textField.setStyle("-fx-control-inner-background:#424242; -fx-highlight-fill: #C1CDC6; -fx-highlight-text-fill: #424242; -fx-text-fill: #C1CDC6; ");
        resultTextField.setFont(new Font("Calibri", 17));
        resultTextField.setStyle("-fx-control-inner-background:#424242; -fx-highlight-fill: #C1CDC6; -fx-highlight-text-fill: #424242; -fx-text-fill: #C1CDC6; ");

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

        hbButTex.setAlignment(Pos.CENTER);
        hbButTex.setPadding(new Insets(10, 0, 5, 0));

        vbTextField.setAlignment(Pos.CENTER);
        vbTextField.setStyle("-fx-background-color: rgb(48,48,48);");
        vbTextField.setPadding(new Insets(0, 5, 5, 0));

        hbLabel.setAlignment(Pos.CENTER);
        hbLabel.setStyle("-fx-background-color: rgb(48,48,48);");
        hbLabel.setPadding(new Insets(20, 5, 5, 5));

        hbDone.setAlignment(Pos.BOTTOM_RIGHT);
        hbDone.setStyle("-fx-background-color: rgb(33,33,33);");
        hbDone.setPadding(new Insets(10, 15, 10, 0));

        vbRoot.setStyle("-fx-background-color: rgb(33,33,33);");

        hbTop.getChildren().addAll(buttonScene1, buttonScene2, buttonScene3);
        hbButTex.getChildren().addAll(resultTextField);
        vbTextField.getChildren().addAll(textField, hbButTex);
        hbLabel.getChildren().addAll(passLabel, textField /*vbTextField*/);
        hbDone.getChildren().addAll(buttonOk, buttonExit);
        vbRoot.getChildren().addAll(hbTop, hbLabel, vbTextField, hbDone);

        DropShadow shadow = new DropShadow(10, Color.RED); // hovered Effect

        buttonOk.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> buttonOk.setEffect(shadow));
        buttonOk.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> buttonOk.setEffect(null));

        buttonExit.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> buttonExit.setEffect(shadow));
        buttonExit.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> buttonExit.setEffect(null));

        buttonOk.setOnAction(e ->{
            Random r = new Random();
            char C = (char)(r.nextInt(26) + 'A');
            char c = (char)(r.nextInt(26) + 'a');
            Set<PasswordGenerator.PasswordCharacterSet> values = new HashSet<>(EnumSet.allOf(summercharactersets.class));
            PasswordGenerator pwGenerator = new PasswordGenerator(values, Integer.parseInt(textField.getText()) - 2, Integer.parseInt(textField.getText()) -2);
            for(int i=0; i < 10; ++i) {
                resultTextField.setText(C + String.valueOf(pwGenerator.generatePassword()) + c);
            }
            resultTextField.requestFocus();
            resultTextField.selectAll();
        });

        buttonExit.setOnAction(event -> Platform.exit());

        // If Pass Generator press, go to the second Scene
        buttonScene1.setOnAction(e -> stage.setScene(scene));

        // If Ip Matcher press, go to the first Scene
        buttonScene2.setOnAction(e ->{
            IpAddressMatcher ipAddressMatcher = new IpAddressMatcher();
            ipAddressMatcher.start(stage);
        });

        // If Pass String Similarity, go to the third Scene
        buttonScene3.setOnAction(e ->{
            Compare2Strings twoStringEquail = new Compare2Strings();
            twoStringEquail.start(stage);
        });


    }

    public static void main(String[] args) {
        launch(args);
    }

    private static final char[] ALPHA_UPPER_CHARACTERS = { 'A', 'B', 'C', 'D',
            'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q',
            'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
    private static final char[] ALPHA_LOWER_CHARACTERS = { 'a', 'b', 'c', 'd',
            'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q',
            'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
    private static final char[] NUMERIC_CHARACTERS = { '0', '1', '2', '3', '4',
            '5', '6', '7', '8', '9' };
    private static final char[] SPECIAL_CHARACTERS = { '~', '`', '!', '@', '#',
            '$', '%', '^', '&', '*', '(', ')', '-', '_', '=', '+', '[', '{',
            ']', '}', '\\', '|', ';', ':', '\'', '"', ',', '<', '.', '>', '/',
            '?' };

    private enum summercharactersets implements PasswordGenerator.PasswordCharacterSet {
        ALPHA_UPPER(ALPHA_UPPER_CHARACTERS, 1),
        ALPHA_LOWER(ALPHA_LOWER_CHARACTERS, 1),
        NUMERIC(NUMERIC_CHARACTERS, 1),
        SPECIAL(SPECIAL_CHARACTERS, 1);

        private final char[] chars;
        private final int minUsage;

        summercharactersets(char[] chars, int minUsage) {
            this.chars = chars;
            this.minUsage = minUsage;
        }

        @Override
        public char[] getCharacters() {
            return chars;
        }

        @Override
        public int getMinCharacters() {
            return minUsage;
        }
    }
}
