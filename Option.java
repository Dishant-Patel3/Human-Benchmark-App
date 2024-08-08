import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Option extends JPanel {
    JLabel label = new JLabel("Human Benchmark");
    JLabel label1 = new JLabel("Measure your abilties and be disappointed!");
    JButton button1 = new JButton("");
    JButton button2 = new JButton("");
    JButton button3 = new JButton("");
    JButton button4 = new JButton("");
    ImageIcon img = new ImageIcon("Images/GOAT.png");
    ImageIcon img1 = new ImageIcon("Images/1.png");
    ImageIcon img2 = new ImageIcon("Images/2.png");
    ImageIcon img3 = new ImageIcon("Images/3.png");
    ImageIcon img4 = new ImageIcon("Images/4.png");

    private Home app;

    public Option(Home puzzle) {
        app = puzzle;
        setLayout(null);
        setSize(700, 700);
        setBounds(0, 0, 700, 700);
        setBackground(new Color(13, 134, 255));
        label.setBounds(25, 30, 700, 100);
        label.setFont(new Font("Koulen", Font.BOLD, 70));
        label.setForeground(Color.WHITE);
        add(label);
        label1.setBounds(100, 90, 700, 100);
        label1.setFont(new Font("Koulen", Font.PLAIN, 26));
        label1.setForeground(Color.WHITE);
        add(label1);
        button1.setBounds(25, 210, 200, 200);
        button1.setIcon(img1);
        button1.setBackground(new Color(13, 134, 255));
        add(button1);
        button2.setBounds(242, 210, 200, 200);
        button2.setIcon(img2);
        button2.setBackground(new Color(13, 134, 255));
        add(button2);
        button3.setBounds(460, 210, 200, 200);
        button3.setIcon(img3);
        button3.setBackground(new Color(13, 134, 255));
        add(button3);
        button4.setBounds(150, 430, 400, 200);
        button4.setIcon(img4);
        button4.setBackground(new Color(13, 134, 255));
        add(button4);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                app.pageClick(1);

            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                app.pageClick(2);

            }
        });
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                app.pageClick(3);
            }
        });
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                app.pageClick(4);
            }
        });
    }
}

