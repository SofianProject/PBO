package model;

public class ItemStack {
    private Item item;
    private int jumlah;

    public ItemStack(Item item, int jumlah) {
        this.item = item;
        // Validasi agar jumlah tidak melebihi kapasitas maksimal saat objek dibuat
        this.jumlah = Math.min(jumlah, item.getMaxStack());
    }

    public Item getItem() {
        return item;
    }

    public int getJumlah() {
        return jumlah;
    }

    // Mengembalikan sisa barang yang tidak muat jika melebihi maxStack
    public int tambahJumlah(int tambahan) {
        int total = this.jumlah + tambahan;
        if (total > item.getMaxStack()) {
            this.jumlah = item.getMaxStack();
            return total - item.getMaxStack(); // Sisa yang tumpah
        } else {
            this.jumlah = total;
            return 0; // Berhasil masuk semua
        }
    }

    public void kurangiJumlah(int pengurangan) {
        this.jumlah = Math.max(0, this.jumlah - pengurangan);
    }

    public boolean isPenuh() {
        return this.jumlah >= item.getMaxStack();
    }
}