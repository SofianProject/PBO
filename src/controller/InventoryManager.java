package controller;

import model.ItemStack;
import model.Slot;

public class InventoryManager {
    private ItemStack heldStack;

    public InventoryManager() {
        this.heldStack = null;
    }

    public ItemStack getHeldStack() {
        return heldStack;
    }

    public String clickSlot(Slot clickedSlot) {
        ItemStack slotStack = clickedSlot.getStack();

        if (heldStack == null && !clickedSlot.isKosong()) {
            heldStack = slotStack;
            clickedSlot.kosongkan();
            return "Mengambil " + heldStack.getJumlah() + "x [" + heldStack.getItem().getNama() + "] ke kursor.";
        }

        else if (heldStack != null && clickedSlot.isKosong()) {
            clickedSlot.setStack(heldStack);
            String msg = "Menaruh " + heldStack.getJumlah() + "x [" + heldStack.getItem().getNama() + "] ke slot.";
            heldStack = null;
            return msg;
        }

        else if (heldStack != null && !clickedSlot.isKosong()) {

            if (heldStack.getItem().getId().equals(slotStack.getItem().getId())) {

                int jumlahAwalSlot = slotStack.getJumlah();
                int sisa = heldStack.tambahJumlah(jumlahAwalSlot);

                if (sisa == 0) {
                    clickedSlot.kosongkan();
                    return "Mengakumulasi tumpukan! Di kursor sekarang ada " + heldStack.getJumlah() + "x [" + heldStack.getItem().getNama() + "].";
                } else {
                    int jumlahYangBerhasilDiambil = jumlahAwalSlot - sisa;
                    slotStack.kurangiJumlah(jumlahYangBerhasilDiambil);

                    return "Kursor penuh (Max " + heldStack.getItem().getMaxStack() + ")! Sisa " + sisa + "x [" + slotStack.getItem().getNama() + "] ditinggalkan di petak.";
                }
            }
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