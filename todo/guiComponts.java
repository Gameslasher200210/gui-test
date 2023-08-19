package todo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class guiComponts {
    public JFrame frame;
    public JButton addButton;
    public JButton editButton;
    public JTextField taskInput;
    public JPanel inputPanel;
   
    public guiComponts(){
        addButton = new JButton("+");
        editButton = new JButton("edit");
        taskInput = new JTextField("ADD A TASK", 50);
        inputPanel = new JPanel();
        

        inputPanel.add(addButton);
        inputPanel.add(taskInput);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputText = taskInput.getText();
                fileActions act = new fileActions();
                act.add("uncompleted.txt", inputText);
                   // Clear the text field after adding the task
                taskInput.setText("ADD A TASK");
                //ADD CODE TO HANDLE ADD EXCEPTIONS
            }
        });
        taskInput.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (evt.getSource() == taskInput) {
                    taskInput.setText("");
                }
            }
        });
        // editing code
        

    }


    
}
