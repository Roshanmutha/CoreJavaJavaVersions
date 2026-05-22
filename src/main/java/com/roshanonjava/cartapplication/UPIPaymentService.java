package com.roshanonjava.cartapplication;

public final class UPIPaymentService implements PaymentService {

    @Override
    public PaymentResponse makePayment(CardType cardType, int amount) {
        System.out.println("Processing " + cardType + " Payment of amount: " + amount);
        // Simulate payment processing
        if (amount > 0 && amount <= 100000) {
            System.out.println("UPI Payment Successful");
            return PaymentResponse.SUCCESS;
        }
        System.out.println("UPI Payment Failed");
        return PaymentResponse.FAILURE;
    }
}

