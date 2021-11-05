package learn.cards;

public enum Suit {
    HEARTS("Hearts"),
    DIAMONDS("Diamonds"),
    SPADES("Spades"),
    CLUBS("Clubs");

    private final String name;


    Suit(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}