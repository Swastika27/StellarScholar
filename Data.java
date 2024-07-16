package StellarScholar;

public class Data {
    public String Guardian;
    public String password;

    public Data(String user, String password) {
        this.Guardian = user;
        this.password = password;
    }
    public Data()
    {

    }

    public String getUser() {
        return Guardian;
    }

    public void setUser(String user) {
        this.Guardian = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        String st = Guardian + "  " + password;
        return st;
    }
}
