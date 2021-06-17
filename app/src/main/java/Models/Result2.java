package Models;

public class Result2 {
    String result;
    String dogrulamakodu;
    String truefalse;
    String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getDogrulamakodu() {
        return dogrulamakodu;
    }

    public void setDogrulamakodu(String dogrulamakodu) {
        this.dogrulamakodu = dogrulamakodu;
    }

    public String getTruefalse() {
        return truefalse;
    }

    public void setTruefalse(String truefalse) {
        this.truefalse = truefalse;
    }

    @Override
    public String toString() {
        return "Result2{" +
                "result='" + result + '\'' +
                ", dogrulamakodu='" + dogrulamakodu + '\'' +
                ", truefalse='" + truefalse + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
