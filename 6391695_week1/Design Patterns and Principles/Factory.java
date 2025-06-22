interface Notification {
    void notifyUser();
}

class SMSNotification implements Notification {
    public void notifyUser() {
        System.out.println("Sending an SMS Notification");
    }
}

class EmailNotification implements Notification {
    public void notifyUser() {
        System.out.println("Sending an Email Notification");
    }
}

class PushNotification implements Notification {
    public void notifyUser() {
        System.out.println("Sending a Push Notification");
    }
}

abstract class NotificationFactory {
    public abstract Notification createNotification();
}

class SMSNotificationFactory extends NotificationFactory {
    public Notification createNotification() {
        return new SMSNotification();
    }
}

class EmailNotificationFactory extends NotificationFactory {
    public Notification createNotification() {
        return new EmailNotification();
    }
}

class PushNotificationFactory extends NotificationFactory {
    public Notification createNotification() {
        return new PushNotification();
    }
}

public class Factory {
    public static void main(String[] args) {
        NotificationFactory factory = new SMSNotificationFactory();
        Notification notification = factory.createNotification();
        notification.notifyUser();
    }
}