
package adatbáziskapcsolat;

/**
 *
 * @Bukács Éva
 */
public class Raktár {
    
    private int raktarId;
    private String raktarNev;
    private String raktarCim;
    private String raktarTelefonSzam;
    private String raktarEmailCim;
    
    public Raktár(int raktarId_,String raktarNev_,String raktarCim_, String raktarTelefonSzam_,String raktarEmailCim_){
        raktarId=raktarId_;
        raktarNev=raktarNev_;
        raktarCim=raktarCim_;
        raktarTelefonSzam=raktarTelefonSzam_;
        raktarEmailCim=raktarEmailCim_;        
    
    }
    
    public Raktár(String raktarNev_,String raktarCim_, String raktarTelefonSzam_,String raktarEmailCim_){
        
        raktarNev=raktarNev_;
        raktarCim=raktarCim_;
        raktarTelefonSzam=raktarTelefonSzam_;
        raktarEmailCim=raktarEmailCim_;        
    
    }

    public int getRaktarId() {
        return raktarId;
    }

    public void setRaktarId(int raktarId) {
        this.raktarId = raktarId;
    }

    public String getRaktarNev() {
        return raktarNev;
    }

    public void setRaktarNev(String raktarNev) {
        this.raktarNev = raktarNev;
    }

    public String getRaktarCim() {
        return raktarCim;
    }

    public void setRaktarCim(String raktarCim) {
        this.raktarCim = raktarCim;
    }

    public String getRaktarTelefonSzam() {
        return raktarTelefonSzam;
    }

    public void setRaktarTelefonSzam(String raktarTelefonSzam) {
        this.raktarTelefonSzam = raktarTelefonSzam;
    }

    public String getRaktarEmailCim() {
        return raktarEmailCim;
    }

    public void setRaktarEmailCim(String raktarEmailCim) {
        this.raktarEmailCim = raktarEmailCim;
    }
    
    
}
