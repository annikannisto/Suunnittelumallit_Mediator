package org.example.suunnittelumallit_mediator;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ChatClientController {
    @FXML private TextArea messageDisplayArea;
    @FXML private TextField messageInputField;
    @FXML private ComboBox<String> recipientComboBox;
    @FXML private Button sendButton;

    private ChatClient client;
    private ChatMediator mediator;

    public void setMediator(ChatMediator mediator) {
        this.mediator = mediator;
    }

    public void setUsername(String username) {
        if (mediator == null) {
            throw new IllegalStateException("Mediator is not set");
        }
        client = new ChatClient(mediator, username, messageDisplayArea);
    }

    @FXML
    public void initialize() {
        recipientComboBox.getItems().addAll("User2", "User3", "User4");

        sendButton.setOnAction(e -> sendMessage());
    }

    @FXML
    private void sendMessage() {
        String message = messageInputField.getText();
        String recipientName = recipientComboBox.getValue();

        Client recipient = findClientByName(recipientName);

        if (recipient != null) {
            client.sendMessage(message, recipient);
            messageDisplayArea.appendText("To " + recipientName + ": " + message + "\n");
        }

        messageInputField.clear();
    }

    private Client findClientByName(String name) {
        for (Client c : mediator.getClients()) {
            if (c.username.equals(name)) {
                return c;
            }
        }
        return null;
    }
}