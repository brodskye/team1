public class Deck extends Card
{
    public java.util.List<Card> deck = new ArrayList<>();
    private int deckSize = 0;

    public void reateRegularDeck() //doesn't need to check for NULL because Java takes care of object lifecycle
    {
        this.deckSize = 52;
        this.cards = new Card[52];
        for (int i = 0; i < 4; i++) //Create a card and add it to the deck 
        {
            for(int j = 2; j < 15; j++)
            Card newCard = new Card(j, i);
                        //13 * i accounts for all the ranks in each suit
                        //j - 2 accounts for 2 as the starting card rank
            this.cards[(13 * i) + (j - 2)] = newCard; //places it in the array 
        }
    }
    public void shuffleCards()
    { //should work for any size deck
        Random seeded = new Random();
        for(int i = cards.length - 1; i > 0; i--)
        {
            int nextIndex = seeded.nextInt(i + 1);
            Card tempCard = cards[nextIndex];
            cards[nextIndex] = cards[i];
            cards[i] = tempCard;
        }
    }
    public Card drawCard()
    {
        if(deckSize <= 0)
            return NULL;
        
        Card tempCard = this.cards(deckSize - 1);
        this.cards(deckSize - 1) = NULL;
        this.deckSize--;
        return tempCard;
    }
}