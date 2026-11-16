package model;

public class Potion extends Item {
    private int healAmount;

    public Potion(int jumlah) {
        super("P01", "HP Potion", 16, jumlah, "src/assets/potion.png");
        this.healAmount = 50;
    }

    public int getHealAmount() { return healAmount; }

    @Override
    public void gunakan() {
        System.out.println("Meminum " + getNama() + ", memulihkan " + healAmount + " HP.");
    }
}