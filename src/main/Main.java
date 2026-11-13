package main;

import view.MainFrame;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        // Menjalankan GUI Swing di thread yang aman
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainFrame frame = new MainFrame();
                frame.setLocationRelativeTo(null); // Membuka window di tengah layar
                frame.setVisible(true);
            }
        });
    }
}