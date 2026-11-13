package model;

public class Material extends Item {
    private String tipe;

    public Material(String id, String nama, String tipe, String imagePath) {
        super(id, nama, 64, imagePath); // Max stack material 64
        this.tipe = tipe;
    }

    public String getTipe() {
        return tipe;
    }

    @Override
    public void gunakan() {
        System.out.println("Menggunakan material " + getNama() + " untuk crafting.");
    }
}