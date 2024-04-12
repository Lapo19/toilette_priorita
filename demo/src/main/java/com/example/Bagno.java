package com.example;


public class Bagno {
    private boolean disponibile = true;
    private int numDonneAttesa = 0;

    public synchronized void entra(ThreadB B) {
        String name = Thread.currentThread().getName();
        char sesso = B.getSesso();
        if (sesso == 'F')numDonneAttesa++;
        try {
            while ( ! disponibile || (sesso == 'M' && numDonneAttesa > 0)) {
                System.out.println(name + " in attesa di entrare...");
                wait();
            }
            disponibile = false;
            if (sesso == 'F')numDonneAttesa--;
            System.out.println(name + " entra in bagno");
        } catch ( InterruptedException e) { }
    }

    public synchronized void esci() {
        String name = Thread.currentThread().getName();
        System.out.println(name + " esce dal bagno");
        disponibile = true;
        notifyAll();
    }

}
