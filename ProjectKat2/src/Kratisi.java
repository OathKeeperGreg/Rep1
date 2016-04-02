
import java.io.Serializable;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author g_man
 */
public class Kratisi implements Serializable{
    private Date afixh;
    private Date anaxwrhsh;
    private String type;
    private boolean prwino;
    private Client c;

    public Kratisi(Date afixh, Date anaxwrhsh, String type, boolean prwino, Client c) {
        this.afixh = afixh;
        this.anaxwrhsh = anaxwrhsh;
        this.type = type;
        this.prwino = prwino;
        this.c = c;
    }

    public Date getAfixh() {
        return afixh;
    }

    public void setAfixh(Date afixh) {
        this.afixh = afixh;
    }

    public Date getAnaxwrhsh() {
        return anaxwrhsh;
    }

    public void setAnaxwrhsh(Date anaxwrhsh) {
        this.anaxwrhsh = anaxwrhsh;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Client getC() {
        return c;
    }

    public void setC(Client c) {
        this.c = c;
    }

    public boolean isPrwino() {
        return prwino;
    }

    public void setPrwino(boolean prwino) {
        this.prwino = prwino;
    }

    @Override
    public String toString() {
        if (prwino = true) {
            return "Ημερομηνία Άφιξης : " + afixh + " Ημερομηνία Αναχώρησης : " + anaxwrhsh + " Τύπος δωματίου : " + type + " Πρωινό : " + " Ναι " + " Πελάτης : " + c;
        } else {
            return "Ημερομηνία Άφιξης : " + afixh + " Ημερομηνία Αναχώρησης : " + anaxwrhsh + " Τύπος δωματίου : " + type + " Πρωινό : " + " Όχι " + " Πελάτης : " + c;
        }
    }
}
    

