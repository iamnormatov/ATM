public class Main {
    public static void main(String[] args) {
        Transaction transaction = new Transaction();

        Card cardOne = new Card("Uzcard", 1000, 5.600, 8600335660792625L, true);

        ATM atmOne = new ATM(124.1, "Tashkent", true);

        System.out.println(transaction.addCard(cardOne));
        System.out.println(transaction.addATM(atmOne));

        System.out.println(transaction.getCard(1));
        System.out.println(transaction.getATM(1));

        System.out.println(transaction.addMoneyToCard(1, 1000, 5.600));
        System.out.println(transaction.addMoneyToATM(1, 124.1));

        System.out.println(transaction.getCash(1, 1, 1000, 5000));


    }
}