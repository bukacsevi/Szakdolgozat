package adatbáziskapcsolat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
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

        if (con != null) {
            try {
                stmt = con.createStatement();
            } catch (SQLException ex) {
                System.out.println("Hiba a statementel: " + ex);
            }

        }

        //Táblák létrehozása ha még nem létezik
        //Termék Tábla
        try {
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

        lekerdezTermekek();
        lekerdezRaktarak();
        lekerdezVevok();
        lekerdezBeszallitok();

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
            
            String sql = "INSERT INTO termekek (cikkszám,megnevezes,ar) "
                    + "VALUES ('" + termek.getCikkszam() + "','" +termek.getMegnevezes() + "','"+ termek.getAr()+"')";
            
            stmt.executeUpdate(sql);
            
            System.out.println("Termék hozzáadva");
            
        } catch (SQLException ex) {
            Logger.getLogger(DbKapcsolat.class.getName()).log(Level.SEVERE, null, ex);
             JOptionPane.showMessageDialog(null, "Hibás adatbevitel!");
            
        }
       

    }
   
   public void ujRaktar(Raktár raktar) {

        try {
            
            String sql = "INSERT INTO raktarak (raktarNev,raktarCim,raktarTelefonSzam,raktarEmailCim) "
                    + "VALUES ('" + raktar.getRaktarNev() + "','" + raktar.getRaktarCim() + "','" + raktar.getRaktarTelefonSzam() + "','" + raktar.getRaktarEmailCim() +"')";
            
            stmt.executeUpdate(sql);
            
            System.out.println("Raktár hozzáadva");
            
        } catch (SQLException ex) {
            Logger.getLogger(DbKapcsolat.class.getName()).log(Level.SEVERE, null, ex);
             JOptionPane.showMessageDialog(null, "Hibás adatbevitel!");
        }

    }
   
   public void ujVevo(Vevő vevo) {

        try {
            
            String sql = "INSERT INTO vevok (vezetekNev,keresztNev,vevocim,vevoTelefonSzam,vevoEmailCim) "
                    + "VALUES ('" + vevo.getVezetekNev() + "','" + vevo.getKeresztNev() + "','" + vevo.getVevoCim() + "','" + vevo.getVevoTelefonSzam() +"','" + vevo.getVevoEmailCim() +"')";
            
            stmt.executeUpdate(sql);
            
            System.out.println("Vevő hozzáadva");
            
        } catch (SQLException ex) {
            Logger.getLogger(DbKapcsolat.class.getName()).log(Level.SEVERE, null, ex);
             JOptionPane.showMessageDialog(null, "Hibás adatbevitel!");
        }

    }
   
   public void ujBeszallito(Beszállító beszallito) {

        try {
            
            String sql = "INSERT INTO beszallitok (cegNev,telephely,cegTelefonszam,cegEmailCim,cegAdoSzam) "
                    + "VALUES ('" + beszallito.getCegNev() + "','" + beszallito.getTelephely() + "','" + beszallito.getCegTelefonSzam() + "','" + beszallito.getCegEmailCim() +"','" + beszallito.getCegAdoSzam() +"')";
            
            stmt.executeUpdate(sql);
            
            System.out.println("Beszállító hozzáadva");
            
        } catch (SQLException ex) {
            Logger.getLogger(DbKapcsolat.class.getName()).log(Level.SEVERE, null, ex);
             JOptionPane.showMessageDialog(null, "Hibás adatbevitel!");
        }

    }
}
