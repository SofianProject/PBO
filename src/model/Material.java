package model;

public class Material extends Item {
    private String tipe;

    public Material(String id, String nama, String tipe, int jumlah, String imagePath) {
        super(id, nama, 64, jumlah, imagePath);
        this.tipe = tipe;
    }

    // Pembuat objek instan (Factory Method) untuk Kayu dan Batu
    public static Material buatKayu(int jumlah) {
        return new Material("M01", "Kayu Oak", "Wood", jumlah, "src/assets/kayu.png");
    }

    public static Material buatBatu(int jumlah) {
        return new Material("M02", "Batu", "Stone", jumlah, "src/assets/batu.png");
    }

    @Override
    public void gunakan() {
        System.out.println("Menggunakan material " + getNama() + " untuk crafting.");
    }
}