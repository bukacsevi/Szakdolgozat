package newpackage;

import static java.lang.Math.E;
import static java.lang.StrictMath.E;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @Bukács Éva
 */
public class DbKapcsolat {

    private Vector<Termék> termekek;
    private Vector<Raktár> raktarak;
    private Vector<Vevő> vevok;
    private Vector<Beszállító> beszallitok;
    private Vector<Termék> termekekAdottRaktarban;
    private Vector<Termék> beszallitoTermekei;
    private Vector<Megrendeles> megrendelesek;

    private String database;
    private Connection con;
    private Statement stmt;
    private PreparedStatement ptmt;
    private int DEFAULTID;

    public DbKapcsolat() {
        termekek = new Vector<Termék>();
        raktarak = new Vector<Raktár>();
        vevok = new Vector<Vevő>();
        beszallitok = new Vector<Beszállító>();
        termekekAdottRaktarban = new Vector<Termék>();
        beszallitoTermekei = new Vector<Termék>();
        megrendelesek = new Vector<Megrendeles>();

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

            String sql = "SELECT * FROM beszallitok";
            ResultSet rs = stmt.executeQuery(sql);
            int i = 0;
            while (rs.next()) {
                i++;
            }
            if (i == 0) {
                sql = "INSERT INTO beszallitok (cegNev) "
                        + "VALUES ('DEFAULT')";

                stmt.executeUpdate(sql);
            }
            sql = "SELECT cegId FROM beszallitok WHERE cegNev='DEFAULT' ";

            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                this.DEFAULTID = rs.getInt("cegId");
            }

        } catch (SQLException ex) {
            Logger.getLogger(DbKapcsolat.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("hiba a beszallitok tábla létrehozásánál");
        }

        //Termék Tábla
        try {      //BESZÁLLITOiD és nem kell db
            stmt.execute("CREATE TABLE IF NOT EXISTS termekek("
                    + "termekId  SERIAL NOT NULL PRIMARY KEY,"
                    + "cikkszám text UNIQUE," // legyen unique
                    + "megnevezes text,"
                    + "ar int)");

            System.out.println("tábla termekek létrehozva");

        } catch (SQLException ex) {
            Logger.getLogger(DbKapcsolat.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("hiba a termek tábla létrehozásánál");
        }

        try {      //BESZÁLLITOiD és nem kell db
            stmt.execute("CREATE TABLE IF NOT EXISTS beszallitoTermekei("
                    + "Id SERIAL NOT NULL PRIMARY KEY,"
                    + "cegId int REFERENCES beszallitok(cegId),"
                    + "termekId int REFERENCES termekek(termekId) UNIQUE)");

            System.out.println("beszallitoTermekei tabla létrehozva");

        } catch (SQLException ex) {
            Logger.getLogger(DbKapcsolat.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("hiba a beszallitotermekei tábla létrehozásánál");
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

        //Tranzakciók tábla //legyen dátum
        try {
            stmt.execute("CREATE TABLE IF NOT EXISTS tranzakciok ("
                    + "  tranzakcioId SERIAL NOT NULL PRIMARY KEY,   "
                    + "  raktarId int REFERENCES raktarak(raktarId),"
                    + "  termekId int REFERENCES termekek(termekId),"
                    + "  termekDb int DEFAULT 0"
                    + ")");

            System.out.println("tábla tranzakciok létrehozva");

        } catch (SQLException ex) {
            Logger.getLogger(DbKapcsolat.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("hiba a tranzakciok tábla létrehozásásnál");
        }

        //Atvezetés tábla //legyen dátum
        try {
            stmt.execute("CREATE TABLE IF NOT EXISTS atvezetes ("
                    + "  atvezetesId SERIAL NOT NULL PRIMARY KEY,   "
                    + "  startRaktarId int REFERENCES raktarak(raktarId),"
                    + "  celRaktarId int REFERENCES raktarak(raktarId),"
                    + "  termekId int REFERENCES termekek(termekId),"
                    + "  atvittTermekDb int DEFAULT 0,"
                    + "  datum date "
                    + ")");

            System.out.println("tábla atvezetes létrehozva");

        } catch (SQLException ex) {
            Logger.getLogger(DbKapcsolat.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("hiba az atvezetes tábla létrehozásásnál");
        }

        try {
            stmt.execute("CREATE TABLE IF NOT EXISTS megrendelesek ("
                    + "  feladasiDatum date,"
                    + "  vevoId int REFERENCES vevok(vevoId),"
                    + "  termekId int REFERENCES termekek(termekId),"
                    + "  mennyiseg int,"
                    + "  datum date "
                    + ")");

            System.out.println("tábla megrendelesek létrehozva");

        } catch (SQLException ex) {
            Logger.getLogger(DbKapcsolat.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("hiba az megrendelesek tábla létrehozásásnál");
        }

        termekekVektorFeltolt();
        raktarakVektorFeltolt();
        vevokVektorFeltolt();
        beszallitokVektorFeltolt();

        //lekerdezTranzakcio();
    }

    public Vector<Megrendeles> getMegrendelesek() {
        return megrendelesek;
    }

    public void setMegrendelesek(Vector<Megrendeles> megrendelesek) {
        this.megrendelesek = megrendelesek;
    }

    public Vector<Termék> getTermekek() {
        return this.termekek;
    }

    public Vector<Raktár> getRaktarak() {
        return this.raktarak;
    }

    public ComboBoxModel getRaktarakModel() {
        ComboBoxModel model = null;

        return model;
    }

    public Vector<Vevő> getVevok() {
        return this.vevok;
    }

    public Vector<Beszállító> getBeszallitok() {
        return this.beszallitok;
    }

    public Vector<Termék> getTermekekAdottRaktarban() {
        return termekekAdottRaktarban;
    }

    public Vector<Termék> getBeszallitoTermekei() {
        return beszallitoTermekei;
    }

    public void raktarkoziAtvezetes(int startRaktarId, int celRaktarId, int termekId, int hanyDb) {
        int startRaktarDb = 0;
        int celRaktarDb = 0;
        int startRaktarbanMaradoTermekDb = 0;
        int celRaktarJovebeniTermekDb = 0; //0 kuldendo darabnál ne csináljon semmit, és ne jelenlen meg a sartraktár a célraktárnál
        int letezikEmarAtranzakcio = -1;//ha 0lesz a start raktárban akkor törölje a tranzakciokból a sort
        ResultSet rs;
        LocalDate datum = LocalDate.now();

        try {
            //van e a cél raktárban már az átvezetendő termékből
            rs = stmt.executeQuery("SELECT count(*) letezikE FROM tranzakciok where raktarId=" + celRaktarId + " AND termekId=" + termekId + ";");

            while (rs.next()) {
                letezikEmarAtranzakcio = rs.getInt("letezikE");
                System.out.println(letezikEmarAtranzakcio);
            }

            //mennyi van a kiindulási raktárban a termékből
            rs = stmt.executeQuery("SELECT termekDb FROM tranzakciok WHERE raktarId=" + startRaktarId + " AND termekId=" + termekId + ";");
            while (rs.next()) {
                startRaktarDb = rs.getInt("termekDb");
            }

            //mennyi van cél raktárban a termékből
            rs = stmt.executeQuery("SELECT termekDb FROM tranzakciok WHERE raktarId=" + celRaktarId + " AND termekId=" + termekId + ";");
            while (rs.next()) {
                celRaktarDb = rs.getInt("termekDb");
            }

            startRaktarbanMaradoTermekDb = startRaktarDb - hanyDb;
            celRaktarJovebeniTermekDb = celRaktarDb + hanyDb;

            //tranzakcio módosít ha már van a célraktárban a termékből
            if (startRaktarbanMaradoTermekDb > -1 && letezikEmarAtranzakcio == 1 && hanyDb != 0) {
                ptmt = con.prepareStatement("UPDATE tranzakciok SET termekDb=? WHERE raktarId=" + startRaktarId + " AND termekId=" + termekId + "; ");
                ptmt.setInt(1, startRaktarbanMaradoTermekDb);
                ptmt.executeUpdate();

                ptmt = con.prepareStatement("UPDATE tranzakciok SET termekDb=? WHERE raktarId=" + celRaktarId + " AND termekId=" + termekId + "; ");
                ptmt.setInt(1, celRaktarJovebeniTermekDb);
                ptmt.executeUpdate();

                //atvezetes rögzítése
                ptmt = con.prepareStatement("INSERT INTO atvezetes (startRaktarId,celRaktarId,termekId,atvittTermekDb, datum) VALUES(?,?,?,?,?)");
                ptmt.setInt(1, startRaktarId);
                ptmt.setInt(2, celRaktarId);
                ptmt.setInt(3, termekId);
                ptmt.setInt(4, hanyDb);
                ptmt.setDate(5, Date.valueOf(datum));
                ptmt.executeUpdate();
                if (startRaktarbanMaradoTermekDb == 0) {
                    String sql = "DELETE FROM tranzakciok WHERE raktarId=" + startRaktarId + " AND termekId=" + termekId + ";";
                    stmt.executeUpdate(sql);
                }
                JOptionPane.showMessageDialog(null, "Átvezetés sikeres");
            } //tranzakcio feltölt ha még nincs a célraktárban a termékből
            else if (startRaktarbanMaradoTermekDb > -1 && letezikEmarAtranzakcio == 0 && hanyDb != 0) {
                ptmt = con.prepareStatement("UPDATE tranzakciok SET termekDb=? WHERE raktarId=" + startRaktarId + " AND termekId=" + termekId + "; ");
                ptmt.setInt(1, startRaktarbanMaradoTermekDb);
                ptmt.executeUpdate();

                ptmt = con.prepareStatement("INSERT INTO tranzakciok (raktarId,termekId,termekDb) VALUES(?,?,?)");
                ptmt.setInt(1, celRaktarId);
                ptmt.setInt(2, termekId);
                ptmt.setInt(3, hanyDb);
                ptmt.executeUpdate();

                //atvezetes rögzitese
                ptmt = con.prepareStatement("INSERT INTO atvezetes (startRaktarId,celRaktarId,termekId,atvittTermekDb,datum) VALUES(?,?,?,?,?)");
                ptmt.setInt(1, startRaktarId);
                ptmt.setInt(2, celRaktarId);
                ptmt.setInt(3, termekId);
                ptmt.setInt(4, hanyDb);
                ptmt.setDate(5, Date.valueOf(datum));
                ptmt.executeUpdate();

                if (startRaktarbanMaradoTermekDb == 0) {
                    String sql = "DELETE FROM tranzakciok WHERE raktarId=" + startRaktarId + " AND termekId=" + termekId + ";";
                    stmt.executeUpdate(sql);
                }
                JOptionPane.showMessageDialog(null, "Átvezetés sikeres");
            }

        } catch (SQLException ex) {
            Logger.getLogger(DbKapcsolat.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void bevetelezes(int raktarId, int termekId, int db) {
        int ujTermekDarab = 0;
        int letezikEmarAtranzakcio = -1;
        ResultSet rs;

        //Létezeik e már ez a tranzakció, új termék darab szám számolása//fv-t csinálni belole
        try {
            rs = stmt.executeQuery("SELECT count(*) letezikE FROM tranzakciok where termekId=" + termekId + " AND raktarId=" + raktarId + ";");

            //letezikEmarAtranzakcio==0, ha nem és 1,ha igen//egy termékid raktárid pár csak egyszer szerepelhet
            while (rs.next()) {
                letezikEmarAtranzakcio = rs.getInt("letezikE");
            }

            //a régi darabszám plusz az új darabszám, régit lekérdezi
            rs = stmt.executeQuery("SELECT tranzakciok.termekDb FROM tranzakciok where termekId=" + termekId + " AND raktarId=" + raktarId + ";");
            while (rs.next()) {
                ujTermekDarab = db + rs.getInt("termekDb");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DbKapcsolat.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Nincs ilyen tranzakcio, inzertálja
        if (letezikEmarAtranzakcio == 0) {
            try {
                ptmt = con.prepareStatement("INSERT INTO tranzakciok (raktarId,termekId,termekDb)VALUES(?,?,?);");
                ptmt.setInt(1, raktarId);
                ptmt.setInt(2, termekId);
                ptmt.setInt(3, db);
                ptmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Termék bevételezve");
            } catch (SQLException ex) {
                Logger.getLogger(DbKapcsolat.class.getName()).log(Level.SEVERE, null, ex);
            }
            //Van már ilyen tranzakcio, módosítsa a darabszámot
            //Van már ilyen tranzakcio, módosítsa a darabszámot
        } else if (letezikEmarAtranzakcio != 0) {
            try {
                ptmt = con.prepareStatement("UPDATE tranzakciok SET termekDb=? WHERE  termekId=" + termekId + " AND raktarId=" + raktarId + ";");
                ptmt.setInt(1, ujTermekDarab);
                ptmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Termék bevételezve");
            } catch (SQLException ex) {
                Logger.getLogger(DbKapcsolat.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        //tranzakciók kiírása
        lekerdezTranzakcio();
    }

    public Boolean kivételezés(int raktarId, int termekId, int db) throws Exception {
        int ujTermekDarab = 0;
        int aktualisTermekDarab = 0;
        Boolean sikeres = true;
        ResultSet rs;

        try {
            rs = stmt.executeQuery("SELECT tranzakciok.termekDb FROM tranzakciok WHERE tranzakciok.raktarId=" + raktarId + " AND tranzakciok.termekId=" + termekId + ";");

            while (rs.next()) {
                aktualisTermekDarab = rs.getInt("termekDb");
            }
        } catch (Exception e) {
            System.err.println("hiba");
            return false;
        }

        ujTermekDarab = aktualisTermekDarab - db;

        if (ujTermekDarab < 0) {
            JOptionPane.showMessageDialog(null, "A kivételezendő termék mennyiség túllépi a raktárban lévő termékek számát! ");
            sikeres = false;
        } else {

            ptmt = con.prepareStatement("UPDATE tranzakciok SET termekDb=? WHERE tranzakciok.raktarId= " + raktarId + " AND tranzakciok.termekId=" + termekId + ";");
            ptmt.setInt(1, ujTermekDarab);
            ptmt.executeUpdate();
            if (ujTermekDarab == 0) {
                try {
                    String sql = "DELETE FROM tranzakciok WHERE termekId=" + termekId + " AND raktarId= " + raktarId + ";";
                    stmt.executeUpdate(sql);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Tranzakcio nem törölhető");
                }
            }
            sikeres = true;

        }

        lekerdezTranzakcio();
        return sikeres;
    }

    public String sqlLetrehoz2(int vevoId, String vezeteknev, String keresztnev, String cikkszam) {

        String sql = "SELECT vevok.vezetekNev, vevok.keresztNev, termekek.cikkszám, termekek.megnevezes, megrendelesek.mennyiseg, megrendelesek.datum, megrendelesek.feladasiDatum FROM ((megrendelesek INNER JOIN termekek ON megrendelesek.termekId=termekek.termekId) INNER JOIN  vevok ON megrendelesek.vevoId=vevok.vevoId)";

        String vevoIdSql = "vevok.vevoId=" + "" + vevoId + "";
        String vezetekNevSql = "vevok.vezetekNev=" + "'" + vezeteknev + "'";
        String keresztNevSql = "vevok.keresztNev=" + "'" + keresztnev + "'";
        String cikkszamSql = "termekek.cikkszám=" + "'" + cikkszam + "'";

        String WHERE = " WHERE ";
        String AND = " AND ";

        int mennyi = 0;
        int szamol = 0;

        if (vevoId != 0) {
            mennyi = mennyi + 1;
        }
        if (!vezeteknev.isEmpty()) {
            mennyi = mennyi + 1;
        }
        if (!keresztnev.isEmpty()) {
            mennyi = mennyi + 1;
        }
        if (!cikkszam.isEmpty()) {
            mennyi = mennyi + 1;
        }
        if (mennyi > 0) {
            sql = sql + WHERE;
        } else {
            sql = sql + ";";
        }

        if (vevoId != 0) {
            sql = sql + vevoIdSql;
            szamol = szamol + 1;
            if (mennyi == szamol) {
                sql = sql + ";";
            }
            if (szamol < mennyi) {
                sql = sql + AND;
            }
        }
        if (!(vezeteknev.equals(""))) {
            sql = sql + vezetekNevSql;
            szamol = szamol + 1;
            if (mennyi == szamol) {
                sql = sql + ";";
            }
            if (szamol < mennyi) {
                sql = sql + AND;
            }
        }
        if (!(keresztnev.equals(""))) {
            sql = sql + keresztNevSql;
            szamol = szamol + 1;
            if (mennyi == szamol) {
                sql = sql + ";";
            }
            if (szamol < mennyi) {
                sql = sql + AND;
            }
        }
        if (!(cikkszam.equals(""))) {
            sql = sql + cikkszamSql;
            szamol = szamol + 1;
            if (mennyi == szamol) {
                sql = sql + ";";
            }
            if (szamol < mennyi) {
                sql = sql + AND;
            }
        }
//        System.out.println(sql);

//        try {
//            ResultSet rs = stmt.executeQuery(sql);
//            while (rs.next()) {
//                System.out.println(rs.getString("vezetekNev"));
//            }
//
//        } catch (SQLException ex) {
//            Logger.getLogger(DbKapcsolat.class.getName()).log(Level.SEVERE, null, ex);
//        }

        return sql;
    }

    public String sqlLetrezoz(int raktarId, String termekMegnevezes, String termekCikkszam) {
        String sql = "SELECT raktarak.raktarNev, termekek.cikkszám, termekek.megnevezes, termekek.ar, tranzakciok.termekDb FROM ((tranzakciok INNER JOIN termekek ON tranzakciok.termekId=termekek.termekId) INNER JOIN raktarak ON tranzakciok.raktarId=raktarak.raktarId) ";
        String raktarSql = " tranzakciok.raktarId=" + "" + raktarId + " ";
        String megnevezesSql = " termekek.megnevezes=" + "'" + termekMegnevezes + "' ";
        String cikkszamSql = " termekek.cikkszám=" + "'" + termekCikkszam + "' ";

        String WHERE = " WHERE ";
        String AND = " AND ";
        int mennyi = 0;
        int szamol = 0;

        if (raktarId != 0) {
            mennyi = mennyi + 1;
        }
        if (!(termekMegnevezes.equals(""))) {
            mennyi = mennyi + 1;
        }
        if (!(termekCikkszam.equals(""))) {
            mennyi = mennyi + 1;
        }
        if (mennyi > 0) {
            sql = sql + WHERE;
        } else {
            sql = sql + ";";
        }

        if (raktarId != 0) {
            sql = sql + raktarSql;
            szamol = szamol + 1;
            if (mennyi == szamol) {
                sql = sql + ";";
            }
            if (szamol < mennyi) {
                sql = sql + AND;
            }
        }
        if (!(termekMegnevezes.equals(""))) {
            sql = sql + megnevezesSql;
            szamol = szamol + 1;
            if (mennyi == szamol) {
                sql = sql + ";";
            }
            if (szamol < mennyi) {
                sql = sql + AND;
            }
        }
        if (!(termekCikkszam.equals(""))) {
            sql = sql + cikkszamSql;
            szamol = szamol + 1;
            if (mennyi == szamol) {
                sql = sql + ";";
            }
            if (szamol < mennyi) {
                sql = sql + AND;
            }
        }
        return sql;
        
    }

    public DefaultTableModel MegrendelesLekerdezes(int vevoId, String vezeteknev, String keresztnev, String cikkszam) {

        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("Vezetéknév");
        model.addColumn("Keresztnév");
        model.addColumn("Cikkszám");
        model.addColumn("megnevezés");
        model.addColumn("mennyiség");
        model.addColumn("Megrendelés dátuma");
        model.addColumn("Feladás dátuma");

        try {
            String sql = sqlLetrehoz2(vevoId, vezeteknev, keresztnev, cikkszam);
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {

                model.addRow(new Object[]{rs.getString("vezetekNev"), rs.getString("keresztnev"), rs.getString("cikkszám"), rs.getString("megnevezes"), rs.getInt("mennyiseg"), rs.getDate("datum"), rs.getDate("feladasiDatum")});

            }
        } catch (SQLException se) {
            System.err.println("Megrendeles lekérdezési hiba!");

            System.err.println(se.getMessage());
        }

        return model;
    }

    public DefaultTableModel lekerdezes(int raktarId, String termekMegnevezes, String termekCikkszam) {

        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("Raktár");
        model.addColumn("Cikkszám");
        model.addColumn("Megnevezés");
        model.addColumn("Ár");
        model.addColumn("Mennyiség");

        try {
            String sql = sqlLetrezoz(raktarId, termekMegnevezes, termekCikkszam);
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {

                model.addRow(new Object[]{rs.getString("raktarNev"), rs.getString("cikkszám"), rs.getString("megnevezes"), rs.getInt("ar"), rs.getInt("termekDb")});

            }
        } catch (SQLException se) {
            System.err.println("Tranzakcio lekérdezési hiba!");

            System.err.println(se.getMessage());
        }

        return model;
    }

    public int aktualisRaktarMennyiseg(int raktarId, String termekMegnevezes, String termekCikkszam) {

        int aktualisMennyiseg = 0;

        try {
            String sql = sqlLetrezoz(raktarId, termekMegnevezes, termekCikkszam);
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {

                aktualisMennyiseg = rs.getInt("termekDb");

            }
        } catch (SQLException se) {
            System.err.println("Tranzakcio lekérdezési hiba!");

            System.err.println(se.getMessage());
        }

        return aktualisMennyiseg;
    }

    public DefaultTableModel megrendelesLekerdezes(int vevoId) {

        DefaultTableModel model = new DefaultTableModel() {

            @Override
            public Class<?> getColumnClass(int column) {

                switch (column) {
                    case 0:
                        return String.class;
                    case 1:
                        return String.class;
                    case 2:
                        return Integer.class;
                    case 3:
                        return Integer.class;
                    case 4:
                        return Boolean.class;
                }
                return null;
            }
        };

        model.addColumn("Cikkszám");
        model.addColumn("Megnevezés");
        model.addColumn("Rendelt mennyiség");
        model.addColumn("Raktáron lévő mennyiség");
        model.addColumn("Feladva");

        try {

            ResultSet rs = stmt.executeQuery("SELECT termekek.cikkszám, termekek.megnevezes, megrendelesek.mennyiseg FROM termekek INNER JOIN megrendelesek ON termekek.termekId=megrendelesek.termekId WHERE  feladasiDatum is null AND megrendelesek.vevoId=" + vevoId + "");

            while (rs.next()) {

                model.addRow(new Object[]{rs.getString("cikkszám"), rs.getString("megnevezes"), rs.getInt("mennyiseg"), null, false});

            }
        } catch (SQLException se) {
            System.err.println("Megrendeles lekérdezési hiba!");

            System.err.println(se.getMessage());
        }

        return model;
    }

    public int lekerdezesLeltar(int raktarId, String termekMegnevezes, String termekCikkszam) {

        int darab = 0;

        try {
            String sql = sqlLetrezoz(raktarId, termekMegnevezes, termekCikkszam);
            //ResultSet rs = stmt.executeQuery("SELECT raktarak.raktarNev, termekek.cikkszám, termekek.megnevezes, termekek.ar, tranzakciok.termekDb FROM ((tranzakciok INNER JOIN termekek ON tranzakciok.termekId=termekek.termekId) INNER JOIN raktarak ON tranzakciok.raktarId=raktarak.raktarId) WHERE tranzakciok.raktarId=" + raktarId + " AND termekek.megnevezes='"+termekMegnevezes+"' AND termekek.cikkszám='"+termekCikkszam+"' ;");
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {

                darab = rs.getInt("termekDb");

            }
        } catch (SQLException se) {
            System.err.println("Tranzakcio lekérdezési hiba!");

            System.err.println(se.getMessage());
        }

        return darab;
    }

    public DefaultTableModel eletutLekerdezes(String tolDatum, String igDatum) {
        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("startRaktár");
        model.addColumn("celrakar");
        model.addColumn("termek");
        model.addColumn("db");
        model.addColumn("dátum");

        try {

            ResultSet rs = stmt.executeQuery("SELECT r.raktarNev as b, s.raktarNev as c, termekek.megnevezes, atvezetes.atvittTermekDb, atvezetes.datum "
                    + "FROM (((atvezetes  INNER JOIN raktarak as r ON atvezetes.startRaktarId=r.raktarId)"
                    + "INNER JOIN raktarak as s ON atvezetes.celRaktarId=s.raktarId) "
                    + "INNER JOIN termekek  ON atvezetes.termekId=termekek.termekId) WHERE atvezetes.datum>='" + tolDatum + "' AND atvezetes.datum<='" + igDatum + "'; ");

            System.out.println(rs);
            while (rs.next()) {

                model.addRow(new Object[]{rs.getString("b"), rs.getString("c"), rs.getString("megnevezes"), rs.getInt("atvittTermekDb"), rs.getString("datum")});

            }
        } catch (SQLException se) {
            System.err.println("Tranzakcio lekérdezési hiba!");

            System.err.println(se.getMessage());
        }

        return model;
    }

    public DefaultTableModel eletutLekerdezes(int raktarid, String tolDatum, String igDatum) {
        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("startRaktár");
        model.addColumn("celrakar");
        model.addColumn("termek");
        model.addColumn("db");
        model.addColumn("dátum");

        try {

            ResultSet rs = stmt.executeQuery("SELECT r.raktarNev as b, s.raktarNev as c, termekek.megnevezes, atvezetes.atvittTermekDb, atvezetes.datum "
                    + "FROM (((atvezetes  INNER JOIN raktarak as r ON atvezetes.startRaktarId=r.raktarId)"
                    + "INNER JOIN raktarak as s ON atvezetes.celRaktarId=s.raktarId) "
                    + "INNER JOIN termekek  ON atvezetes.termekId=termekek.termekId) WHERE atvezetes.startRaktarId=" + raktarid + " AND atvezetes.datum>='" + tolDatum + "' AND atvezetes.datum<='" + igDatum + "'; ");

            System.out.println(rs);
            while (rs.next()) {

                model.addRow(new Object[]{rs.getString("b"), rs.getString("c"), rs.getString("megnevezes"), rs.getInt("atvittTermekDb"), rs.getString("datum")});

            }
        } catch (SQLException se) {
            JOptionPane.showMessageDialog(null, "Hiba a lekérdezés során");
        }

        return model;
    }

    private void lekerdezTranzakcio() {
        try {

            ResultSet rs = stmt.executeQuery("SELECT startRaktarId, celRaktarId, termekId, atvittTermekDb FROM atvezetes;");

            while (rs.next()) {

                System.out.println("start:  " + rs.getInt("startRaktarId"));
                System.out.println("cel  :" + rs.getString("celRaktarId"));
                System.out.println("termek :  " + rs.getString("termekId"));
                System.out.println("termek db:  " + rs.getInt("atvittTermekDb"));
                System.out.println("");

            }//while
        } catch (SQLException se) {
            JOptionPane.showMessageDialog(null, "Hiba a lekérdezés során");
        }

    }

    public Termék lekerdezTermek(String cikkszam) { // legyen id alapján lekérdezhető módosítás a fv hívásokban!
        Termék termek = null;
        try {
            ResultSet rs = stmt.executeQuery("SELECT * FROM termekek  WHERE termekek.cikkszám='" + cikkszam + "';");

            while (rs.next()) {
                termek = new Termék(rs.getInt("termekId"),
                        rs.getString("cikkszám"),
                        rs.getString("megnevezes"),
                        rs.getInt("ar"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(DbKapcsolat.class.getName()).log(Level.SEVERE, null, ex);
        }
        return termek;
    }

    public DefaultTableModel lekerdezBeszallitoTermekei(Beszállító beszallito) {
        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("cikkszám");//"SELECT r.raktarNev as b, s.raktarNev as c, termekek.megnevezes, atvezetes.atvittTermekDb "
        //+ "FROM (((atvezetes  INNER JOIN raktarak as r ON atvezetes.startRaktarId=r.raktarId)"
        // + "INNER JOIN raktarak as s ON atvezetes.celRaktarId=s.raktarId) "
        // + "INNER JOIN termekek  ON atvezetes.termekId=termekek.termekId);
        model.addColumn("megnevezés");
        model.addColumn("ár");

        try {
            ResultSet rs = stmt.executeQuery("SELECT termekek.cikkszám, termekek.megnevezes, termekek.ar FROM ((beszallitoTermekei  INNER JOIN termekek ON termekek.termekId=beszallitoTermekei.termekId)INNER JOIN beszallitok ON beszallitok.cegId=beszallitoTermekei.cegId) WHERE beszallitoTermekei.cegId=" + beszallito.getCegId() + ";");

            while (rs.next()) {

                model.addRow(new Object[]{rs.getString("cikkszám"), rs.getString("megnevezes"), rs.getInt("ar")});

            }
        } catch (SQLException ex) {
            Logger.getLogger(DbKapcsolat.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("hiba a lekérdezésnél");
        }

        return model;
    }

    public DefaultTableModel lekerdezBeszallitoTermekeik(Beszállító beszallito) {
        DefaultTableModel model = new DefaultTableModel() {

            @Override
            public Class<?> getColumnClass(int column) {

                switch (column) {
                    case 0:
                        return String.class;
                    case 1:
                        return String.class;
                    case 2:
                        return Integer.class;
                    case 3:
                        return Boolean.class;
                }
                return null;
            }
        };
        model.addColumn("cikkszam");
        model.addColumn("megnevezes");
        model.addColumn("ar");
        model.addColumn("módosítás");

        try {
            ResultSet rs = stmt.executeQuery("SELECT termekek.cikkszám, termekek.megnevezes, termekek.ar FROM ((beszallitoTermekei  INNER JOIN termekek ON termekek.termekId=beszallitoTermekei.termekId)INNER JOIN beszallitok ON beszallitok.cegId=beszallitoTermekei.cegId) WHERE beszallitoTermekei.cegId=" + beszallito.getCegId() + ";");

            while (rs.next()) {

                model.addRow(new Object[]{rs.getString("cikkszám"), rs.getString("megnevezes"), rs.getInt("ar"), false});

            }
        } catch (SQLException ex) {
            Logger.getLogger(DbKapcsolat.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("hiba a lekérdezésnél");
        }

        return model;
    }

    public Raktár lekerdezRaktar(String raktarNev) {
        Raktár raktar = null;
        try {

            ResultSet rs = stmt.executeQuery("SELECT * FROM raktarak WHERE raktarNev='" + raktarNev + "';");

            while (rs.next()) {

                raktar = new Raktár(rs.getInt("raktarId"),
                        rs.getString("raktarNev"),
                        rs.getString("raktarCim"),
                        rs.getString("raktarTelefonSzam"),
                        rs.getString("raktarEmailCim"));

            }
        } catch (SQLException se) {
            System.err.println("Lekérdezési hiba!");
            System.err.println(se.getMessage());
        }
        return raktar;
    }

    public Vevő lekerdezVevo(String email) {
        Vevő vevo = null;
        try {

            ResultSet rs = stmt.executeQuery("SELECT * FROM vevok WHERE vevoEmailCim='" + email + "' ;");

            while (rs.next()) {
                vevo = new Vevő(rs.getInt("vevoId"),
                        rs.getString("vezetekNev"),
                        rs.getString("keresztNev"),
                        rs.getString("vevoCim"),
                        rs.getString("vevoTelefonSzam"),
                        rs.getString("vevoEmailCim"));

            }
        } catch (SQLException se) {
            System.err.println("Lekérdezési hiba!");
            System.err.println(se.getMessage());
        }
        return vevo;
    }

    public Beszállító lekerdezBeszallito(int beszallitoId) {
        Beszállító beszallito = null;
        try {

            ResultSet rs = stmt.executeQuery("SELECT * FROM beszallitok WHERE cegId=" + beszallitoId + " ;");

            while (rs.next()) {
                beszallito = new Beszállító(rs.getInt("cegId"),
                        rs.getString("cegNev"),
                        rs.getString("telephely"),
                        rs.getString("cegTelefonSzam"),
                        rs.getString("cegEmailCim"),
                        rs.getString("cegAdoszam"));

            }
        } catch (SQLException se) {
            System.err.println("Lekérdezési hiba!");
            System.err.println(se.getMessage());
        }
        return beszallito;
    }

    public int lekerdezTermekBeszallitoja(Termék termek) {
        int cegId = 0;
        try {

            //"SELECT termekek.cikkszám, termekek.megnevezes, termekek.ar FROM termekek INNER JOIN beszallitok ON termekek.cegId=beszallitok.cegId WHERE beszallitok.cegId=" + beszallito.getCegId() + ";");
            ResultSet rs = stmt.executeQuery(
                    "SELECT cegId FROM beszallitoTermekei WHERE beszallitoTermekei.termekId=" + termek.getTermekId() + " ;");

            while (rs.next()) {
                cegId = rs.getInt("cegId");

            }
        } catch (SQLException se) {
            System.err.println("Lekérdezési hiba van!");
            System.err.println(se.getMessage());
        }
        return cegId;
    }

    private void ujTermekVektorhozAd(Termék termek) {
        try {
            ResultSet rs = stmt.executeQuery("SELECT * FROM termekek WHERE cikkszám='" + termek.getCikkszam() + "';");

            while (rs.next()) {
                termekek.add(new Termék(rs.getInt("termekId"),
                        rs.getString("cikkszám"),
                        rs.getString("megnevezes"),
                        rs.getInt("ar")));

            }
        } catch (SQLException ex) {
            Logger.getLogger(DbKapcsolat.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void ujRaktarVektorhozAd(Raktár raktar) {
        try {                                                                       //kiegészíteni az adatokkal
            ResultSet rs = stmt.executeQuery("SELECT * FROM raktarak WHERE raktarNev='" + raktar.getRaktarNev() + "';");

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

    private void ujVevoVektorhozAd(Vevő vevo) {
        try {
            ResultSet rs = stmt.executeQuery("SELECT * FROM vevok WHERE vezetekNev='" + vevo.getVezetekNev() + "' AND keresztNev= '" + vevo.getKeresztNev() + "' AND vevoCim='" + vevo.getVevoCim() + "' AND vevoTelefonSzam='" + vevo.getVevoTelefonSzam() + "' AND vevoEmailCim='" + vevo.getVevoEmailCim() + "';");

            while (rs.next()) {
                vevok.add(new Vevő(rs.getInt("vevoId"),
                        rs.getString("vezetekNev"),
                        rs.getString("keresztNev"),
                        rs.getString("vevoCim"),
                        rs.getString("vevoTelefonSzam"),
                        rs.getString("vevoEmailCim")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DbKapcsolat.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void ujBeszallitoVektorhozAd(Beszállító beszallito) {
        try {
            ResultSet rs = stmt.executeQuery("SELECT * FROM beszallitok WHERE cegNev='" + beszallito.getCegNev() + "' AND cegAdoSzam='" + beszallito.getCegAdoSzam() + "' ;");

            while (rs.next()) {
                beszallitok.add(new Beszállító(rs.getInt("cegId"),
                        rs.getString("cegNev"),
                        rs.getString("telephely"),
                        rs.getString("cegTelefonSzam"),
                        rs.getString("cegEmailCim"),
                        rs.getString("cegAdoSzam")));
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
                        rs.getInt("ar")));

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

            ResultSet rs = stmt.executeQuery("SELECT * FROM beszallitok;");
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

    public Boolean ujTermek(Termék termek) throws SQLException {

        ptmt = con.prepareStatement("INSERT INTO termekek (cikkszám,megnevezes,ar)VALUES(?,?,?)");
        ptmt.setString(1, termek.getCikkszam());
        ptmt.setString(2, termek.getMegnevezes());
        ptmt.setInt(3, termek.getAr());
        ptmt.executeUpdate();

        ujTermekVektorhozAd(termek);

        return true;
    }

    public void ujTermekBeszallitohozRendel(Termék termek, Beszállító beszallito) throws SQLException {

        ptmt = con.prepareStatement("INSERT INTO beszallitoTermekei (cegId, termekId)VALUES(?,?)");
        ptmt.setInt(1, beszallito.getCegId());
        ptmt.setInt(2, termek.getTermekId());
        ptmt.executeUpdate();

    }

    public void modositTermek(Termék termek, Beszállító beszallito) {//beszállítót is kell módosítani, termekid alapján legyen keresve ne cikkszám és akkor lehet a cikkszámot módosítani

        try {
            String sql = "UPDATE termekek SET cikkszám='" + termek.getCikkszam() + "',   megnevezes='" + termek.getMegnevezes() + "',  ar=" + termek.getAr() + " WHERE termekId=" + termek.getTermekId() + "; ";

            stmt.executeUpdate(sql);
            termekekVektorFeltolt();

        } catch (SQLException ex) {
            Logger.getLogger(DbKapcsolat.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Hibás adatbevitel! Ellenőrizze létezik e már ilyen cikkszám! ");
            return;

        }
        try {
            String sql = "UPDATE beszallitoTermekei SET cegId=" + beszallito.getCegId() + " WHERE termekId=" + termek.getTermekId() + "; ";

            stmt.executeUpdate(sql);
            termekekVektorFeltolt();
            JOptionPane.showMessageDialog(null, "Termék módosítva!");
        } catch (SQLException ex) {
            Logger.getLogger(DbKapcsolat.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Hibás beszállító adatbevitel!");

        }
    }

    public void modositTermekBeszallito(int termekId, int ujCegId) {

        try {                                                           //cikkszám='"+termek.getCikkszam()+"',
            String sql = "UPDATE beszallitoTermekei SET cegid=" + ujCegId + " WHERE termekId=" + termekId + "; ";

            stmt.executeUpdate(sql);
            termekekVektorFeltolt();
            //JOptionPane.showMessageDialog(null, "Beszállító módosítva!");

        } catch (SQLException ex) {
            Logger.getLogger(DbKapcsolat.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Hibás adatbevitel!");

        }

    }

    public void torolTermekBeszallito(int termekId) {//nem jó igy nincs termekben cegid
        int defaultCegId = 0;
        try {
            ResultSet rs = stmt.executeQuery("SELECT cegId FROM beszallitok WHERE cegNev='DEFAULT';");
            while (rs.next()) {
                defaultCegId = rs.getInt("cegId");
            }

            String sql = "UPDATE beszallitoTermekei SET cegId=" + defaultCegId + " WHERE termekId='" + termekId + "'; ";

            stmt.executeUpdate(sql);
            termekekVektorFeltolt();
            //JOptionPane.showMessageDialog(null, "Beszállító módosítva!");

        } catch (SQLException ex) {
            Logger.getLogger(DbKapcsolat.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Hibás adatbevitel!");

        }

    }

    public void modositRaktar(Raktár raktar) {

        try {                           //
            String sql = "UPDATE raktarak SET raktarNev='" + raktar.getRaktarNev() + "', raktarCim='" + raktar.getRaktarCim() + "', raktarTelefonSzam='" + raktar.getRaktarTelefonSzam() + "', raktaremailcim='" + raktar.getRaktarEmailCim() + "' WHERE raktarId=" + raktar.getRaktarId() + "; ";

            stmt.executeUpdate(sql);
            raktarakVektorFeltolt();
            JOptionPane.showMessageDialog(null, "Raktár módosítva!");

        } catch (SQLException ex) {
            Logger.getLogger(DbKapcsolat.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Hibás adatbevitel!");

        }

    }

    public void modositVevo(Vevő vevo) {

        try {
            String sql = "UPDATE vevok SET vezetekNev='" + vevo.getVezetekNev() + "',keresztNev='" + vevo.getKeresztNev() + "',  vevocim='" + vevo.getVevoCim() + "', vevoEmailCim='" + vevo.getVevoEmailCim() + "', vevoTelefonSzam='" + vevo.getVevoTelefonSzam() + "' WHERE vevoId= " + vevo.getVevoId() + "; ";

            stmt.executeUpdate(sql);
            vevokVektorFeltolt();
            JOptionPane.showMessageDialog(null, "Vásárló módosítva!");

        } catch (SQLException ex) {
            Logger.getLogger(DbKapcsolat.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Hibás adatbevitel!");

        }

    }

    public void modositBeszallito(Beszállító beszallito) {

        if (!beszallito.getCegNev().equals("DEFAULT") && beszallito.getCegId() != this.DEFAULTID) {
            try {
                String sql = "UPDATE beszallitok SET cegNev='" + beszallito.getCegNev() + "',telephely='" + beszallito.getTelephely() + "',  cegtelefonszam='" + beszallito.getCegTelefonSzam() + "', cegemailcim='" + beszallito.getCegEmailCim() + "', cegadoszam='" + beszallito.getCegAdoSzam() + "' WHERE cegid=" + beszallito.getCegId() + "; ";

                stmt.executeUpdate(sql);
                beszallitokVektorFeltolt();
                JOptionPane.showMessageDialog(null, "Beszállító módosítva!");

            } catch (SQLException ex) {
                Logger.getLogger(DbKapcsolat.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Hiba");

            }
        } else {
            JOptionPane.showMessageDialog(null, "Default nevű beszállító létrehozása nem megengedett");
        }

    }

    public void torolTermek(Termék termek, Beszállító beszallito) {//két táblából kell törölni a termékből és a beszallitotermekeibol

        try {
            String sql = "SELECT *  FROM tranzakciok WHERE termekId=" + termek.getTermekId() + "; ";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                JOptionPane.showMessageDialog(null, "Nem lehet törölni a terméket amíg bevételezve van raktárba!");
                return;

            }

            sql = "DELETE  FROM atvezetes WHERE termekId=" + termek.getTermekId() + "; ";

            stmt.executeUpdate(sql);

            sql = "DELETE  FROM beszallitoTermekei WHERE termekId=" + termek.getTermekId() + "; ";

            stmt.executeUpdate(sql);

            sql = "DELETE  FROM termekek WHERE termekId='" + termek.getTermekId() + "'; ";

            stmt.executeUpdate(sql);

            termekekVektorFeltolt();

            JOptionPane.showMessageDialog(null, "Termék törölve!");

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Nem lehet törölni a terméket amíg bevételezve van raktárba!!");

        }

    }

    public void torolBeszallito(Beszállító beszallito) throws SQLException {

        if (beszallito.getCegId() != this.DEFAULTID) {

            String sql = "DELETE FROM beszallitok WHERE cegid=" + beszallito.getCegId() + "; ";

            stmt.executeUpdate(sql);
            beszallitokVektorFeltolt();

            JOptionPane.showMessageDialog(null, "Beszállító törölve!");

        } else {
            JOptionPane.showMessageDialog(null, "Beszállító nem törölhető!");
        }
    }

    public void torolVevo(Vevő vevo) {

        try {
            String sql = "DELETE FROM vevok WHERE vevoEmailCim='" + vevo.getVevoEmailCim() + "'; ";

            stmt.executeUpdate(sql);
            vevokVektorFeltolt();

            JOptionPane.showMessageDialog(null, "Vásárló törölve!");

        } catch (SQLException ex) {
            Logger.getLogger(DbKapcsolat.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Hibás adatbevitel!");

        }

    }

    public void torolRaktar(Raktár raktar) {

        try {
            String sql = "DELETE FROM raktarak WHERE raktarId=" + raktar.getRaktarId() + "; ";

            stmt.executeUpdate(sql);
            raktarakVektorFeltolt();

            JOptionPane.showMessageDialog(null, "Raktár törölve!");

        } catch (SQLException ex) {
            Logger.getLogger(DbKapcsolat.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Nem lehet törölni a raktárat amíg termékek vannak hozzárendelve!");

        }

    }

    public void ujRaktar(Raktár raktar) throws SQLException {

        ptmt = con.prepareStatement("INSERT INTO raktarak (raktarNev,raktarCim,raktarTelefonSzam,raktarEmailCim)VALUES(?,?,?,?)");
        ptmt.setString(1, raktar.getRaktarNev());
        ptmt.setString(2, raktar.getRaktarCim());
        ptmt.setString(3, raktar.getRaktarTelefonSzam());
        ptmt.setString(4, raktar.getRaktarEmailCim());
        ptmt.executeUpdate();

        ujRaktarVektorhozAd(raktar);

    }

    public void ujVevo(Vevő vevo) throws SQLException {  //nem jó ptmt kell

        String sql = "INSERT INTO vevok (vezetekNev,keresztNev,vevocim,vevoTelefonSzam,vevoEmailCim) "
                + "VALUES ('" + vevo.getVezetekNev() + "','" + vevo.getKeresztNev() + "','" + vevo.getVevoCim() + "','" + vevo.getVevoTelefonSzam() + "','" + vevo.getVevoEmailCim() + "')";

        stmt.executeUpdate(sql);
        ujVevoVektorhozAd(vevo);

    }

    public void megrendelesekVektorFeltolt() {
        try {

            ResultSet rs = stmt.executeQuery("SELECT * FROM megrendelesek WHERE feladasiDatum is null;");
            megrendelesek.clear();

            while (rs.next()) {
                megrendelesek.add(new Megrendeles(
                        rs.getInt("vevoId"),
                        rs.getInt("termekId"),
                        rs.getInt("mennyiseg"),
                        rs.getDate("datum")));
            }
        } catch (SQLException se) {
            System.err.println("Megrendeles lekérdezési hiba!");
            System.err.println(se.getMessage());
        }

    }

    public void ujMegrendeles(Vevő vevo, Vector<Termék> rendeltTermekek) throws SQLException {
        LocalDate datum = LocalDate.now();
        Boolean letezoMegrendeles = false;
        int korabbiMennyiseg = 0;

        for (int i = 0; i < rendeltTermekek.size(); i++) {

            Termék termek = rendeltTermekek.get(i);

            ResultSet rs = stmt.executeQuery("SELECT mennyiseg FROM megrendelesek WHERE vevoId=" + vevo.getVevoId() + " AND termekId=" + termek.getTermekId() + " AND feladasiDatum is null");
            while (rs.next()) {
                letezoMegrendeles = true;
                System.out.println(letezoMegrendeles);
                korabbiMennyiseg = rs.getInt("mennyiseg");
                
            }

            if (letezoMegrendeles) {

                ptmt = con.prepareStatement("UPDATE megrendelesek SET mennyiseg=? WHERE vevoId=" + vevo.getVevoId() + " AND termekId=" + termek.getTermekId() + "");
                ptmt.setInt(1, termek.getRendeltMennyiseg() + korabbiMennyiseg);
                ptmt.executeUpdate();
                

            } else {
                
                ptmt = con.prepareStatement("INSERT INTO megrendelesek (vevoId, termekId, mennyiseg, datum)VALUES(?,?,?,?)");
                ptmt.setInt(1, vevo.getVevoId());
                ptmt.setInt(2, termek.getTermekId());
                ptmt.setInt(3, termek.getRendeltMennyiseg());
                ptmt.setDate(4, Date.valueOf(datum));
                ptmt.executeUpdate();
//            String sql = "INSERT INTO megrendelesek (vevoId, termekId, mennyiseg, datum) "
//                    + "VALUES (" + vevo.getVevoId() + "," + termek.getTermekId() + "," + termek.getRendeltMennyiseg() + ",)";
//
//            stmt.executeUpdate(sql);
            }
            letezoMegrendeles = false;
        }
        
    }

    public Boolean megrendelesFeladva(int vevoId, int termekId, int raktarId, int rendeltMennyiseg) throws SQLException, Exception {
        LocalDate datum = LocalDate.now();
        Boolean kivetelezesSikeres=false;
        try {
            kivetelezesSikeres = this.kivételezés(raktarId, termekId, rendeltMennyiseg);            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Feladás sikertelen");
        }
        if (kivetelezesSikeres) {
            ptmt = con.prepareStatement("UPDATE megrendelesek SET feladasiDatum=? WHERE vevoId=" + vevoId + " AND termekId=" + termekId + "");
            ptmt.setDate(1, Date.valueOf(datum));
            ptmt.executeUpdate();
            
        }
        return kivetelezesSikeres;
    }

    public void ujBeszallito(Beszállító beszallito) throws SQLException {

        if (!beszallito.getCegNev().equals("DEFAULT")) {

            String sql = "INSERT INTO beszallitok (cegNev,telephely,cegTelefonszam,cegEmailCim,cegAdoSzam) "
                    + "VALUES ('" + beszallito.getCegNev() + "','" + beszallito.getTelephely() + "','" + beszallito.getCegTelefonSzam() + "','" + beszallito.getCegEmailCim() + "','" + beszallito.getCegAdoSzam() + "')";

            stmt.executeUpdate(sql);
            ujBeszallitoVektorhozAd(beszallito);

        } else {
            JOptionPane.showMessageDialog(null, "Default nevű beszállító létrehozása nem megengedett");
        }
    }

    public void raktarTermekLista(int raktarId) {
        try {

            ResultSet rs = stmt.executeQuery("SELECT termekek.termekId, termekek.cikkszám,termekek.megnevezes,termekek.ar FROM termekek INNER JOIN tranzakciok ON tranzakciok.termekId=termekek.termekId AND tranzakciok.raktarId=" + raktarId + " AND tranzakciok.termekDb>0 ;");
            termekekAdottRaktarban.clear();

            while (rs.next()) {
                termekekAdottRaktarban.add(new Termék(rs.getInt("termekId"),
                        rs.getString("cikkszám"),
                        rs.getString("megnevezes"),
                        rs.getInt("ar")));

            }
        } catch (SQLException se) {
            System.err.println("Lekérdezési hiba!");
            System.err.println(se.getMessage());
        }
    }

    public void beszallitoTermekeiVektorfeltolt(int cegId) {
        try {

            ResultSet rs = stmt.executeQuery("SELECT termekek.termekId, termekek.cikkszám,termekek.megnevezes,termekek.ar FROM termekek INNER JOIN beszallitoTermekei ON beszallitoTermekei.termekId=termekek.termekId AND beszallitoTermekei.cegId=" + cegId + ";");
            beszallitoTermekei.clear();

            while (rs.next()) {
                beszallitoTermekei.add(new Termék(rs.getInt("termekId"),
                        rs.getString("cikkszám"),
                        rs.getString("megnevezes"),
                        rs.getInt("ar")));

            }
        } catch (SQLException se) {
            System.err.println("Lekérdezési hiba!");
            System.err.println(se.getMessage());
        }
    }

    public int aktualisTermekMennyisegRaktarban(Raktár raktar, Termék termek) {
        int raktarId = raktar.getRaktarId();
        int termekId = termek.getTermekId();
        int termekDb = 0;

        try {
            ResultSet rs = stmt.executeQuery("SELECT tranzakciok.termekDb FROM tranzakciok WHERE tranzakciok.termekId=" + termekId + " AND tranzakciok.raktarId=" + raktarId + " ;");

            while (rs.next()) {
                termekDb = rs.getInt("termekDb");
            }

        } catch (SQLException ex) {
            Logger.getLogger(DbKapcsolat.class.getName()).log(Level.SEVERE, null, ex);
        }
        return termekDb;
    }

    public DbKapcsolat adatokTorlese() {
        try {
            stmt = con.createStatement();
            String sql = "DROP TABLE  beszallitoTermekei,atvezetes,tranzakciok, termekek,beszallitok,vevok,raktarak,megrendelesek;";
            stmt.executeUpdate(sql);

        } catch (Exception e) {
            System.out.println(e);
        }
        DbKapcsolat db = new DbKapcsolat();
        return db;
    }

    public void tesztAdatokBetoltese() {

    }
}
