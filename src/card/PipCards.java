package card;

public class PipCards implements Card {
    private final int value;

    public PipCards(int value) throws IncorrectValueException {
        this.value = value;
        if(this.value < 2 | value > 10) throw new IncorrectValueException();
    }

    @Override
    public int getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return "Pip card with value " + this.getValue();
    }

    public static class IncorrectValueException extends Exception {

        private IncorrectValueException() {
            super("Wrong value assigned for pip card. The value must be between 2 and 9.");
        }
    }
}
