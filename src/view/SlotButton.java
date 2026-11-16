package view;

import model.Slot;
import model.Item;
import javax.swing.*;
import java.awt.*;

public class SlotButton extends JButton {
    private Slot slotModel;

    public SlotButton(Slot slot) {
        this.slotModel = slot;
        setFont(new Font("Arial", Font.BOLD, 12));
        setFocusPainted(false);
        setVerticalTextPosition(SwingConstants.BOTTOM);
        setHorizontalTextPosition(SwingConstants.CENTER);
        updateVisual();
    }

    public Slot getSlotModel() {
        return slotModel;
    }

    public void updateVisual() {
        if (slotModel.isKosong()) {
            setText("");
            setIcon(null);
            setBackground(new Color(220, 220, 220));
        } else {
            Item item = slotModel.getItem();
            int jumlah = item.getJumlah();

            if (jumlah > 1) {
                setText(String.valueOf(jumlah));
            } else {
                setText("");
            }

            try {
                ImageIcon originalIcon = new ImageIcon(item.getImagePath());
                Image scaledImage = originalIcon.getImage().getScaledInstance(48, 48, Image.SCALE_SMOOTH);
                setIcon(new ImageIcon(scaledImage));
            } catch (Exception e) {
                System.out.println("Gagal memuat gambar: " + item.getImagePath());
            }

            setBackground(Color.WHITE);
        }
    }
}