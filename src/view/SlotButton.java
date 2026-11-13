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
        // Atur agar teks angka berada di bawah ikon gambar
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
            setIcon(null); // Hapus ikon jika kosong
            setBackground(new Color(220, 220, 220)); // Warna default slot kosong
        } else {
            Item item = slotModel.getStack().getItem();
            int jumlah = slotModel.getStack().getJumlah();

            // Set teks hanya untuk menampilkan jumlah (seperti di Minecraft)
            // Jika weapon (max stack 1), tidak perlu tampilkan angka 1
            if (jumlah > 1) {
                setText(String.valueOf(jumlah));
            } else {
                setText("");
            }

            // Load dan render gambar PNG
            try {
                // Pastikan path merujuk ke folder src/assets/ milikmu
                ImageIcon originalIcon = new ImageIcon(item.getImagePath());
                // Resize gambar agar pas dengan tombol (misal 40x40 pixel)
                Image scaledImage = originalIcon.getImage().getScaledInstance(48, 48, Image.SCALE_SMOOTH);
                setIcon(new ImageIcon(scaledImage));
            } catch (Exception e) {
                System.out.println("Gagal memuat gambar: " + item.getImagePath());
            }

            setBackground(Color.WHITE); // Background putih agar PNG transparan terlihat jelas
        }
    }
}