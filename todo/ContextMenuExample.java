package todo;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ContextMenuExample {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            createAndShowGUI();
        });
    }

    public static void createAndShowGUI() {
        JFrame frame = new JFrame("Editable JList Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        DefaultListModel<String> listModel = new DefaultListModel<>();
        JList<String> jList = new JList<>(listModel);
        jList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Add some items to the list
        listModel.addElement("Item 1");
        listModel.addElement("Item 2");
        listModel.addElement("Item 3");

        jList.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    int index = jList.locationToIndex(e.getPoint());
                    if (index != -1 && jList.getCellBounds(index, index).contains(e.getPoint())) {
                        jList.setSelectedIndex(index);
                        showContextMenu(jList, e.getX(), e.getY());
                    }
                }
            }
        });

        frame.add(new JScrollPane(jList), BorderLayout.CENTER);
        frame.setSize(300, 200);
        frame.setVisible(true);
    }

    public static void showContextMenu(JList<String> jList, int x, int y) {
        JPopupMenu contextMenu = new JPopupMenu();

        JMenuItem editItem = new JMenuItem("Edit");
        JMenuItem deleteItem = new JMenuItem("Delete");

        contextMenu.add(editItem);
        contextMenu.add(deleteItem);

        editItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = jList.getSelectedIndex();
                if (selectedIndex != -1) {
                    String selectedItem = jList.getModel().getElementAt(selectedIndex);
                    editListItem(jList, selectedIndex, selectedItem);
                }
            }
        });

        deleteItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = jList.getSelectedIndex();
                if (selectedIndex != -1) {
                    DefaultListModel<String> model = (DefaultListModel<String>) jList.getModel();
                    model.remove(selectedIndex);
                }
            }
        });

        contextMenu.show(jList, x, y);
    }

    public static void editListItem(JList<String> jList, int index, String text) {
        DefaultListModel<String> model = (DefaultListModel<String>) jList.getModel();
        JTextField textField = new JTextField(text);

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
