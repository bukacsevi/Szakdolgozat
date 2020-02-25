package adatbáziskapcsolat;

import static java.lang.Math.E;
import static java.lang.StrictMath.E;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractListModel;
import javax.swing.JOptionPane;

/**
 *
 * @Bukács Éva
 */
public class DbKapcsolat {

    private Vector<Termék> termekek;
    private Vector<Raktár> raktarak;
    private Vector<Vevő> vevok;
    private Vector<Beszállító> beszallitok;

    private String database;
    private Connection con;
    private Statement stmt;
    private PreparedStatement ptmt;

    public DbKapcsolat() {
        termekek = new Vector<Termék>();
        raktarak = new Vector<Raktár>();
        vevok = new Vector<Vevő>();
        beszallitok = new Vector<Beszállító>();

        //Kapcsolat az adatbázissal
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "jelszo");
            //c.setAutoCommit(false);
            stmt = con.createStatement();

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ":" + e.getMessage());
            System.err.println("Adatbáziskapcsolati hiba!");
            System.exit(0);
        }
        System.out.println("Csatlakozva");

        /* if (con != null) {
         try {
         stmt = con.createStatement();
         } catch (SQLException ex) {
         System.out.println("Hiba a statementel: " + ex);
         }

         }*/
        //Táblák létrehozása ha még nem létezik
        //Termék Tábla
        try {      //BESZÁLLITOiD és nem kell db
            stmt.execute("CREATE TABLE IF NOT EXISTS termekek("
                    + "termekId  SERIAL NOT NULL PRIMARY KEY,"
                    + "cikkszám text," // legyen unique
                    + "megnevezes text,"
                    + "ar int,"
                    + "darab text)"); //nem kell ide

            System.out.println("tábla termekek létrehozva");

        } catch (SQLException ex) {
            Logger.getLogger(DbKapcsolat.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("hiba a termek tábla létrehozásánál");
        }

        //Raktár Tábla
        try {
            stmt.execute("CREATE TABLE IF NOT EXISTS raktarak("
                    + "raktarId  SERIAL NOT NULL PRIMARY KEY,"
                    + "raktarNev text," //legyen unique
                    + "raktarCim text,"
                    + "raktarTelefonSzam text,"
                    + "raktarEmailCim text)");

            System.out.println("tábla raktarak létrehozva");

        } catch (SQLException ex) {
            Logger.getLogger(DbKapcsolat.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("hiba a raktar tábla létrehozásánál");
        }

        //Vevők tábla
        try {
            stmt.execute("CREATE TABLE IF NOT EXISTS vevok("
                    + "vevoId  SERIAL NOT NULL PRIMARY KEY,"
                    + "vezetekNev text,"
                    + "keresztNev text,"
                    + "vevocim text,"
                    + "vevoTelefonSzam text,"
                    + "vevoEmailCim text)");

            System.out.println("tábla vevok létrehozva");

        } catch (SQLException ex) {
            Logger.getLogger(DbKapcsolat.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("hiba a vevok tábla létrehozásánál");
        }

        //Beszállítók tábla
        try {
            stmt.execute("CREATE TABLE IF NOT EXISTS beszallitok("
                    + "cegId  SERIAL NOT NULL PRIMARY KEY,"
                    + "cegNev text,"
                    + "telephely text,"
                    + "cegTelefonSzam text,"
                    + "cegEmailCim text,"
                    + "cegAdoSzam text)");

            System.out.println("tábla beszallitok létrehozva");

        } catch (SQLException ex) {
            Logger.getLogger(DbKapcsolat.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("hiba a beszallitok tábla létrehozásánál");
        }

        //Tranzakciók tábla
        try {
            stmt.execute("CREATE TABLE IF NOT EXISTS tranzakciok ("
                    + "  tranzakcioId SERIAL NOT NULL PRIMARY KEY,   "
                    + "  raktarId int REFERENCES raktarak(raktarId),"
                    + "  termekId int REFERENCES termekek(termekId),"
                    + "  termekDb int"
                    + ")");

            System.out.println("tábla tranzakciok létrehozva");

        } catch (SQLException ex) {
            Logger.getLogger(DbKapcsolat.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("hiba a tranzakciok tábla létrehozásásnál");
        }

        termekekVektorFeltolt();
        raktarakVektorFeltolt();
        vevokVektorFeltolt();
        beszallitokVektorFeltolt();

        //lekerdezTranzakcio();
    }

    public Vector<Termék> getTermekek() {
        return this.termekek;
    }

    public Vector<Raktár> getRaktarak() {
        return this.raktarak;
    }

    public Vector<Vevő> getVevok() {
        return this.vevok;
    }

    public Vector<Beszállító> getBeszallitok() {
        return this.beszallitok;
    }

    public void bevetelezes(int raktarId, int termekId, int db) {
        int darab = 0;
        int vanE = -1;
        try {
            
            ResultSet rs = stmt.executeQuery("SELECT count(*) vanE FROM tranzakciok where termekId=" + termekId + " AND raktarId=" + raktarId + ";");
            while (rs.next()) {
                vanE = rs.getInt("vanE");

            }
            rs = stmt.executeQuery("SELECT tranzakciok.termekDb FROM tranzakciok where termekId=" + termekId + " AND raktarId=" + raktarId + ";");
            while (rs.next()) {
                darab = db + rs.getInt("termekDb");

            }
        } catch (SQLException ex) {
            Logger.getLogger(DbKapcsolat.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (vanE == 0) {
            try {
                ptmt = con.prepareStatement("INSERT INTO tranzakciok (raktarId,termekId,termekDb)VALUES(?,?,?);");
                ptmt.setInt(1, raktarId);
                System.out.println("1");
                ptmt.setInt(2, termekId);
                System.out.println("2");
                ptmt.setInt(3, db);//javítani hogy termekDbnek legyen alapértéke 0 a tranzakciókban
                System.out.println("3");
                ptmt.executeUpdate();
                System.out.println("Tranzakcio hozzáadva");
            } catch (SQLException ex) {
                Logger.getLogger(DbKapcsolat.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (vanE != 0) {
            try {
                ptmt = con.prepareStatement("UPDATE tranzakciok SET termekDb=? WHERE  termekId=" + termekId + " AND raktarId=" + raktarId + ";");

                ptmt.setInt(1, darab);
                ptmt.executeUpdate();
                System.out.println("Tranzakcio hozzáadva");
            } catch (Exception e) {
                System.out.println("2ajjajj");
            }

        }
        lekerdezTranzakcio();
    }

    private void lekerdezTranzakcio() {
        try {

            ResultSet rs = stmt.executeQuery("SELECT tranzakcioId, raktarak.raktarNev, termekek.megnevezes, tranzakciok.termekDb FROM ((tranzakciok INNER JOIN termekek ON tranzakciok.termekId=termekek.termekId) INNER JOIN raktarak ON tranzakciok.raktarId=raktarak.raktarId) ;");

            System.out.println("_____________________Tranzakciok:___________________________");
            while (rs.next()) {

                System.out.println("tranzakcioId:  " + rs.getInt("tranzakcioId"));
                System.out.println("raktarNev  :" + rs.getString("raktarNev"));
                System.out.println("termek megnevezes:  " + rs.getString("megnevezes"));
                System.out.println("termek db:  " + rs.getInt("termekDb"));
                System.out.println("");

            }//while
        } catch (SQLException se) {
            System.err.println("Tranzakcio lekérdezési hiba!");
            //System.err.println(se.getSQLState()); //hibakód
            System.err.println(se.getMessage()); //sql hibaüzenet
        }
    }

    public void lekerdezTermekekTabla() {
        try {
            ResultSet rs = stmt.executeQuery("SELECT * FROM termekek;");
            System.out.println("_____________________Termékek:___________________________");
            while (rs.next()) {
                System.out.println("id:  " + rs.getInt("termekId"));
                System.out.println("cikkszám:  " + rs.getString("cikkszám"));
                System.out.println("megnevezés  :" + rs.getString("megnevezes"));
                System.out.println("ár:  " + rs.getInt("ar"));
                System.out.println("darab:  " + rs.getInt("darab"));
                System.out.println("");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DbKapcsolat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void lekerdezRaktarakTabla() {
        try {

            ResultSet rs = stmt.executeQuery("SELECT * FROM raktarak ;");

            System.out.println("__________________Raktárak:__________________________");
            while (rs.next()) {

                System.out.println("id: " + rs.getInt("raktarId"));
                System.out.println("nev:  " + rs.getString("raktarNev"));
                System.out.println("cim:  " + rs.getString("raktarCim"));
                System.out.println("telefonszam:  " + rs.getString("raktarTelefonSzam"));
                System.out.println("email:  " + rs.getString("raktarEmailCim"));
                System.out.println("");

            }
        } catch (SQLException se) {
            System.err.println("Raktár lekérdezési hiba!");
            System.err.println(se.getMessage());
        }
    }

    public void lekerdezVevokTabla() {
        try {

            ResultSet rs = stmt.executeQuery("SELECT * FROM vevok ;");

            System.out.println("________________________Vevők:_____________________________");
            while (rs.next()) {
                System.out.println(rs.getInt("vevoId"));
                System.out.println(rs.getString("vezetekNev"));
                System.out.println(rs.getString("keresztNev"));
                System.out.println(rs.getString("vevoCim"));
                System.out.println(rs.getString("vevoTelefonSzam"));
                System.out.println(rs.getString("vevoEmailCim"));

            }
        } catch (SQLException se) {
            System.err.println("Vevő lekérdezési hiba!");
            System.err.println(se.getMessage());
        }
    }

    public void lekerdezBeszallitokTabla() {
        try {

            ResultSet rs = stmt.executeQuery("SELECT * FROM beszallitok ;");

            System.out.println("_____________________Beszállítók:__________________________");
            while (rs.next()) {
                System.out.println(rs.getInt("cegId"));
                System.out.println(rs.getString("cegNev"));
                System.out.println(rs.getString("telephely"));
                System.out.println(rs.getString("cegTelefonSzam"));
                System.out.println(rs.getString("cegEmailCim"));
                System.out.println(rs.getString("cegAdoszam"));
                System.out.println("");

            }
        } catch (SQLException se) {
            System.err.println("Vevő lekérdezési hiba!");
            System.err.println(se.getMessage());
        }
    }

    private void ujTermekVektorhozAd(Termék termek) {
        try {
            ResultSet rs = stmt.executeQuery("SELECT * FROM termekek WHERE cikkszám='" + termek.getCikkszam() + "' ;");

            while (rs.next()) {
                termekek.add(new Termék(rs.getInt("termekId"),
                        rs.getString("cikkszám"),
                        rs.getString("megnevezes"),
                        rs.getInt("ar"),
                        rs.getInt("darab")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DbKapcsolat.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void ujRaktarVektorhozAd(Raktár raktar) {
        try {
            ResultSet rs = stmt.executeQuery("SELECT * FROM raktarak WHERE raktarNev='" + raktar.getRaktarNev() + "' ;");

            while (rs.next()) {
                raktarak.add(new Raktár(rs.getInt("raktarId"),
                        rs.getString("raktarNev"),
                        rs.getString("raktarCim"),
                        rs.getString("raktarTelefonSzam"),
                        rs.getString("raktarEmailCim")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DbKapcsolat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void termekekVektorFeltolt() {
        try {

            ResultSet rs = stmt.executeQuery("SELECT * FROM termekek ;");
            termekek.clear();

            while (rs.next()) {
                termekek.add(new Termék(rs.getInt("termekId"),
                        rs.getString("cikkszám"),
                        rs.getString("megnevezes"),
                        rs.getInt("ar"),
                        rs.getInt("darab")));
            }
        } catch (SQLException se) {
            System.err.println("Termék lekérdezési hiba!");
            System.err.println(se.getMessage());
        }
    }

    public void raktarakVektorFeltolt() {
        try {

            ResultSet rs = stmt.executeQuery("SELECT * FROM raktarak ;");
            raktarak.clear();           
            while (rs.next()) {

                raktarak.add(new Raktár(rs.getInt("raktarId"),
                        rs.getString("raktarNev"),
                        rs.getString("raktarCim"),
                        rs.getString("raktarTelefonSzam"),
                        rs.getString("raktarEmailCim")));
            }
        } catch (SQLException se) {
            System.err.println("Raktár lekérdezési hiba!");
            System.err.println(se.getMessage());
        }
    }

    public void vevokVektorFeltolt() {
        try {

            ResultSet rs = stmt.executeQuery("SELECT * FROM vevok ;");
            vevok.clear();

            while (rs.next()) {
                vevok.add(new Vevő(rs.getInt("vevoId"),
                        rs.getString("vezetekNev"),
                        rs.getString("keresztNev"),
                        rs.getString("vevoCim"),
                        rs.getString("vevoTelefonSzam"),
                        rs.getString("vevoEmailCim")));

            }
        } catch (SQLException se) {
            System.err.println("Vevő lekérdezési hiba!");
            System.err.println(se.getMessage());
        }
    }

    public void beszallitokVektorFeltolt() {
        try {

            ResultSet rs = stmt.executeQuery("SELECT * FROM beszallitok ;");
            beszallitok.clear();  //régi adatokat eldobja

            while (rs.next()) {
                //újakkal feltölti
                beszallitok.add(new Beszállító(rs.getInt("cegId"),
                        rs.getString("cegNev"),
                        rs.getString("telephely"),
                        rs.getString("cegTelefonSzam"),
                        rs.getString("cegEmailCim"),
                        rs.getString("cegAdoszam")));
            }
        } catch (SQLException se) {
            System.err.println("Vevő lekérdezési hiba!");
            System.err.println(se.getMessage());
        }
    }

    public void ujTermek(Termék termek) {

        try {
            ptmt = con.prepareStatement("INSERT INTO termekek (cikkszám,megnevezes,ar)VALUES(?,?,?)");
            ptmt.setString(1, termek.getCikkszam());
            ptmt.setString(2, termek.getMegnevezes());
            ptmt.setInt(3, termek.getAr());
            ptmt.executeUpdate();

            ujTermekVektorhozAd(termek);

            System.out.println("Termék hozzáadva");

        } catch (SQLException ex) {
            Logger.getLogger(DbKapcsolat.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Hibás adatbevitel!");

        }
        //termekek.add(termek);

    }

    public void ujRaktar(Raktár raktar) {

        try {
            ptmt = con.prepareStatement("INSERT INTO raktarak (raktarNev,raktarCim,raktarTelefonSzam,raktarEmailCim)VALUES(?,?,?,?)");
            ptmt.setString(1, raktar.getRaktarNev());
            ptmt.setString(2, raktar.getRaktarCim());
            ptmt.setString(3, raktar.getRaktarTelefonSzam());
            ptmt.setString(4, raktar.getRaktarEmailCim());
            ptmt.executeUpdate();

            ujRaktarVektorhozAd(raktar);

            System.out.println("Raktár hozzáadva");

        } catch (SQLException ex) {
            Logger.getLogger(DbKapcsolat.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Hibás adatbevitel!");
        }
        // raktarak.add(raktar);

    }

    public void ujVevo(Vevő vevo) {

        try {

            String sql = "INSERT INTO vevok (vezetekNev,keresztNev,vevocim,vevoTelefonSzam,vevoEmailCim) "
                    + "VALUES ('" + vevo.getVezetekNev() + "','" + vevo.getKeresztNev() + "','" + vevo.getVevoCim() + "','" + vevo.getVevoTelefonSzam() + "','" + vevo.getVevoEmailCim() + "')";

            stmt.executeUpdate(sql);
            //vevo vektrohoz ad
            System.out.println("Vevő hozzáadva");

        } catch (SQLException ex) {
            Logger.getLogger(DbKapcsolat.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Hibás adatbevitel!");
        }

    }

    public void ujBeszallito(Beszállító beszallito) {

        try {

            String sql = "INSERT INTO beszallitok (cegNev,telephely,cegTelefonszam,cegEmailCim,cegAdoSzam) "
                    + "VALUES ('" + beszallito.getCegNev() + "','" + beszallito.getTelephely() + "','" + beszallito.getCegTelefonSzam() + "','" + beszallito.getCegEmailCim() + "','" + beszallito.getCegAdoSzam() + "')";

            stmt.executeUpdate(sql);
            //beszallito vektorhoz ad
            System.out.println("Beszállító hozzáadva");

        } catch (SQLException ex) {
            Logger.getLogger(DbKapcsolat.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Hibás adatbevitel!");
        }

    }
}
