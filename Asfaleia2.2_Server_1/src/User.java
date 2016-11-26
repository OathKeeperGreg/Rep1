
import java.io.Serializable;

public class User implements Serializable {

    protected String Nickname;
    protected String Port;
    protected boolean status;

    public User(String Nickname, String Port, boolean status) {
        this.Nickname = Nickname;
        this.Port = Port;
        this.status = status;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public User(String Nickname) {
        this.Nickname = Nickname;
    }

    public String getPort() {
        return Port;
    }

    public void setPort(String Port) {
        this.Port = Port;
    }

    public String getNickname() {
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
