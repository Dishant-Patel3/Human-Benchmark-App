import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Chimp extends JPanel {
    ImageIcon img = new ImageIcon("Images/HOME.png");
    JLabel label = new JLabel("Chimp Test");
    JLabel label5 = new JLabel("Are you Smarter Than a Chimpanzee?");
    JLabel label3 = new JLabel("Click the sqaures in order according to their numbers");
    JLabel label4 = new JLabel("The test will get progressively harder");
    JLabel lab1 = new JLabel("Score");
    JLabel lab = new JLabel("GAME OVER");
    JButton button = new JButton("");
    JButton button6 = new JButton("Start");
    
    public JButton button5 = new JButton("Play Again");
    public JLabel label1 = new JLabel("");
    public JLabel label2 = new JLabel("");
    private Home app;
    private Chimp1 game;
    private Chimp this1;

    public Chimp(Home home) {
        app = home;
        this1 = this;
        setLayout(null);
        setSize(700, 700);
        setBounds(0, 0, 700, 700);
        setBackground(new Color(13, 134, 255));
        label.setSize(700, 100);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setFont(new Font("Koulen", Font.BOLD, 45));
        label.setForeground(Color.WHITE);
        add(label);
        label5.setBounds(20, 150, 700, 50);
        label5.setFont(new Font("Koulen", Font.ITALIC, 38));
        label5.setForeground(Color.BLACK);
        add(label5);
        label3.setBounds(50, 230, 700, 50);
        label3.setFont(new Font("Koulen", Font.PLAIN, 25));
        label3.setForeground(Color.WHITE);
        add(label3);
        label4.setBounds(140, 280, 700, 50);
        label4.setFont(new Font("Koulen", Font.PLAIN, 25));
        label4.setForeground(Color.WHITE);
        add(label4);
        label1.setBounds(150, 80, 700, 50);
        label1.setFont(new Font("Koulen", Font.BOLD, 21));
        label1.setForeground(Color.WHITE);
        label2.setBounds(400, 80, 700, 50);
        label2.setFont(new Font("Koulen", Font.BOLD, 21));
        label2.setForeground(Color.WHITE);
        add(label1);
        add(label2);
        lab1.setBounds(295, 120, 700, 80);
        lab1.setFont(new Font("Koulen", Font.BOLD, 40));
        lab1.setForeground(Color.WHITE);
        add(lab1);
        lab.setBounds(325, 190, 700, 80);
        lab.setFont(new Font("Koulen", Font.BOLD, 55));
        lab.setForeground(Color.BLACK);
        add(lab);
        lab.setVisible(false);
        lab1.setVisible(false);
        button.setBounds(605, 10, 70, 70);
        button.setIcon(img);
        button.setBackground(new Color(13,134,255));
        button.setBorder(BorderFactory.createLineBorder(new Color(13,134,255),1));
        add(button);
        button6.setBounds(250, 450, 200, 100);
        button6.setBackground(new Color(13,134,255));
        button6.setForeground(Color.WHITE);
        button6.setFont(new Font("Koulen", Font.PLAIN, 25));
        button6.setBorder(BorderFactory.createLineBorder(Color.WHITE,10));
        add(button6);
        button5.setBounds(250, 300, 200, 200);
        button5.setBackground(new Color(13,134,255));
        button5.setForeground(Color.WHITE);
        button5.setFont(new Font("Koulen", Font.PLAIN, 25));
        button5.setBorder(BorderFactory.createLineBorder(Color.WHITE,10));
        add(button5);
        button5.setVisible(false);
        button6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                game = new Chimp1(this1);
                add(game);
                button6.setVisible(false);
                label2.setVisible(true);
                label1.setVisible(true);
                label2.setText("Strikes: 3");
                label1.setText("Next Round: 5");
                button5.setVisible(false);
                lab.setVisible(false);
                lab1.setVisible(false);
                label5.setVisible(false);
                label3.setVisible(false);
                label4.setVisible(false);
        }
        });
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                app.pageClick1();
                button6.setVisible(true);
                remove(game);
                label5.setVisible(true);
                label3.setVisible(true);
                label4.setVisible(true);
                label2.setVisible(false);
                label1.setVisible(false);
                button5.setVisible(false);
                lab.setVisible(false);
                lab1.setVisible(false);
            }
        });
        button5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                game = new Chimp1(this1);
                add(game);
                label2.setText("Strikes: 3");
                label1.setText("Next Round: 5");
                button5.setVisible(false);
                button6.setVisible(false);
                lab.setVisible(false);
                lab1.setVisible(false);
                label5.setVisible(false);
                label3.setVisible(false);
                label4.setVisible(false);
            }
        });
    }
}