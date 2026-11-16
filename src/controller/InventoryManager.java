package controller;

import model.Item;
import model.Slot;

public class InventoryManager {
    private Item heldItem;

    public InventoryManager() {
        this.heldItem = null;
    }

    public Item getHeldItem() {
        return heldItem;
    }

    public String clickSlot(Slot clickedSlot) {
        Item slotItem = clickedSlot.getItem();

        // Skenario 1: Kursor kosong, petak berisi -> Ambil barang
        if (heldItem == null && !clickedSlot.isKosong()) {
            heldItem = slotItem;
            clickedSlot.kosongkan();
            return "Mengambil " + heldItem.getJumlah() + "x [" + heldItem.getNama() + "] ke kursor.";
        }
        // Skenario 2: Kursor berisi, petak kosong -> Taruh barang
        else if (heldItem != null && clickedSlot.isKosong()) {
            clickedSlot.setItem(heldItem);
            String msg = "Menaruh " + heldItem.getJumlah() + "x [" + heldItem.getNama() + "] ke slot.";
            heldItem = null;
            return msg;
        }
        // Skenario 3: Kursor berisi, petak berisi -> Stack atau Swap
        else if (heldItem != null && !clickedSlot.isKosong()) {
            if (heldItem.getId().equals(slotItem.getId())) {
                int jumlahAwalSlot = slotItem.getJumlah();
                int sisa = heldItem.tambahJumlah(jumlahAwalSlot);

                if (sisa == 0) {
                    clickedSlot.kosongkan();
                    return "Mengakumulasi tumpukan! Di kursor sekarang ada " + heldItem.getJumlah() + "x [" + heldItem.getNama() + "].";
                } else {
                    slotItem.kurangiJumlah(jumlahAwalSlot - sisa);
                    return "Kursor penuh (Max " + heldItem.getMaxStack() + ")! Sisa " + sisa + "x [" + slotItem.getNama() + "] ditinggalkan di petak.";
                }
            } else {
                Item temp = slotItem;
                clickedSlot.setItem(heldItem);
                heldItem = temp;
                return "Menukar [" + clickedSlot.getItem().getNama() + "] dengan [" + heldItem.getNama() + "].";
            }
        }

        return "Petak kosong, tidak ada tindakan.";
    }
}