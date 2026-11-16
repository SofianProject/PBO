package model;

public class ItemStack {
    private Item item;
    private int jumlah;

    public ItemStack(Item item, int jumlah) {
        this.item = item;
        this.jumlah = Math.min(jumlah, item.getMaxStack());
    }

    public Item getItem() {
        return item;
    }

    public int getJumlah() {
        return jumlah;
    }

    public int tambahJumlah(int tambahan) {
        int total = this.jumlah + tambahan;
        if (total > item.getMaxStack()) {
            this.jumlah = item.getMaxStack();
            return total - item.getMaxStack();
        } else {
            this.jumlah = total;
            return 0;
        }
    }

    public void kurangiJumlah(int pengurangan) {
        this.jumlah = Math.max(0, this.jumlah - pengurangan);
    }

    public boolean isPenuh() {
        return this.jumlah >= item.getMaxStack();
    }
}