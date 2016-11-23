
import java.io.Serializable;

public class Message implements Serializable {

    Object message1;
    Object message2;
    String mes_type;
    
    public Message(Object message1) {
        this.message1 = message1;
    }

    public Message(Object message1, Object message2) {
        this.message1 = message1;
        this.message2 = message2;
    }

    public Message(Object message1, Object message2, String mes_type) {
        this.message1 = message1;
        this.message2 = message2;
        this.mes_type = mes_type;
    }

    public String getMes_Type() {
        return mes_type;
    }

    public void setMessage3(String mes_type) {
        this.mes_type = mes_type;
    }

    public Object getMessage1() {
        return message1;
    }

    public void setMessage1(String message1) {
        this.message1 = message1;
    }

    public Object getMessage2() {
        return message2;
    }

    public void setMessage2(String message2) {
        this.message2 = message2;
    }

}
