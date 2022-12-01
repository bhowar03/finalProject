import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Creates a deck, lets user input a name

class CreateDeck implements ActionListener {
    private JButton button1;

    public CreateDeck(JButton button1){
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
        button4.addActionListener(new CreateDeck2(button4, textField));
        panel2.add(button4);

        frame2.pack();
        frame2.setSize(500,500);
        frame2.setVisible(true);
        frame2.add(panel2);
    }
}