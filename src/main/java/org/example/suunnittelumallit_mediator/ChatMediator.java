package org.example.suunnittelumallit_mediator;

import java.util.ArrayList;
import java.util.List;

public class ChatMediator implements Mediator {
    private List<Client> clients;

    public ChatMediator() {
        this.clients = new ArrayList<>();
    }

    @Override
    public void registerClient(Client client) {
        this.clients.add(client);
    }

    @Override
    public void sendMessage(String message, Client sender, Client recipient) {
        recipient.receiveMessage(message, sender);
    }

    public List<Client> getClients() {
        return clients;
    }
}