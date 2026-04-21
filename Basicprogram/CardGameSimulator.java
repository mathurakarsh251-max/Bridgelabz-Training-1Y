import java.util.Scanner;

public class CardGameSimulator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        String[] deck = initializeDeck(suits, ranks);
        int n = deck.length;
        deck = shuffleDeck(deck);
        System.out.print("Enter number of players: ");
        int x = scanner.nextInt();
        System.out.print("Enter number of cards per player: ");
        int cardsPerPlayer = scanner.nextInt();

        String[][] players = distributeCards(deck, x, cardsPerPlayer);
        if (players != null) {
            printHands(players);
        } else {
            System.out.println("Error: Not enough cards in the deck for " + x + " players.");
        }

        scanner.close();
    }
    public static String[] initializeDeck(String[] suits, String[] ranks) {
        String[] deck = new String[suits.length * ranks.length];
        int index = 0;
        for (String suit : suits) {
            for (String rank : ranks) {
                deck[index++] = rank + " of " + suit;
            }
        }
        return deck;
    }
    public static String[] shuffleDeck(String[] deck) {
        int n = deck.length;
        for (int i = 0; i < n; i++) 
            int r = i + (int) (Math.random() * (n - i));
            String temp = deck[r];
            deck[r] = deck[i];
            deck[i] = temp;
        }
        return deck;
    }
    public static String[][] distributeCards(String[] deck, int numPlayers, int cardsPerPlayer) {
        if (numPlayers * cardsPerPlayer > deck.length) {
            return null; 