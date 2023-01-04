package deck;

import card.Card;
import java.util.ArrayList;

public class Deck {
    private ArrayList<Card> deck = new ArrayList<>();

    public void addCard(Card card) {
        this.deck.add(card);
    }

    public ArrayList<Card> getDeckCards() {
        return this.deck;
    }
}