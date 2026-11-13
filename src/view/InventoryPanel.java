package view;

import controller.InventoryManager;
import model.Inventory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InventoryPanel extends JPanel {
    // Referensi agar panel bisa berkomunikasi dengan model dan controller
    private Inventory inventory;
    private InventoryManager manager;
    private JLabel cursorLabel;
    private JTextArea logArea;

    public InventoryPanel(String title, Inventory inventory, InventoryManager manager, JLabel cursorLabel, JTextArea logArea) {
        this.inventory = inventory;
        this.manager = manager;
        this.cursorLabel = cursorLabel;
        this.logArea = logArea;

        // Konfigurasi layout panel ini
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createTitledBorder(title));

        // Membuat grid bagian dalam
        JPanel grid = new JPanel(new GridLayout(inventory.getBaris(), inventory.getKolom(), 5, 5));

        // Melakukan perulangan untuk mengisi grid dengan SlotButton
        for (int r = 0; r < inventory.getBaris(); r++) {
            for (int c = 0; c < inventory.getKolom(); c++) {
                SlotButton btn = new SlotButton(inventory.getSlot(r, c));

                // Listener ketika petak inventori diklik
                btn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Controller memproses klik
                        String hasil = manager.clickSlot(btn.getSlotModel());

                        // Render ulang visual tombol
                        btn.updateVisual();

                        // Render ulang teks kursor di layar utama
                        if (manager.getHeldStack() == null) {
                            cursorLabel.setText("Di Kursor: Kosong");
                        } else {
                            cursorLabel.setText("Di Kursor: " + manager.getHeldStack().getJumlah() + "x [" + manager.getHeldStack().getItem().getNama() + "]");
                        }

                        // Kirim output ke log area
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