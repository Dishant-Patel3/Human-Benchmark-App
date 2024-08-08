import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Visual extends JPanel {
    ImageIcon img = new ImageIcon("Images/HOME.png");
    JLabel label = new JLabel("Visual Memory");
    JLabel lab = new JLabel("GAME OVER");
    JButton button = new JButton("");
    JButton button6 = new JButton("Start");
    
    public JLabel label1 = new JLabel("");
    public JLabel label2 = new JLabel("");
    public JButton button5 = new JButton("Play Again");
    private Home app;
    private Visual1 game;
    private Visual this1;

    public Visual(Home home) {
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
        label1.setBounds(150, 80, 700, 50);
        label1.setFont(new Font("Koulen", Font.BOLD, 21));
        label1.setForeground(Color.WHITE);
        label2.setBounds(400, 80, 700, 50);
        label2.setFont(new Font("Koulen", Font.BOLD, 21));
        label2.setForeground(Color.WHITE);
        add(label1);
        add(label2);
        lab.setBounds(180, 150, 700, 80);
        lab.setFont(new Font("Koulen", Font.BOLD, 55));
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
                game = new Visual1(this1);
                add(game);
                button6.setVisible(false);
                label2.setVisible(true);
                label1.setVisible(true);
                label2.setText("Lives: 3");
                label1.setText("Level: 1");
                button5.setVisible(false);
                lab.setVisible(false);
            }
        });
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                app.pageClick1();
                button6.setVisible(true);
                remove(game);
                label2.setVisible(false);
                label1.setVisible(false);
                button5.setVisible(false);
                lab.setVisible(false);
            }
        });
        button5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                game = new Visual1(this1);
                add(game);
                label2.setText("Lives: 3");
                label1.setText("Level: 1");
                button5.setVisible(false);
                button6.setVisible(false);
                lab.setVisible(false);
            }
        });
    }
}