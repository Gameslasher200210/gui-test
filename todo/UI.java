package todo;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class UI {
    public JFrame frame;
    public UI(){
        frame = new JFrame("File To JList GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setVisible(true);
        printToGui printGui = new printToGui();
        guiComponts components = new guiComponts();
        contextmenu menu = new contextmenu();
        
      
        frame.add(components.inputPanel, BorderLayout.NORTH);
        frame.add(printGui.scrollPane, BorderLayout.CENTER);
      


    }
      public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
         new UI();
        });
}
}