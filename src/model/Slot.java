package model;

public class Slot {
    private Item item;

    public Slot() {
        this.item = null;
    }

    public Item getItem() { return item; }
    public void setItem(Item item) { this.item = item; }

    public boolean isKosong() {
        return item == null || item.getJumlah() <= 0;
    }

    public void kosongkan() {
        this.item = null;
    }
}