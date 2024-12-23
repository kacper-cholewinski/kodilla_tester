package com.kodilla.mockito.homework;

import com.kodilla.notification.Client;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class WeatherAlertServiceTestSuite {
    WeatherAlertService service = new WeatherAlertService();
    Subscriber firstSubscriber = Mockito.mock(Subscriber.class);
    Subscriber secondSubscriber = Mockito.mock(Subscriber.class);
    Subscriber thirdSubscriber = Mockito.mock(Subscriber.class);
    Alert alert = Mockito.mock(Alert.class);

    @Test
    public void activeSubscriberShouldReceiveAlerts() {
        service.addSubscriberToLocalization(firstSubscriber, "Warszawa");
        service.addSubscriberToLocalization(firstSubscriber, "Kraków");
        service.addSubscriberToLocalization(secondSubscriber, "Kraków");
        service.sendNotificationToLocalSubscribers(alert, "Warszawa");
        service.sendNotificationToLocalSubscribers(alert, "Kraków");

        Mockito.verify(firstSubscriber, Mockito.times(2)).receive(alert);
        Mockito.verify(secondSubscriber, Mockito.times(1)).receive(alert);
    }

    @Test
    public void locallyRemovedSubscriberShouldNotReceiveAlerts() {
        service.addSubscriberToLocalization(firstSubscriber, "Warszawa");
        service.removeSubscriberFromLocalization(firstSubscriber, "Warszawa");
        service.sendNotificationToLocalSubscribers(alert, "Warszawa");

        Mockito.verify(firstSubscriber, Mockito.never()).receive(alert);
    }

    @Test
    public void completelyRemovedSubscriberShouldNotReceiveAlerts() {
        service.addSubscriberToLocalization(firstSubscriber, "Warszawa");
        service.addSubscriberToLocalization(firstSubscriber, "Kraków");
        service.removeSubscriberFromAllLocalizations(firstSubscriber);
        service.sendNotificationToLocalSubscribers(alert, "Warszawa");
        service.sendNotificationToLocalSubscribers(alert, "Kraków");
        service.sendNotificationToAllSubscribers(alert);

        Mockito.verify(firstSubscriber, Mockito.never()).receive(alert);
    }

    @Test
    public void locallyInactiveSubscriberShouldNotReceiveAlerts() {
        service.addSubscriberToLocalization(firstSubscriber, "Kraków");
        service.addSubscriberToLocalization(secondSubscriber, "Warszawa");
        service.sendNotificationToLocalSubscribers(alert, "Warszawa");
        service.sendNotificationToLocalSubscribers(alert, "Kraków");
        Mockito.verify(firstSubscriber, Mockito.times(1)).receive(alert);
        Mockito.verify(secondSubscriber, Mockito.times(1)).receive(alert);
    }

    @Test
    public void allSubscribersShouldReceiveGeneralAlerts() {
        service.addSubscriberToLocalization(firstSubscriber, "Kraków");
        service.addSubscriberToLocalization(secondSubscriber, "Warszawa");
        service.sendNotificationToAllSubscribers(alert);
        Mockito.verify(firstSubscriber, Mockito.times(1)).receive(alert);
        Mockito.verify(secondSubscriber, Mockito.times(1)).receive(alert);
    }

    @Test
    public void subscriberShouldNotReceiveAlertsForRemovedLocalization() {
        service.addSubscriberToLocalization(secondSubscriber, "Warszawa");
        service.removeLocalization("Warszawa");
        service.sendNotificationToLocalSubscribers(alert, "Warszawa");
        Mockito.verify(firstSubscriber, Mockito.never()).receive(alert);
    }
}
