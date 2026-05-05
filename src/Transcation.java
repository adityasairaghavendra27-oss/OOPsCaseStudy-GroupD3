abstract class Transaction {
    String paymentID;
    double amount;

    abstract void process();
}