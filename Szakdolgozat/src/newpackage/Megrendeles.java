
package newpackage;

import java.sql.Date;


public class Megrendeles {
    
    private int vevoId;
    private int termekId;
    private int rendeltMennyiseg;
    private Date datum;    
    

    public Megrendeles(int vevoId, int termekId, int rendeltMennyiseg, Date datum) {
        this.vevoId = vevoId;
        this.termekId = termekId;
        this.rendeltMennyiseg = rendeltMennyiseg;
        this.datum = datum;
    }
    
    

    public int getVevoId() {
        return vevoId;
    }

    public void setVevoId(int vevoId) {
        this.vevoId = vevoId;
    }

    public int getTermekId() {
        return termekId;
    }

    public void setTermekId(int termekId) {
        this.termekId = termekId;
    }

    public int getRendeltMennyiseg() {
        return rendeltMennyiseg;
    }

    public void setRendeltMennyiseg(int rendeltMennyiseg) {
        this.rendeltMennyiseg = rendeltMennyiseg;
    }

    public Date getDatum() {
        return datum;
    }
    

    public void setDatum(Date datum) {
        this.datum = datum;
    }
    
    @Override
    public String toString(){    
        return String.valueOf(vevoId);
    }
    
    
}
