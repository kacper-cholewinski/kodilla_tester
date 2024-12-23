package com.kodilla.mockito.homework;

import com.kodilla.notification.Client;
import com.kodilla.notification.Notification;

import java.util.*;
import java.util.stream.Collectors;

public class WeatherAlertService {
    Map<String, Set<Subscriber>> subscriptions = new ArrayList<>(Arrays.asList("Warszawa", "Kraków", "Katowice"))
            .stream()
            .collect(Collectors.toMap(localization -> localization, localization -> new HashSet<>()));

    public void addSubscriberToLocalization(Subscriber subscriber, String localization) {
        if (subscriptions.containsKey(localization)) {
            subscriptions.get(localization).add(subscriber);
        }
    }

    public void removeSubscriberFromLocalization(Subscriber subscriber, String localization) {
        if (subscriptions.containsKey(localization)) {
            subscriptions.get(localization).remove(subscriber);
        }
    }

    public void removeSubscriberFromAllLocalizations(Subscriber subscriber) {
        subscriptions.values().forEach(subscribers -> subscribers.remove(subscriber));
    }

    public void sendNotificationToAllSubscribers(Alert alert) {
        Set<Subscriber> allSubscribers = subscriptions.values().stream().flatMap(subscribers -> subscribers.stream()).collect(Collectors.toSet());
        allSubscribers.forEach(subscriber -> subscriber.receive(alert));
    }

    public void sendNotificationToLocalSubscribers(Alert alert, String localization) {
        if (subscriptions.containsKey(localization)) {
            subscriptions.get(localization).forEach(subscriber -> subscriber.receive(alert));
        }
    }

    public void removeLocalization(String localization) {
        subscriptions.remove(localization);
    }
}
