package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Assignment 1: Each of the blank methods below require implementation to get AcesUp to build/run
 */
public class Game {

    public Deck deck;
    public java.util.List<java.util.List<Card>> cols = new ArrayList<>(4);

    public Game(){
        deck = new Deck();
        for (int i = 0; i < 4; i++) {
            cols.add(new ArrayList<Card>(13));
        }
    }

    public boolean columnHasCards(int columnNumber) {
        // check indicated column for number of cards; if no cards return false, otherwise return true
        return this.cols.get(columnNumber).size() != 0;
    }

    public Card getTopCard(int columnNumber) {
        return this.cols.get(columnNumber).get(this.cols.get(columnNumber).size()-1);
    }

    public void remove(int columnNumber) {
        if (columnHasCards(columnNumber)) {
            Card c = getTopCard(columnNumber);
            boolean removeCard = false;
            for (int i = 0; i < 4; i++) {
                if (i != columnNumber) {
                    if (columnHasCards(i)) {
                        Card compare = getTopCard(i);
                        if (compare.getSuit() == c.getSuit()) {
                            if (compare.getValue() > c.getValue()) {
                                removeCard = true;
                            }
                        }
                    }
                }
            }
            if (removeCard) {
                this.cols.get(columnNumber).remove(this.cols.get(columnNumber).size() - 1);
            }
        } else {
            return;
    }

    public void move(int columnFrom, int columnTo) {
        // remove the top card from the columnFrom column, add it to the columnTo column
        // column must be empty to move a card, as per Aces Up rules
        if (columnHasCards(columnFrom) && !(columnHasCards(columnTo))) {
            Card cardToMove = getTopCard(columnFrom);
            if(cardToMove.getValue() == 14){
                removeCardFromCol(columnFrom);
                addCardToCol(columnTo, cardToMove);
            }
            else System.out.println("Cannot move non-aces into empty column");
        }
        else System.out.println("Cannot move cards into non-empty column.");
    }

    public void addCardToCol(int columnTo, Card cardToMove) {
        cols.get(columnTo).add(cardToMove);
    }

    public void removeCardFromCol(int colFrom) {
        this.cols.get(colFrom).remove(this.cols.get(colFrom).size()-1);
    }

    public void dealFour() {
        for(int i = 0; i < 4; i++)
        {
            cols.get(i).add(deck.drawCard());
        }
        // remove the top card from the deck and add it to a column; repeat for each of the four columns
    }
}
