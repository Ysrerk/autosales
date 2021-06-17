package Models;

public class Result {
     private String id;
     private String email;
     private String sifre;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    @Override
    public String toString() {
        return "result{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                ", sifre='" + sifre + '\'' +
                '}';
    }
}
