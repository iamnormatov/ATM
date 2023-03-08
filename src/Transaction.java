import java.util.ArrayList;
import java.util.List;

public class Transaction {
    private List<ATM> atmList;
    private List<Card> cardList;
    private Integer atmIndex;
    private Integer cardIndex;
    public Transaction(){
        this.atmList = new ArrayList<>();
        this.cardList = new ArrayList<>();
        this.atmIndex = 0;
        this.cardIndex = 0;
    }

    public String addCard(Card card){
        if (card.getPinCode().toString().length() != 4){
            return "Error pin code";
        }
        if (card.getCardCode().toString().length() != 16){
            return "Error card number";
        }
        if (card.getSumma() < 0){
            return "Wrong balans";
        }

        card.setCardId(++this.cardIndex);
        this.cardList.add(card);
        return "Card successful added";
    }


    public String addATM(ATM atm){
        if (atm.getBalance() < 0){
            return "Wrong atm balans";
        }
        atm.setMachineId(++this.atmIndex);
        this.atmList.add(atm);
        return "ATM successful added";
    }

    public String getCard(Integer cartId){
        for (Card card : this.cardList) {
            if (card.getCardId().equals(cartId)){
                return card.toCard();
            }
        }
        return "Card is not found";
    }
    public String getATM(Integer machineId){
        for (ATM atm : this.atmList) {
            if (atm.getMachineId().equals(machineId)){
                return atm.toATM();
            }
        }
        return "Card is not found";
    }


    public String removeCard(Integer id){
        for (Card card : this.cardList) {
            if (card.getCardId().equals(id)){
                this.cardList.remove(card);
                return "Card successful removed";
            }
        }
        return "Card is not found";
    }
    public String removeATM(Integer id){
        for (ATM atm : this.atmList) {
            if (atm.getMachineId().equals(id)){
                this.atmList.remove(atm);
                return "ATM succesfull removed";
            }
        }
        return "ATM is not found";
    }


    public String addMoneyToCard(Integer cardId, Integer pincode, Double balance){
        for (Card card : this.cardList) {
            if (card.getCardId().equals(cardId)){
                if (card.getPinCode().equals(pincode)){
                    card.setSumma(card.getSumma() + balance);
                    this.cardList.add(card);
                    return "Money successful added to Card";
                }
            }
        }
        return  "Not found Card";
    }
    public String addMoneyToATM(Integer machineId, Double balance){
        for (ATM atm : this.atmList) {
            if (atm.getMachineId().equals(machineId)) {
                atm.setBalance(atm.getBalance() + balance);
                this.atmList.add(atm);
                return "Money successful added to ATM";
            }
        }
        return "Not found ATM";
    }


    public String removeMoneyToCard(Integer cardId, Integer pinCode, Double summa){
        for (Card card : this.cardList) {
            if (card.getCardId().equals(cardId)){
                if (card.getPinCode().equals(pinCode)){
                    if (card.getSumma() > summa){
                        card.setSumma(card.getSumma() - summa);
                        this.cardList.remove(card);
                        return "Successful withdraw money";
                    }
                }
            }
        }
        return "Card haven't money";
    }
    public String removeMoneyToATM(Integer machineId, Double summa){
        for (ATM atm : this.atmList) {
            if (atm.getMachineId().equals(machineId)){
                if (atm.getBalance() > summa){
                    atm.setBalance(atm.getBalance() - summa);
                    this.atmList.remove(atm);
                    return "Successful withdraw money";
                }
            }
        }
        return "ATM haven't money";
    }

    public String getCash(Integer cardId, Integer machineId, Integer pinCode, Integer cash){
        for (Card card : this.cardList) {
            if (card.getCardId().equals(cardId)){
                if (card.getPinCode().equals(pinCode)){
                    for (ATM atm : this.atmList) {
                        if (atm.getMachineId().equals(machineId)){
                            if (atm.getBalance() > cash + card.getSumma()){
                                atm.setBalance(card.getSumma() - cash);
                                card.setSumma(atm.getBalance() - cash);
                                this.cardList.add(card);
                                this.atmList.add(atm);
                                return "Get the money";
                            }
                        }else {
                            return "ATM is not found";
                        }
                    }
                }else {
                    return "Wrong pincode";
                }
            } else {
                return "Card is not found";
            }
        }
        return "Not enough money";
    }

    public String changePinCodeInCard(Integer cardId, Integer oldPin, Integer newPin){
        for (Card card : this.cardList) {
            if (card.getCardId().equals(cardId)){
                if (card.getPinCode().equals(oldPin)){
                    card.setPinCode(newPin);
                    return "Successful change pincode";
                }else {
                    return  "Wrong pincode";
                }
            }
        }
        return "Card is not found";
    }

    public String sendmoney(Integer senderCardId, Integer pinCode, Integer receivecardId, Long cardCode, Double summa){
        for (Card card : this.cardList) {
            if (card.getCardId().equals(senderCardId)){
                if (card.getPinCode().equals(pinCode)){
                    for (Card cardTwo : cardList) {
                        if (cardTwo.getCardId().equals(receivecardId)) {
                            if (cardTwo.getCardCode().equals(cardCode)) {
                                card.setSumma(card.getSumma() - summa);
                                cardTwo.setSumma(cardTwo.getSumma() + summa);
                            }else {
                                return "Wrong cardcode";
                            }
                        }else {
                            return "Card is not found";
                        }
                    }
                }else {
                    return "Wrong pincode";
                }
            }else {
                return "Card is not found";
            }
        }
        return "An error occurred";
    }
}
