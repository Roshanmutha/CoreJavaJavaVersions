package com.roshanonjava.cartapplication;

public class PaymentServiceFactory {

    public static PaymentService getPaymentService(CardType cardType) {
        return switch (cardType) {
            case CREDIT -> new CreditCardPaymentService();
            case DEBIT -> new DebitCardPaymentService();
            case UPI -> new UPIPaymentService();
        };
    }
}

