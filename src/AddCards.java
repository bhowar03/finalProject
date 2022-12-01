import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Lets the user input a question on the left, and an answer on the right and adds a card to the deck with a button and finishes that process with the other
class AddCards implements ActionListener {

    private String deckName;
    private JButton button;

    public AddCards(String name, JButton b) {
        deckName = name;
//        button = b;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Deck deck = new Deck(deckName);

        JFrame frame = new JFrame("Adding Cards");
        frame.setLayout(new GridLayout());

        JTextField questionField = new JTextField();
        questionField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                questionField.getText();
            }
        });
        frame.getContentPane().add(questionField);

        JTextField answerField = new JTextField();
        answerField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                answerField.getText();
            }
        });
        frame.getContentPane().add(answerField);

        JButton addButton = new JButton("Add Card");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String question = questionField.getText();
                String answer = answerField.getText();
                Card c = new Card(question, answer);
                deck.addCard(c);
            }
        });
        frame.getContentPane().add(addButton);

        JButton closeButton = new JButton("Done");
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                deck.save();
            }
        });
        frame.getContentPane().add(closeButton);

        frame.pack();
        frame.setSize(500,500);
        frame.setVisible(true);
    }
}