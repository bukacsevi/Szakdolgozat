
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.metal.DefaultMetalTheme;
import javax.swing.plaf.metal.MetalLookAndFeel;
import newpackage.Beszállító;
import newpackage.DbKapcsolat;
import newpackage.Raktár;
import newpackage.Termék;
import newpackage.Vevő;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author kicsi
 */
public class frame extends javax.swing.JFrame {

    static DbKapcsolat db;
    static JPanel panel;

    public frame() {

        initComponents();

        

        this.setTitle("Készletnyilvántartó");
        db = new DbKapcsolat();
        parentPanel.setLayout(new BorderLayout());
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        panel = this.parentPanel;

        //this.setResizable(false);
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        parentPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        leltarGomb = new javax.swing.JButton();
        arajanlatGomb = new javax.swing.JButton();
        rendelesFeladGomb = new javax.swing.JButton();
        bevetelKivetGomb = new javax.swing.JButton();
        atvezetGomb = new javax.swing.JButton();
        lekerdezesekGomb = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        tesztAdatokBetoltese = new javax.swing.JMenu();
        adatokTorleseMenu = new javax.swing.JMenuItem();
        adatokTorlese = new javax.swing.JMenuItem();
        menu = new javax.swing.JMenu();
        leltarMenu = new javax.swing.JMenu();
        megrendelesOsszekeszitesMenu = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 255));

        jPanel2.setBackground(new java.awt.Color(0, 140, 113));

        parentPanel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout parentPanelLayout = new javax.swing.GroupLayout(parentPanel);
        parentPanel.setLayout(parentPanelLayout);
        parentPanelLayout.setHorizontalGroup(
            parentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1085, Short.MAX_VALUE)
        );
        parentPanelLayout.setVerticalGroup(
            parentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel1.setBackground(new java.awt.Color(0, 140, 113));

        leltarGomb.setBackground(new java.awt.Color(0, 140, 113));
        leltarGomb.setFont(new java.awt.Font("Arial Narrow", 0, 16)); // NOI18N
        leltarGomb.setForeground(new java.awt.Color(255, 255, 255));
        leltarGomb.setText("Leltár Készítés");
        leltarGomb.setToolTipText("");
        leltarGomb.setBorder(null);
        leltarGomb.setBorderPainted(false);
        leltarGomb.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        leltarGomb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leltarGombActionPerformed(evt);
            }
        });

        arajanlatGomb.setBackground(new java.awt.Color(0, 140, 113));
        arajanlatGomb.setFont(new java.awt.Font("Arial Narrow", 0, 16)); // NOI18N
        arajanlatGomb.setForeground(new java.awt.Color(255, 255, 255));
        arajanlatGomb.setText("Árajánlat/Megrendelés");
        arajanlatGomb.setToolTipText("");
        arajanlatGomb.setBorder(null);
        arajanlatGomb.setBorderPainted(false);
        arajanlatGomb.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        arajanlatGomb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                arajanlatGombActionPerformed(evt);
            }
        });

        rendelesFeladGomb.setBackground(new java.awt.Color(0, 140, 113));
        rendelesFeladGomb.setFont(new java.awt.Font("Arial Narrow", 0, 16)); // NOI18N
        rendelesFeladGomb.setForeground(new java.awt.Color(255, 255, 255));
        rendelesFeladGomb.setText("Rendelés Feladás");
        rendelesFeladGomb.setToolTipText("");
        rendelesFeladGomb.setBorder(null);
        rendelesFeladGomb.setBorderPainted(false);
        rendelesFeladGomb.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        rendelesFeladGomb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rendelesFeladGombActionPerformed(evt);
            }
        });

        bevetelKivetGomb.setBackground(new java.awt.Color(0, 140, 113));
        bevetelKivetGomb.setFont(new java.awt.Font("Arial Narrow", 0, 16)); // NOI18N
        bevetelKivetGomb.setForeground(new java.awt.Color(255, 255, 255));
        bevetelKivetGomb.setText("Bevételezés/Kivételezés");
        bevetelKivetGomb.setToolTipText("");
        bevetelKivetGomb.setBorder(null);
        bevetelKivetGomb.setBorderPainted(false);
        bevetelKivetGomb.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        bevetelKivetGomb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bevetelKivetGombActionPerformed(evt);
            }
        });

        atvezetGomb.setBackground(new java.awt.Color(0, 140, 113));
        atvezetGomb.setFont(new java.awt.Font("Arial Narrow", 0, 16)); // NOI18N
        atvezetGomb.setForeground(new java.awt.Color(255, 255, 255));
        atvezetGomb.setText("Raktárközi Átvezetés");
        atvezetGomb.setToolTipText("");
        atvezetGomb.setBorder(null);
        atvezetGomb.setBorderPainted(false);
        atvezetGomb.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        atvezetGomb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atvezetGombActionPerformed(evt);
            }
        });

        lekerdezesekGomb.setBackground(new java.awt.Color(0, 140, 113));
        lekerdezesekGomb.setFont(new java.awt.Font("Arial Narrow", 0, 16)); // NOI18N
        lekerdezesekGomb.setForeground(new java.awt.Color(255, 255, 255));
        lekerdezesekGomb.setText("Lekérdezések");
        lekerdezesekGomb.setToolTipText("");
        lekerdezesekGomb.setBorder(null);
        lekerdezesekGomb.setBorderPainted(false);
        lekerdezesekGomb.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lekerdezesekGomb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lekerdezesekGombActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(arajanlatGomb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(leltarGomb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bevetelKivetGomb, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                    .addComponent(rendelesFeladGomb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(atvezetGomb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lekerdezesekGomb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(bevetelKivetGomb, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(atvezetGomb, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lekerdezesekGomb, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69)
                .addComponent(arajanlatGomb, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(rendelesFeladGomb, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(leltarGomb, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(315, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(parentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(parentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jMenuBar1.setBackground(new java.awt.Color(102, 102, 102));
        jMenuBar1.setBorder(null);
        jMenuBar1.setForeground(new java.awt.Color(255, 153, 51));
        jMenuBar1.setAlignmentX(2.0F);
        jMenuBar1.setFont(new java.awt.Font("Arial Narrow", 0, 12)); // NOI18N

        tesztAdatokBetoltese.setBackground(new java.awt.Color(255, 140, 0));
        tesztAdatokBetoltese.setForeground(new java.awt.Color(255, 140, 0));
        tesztAdatokBetoltese.setText("Fájl   ");
        tesztAdatokBetoltese.setFont(new java.awt.Font("Sylfaen", 3, 18)); // NOI18N
        tesztAdatokBetoltese.setPreferredSize(new java.awt.Dimension(60, 21));

        adatokTorleseMenu.setText("Teszadatok betöltése");
        adatokTorleseMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tesztAdatokBetoltese(evt);
            }
        });
        tesztAdatokBetoltese.add(adatokTorleseMenu);

        adatokTorlese.setText("Minden adat törlése");
        adatokTorlese.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adatokTorleseActionPerformed(evt);
            }
        });
        tesztAdatokBetoltese.add(adatokTorlese);

        jMenuBar1.add(tesztAdatokBetoltese);

        menu.setBackground(new java.awt.Color(255, 140, 0));
        menu.setForeground(new java.awt.Color(255, 140, 0));
        menu.setText("Termék ");
        menu.setFont(new java.awt.Font("Sylfaen", 3, 18)); // NOI18N
        menu.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        menu.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        menu.setPreferredSize(new java.awt.Dimension(100, 40));
        menu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuMouseClicked(evt);
            }
        });
        menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuActionPerformed(evt);
            }
        });
        jMenuBar1.add(menu);

        leltarMenu.setBackground(new java.awt.Color(255, 140, 0));
        leltarMenu.setForeground(new java.awt.Color(255, 140, 0));
        leltarMenu.setText("Raktár");
        leltarMenu.setFont(new java.awt.Font("Sylfaen", 3, 18)); // NOI18N
        leltarMenu.setPreferredSize(new java.awt.Dimension(100, 40));
        leltarMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                leltarMenuMouseClicked(evt);
            }
        });
        leltarMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leltarMenuActionPerformed(evt);
            }
        });
        jMenuBar1.add(leltarMenu);

        megrendelesOsszekeszitesMenu.setBackground(new java.awt.Color(255, 140, 0));
        megrendelesOsszekeszitesMenu.setForeground(new java.awt.Color(255, 140, 0));
        megrendelesOsszekeszitesMenu.setText("Vásárló");
        megrendelesOsszekeszitesMenu.setFont(new java.awt.Font("Sylfaen", 3, 18)); // NOI18N
        megrendelesOsszekeszitesMenu.setPreferredSize(new java.awt.Dimension(100, 40));
        megrendelesOsszekeszitesMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                megrendelesOsszekeszitesMenuMouseClicked(evt);
            }
        });
        megrendelesOsszekeszitesMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                megrendelesOsszekeszitesMenuActionPerformed(evt);
            }
        });
        jMenuBar1.add(megrendelesOsszekeszitesMenu);

        jMenu1.setBackground(new java.awt.Color(255, 153, 51));
        jMenu1.setForeground(new java.awt.Color(255, 140, 0));
        jMenu1.setText("Beszállító");
        jMenu1.setToolTipText("");
        jMenu1.setFont(new java.awt.Font("Sylfaen", 3, 18)); // NOI18N
        jMenu1.setPreferredSize(new java.awt.Dimension(100, 40));
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 167, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    static DbKapcsolat getDbKapcsolat() {
        return frame.db;
    }

    private void leltarGombActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leltarGombActionPerformed
