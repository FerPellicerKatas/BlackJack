package blackjack;

import card.Ace;
import card.FigureCards;
import card.PipCards;
import deck.Deck;
import players.Player;
import java.util.ArrayList;
import players.Croupier;

public class Main {
        public static void main(String[] args) throws PipCards.IncorrectValueException {
        System.out.println("Caso de ejemplo");
        case1();
        System.out.println("\n\n");
    }
    
    private static void case1() throws PipCards.IncorrectValueException{
        Player P1 = new Player("Player 1"), 
           P2 = new Player("Player 2"), 
           P3 = new Player("Player 3");
                
        Croupier croupier = new Croupier("Croupier");
        
        Deck deck = new Deck();
        
        
        System.out.println("###Caso 1");
        
        P1.addCard(new PipCards(5));
        P1.addCard(new PipCards(4));
        P1.addCard(new Ace());
        P1.addCard(new FigureCards("K"));
        
        P2.addCard(new PipCards(10));
        P2.addCard(new PipCards(4));
        P2.addCard(new PipCards(7));
        
        P3.addCard(new FigureCards("J"));
        P3.addCard(new Ace());
        
        croupier.addCard(new PipCards(8));
        croupier.addCard(new PipCards(8));
        
        deck.addCard(new PipCards(6));
        deck.addCard(new PipCards(8));
        deck.addCard(new FigureCards("K"));
        deck.addCard(new PipCards(2));
        
        System.out.println(P1.toString() + "(" + BlackJackApp.getHandPoints
        (P1.getPlayerCards()) + ")");
        System.out.println(P2.toString() + "(" +  BlackJackApp.getHandPoints
        (P2.getPlayerCards()) + ")");
        System.out.println(P3.toString() + "(" +  BlackJackApp.getHandPoints
        (P3.getPlayerCards()) + ")");
        System.out.println(croupier.toString() + "(" +  BlackJackApp
                .getHandPoints(croupier.getCroupierCards()) + ")");

        System.out.println("Deck: " + deck.toString() + "\n");
        
        
        ArrayList<String> winners = BlackJackApp.getWinners(P1.getPlayerCards(),
                P2.getPlayerCards(),P3.getPlayerCards(), 
                croupier.getCroupierCards(), deck.getDeckCards());
        String w = "[";
        for (String winner : winners) {
            w += winner + ", ";
        }
        System.out.println("getWinners(..) -----> " + 
                w.substring(0,w.length()-2) + "]");
    }    
}