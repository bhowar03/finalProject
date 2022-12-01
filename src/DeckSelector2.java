import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

// Goes through and lists off the decks available and lets the user select one to add cards to
class DeckSelector2 implements ActionListener {
    private JButton button3;

    public DeckSelector2(JButton button3){
        this.button3 = button3;
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

    @Override
    public void actionPerformed(ActionEvent e){
        JFrame frame6 = new JFrame();
        JPanel panel6 = new JPanel();
        panel6.setLayout(new FlowLayout());

        ArrayList<String> deckNames = getDecks();

        for (int i=0; i<deckNames.size(); i++) {
            JButton button = new JButton(deckNames.get(i));
            button.addActionListener(new AddCards(deckNames.get(i), button));
            panel6.add(button);
        }

        frame6.pack();
        frame6.setSize(500,500);
        frame6.setVisible(true);
        frame6.add(panel6);
    }
}