//        parentPanel.removeAll();
//        RaktarHozzaad raktarHozzaadPanel = new RaktarHozzaad();
//        raktarHozzaadPanel.getRaktarListaComboBox().setModel(new DefaultComboBoxModel(db.getRaktarak()));
//        parentPanel.add(raktarHozzaadPanel);
//
//        parentPanel.revalidate();
//        parentPanel.repaint();

        Leltar leltar = new Leltar(this, true);
        leltar.setVisible(true);
    }//GEN-LAST:event_leltarGombActionPerformed

    private void menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuActionPerformed

    }//GEN-LAST:event_menuActionPerformed

    private void menuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuMouseClicked
//        Dokumentum doku = new Dokumentum(this, true);
//        doku.setVisible(true);

        parentPanel.removeAll();
        TermekHozzaad termekHozzaadPanel = new TermekHozzaad();
        termekHozzaadPanel.getBeszallitoComboBox().setModel(new DefaultComboBoxModel(db.getBeszallitok()));
        parentPanel.add(termekHozzaadPanel);

        parentPanel.revalidate();
        parentPanel.repaint();

    }//GEN-LAST:event_menuMouseClicked

    private void leltarMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leltarMenuActionPerformed

    }//GEN-LAST:event_leltarMenuActionPerformed

    private void leltarMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_leltarMenuMouseClicked
