package model;

public class Weapon extends Item {
    private int damage;

    public Weapon(String id, String nama, int damage, String imagePath) {
        super(id, nama, 1, imagePath);
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    @Override
    public void gunakan() {
        System.out.println("Mengayunkan " + getNama() + " dengan damage " + damage);
    }
}