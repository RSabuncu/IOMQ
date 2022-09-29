package fx;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class main extends Application {

    public static void main(String args[]) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Picit App!!");

        StackPane stack = new StackPane();

        VBox infoPart = new VBox();
        infoPart.setPadding(new Insets(50,10,10,10));
        infoPart.setSpacing(10);

        String[] inputQueues = {
                "SCF_T11.QA.REQUEST",
                "SCF_T12.QA.REQUEST",
                "SCF_T13.QA.REQUEST"
        };
        ChoiceBox input = new ChoiceBox(FXCollections.observableArrayList(inputQueues));

        String[] outputQueues = {
                "SCF_T11.QA.RESPONSE1.DUMMY",
                "SCF_T12.QA.RESPONSE1.DUMMY",
                "SCF_T13.QA.RESPONSE1.DUMMY"
        };
        ChoiceBox output = new ChoiceBox(FXCollections.observableArrayList(outputQueues));

        TextArea message = new TextArea();
        message.setText("Enter message here");
        message.setPrefColumnCount(15);
        message.setPrefHeight(300);
        message.setPrefWidth(800);

        TextArea response = new TextArea();
        response.setPrefColumnCount(15);
        response.setPrefHeight(300);
        response.setPrefWidth(800);

        Button send = new Button("Send");
        send.setOnAction((evt) -> response.setText(message.getText() + " " + output.getSelectionModel().getSelectedItem() + " " + input.getSelectionModel().getSelectedItem())
        );

        infoPart.getChildren().addAll(input, output, message, response, send);

        stack.getChildren().add(infoPart);
        Scene scene = new Scene(stack, 900, 900);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


}


