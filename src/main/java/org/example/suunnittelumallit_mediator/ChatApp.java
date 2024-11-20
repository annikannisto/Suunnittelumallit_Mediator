package org.example.suunnittelumallit_mediator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ChatApp extends Application {

    private static final int CLIENT_COUNT = 3;

    @Override
    public void start(Stage primaryStage) {
        try {
            ChatMediator mediator = new ChatMediator();

            for (int i = 1; i <= CLIENT_COUNT; i++) {
                String username = "User" + i;
                FXMLLoader loader = new FXMLLoader(getClass().getResource("ChatClient.fxml"));
                VBox root = loader.load();

                ChatClientController controller = loader.getController();
                controller.setMediator(mediator);
                controller.setUsername(username);

                Scene scene = new Scene(root, 400, 400);
                Stage clientStage = new Stage();
                clientStage.setTitle(username);
                clientStage.setScene(scene);
                clientStage.show();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}