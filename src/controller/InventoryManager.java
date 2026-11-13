package controller;

import model.ItemStack;
import model.Slot;

public class InventoryManager {
    private ItemStack heldStack; // Barang yang sedang 'melayang' di kursor mouse

    public InventoryManager() {
        this.heldStack = null;
    }

    public ItemStack getHeldStack() {
        return heldStack;
    }

    // Mengembalikan pesan String untuk ditampilkan di JTextArea (Log UI)
    public String clickSlot(Slot clickedSlot) {
        ItemStack slotStack = clickedSlot.getStack();

        // Skenario 1: Kursor kosong, petak ada isi -> Ambil barang ke kursor
        if (heldStack == null && !clickedSlot.isKosong()) {
            heldStack = slotStack;
            clickedSlot.kosongkan();
            return "Mengambil " + heldStack.getJumlah() + "x [" + heldStack.getItem().getNama() + "] ke kursor.";
        }

        // Skenario 2: Kursor ada barang, petak kosong -> Taruh barang
        else if (heldStack != null && clickedSlot.isKosong()) {
            clickedSlot.setStack(heldStack);
            String msg = "Menaruh " + heldStack.getJumlah() + "x [" + heldStack.getItem().getNama() + "] ke slot.";
            heldStack = null;
            return msg;
        }

        // ... (Skenario 1 dan 2 tetap sama) ...

        // Skenario 3: Kursor ada barang, petak ada barang -> Stack (Kursor menyerap petak) atau Swap
        else if (heldStack != null && !clickedSlot.isKosong()) {

            // Jika ID barang sama -> Kursor MENYERAP barang dari slot
            if (heldStack.getItem().getId().equals(slotStack.getItem().getId())) {

                int jumlahAwalSlot = slotStack.getJumlah();
                // Kursor mencoba menelan semua jumlah barang dari slot
                int sisa = heldStack.tambahJumlah(jumlahAwalSlot);

                if (sisa == 0) {
                    // Semua berhasil masuk ke kursor, petak dikosongkan
                    clickedSlot.kosongkan();
                    return "Mengakumulasi tumpukan! Di kursor sekarang ada " + heldStack.getJumlah() + "x [" + heldStack.getItem().getNama() + "].";
                } else {
                    // Kursor mencapai Max Stack, sisa barang ditinggalkan di petak
                    int jumlahYangBerhasilDiambil = jumlahAwalSlot - sisa;
                    slotStack.kurangiJumlah(jumlahYangBerhasilDiambil);

                    return "Kursor penuh (Max " + heldStack.getItem().getMaxStack() + ")! Sisa " + sisa + "x [" + slotStack.getItem().getNama() + "] ditinggalkan di petak.";
                }
            }
            // Jika ID barang berbeda -> Lakukan Swapping (Tukar posisi)
            else {
                ItemStack temp = slotStack;
                clickedSlot.setStack(heldStack);
                heldStack = temp;
                return "Menukar [" + clickedSlot.getStack().getItem().getNama() + "] dengan [" + heldStack.getItem().getNama() + "].";
            }
        }

        return "Petak kosong, tidak ada tindakan.";
    }
}