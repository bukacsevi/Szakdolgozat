
package newpackage;

/**
 *
 * @Bukács Éva
 */
public class Vevő {
    
    private int vevoId;
    private String vezetekNev;
    private String keresztNev;
    private String vevoCim;
    private String vevoTelefonSzam;
    private String vevoEmailCim;
    
    public Vevő(int vevoId_, String vezetekNev_, String keresztNev_, String vevoCim_, String vevoTelefonSzam_, String vevoEmailCim_){
    vevoId=vevoId_;
    vezetekNev=vezetekNev_;
    keresztNev=keresztNev_;
    vevoCim= vevoCim_;
    vevoTelefonSzam=vevoTelefonSzam_;
    vevoEmailCim=vevoEmailCim_;    
    }
    public Vevő(String vezetekNev_, String keresztNev_, String vevoCim_, String vevoTelefonSzam_, String vevoEmailCim_){
    
    vezetekNev=vezetekNev_;
    keresztNev=keresztNev_;
    vevoCim= vevoCim_;
    vevoTelefonSzam=vevoTelefonSzam_;
    vevoEmailCim=vevoEmailCim_;    
    }

    public int getVevoId() {
        return vevoId;
    }

    public void setVevoId(int vevoId) {
        this.vevoId = vevoId;
    }

    public String getVezetekNev() {
        return vezetekNev;
    }

    public void setVezetekNev(String vezetekNev) {
        this.vezetekNev = vezetekNev;
    }

    public String getKeresztNev() {
        return keresztNev;
    }

    public void setKeresztNev(String keresztNev) {
        this.keresztNev = keresztNev;
    }

    public String getVevoCim() {
        return vevoCim;
    }

    public void setVevoCim(String vevoCim) {
        this.vevoCim = vevoCim;
    }

    public String getVevoTelefonSzam() {
        return vevoTelefonSzam;
    }

    public void setVevoTelefonSzam(String vevoTelefonSzam) {
        this.vevoTelefonSzam = vevoTelefonSzam;
    }

    public String getVevoEmailCim() {
        return vevoEmailCim;
    }

    public void setVevoEmailCim(String vevoEmailCim) {
        this.vevoEmailCim = vevoEmailCim;
    }
    @Override
    public String toString(){
        return vezetekNev+" "+keresztNev+" vevőkód: "+ vevoId;
    }
    
    
}
