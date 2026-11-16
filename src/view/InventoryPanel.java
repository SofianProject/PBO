package view;

import controller.InventoryManager;
import model.Inventory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InventoryPanel extends JPanel {
    private Inventory inventory;
    private InventoryManager manager;
    private JLabel cursorLabel;
    private JTextArea logArea;

    public InventoryPanel(String title, Inventory inventory, InventoryManager manager, JLabel cursorLabel, JTextArea logArea) {
        this.inventory = inventory;
        this.manager = manager;
        this.cursorLabel = cursorLabel;
        this.logArea = logArea;

        setLayout(new BorderLayout());
        setBorder(BorderFactory.createTitledBorder(title));

        JPanel grid = new JPanel(new GridLayout(inventory.getBaris(), inventory.getKolom(), 5, 5));

        for (int r = 0; r < inventory.getBaris(); r++) {
            for (int c = 0; c < inventory.getKolom(); c++) {
                SlotButton btn = new SlotButton(inventory.getSlot(r, c));

                btn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String hasil = manager.clickSlot(btn.getSlotModel());

                        btn.updateVisual();

                        if (manager.getHeldItem() == null) {
                            cursorLabel.setText("Di Kursor: Kosong");
                        } else {
                            cursorLabel.setText("Di Kursor: " + manager.getHeldItem().getJumlah() + "x [" + manager.getHeldItem().getJumlah() + "]");
                        }

                        logArea.append(hasil + "\n");
                        logArea.setCaretPosition(logArea.getDocument().getLength());
                    }
                });
                grid.add(btn);
            }
        }
        add(grid, BorderLayout.CENTER);
    }
}