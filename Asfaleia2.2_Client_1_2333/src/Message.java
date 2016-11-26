
import java.io.Serializable;

public class Message implements Serializable {

    Object message1;
    Object message2;
    String mes_type;
    boolean user_status;

    public Message(Object message1) {
        this.message1 = message1;
    }

    public Message(Object message1, Object message2, boolean user_status) {
        this.message1 = message1;
        this.message2 = message2;
        this.user_status = user_status;
    }

    public Message(Object message1, Object message2) {
        this.message1 = message1;
        this.message2 = message2;
    }

    public Message(Object message1, Object message2, String mes_type, boolean user_status) {
        this.message1 = message1;
        this.message2 = message2;
        this.mes_type = mes_type;
        this.user_status = user_status;
    }

    public String getMes_type() {
        return mes_type;
    }

    public void setMes_type(String mes_type) {
        this.mes_type = mes_type;
    }

    public boolean isUser_status() {
        return user_status;
    }

    public void setUser_status(boolean user_status) {
        this.user_status = user_status;
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
