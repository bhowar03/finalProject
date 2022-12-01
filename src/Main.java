import javax.swing.*;
import java.awt.*;
import java.io.File;
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
        button1.addActionListener(new CreateDeck(button1));
        panel.add(button1);
        JButton button2 = new JButton("Add cards");
        button2.setBounds(150, 150, 100, 35);
        button2.setFont(new Font("Arial", Font.BOLD, 10));
        button2.addActionListener(new DeckSelector2(button2));
        panel.add(button2);
        JButton button3 = new JButton("Study");
        button3.setBounds(90, 100, 100, 35);
        button3.setFont(new Font("Arial", Font.BOLD, 10));
        button3.addActionListener(new StudyDeck(button3));
        panel.add(button3);

        frame.pack();
        frame.setSize(300,300);
        frame.setVisible(true);
        frame.add(panel);
    }


//    public static ArrayList<String> getDecks() {
//        File f = new File("./decks");
//        String[] fileList = f.list();
//        ArrayList<String> files = new ArrayList<>();
//        for (int i=0; i< fileList.length; i++) {
//            files.add(fileList[i]);
//        }
//        return files;
//    }


}