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
                    + "cikkszám text,"
                    + "megnevezes text,"
                    + "ar int,"
                    + "darab text)");

            System.out.println("tábla termekek létrehozva");

        } catch (SQLException ex) {
            Logger.getLogger(DbKapcsolat.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("hiba a termek tábla ellenőrzésnél");
        }

        //Raktár Tábla
        try {
            stmt.execute("CREATE TABLE IF NOT EXISTS raktarak("
                    + "raktarId  SERIAL NOT NULL PRIMARY KEY,"
                    + "raktarNev text,"
                    + "raktarCim text,"
                    + "raktarTelefonSzam text,"
                    + "raktarEmailCim text)");

            System.out.println("tábla raktarak létrehozva");

        } catch (SQLException ex) {
            Logger.getLogger(DbKapcsolat.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("hiba a raktar tábla ellenőrzésnél");
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
            System.out.println("hiba a vevok tábla ellenőrzésnél");
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
            System.out.println("hiba a beszallitok tábla ellenőrzésnél");
        }

        //Tranzakciók táblaCREATE 
        //TABLE IF NOT EXISTS tranzakciok("
        //   + "tranzakcioId  SERIAL NOT NULL PRIMARY KEY,"
        //   + "FOREIGN KEY (termekId) REFERENCES termekek (termekId))
        try {
            stmt.execute("CREATE TABLE IF NOT EXISTS tranzakciok ("
                    + "  tranzakcioId SERIAL NOT NULL PRIMARY KEY,   "
                    + "  raktarId INTEGER REFERENCES raktarak(raktarId),"
                    + "  termekId INTEGER REFERENCES termekek(termekId),"
                    + "  termekDb int"
                    + ")");

            System.out.println("tábla tranzakciok létrehozva");

        } catch (SQLException ex) {
            Logger.getLogger(DbKapcsolat.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("hiba a tranzakciok tábla ellenőrzésnél");
        }

        lekerdezTermekek();
        lekerdezRaktarak();
        lekerdezVevok();
        lekerdezBeszallitok();
        //vanEraktar(1,1,100);
        //vanEraktar(1,2,150);
        // vanEraktar(2,1,30);
        // vanEraktar(2,2,350);
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
            /* ResultSet rs = stmt.executeQuery("SELECT count(*) raktar FROM tranzakciok where raktarId="+ raktarId +";");
             while (rs.next()) {
             raktar= rs.getInt("rakar");
             System.out.println(raktar);
             }*/
            ResultSet rs = stmt.executeQuery("SELECT count(*) vanE FROM tranzakciok where termekId=" + termekId + " AND raktarId=" + raktarId + ";");
            while (rs.next()) {
                vanE = rs.getInt("vanE");
                
            }
            rs = stmt.executeQuery("SELECT tranzakciok.termekDb FROM tranzakciok where termekId=" + termekId + " AND raktarId=" + raktarId + ";");
            while (rs.next()) {
                darab=db+rs.getInt("termekDb");
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(DbKapcsolat.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (vanE == 0) {
            try {
                ptmt = con.prepareStatement("INSERT INTO tranzakciok (raktarId,termekId,termekDb)VALUES(?,?,?);");
                ptmt.setInt(1, raktarId);
                ptmt.setInt(2, termekId);
                ptmt.setInt(3, db);//javítani hogy termekDbnek legyen alapértéke 0 a tranzakciókban
                ptmt.executeUpdate();
                System.out.println("Tranzakcio hozzáadva");
            } catch (Exception e) {
                System.out.println("1ajjajj");
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
            // termekek vektor feltöltése
            ResultSet rs = stmt.executeQuery("SELECT tranzakcioId, tranzakciok.raktarId, termekek.megnevezes, tranzakciok.termekDb FROM tranzakciok INNER JOIN termekek ON tranzakciok.termekId=termekek.termekId ;");  //ORDER BY nev

            System.out.println("_____________________Tranzakciok:___________________________");
            while (rs.next()) {

                System.out.println(rs.getInt("tranzakcioId"));
                System.out.println(rs.getInt("raktarId"));
                System.out.println(rs.getString("megnevezes"));
                System.out.println(rs.getInt("termekDb"));
                System.out.println("");

            }//while
        } catch (SQLException se) {
            System.err.println("Termék lekérdezési hiba!");
            //System.err.println(se.getSQLState()); //hibakód
            System.err.println(se.getMessage()); //sql hibaüzenet
        }
    }

    private void lekerdezTermekek() {
        try {
            // termekek vektor feltöltése
            ResultSet rs = stmt.executeQuery("SELECT * FROM termekek ;");  //ORDER BY nev
            termekek.clear();  //régi adatokat eldobja
            System.out.println("_____________________Termékek:___________________________");
            while (rs.next()) {
                //újakkal feltölti
                termekek.add(new Termék(rs.getInt("termekId"),
                        rs.getString("cikkszám"),
                        rs.getString("megnevezes"),
                        rs.getInt("ar"),
                        rs.getInt("darab")));

                System.out.println(rs.getInt("termekId"));
                System.out.println(rs.getString("cikkszám"));
                System.out.println(rs.getString("megnevezes"));
                System.out.println(rs.getInt("ar"));
                System.out.println(rs.getInt("darab"));
                System.out.println("");

            }//while
        } catch (SQLException se) {
            System.err.println("Termék lekérdezési hiba!");
            //System.err.println(se.getSQLState()); //hibakód
            System.err.println(se.getMessage()); //sql hibaüzenet
        }
    }

    private void lekerdezRaktarak() {
        try {
            // raktarak vektor feltöltése
            ResultSet rs = stmt.executeQuery("SELECT * FROM raktarak ;");  //ORDER BY nev
            raktarak.clear();  //régi adatokat eldobja
            System.out.println("__________________Raktárak:__________________________");
            while (rs.next()) {
                //újakkal feltölti
                raktarak.add(new Raktár(rs.getInt("raktarId"),
                        rs.getString("raktarNev"),
                        rs.getString("raktarCim"),
                        rs.getString("raktarTelefonSzam"),
                        rs.getString("raktarEmailCim")));

                System.out.println(rs.getInt("raktarId"));
                System.out.println(rs.getString("raktarNev"));
                System.out.println(rs.getString("raktarCim"));
                System.out.println(rs.getString("raktarTelefonSzam"));
                System.out.println(rs.getString("raktarEmailCim"));
                System.out.println("");

            }//while
        } catch (SQLException se) {
            System.err.println("Raktár lekérdezési hiba!");
            //System.err.println(se.getSQLState()); //hibakód
            System.err.println(se.getMessage()); //sql hibaüzenet
        }
    }

    private void lekerdezVevok() {
        try {
            // raktarak vektor feltöltése
            ResultSet rs = stmt.executeQuery("SELECT * FROM vevok ;");  //ORDER BY nev
            vevok.clear();  //régi adatokat eldobja
            System.out.println("________________________Vevők:_____________________________");
            while (rs.next()) {
                //újakkal feltölti
                vevok.add(new Vevő(rs.getInt("vevoId"),
                        rs.getString("vezetekNev"),
                        rs.getString("keresztNev"),
                        rs.getString("vevoCim"),
                        rs.getString("vevoTelefonSzam"),
                        rs.getString("vevoEmailCim")));

                System.out.println(rs.getInt("vevoId"));
                System.out.println(rs.getString("vezetekNev"));
                System.out.println(rs.getString("keresztNev"));
                System.out.println(rs.getString("vevoCim"));
                System.out.println(rs.getString("vevoTelefonSzam"));
                System.out.println(rs.getString("vevoEmailCim"));

            }//while
        } catch (SQLException se) {
            System.err.println("Vevő lekérdezési hiba!");
            //System.err.println(se.getSQLState()); //hibakód
            System.err.println(se.getMessage()); //sql hibaüzenet
        }
    }

    private void lekerdezBeszallitok() {
        try {
            // raktarak vektor feltöltése
            ResultSet rs = stmt.executeQuery("SELECT * FROM beszallitok ;");  //ORDER BY nev
            beszallitok.clear();  //régi adatokat eldobja
            System.out.println("_____________________Beszállítók:__________________________");
            while (rs.next()) {
                //újakkal feltölti
                beszallitok.add(new Beszállító(rs.getInt("cegId"),
                        rs.getString("cegNev"),
                        rs.getString("telephely"),
                        rs.getString("cegTelefonSzam"),
                        rs.getString("cegEmailCim"),
                        rs.getString("cegAdoszam")));

                System.out.println(rs.getInt("cegId"));
                System.out.println(rs.getString("cegNev"));
                System.out.println(rs.getString("telephely"));
                System.out.println(rs.getString("cegTelefonSzam"));
                System.out.println(rs.getString("cegEmailCim"));
                System.out.println(rs.getString("cegAdoszam"));
                System.out.println("");

            }//while
        } catch (SQLException se) {
            System.err.println("Vevő lekérdezési hiba!");
            //System.err.println(se.getSQLState()); //hibakód
            System.err.println(se.getMessage()); //sql hibaüzenet
        }
    }

    public void ujTermek(Termék termek) {

        try {

            // String sql = "INSERT INTO termekek (cikkszám,megnevezes,ar) "
            //         + "VALUES ('" + termek.getCikkszam() + "','" +termek.getMegnevezes() + "','"+ termek.getAr()+"')";
            // stmt.executeUpdate(sql);
            ptmt = con.prepareStatement("INSERT INTO termekek (cikkszám,megnevezes,ar)VALUES(?,?,?)");
            ptmt.setString(1, termek.getCikkszam());
            ptmt.setString(2, termek.getMegnevezes());
            ptmt.setInt(3, termek.getAr());
            ptmt.executeUpdate();
            termekek.add(termek);
            System.out.println("Termék hozzáadva");

        } catch (SQLException ex) {
            Logger.getLogger(DbKapcsolat.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Hibás adatbevitel!");

        }

    }

    public void ujRaktar(Raktár raktar) {

        try {

            // String sql = "INSERT INTO raktarak (raktarNev,raktarCim,raktarTelefonSzam,raktarEmailCim) "
            //       + "VALUES ('" + raktar.getRaktarNev() + "','" + raktar.getRaktarCim() + "','" + raktar.getRaktarTelefonSzam() + "','" + raktar.getRaktarEmailCim() +"')";
            // stmt.executeUpdate(sql);
            ptmt = con.prepareStatement("INSERT INTO raktarak (raktarNev,raktarCim,raktarTelefonSzam,raktarEmailCim)VALUES(?,?,?,?)");
            ptmt.setString(1, raktar.getRaktarNev());
            ptmt.setString(2, raktar.getRaktarCim());
            ptmt.setString(3, raktar.getRaktarTelefonSzam());
            ptmt.setString(4, raktar.getRaktarEmailCim());
            ptmt.executeUpdate();
            raktarak.add(raktar);
            System.out.println("Raktár hozzáadva");

        } catch (SQLException ex) {
            Logger.getLogger(DbKapcsolat.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Hibás adatbevitel!");
        }

    }

    public void ujVevo(Vevő vevo) {

        try {

            String sql = "INSERT INTO vevok (vezetekNev,keresztNev,vevocim,vevoTelefonSzam,vevoEmailCim) "
                    + "VALUES ('" + vevo.getVezetekNev() + "','" + vevo.getKeresztNev() + "','" + vevo.getVevoCim() + "','" + vevo.getVevoTelefonSzam() + "','" + vevo.getVevoEmailCim() + "')";

            stmt.executeUpdate(sql);
            vevok.add(vevo);
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
            beszallitok.add(beszallito);
            System.out.println("Beszállító hozzáadva");

        } catch (SQLException ex) {
            Logger.getLogger(DbKapcsolat.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Hibás adatbevitel!");
        }

    }
}
