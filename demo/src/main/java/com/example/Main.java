package com.example;

public class Main {
    public static void main(String[] args) {
        Bagno b1 = new Bagno();
        String[] nomi = {"Marco", "Viola", "Francesco","Lorenzo","Sara","Ilaria","Olivia"};
        char[] sessi = {'M', 'F', 'M','M','F','F','F'};

        for(int i=0; i<nomi.length;i++) {
            ThreadB t = new ThreadB(b1, nomi[i], sessi[i]);
            t.start();
        }
    }

}