//        Leltar leltar = new Leltar(this, true);
//        leltar.setVisible(true);

        parentPanel.removeAll();
        RaktarHozzaad raktarHozzaadPanel = new RaktarHozzaad();
        raktarHozzaadPanel.getRaktarListaComboBox().setModel(new DefaultComboBoxModel(db.getRaktarak()));
        parentPanel.add(raktarHozzaadPanel);

        parentPanel.revalidate();
        parentPanel.repaint();
    }//GEN-LAST:event_leltarMenuMouseClicked

    private void adatokTorleseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adatokTorleseActionPerformed
        db = db.adatokTorlese();
        parentPanel.removeAll();

        parentPanel.revalidate();
        parentPanel.repaint();
    }//GEN-LAST:event_adatokTorleseActionPerformed

    private void tesztAdatokBetoltese(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tesztAdatokBetoltese
        adatokTorleseActionPerformed(evt);
        try {
            Beszállító beszallito1 = new Beszállító("Hajdútej Tejipari Rt.", "Budapest", "+36201234567", "goo.supp.goo@gmail.com", "12345678-9-10");
            Beszállító beszallito2 = new Beszállító("Győri Szeszgyár és Finomító Rt.", "Győr", "+36201234567", "goo.supp.goo@gmail.com", "12345678-9-10");
            Beszállító beszallito3 = new Beszállító("Délhús Rt.", "Pécs", "+36201234567", "goo.supp.goo@gmail.com", "12345678-9-10");
            Beszállító beszallito4 = new Beszállító("Karamell Sütő- és Édesipari Rt.", "Pécs", "+36201234567", "goo.supp.goo@gmail.com", "12345678-9-10");

            db.ujBeszallito(beszallito1);
            db.ujBeszallito(beszallito2);
            db.ujBeszallito(beszallito3);
            db.ujBeszallito(beszallito4);

            Termék termek = new Termék("1258", "Nádudvari félzsíros túró 250g", 399);
            Termék termek1 = new Termék("1259", "Pilos kefír 125g", 79);
            Termék termek2 = new Termék("1260", "Danon epres joghurt 125g", 249);
            Termék termek3 = new Termék("1261", "Danon málnás joghurt 125g", 249);
            Termék termek4 = new Termék("1262", "Tolle tej 1,5%", 219);

            Termék termek5 = new Termék("1263", "Jagermeister keserűlikőr 0,7l", 4999);
            Termék termek6 = new Termék("1264", "Unicum 0,7l", 6290);
            Termék termek7 = new Termék("1265", "Johnnie Walker Red Label Whisky 0,7l", 4790);
            Termék termek8 = new Termék("1266", "Staropamen Világos sör 5% 500ml", 269);
            Termék termek19 = new Termék("1277", "Borsodi Világos sör 5% 500ml", 199);

            Termék termek9 = new Termék("1267", "Pick Zala felvágott 500g", 699);
            Termék termek10 = new Termék("1268", "Bécsi virsli 1kg", 1499);
            Termék termek11 = new Termék("1269", "Pick téliszalámi 150g", 399);
            Termék termek12 = new Termék("1270", "Gyulai sertés májas 200g", 299);
            Termék termek13 = new Termék("1271", "Pikok pulykamell sonka 150g", 499);

            Termék termek14 = new Termék("1272", "Dr.Oetker sütőpor 10db", 359);
            Termék termek15 = new Termék("1273", "Dr.Oetker instant élesztő 10db", 359);
            Termék termek16 = new Termék("1274", "Búza finom liszt 1kg", 9999);
            Termék termek17 = new Termék("1275", "Zabkorpa 500g", 599);
            Termék termek18 = new Termék("1276", "Búzadara 1kg", 299);

            db.ujTermek(termek);
            Termék termekAdatbazisbol = db.lekerdezTermek(termek.getCikkszam());
            db.ujTermekBeszallitohozRendel(termekAdatbazisbol, (Beszállító) db.getBeszallitok().get(1));
            db.ujTermek(termek1);
            termekAdatbazisbol = db.lekerdezTermek(termek1.getCikkszam());
            db.ujTermekBeszallitohozRendel(termekAdatbazisbol, db.getBeszallitok().get(1));
            db.ujTermek(termek2);
            termekAdatbazisbol = db.lekerdezTermek(termek2.getCikkszam());
            db.ujTermekBeszallitohozRendel(termekAdatbazisbol, db.getBeszallitok().get(1));
            db.ujTermek(termek3);
            termekAdatbazisbol = db.lekerdezTermek(termek3.getCikkszam());
            db.ujTermekBeszallitohozRendel(termekAdatbazisbol, db.getBeszallitok().get(1));
            db.ujTermek(termek4);
            termekAdatbazisbol = db.lekerdezTermek(termek4.getCikkszam());
            db.ujTermekBeszallitohozRendel(termekAdatbazisbol, db.getBeszallitok().get(1));

            db.ujTermek(termek5);
            termekAdatbazisbol = db.lekerdezTermek(termek5.getCikkszam());
            db.ujTermekBeszallitohozRendel(termekAdatbazisbol, (Beszállító) db.getBeszallitok().get(2));
            db.ujTermek(termek6);
            termekAdatbazisbol = db.lekerdezTermek(termek6.getCikkszam());
            db.ujTermekBeszallitohozRendel(termekAdatbazisbol, db.getBeszallitok().get(2));
            db.ujTermek(termek7);
            termekAdatbazisbol = db.lekerdezTermek(termek7.getCikkszam());
            db.ujTermekBeszallitohozRendel(termekAdatbazisbol, db.getBeszallitok().get(2));
            db.ujTermek(termek8);
            termekAdatbazisbol = db.lekerdezTermek(termek8.getCikkszam());
            db.ujTermekBeszallitohozRendel(termekAdatbazisbol, db.getBeszallitok().get(2));
            db.ujTermek(termek19);
            termekAdatbazisbol = db.lekerdezTermek(termek19.getCikkszam());
            db.ujTermekBeszallitohozRendel(termekAdatbazisbol, db.getBeszallitok().get(2));

            db.ujTermek(termek9);
            termekAdatbazisbol = db.lekerdezTermek(termek9.getCikkszam());
            db.ujTermekBeszallitohozRendel(termekAdatbazisbol, (Beszállító) db.getBeszallitok().get(3));
            db.ujTermek(termek10);
            termekAdatbazisbol = db.lekerdezTermek(termek10.getCikkszam());
            db.ujTermekBeszallitohozRendel(termekAdatbazisbol, db.getBeszallitok().get(3));
            db.ujTermek(termek11);
            termekAdatbazisbol = db.lekerdezTermek(termek11.getCikkszam());
            db.ujTermekBeszallitohozRendel(termekAdatbazisbol, db.getBeszallitok().get(3));
            db.ujTermek(termek12);
            termekAdatbazisbol = db.lekerdezTermek(termek12.getCikkszam());
            db.ujTermekBeszallitohozRendel(termekAdatbazisbol, db.getBeszallitok().get(3));
            db.ujTermek(termek13);
            termekAdatbazisbol = db.lekerdezTermek(termek13.getCikkszam());
            db.ujTermekBeszallitohozRendel(termekAdatbazisbol, db.getBeszallitok().get(3));

            db.ujTermek(termek14);
            termekAdatbazisbol = db.lekerdezTermek(termek14.getCikkszam());
            db.ujTermekBeszallitohozRendel(termekAdatbazisbol, (Beszállító) db.getBeszallitok().get(4));
            db.ujTermek(termek15);
            termekAdatbazisbol = db.lekerdezTermek(termek15.getCikkszam());
            db.ujTermekBeszallitohozRendel(termekAdatbazisbol, db.getBeszallitok().get(4));
            db.ujTermek(termek16);
            termekAdatbazisbol = db.lekerdezTermek(termek16.getCikkszam());
            db.ujTermekBeszallitohozRendel(termekAdatbazisbol, db.getBeszallitok().get(4));
            db.ujTermek(termek17);
            termekAdatbazisbol = db.lekerdezTermek(termek17.getCikkszam());
            db.ujTermekBeszallitohozRendel(termekAdatbazisbol, db.getBeszallitok().get(4));
            db.ujTermek(termek18);
            termekAdatbazisbol = db.lekerdezTermek(termek18.getCikkszam());
            db.ujTermekBeszallitohozRendel(termekAdatbazisbol, db.getBeszallitok().get(4));

            Vevő vevo1 = new Vevő("Bukács", "Éva", "1203 Budapest, Sárrét utca 8/a", "+36704433818", "bukacsevi@gmail.com");
            Vevő vevo2 = new Vevő("Oláh", "Attila", "1203 Budapest, Sárrét utca 8/a", "+36704433818", "bukacsevi@gmail.com");
            Vevő vevo3 = new Vevő("Oláh", "Dóra", "1203 Budapest, Sárrét utca 8/a", "+36704433818", "bukacsevi@gmail.com");
            Vevő vevo4 = new Vevő("Zatykó", "Bernadett", "1223 Budapest, Tököly utca 25", "+36704589966", "bukacsevi@gmail.com");

            db.ujVevo(vevo1);
            db.ujVevo(vevo2);
            db.ujVevo(vevo3);
            db.ujVevo(vevo4);

            Raktár raktar1 = new Raktár("Budapesti Raktár", "Budapest", "+36201234567", "valami@gmail.com");
            Raktár raktar2 = new Raktár("Győri Raktár", "Győr", "+36205984567", "val@gmail.com");
            Raktár raktar3 = new Raktár("Pécsi Raktár", "Pécs", "+36208964567", "vaami@gmail.com");
            Raktár raktar4 = new Raktár("Szegedi Raktár", "Szeged", "+36201238867", "valai@gmail.com");

            db.ujRaktar(raktar1);
            db.ujRaktar(raktar2);
            db.ujRaktar(raktar3);
            db.ujRaktar(raktar4);

        } catch (Exception ex) {
            Logger.getLogger(DbKapcsolat.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_tesztAdatokBetoltese

    private void megrendelesOsszekeszitesMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_megrendelesOsszekeszitesMenuActionPerformed

    }//GEN-LAST:event_megrendelesOsszekeszitesMenuActionPerformed

    private void megrendelesOsszekeszitesMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_megrendelesOsszekeszitesMenuMouseClicked
//        MegrendelesOsszekeszites keszit = new MegrendelesOsszekeszites(this, true);
//        keszit.setVisible(true);

        parentPanel.removeAll();
        VevoHozzaad vevoHozzaadPanel = new VevoHozzaad();
        vevoHozzaadPanel.getVevoListaComboBox().setModel(new DefaultComboBoxModel(db.getVevok()));
        parentPanel.add(vevoHozzaadPanel);

        parentPanel.revalidate();
        parentPanel.repaint();
    }//GEN-LAST:event_megrendelesOsszekeszitesMenuMouseClicked

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        parentPanel.removeAll();
        BeszallitoHozzaad beszallitoAdatmodositasPanel = new BeszallitoHozzaad();
        beszallitoAdatmodositasPanel.getBeszallitoComboBox().setModel(new DefaultComboBoxModel(db.getBeszallitok()));
        parentPanel.add(beszallitoAdatmodositasPanel);

        parentPanel.revalidate();
        parentPanel.repaint();
    }//GEN-LAST:event_jMenu1MouseClicked

    private void arajanlatGombActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_arajanlatGombActionPerformed
        Dokumentum doku = new Dokumentum(this, true);
        doku.setVisible(true);
    }//GEN-LAST:event_arajanlatGombActionPerformed

    private void rendelesFeladGombActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rendelesFeladGombActionPerformed
        MegrendelesOsszekeszites keszit = new MegrendelesOsszekeszites(this, true);
        keszit.setVisible(true);
    }//GEN-LAST:event_rendelesFeladGombActionPerformed

    private void bevetelKivetGombActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bevetelKivetGombActionPerformed
        parentPanel.removeAll();
        BevetelKivetel bevetelKivetelPanel = new BevetelKivetel();

        parentPanel.add(bevetelKivetelPanel);

        parentPanel.revalidate();
        parentPanel.repaint();
        
        
    }//GEN-LAST:event_bevetelKivetGombActionPerformed

    private void atvezetGombActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atvezetGombActionPerformed
        parentPanel.removeAll();
        RaktarkoziAtvezetes raktarkoziAtvezetesPanel = new RaktarkoziAtvezetes();
        raktarkoziAtvezetesPanel.getStartRaktarComboBox().setModel(new DefaultComboBoxModel(db.getRaktarak()));

        parentPanel.add(raktarkoziAtvezetesPanel);

        parentPanel.revalidate();
        parentPanel.repaint();
    }//GEN-LAST:event_atvezetGombActionPerformed

    private void lekerdezesekGombActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lekerdezesekGombActionPerformed
        parentPanel.removeAll();
        Lekerdezes lekerdezesPanel = new Lekerdezes();

        parentPanel.add(lekerdezesPanel);

        parentPanel.revalidate();
        parentPanel.repaint();
    }//GEN-LAST:event_lekerdezesekGombActionPerformed

    static JPanel getPanel() {
        return frame.panel;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            UIManager.put("ToolTip.background", Color.white);
            UIManager.put("ToolTip.foreground", Color.black);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem adatokTorlese;
    private javax.swing.JMenuItem adatokTorleseMenu;
    private javax.swing.JButton arajanlatGomb;
    private javax.swing.JButton atvezetGomb;
    private javax.swing.JButton bevetelKivetGomb;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton lekerdezesekGomb;
    private javax.swing.JButton leltarGomb;
    private javax.swing.JMenu leltarMenu;
    private javax.swing.JMenu megrendelesOsszekeszitesMenu;
    private javax.swing.JMenu menu;
    private javax.swing.JPanel parentPanel;
    private javax.swing.JButton rendelesFeladGomb;
    private javax.swing.JMenu tesztAdatokBetoltese;
    // End of variables declaration//GEN-END:variables
}

class MyDefaultMetalTheme extends DefaultMetalTheme {

    public ColorUIResource getWindowTitleInactiveBackground() {
        return new ColorUIResource(java.awt.Color.orange);
    }

    public ColorUIResource getWindowTitleBackground() {
        return new ColorUIResource(java.awt.Color.orange);
    }

    public ColorUIResource getPrimaryControlHighlight() {
        return new ColorUIResource(java.awt.Color.orange);
    }

    public ColorUIResource getPrimaryControlDarkShadow() {
        return new ColorUIResource(java.awt.Color.orange);
    }

    public ColorUIResource getPrimaryControl() {
        return new ColorUIResource(java.awt.Color.orange);
    }

    public ColorUIResource getControlHighlight() {
        return new ColorUIResource(java.awt.Color.orange);
    }

    public ColorUIResource getControlDarkShadow() {
        return new ColorUIResource(java.awt.Color.orange);
    }

    public ColorUIResource getControl() {
        return new ColorUIResource(java.awt.Color.orange);
    }
}