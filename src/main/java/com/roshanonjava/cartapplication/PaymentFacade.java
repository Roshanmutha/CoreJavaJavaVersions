package com.roshanonjava.cartapplication;

public class PaymentFacade {

    public PaymentResponse makePayment(CardType cardType, int amount) {
        System.out.println("=== Payment Facade Processing ===");
        System.out.println("Card Type: " + cardType + ", Amount: " + amount);

        // Get the appropriate payment service from factory
        PaymentService paymentService = PaymentServiceFactory.getPaymentService(cardType);

        // Call the service method and return response
        PaymentResponse response = paymentService.makePayment(cardType, amount);

        System.out.println("Payment Response: " + response);
        System.out.println("=== End of Transaction ===\n");

        return response;
    }
}

