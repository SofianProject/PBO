package model;

public class Slot {
    private ItemStack stack;

    public Slot() {
        this.stack = null; // Slot kosong secara default
    }

    public ItemStack getStack() {
        return stack;
    }

    public void setStack(ItemStack stack) {
        this.stack = stack;
    }

    public boolean isKosong() {
        return stack == null || stack.getJumlah() <= 0;
    }

    public void kosongkan() {
        this.stack = null;
    }
}