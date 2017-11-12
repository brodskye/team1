package models;

import java.util.ArrayList;
import java.util.Collections;

public class Discard {
    public java.util.List<Card> discard = new ArrayList<>();

    public void addCard(Card newCard){
        this.discard.add(newCard);
    }

    public int score(){
        return this.discard.size();
    }

}