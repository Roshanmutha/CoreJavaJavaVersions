package com.roshanonjava.cartapplication;

public sealed interface PaymentService permits CreditCardPaymentService, DebitCardPaymentService, UPIPaymentService {
    PaymentResponse makePayment(CardType cardType, int amount);
}

