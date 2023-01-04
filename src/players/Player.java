package players;

import card.Card;
import java.util.ArrayList;

public class Player {
    private final String playerName;
    private ArrayList<Card> playerHand = new ArrayList<>();

    public Player(String playerName) {
        this.playerName = playerName;
    }

    public String getName() {
        return this.playerName;
    }

    public void addCard(Card card) {
        this.playerHand.add(card);
    }

    public ArrayList<Card> getPlayerCards() {
        return this.playerHand;
    }
}
