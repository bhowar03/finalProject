import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;



class CreateDeck2 implements ActionListener{
    private JButton button2;
    private JTextField textField2;

    public CreateDeck2(JButton button2, JTextField textField2){
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







