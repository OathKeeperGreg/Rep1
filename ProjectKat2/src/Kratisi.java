
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;
import static jdk.nashorn.internal.runtime.Debug.id;


public class Kratisi implements Serializable{
    private Date afixh;
    private Date anaxwrhsh;
    private String type;
    private boolean prwino;
    private Client c;
    private int xrewsh;
    String id;
    
    public Kratisi(Date afixh, Date anaxwrhsh, String type, boolean prwino, Client c) {
        this.afixh = afixh;
        this.anaxwrhsh = anaxwrhsh;
        this.type = type;
        this.prwino = prwino;
        this.c = c;
        xrewsh = 0;
        id = null;
        
    }

    public Date getAfixh() {
        return afixh;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAfixh(Date afixh) {
        this.afixh = afixh;
    }

    public int getXrewsh() {
        return xrewsh;
    }

    public void setXrewsh(int xrewsh) {
        this.xrewsh = xrewsh;
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

    void setId(UUID d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
    

