import java.io.Serializable;
import java.util.Date;

public class Kratisi implements Serializable{

    private Date afixh;
    private Date anaxwrhsh;
    private String type;
    private boolean prwino;
    private Customer c;

    public Kratisi(Date afixh, Date anaxwrhsh, String type, boolean prwino, Customer c) {
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

    public Customer getC() {
        return c;
    }

    public void setC(Customer c) {
        this.c = c;
    }

    public boolean isPrwino() {
        return prwino;
    }

    public void setPrwino(boolean prwino) {
        this.prwino = prwino;
    }
    

}
