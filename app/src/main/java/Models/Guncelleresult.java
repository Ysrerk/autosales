package Models;

public class Guncelleresult {
    String gresult;
    Boolean tf;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    String  email;




    public String getGresult() {
        return gresult;
    }

    public void setGresult(String gresult) {
        this.gresult = gresult;
    }

    public Boolean getTf() {
        return tf;
    }

    public void setTf(Boolean tf) {
        this.tf = tf;
    }

    @Override
    public String toString() {
        return "Guncelleresult{" +
                "gresult='" + gresult + '\'' +
                ", tf=" + tf +
                ", email='" + email + '\'' +
                '}';
    }
}
