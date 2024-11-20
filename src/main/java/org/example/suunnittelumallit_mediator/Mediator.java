package org.example.suunnittelumallit_mediator;

public interface Mediator {
    void registerClient(Client client);
    void sendMessage(String message, Client sender, Client recipient);
}
