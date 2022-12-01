import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

// A method for studying cards
// Goes through the file and gathers the cards with recent due dates, runs through the cards and prompts a query on difficulty,
// then adjusts days between next showing of card
class StudyDeck implements ActionListener {
    private JButton studyButton;

    public StudyDeck(JButton studyButton) {
        this.studyButton = studyButton;
    }

    public static ArrayList<String> getDeck() {
        File f = new File("./decks");
        String[] fileList = f.list();
        ArrayList<String> files = new ArrayList<>();
        for (int i=0; i< fileList.length; i++) {
            files.add(fileList[i]);
        }
        return files;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFrame frame7 = new JFrame();
        JPanel panel7 = new JPanel();
        panel7.setLayout(new FlowLayout());
        ArrayList<String> deckNames = getDeck();

        for (int i=0; i<deckNames.size(); i++) {
            JButton click = new JButton(deckNames.get(i));
            click.addActionListener(new StudyDeckChooser(deckNames.get(i), click));
            panel7.add(click);
        }


        frame7.pack();
        frame7.setSize(500,500);
        frame7.setVisible(true);
        frame7.add(panel7);
    }
}