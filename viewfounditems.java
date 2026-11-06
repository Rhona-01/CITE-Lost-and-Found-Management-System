
package cite_lostandfounddepartment_system;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class viewfounditems extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(viewfounditems.class.getName());
    private int studentUserId;


    public viewfounditems(int userId) {
        initComponents();
        
        this.studentUserId = userId;
        setLocationRelativeTo(null);
        
            foundItemsTable.getTableHeader().setBackground(new java.awt.Color(114, 191, 191));
            foundItemsTable.getTableHeader().setForeground(new java.awt.Color(0, 51, 51));
            foundItemsTable.getTableHeader().setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 18));
            
                    javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) foundItemsTable.getModel();
        model.setColumnIdentifiers(new Object[]{
        "found_id",
        "Item Name",
        "Category",
        "Location Found",
        "Date Found",
        "Status"
    });

    loadFoundItems();

    hideFoundIdColumn();
    
        colorStatusColumn();
        
        
    }
    private void loadFoundItems() {

       javax.swing.table.DefaultTableModel model =
            (javax.swing.table.DefaultTableModel) foundItemsTable.getModel();

    model.setRowCount(0);

    String sql =
            "SELECT found_id, item_name, category, "
            + "location_found, date_found, status "
            + "FROM tbl_found_items "
            + "ORDER BY found_id DESC";

    try {

        Connection conn = DBConnection.connect();
        java.sql.PreparedStatement pst = conn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            int foundId = rs.getInt("found_id");
            
            String itemName = rs.getString("item_name");
            String category = rs.getString("category");
            String locationFound = rs.getString("location_found");
            String dateFound = "";
            
            if (rs.getDate("date_found") != null) {
                java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("MM/dd/yyyy");

                dateFound = dateFormat.format(rs.getDate("date_Found"));
            }

            String status = rs.getString("status");

            model.addRow(new Object[]{
                foundId,
                itemName,
                category,
                locationFound,
                dateFound,
                status
            });
        }

        rs.close();
        pst.close();
        conn.close();

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Database Error: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
    }
    }
    private void colorStatusColumn() {

        int statusModelColumn = 5;
        int statusViewColumn = foundItemsTable.convertColumnIndexToView(statusModelColumn);
        if (statusViewColumn == -1) {
        return;
    }
        foundItemsTable.getColumnModel()
            .getColumn(statusViewColumn)
            .setCellRenderer(new javax.swing.table.DefaultTableCellRenderer() {

        @Override
        public java.awt.Component getTableCellRendererComponent(javax.swing.JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            java.awt.Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            String status = value == null ? "" : value.toString();

            if (status.equalsIgnoreCase("Found")) {
                component.setBackground(new java.awt.Color(0,204,153));
                component.setForeground(new java.awt.Color(0, 0, 0));
                component.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 18));

            } else {
                component.setBackground(new java.awt.Color(21, 82, 82));
                component.setForeground(java.awt.Color.WHITE);
            }
            return component;
        }
    });
}
        
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnHome = new javax.swing.JButton();
        btnViewLostItems = new javax.swing.JButton();
        btnClaimsRecords = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        btnViewFoundItems = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        btnReportLostItem1 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        btnReportFoundItem1 = new javax.swing.JButton();
        btnProfile = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        btnReportFoundItem3 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        foundItemsTable = new javax.swing.JTable();
        btbViewItem1 = new javax.swing.JButton();

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

        btnClaimsRecords.setBackground(new java.awt.Color(21, 82, 82));
        btnClaimsRecords.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        btnClaimsRecords.setForeground(new java.awt.Color(255, 255, 255));
        btnClaimsRecords.setIcon(new javax.swing.ImageIcon("C:\\Users\\abbyg\\OneDrive\\Pictures\\icons\\claims.png")); // NOI18N
        btnClaimsRecords.setText("My Claims");
        btnClaimsRecords.setBorder(null);
        btnClaimsRecords.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnClaimsRecords.addActionListener(this::btnClaimsRecordsActionPerformed);

        btnLogout.setBackground(new java.awt.Color(21, 82, 82));
        btnLogout.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        btnLogout.setForeground(new java.awt.Color(255, 255, 255));
        btnLogout.setIcon(new javax.swing.ImageIcon("C:\\Users\\abbyg\\OneDrive\\Pictures\\icons\\logout.png")); // NOI18N
        btnLogout.setText("Logout");
        btnLogout.setBorder(null);
        btnLogout.addActionListener(this::btnLogoutActionPerformed);

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

        jPanel8.setBackground(new java.awt.Color(204, 255, 255));

        jLabel37.setBackground(new java.awt.Color(124, 249, 249));
        jLabel37.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(0, 0, 0));
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setText("FOUND ITEMS");
        jLabel37.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel37.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel37.setOpaque(true);

        txtSearch.setBackground(new java.awt.Color(255, 255, 255));
        txtSearch.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtSearch.setForeground(new java.awt.Color(0, 51, 51));
        txtSearch.setText("Search item...");
        txtSearch.addActionListener(this::txtSearchActionPerformed);

        jButton5.setBackground(new java.awt.Color(51, 204, 255));
        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jButton5.setForeground(new java.awt.Color(0, 0, 0));
        jButton5.setText("Search");
        jButton5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 51)));
        jButton5.addActionListener(this::jButton5ActionPerformed);

        btnReportFoundItem3.setBackground(new java.awt.Color(51, 204, 255));
        btnReportFoundItem3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnReportFoundItem3.setForeground(new java.awt.Color(0, 0, 0));
        btnReportFoundItem3.setText("+ Report Found Item");
        btnReportFoundItem3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 51)));
        btnReportFoundItem3.addActionListener(this::btnReportFoundItem3ActionPerformed);

        foundItemsTable.setBackground(new java.awt.Color(255, 255, 255));
        foundItemsTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        foundItemsTable.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        foundItemsTable.setForeground(new java.awt.Color(0, 0, 0));
        foundItemsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Wallet", "Personal Item", "CITE Lobby", "Sept 15, 2025", "Found"},
                {"Umbrella", "Accessories", "Room 204", "Sept 16, 2026", "Found"},
                {"ID Card", "Documents", "Library", "Sept 17, 2026", "Found"},
                {"Headphones", "Electronics", "Cafeteria", "Sept 18, 2026", "Found"},
                {"Backpack", "Bags", "Main Gate", "Sept 19, 2026", "Found"}
            },
            new String [] {
                "Item Name", "Category", "Location Found", "Date Found", "Status"
            }
        ));
        foundItemsTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        foundItemsTable.setGridColor(new java.awt.Color(0, 0, 0));
        foundItemsTable.setRowHeight(80);
        foundItemsTable.setShowGrid(true);
        jScrollPane3.setViewportView(foundItemsTable);
        if (foundItemsTable.getColumnModel().getColumnCount() > 0) {
            foundItemsTable.getColumnModel().getColumn(0).setPreferredWidth(200);
            foundItemsTable.getColumnModel().getColumn(2).setPreferredWidth(100);
        }
        foundItemsTable.getTableHeader().setBackground(new java.awt.Color(124,249,249));
        foundItemsTable.getTableHeader().setFont(
            new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 18)
        );

        btbViewItem1.setBackground(new java.awt.Color(51, 204, 255));
        btbViewItem1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        btbViewItem1.setForeground(new java.awt.Color(0, 0, 0));
        btbViewItem1.setText("View Item Details");
        btbViewItem1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btbViewItem1.addActionListener(this::btbViewItem1ActionPerformed);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btbViewItem1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1046, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel8Layout.createSequentialGroup()
                            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnReportFoundItem3, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnReportFoundItem3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btbViewItem1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13))))
                        .addGap(13, 13, 13))
                    .addComponent(btnViewFoundItems, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnViewLostItems, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnReportFoundItem1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnHome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnReportLostItem1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLogout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnClaimsRecords, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnProfile, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
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
                        .addComponent(btnClaimsRecords, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void btnClaimsRecordsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClaimsRecordsActionPerformed
        claimsrecords claimsPage = new claimsrecords(studentUserId);
        claimsPage.setLocationRelativeTo(this);
        claimsPage.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnClaimsRecordsActionPerformed

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

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        String search = txtSearch.getText().trim();
        javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) foundItemsTable.getModel();
        model.setRowCount(0);
        String sql = "SELECT found_id, item_name, category, "
        + "location_found, date_found, status "
        + "FROM tbl_found_items "
        + "WHERE item_name LIKE ? "
        + "OR category LIKE ? "
        + "OR location_found LIKE ? "
        + "ORDER BY found_id DESC";

        try {
            Connection conn = DBConnection.connect();
            PreparedStatement pst = conn.prepareStatement(sql);
            String searchValue = "%" + search + "%";

            pst.setString(1, searchValue);
            pst.setString(2, searchValue);
            pst.setString(3, searchValue);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                int foundId = rs.getInt("found_id");

                String itemName = rs.getString("item_name");
                String category = rs.getString("category");
                String locationFound = rs.getString("location_found");
                String dateFound = "";

                if (rs.getDate("date_found") != null) {
                    java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("MM/dd/yyyy");
                    dateFound = dateFormat.format(rs.getDate("date_found"));
                }

                String status = rs.getString("status");
                model.addRow(new Object[]{
                    foundId,
                    itemName,
                    category,
                    locationFound,
                    dateFound,
                    status
                });
            }

            rs.close();
            pst.close();
            conn.close();

            colorStatusColumn();

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(this, "Database Error: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void btnReportFoundItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportFoundItem3ActionPerformed
        reportfounditem reportfoundItem = new reportfounditem(studentUserId);
        reportfoundItem.setLocationRelativeTo(this);
        reportfoundItem.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnReportFoundItem3ActionPerformed

    private void btbViewItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btbViewItem1ActionPerformed
        int selectedRow = foundItemsTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a found item first.", "No Item Selected", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int modelRow = foundItemsTable.convertRowIndexToModel(selectedRow);
        Object idValue = foundItemsTable.getModel().getValueAt(modelRow, 0);

        if (idValue == null) {
            JOptionPane.showMessageDialog(this, "Unable to get the Found Item ID.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int foundId = Integer.parseInt(idValue.toString());
        view_found_item detailsPage = new view_found_item(foundId, studentUserId);
        detailsPage.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btbViewItem1ActionPerformed

        private void hideFoundIdColumn() {
        int foundIdViewColumn =
            foundItemsTable.convertColumnIndexToView(0);
        if (foundIdViewColumn != -1) {
        foundItemsTable.getColumnModel().removeColumn(foundItemsTable.getColumnModel().getColumn(foundIdViewColumn));
    }
        }
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
        javax.swing.JOptionPane.showMessageDialog(null,"Please open this page through the Student Dashboard.");
    });
    
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btbViewItem1;
    private javax.swing.JButton btnClaimsRecords;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnProfile;
    private javax.swing.JButton btnReportFoundItem1;
    private javax.swing.JButton btnReportFoundItem3;
    private javax.swing.JButton btnReportLostItem1;
    private javax.swing.JButton btnViewFoundItems;
    private javax.swing.JButton btnViewLostItems;
    private javax.swing.JTable foundItemsTable;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
