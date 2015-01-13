package com.encoway.kata.vierGewinnt;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

import static org.junit.Assert.*;

public class VierGewinntTest {

    private VierGewinnt vierGewinnt;

    @Before
    public void setUp() {
        vierGewinnt = new VierGewinnt();
    }

    @Test
    public void testSpieler1Beginnt() {
        assertThat(vierGewinnt.stand(), is("Spieler 1 ist an der Reihe."));
    }

    @Test
    public void testMacheZug() throws Exception {
        assertTrue(vierGewinnt.macheZug(1));
    }

    @Test
    public void testSpielerWechsel() throws Exception {
        vierGewinnt.macheZug(1);
        assertThat(vierGewinnt.stand(), is("Spieler 2 ist an der Reihe."));
    }

    @Test
    public void testVertikalSieg() throws Exception {
        macheVieleZuege(1, 2, 1, 2, 1, 2, 1);
        assertThat(vierGewinnt.stand(), is("Spieler 1 hat gewonnen."));
    }

    @Test
    public void testLinksHorizontalSieg() throws Exception {
        macheVieleZuege(1, 1, 2, 2, 3, 3, 4);
        assertThat(vierGewinnt.stand(), is("Spieler 1 hat gewonnen."));
    }

    @Test
    public void testHorizontalSieg() throws Exception {
        macheVieleZuege(1, 1, 3, 3, 4, 4, 2);
        assertThat(vierGewinnt.stand(), is("Spieler 1 hat gewonnen."));
    }

    @Test
    public void testSlashSieg() throws Exception {
        macheVieleZuege(1, 2, 2, 3, 3, 4, 3, 4, 5, 4, 4);
        assertThat(vierGewinnt.stand(), is("Spieler 1 hat gewonnen."));
    }

    @Test
    public void testBackslashSieg() throws Exception {
        macheVieleZuege(1, 1, 1, 2, 1, 2, 2, 3, 3, 5, 4);
        assertThat(vierGewinnt.stand(), is("Spieler 1 hat gewonnen."));
    }

    @Test
    public void testSpalteVoll() throws Exception {
        macheVieleZuege(1, 1, 1, 1, 1, 1);
        assertFalse(vierGewinnt.macheZug(1));
    }

    @Test
    public void testUngueltigerZug() throws Exception {
        assertFalse(vierGewinnt.macheZug(8));
        assertFalse(vierGewinnt.macheZug(0));
        assertTrue(vierGewinnt.macheZug(7));
    }
    
    @Test
    public void testUnentschieden() throws Exception {
        macheVieleZuege(1,2,1,2,1,2,2,1,2,1,2,1,3,4,3,4,3,4,4,3,4,3,4,3,5,6,5,6,5,6,6,5,6,5,6,5,7,7,7,7,7,7);
        assertThat(vierGewinnt.stand(), is("Unentschieden"));
    }

    private void macheVieleZuege(int... spalten) {
        for (int i = 0; i < spalten.length; i++) {
            vierGewinnt.macheZug(spalten[i]);
        }
    }
}
