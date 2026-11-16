package model;

public abstract class Item {
    private String id;
    private String nama;
    protected int maxStack;
    private int jumlah;
    private String imagePath;

    public Item(String id, String nama, int maxStack, int jumlah, String imagePath) {
        this.id = id;
        this.nama = nama;
        this.maxStack = maxStack;
        this.jumlah = Math.min(jumlah, maxStack);
        this.imagePath = imagePath;
    }

    public String getId() { return id; }
    public String getNama() { return nama; }
    public int getMaxStack() { return maxStack; }
    public int getJumlah() { return jumlah; }
    public String getImagePath() { return imagePath; }

    public int tambahJumlah(int tambahan) {
        int total = this.jumlah + tambahan;
        if (total > maxStack) {
            this.jumlah = maxStack;
            return total - maxStack; // Mengembalikan sisa barang yang tidak muat
        } else {
            this.jumlah = total;
            return 0;
        }
    }

    public void kurangiJumlah(int pengurangan) {
        this.jumlah = Math.max(0, this.jumlah - pengurangan);
    }

    public boolean isPenuh() {
        return this.jumlah >= maxStack;
    }

    public abstract void gunakan();
}