package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Assignment 1: Each of the blank methods below require implementation to get AcesUp to build/run
 */
public class Game {

    public java.util.List<Card> deck = new ArrayList<>();

    public java.util.List<java.util.List<Card>> cols = new ArrayList<>(4);


    public Game(){
        // initialize a new game such that each column can store cards
        for (int i = 0; i < 4; i++) {
            cols.add(new ArrayList<Card>(13));
        }
    }

    public void buildDeck() {
        for(int i = 2; i < 15; i++){
            deck.add(new Card(i,Suit.Clubs));
            deck.add(new Card(i,Suit.Hearts));
            deck.add(new Card(i,Suit.Diamonds));
            deck.add(new Card(i,Suit.Spades));
        }
    }

    public void shuffle() {
        // shuffles the deck so that it is random. random library is needed for this funtion
        Random seeded = new Random();
        for(int i = this.deck.size() - 1; i > 0; i--)
        {
            int nextIndex = seeded.nextInt(i + 1);
            Card tempCard = this.deck.get(nextIndex);
            this.deck.set(nextIndex, this.deck.get(i));
            this.deck.set(i, tempCard);
        }
    }

    public void dealFour() {
        for(int i = 0; i < 4; i++)
        {
            this.addCardToCol(i, this.topCardPop());
        }
        // remove the top card from the deck and add it to a column; repeat for each of the four columns
    }

    private Card topCardPop(){
        //pulls the top card off and returns it, otherwise it throws an exception isf there aren't any cards.
        if(this.deck.size() > 0)
        {
            Card outCard = this.deck.get(this.deck.size() -1);
            this.deck.remove(this.deck.size() -1);
            return outCard;
        }
        else
        {
            throw new RuntimeException("Deck is empty, cannot draw card.");
        }

    }
    public void remove(int columnNumber) {
        if(getTopCard(columnNumber) == null){
            System.out.println("Another column has a higher value");
            }
        for(int i = 0; i < 4; i++){
            int checkOtherColumn = ((i+1)%4);
            if(getTopCard(columnNumber).getSuit() == getTopCard(checkOtherColumn).getSuit()){
                if(getTopCard(columnNumber).getValue() < getTopCard(checkOtherColumn).getValue()){
                    this.removeCardFromCol(i);
                    }
                else{
                    System.out.println("Another column has a higher value");
                    }
                }
                else{
                    System.out.println("No other columns have the same suit");
                    }
            }
        // remove the top card from the indicated column
    }

    private boolean columnHasCards(int columnNumber) {
        // check indicated column for number of cards; if no cards return false, otherwise return true
        return this.cols.get(columnNumber).size() != 0;
    }

    private Card getTopCard(int columnNumber) {
        return this.cols.get(columnNumber).get(this.cols.get(columnNumber).size()-1);
    }


    public void move(int columnFrom, int columnTo) {
        // remove the top card from the columnFrom column, add it to the columnTo column
        // column must be empty to move a card, as per Aces Up rules
        if (columnHasCards(columnFrom) && !(columnHasCards(columnTo))) {
            Card cardToMove = getTopCard(columnFrom);
            removeCardFromCol(columnFrom);
            addCardToCol(columnTo, cardToMove);
            }
        else System.out.println("Cannot move cards into non-empty column.");
    }

    private void addCardToCol(int columnTo, Card cardToMove) {
        cols.get(columnTo).add(cardToMove);
    }

    private void removeCardFromCol(int colFrom) {
        this.cols.get(colFrom).remove(this.cols.get(colFrom).size()-1);
    }
}
