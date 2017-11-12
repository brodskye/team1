package models;

import java.util.ArrayList;
import java.util.Collections;

public class Board {
    public java.util.List<java.util.List<Card>> cols = new ArrayList<>(4);

    public Board(){
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

    public void addCardToCol(int columnTo, Card cardToMove) {
        cols.get(columnTo).add(cardToMove);
    }

    public void removeCardFromCol(int colFrom) {
        this.cols.get(colFrom).remove(this.cols.get(colFrom).size()-1);
    }


}

