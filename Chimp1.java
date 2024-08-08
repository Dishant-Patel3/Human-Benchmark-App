import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Chimp1 extends JPanel {
    private int level, lives, current;
    private Chimp game;
    private boolean clicked;

    public Chimp1(Chimp v) {
        game = v;
        level = 1;
        lives = 3;
        current = 1;
        clicked = true;
        
        setBackground(new Color(13, 134, 255));
        setLayout(new GridLayout(8, 5, 7, 7));
        setSize(600,500);
        setBounds(50, 130, 600, 500);
        
        initialize(level + 3);
    }

    public void initialize(int num) {
        List<Integer> buttons = new ArrayList<>();
        for (int i = 1; i <= num; i++) {
            buttons.add(i);
        }
        Collections.shuffle(buttons);
        List<JButton> buttons1 = new ArrayList<>();
        for (int i = 0; i < 8 * 5; i++) {
            if (i < buttons.size()) {
                JButton button = new JButton(String.valueOf(buttons.get(i)));
                button.addActionListener(new ButtonListener(buttons.get(i)));
                button.setForeground(Color.WHITE);
                button.setBackground(Color.BLACK);
                button.setFont(new Font("Verdana", Font.BOLD, 40));
                buttons1.add(button);
            } else {
                JButton button1 = new JButton();
                button1.setEnabled(false);
                button1.setVisible(false);
                buttons1.add(button1);
            }
        }
        Collections.shuffle(buttons1);
        for (JButton button3 : buttons1) {
            add(button3);
        }
    }

    public void hideButtonNumbers() {
        for (Component c : getComponents()) {
            if (c instanceof JButton) {
                JButton button = (JButton) c;
                if (!button.getText().equals("1")) {
                    button.setText("");
                }
            }
        }
    }

    public class ButtonListener implements ActionListener {
        private int num;

        public ButtonListener(int buttonNumber) {
            this.num = buttonNumber;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton button4 = (JButton) e.getSource();
            button4.setOpaque(true);
            button4.setContentAreaFilled(true);
            button4.setBorderPainted(false);
            button4.setFocusPainted(false);
            button4.setBackground(Color.BLACK);
            if (num == current) {
                current++;
                if(clicked || level == 1) {
                    button4.setEnabled(false);
                    button4.setVisible(false);
                    clicked = false;
                    repaint();
                }
                if (clicked || level > 1) {
                    button4.setEnabled(false);
                    button4.setVisible(false);
                    hideButtonNumbers();
                    clicked = false;
                    repaint();
                }
                if (current == level + 4) {
                    int i = level+5;
                    game.label1.setText("Next Round: " + i);
                    if (level < 100) {
                        level++;
                        current = 1;
                        clicked = true;
                        removeAll();
                        initialize(level + 3);
                        revalidate();
                        repaint();
                    }
                }
            } else {
                lives--;
                game.label2.setText("Strikes: " + lives);
                if (lives > 0) {
                    current = 1;
                    clicked = true;
                    removeAll();
                    initialize(level + 3);
                    revalidate();
                    repaint();
                } else {
                    int i = level+3;
                    game.lab.setText("" + i);
                    setVisible(false);
                    game.button5.setVisible(true);
                    game.label1.setVisible(false);
                    game.label2.setVisible(false);
                    game.lab.setVisible(true);
                    game.lab1.setVisible(true);
                }
            }
        }
    }
}
