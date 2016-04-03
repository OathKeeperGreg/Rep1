
import java.io.Serializable;


public class Client implements Serializable{
    private String name;
    private String surname;
    private String cust_number;
    
    public Client(String name, String surname, String cust_number){
        this.name = name;
        this.surname = surname;
        this.cust_number = cust_number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getNumber() {
        return cust_number;
    }

    public void setNumber(String cust_number) {
        this.cust_number = cust_number;
    }
    
    @Override
    public String toString(){
        return "Όνομα : " + name + "Επίθετο : " + surname + "Τηλέφωνο : " + cust_number;
    }
}
