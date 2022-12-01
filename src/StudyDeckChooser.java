import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class StudyDeckChooser implements ActionListener {

    private String deckName;
    private JButton button;
    private ArrayList<Card> cards;
    private Deck deck;

    public StudyDeckChooser(String name, JButton b) {
        deckName = name;
        button = b;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
//        System.out.println(deckName);
        deck = new Deck(deckName);

        deck.study();
        JButton test = new JButton("Save");
        JFrame frame2 = new JFrame("Save");
        frame2.add(test);
        frame2.setVisible(true);
        frame2.setBounds(100, 100, 100, 100);
        test.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deck.save();
                frame2.setVisible(false);
            }
        });
    }
}