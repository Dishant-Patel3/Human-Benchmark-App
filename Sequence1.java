import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Sequence1 extends JPanel {
    public int level, level1, lives, index, status;
    private List<Integer> sequence;
    private JPanel buttonPanel;
    private Timer timer;
    private Sequence game1;

    public Sequence1(Sequence v) {
        game1 = v;
        sequence = new ArrayList<>();
        index = 0;
        level1 = 1;
        lives = 1;
        level = 10;
        buttonPanel = new JPanel(new GridLayout(3, 3, 7, 7));
        timer = new Timer(1000, new ButtonTimerListener());

        setLayout(null);
        setSize(500, 500);
        setBounds(100, 130, 500, 500);
        setLayout(new BorderLayout());
        add(buttonPanel, BorderLayout.CENTER);

        initialize();
    }


    public void initialize() {
        for (int i = 1; i <= 9; i++) {
            JButton button = new JButton();
            button.setBackground(Color.WHITE);
            button.setOpaque(true);
            button.setPreferredSize(new java.awt.Dimension(60, 60));
            button.addActionListener(new ButtonListener());
            buttonPanel.add(button);
        }
        buttonPanel.setBackground(new Color(13, 134, 255));
        sequence.clear();
        index = 0;
        level1 = 1;
        lives = 1;
        generateSequence();
        buttonPanel.setEnabled(false);
        timer.setInitialDelay(1000);
        timer.start();
    }

    public void generateSequence() {
        Random random = new Random();
        int num = 0;
        for (int i = 0; i < level; i++) {
            num = random.nextInt(9);
            if (i > 1) {
                while ((num == (sequence.get(i - 1)))) {
                    num = random.nextInt(9);
                }
            }
            sequence.add(num);
        }
    }

    public class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            checkButton(button);
        }
    }

    public class ButtonTimerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < 9; i++) {
                JButton button = (JButton) buttonPanel.getComponent(i);
                button.setBackground(Color.WHITE);
            }
            if (index < level1) {
                int buttonIndex = sequence.get(index);
                JButton button = (JButton) buttonPanel.getComponent(buttonIndex);
                button.setBackground(Color.BLACK);
                index++;
            } else {
                index = 0;
                timer.stop();
                buttonPanel.setEnabled(true);
            }
        }
    }

    public void checkButton(JButton button) {
        int buttonIndex = buttonPanel.getComponentZOrder(button);
        if (buttonIndex == sequence.get(index)) {
            index++;
            button.setBackground(Color.BLACK);
            Timer colorTimer = new Timer(500, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    button.setBackground(Color.WHITE);
                    if (index == level1) {
                        index = 0;
                        level1++;
                        game1.label1.setText("Level: " + level1);
                        buttonPanel.setEnabled(false);
                        timer.setInitialDelay(1000);
                        timer.start();
                    }
                }
            });
            colorTimer.setRepeats(false);
            colorTimer.start();
        } else {
            lives--;
            if (lives == 0) {
                timer.stop();
                setVisible(false);
                buttonPanel.setVisible(false);
                game1.button5.setVisible(true);
                game1.label1.setVisible(false);
                game1.lab.setVisible(true);
            }
        }
    }
}
