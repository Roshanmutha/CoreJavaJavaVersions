package com.roshanonjava.cartapplication;

public class PaymentDemo {

    public static void main(String[] args) {
        PaymentFacade paymentFacade = new PaymentFacade();

        System.out.println("========== Payment Application Demo ==========\n");

        // Test Credit Card Payment
        paymentFacade.makePayment(CardType.CREDIT, 5000);

        // Test Debit Card Payment
        paymentFacade.makePayment(CardType.DEBIT, 10000);

        // Test UPI Payment
        paymentFacade.makePayment(CardType.UPI, 2500);

        // Test Failed Payment (negative amount)
        paymentFacade.makePayment(CardType.CREDIT, -1000);

        // Test Large Amount Payment (Debit Card Limit)
        paymentFacade.makePayment(CardType.DEBIT, 150000);

        System.out.println("========== End of Demo ==========");
    }
}

