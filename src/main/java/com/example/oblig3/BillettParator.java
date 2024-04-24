package com.example.oblig3;

import java.util.Comparator;

public class BillettParator implements Comparator<Billett> {

    @Override
    public int compare(Billett b1, Billett b2) {
        return b1.getEtternavn().compareTo(b2.getEtternavn());
    }
}
