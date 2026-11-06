
package cite_lostandfounddepartment_system;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import java.text.SimpleDateFormat;


public class admin_claims extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(admin_claims.class.getName());
    
    private int AdminUserId;
    private String AdminFullName;
    
            private void colorStatusColumn() {

        tblClaims.getColumnModel().getColumn(4).setCellRenderer(new DefaultTableCellRenderer() {

            @Override
            public java.awt.Component getTableCellRendererComponent(javax.swing.JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

                java.awt.Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                cell.setBackground(java.awt.Color.WHITE);
                cell.setForeground(java.awt.Color.BLACK);
                cell.setFont(new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 18));

                if ("Claimed".equals(value)) {

                    cell.setBackground(new java.awt.Color(120, 220, 120));
                    cell.setForeground(java.awt.Color.BLACK);
                    cell.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 18));

                } else if ("Pending".equals(value)) {

                    cell.setBackground(new java.awt.Color(190, 225, 120));
                    cell.setForeground(java.awt.Color.BLACK);
                    cell.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 18));

                } else if ("Rejected".equals(value)) {

                    cell.setBackground(new java.awt.Color(102, 102, 102));
                    cell.setForeground(java.awt.Color.BLACK);
                    cell.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 18));
                
                } else if ("Returned".equals(value)) {

                    cell.setBackground(new java.awt.Color(153,204,255));
                    cell.setForeground(java.awt.Color.BLACK);
                    cell.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 18));
                }

                return cell;
            }
        }
    );
}
    
    
    
    public admin_claims(int userId, String fullName) {
        initComponents();
        
        this.AdminUserId = userId;
        this.AdminFullName = fullName;
        
        setResizable(true);
        setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        
        
        loadClaims();
        colorStatusColumn();
    }
    
 
   


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel17 = new javax.swing.JPanel();
        btnHome = new javax.swing.JButton();
        btnViewLostItems = new javax.swing.JButton();
        btnLogout4 = new javax.swing.JButton();
        btnViewFoundItems = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        btnClaims = new javax.swing.JButton();
        btnUsers = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        btnReports = new javax.swing.JButton();
        btnProfile = new javax.swing.JButton();
        jPanel20 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblClaims = new javax.swing.JTable();
        txtSearch = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cmbStatus = new javax.swing.JComboBox<>();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel17.setBackground(new java.awt.Color(0, 102, 102));
        jPanel17.setAutoscrolls(true);

        btnHome.setBackground(new java.awt.Color(0, 100, 100));
        btnHome.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        btnHome.setForeground(new java.awt.Color(255, 255, 255));
        btnHome.setIcon(new javax.swing.ImageIcon("C:\\Users\\abbyg\\OneDrive\\Pictures\\icons\\home.png")); // NOI18N
        btnHome.setText("Dashboard");
        btnHome.setBorder(null);
        btnHome.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnHome.addActionListener(this::btnHomeActionPerformed);

        btnViewLostItems.setBackground(new java.awt.Color(0, 102, 102));
        btnViewLostItems.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        btnViewLostItems.setForeground(new java.awt.Color(255, 255, 255));
        btnViewLostItems.setIcon(new javax.swing.ImageIcon("C:\\Users\\abbyg\\OneDrive\\Pictures\\icons\\view lost items.png")); // NOI18N
        btnViewLostItems.setText("Lost Items");
        btnViewLostItems.setBorder(null);
        btnViewLostItems.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnViewLostItems.addActionListener(this::btnViewLostItemsActionPerformed);

        btnLogout4.setBackground(new java.awt.Color(0, 102, 102));
        btnLogout4.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        btnLogout4.setForeground(new java.awt.Color(255, 255, 255));
        btnLogout4.setIcon(new javax.swing.ImageIcon("C:\\Users\\abbyg\\OneDrive\\Pictures\\icons\\logout.png")); // NOI18N
        btnLogout4.setText("Logout");
        btnLogout4.setBorder(null);
        btnLogout4.addActionListener(this::btnLogout4ActionPerformed);

        btnViewFoundItems.setBackground(new java.awt.Color(0, 102, 102));
        btnViewFoundItems.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        btnViewFoundItems.setForeground(new java.awt.Color(255, 255, 255));
        btnViewFoundItems.setIcon(new javax.swing.ImageIcon("C:\\Users\\abbyg\\OneDrive\\Pictures\\icons\\view found items.png")); // NOI18N
        btnViewFoundItems.setText("Found Items");
        btnViewFoundItems.setBorder(null);
        btnViewFoundItems.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnViewFoundItems.addActionListener(this::btnViewFoundItemsActionPerformed);

        jSeparator2.setForeground(new java.awt.Color(114, 191, 191));

        btnClaims.setBackground(new java.awt.Color(0, 102, 102));
        btnClaims.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        btnClaims.setForeground(new java.awt.Color(255, 255, 255));
        btnClaims.setIcon(new javax.swing.ImageIcon("C:\\Users\\abbyg\\OneDrive\\Pictures\\icons\\view found items.png")); // NOI18N
        btnClaims.setText("Claims");
        btnClaims.setBorder(null);
        btnClaims.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnClaims.addActionListener(this::btnClaimsActionPerformed);

        btnUsers.setBackground(new java.awt.Color(0, 102, 102));
        btnUsers.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        btnUsers.setForeground(new java.awt.Color(255, 255, 255));
        btnUsers.setIcon(new javax.swing.ImageIcon("C:\\Users\\abbyg\\OneDrive\\Pictures\\icons\\users.png")); // NOI18N
        btnUsers.setText("Users");
        btnUsers.setBorder(null);
        btnUsers.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnUsers.addActionListener(this::btnUsersActionPerformed);

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setIcon(new javax.swing.ImageIcon("C:\\Users\\abbyg\\OneDrive\\Pictures\\icons\\system logo dashboard.png")); // NOI18N

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("CITE DEPARTMENT");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("<html><center>LOST AND FOUND<br>MANAGEMENT SYSTEM</center></html>\n");

        btnReports.setBackground(new java.awt.Color(0, 102, 102));
        btnReports.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        btnReports.setForeground(new java.awt.Color(255, 255, 255));
        btnReports.setIcon(new javax.swing.ImageIcon("C:\\Users\\abbyg\\OneDrive\\Pictures\\icons\\claims.png")); // NOI18N
        btnReports.setText("Reports");
        btnReports.setBorder(null);
        btnReports.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnReports.addActionListener(this::btnReportsActionPerformed);

        btnProfile.setBackground(new java.awt.Color(0, 102, 102));
        btnProfile.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        btnProfile.setForeground(new java.awt.Color(255, 255, 255));
        btnProfile.setIcon(new javax.swing.ImageIcon("C:\\Users\\abbyg\\OneDrive\\Pictures\\icons\\claims.png")); // NOI18N
        btnProfile.setText("Profile");
        btnProfile.setBorder(null);
        btnProfile.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnProfile.addActionListener(this::btnProfileActionPerformed);

        jPanel20.setBackground(new java.awt.Color(204, 255, 255));

        jLabel8.setBackground(new java.awt.Color(124, 249, 249));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("REVIEW CLAIMS");
        jLabel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel8.setOpaque(true);

        tblClaims.setBackground(new java.awt.Color(255, 255, 255));
        tblClaims.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        tblClaims.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tblClaims.setForeground(new java.awt.Color(0, 0, 0));
        tblClaims.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Claimant Name", "Item Name", "Claim Date", "Status"
            }
        ));
        tblClaims.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tblClaims.setGridColor(new java.awt.Color(0, 0, 0));
        tblClaims.setRowHeight(80);
        tblClaims.setShowGrid(true);
        jScrollPane4.setViewportView(tblClaims);
        tblClaims.getTableHeader().setBackground(new java.awt.Color(124,249,249));
        tblClaims.getTableHeader().setFont(
            new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 18)
        );

        txtSearch.setBackground(new java.awt.Color(255, 255, 255));
        txtSearch.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtSearch.setForeground(new java.awt.Color(0, 0, 0));
        txtSearch.setText("Search item...");
        txtSearch.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtSearch.addActionListener(this::txtSearchActionPerformed);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Search:");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Status:");

        cmbStatus.setBackground(new java.awt.Color(255, 255, 255));
        cmbStatus.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cmbStatus.setForeground(new java.awt.Color(0, 0, 0));
        cmbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All Status", "Pending", "Claimed", "Rejected", " " }));
        cmbStatus.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cmbStatus.addActionListener(this::cmbStatusActionPerformed);

        jButton12.setBackground(new java.awt.Color(153, 204, 255));
        jButton12.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jButton12.setForeground(new java.awt.Color(0, 0, 0));
        jButton12.setText("Search");
        jButton12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton12.addActionListener(this::jButton12ActionPerformed);

        jButton13.setBackground(new java.awt.Color(102, 255, 153));
        jButton13.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jButton13.setForeground(new java.awt.Color(0, 0, 0));
        jButton13.setText("APPROVE");
        jButton13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton13.addActionListener(this::jButton13ActionPerformed);

        jButton14.setBackground(new java.awt.Color(255, 102, 102));
        jButton14.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jButton14.setForeground(new java.awt.Color(0, 0, 0));
        jButton14.setText("REJECT");
        jButton14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton14.addActionListener(this::jButton14ActionPerformed);

        jButton15.setBackground(new java.awt.Color(153, 204, 255));
        jButton15.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jButton15.setForeground(new java.awt.Color(0, 0, 0));
        jButton15.setText("MARKED RETURNED");
        jButton15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton15.addActionListener(this::jButton15ActionPerformed);

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txtSearch))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(cmbStatus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(111, 111, 111))
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(209, Short.MAX_VALUE))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47))
        );

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnProfile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnViewLostItems, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnHome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jSeparator2)
                                .addComponent(btnLogout4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel14)
                                .addComponent(btnReports, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(btnUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnViewFoundItems, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnClaims, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnViewLostItems, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnViewFoundItems, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnClaims, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnReports, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLogout4, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jPanel20, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        admin_homepage home = new admin_homepage(AdminUserId, AdminFullName);
        home.setLocationRelativeTo(null);
        home.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnHomeActionPerformed

    private void btnViewLostItemsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewLostItemsActionPerformed
        admin_lost_items lost = new admin_lost_items(AdminUserId, AdminFullName);
        lost.setLocationRelativeTo(null);
        lost.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnViewLostItemsActionPerformed

    private void btnLogout4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogout4ActionPerformed
        login loginPage = new login();
        loginPage.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnLogout4ActionPerformed

    private void btnViewFoundItemsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewFoundItemsActionPerformed
        admin_found_items found = new admin_found_items(AdminUserId, AdminFullName);
        found.setLocationRelativeTo(null);
        found.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnViewFoundItemsActionPerformed

    private void btnClaimsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClaimsActionPerformed
        admin_claims claims = new admin_claims(AdminUserId, AdminFullName);
        claims.setLocationRelativeTo(null);
        claims.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnClaimsActionPerformed

    private void btnUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsersActionPerformed
        admin_users users = new admin_users(AdminUserId, AdminFullName);
        users.setLocationRelativeTo(null);
        users.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnUsersActionPerformed

    private void btnReportsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportsActionPerformed
        admin_reports reports = new admin_reports(AdminUserId, AdminFullName);
        reports.setLocationRelativeTo(null);
        reports.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnReportsActionPerformed

    private void btnProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProfileActionPerformed
        admin_profile profile = new admin_profile(AdminUserId, AdminFullName);
        profile.setLocationRelativeTo(null);
        profile.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnProfileActionPerformed

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    private void cmbStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbStatusActionPerformed
        loadClaims();
        }

        private void loadClaims() {

            String selectedStatus = cmbStatus.getSelectedItem().toString();

            String sql = "SELECT c.claim_id, "
            + "c.claimant_name, "
            + "f.item_name, "
            + "c.claim_date, "
            + "c.status "
            + "FROM tbl_claims c "
            + "LEFT JOIN tbl_found_items f "
            + "ON c.found_id = f.found_id ";

            // Only add WHERE when a specific status is selected
            if (!selectedStatus.equals("All Status")) {
                sql += "WHERE c.status = ? ";
            }

            sql += "ORDER BY c.claim_id DESC";

            try {

                Connection conn = DBConnection.connect();
                PreparedStatement pst = conn.prepareStatement(sql);

                // Set status parameter only when WHERE is used
                if (!selectedStatus.equals("All Status")) {
                    pst.setString(1, selectedStatus);
                }

                ResultSet rs = pst.executeQuery();

                javax.swing.table.DefaultTableModel model =
                (javax.swing.table.DefaultTableModel) tblClaims.getModel();

                // Clear existing rows
                model.setRowCount(0);

                while (rs.next()) {

                    int claimId = rs.getInt("claim_id");

                    String claimantName =
                    rs.getString("claimant_name");

                    String itemName =
                    rs.getString("item_name");

                    String claimDate = "";

                    if (rs.getDate("claim_date") != null) {

                        java.text.SimpleDateFormat dateFormat =
                        new java.text.SimpleDateFormat("MM/dd/yyyy");

                        claimDate =
                        dateFormat.format(rs.getDate("claim_date"));
                    }

                    String status =
                    rs.getString("status");

                    model.addRow(new Object[]{
                        claimId,
                        claimantName,
                        itemName,
                        claimDate,
                        status
                    });
                }

                rs.close();
                pst.close();
                conn.close();

            } catch (SQLException e) {

                JOptionPane.showMessageDialog(
                    this,
                    "Database Error: " + e.getMessage(),
                    "Database Error",
                    JOptionPane.ERROR_MESSAGE
                );
            }
    }//GEN-LAST:event_cmbStatusActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        String searchText = txtSearch.getText().trim();

        String sql = "SELECT c.claim_id, "
        + "c.claimant_name, "
        + "f.item_name, "
        + "c.claim_date, "
        + "c.status "
        + "FROM tbl_claims c "
        + "LEFT JOIN tbl_found_items f "
        + "ON c.found_id = f.found_id "
        + "WHERE f.item_name LIKE ? "
        + "OR c.claimant_name LIKE ? "
        + "ORDER BY c.claim_id DESC";

        try {

            Connection conn = DBConnection.connect();
            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setString(1, "%" + searchText + "%");
            pst.setString(2, "%" + searchText + "%");

            ResultSet rs = pst.executeQuery();

            DefaultTableModel model =
            (DefaultTableModel) tblClaims.getModel();

            model.setRowCount(0);

            while (rs.next()) {

                int claimId = rs.getInt("claim_id");
                String claimantName = rs.getString("claimant_name");
                String itemName = rs.getString("item_name");

                String claimDate = "";

                if (rs.getDate("claim_date") != null) {
                    SimpleDateFormat dateFormat =
                    new SimpleDateFormat("MM/dd/yyyy");

                    claimDate =
                    dateFormat.format(rs.getDate("claim_date"));
                }

                String status = rs.getString("status");

                model.addRow(new Object[]{
                    claimId,
                    claimantName,
                    itemName,
                    claimDate,
                    status
                });
            }

            rs.close();
            pst.close();
            conn.close();

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(
                this,
                "Database Error: " + e.getMessage(),
                "Database Error",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        int selectedRow = tblClaims.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a claim first.", "No Claim Selected",JOptionPane.WARNING_MESSAGE);

            return;
        }

        int claimId = Integer.parseInt(tblClaims.getValueAt(selectedRow, 0).toString());

        String sql = "UPDATE tbl_claims SET status = 'Approved' "
        + "WHERE claim_id = ?";

        try {
            Connection conn = DBConnection.connect();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, claimId);
            pst.executeUpdate();
            pst.close();

            conn.close();
            JOptionPane.showMessageDialog(this, "Claim approved successfully.");

            loadClaims();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Database Error: " + e.getMessage(), "Database Error",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        int selectedRow = tblClaims.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a claim first.", "No Claim Selected", JOptionPane.WARNING_MESSAGE);
            return;

        }

        int claimId = Integer.parseInt(tblClaims.getValueAt(selectedRow, 0).toString());

        String sql = "UPDATE tbl_claims SET status = 'Rejected' "
        + "WHERE claim_id = ?";

        try {
            Connection conn = DBConnection.connect();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, claimId);
            pst.executeUpdate();
            pst.close();
            conn.close();
            JOptionPane.showMessageDialog(this, "Claim rejected.");

            loadClaims();

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(this, "Database Error: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        int selectedRow = tblClaims.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a claim first.", "No Claim Selected", JOptionPane.WARNING_MESSAGE);
            return;

        }

        int claimId = Integer.parseInt(tblClaims.getValueAt(selectedRow, 0).toString());

        String sql = "UPDATE tbl_claims SET status = 'Returned' "
        + "WHERE claim_id = ?";

        try {
            Connection conn = DBConnection.connect();
            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setInt(1, claimId);
            pst.executeUpdate();
            pst.close();

            conn.close();

            JOptionPane.showMessageDialog(this, "Claim marked as returned.");
            loadClaims();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Database Error: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton15ActionPerformed


    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> {
            new admin_claims(1, "Admin").setVisible(true);
    });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClaims;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnLogout4;
    private javax.swing.JButton btnProfile;
    private javax.swing.JButton btnReports;
    private javax.swing.JButton btnUsers;
    private javax.swing.JButton btnViewFoundItems;
    private javax.swing.JButton btnViewLostItems;
    private javax.swing.JComboBox<String> cmbStatus;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable tblClaims;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
