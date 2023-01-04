package players;

import card.Card;
import java.util.ArrayList;

public class Croupier {
    private final String croupierName;
    private ArrayList<Card> croupierHand = new ArrayList<>();

    public Croupier(String croupierName) {
        this.croupierName = croupierName;
    }

    public String getName() {
        return this.croupierName;
    }

    public void addCard(Card card) {
        this.croupierHand.add(card);
    }

    public ArrayList<Card> getCroupierCards() {
        return this.croupierHand;
    }
}
