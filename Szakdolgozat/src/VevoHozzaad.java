
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import newpackage.DbKapcsolat;
import newpackage.Vevő;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author kicsi
 */
public class VevoHozzaad extends javax.swing.JPanel {

    private DbKapcsolat db;

    public VevoHozzaad() {
        initComponents();
        radioGombok.add(hozzaadRadioGomb);
        radioGombok.add(modositRadioGomb);
        radioGombok.add(torolRadioGomb);
        db = frame.getDbKapcsolat();

        hozzaadRadioGomb.setSelected(true);
        vasarloLista.setEnabled(false);

        AutoCompleteDecorator.decorate(vasarloLista);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        radioGombok = new javax.swing.ButtonGroup();
        keszGomb = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        modositRadioGomb = new javax.swing.JRadioButton();
        torolRadioGomb = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        vasarloLista = new javax.swing.JComboBox();
        keresGomb = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        hozzaadRadioGomb = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        vezetekNev = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        keresztNev = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cim = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        telefonszam = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();

        setBackground(new java.awt.Color(238, 238, 238));

        keszGomb.setBackground(new java.awt.Color(255, 140, 0));
        keszGomb.setForeground(new java.awt.Color(255, 255, 255));
        keszGomb.setText("KÉSZ");
        keszGomb.setBorderPainted(false);
        keszGomb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keszGombActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 140, 113));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Vásárló műveletek");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        modositRadioGomb.setBackground(new java.awt.Color(255, 255, 255));
        modositRadioGomb.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        modositRadioGomb.setForeground(new java.awt.Color(0, 140, 113));
        modositRadioGomb.setText("Vásárló adatmódosítás");
        modositRadioGomb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modositRadioGombActionPerformed(evt);
            }
        });

        torolRadioGomb.setBackground(new java.awt.Color(255, 255, 255));
        torolRadioGomb.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        torolRadioGomb.setForeground(new java.awt.Color(0, 140, 113));
        torolRadioGomb.setText("Vásárló törlés");
        torolRadioGomb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                torolRadioGombActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 140, 113));
        jLabel7.setText("Vásárló kiválasztása:");

        vasarloLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vasarloListaActionPerformed(evt);
            }
        });

        keresGomb.setBackground(new java.awt.Color(255, 140, 0));
        keresGomb.setForeground(new java.awt.Color(255, 255, 255));
        keresGomb.setText("FRISSÍT");
        keresGomb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keresGombActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(keresGomb, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(modositRadioGomb, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(vasarloLista, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(torolRadioGomb, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))))
                .addGap(0, 63, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(torolRadioGomb)
                    .addComponent(modositRadioGomb))
                .addGap(32, 32, 32)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(vasarloLista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(keresGomb, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        hozzaadRadioGomb.setBackground(new java.awt.Color(255, 255, 255));
        hozzaadRadioGomb.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        hozzaadRadioGomb.setForeground(new java.awt.Color(0, 140, 113));
        hozzaadRadioGomb.setText("Új vásárló hozzáadása");
        hozzaadRadioGomb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hozzaadRadioGombActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 140, 113));
        jLabel1.setText("Vezetéknév:");

        vezetekNev.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        vezetekNev.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                EnterKeyPressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 140, 113));
        jLabel3.setText("Keresztnév:");

        keresztNev.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        keresztNev.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                EnterKeyPressed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 140, 113));
        jLabel5.setText("Cím:");

        cim.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        cim.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                EnterKeyPressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 140, 113));
        jLabel2.setText("Telefonszám:");

        telefonszam.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        telefonszam.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                EnterKeyPressed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 140, 113));
        jLabel4.setText("E-mail cím:");

        email.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        email.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                EnterKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(116, 116, 116)
                        .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(telefonszam, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cim, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(keresztNev, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(hozzaadRadioGomb, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(vezetekNev, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(103, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(hozzaadRadioGomb)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(vezetekNev, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(keresztNev, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(telefonszam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(61, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(keszGomb, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(103, 103, 103))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(keszGomb, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    public JComboBox getVevoListaComboBox() {
        return this.vasarloLista;
    }

    private void keszGombActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keszGombActionPerformed

        try {
            String keresztNev_ = keresztNev.getText();
            String vezetekNev_ = vezetekNev.getText();
            String cim_ = cim.getText();
            String telefonszam_ = telefonszam.getText();
            String email_ = email.getText();

            if (hozzaadRadioGomb.isSelected() || modositRadioGomb.isSelected()) {

                if (keresztNev_.equals("") || vezetekNev_.equals("") || email_.equals("") || cim_.equals("")) {
                    JOptionPane.showMessageDialog(null, "A vezetéknév, keresztnév, cím, e-mail cím megadása kötelező!");
                    return;
                }
                if (telefonszam_.length() != 0) {
                    if (telefonszam_.length() < 11 || telefonszam_.length() > 12 || telefonszam_.charAt(0) != '+' || telefonszam_.charAt(1) != '3' || telefonszam_.charAt(2) != '6') {
                        JOptionPane.showMessageDialog(null, "Telefoszám formátum +36202222222");
                        return;
                    }
                }
                if (!(email_.contains("@") && email_.contains("."))) {
                    JOptionPane.showMessageDialog(null, "Hibás e-mail cím!");
                    return;
                }
            }

            Vevő ujVevo = new Vevő(vezetekNev_, keresztNev_, cim_, telefonszam_, email_);

            if (hozzaadRadioGomb.isSelected()) {
                try {
                    db.ujVevo(ujVevo);
                    vasarloLista.setModel(new DefaultComboBoxModel(db.getVevok()));
                    JOptionPane.showMessageDialog(null, "Vásárló hozzáadva!");
                } catch (Exception ex) {
                    Logger.getLogger(DbKapcsolat.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "Hibás adatbevitel!");
                }
            }
            if (modositRadioGomb.isSelected()) {
                Vevő modositandoVevo = (Vevő) vasarloLista.getSelectedItem();
                int modositandoVevoId = modositandoVevo.getVevoId();
                ujVevo.setVevoId(modositandoVevoId);
                db.modositVevo(ujVevo);

                vasarloLista.setModel(new DefaultComboBoxModel(db.getVevok()));
                keresGomb.doClick();
            }
            if (torolRadioGomb.isSelected()) {
                Vevő torlendoVevo = (Vevő) vasarloLista.getSelectedItem();
                db.torolVevo(torlendoVevo);

                vasarloLista.setModel(new DefaultComboBoxModel(db.getVevok()));
                keresGomb.doClick();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hibás adatbevitel!");
        }

    }//GEN-LAST:event_keszGombActionPerformed

    private void hozzaadRadioGombActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hozzaadRadioGombActionPerformed
        keresztNev.setEditable(true);
        keresztNev.setBackground(Color.WHITE);
        vezetekNev.setEditable(true);
        vezetekNev.setBackground(Color.WHITE);
        cim.setEditable(true);
        cim.setBackground(Color.WHITE);
        telefonszam.setEditable(true);
        telefonszam.setBackground(Color.WHITE);
        email.setEditable(true);
        email.setBackground(Color.WHITE);
        vasarloLista.setEnabled(false);

        keresztNev.setText("");
        vezetekNev.setText("");
        cim.setText("");
        telefonszam.setText("");
        email.setText("");

    }//GEN-LAST:event_hozzaadRadioGombActionPerformed

    private void modositRadioGombActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modositRadioGombActionPerformed
        keresztNev.setEditable(false);
        keresztNev.setBackground(Color.LIGHT_GRAY);
        vezetekNev.setEditable(false);
        vezetekNev.setBackground(Color.LIGHT_GRAY);
        cim.setEditable(false);
        cim.setBackground(Color.LIGHT_GRAY);
        telefonszam.setEditable(false);
        telefonszam.setBackground(Color.LIGHT_GRAY);
        email.setEditable(false);
        email.setBackground(Color.LIGHT_GRAY);
        vasarloLista.setEnabled(true);

        keresGomb.doClick();
    }//GEN-LAST:event_modositRadioGombActionPerformed

    private void torolRadioGombActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_torolRadioGombActionPerformed
        keresztNev.setEditable(false);
        keresztNev.setBackground(Color.LIGHT_GRAY);
        vezetekNev.setEditable(false);
        vezetekNev.setBackground(Color.LIGHT_GRAY);
        cim.setEditable(false);
        cim.setBackground(Color.LIGHT_GRAY);
        telefonszam.setEditable(false);
        telefonszam.setBackground(Color.LIGHT_GRAY);
        email.setEditable(false);
        email.setBackground(Color.LIGHT_GRAY);

        keresGomb.doClick();
    }//GEN-LAST:event_torolRadioGombActionPerformed

    private void keresGombActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keresGombActionPerformed
        if (modositRadioGomb.isSelected()) {
            try {

                Vevő vevo = (Vevő) vasarloLista.getSelectedItem();            //db.lekerdezVevo(email.getText());
                vezetekNev.setText(vevo.getVezetekNev());
                keresztNev.setText(vevo.getKeresztNev());
                cim.setText(vevo.getVevoCim());
                telefonszam.setText(vevo.getVevoTelefonSzam());
                email.setText(vevo.getVevoEmailCim());

                keresztNev.setEditable(true);
                keresztNev.setBackground(Color.WHITE);
                vezetekNev.setEditable(true);
                vezetekNev.setBackground(Color.WHITE);
                cim.setEditable(true);
                cim.setBackground(Color.WHITE);
                telefonszam.setEditable(true);
                telefonszam.setBackground(Color.WHITE);
                email.setEditable(true);
                email.setBackground(Color.WHITE);
                vasarloLista.setEnabled(true);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Vásárlólista üres!");
            }
        }
        if (torolRadioGomb.isSelected()) {
            try {
                Vevő vevo = (Vevő) vasarloLista.getSelectedItem(); //db.lekerdezVevo(email.getText());
                vezetekNev.setText(vevo.getVezetekNev());
                keresztNev.setText(vevo.getKeresztNev());
                cim.setText(vevo.getVevoCim());
                telefonszam.setText(vevo.getVevoTelefonSzam());
                email.setText(vevo.getVevoEmailCim());

                keresztNev.setEditable(false);
                keresztNev.setBackground(Color.LIGHT_GRAY);
                vezetekNev.setEditable(false);
                vezetekNev.setBackground(Color.LIGHT_GRAY);
                cim.setEditable(false);
                cim.setBackground(Color.LIGHT_GRAY);
                telefonszam.setEditable(false);
                telefonszam.setBackground(Color.LIGHT_GRAY);
                email.setEditable(false);
                email.setBackground(Color.LIGHT_GRAY);

                vasarloLista.setEnabled(true);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Vásárlólista üres!");

                keresztNev.setText("");
                vezetekNev.setText("");
                cim.setText("");
                telefonszam.setText("");
                email.setText("");
            }
        }
    }//GEN-LAST:event_keresGombActionPerformed

    private void EnterKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_EnterKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            keszGomb.doClick();
        }
    }//GEN-LAST:event_EnterKeyPressed

    private void vasarloListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vasarloListaActionPerformed
        if (modositRadioGomb.isSelected() || torolRadioGomb.isSelected()) {
            keresGomb.doClick();
        }
    }//GEN-LAST:event_vasarloListaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cim;
    private javax.swing.JTextField email;
    private javax.swing.JRadioButton hozzaadRadioGomb;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JButton keresGomb;
    private javax.swing.JTextField keresztNev;
    private javax.swing.JButton keszGomb;
    private javax.swing.JRadioButton modositRadioGomb;
    private javax.swing.ButtonGroup radioGombok;
    private javax.swing.JTextField telefonszam;
    private javax.swing.JRadioButton torolRadioGomb;
    private javax.swing.JComboBox vasarloLista;
    private javax.swing.JTextField vezetekNev;
    // End of variables declaration//GEN-END:variables
}