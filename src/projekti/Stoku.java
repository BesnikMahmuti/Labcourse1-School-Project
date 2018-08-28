/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekti;

import com.sun.glass.events.KeyEvent;
import java.awt.Color;
import java.awt.Panel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Besnik
 */
public class Stoku extends javax.swing.JInternalFrame {

    /**
     * Creates new form StokuDales
     */
    
    private Statement st;
    private Connection con;
    private ResultSet rs;
    private PreparedStatement pst;
    
    public Stoku() {
        initComponents();
        con=ConnectionManager.getConnection();
        ShfaqListenEProd();
    }
    
        public void clear(){
            barkodi.setText("");
            emriProd.setText("");
            qmimi.setText("");
            sasia.setText("");
            totalProd.setText("");
            qmimiTotal.setText("");
            search.setText("");
        }
                    
        
                public ArrayList<AtributetEStokut> listaStokutDales() {
                    ArrayList<AtributetEStokut> listaStokutDales = new ArrayList<AtributetEStokut>();
                    String query = "select*from stoku";
                    try {
                        st=con.createStatement();
                        rs=st.executeQuery(query);
                        AtributetEStokut aes;
                        while(rs.next()){
                            aes=new AtributetEStokut(rs.getInt("stokuID"),rs.getInt("barkodi"),rs.getString("emriIProduktit"),
                            rs.getDouble("qmimi"),rs.getInt("sasia"));
                            listaStokutDales.add(aes);
                        }
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(this, e);
                    }
                    return listaStokutDales;
            }
                
                public void ShfaqListenEProd(){
                    ArrayList<AtributetEStokut> list = listaStokutDales();
                    DefaultTableModel model = (DefaultTableModel)tabela.getModel();
                    Object [] row = new Object[5];
                    for (int i = 0; i < list.size() ; i++) {
                        row[0]=list.get(i).getStokuID();
                        row[1]=list.get(i).getBarkodi();
                        row[2]=list.get(i).getEmriIProduktit();
                        row[3]=list.get(i).getQmimi();
                        row[4]=list.get(i).getSasia();
                        model.addRow(row);
                    }
                }
                
                public void ekzekutoSQLQuery(String query,String message){
                    DefaultTableModel model = (DefaultTableModel)tabela.getModel();
                    try {
                        st=con.createStatement();
                        if(st.executeUpdate(query)==1){
                            model.setRowCount(0);
                              ShfaqListenEProd();
                              JOptionPane.showMessageDialog(this, "U "+message+ " me sukses");
                        }else{
                              JOptionPane.showMessageDialog(this, "Nuk u "+message+ " me sukses");
                        }
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(this, "Ekziston ky produkt","Error"
                                ,JOptionPane.ERROR_MESSAGE);
                    }
                }
                
                 public void ekzekutoSQLQuery1(String query,String message){
                    DefaultTableModel model = (DefaultTableModel)tabela.getModel();
                    try {
                        st=con.createStatement();
                        if(st.executeUpdate(query)==1){
                            model.setRowCount(0);
                              ShfaqListenEProd();
                              JOptionPane.showMessageDialog(this, "U "+message+ " me sukses");
                        }else{
                              JOptionPane.showMessageDialog(this, 
                              "Keto produkte tashme jane fshire nga depo, zgjedhni disa produkte tjera");
                        }
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(this, "Ekziston ky produkt","Error"
                                ,JOptionPane.ERROR_MESSAGE);
                    }
                }
                
                public ArrayList<AtributetEStokut> ListoProduktetSearch(String valueToSearch){
                ArrayList<AtributetEStokut> produktetList = new ArrayList<AtributetEStokut>();
                
                try {
                    st=con.createStatement();
                    String searchQuery = "select * from stoku where "
                            + "stokuID='"+valueToSearch+"' or barkodi='"+valueToSearch+"'";
                    rs=st.executeQuery(searchQuery);
                    AtributetEStokut aes;
                    while(rs.next()){
                        aes = new AtributetEStokut(rs.getInt("stokuID"),rs.getInt("barkodi"),
                        rs.getString("emriIProduktit"),rs.getDouble("qmimi"),rs.getInt("sasia"));
                        produktetList.add(aes);
                        
                   }
                    
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(this, e);
                }
               return produktetList;
            }
            
