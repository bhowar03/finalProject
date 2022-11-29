import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();


        panel.setLayout(null);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel();
        label.setBounds(10, 20, 80, 25);
        panel.add(label);

        JButton button1 = new JButton("Create deck");
        button1.setBounds(30, 150,100, 35);
        button1.setFont(new Font("Arial", Font.BOLD, 10));
        button1.addActionListener(new test(button1));
        panel.add(button1);
        JButton button2 = new JButton("Add cards");
        button2.setBounds(150, 150, 100, 35);
        button2.setFont(new Font("Arial", Font.BOLD, 10));
        button2.addActionListener(new AddCards(button2));
        panel.add(button2);
        JButton button3 = new JButton("Study");
        button3.setBounds(90, 100, 100, 35);
        button3.setFont(new Font("Arial", Font.BOLD, 10));
        button3.addActionListener(new studyDeck(button3));
        panel.add(button3);

        frame.pack();
        frame.setSize(300,300);
        frame.setVisible(true);
        frame.add(panel);
    }


    public static ArrayList<String> getDecks() {
        File f = new File("./decks");
        String[] fileList = f.list();
        ArrayList<String> files = new ArrayList<>();
        for (int i=0; i< fileList.length; i++) {
            files.add(fileList[i]);
        }
        return files;
    }

    public static Deck chooseDeck() {
        ArrayList<String> deckNames = getDecks();
        for (int i=0; i<deckNames.size(); i++) {
            System.out.println((i+1) + ". " + deckNames.get(i));
        }
        System.out.print(": ");
        Scanner in = new Scanner(System.in);
        int choice = in.nextInt();
        Deck deck = new Deck(deckNames.get(choice-1));
        System.out.println();
        return deck;
    }



//    public static void study() {
//        System.out.println("Which deck would you like to study?");
//        Deck deck = chooseDeck();
//        deck.study();
//        deck.save();
//    }
//
//    public static void addCards() {
//        System.out.println("Which deck would you like to add Cards to?");
//        Deck deck = chooseDeck();
//        Scanner in = new Scanner(System.in);
//        String choice = "";
//        while (!choice.equals("no")) {
//            System.out.println("Add a question");
//            String question = in.nextLine();
//            System.out.println("Add the answer to the question");
//            String answer = in.nextLine();
//            deck.addCard(new Card(question, answer));
//            System.out.println("Would you like to add more? Type \"yes\" or \"no\"");
//            choice = in.nextLine();
//            System.out.println();
//        }
//        deck.save();
//    }
//
//    public static void createDeck() {
//        String pathName = "./decks";
//        new File(pathName).mkdir();
//        Scanner in = new Scanner(System.in);
//        System.out.print("What is the name of the deck you want to create: ");
//        String name = in.next();
//        String deckName = name + ".deck";
//        File f = new File(pathName, deckName);
//        try {
//            f.createNewFile();
//            PrintWriter out = new PrintWriter(f);
//            out.flush();
//            out.close();
//        } catch (IOException e) {
//            System.err.println("Unable to create file");
//        }
//    }
}