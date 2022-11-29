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
        frame.setLayout(new GridLayout());

        JLabel label = new JLabel();
        label.setText(question);
        frame.add(label);

        JButton place = new JButton("Continue");
        frame.add(place);
        place.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText(answer);
            }
        });

//
//
//
//        Scanner in = new Scanner(System.in);
//        String choice = "";
//        System.out.println("Press enter when you are ready to flip");
//        choice = in.nextLine();
//        if (choice.equals("")) {
//            System.out.println(answer);
//        }
//        boolean valid = false;
//        boolean isWrong = false;
//        while (!valid) {
//            System.out.println("Was that easy, correct, difficult, or wrong");
//            String response = in.next();
//            switch(response) {
//                case "easy":
//                    daysBetween = (int)Math.round(((daysBetween + 1) * 1.5));
//                    newCard = false;
//                    valid = true;
//                    break;
//                case "correct":
//                    daysBetween = (int)Math.round(((daysBetween + 1) * 1.25));
//                    newCard = false;
//                    valid = true;
//                    break;
//                case "difficult":
//                    daysBetween = (int)Math.round(((daysBetween + 1) * 1.1));
//                    newCard = false;
//                    valid = true;
//                    break;
//                case "wrong":
//                    daysBetween = 0;
//                    newCard = false;
//                    valid = true;
//                    isWrong = true;
//                    break;
//            }
//        }
//        pause();
//        for (int i=0; i<100; i++) {
//            System.out.println();
//        }
//        return isWrong;
//    }
//
//    public static void pause() {
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {}
//    }
        return true;
    }

}