            public void findProduktet(){
                ArrayList<AtributetEStokut> produktet = ListoProduktetSearch(search.getText());
                DefaultTableModel model =  new DefaultTableModel();
                model.setColumnIdentifiers(new Object[]{"ID","Barkodi","Emri i produktit","Qmimi","Sasia"});
                Object [] row = new Object[5];
                for (int i = 0; i < produktet.size(); i++) {
                    row[0] = produktet.get(i).getStokuID();
                    row[1] = produktet.get(i).getBarkodi();
                    row[2]= produktet.get(i).getEmriIProduktit();
                    row[3] = produktet.get(i).getQmimi();
                    row[4] = produktet.get(i).getSasia();
                    model.addRow(row);
                }
                tabela.setModel(model);
                
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
        search = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        barkodi = new javax.swing.JTextField();
        emriProd = new javax.swing.JTextField();
        qmimi = new javax.swing.JTextField();
        sasia = new javax.swing.JTextField();
        jToolBar1 = new javax.swing.JToolBar();
        add = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        clear1 = new javax.swing.JButton();
        edit = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        qmimiTotal = new javax.swing.JLabel();
        totalProd = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);

        search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                searchKeyTyped(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Search-20.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Barkodi", "Emri i produktit", "Qmimi", "Sasia"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela.getTableHeader().setReorderingAllowed(false);
        tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabela);
        if (tabela.getColumnModel().getColumnCount() > 0) {
            tabela.getColumnModel().getColumn(0).setResizable(false);
            tabela.getColumnModel().getColumn(1).setResizable(false);
            tabela.getColumnModel().getColumn(2).setResizable(false);
            tabela.getColumnModel().getColumn(3).setResizable(false);
            tabela.getColumnModel().getColumn(4).setResizable(false);
        }

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel1.setText("Barkodi");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("Emri i produktit");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setText("Qmimi");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setText("Sasia");

