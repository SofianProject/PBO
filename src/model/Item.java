package model;

public abstract class Item {
    private String id;
    private String nama;
    protected int maxStack;
    private String imagePath;

    public Item(String id, String nama, int maxStack, String imagePath) {
        this.id = id;
        this.nama = nama;
        this.maxStack = maxStack;
        this.imagePath = imagePath;
    }

    public String getId() { return id; }
    public String getNama() { return nama; }
    public int getMaxStack() { return maxStack; }
    public String getImagePath() { return imagePath; }

    public abstract void gunakan();
}