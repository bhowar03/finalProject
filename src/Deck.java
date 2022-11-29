
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Deck {
    private String fileName;
    private ArrayList<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
    }

    public Deck(String name) {
        fileName = name;
        cards = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader("./decks/" + fileName);
            Scanner in = new Scanner(fileReader);
            while (in.hasNext()) {
                Card c = new Card(in);
                cards.add(c);
                in.nextLine();
            }
        } catch (FileNotFoundException e) {
            e.getMessage();
        }
    }

    public void save() {
        try {
            PrintWriter out = new PrintWriter("./decks/" + fileName);
            for (Card c : cards) {
                c.save(out);
            }
            out.flush();
            out.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        }
    }

    public void addCard(Card c) {
        cards.add(c);
    }

    public void study() {
        Collections.shuffle(cards);
        int numOfNew = 0;
        ArrayList<Card> dueCards = new ArrayList<>();
        for (int i = 0; i < cards.size(); i++) {
            if (cards.get(i).isDue() && !cards.get(i).isNew()) {
                dueCards.add(cards.get(i));
            } else if (cards.get(i).isNew() && numOfNew < 10) {
                dueCards.add(cards.get(i));
                numOfNew += 1;
            }
        }
        ArrayList<Card> wrongCards = new ArrayList<>();
        for (Card c : dueCards) {
            if (c.ask()) {
                wrongCards.add(c);
            }
        }
        while (wrongCards.size() > 0) {
            for (Card c : wrongCards) {
                if (!c.ask()) {
                    if (wrongCards.size() > 1) {
                        wrongCards.remove(c);
                    } else if (wrongCards.size() == 1) {
                        wrongCards.clear();
                        break;
                    }
                }
            }
        }
        System.out.println("All caught up!");

    }
}
