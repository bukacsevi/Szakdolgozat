/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adatbáziskliens;

import adatbáziskapcsolat.DbKapcsolat;
import adatbáziskapcsolat.Raktár;
import adatbáziskapcsolat.Termék;
import static java.lang.Math.E;
import static java.lang.StrictMath.E;
import java.util.Vector;
import static javafx.scene.input.KeyCode.E;
import javax.swing.AbstractListModel;
import javax.swing.JFrame;
import javax.swing.*;

/**
 *
 * @author kicsi
 */
public class Keszletnyilvantarto extends javax.swing.JFrame {

    /**
     * Creates new form Keszletnyilvantarto
     */
    public Keszletnyilvantarto() {
        initComponents();
        this.setLocationRelativeTo(null);
        db = new DbKapcsolat();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        raktarLista = new javax.swing.JList();
        jScrollPane3 = new javax.swing.JScrollPane();
        termekLista = new javax.swing.JList();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        termekDb = new javax.swing.JTextField();
        bevetelezesGomb = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        ujTermekMenu = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        ujRakterMenu = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        ujVevoMenu = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        ujBeszallitoMenu = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Készletnyilvántartó");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jLabel1.setText("Bevételezés/Kivételezés");

        jScrollPane2.setViewportView(raktarLista);

        jScrollPane3.setViewportView(termekLista);

        jLabel2.setText("raktár");

        jLabel3.setText("termék");

        jLabel4.setText("darab");

        bevetelezesGomb.setText("+");
        bevetelezesGomb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bevetelezesGombActionPerformed(evt);
            }
        });

        jButton2.setText("-");

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu3.setText("Termék");

        ujTermekMenu.setText("Új Termék Hozzáadás");
        ujTermekMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ujTermekMenuActionPerformed(evt);
            }
        });
        jMenu3.add(ujTermekMenu);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Raktár");

        ujRakterMenu.setText("Új Raktár Hozzáadás");
        ujRakterMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ujRakterMenuActionPerformed(evt);
            }
        });
        jMenu4.add(ujRakterMenu);

        jMenuBar1.add(jMenu4);

        jMenu5.setText("Vevő");

        ujVevoMenu.setText("Új Vevő Hozzáadás");
        ujVevoMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ujVevoMenuActionPerformed(evt);
            }
        });
        jMenu5.add(ujVevoMenu);

        jMenuBar1.add(jMenu5);

        jMenu6.setText("Beszállító");

        ujBeszallitoMenu.setText("Új Beszállító Hozzáadás");
        ujBeszallitoMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ujBeszallitoMenuActionPerformed(evt);
            }
        });
        jMenu6.add(ujBeszallitoMenu);

        jMenuBar1.add(jMenu6);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(69, 69, 69)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(termekDb, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(95, 95, 95)
                        .addComponent(bevetelezesGomb)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(termekDb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bevetelezesGomb)
                    .addComponent(jButton2))
                .addContainerGap(72, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ujBeszallitoMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ujBeszallitoMenuActionPerformed
        this.setVisible(false);
        UjBeszallitoHozzaadas ujBeszallito = new UjBeszallitoHozzaadas(this, true);
        ujBeszallito.setVisible(true);
    }//GEN-LAST:event_ujBeszallitoMenuActionPerformed

    private void ujTermekMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ujTermekMenuActionPerformed
        this.setVisible(false);
        UjTermekHozzaadas ujTermek = new UjTermekHozzaadas(this, true);
        ujTermek.setVisible(true);
        //raktarLista.setListData(db.getRaktarak());
        //termekLista.setListData(db.getTermekek());
    }//GEN-LAST:event_ujTermekMenuActionPerformed

    private void ujRakterMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ujRakterMenuActionPerformed
        this.setVisible(false);
        UjRaktarHozzaadas ujRaktar = new UjRaktarHozzaadas(this, true);
        ujRaktar.setVisible(true);

    }//GEN-LAST:event_ujRakterMenuActionPerformed

    private void ujVevoMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ujVevoMenuActionPerformed
        this.setVisible(false);
        UjVevoHozzaadas ujVevo = new UjVevoHozzaadas(this, true);
        ujVevo.setVisible(true);
    }//GEN-LAST:event_ujVevoMenuActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        raktarLista.setListData(db.getRaktarak());
        termekLista.setListData(db.getTermekek());
    }//GEN-LAST:event_formWindowActivated

    private void bevetelezesGombActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bevetelezesGombActionPerformed
        try {
            int raktarId = ((Raktár) raktarLista.getSelectedValue()).getRaktarId();
            int termekId = ((Termék) termekLista.getSelectedValue()).getTermekId();
            int darab = Integer.parseInt(termekDb.getText()); //input ellenőrzés kell
            //raktarLista.setListData(db.getRaktarak());
            //termekLista.setListData(db.getTermekek());
           
            db.bevetelezes(raktarId, termekId, darab);
            
        } catch (Exception e) {
            System.out.println("hiba a bevételezésben");
        }
    }//GEN-LAST:event_bevetelezesGombActionPerformed

    protected DbKapcsolat getDbKapcsolat() {
        return db;
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
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Keszletnyilvantarto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Keszletnyilvantarto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Keszletnyilvantarto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Keszletnyilvantarto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Keszletnyilvantarto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bevetelezesGomb;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JList raktarLista;
    private javax.swing.JTextField termekDb;
    private javax.swing.JList termekLista;
    private javax.swing.JMenuItem ujBeszallitoMenu;
    private javax.swing.JMenuItem ujRakterMenu;
    private javax.swing.JMenuItem ujTermekMenu;
    private javax.swing.JMenuItem ujVevoMenu;
    // End of variables declaration//GEN-END:variables
    private DbKapcsolat db;

}
