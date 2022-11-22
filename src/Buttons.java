import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import java.awt.event.ActionListener;

class test implements ActionListener {
    private JButton button1;

    public test(JButton button1){
        this.button1 = button1;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFrame frame2 = new JFrame("Create deck");
        JPanel panel2 = new JPanel();
        panel2.setLayout(null);

        JTextField textField = new JTextField();
        textField.setBounds(100, 100, 300, 100);
        panel2.add(textField);
        JButton button4 = new JButton("Enter New Deck Name");
        button4.setBounds(150, 220,200, 25);
        button4.addActionListener(new test2(button4, textField));
        panel2.add(button4);

        frame2.pack();
        frame2.setSize(500,500);
        frame2.setVisible(true);
        frame2.add(panel2);
    }
}

class test2 implements ActionListener{
    private JButton button2;
    private JTextField textField2;

    public test2(JButton button2, JTextField textField2){
        this.button2 = button2;
        this.textField2 = textField2;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String pathName = "./decks";
        new File(pathName).mkdir();
        String get = textField2.getText() + ".deck";
        File f = new File(pathName, get);
        try {
            f.createNewFile();
            PrintWriter out = new PrintWriter(f);
            out.flush();
            out.close();
        } catch (IOException g) {
            System.err.println("Unable to create file");
        }
        JFrame frame5 = new JFrame(get);
        JPanel panel5 = new JPanel();
        panel5.setLayout(null);

        frame5.pack();
        frame5.setSize(300,300);
        frame5.setVisible(true);
        frame5.add(panel5);
    }
}

class test3 implements ActionListener{
    private JButton button3;


    public test3(JButton button3){
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
        panel6.setLayout(null);



        ArrayList<String> deckNames = getDecks();

        int k = 10;
        int choice = 1;

        for (int i=0; i<deckNames.size(); i++) {
            JLabel label = new JLabel(deckNames.get(i));
            label.setBounds(20, k, 75, 25);
            JLabel label2 = new JLabel(String.valueOf(choice));
            label2.setBounds(10, k, 50, 25);
            panel6.add(label2);
            panel6.add(label);
            k = k + 10;
            choice = choice + 1;
        }
        frame6.pack();
        frame6.setSize(500,500);
        frame6.setVisible(true);
        frame6.add(panel6);
    }
}

public class Buttons {
}
