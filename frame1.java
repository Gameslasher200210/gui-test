import javax.swing.*;

public class frame1 extends frame2 {

    public JPanel panel;
    public JButton button;

    frame1(){
       

        panel = new JPanel();
        button = new JButton("Click Me!");

        panel.add(button);
        frame.add(panel);

      
    }
        public static void addJListClickListener(JList<String> jList) {
        jList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedIndex = jList.getSelectedIndex();
                    if (selectedIndex != -1) {
                        String selectedItem = jList.getModel().getElementAt(selectedIndex);
                        guiComponts components = new guiComponts();
                        components.taskInput.setText(selectedItem);
                        
                        System.out.println("Selected item: " + selectedItem);
                    }
                }
            }
        });
    }