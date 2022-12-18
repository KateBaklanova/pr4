import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GUI extends JFrame {

    JButton b1 = new JButton("AC Milan");
    JButton b2 = new JButton("Real Madrid");
    JLabel l1 = new JLabel("Result 0 X 0");
    JLabel l2 = new JLabel("Last Scorer N/A");
    Label l3 = new Label("Winner: DRAW");
    JPanel[] panel = new JPanel[9];
    public int scoreMilan = 0;
    public int scoreMadrid = 0;

    public GUI()
    {

        super("Пинатели мячей");
        setLayout(new GridLayout(3,3));



        for ( int i = 0; i < panel.length; i++)
        {
            panel[i] = new JPanel();
            add(panel[i]);
            panel[i].setBackground(new Color(130, 170, 210));
        }

        panel[1].add(l1);
        panel[3].add(b1);
        panel[5].add(b2);
        panel[6].add(l2);
        panel[8].add(l3);

        setLocationRelativeTo (null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBackground(new Color(255, 39, 30));
        setSize(300, 300);
        setVisible(true);

        b1.addMouseListener(new MouseAdapter() {
                                public void mouseClicked(MouseEvent a) {
                                    scoreMilan++;
                                    l1.setText("Result " + scoreMilan + " X " + scoreMadrid);
                                    l2.setText("Milan");
                                    winnerIs();
                                }
                            });

        b2.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent a) {
                scoreMadrid++;
                l1.setText("Result " + scoreMilan + " X " + scoreMadrid);
                l2.setText("Madrid");
                winnerIs();
            }
        });



    }

    public void winnerIs()
    {
        if (scoreMadrid > scoreMilan) {
            l3.setText("Madrid");
        } else if (scoreMadrid < scoreMilan) {
            l3.setText("Milan");
        } else {
            l3.setText("DRAW");
        }
    }

    public static void main (String args[])
    {
        new GUI().setVisible(true);
    }

}
