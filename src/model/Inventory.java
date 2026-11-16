package model;

public class Inventory {
    private int baris;
    private int kolom;
    private Slot[][] slots;

    public Inventory(int baris, int kolom) {
        this.baris = baris;
        this.kolom = kolom;
        this.slots = new Slot[baris][kolom];

        for (int r = 0; r < baris; r++) {
            for (int c = 0; c < kolom; c++) {
                slots[r][c] = new Slot();
            }
        }
    }

    public int getBaris() {
        return baris;
    }

    public int getKolom() {
        return kolom;
    }

    public Slot getSlot(int baris, int kolom) {
        return slots[baris][kolom];
    }
}