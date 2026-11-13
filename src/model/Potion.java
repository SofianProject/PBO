package model;

public class Potion extends Item {
    private int healAmount;

    public Potion(String id, String nama, int healAmount, String imagePath) {
        super(id, nama, 16, imagePath); // Max stack potion 16
        this.healAmount = healAmount;
    }

    public int getHealAmount() {
        return healAmount;
    }

    @Override
    public void gunakan() {
        System.out.println("Meminum " + getNama() + ", memulihkan " + healAmount + " HP.");
    }
}