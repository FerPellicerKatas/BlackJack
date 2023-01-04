package test;

import blackjack.BlackJackApp;
import card.*;
import deck.Deck;
import players.*;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BlackJackTest {
    
    @Test
    public void test_hand_value_with_one_card() throws PipCards.IncorrectValueException {
        assertEquals(3, new PipCards(3).getValue());
        assertEquals(10, new PipCards(10).getValue());
        assertEquals(10, new FigureCards("J").getValue());
        assertEquals(10, new FigureCards("Q").getValue());
        assertEquals(10, new FigureCards("K").getValue());
        assertEquals(11, new Ace().getValue());
    }

    @Test
    public void case1() {
        Player player1 = new Player("Fernando");
        try {
            player1.addCard(new FigureCards("J"));
            player1.addCard(new Ace());
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }

        Player player2 = new Player("Jose Juan");
        try {
            player2.addCard(new PipCards(10));
            player2.addCard(new PipCards(5));
            player2.addCard(new PipCards(6));
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }

        Player player3 = new Player("Pablo");
        try {
            player3.addCard(new PipCards(3));
            player3.addCard(new PipCards(6));
            player3.addCard(new Ace());
            player3.addCard(new PipCards(3));
            player3.addCard(new Ace());
            player3.addCard(new FigureCards("K"));
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }

        Croupier croupier = new Croupier("Croupier");
        try {
            croupier.addCard(new PipCards(9));
            croupier.addCard(new PipCards(7));
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }

        Deck deck = new Deck();
        try {
            deck.addCard(new PipCards(5));
            deck.addCard(new PipCards(4));
            deck.addCard(new FigureCards("K"));
            deck.addCard(new PipCards(2));
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }

        ArrayList<String> winners = new ArrayList<>();
        winners.add("Player 1");
        assertEquals(winners, BlackJackApp.getWinners(player1.getPlayerCards(), player2.getPlayerCards(),
                player3.getPlayerCards(), croupier.getCroupierCards(), deck.getDeckCards()));
    }

    @Test
    public void case2_player2_totals21() {
        Player player1 = new Player("Player 1");
        try {
            player1.addCard(new FigureCards("J"));
            player1.addCard(new PipCards(6));
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }

        Player player2 = new Player("Player 2");
        try {
            player2.addCard(new PipCards(10));
            player2.addCard(new PipCards(5));
            player2.addCard(new PipCards(6));
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }

        Player player3 = new Player("Player 3");
        try {
            player3.addCard(new PipCards(5));
            player3.addCard(new PipCards(6));
            player3.addCard(new PipCards(7));
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }

        Croupier croupier = new Croupier("Croupier");
        try {
            croupier.addCard(new PipCards(4));
            croupier.addCard(new PipCards(7));
            croupier.addCard(new PipCards(9));
        } catch(Exception exception) {
            System.out.println(exception.getMessage());
        }

        Deck deck = new Deck();
        try {
            deck.addCard(new PipCards(3));
            deck.addCard(new PipCards(3));
            deck.addCard(new FigureCards("K"));
            deck.addCard(new PipCards(2));
        } catch(Exception exception) {
            System.out.println(exception.getMessage());
        }

        ArrayList<String> winners = new ArrayList<>();
        winners.add("Player 2");
        assertEquals(winners, BlackJackApp.getWinners(player1.getPlayerCards(), player2.getPlayerCards(),
                    player3.getPlayerCards(), croupier.getCroupierCards(), deck.getDeckCards()));
    }

    @Test
    public void case3_Nplayers_have_blackjack() {
        Player player1 = new Player("Player 1");
        player1.addCard(new FigureCards("J"));
        player1.addCard(new Ace());

        Player player2 = new Player("Player 2");
        player2.addCard(new FigureCards("J"));
        player2.addCard(new Ace());

        Player player3 = new Player("Player 3");
        try {
            player3.addCard(new Ace());
            player3.addCard(new PipCards(5));
            player3.addCard(new PipCards(6));
            player3.addCard(new FigureCards("J"));
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }

        Croupier croupier = new Croupier("Croupier");
        try {
            croupier.addCard(new PipCards(5));
            croupier.addCard(new PipCards(10));
        } catch(Exception exception) {
            System.out.println(exception.getMessage());
        }

        Deck deck = new Deck();
        try {
            deck.addCard(new Ace());
            deck.addCard(new PipCards(3));
            deck.addCard(new FigureCards("K"));
            deck.addCard(new PipCards(2));
        } catch(Exception exception) {
            System.out.println(exception.getMessage());
        }

        ArrayList<String> winners = new ArrayList<>();
        winners.add("Player 1");
        winners.add("Player 2");
        assertEquals(winners, BlackJackApp.getWinners(player1.getPlayerCards(), player2.getPlayerCards(),
                player3.getPlayerCards(), croupier.getCroupierCards(), deck.getDeckCards()));
    }

    @Test
    public void case4_player1_has_highest_points() {
        Player player1 = new Player("Player 1");
        try {
            player1.addCard(new PipCards(8));
            player1.addCard(new PipCards(2));
            player1.addCard(new PipCards(9));
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }

        Player player2 = new Player("Player 2");
        try {
            player2.addCard(new PipCards(5));
            player2.addCard(new PipCards(9));
            player2.addCard(new PipCards(4));
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }

        Player player3 = new Player("Player 3");
        try {
            player3.addCard(new PipCards(10));
            player3.addCard(new PipCards(10));
            player3.addCard(new PipCards(5));
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }

        Croupier croupier = new Croupier("Croupier");
        try {
            croupier.addCard(new PipCards(5));
            croupier.addCard(new FigureCards("Q"));
            croupier.addCard(new PipCards(3));
        } catch(Exception exception) {
            System.out.println(exception.getMessage());
        }

        Deck deck = new Deck();
        try {
            deck.addCard(new PipCards(4));
            deck.addCard(new PipCards(5));
            deck.addCard(new PipCards(8));
            deck.addCard(new FigureCards("Q"));
        } catch(Exception exception) {
            System.out.println(exception.getMessage());
        }

        ArrayList<String> winners = new ArrayList<>();
        winners.add("Player 1");
        assertEquals(winners, BlackJackApp.getWinners(player1.getPlayerCards(), player2.getPlayerCards(),
                player3.getPlayerCards(), croupier.getCroupierCards(), deck.getDeckCards()));
    }
}
