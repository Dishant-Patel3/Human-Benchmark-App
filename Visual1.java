import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Visual1 extends JPanel {
    public int level, lives, status, total, wrong, start;
    private ArrayList<JButton> buttons;
    private Set<Integer> memory;
    private Timer timer;
    private Visual game;

    public Visual1(Visual v) {
        game = v;
        level = 1;
        lives = 3;
        wrong = 0;
        start = 1;
        status = 0;
        
        setLayout(null);
        setSize(500, 500);
        setBounds(100, 130, 500, 500);
        setBackground(new Color(13, 134, 255));

        initialize(3);
        display(level);
    }

    public void initialize(int x) {
        total = x * x;
        buttons = new ArrayList<>();
        memory = new HashSet<>();
        setLayout(new GridLayout(x, x, 7, 7));
        setBounds(100, 130, 500, 500);
        for (int i = 0; i < total; i++) {
            JButton button = new JButton();
            button.setName(Integer.toString(i));
            button.setPreferredSize(new Dimension(50, 50));
            button.setBackground(Color.WHITE);
            button.setOpaque(true);
            button.setBorderPainted(false);
            button.addActionListener(new ButtonListener());
            buttons.add(button);
            add(button);
        }
    }

    public void display(int l) {
        level = l;
        int count = level + 1 + start;
        memory.clear();
        while (memory.size() < count) {
            int random = (int) (Math.random() * total);
            memory.add(random);
            buttons.get(random).setBackground(Color.BLACK);
        }
        timer = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Integer index : memory) {
                    buttons.get(index).setBackground(Color.WHITE);
                }
                timer.stop();
            }
        });
        timer.start();
    }

    public void updateInitialize(int level) {
        removeAll();
        if (level <= 2) {
            initialize(3);
        } else if (level <= 5) {
            initialize(4);
        } else if (level <= 7) {
            initialize(5);
        } else if (level <= 9) {
            initialize(6);
        } else if (level <= 11) {
            initialize(7);
        } else if (level <= 14) {
            initialize(8);
        } else {
            initialize(9);
        }
        revalidate();
        repaint();
    }

    public class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton clickedButton = (JButton) e.getSource();
            int buttonIndex = Integer.parseInt(clickedButton.getName());
            if (memory.contains(buttonIndex)) {
                clickedButton.setBackground(Color.BLACK);
                memory.remove(buttonIndex);
                if (memory.isEmpty()) {
                    level++;
                    game.label1.setText("Level: " + level);
                    if (level <= 15) {
                        updateInitialize(level);
                        display(level);
                    } else {
                        setVisible(false);
                    }
                }
            } else {
                wrong++;
                if (wrong == 3) {
                    lives--;
                    game.label2.setText("Lives: " + lives);
                    if (lives == 0) {
                        setVisible(false);
                        game.button5.setVisible(true);
                        game.lab.setVisible(true);
                    } else {
                        wrong = 0;
                        display(level);
                    }
                }
            }
        }
    }
}
