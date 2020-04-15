
package newpackage;

/**
 *
 * @Bukács Éva
 */
public class Beszállító {
    
    private int cegId;
    private String cegNev;
    private String telephely;
    private String cegTelefonSzam;
    private String cegEmailCim;
    private String cegAdoSzam;
    
    public Beszállító(int cegId_, String cegNev_, String telephely_, String cegTelefonSzam_, String cegEmailCim_, String cegAdoSzam_){
        cegId=cegId_;
        cegNev=cegNev_;
        telephely=telephely_;
        cegTelefonSzam=cegTelefonSzam_;
        cegEmailCim=cegEmailCim_;
        cegAdoSzam= cegAdoSzam_;
    
    }
    public Beszállító(String cegNev_, String telephely_, String cegTelefonSzam_, String cegEmailCim_, String cegAdoSzam_){
        
        cegNev=cegNev_;
        telephely=telephely_;
        cegTelefonSzam=cegTelefonSzam_;
        cegEmailCim=cegEmailCim_;
        cegAdoSzam= cegAdoSzam_;
    
    }

    public int getCegId() {
        return cegId;
    }

    public void setCegId(int cegId) {
        this.cegId = cegId;
    }

    public String getCegNev() {
        return cegNev;
    }

    public void setCegNev(String cegNev) {
        this.cegNev = cegNev;
    }

    public String getTelephely() {
        return telephely;
    }

    public void setTelephely(String telephely) {
        this.telephely = telephely;
    }

    public String getCegTelefonSzam() {
        return cegTelefonSzam;
    }

    public void setCegTelefonSzam(String cegTelefonSzam) {
        this.cegTelefonSzam = cegTelefonSzam;
    }

    public String getCegEmailCim() {
        return cegEmailCim;
    }

    public void setCegEmailCim(String cegEmailCim) {
        this.cegEmailCim = cegEmailCim;
    }

    public String getCegAdoSzam() {
        return cegAdoSzam;
    }

    public void setCegAdoSzam(String cegAdoSzam) {
        this.cegAdoSzam = cegAdoSzam;
    }
    @Override
    public String toString(){
        return cegNev;
    }
    
}
