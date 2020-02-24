
package adatbáziskapcsolat;

/**
 *
 * @Bukács Éva
 */
public class Termék {
    
    private int termekId;
    private String cikkszam;
    private String megnevezes;
    private int ar;    
    private int darab;
    
    public Termék(int termekId_,String cikkszam_,String megnevezes_,int ar_,int darab_){
        termekId=termekId_;
        cikkszam=cikkszam_;
        megnevezes=megnevezes_;
        ar=ar_;
        darab=darab_;
        
    }
    
    public Termék(String cikkszam_,String megnevezes_,int ar_){
        
        cikkszam=cikkszam_;
        megnevezes=megnevezes_;
        ar=ar_;
        darab=0;
        
    }
    
    public int getAr() {
        return ar;
    }

    public void setAr(int ar) {
        this.ar = ar;
    }

    public int getTermekId() {
        return termekId;
    }

    public void setTermekId(int termekId) {
        this.termekId = termekId;
    }

    public String getCikkszam() {
        return cikkszam;
    }

    public void setCikkszam(String cikkszam) {
        this.cikkszam = cikkszam;
    }

    public String getMegnevezes() {
        return megnevezes;
    }

    public void setMegnevezes(String megnevezes) {
        this.megnevezes = megnevezes;
    }

    public int getDarab() {
        return darab;
    }

    public void setDarab(int darab) {
        this.darab = darab;
    }
    
    @Override
    public String toString(){
        return megnevezes;
    }
    
    
}