        emriProd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                emriProdKeyTyped(evt);
            }
        });

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        add.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Plus-40.png"))); // NOI18N
        add.setText("Add");
        add.setFocusable(false);
        add.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        jToolBar1.add(add);

        delete.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Delete-40.png"))); // NOI18N
        delete.setText("Delete");
        delete.setFocusable(false);
        delete.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        delete.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        jToolBar1.add(delete);

        clear1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        clear1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Broom-40.png"))); // NOI18N
        clear1.setText("Clear");
        clear1.setFocusable(false);
        clear1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        clear1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        clear1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clear1ActionPerformed(evt);
            }
        });
        jToolBar1.add(clear1);

        edit.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        edit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Edit-40.png"))); // NOI18N
        edit.setText("Edit");
        edit.setFocusable(false);
        edit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        edit.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });
        jToolBar1.add(edit);

        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/1490737231_Print.png"))); // NOI18N
        jButton1.setText("Print");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton1);

        jButton3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Plus 2 Math-40.png"))); // NOI18N
        jButton3.setText("Totali i produkteve");
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton3);

        jButton4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Plus 2 Math-40.png"))); // NOI18N
        jButton4.setText("Qmimi total");
        jButton4.setFocusable(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton4);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel5.setText("Stoku");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 11)); // NOI18N
        jLabel6.setText("Kerko produkt permes id ose barkod");

        jLabel7.setText("Total.Prod:");

        jLabel8.setText("Total.Qmimi:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(251, 251, 251))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(barkodi, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                            .addComponent(emriProd)
                            .addComponent(qmimi)
                            .addComponent(sasia, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(totalProd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(qmimiTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel5)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(totalProd, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(qmimiTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(barkodi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(38, 38, 38)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(emriProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(46, 46, 46)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(qmimi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(47, 47, 47)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(sasia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                        .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void clear1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clear1ActionPerformed
      clear();
    }//GEN-LAST:event_clear1ActionPerformed

    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked
        int i = tabela.getSelectedRow();
        TableModel model = tabela.getModel();
        barkodi.setText(model.getValueAt(i, 1).toString());
        emriProd.setText(model.getValueAt(i, 2).toString());
        qmimi.setText(model.getValueAt(i, 3).toString());
        sasia.setText(model.getValueAt(i, 4).toString());
    }//GEN-LAST:event_tabelaMouseClicked

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
       String query="insert into stoku(barkodi,emriIProduktit,qmimi,sasia) values('"+barkodi.getText()+"','"+emriProd.getText()+"','"+qmimi.getText()+"','"+sasia.getText()+"')";
       if( barkodi.getText().isEmpty() ||
                    emriProd.getText().isEmpty() || qmimi.getText().isEmpty() || sasia.getText().isEmpty()){
                    JOptionPane.showMessageDialog(this, 
                        "Te gjitha fushat duhet te plotesohen ", "Error", JOptionPane.WARNING_MESSAGE);
                    return;
             }
       ekzekutoSQLQuery(query,"insertua");
    }//GEN-LAST:event_addActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        /*  JFrame frame = new JFrame("Delete product");
           int id = Integer.parseInt( JOptionPane.showInputDialog(frame, "Shtypni id e produktit qe deshironi te fshini"));
           */
        
        String [] options1 = {"Ok","Cancel"};
        JPanel panel = new JPanel();
        JLabel lb1 = new JLabel("Shkruani id e produktit qe deshironi te fshini nga stoku?");
        JTextField txt = new JTextField(10);
        panel.add(lb1);
        panel.add(txt);
        
        int selectedOption = JOptionPane.showOptionDialog(null, panel, "Delete product",
                JOptionPane.NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options1, options1[1]);
        
        String text = txt.getText();
        int n = Integer.parseInt(text);
       
        
        
            String sql = "select stokuID from stoku";
            String query="delete from stoku where stokuID='"+n+"'";
            
           try{
              st=con.createStatement();
              rs=st.executeQuery(sql);
              
              //pst=con.prepareStatement(query);
             // pst.executeUpdate();
             
               try {
                    
                     
                   
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(this, e);
               }
            
            while(rs.next()){  
                int value = rs.getInt("stokuID"); 
              
                if(selectedOption==0){
                        if(n==value){
                         Object [] options = {"PO","JO"};
                         int n1 = JOptionPane.showOptionDialog(this, "A jeni i sigurt qe deshironi ta fshini kete produkt",
                        "Delete", JOptionPane.YES_NO_OPTION,
                         JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
                         if(n1==0){
                             st.executeUpdate(query);
                            DefaultTableModel model = (DefaultTableModel)tabela.getModel();
                           model.setRowCount(0);
                           ShfaqListenEProd();
                           JOptionPane.showMessageDialog(this, "Produkti me kete id u fshi nga stoku","Error",JOptionPane.INFORMATION_MESSAGE);
                           clear(); 
                         }else if(n1==1){
                              JOptionPane.showMessageDialog(this, "Produkti me kete id nuk fshi nga stoku","Error",JOptionPane.INFORMATION_MESSAGE);
                            return;
                         }
                        
                    }else if(n!=value){
                        JOptionPane.showMessageDialog(this, "Produkti me kete id nuk ekziston ne stok","Error",JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }
                
            }
        }catch(SQLException e){
           JOptionPane.showMessageDialog(this, e);
        }
       
            /*if(barkodi.getText().isEmpty() ||
                    emriProd.getText().isEmpty() || qmimi.getText().isEmpty() || sasia.getText().isEmpty()){
                    JOptionPane.showMessageDialog(this, 
                        "Zgjedhni nga lista cilin produkt deshironi ta fshini", "Error", JOptionPane.WARNING_MESSAGE);
                    return;
              }*/ 
            
    }//GEN-LAST:event_deleteActionPerformed

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        JFrame frame = new JFrame("Update product");
           int id = Integer.parseInt( JOptionPane.showInputDialog(frame, "Shtypni id e produktit qe deshironi ta ndryshoni")); 
        
        String query="update stoku set barkodi='"+barkodi.getText()+"', emriIProduktit='"+emriProd.getText()+"', qmimi='"+qmimi.getText()+"', sasia="+sasia.getText()+" where  stokuID='"+id+"'";
        
        if(barkodi.getText().isEmpty() ||
                    emriProd.getText().isEmpty() || qmimi.getText().isEmpty() || sasia.getText().isEmpty()){
                    JOptionPane.showMessageDialog(this, 
                        "Zgjedhni cilin produkt deshironi ta editoni nga lista", 
                        "Error", JOptionPane.WARNING_MESSAGE);
                        return;
            }
        ekzekutoSQLQuery(query,"editua");
    }//GEN-LAST:event_editActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        findProduktet();
         if(search.getText().isEmpty()){
             ShfaqListenEProd();
                JOptionPane.showMessageDialog(this, "Shtypni id ose barkodin e produktit qe po kerkoni",
                        "Warning",JOptionPane.WARNING_MESSAGE);
                         
                    }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyReleased
        if(search.getText().isEmpty()){
           search.setBackground(Color.WHITE);
           DefaultTableModel model = (DefaultTableModel)tabela.getModel();
           model.setRowCount(0);
                ShfaqListenEProd();
           
       }else {
           search.setBackground(Color.GRAY);
       }
    }//GEN-LAST:event_searchKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        MessageFormat header = new MessageFormat("Produktet e stokut te printuara");
            MessageFormat footer  = new MessageFormat("Page{0,number,integer}");
        
        try {
                    tabela.print(JTable.PrintMode.FIT_WIDTH, header, footer);
                
        } catch (java.awt.print.PrinterException e) {
            System.err.format("Cannot print %s%n ", e);
        }
      
    }//GEN-LAST:event_jButton1ActionPerformed

    private void emriProdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_emriProdKeyTyped
       char c = evt.getKeyChar();
            if((c<'a' || c>'z') && (c<'A' || c>'Z') && (c!=(char)KeyEvent.VK_BACKSPACE) 
                    && (c!=(char)KeyEvent.VK_SPACE)){
                evt.consume();
                JOptionPane.showMessageDialog(this, "Pranon vetem tekst","Warning"
                        ,JOptionPane.WARNING_MESSAGE);
                
            }
    }//GEN-LAST:event_emriProdKeyTyped

    private void searchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyTyped
       char c = evt.getKeyChar();
            if((c<'0' || c>'9')  && (c!=(char)KeyEvent.VK_BACKSPACE) 
                    && (c!=(char)KeyEvent.VK_SPACE)){
                evt.consume();
                JOptionPane.showMessageDialog(this, "Pranon vetem numer","Warning"
                        ,JOptionPane.WARNING_MESSAGE);
                
            }
    }//GEN-LAST:event_searchKeyTyped

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String query="select sum(sasia) 'Sum' from stoku as sum";
        try {
            pst=con.prepareCall(query);
            rs=pst.executeQuery();
            while(rs.next()){
                totalProd.setText(rs.getString("sum"));
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
         String query="select sum(qmimi) 'Sum' from stoku as sum";
        try {
            pst=con.prepareCall(query);
            rs=pst.executeQuery();
            while(rs.next()){
                qmimiTotal.setText(rs.getString("sum")+"€");
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JTextField barkodi;
    private javax.swing.JButton clear1;
    private javax.swing.JButton delete;
    private javax.swing.JButton edit;
    private javax.swing.JTextField emriProd;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTextField qmimi;
    private javax.swing.JLabel qmimiTotal;
    private javax.swing.JTextField sasia;
    private javax.swing.JTextField search;
    private javax.swing.JTable tabela;
    private javax.swing.JLabel totalProd;
    // End of variables declaration//GEN-END:variables
}
