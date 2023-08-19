import javax.swing.*;

public class frame2 {
    public JFrame frame;
 

    frame2(){
        frame = new JFrame("My Testing Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);

        frame.setVisible(true);
    }

}

