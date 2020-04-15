
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import newpackage.Beszállító;
import newpackage.DbKapcsolat;
import newpackage.Raktár;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author kicsi
 */
public class Lekerdezes extends javax.swing.JPanel {

    private DbKapcsolat db;
    private Raktár raktar = null;
    private int raktarId = 0;
    private String termekMegnevezes;
    private String termekCikkszam;
    DefaultTableModel model;
    private String tolDatum = "2020-03-01";
    private LocalDate date = LocalDate.now();
    private String igDatum = date.toString();

    public Lekerdezes() {
        initComponents();

        tolInput.setEditable(false);
        igInput.setEditable(false);
        

        JTableHeader header = tabla.getTableHeader(); //[255,140,0]
        header.setBackground(Color.getHSBColor((float) 0.46785712, (float) 1.0, (float) 0.54901963));
        header.setForeground(Color.WHITE);
//        float[] hsbvals= new float[3];
//        Color.RGBtoHSB(255, 140, 0, hsbvals);        

        radioGombok.add(termekLekerdezRadioGomb);
        radioGombok.add(beszallitoRadioGomb);
        radioGombok.add(megrendelesRadioButton);

        tolInput.setText(tolDatum);
        igInput.setText(igDatum);

        termekLekerdezRadioGomb.setSelected(true);

        db = frame.getDbKapcsolat();
        model = new DefaultTableModel();

        model.addColumn("Raktár");
        model.addColumn("Cikkszám");
        model.addColumn("Megnevezés");
        model.addColumn("Ár");
        model.addColumn("Mennyiség");
        //legyen beszállító is
        tabla.setModel(model);
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
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        megrendelesRadioButton = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        vevoAzonosito = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        vezeteknev = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        keresztnev = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        megrendelesCikkszam = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        termekLekerdezRadioGomb = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        raktarLista = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        megnevezes = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        cikkszam = new javax.swing.JTextField();
        raktarKivalasztChechBox = new javax.swing.JCheckBox();
        atvezetesCheckbox = new javax.swing.JCheckBox();
        tolInput = new javax.swing.JTextField();
        igInput = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        beszallitoRadioGomb = new javax.swing.JRadioButton();
        beszallitoLista = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        szures = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 140, 113));

        jPanel2.setBackground(new java.awt.Color(238, 238, 238));

        tabla.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tabla.setModel(new javax.swing.table.DefaultTableModel(
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
        tabla.setGridColor(new java.awt.Color(255, 255, 255));
        jScrollPane2.setViewportView(tabla);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        megrendelesRadioButton.setBackground(new java.awt.Color(255, 255, 255));
        megrendelesRadioButton.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        megrendelesRadioButton.setForeground(new java.awt.Color(0, 140, 113));
        megrendelesRadioButton.setText("Megrendelés");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 140, 113));
        jLabel3.setText("Vevőazonosító");

        jLabel8.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 140, 113));
        jLabel8.setText("Vezetéknév");

        jLabel9.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 140, 113));
        jLabel9.setText("Keresztnév");

        jLabel7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 140, 113));
        jLabel7.setText("Cikkszám");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(megrendelesRadioButton)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(vezeteknev, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(vevoAzonosito, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(keresztnev, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(megrendelesCikkszam, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(megrendelesRadioButton)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(vevoAzonosito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(vezeteknev, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(keresztnev, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(megrendelesCikkszam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        termekLekerdezRadioGomb.setBackground(new java.awt.Color(255, 255, 255));
        termekLekerdezRadioGomb.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        termekLekerdezRadioGomb.setForeground(new java.awt.Color(0, 140, 113));
        termekLekerdezRadioGomb.setText("Termék lekérdezés");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 140, 113));
        jLabel5.setText("Raktár:");

        raktarLista.setEditable(true);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 140, 113));
        jLabel2.setText("Megnevezés:");

        megnevezes.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 140, 113));
        jLabel1.setText("Cikkszám:");

        cikkszam.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        raktarKivalasztChechBox.setBackground(new java.awt.Color(255, 255, 255));
        raktarKivalasztChechBox.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        raktarKivalasztChechBox.setForeground(new java.awt.Color(0, 140, 113));
        raktarKivalasztChechBox.setText("Raktár kiválasztása");
        raktarKivalasztChechBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                raktarKivalasztChechBoxActionPerformed(evt);
            }
        });

        atvezetesCheckbox.setBackground(new java.awt.Color(255, 255, 255));
        atvezetesCheckbox.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        atvezetesCheckbox.setForeground(new java.awt.Color(0, 140, 113));
        atvezetesCheckbox.setText("Raktárközi átvezetés");
        atvezetesCheckbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atvezetesCheckboxActionPerformed(evt);
            }
        });

        igInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                igInputActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 140, 113));
        jLabel11.setText("Dátum:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(tolInput, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(igInput, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cikkszam)
                                    .addComponent(megnevezes)))
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(termekLekerdezRadioGomb)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(57, 57, 57)
                                    .addComponent(raktarLista, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel1)))
                        .addGap(18, 18, 18))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(raktarKivalasztChechBox)
                                .addGap(18, 18, 18)
                                .addComponent(atvezetesCheckbox))
                            .addComponent(jLabel11))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(termekLekerdezRadioGomb)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(raktarLista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(raktarKivalasztChechBox)
                    .addComponent(atvezetesCheckbox))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(megnevezes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(cikkszam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tolInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(igInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        beszallitoRadioGomb.setBackground(new java.awt.Color(255, 255, 255));
        beszallitoRadioGomb.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        beszallitoRadioGomb.setForeground(new java.awt.Color(0, 140, 113));
        beszallitoRadioGomb.setText("Beszállító lekérdezés");
        beszallitoRadioGomb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                beszallitoRadioGombActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 140, 113));
        jLabel10.setText("Beszállító:");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(beszallitoRadioGomb)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                        .addComponent(beszallitoLista, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(beszallitoRadioGomb)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(beszallitoLista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        szures.setBackground(new java.awt.Color(255, 140, 0));
        szures.setForeground(new java.awt.Color(255, 255, 255));
        szures.setText("LEKÉRDEZÉS");
        szures.setBorderPainted(false);
        szures.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                szuresActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(szures, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator3)
                        .addGap(321, 321, 321))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(szures, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(391, 391, 391))
        );

        jPanel1.setBackground(new java.awt.Color(0, 140, 113));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Lekérdezések");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1155, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 739, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(66, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void raktarKivalasztChechBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_raktarKivalasztChechBoxActionPerformed
        if (raktarKivalasztChechBox.isSelected()) {
            raktarLista.setModel(new DefaultComboBoxModel(db.getRaktarak()));

        } else {
            raktarLista.setModel(new DefaultComboBoxModel());
            raktarId = 0;
        }
    }//GEN-LAST:event_raktarKivalasztChechBoxActionPerformed

    private void beszallitoRadioGombActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_beszallitoRadioGombActionPerformed
        beszallitoLista.setModel(new DefaultComboBoxModel(db.getBeszallitok()));
    }//GEN-LAST:event_beszallitoRadioGombActionPerformed

    private void szuresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_szuresActionPerformed
        this.tolDatum = tolInput.getText();
        this.igDatum = igInput.getText();

        if (termekLekerdezRadioGomb.isSelected()) {

            //Minden életút
            if (atvezetesCheckbox.isSelected() && !raktarKivalasztChechBox.isSelected()) {

                if (!tolInput.getText().isEmpty() && !igInput.getText().isEmpty() && datumEllenorzes(tolDatum, igDatum)) {

                    tabla.setModel(model);
                    tabla.setModel(db.eletutLekerdezes(tolDatum, igDatum));

                    DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
                    centerRenderer.setHorizontalAlignment(JLabel.CENTER);
                    tabla.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
                    tabla.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);

                } else {
                    JOptionPane.showMessageDialog(null, "Hibás dátum");
                }
                //Életút raktárra szűrve
            } else if (atvezetesCheckbox.isSelected() && raktarKivalasztChechBox.isSelected()) {

                if (!tolInput.getText().isEmpty() && !igInput.getText().isEmpty() && datumEllenorzes(tolDatum, igDatum)) {

                    raktar = (Raktár) raktarLista.getSelectedItem();
                    raktarId = raktar.getRaktarId();
                    tabla.setModel(model);
                    tabla.setModel(db.eletutLekerdezes(raktarId, tolDatum, igDatum));

                    DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
                    centerRenderer.setHorizontalAlignment(JLabel.CENTER);
                    tabla.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
                    tabla.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);

                } else {
                    JOptionPane.showMessageDialog(null, "Hibás dátum");
                }

                // Termék lekérdezés minden raktárban
            } else if (!raktarKivalasztChechBox.isSelected()) {
                termekMegnevezes = megnevezes.getText();
                termekCikkszam = cikkszam.getText();
                tabla.setModel(db.lekerdezes(0, termekMegnevezes, termekCikkszam));

                DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
                centerRenderer.setHorizontalAlignment(JLabel.CENTER);
                tabla.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
                tabla.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
                tabla.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
                //Termék lekérdezés raktárra szűrve
            } else if (raktarKivalasztChechBox.isSelected()) {
                raktar = (Raktár) raktarLista.getSelectedItem();
                raktarId = raktar.getRaktarId();
                termekMegnevezes = megnevezes.getText();
                termekCikkszam = cikkszam.getText();
                tabla.setModel(db.lekerdezes(raktarId, termekMegnevezes, termekCikkszam));

                DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
                centerRenderer.setHorizontalAlignment(JLabel.CENTER);
                tabla.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
                tabla.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
                tabla.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
            }
        }       //Beszállító termékeinek lekérdezése
        if (beszallitoRadioGomb.isSelected()) {
            tabla.setModel(db.lekerdezBeszallitoTermekei((Beszállító) beszallitoLista.getSelectedItem()));

            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(JLabel.CENTER);
            tabla.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
            tabla.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        }
        if (megrendelesRadioButton.isSelected()) {
            int vevoId = 0;

            if (!vevoAzonosito.getText().isEmpty()) {
                vevoId = Integer.parseInt(vevoAzonosito.getText());
            }
            String vezetekN = vezeteknev.getText();
            String keresztN = keresztnev.getText();
            String cikkszam = megrendelesCikkszam.getText();

            tabla.setModel(db.MegrendelesLekerdezes(vevoId, vezetekN, keresztN, cikkszam));

            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(JLabel.CENTER);
            tabla.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
            tabla.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
            tabla.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
            tabla.getColumnModel().getColumn(6).setCellRenderer(centerRenderer);
        }
    }//GEN-LAST:event_szuresActionPerformed

    private void igInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_igInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_igInputActionPerformed

    private void atvezetesCheckboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atvezetesCheckboxActionPerformed
        if (atvezetesCheckbox.isSelected()) {
            tolInput.setEditable(true);
            igInput.setEditable(true);
            megnevezes.setEditable(false);
            cikkszam.setEditable(false);
        } else {
            tolInput.setEditable(false);
            igInput.setEditable(false);
            megnevezes.setEditable(true);
            cikkszam.setEditable(true);
        }
    }//GEN-LAST:event_atvezetesCheckboxActionPerformed

    private boolean datumEllenorzes(String tolDatum, String igDatum) {
        Boolean helyesDatum = true;
        if (tolDatum.length() == 10 || igDatum.length() == 10) {

            if (tolDatum.charAt(4) != '-' || tolDatum.charAt(7) != '-') {
                helyesDatum = false;
            }

            try {
                String ellenorzesTolDatum = tolDatum.substring(0, 4);
                String ellenorzesIgDatum = igDatum.substring(0, 4);
                int ellenorzes = Integer.parseInt(ellenorzesTolDatum);
                ellenorzes = Integer.parseInt(ellenorzesIgDatum);

                ellenorzesTolDatum = tolDatum.substring(5, 7);
                ellenorzesIgDatum = igDatum.substring(5, 7);
                ellenorzes = Integer.parseInt(ellenorzesTolDatum);
                ellenorzes = Integer.parseInt(ellenorzesIgDatum);

                ellenorzesTolDatum = tolDatum.substring(8, 10);
                ellenorzesIgDatum = igDatum.substring(8, 10);
                ellenorzes = Integer.parseInt(ellenorzesTolDatum);
                ellenorzes = Integer.parseInt(ellenorzesIgDatum);

            } catch (Exception e) {
                helyesDatum = false;

            }
        } else {
            System.out.println("hossz");
            helyesDatum = false;

        }
        return helyesDatum;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox atvezetesCheckbox;
    private javax.swing.JComboBox beszallitoLista;
    private javax.swing.JRadioButton beszallitoRadioGomb;
    private javax.swing.JTextField cikkszam;
    private javax.swing.JTextField igInput;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextField keresztnev;
    private javax.swing.JTextField megnevezes;
    private javax.swing.JTextField megrendelesCikkszam;
    private javax.swing.JRadioButton megrendelesRadioButton;
    private javax.swing.ButtonGroup radioGombok;
    private javax.swing.JCheckBox raktarKivalasztChechBox;
    private javax.swing.JComboBox raktarLista;
    private javax.swing.JButton szures;
    private javax.swing.JTable tabla;
    private javax.swing.JRadioButton termekLekerdezRadioGomb;
    private javax.swing.JTextField tolInput;
    private javax.swing.JTextField vevoAzonosito;
    private javax.swing.JTextField vezeteknev;
    // End of variables declaration//GEN-END:variables
}
