package org.example.suunnittelumallit_mediator;

public abstract class Client {
    protected Mediator mediator;
    public String username;

    public Client(Mediator mediator, String username) {
        this.mediator = mediator;
        this.username = username;
        this.mediator.registerClient(this);
    }

    public abstract void sendMessage(String message, Client recipient);
    public abstract void receiveMessage(String message, Client sender);
}