package newpackage;

public class Cimzett {

    private String nev;
    private String cim;
    private String telefonszam;
    private String email;

    public Cimzett(String nev, String cim, String telefonszam, String email) {
        this.nev = nev;
        this.cim = cim;
        this.telefonszam = telefonszam;
        this.email = email;
    }

    public String getCim() {
        return cim;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public void setCim(String cim) {
        this.cim = cim;
    }

    public String getTelefonszam() {
        return telefonszam;
    }

    public void setTelefonszam(String telefonszam) {
        this.telefonszam = telefonszam;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
