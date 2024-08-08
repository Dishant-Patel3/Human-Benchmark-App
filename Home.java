import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Home extends JFrame {
    ImageIcon img = new ImageIcon("Images/GOAT.png");

    private Option grid;
    private Sequence game1;
    private Aim game2;
    private Chimp game3;
    private Visual game4;
    private int num;

    public Home() {
        setTitle("Dishant Patel - Human Benchmark");
        setSize(700, 700);
        this.setLocationRelativeTo(null);
        this.setIconImage(img.getImage());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        num = 0; 
        game1 = new Sequence(this);
        add(game1);
        game1.setVisible(false);
        game2 = new Aim(this);
        add(game2);
        game2.setVisible(false);
        game3 = new Chimp(this);
        add(game3);
        game3.setVisible(false);
        game4 = new Visual(this);
        add(game4);
        game4.setVisible(false);
        grid = new Option(this);
        add(grid);    
        setVisible(true);
    }

    public void pageClick(int x) {
        grid.setVisible(false);
        num = x;
        if(num == 1) {
            gameOne();
        } else if(num == 2) {
            gameTwo();
        } else if(num == 3) {
            gameThree();
        } else if(num == 4) {
            gameFour();
        }
    }

    public void pageClick1() {
        grid.setVisible(true);
        game1.setVisible(false);
        game2.setVisible(false);
        game3.setVisible(false);
        game4.setVisible(false);
    }

    public void gameOne() {
        game1.setVisible(true);
    }
    
    public void gameTwo() {
        game2.setVisible(true);
    }

    public void gameThree() {
        game3.setVisible(true);
    }

    public void gameFour() {
        game4.setVisible(true);
    }
}