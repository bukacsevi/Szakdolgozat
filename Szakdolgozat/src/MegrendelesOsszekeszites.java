
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import newpackage.DbKapcsolat;
import newpackage.Megrendeles;
import newpackage.Raktár;
import newpackage.Termék;
import newpackage.Vevő;

public class MegrendelesOsszekeszites extends javax.swing.JDialog {

    private DbKapcsolat db;
    private Vector<Integer> megrendelesAzonositok;
    private ActionEvent evt;

    public MegrendelesOsszekeszites(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        
        JTableHeader header = table.getTableHeader(); //[255,140,0]
        header.setBackground(Color.getHSBColor((float) 0.46785712, (float) 1.0, (float) 0.54901963));
        header.setForeground(Color.WHITE);

        megrendelesAzonositok = new Vector<>();

        this.db = frame.getDbKapcsolat();
        db.megrendelesekVektorFeltolt();
        megrendelesAzonositokVektorFeltolt(megrendelesAzonositok);
        vevoLista.setModel(new DefaultComboBoxModel(megrendelesAzonositok));

        raktarLista.setModel(new DefaultComboBoxModel(db.getRaktarak()));

        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("Cikkszám");
        model.addColumn("Megnevezés");
        model.addColumn("Rendelt mennyiség");
        model.addColumn("Raktáron lévő mennyiség");
        model.addColumn("Feladva");

 
        try {
            vevoListaActionPerformed(evt);
        } catch (Exception e) {
            table.setModel(model);
        }
        
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        table.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);

    }

//    private static JTable getNewRenderedTable(final JTable table, int raktarMennyiseg, int rendeltMennyiseg) {
//        table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){
//            @Override
//            public Component getTableCellRendererComponent(JTable table,
//                    Object value, boolean isSelected, boolean hasFocus, int row, int col) {
//                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);
//                int status = (int)table.getModel().getValueAt(2, 2);
//                if (status==2) {
//                    setBackground(Color.BLACK);
//                    setForeground(Color.WHITE);
//                } else {
//                    setBackground(table.getBackground());
//                    setForeground(table.getForeground());
//                }       
//                return this;
//            }   
//        });
//        return table;
//    }
    private void megrendelesAzonositokVektorFeltolt(Vector<Integer> megrendelesAzonositok) {
        megrendelesAzonositok.clear();
        for (int i = 0; i < db.getMegrendelesek().size(); i++) {

            int vevoId = ((Megrendeles) db.getMegrendelesek().get(i)).getVevoId();
            if (!megrendelesAzonositok.contains(vevoId)) {
                megrendelesAzonositok.add(vevoId);
            }
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable()
        {
            @Override
            public Component prepareRenderer(TableCellRenderer renderer, int row, int column){

                Component componenet=super.prepareRenderer(renderer, row, column);

                if(column==2){

                    Integer rendeltMennyiseg=(Integer) getModel().getValueAt(row,column);
                    Integer raktarKeszlet= (Integer)getModel().getValueAt(row,column+1);

                    if(rendeltMennyiseg!=null && raktarKeszlet!=null){
                        if(rendeltMennyiseg>raktarKeszlet){

                            componenet.setForeground(Color.RED);

                        }
                    }
                }
                else{

                    componenet.setBackground(Color.WHITE);
                    componenet.setForeground(Color.BLACK);
                }
                return componenet;
            }
        }
        ;
        vevoLista = new javax.swing.JComboBox();
        feladva = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        raktarLista = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Megrendelés Feladás");
        setBackground(new java.awt.Color(238, 238, 238));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        table.setGridColor(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(table);

        vevoLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vevoListaActionPerformed(evt);
            }
        });

        feladva.setBackground(new java.awt.Color(255, 140, 0));
        feladva.setForeground(new java.awt.Color(255, 255, 255));
        feladva.setText("MEGRENDELÉS FELADVA");
        feladva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                feladvaActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 140, 113));
        jLabel1.setText("Vevő azonosító");

        raktarLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                raktarListaActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 140, 113));
        jLabel2.setText("Összekészítő raktár");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 140, 113));
        jLabel3.setText("Válassza ki a feladott termékeket:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(vevoLista, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(raktarLista, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(feladva)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 812, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(vevoLista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(raktarLista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(feladva, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void vevoListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vevoListaActionPerformed
        int vevoId = (int) vevoLista.getSelectedItem();
        table.setModel(db.megrendelesLekerdezes(vevoId));

        raktarListaActionPerformed(evt);
    }//GEN-LAST:event_vevoListaActionPerformed

    private void feladvaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_feladvaActionPerformed
        int vevoId = (int) vevoLista.getSelectedItem();
        Raktár raktar = (Raktár) raktarLista.getSelectedItem();
        int mennyiLettFeladva = 0;

        for (int i = 0; i < table.getRowCount(); i++) {

            if ((Boolean) table.getValueAt(i, 4)) {

                Termék termek = db.lekerdezTermek((String) table.getValueAt(i, 0));

                try {

                    if (db.megrendelesFeladva(vevoId, termek.getTermekId(), raktar.getRaktarId(), (int) table.getValueAt(i, 2)) == true) {

                        mennyiLettFeladva += 1;
                    }

                } catch (Exception ex) {
                    Logger.getLogger(MegrendelesOsszekeszites.class.getName()).log(Level.SEVERE, null, ex);
                }

                db.megrendelesekVektorFeltolt();
                megrendelesAzonositokVektorFeltolt(megrendelesAzonositok);
                vevoLista.setModel(new DefaultComboBoxModel(megrendelesAzonositok));

            }
        }
        if (mennyiLettFeladva == table.getRowCount() && table.getRowCount() != 0) {
            JOptionPane.showMessageDialog(null, "Megrendelés feladva");
        } else if (mennyiLettFeladva == 0) {
            JOptionPane.showMessageDialog(null, "Feladás sikertelen");
        } else {
            JOptionPane.showMessageDialog(null, "Tört rendelés feladva");
        }

        table.setModel(db.megrendelesLekerdezes(vevoId));

    }//GEN-LAST:event_feladvaActionPerformed

    private void raktarListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_raktarListaActionPerformed
        for (int i = 0; i < table.getRowCount(); i++) {

            Raktár raktar = (Raktár) raktarLista.getSelectedItem();
            String cikkszam = (String) table.getValueAt(i, 0);
            String megnevezes = (String) table.getValueAt(i, 1);
            int rendeltMennyiseg = (int) table.getValueAt(i, 2);

            int raktarMennyiseg = db.aktualisRaktarMennyiseg(raktar.getRaktarId(), megnevezes, cikkszam);

            table.setValueAt(raktarMennyiseg, i, 3);
            if (raktarMennyiseg < rendeltMennyiseg) {
//                getNewRenderedTable(table, raktarMennyiseg, rendeltMennyiseg);
//                table.getCellRenderer(0, 0).getTableCellRendererComponent(table, null, false, false, 0, 0).setBackground(Color.red);
            }
        }
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        table.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
    }//GEN-LAST:event_raktarListaActionPerformed

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
            java.util.logging.Logger.getLogger(MegrendelesOsszekeszites.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MegrendelesOsszekeszites.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MegrendelesOsszekeszites.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MegrendelesOsszekeszites.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MegrendelesOsszekeszites dialog = new MegrendelesOsszekeszites(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton feladva;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox raktarLista;
    private javax.swing.JTable table;
    private javax.swing.JComboBox vevoLista;
    // End of variables declaration//GEN-END:variables
}
