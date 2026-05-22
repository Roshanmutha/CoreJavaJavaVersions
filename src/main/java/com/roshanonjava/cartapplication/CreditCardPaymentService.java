package com.roshanonjava.cartapplication;

public final class CreditCardPaymentService implements PaymentService {

    @Override
    public PaymentResponse makePayment(CardType cardType, int amount) {
        System.out.println("Processing " + cardType + " Payment of amount: " + amount);
        // Simulate payment processing
        if (amount > 0) {
            System.out.println("Credit Card Payment Successful");
            return PaymentResponse.SUCCESS;
        }
        System.out.println("Credit Card Payment Failed");
        return PaymentResponse.FAILURE;
    }
}

