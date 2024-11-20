package org.example.suunnittelumallit_mediator;

import javafx.scene.control.TextArea;

public class ChatClient extends Client {
    private TextArea messageDisplayArea;

    public ChatClient(Mediator mediator, String username, TextArea messageDisplayArea) {
        super(mediator, username);
        this.messageDisplayArea = messageDisplayArea;
    }

    @Override
    public void sendMessage(String message, Client recipient) {
        mediator.sendMessage(message, this, recipient);
    }

    @Override
    public void receiveMessage(String message, Client sender) {
        messageDisplayArea.appendText(sender.username + ": " + message + "\n");
    }
}