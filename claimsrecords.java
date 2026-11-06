
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


public class claimsrecords extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(claimsrecords.class.getName());
    
        private int studentUserId;
        private final String url = "jdbc:mysql://localhost:3306/cite_lostandfounddepartment_system";
        private final String dbUser = "root";
        private final String dbPassword = "";
        
        private void colorStatusColumn() {

        tblMyClaims.getColumnModel().getColumn(3).setCellRenderer(new DefaultTableCellRenderer() {

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

                    cell.setBackground(new java.awt.Color(255,102,102));
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


    public claimsrecords(int userId) {
        initComponents();
        
        tblMyClaims.getTableHeader().setBackground(new java.awt.Color(114, 191, 191));
        tblMyClaims.getTableHeader().setForeground(new java.awt.Color(0, 51, 51));
        tblMyClaims.getTableHeader().setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 16));
        
        this.studentUserId = userId;
        setLocationRelativeTo(null);
        loadMyClaims();
        colorStatusColumn();
        
    }
    
    private void loadMyClaims() {
        javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel)
            tblMyClaims.getModel();
        
        model.setRowCount(0);
        String sql =
                "SELECT c.claim_id, f.item_name, c.claim_date, c.status "
                + "FROM tbl_claims c "
                + "LEFT JOIN tbl_found_items f "
                + "ON c.found_id = f.found_id "
                + "WHERE c.student_user_id = ? "
                + "ORDER BY c.claim_date DESC";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (java.sql.Connection con = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/cite_lostandfounddepartment_system","root", "");
             java.sql.PreparedStatement pst = con.prepareStatement(sql)) {
                
            pst.setInt(1, studentUserId);
            System.out.println("Loading claims for user ID: " + studentUserId);
            try (java.sql.ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    model.addRow(new Object[] {
                        rs.getInt("claim_id"),
                        rs.getString("item_name"),
                        rs.getDate("claim_date"),
                        rs.getString("status")
                    });
                }
            }
        }

    } catch (Exception e) {
        javax.swing.JOptionPane.showMessageDialog(this,"Unable to load claims: " + e.getMessage(),"Database Error",javax.swing.JOptionPane.ERROR_MESSAGE);
        e.printStackTrace();
    }

}

    


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnHome = new javax.swing.JButton();
        btnViewLostItems = new javax.swing.JButton();
        btnMyClaims = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMyClaims = new javax.swing.JTable();
        btnRefresh = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnViewFoundItems = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        btnReportLostItem1 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        btnReportFoundItem1 = new javax.swing.JButton();
        btnProfile = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(21, 82, 82));

        btnHome.setBackground(new java.awt.Color(21, 82, 82));
        btnHome.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        btnHome.setForeground(new java.awt.Color(255, 255, 255));
        btnHome.setIcon(new javax.swing.ImageIcon("C:\\Users\\abbyg\\OneDrive\\Pictures\\icons\\home.png")); // NOI18N
        btnHome.setText("Dashboard");
        btnHome.setBorder(null);
        btnHome.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnHome.addActionListener(this::btnHomeActionPerformed);

        btnViewLostItems.setBackground(new java.awt.Color(21, 82, 82));
        btnViewLostItems.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        btnViewLostItems.setForeground(new java.awt.Color(255, 255, 255));
        btnViewLostItems.setIcon(new javax.swing.ImageIcon("C:\\Users\\abbyg\\OneDrive\\Pictures\\icons\\view lost items.png")); // NOI18N
        btnViewLostItems.setText("View Lost Items");
        btnViewLostItems.setBorder(null);
        btnViewLostItems.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnViewLostItems.addActionListener(this::btnViewLostItemsActionPerformed);

        btnMyClaims.setBackground(new java.awt.Color(21, 82, 82));
        btnMyClaims.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        btnMyClaims.setForeground(new java.awt.Color(255, 255, 255));
        btnMyClaims.setIcon(new javax.swing.ImageIcon("C:\\Users\\abbyg\\OneDrive\\Pictures\\icons\\claims.png")); // NOI18N
        btnMyClaims.setText("My Claims");
        btnMyClaims.setBorder(null);
        btnMyClaims.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnMyClaims.addActionListener(this::btnMyClaimsActionPerformed);

        btnLogout.setBackground(new java.awt.Color(21, 82, 82));
        btnLogout.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        btnLogout.setForeground(new java.awt.Color(255, 255, 255));
        btnLogout.setIcon(new javax.swing.ImageIcon("C:\\Users\\abbyg\\OneDrive\\Pictures\\icons\\logout.png")); // NOI18N
        btnLogout.setText("Logout");
        btnLogout.setBorder(null);
        btnLogout.addActionListener(this::btnLogoutActionPerformed);

        jPanel6.setBackground(new java.awt.Color(204, 255, 255));

        jLabel37.setBackground(new java.awt.Color(124, 249, 249));
        jLabel37.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(0, 0, 0));
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setText("MY CLAIMS");
        jLabel37.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel37.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel37.setOpaque(true);

        tblMyClaims.setBackground(new java.awt.Color(255, 255, 255));
        tblMyClaims.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        tblMyClaims.setForeground(new java.awt.Color(0, 0, 0));
        tblMyClaims.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1", "item", "date", null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Claim ID", "Item Name", "Date Submitted", "Status"
            }
        ));
        tblMyClaims.setGridColor(new java.awt.Color(0, 0, 0));
        tblMyClaims.setRowHeight(70);
        tblMyClaims.setShowGrid(true);
        jScrollPane1.setViewportView(tblMyClaims);
        if (tblMyClaims.getColumnModel().getColumnCount() > 0) {
            tblMyClaims.getColumnModel().getColumn(0).setMinWidth(1);
            tblMyClaims.getColumnModel().getColumn(0).setPreferredWidth(1);
            tblMyClaims.getColumnModel().getColumn(1).setPreferredWidth(100);
            tblMyClaims.getColumnModel().getColumn(2).setPreferredWidth(10);
            tblMyClaims.getColumnModel().getColumn(3).setPreferredWidth(10);
        }

        btnRefresh.setBackground(new java.awt.Color(124, 249, 249));
        btnRefresh.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        btnRefresh.setForeground(new java.awt.Color(0, 0, 0));
        btnRefresh.setText("Refresh");
        btnRefresh.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        btnRefresh.addActionListener(this::btnRefreshActionPerformed);

        jLabel1.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("My Claim Records");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap(34, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(832, 832, 832)
                                .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1050, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74)
                .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        btnViewFoundItems.setBackground(new java.awt.Color(21, 82, 82));
        btnViewFoundItems.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        btnViewFoundItems.setForeground(new java.awt.Color(255, 255, 255));
        btnViewFoundItems.setIcon(new javax.swing.ImageIcon("C:\\Users\\abbyg\\OneDrive\\Pictures\\icons\\view found items.png")); // NOI18N
        btnViewFoundItems.setText("View Found Items");
        btnViewFoundItems.setBorder(null);
        btnViewFoundItems.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnViewFoundItems.addActionListener(this::btnViewFoundItemsActionPerformed);

        jSeparator2.setForeground(new java.awt.Color(114, 191, 191));

        btnReportLostItem1.setBackground(new java.awt.Color(21, 82, 82));
        btnReportLostItem1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        btnReportLostItem1.setForeground(new java.awt.Color(255, 255, 255));
        btnReportLostItem1.setText(" + Report Lost Item");
        btnReportLostItem1.setBorder(null);
        btnReportLostItem1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnReportLostItem1.addActionListener(this::btnReportLostItem1ActionPerformed);

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

        btnReportFoundItem1.setBackground(new java.awt.Color(21, 82, 82));
        btnReportFoundItem1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        btnReportFoundItem1.setForeground(new java.awt.Color(255, 255, 255));
        btnReportFoundItem1.setText(" + Report Found Item");
        btnReportFoundItem1.setBorder(null);
        btnReportFoundItem1.setHideActionText(true);
        btnReportFoundItem1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnReportFoundItem1.addActionListener(this::btnReportFoundItem1ActionPerformed);

        btnProfile.setBackground(new java.awt.Color(21, 82, 82));
        btnProfile.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        btnProfile.setForeground(new java.awt.Color(255, 255, 255));
        btnProfile.setIcon(new javax.swing.ImageIcon("C:\\Users\\abbyg\\OneDrive\\Pictures\\icons\\claims.png")); // NOI18N
        btnProfile.setText("Profile");
        btnProfile.setBorder(null);
        btnProfile.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnProfile.addActionListener(this::btnProfileActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnViewFoundItems, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnViewLostItems, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnReportFoundItem1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnHome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnReportLostItem1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLogout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMyClaims, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnProfile, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel13)
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addGap(13, 13, 13)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReportLostItem1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReportFoundItem1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnViewLostItems, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnViewFoundItems, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMyClaims, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(btnProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        homeframe home = new homeframe(studentUserId);
        home.setLocationRelativeTo(null);
        home.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnHomeActionPerformed

    private void btnViewLostItemsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewLostItemsActionPerformed
       viewlostitems viewlostItemsPage = new viewlostitems(studentUserId);
       viewlostItemsPage.setLocationRelativeTo(this);
       viewlostItemsPage.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_btnViewLostItemsActionPerformed

    private void btnMyClaimsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMyClaimsActionPerformed
        claimsrecords claimsPage = new claimsrecords(studentUserId);
        claimsPage.setLocationRelativeTo(this);
        claimsPage.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnMyClaimsActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        login loginPage = new login();
        loginPage.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnViewFoundItemsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewFoundItemsActionPerformed
       viewfounditems viewfoundItemsPage = new viewfounditems(studentUserId);
       viewfoundItemsPage.setLocationRelativeTo(this);
       viewfoundItemsPage.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_btnViewFoundItemsActionPerformed

    private void btnReportLostItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportLostItem1ActionPerformed
        reportlostitemsframe reportlostItems = new reportlostitemsframe(studentUserId);
        reportlostItems.setLocationRelativeTo(this);
        reportlostItems.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnReportLostItem1ActionPerformed

    private void btnReportFoundItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportFoundItem1ActionPerformed
        reportfounditem reportfoundItem = new reportfounditem(studentUserId);
        reportfoundItem.setLocationRelativeTo(this);
        reportfoundItem.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnReportFoundItem1ActionPerformed

    private void btnProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProfileActionPerformed
        profileframe profile = new profileframe(studentUserId);
        profile.setLocationRelativeTo(this);
        profile.setVisible(true);
    }//GEN-LAST:event_btnProfileActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
            loadMyClaims();
    }//GEN-LAST:event_btnRefreshActionPerformed
    
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            javax.swing.JOptionPane.showMessageDialog(null,"Please open My Claims through the Student Dashboard.");
    });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnMyClaims;
    private javax.swing.JButton btnProfile;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnReportFoundItem1;
    private javax.swing.JButton btnReportLostItem1;
    private javax.swing.JButton btnViewFoundItems;
    private javax.swing.JButton btnViewLostItems;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable tblMyClaims;
    // End of variables declaration//GEN-END:variables
}
