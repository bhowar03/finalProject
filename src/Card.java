import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Scanner;

public class Card {
    private String question;
    private String answer;
    private LocalDate dueDate;
    private int daysBetween;
    private boolean newCard;

    private String response;


    public Card(String q, String a) {
        question = q;
        answer = a;
        daysBetween = 0;
        dueDate = LocalDate.now();
        newCard = true;
    }

    public Card(Scanner scan) {
        this.question = scan.nextLine();
        this.answer = scan.nextLine();
        this.daysBetween = Integer.parseInt(scan.nextLine());
        this.dueDate = LocalDate.parse(scan.nextLine());
        this.newCard = Boolean.parseBoolean(scan.nextLine());
    }

    public void save(PrintWriter out) {
        out.println(question);
        out.println(answer);
        out.println(daysBetween);
        out.println(dueDate.plusDays(daysBetween));
        out.println(newCard);
        out.println();
    }

    public boolean isDue() {
        if (dueDate.equals(LocalDate.now()) || dueDate.isBefore(LocalDate.now())) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isNew() {
        if (newCard) {
            return true;
        } else {
            return false;
        }
    }

    public boolean ask() {
        JFrame frame = new JFrame("Study Deck");
//        JPanel panel = new JPanel();
        frame.setLayout(new GridLayout());
//        frame.add(panel);
        frame.setVisible(true);
        frame.setBounds(00, 300, 400, 400);
//        panel.setBounds(40,80,200,200);

        JLabel label = new JLabel();
        label.setText(question);
        label.setFont(new Font("Arial", Font.PLAIN, 15));
        frame.add(label);

        JButton place = new JButton("Continue");
        frame.add(place);
        place.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText(answer);
            }
        });
        JButton clicker = new JButton("Query");
//        panel.remove(place);
        frame.add(clicker);
        clicker.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                response = "";
                JFrame panel1 = new JFrame("Query");
                panel1.setLayout(new FlowLayout());
                panel1.setBounds(200, 200, 300, 300);
                panel1.setVisible(true);
                JLabel label1 = new JLabel();
                label1.setBounds(100,100,100,100);

                label1.setText("Was that easy, correct, difficult, or wrong");
                panel1.add(label1);

                JButton easy = new JButton("Easy");
                JButton correct = new JButton("Correct");
                JButton difficult = new JButton("Difficult");
                JButton wrong = new JButton("Wrong");
                panel1.add(easy);
                panel1.add(correct);
                panel1.add(difficult);
                panel1.add(wrong);
                frame.setVisible(false);
                easy.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        response = "easy";
                        System.out.println(response);
                        panel1.setVisible(false);

                    }
                });
                correct.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        response = "correct";
                        System.out.println(response);
                        panel1.setVisible(false);
                    }
                });
                difficult.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        response = "difficult";
                        System.out.println(response);
                        panel1.setVisible(false);
                    }
                });
                wrong.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        response = "wrong";
                        System.out.println(response);
                        panel1.setVisible(false);
                    }
                });
            }
        });

        boolean valid = false;
        boolean isWrong = false;
        while (!valid && response != null) {
            switch(response) {
                case "easy":
                    daysBetween = (int)Math.round(((daysBetween + 1) * 1.5));
                    newCard = false;
                    valid = true;
                    break;
                case "correct":
                    daysBetween = (int)Math.round(((daysBetween + 1) * 1.25));
                    newCard = false;
                    valid = true;
                    break;
                case "difficult":
                    daysBetween = (int)Math.round(((daysBetween + 1) * 1.1));
                    newCard = false;
                    valid = true;
                    break;
                case "wrong":
                    daysBetween = 0;
                    newCard = false;
                    valid = true;
                    isWrong = true;
                    break;
            }
        }
        pause();
        for (int i=0; i<100; i++) {
            System.out.println();
        }
        return isWrong;
    }

    public static void pause() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {}
    }
}


