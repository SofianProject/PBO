package model;

public class Weapon extends Item {
    private int damage;

    // Konstruktor kosong (tanpa parameter) karena datanya sudah dikunci di dalam
    public Weapon() {
        super("W01", "Pedang Besi", 1, 1, "src/assets/pedang.png");
        this.damage = 25;
    }

    public int getDamage() { return damage; }

    @Override
    public void gunakan() {
        System.out.println("Mengayunkan " + getNama() + " dengan damage " + damage);
    }
}