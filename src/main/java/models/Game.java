package models;



public class Game {

    public Deck deck;
    public Board board;

    public void dealFour() {
        for(int i = 0; i < 4; i++)
        {
            board.addCardToCol(i, deck.drawCard());
        }
        // remove the top card from the deck and add it to a column; repeat for each of the four columns
    }
}
