package todo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.function.Consumer;

public class contextmenu {

    public contextmenu(){
        printToGui list = new printToGui();
        addMouseListener(list.uncompletedList, (index, e) -> {
        
        });
          addMouseListener(list.completedList, (index, e) -> {
        
        });}
    
        
    private static void createAndShowGUI() {
   

        DefaultListModel<String> listModel = new DefaultListModel<>();
        JList<String> jList = new JList<>(listModel);
        jList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Add some items to the list
        listModel.addElement("Item 1");
        listModel.addElement("Item 2");
        listModel.addElement("Item 3");

        addMouseListener(jList, (index, e) -> showContextMenu(jList, index, e.getX(), e.getY()));

    }

    public static void addMouseListener(JList<String> jList, ContextMenuHandler handler) {
        jList.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    int index = jList.locationToIndex(e.getPoint());
                    if (index != -1 && jList.getCellBounds(index, index).contains(e.getPoint())) {
                        jList.setSelectedIndex(index);
                        handler.showContextMenu(index, e);
                    }
                }
            }
        });
    }

    private interface ContextMenuHandler {
        void showContextMenu(int index, MouseEvent e);
    }

    private static void showContextMenu(JList<String> jList, int index, int x, int y) {
        JPopupMenu contextMenu = new JPopupMenu();

        JMenuItem editItem = new JMenuItem("Edit");
        JMenuItem deleteItem = new JMenuItem("Delete");

        contextMenu.add(editItem);
        contextMenu.add(deleteItem);

        editItem.addActionListener(e -> editListItem(jList, index));

        deleteItem.addActionListener(e -> deleteListItem(jList, index));

        contextMenu.show(jList, x, y);
    }

    private static void editListItem(JList<String> jList, int index) {
        DefaultListModel<String> model = (DefaultListModel<String>) jList.getModel();
        String selectedItem = model.getElementAt(index);

        JTextField textField = new JTextField(selectedItem);

        int response = JOptionPane.showConfirmDialog(
                jList,
                textField,
                "Edit Item",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE
        );

        if (response == JOptionPane.OK_OPTION) {
            String editedText = textField.getText();
            model.setElementAt(editedText, index);
        }
    }

    private static void deleteListItem(JList<String> jList, int index) {
        DefaultListModel<String> model = (DefaultListModel<String>) jList.getModel();
        model.remove(index);
    }
    private static void editListItem(JList<String> jList, int index) {
        DefaultListModel<String> model = (DefaultListModel<String>) jList.getModel();
        String selectedItem = model.getElementAt(index);
    
        JTextField textField = new JTextField(selectedItem);
    
        int response = JOptionPane.showConfirmDialog(
                jList,
                textField,
                "Edit Item",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE
        );
    
        if (response == JOptionPane.OK_OPTION) {
            String editedText = textField.getText();
            model.setElementAt(editedText, index);
        }
    }
    
}
