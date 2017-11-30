package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Deck
{
    public java.util.List<Card> deck = new ArrayList<>();

    public Deck(){

    }

    public void buildDeck(int gameType) {
        if (gameType == 0) {
            for (int i = 2; i < 15; i++) {
                deck.add(new Card(i, Suit.Clubs));
                deck.add(new Card(i, Suit.Hearts));
                deck.add(new Card(i, Suit.Diamonds));
                deck.add(new Card(i, Suit.Spades));
            }
        } else {
            for (int i = 2; i < 14; i++) {
                deck.add(new Card(i, Suit.Bastos));
                deck.add(new Card(i, Suit.Oros));
                deck.add(new Card(i, Suit.Copas));
                deck.add(new Card(i, Suit.Espadas));
            }
            //changed suit.wild to suit.comodines, since that is the spanish version of the word
            deck.add(new Card(14, Suit.Comodines));
            deck.add(new Card(14, Suit.Comodines));
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

    public int deckHasCards() {
        // returns the number of values held in deck array (# of cards in deck)
        return this.deck.size();
    }
    
    //we might want to rethink this function. currently if a deck is empty it ends up passing a null value card into the columns
    public Card drawCard(){
        //pulls the top card off and returns it, otherwise it throws an exception isf there aren't any cards.
        if(this.deck.size() > 0)
        {
            Card outCard = this.deck.get(this.deck.size() -1);
            this.deck.remove(this.deck.size() -1);
            return outCard;
        }
        return null;
    }

    public void addCard(Card newCard){
        deck.add(newCard);
    }

}
