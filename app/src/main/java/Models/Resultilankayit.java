package Models;

public class Resultilankayit {
    String ilanid;
    String memberid;

    public String getIlanid() {
        return ilanid;
    }

    public void setIlanid(String ilanid) {
        this.ilanid = ilanid;
    }

    public String getMemberid() {
        return memberid;
    }

    public void setMemberid(String memberid) {
        this.memberid = memberid;
    }

    public Boolean getTf() {
        return tf;
    }

    public void setTf(Boolean tf) {
        this.tf = tf;
    }

    Boolean tf;

    @Override
    public String toString() {
        return "Resultilankayit{" +
                "ilanid='" + ilanid + '\'' +
                ", memberid='" + memberid + '\'' +
                ", tf=" + tf +
                '}';
    }
}
