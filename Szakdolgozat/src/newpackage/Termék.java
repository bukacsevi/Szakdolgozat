
package newpackage;

/**
 *
 * @Bukács Éva
 */
public class Termék {
    
    private int termekId;    
    private String cikkszam;
    private String megnevezes;
    private int ar;    
    private int rendeltMennyiseg;
    
    
    public Termék(int termekId_,String cikkszam_,String megnevezes_,int ar_){
        termekId=termekId_;        
        cikkszam=cikkszam_;
        megnevezes=megnevezes_;
        ar=ar_;
        
        
    }
    public Termék(int termekId_,String cikkszam_,String megnevezes_,int ar_, int rendeltMennyiseg_){
        termekId=termekId_;        
        cikkszam=cikkszam_;
        megnevezes=megnevezes_;
        ar=ar_;
        rendeltMennyiseg=rendeltMennyiseg_;
        
    }
    
    public Termék(String cikkszam_,String megnevezes_,int ar_){        
        cikkszam=cikkszam_;
        megnevezes=megnevezes_;
        ar=ar_;
        
        
    }

    

    public int getRendeltMennyiseg() {
        return rendeltMennyiseg;
    }

    public void setRendeltMennyiseg(int rendeltMennyiseg) {
        this.rendeltMennyiseg = rendeltMennyiseg;
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
    
    
    @Override
    public String toString(){
        return megnevezes+" - "+cikkszam;
    }
    
    
}
