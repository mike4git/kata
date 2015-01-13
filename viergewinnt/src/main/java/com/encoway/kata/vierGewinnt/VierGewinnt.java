package com.encoway.kata.vierGewinnt;

public class VierGewinnt {

    private static final int ZEILENANZAHL = 6;
    private static final int SPALTENANZAHL = 7;
    private static final String SPIELER_ANREDE = "Spieler ";
    private static final String ZUGMELDUNG = " ist an der Reihe.";
    private static final String SIEGMELDUNG = " hat gewonnen.";

    private int[][] board = new int[SPALTENANZAHL][ZEILENANZAHL];
    
    private int aktuellerSpieler = 1;
    private int anzahlZuege;
    
    private boolean sieg;

    public String stand() {
        if (unentschieden()) {
            return "Unentschieden";
        }
        if (sieg) {
            return SPIELER_ANREDE + aktuellerSpieler + SIEGMELDUNG;
        }
        return SPIELER_ANREDE + aktuellerSpieler + ZUGMELDUNG;
    }

    public boolean macheZug(int gewaehlteSpalte) {
        int interneSpalte = gewaehlteSpalte-1;
        int interneZeile = setzeStein(interneSpalte, 0);
        
        if(!istAufdemFeld(interneSpalte, interneZeile))
            return false;
        
        sieg = pruefeVertikalSieg(interneSpalte, interneZeile) || pruefeHorizontalSieg(interneSpalte, interneZeile) || pruefeDiagonalSlashSieg(interneSpalte, interneZeile) || pruefeDiagonalBackslashSieg(interneSpalte, interneZeile); 
        
        if (!sieg) {
            wechsleSpieler();
            zaehleZuege();
        }
        return true;
    }

    private void zaehleZuege() {
        anzahlZuege++;
    }

    private boolean unentschieden() {
        return anzahlZuege == 42;
    }
    
    private boolean pruefeDiagonalBackslashSieg(int spalte, int zeile) {
        return pruefeSiegInRichtung(spalte, zeile, -1, 1);
    }

    private boolean pruefeDiagonalSlashSieg(int spalte, int zeile) {
        return pruefeSiegInRichtung(spalte, zeile, 1, 1);
    }

    private boolean pruefeHorizontalSieg(int spalte, int zeile) {
        return pruefeSiegInRichtung(spalte, zeile, 0, 1);
    }
    
    private boolean pruefeVertikalSieg(int spalte, int zeile) {
        return pruefeSiegInRichtung(spalte, zeile, 1, 0);
    }
    
    private boolean pruefeSiegInRichtung(int spalte, int zeile, int zeilenRichtung, int spaltenRichtung) {
        int summeGleicherSteine = 0;
        
        summeGleicherSteine += zaehleGleicheSteine(spalte, spaltenRichtung,zeile, zeilenRichtung);
        summeGleicherSteine += zaehleGleicheSteine(spalte-spaltenRichtung, -spaltenRichtung, zeile-zeilenRichtung, -zeilenRichtung);
        
        if(summeGleicherSteine>= 4)
            return true;
        
        return false;
    }

    private int zaehleGleicheSteine(int spalte, int spaltenRichtung,
            int zeile, int zeilenRichtung) {
        int summeGleicherSteine = 0;
        int spaltenindex= spalte;
        int zeilenindex = zeile;
        
        while(istAufdemFeld(spaltenindex, zeilenindex) && gleicherStein(spaltenindex, zeilenindex)) {
            summeGleicherSteine++;
            zeilenindex = zeilenindex + zeilenRichtung;
            spaltenindex = spaltenindex + spaltenRichtung;
        }
        return summeGleicherSteine;
    }
    
    private boolean gleicherStein(int spalte, int zeile) {
        return board[spalte][zeile] == aktuellerSpieler;
    }

    private boolean istAufdemFeld(int spalte, int zeile) {
        return spalte >= 0 && spalte < SPALTENANZAHL && zeile >=0 && zeile < ZEILENANZAHL;
    }
    
    private void wechsleSpieler() {
        aktuellerSpieler = (aktuellerSpieler % 2) + 1;
    }
    
    private int setzeStein(int spalte, int zeile) {
        while(istAufdemFeld(spalte, zeile) && board[spalte][zeile] != 0) {
            zeile++;
        }
        
        if(!istAufdemFeld(spalte, zeile))
            return -1;
        
        board[spalte][zeile] = aktuellerSpieler;
        return zeile;
    }
    
}
