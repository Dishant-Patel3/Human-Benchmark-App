import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Aim1 extends JPanel {
    private int index, start;
    private List<Integer> clickTimes;
    private JButton target;
    private Random random;
    private Aim game;

    public Aim1(Aim v) {
        game = v;
        target = new JButton("");
        clickTimes = new ArrayList<>();
        index = 0;
        start = 29;
        random = new Random();

        initialize();
        setTarget();

        target.addActionListener(new ButtonListener()); 
    }

    public void initialize() {
        setLayout(null);
        setSize(600, 500);
        setBounds(50, 130, 500, 500);
        setBackground(new Color(13, 134, 255));
        target.setBounds(180, 180, 70, 70);
        target.setBackground(Color.BLACK);
        target.setOpaque(true);
        add(target);
    }

    public void setTarget() {
        int x = random.nextInt(320) + 40;
        int y = random.nextInt(320) + 40;
        target.setBounds(x, y, 70, 70);
    }

    public class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int clickTime = (int) System.currentTimeMillis();
            clickTimes.add(clickTime);
            if (index == 29) {
                double averageTime = calAverage();
                game.lab.setText((int) averageTime + "ms");
                setVisible(false);
                game.button5.setVisible(true);
                game.label1.setVisible(false);
                game.lab.setVisible(true);
                game.lab1.setVisible(true);
            } else {
                index++;
                game.label1.setText("Remaining " + start--);                    
                setTarget();
            }
        }
    }

    public double calAverage() {
        int totalTime = 0;
        for (int i = 1; i < clickTimes.size(); i++) {
            int clickTime = clickTimes.get(i);
            int previousClickTime = clickTimes.get(i - 1);
            totalTime += clickTime - previousClickTime;
        }
        return (double) totalTime / clickTimes.size();
    }
}

