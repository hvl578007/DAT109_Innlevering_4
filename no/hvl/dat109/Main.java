package no.hvl.dat109;

public class Main {

    public static void main(String[] args) {
        Terning t1 = new Terning();
        Terning t2 = new Terning();
        Kopp kopp = new Kopp(t1, t2);
        Craps craps = new Craps(kopp);
        /*
        craps.triller();
        craps.sjekkerSum();
        craps.einVinn();
        craps.einTaper();
        */
    }
}