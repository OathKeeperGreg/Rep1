
import java.io.Serializable;


public class User implements Serializable{

    protected static String Nickname;
    protected static String Port;

    public User(String Nickname, String Port) {
        this.Nickname = Nickname;
        this.Port = Port;
    }

    public User(String Nickname) {
        this.Nickname = Nickname;
    }

    public static String getPort() {
        return Port;
    }

    public void setPort(String Port) {
        this.Port = Port;
    }

    public static String getNickname() {
        return Nickname;
    }

    public void setNickname(String Nickname) {
        this.Nickname = Nickname;
    }

    @Override
    public String toString() {
        return Nickname + Port;
    }
 @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        return ((User) this).Port.equals(((User) o).Port);
    }

}
