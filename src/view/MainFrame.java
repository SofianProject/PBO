package view;

import controller.InventoryManager;
import model.Inventory;
import model.Weapon;
import model.Potion;
import model.Material;
import model.ItemStack;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private InventoryManager manager;
    private Inventory playerInv;
    private Inventory chestInv;

    private JLabel cursorLabel;
    private JTextArea logArea;

    public MainFrame() {
        manager = new InventoryManager();
        playerInv = new Inventory(4, 4);
        chestInv = new Inventory(4, 4);

        inisialisasiDataAwal();

        setTitle("OOP Inventory System (Warehouse Keeper)");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        cursorLabel = new JLabel("Di Kursor: Kosong", SwingConstants.CENTER);
        cursorLabel.setFont(new Font("Arial", Font.BOLD, 16));
        cursorLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        add(cursorLabel, BorderLayout.NORTH);

        logArea = new JTextArea(5, 50);
        logArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(logArea);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Log Aktivitas (Output)"));
        add(scrollPane, BorderLayout.SOUTH);

        JPanel gridContainer = new JPanel(new GridLayout(1, 2, 20, 0));
        gridContainer.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        InventoryPanel chestPanel = new InventoryPanel("Chest Inventory", chestInv, manager, cursorLabel, logArea);
        InventoryPanel playerPanel = new InventoryPanel("Player Inventory", playerInv, manager, cursorLabel, logArea);

        gridContainer.add(chestPanel);
        gridContainer.add(playerPanel);
        add(gridContainer, BorderLayout.CENTER);
    }

    private void inisialisasiDataAwal() {

        chestInv.getSlot(0, 0).setItem(new Weapon("W01", "Pedang Besi", 25, "src/assets/pedang.png"));
        chestInv.getSlot(0, 1).setItem(new Potion("P01", "HP Potion", 50, "src/assets/potion.png"));
        chestInv.getSlot(0, 2).setItem(new Potion("P01", "HP Potion", 50, "src/assets/potion.png"));
        chestInv.getSlot(1, 0).setItem(new Material("M01", "Kayu Oak", "Wood", "src/assets/kayu.png"));
        playerInv.getSlot(0, 0).setItem(new Material("M02", "Batu", "Stone", "src/assets/batu.png"));
    }
}