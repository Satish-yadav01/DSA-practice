package lld.atmv2.model;

/**
 * @author : Satish Yadav
 * @purpose :
 */
public class User {
    private int id;
    private String name;
    private Card card;

    public User(int id, String name, Card card) {
        this.id = id;
        this.name = name;
        this.card = card;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}
