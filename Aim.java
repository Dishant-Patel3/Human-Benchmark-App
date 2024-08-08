import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Aim extends JPanel {
    ImageIcon img = new ImageIcon("Images/HOME.png");
    JLabel label = new JLabel("Aim Trainer");
    JLabel lab = new JLabel("707ms");
    JLabel lab1 = new JLabel("Average time per target");
    JButton button = new JButton("");
    JButton button6 = new JButton("Start");

    public JLabel label1 = new JLabel("");
    public JButton button5 = new JButton("Play Again");
    private Home app;
    private Aim1 game;
    private Aim this1;

    public Aim(Home home) {
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
        button.setBounds(605, 10, 70, 70);
        button.setIcon(img);
        button.setBackground(new Color(13,134,255));
        button.setBorder(BorderFactory.createLineBorder(new Color(13,134,255),1));
        add(button);
        label1.setBounds(280, 80, 700, 50);
        label1.setFont(new Font("Koulen", Font.BOLD, 21));
        label1.setForeground(Color.WHITE);
        add(label1);
        lab1.setBounds(130, 120, 700, 80);
        lab1.setFont(new Font("Koulen", Font.BOLD, 40));
        lab1.setForeground(Color.WHITE);
        add(lab1);
        lab1.setVisible(false);
        lab.setBounds(255, 195, 700, 100);
        lab.setFont(new Font("Koulen", Font.BOLD, 60));
        lab.setForeground(Color.BLACK);
        add(lab);
        lab.setVisible(false);
        button.setBounds(605, 10, 70, 70);
        button.setIcon(img);
        button.setBackground(new Color(13,134,255));
        button.setBorder(BorderFactory.createLineBorder(new Color(13,134,255),1));
        add(button);
        button6.setBounds(250, 300, 200, 200);
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
                game = new Aim1(this1);
                add(game);
                button6.setVisible(false);
                label1.setVisible(true);
                label1.setText("Remaining 30");
                button5.setVisible(false);
                lab.setVisible(false);
                lab1.setVisible(false);
            }
        });
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                app.pageClick1();
                button6.setVisible(true);
                remove(game);
                label1.setVisible(false);
                button5.setVisible(false);
                lab.setVisible(false);
                lab1.setVisible(false);
            }
        });
        button5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                game = new Aim1(this1);
                add(game);
                label1.setVisible(true);
                label1.setText("Remaining 30");
                button5.setVisible(false);
                button6.setVisible(false);
                lab.setVisible(false);
                lab1.setVisible(false);
            }
        });
    } 
}
