package com.kodilla.mockito;

import com.kodilla.notification.Client;
import com.kodilla.notification.Notification;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NotificationService {

    private Set<Client> clients = new HashSet<>();

    public void addSubscriber(Client client) {
        clients.add(client);
    }

    public void sendNotification(Notification notification) {
        clients.forEach(client -> client.receive(notification));
    }

    public void removeSubscriber(Client client) {
        clients.remove(client);
    }
}