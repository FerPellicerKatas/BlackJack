package card;

public class FigureCards implements Card {
    private final String cardName;

    public FigureCards(String cardName) {
        this.cardName = cardName;
    }

    @Override
    public int getValue() {
        return 10;
    }

    @Override
    public String toString() {
        return "Face card with value " + this.getValue();
    }
}
