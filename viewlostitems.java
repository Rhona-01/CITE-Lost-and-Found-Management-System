
package cite_lostandfounddepartment_system;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class viewlostitems extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(viewlostitems.class.getName());
    private int studentUserId;


    public viewlostitems(int userId) {
        
        initComponents();
        
        this.studentUserId = userId;
        setLocationRelativeTo(null);
        
        lostItemsTable.getTableHeader().setBackground(new java.awt.Color(114, 191, 191));
        lostItemsTable.getTableHeader().setForeground(new java.awt.Color(0, 51, 51));
        lostItemsTable.getTableHeader().setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 18));
        
        javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) lostItemsTable.getModel();
        model.setColumnIdentifiers(new Object[]{
        "lost_id",
        "Item Name",
        "Category",
        "Location Lost",
        "Date Lost",
        "Status"
    });

    loadLostItems();

    hideLostIdColumn();

    colorStatusColumn();
            
        }         
      
        private void loadLostItems() {
    
        javax.swing.table.DefaultTableModel model =
            (javax.swing.table.DefaultTableModel) lostItemsTable.getModel();

    model.setRowCount(0);

    String sql =
            "SELECT lost_id, item_name, category, "
            + "location_lost, date_lost, status "
            + "FROM tbl_lost_items "
            + "ORDER BY lost_id DESC";

    try {

        Connection conn = DBConnection.connect();
        java.sql.PreparedStatement pst = conn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            int lostId = rs.getInt("lost_id");
            
            String itemName = rs.getString("item_name");
            String category = rs.getString("category");
            String locationLost = rs.getString("location_lost");
            String dateLost = "";
            
            if (rs.getDate("date_lost") != null) {
                java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("MM/dd/yyyy");

                dateLost = dateFormat.format(rs.getDate("date_lost"));
            }

            String status = rs.getString("status");

            model.addRow(new Object[]{
                lostId,
                itemName,
                category,
                locationLost,
                dateLost,
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
        int statusViewColumn = lostItemsTable.convertColumnIndexToView(statusModelColumn);
        if (statusViewColumn == -1) {
        return;
    }
        lostItemsTable.getColumnModel()
            .getColumn(statusViewColumn)
            .setCellRenderer(new javax.swing.table.DefaultTableCellRenderer() {

        @Override
        public java.awt.Component getTableCellRendererComponent(javax.swing.JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            java.awt.Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            String status = value == null ? "" : value.toString();

            if (status.equalsIgnoreCase("Lost")) {
                component.setBackground(new java.awt.Color(225,69,69));
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
    
    private void lostItemsTableMouseClicked(
        java.awt.event.MouseEvent evt) {

    if (evt.getClickCount() == 2) {
        int row = lostItemsTable.getSelectedRow();

        if (row >= 0) {int lostId = Integer.parseInt(
                lostItemsTable.getValueAt(row, 0).toString());
            view_lost_item details = new view_lost_item(lostId, studentUserId);

            details.setVisible(true);
            dispose();
        }
    }
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnReportLostItem = new javax.swing.JButton();
        btbViewItem = new javax.swing.JButton();
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
        jPanel9 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        btnReportLostItem2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        lostItemsTable = new javax.swing.JTable();
        btbViewItem1 = new javax.swing.JButton();

        btnReportLostItem.setBackground(new java.awt.Color(0, 51, 51));
        btnReportLostItem.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        btnReportLostItem.setForeground(new java.awt.Color(255, 255, 255));
        btnReportLostItem.setText("+ Report Lost Item");
        btnReportLostItem.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        btnReportLostItem.addActionListener(this::btnReportLostItemActionPerformed);

        btbViewItem.setBackground(new java.awt.Color(0, 51, 51));
        btbViewItem.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        btbViewItem.setForeground(new java.awt.Color(255, 255, 255));
        btbViewItem.setText("View Item Details");
        btbViewItem.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        btbViewItem.addActionListener(this::btbViewItemActionPerformed);

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

        jPanel9.setBackground(new java.awt.Color(204, 255, 255));

        jLabel37.setBackground(new java.awt.Color(124, 249, 249));
        jLabel37.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(0, 0, 0));
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setText("LOST ITEMS");
        jLabel37.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel37.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel37.setOpaque(true);

        txtSearch.setBackground(new java.awt.Color(255, 255, 255));
        txtSearch.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtSearch.setForeground(new java.awt.Color(0, 51, 51));
        txtSearch.setText("Search item...");
        txtSearch.addActionListener(this::txtSearchActionPerformed);

        jButton4.setBackground(new java.awt.Color(51, 204, 255));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jButton4.setForeground(new java.awt.Color(0, 0, 0));
        jButton4.setText("Search");
        jButton4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 51)));
        jButton4.addActionListener(this::jButton4ActionPerformed);

        btnReportLostItem2.setBackground(new java.awt.Color(51, 204, 255));
        btnReportLostItem2.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        btnReportLostItem2.setForeground(new java.awt.Color(0, 0, 0));
        btnReportLostItem2.setText("+ Report Lost Item");
        btnReportLostItem2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 51)));
        btnReportLostItem2.addActionListener(this::btnReportLostItem2ActionPerformed);

        lostItemsTable.setBackground(new java.awt.Color(255, 255, 255));
        lostItemsTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lostItemsTable.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lostItemsTable.setForeground(new java.awt.Color(0, 0, 0));
        lostItemsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Wallet", "Personal Item", "CITE Lobby", "Sept 15, 2025", "Lost"},
                {"Umbrella", "Accessories", "Room 204", "Sept 16, 2026", "Lost"},
                {"ID Card", "Documents", "Library", "Sept 17, 2026", "Lost"},
                {"Headphones", "Electronics", "Cafeteria", "Sept 18, 2026", "Lost"},
                {"Backpack", "Bags", "Main Gate", "Sept 19, 2026", "Lost"}
            },
            new String [] {
                "Item Name", "Category", "Location Lost", "Date Lost", "Status"
            }
        ));
        lostItemsTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        lostItemsTable.setGridColor(new java.awt.Color(0, 0, 0));
        lostItemsTable.setRowHeight(80);
        lostItemsTable.setSelectionForeground(new java.awt.Color(114, 191, 191));
        lostItemsTable.setShowGrid(true);
        jScrollPane2.setViewportView(lostItemsTable);
        if (lostItemsTable.getColumnModel().getColumnCount() > 0) {
            lostItemsTable.getColumnModel().getColumn(0).setPreferredWidth(200);
            lostItemsTable.getColumnModel().getColumn(2).setPreferredWidth(100);
        }
        lostItemsTable.getTableHeader().setBackground(new java.awt.Color(124,249,249));
        lostItemsTable.getTableHeader().setFont(
            new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 18)
        );

        btbViewItem1.setBackground(new java.awt.Color(51, 204, 255));
        btbViewItem1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        btbViewItem1.setForeground(new java.awt.Color(0, 0, 0));
        btbViewItem1.setText("View Item Details");
        btbViewItem1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 51)));
        btbViewItem1.addActionListener(this::btbViewItem1ActionPerformed);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(0, 42, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btbViewItem1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1055, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnReportLostItem2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21))))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReportLostItem2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btbViewItem1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
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
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                .addComponent(btnClaimsRecords, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(btnProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnReportLostItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportLostItemActionPerformed
        reportlostitemsframe reportlostItems = new reportlostitemsframe(studentUserId);
        reportlostItems.setLocationRelativeTo(this);
        reportlostItems.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnReportLostItemActionPerformed

    private void btbViewItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btbViewItemActionPerformed
        int selectedRow = lostItemsTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a lost item first.", "No Item Selected", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int modelRow = lostItemsTable.convertRowIndexToModel(selectedRow);
        Object idValue = lostItemsTable.getModel().getValueAt(modelRow, 0);

        if (idValue == null) {
            JOptionPane.showMessageDialog(this, "Unable to get the Lost Item ID.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int lostId = Integer.parseInt(idValue.toString());
        view_lost_item detailsPage = new view_lost_item(lostId,studentUserId);
        detailsPage.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btbViewItemActionPerformed

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

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        String search = txtSearch.getText().trim();
        javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) lostItemsTable.getModel();
        model.setRowCount(0);
        String sql = "SELECT lost_id, item_name, category, "
        + "location_lost, date_lost, status "
        + "FROM tbl_lost_items "
        + "WHERE item_name LIKE ? "
        + "OR category LIKE ? "
        + "OR location_lost LIKE ? "
        + "ORDER BY lost_id DESC";

        try {
            Connection conn = DBConnection.connect();
            PreparedStatement pst = conn.prepareStatement(sql);
            String searchValue = "%" + search + "%";

            pst.setString(1, searchValue);
            pst.setString(2, searchValue);
            pst.setString(3, searchValue);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                int lostId = rs.getInt("lost_id");

                String itemName = rs.getString("item_name");
                String category = rs.getString("category");
                String locationLost = rs.getString("location_lost");
                String dateLost = "";

                if (rs.getDate("date_lost") != null) {
                    java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("MM/dd/yyyy");
                    dateLost = dateFormat.format(rs.getDate("date_lost"));
                }

                String status = rs.getString("status");
                model.addRow(new Object[]{
                    lostId,
                    itemName,
                    category,
                    locationLost,
                    dateLost,
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
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btnReportLostItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportLostItem2ActionPerformed
        reportlostitemsframe reportlostItems = new reportlostitemsframe(studentUserId);
        reportlostItems.setLocationRelativeTo(this);
        reportlostItems.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnReportLostItem2ActionPerformed

    private void btbViewItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btbViewItem1ActionPerformed
        int selectedRow = lostItemsTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a lost item first.", "No Item Selected", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int modelRow = lostItemsTable.convertRowIndexToModel(selectedRow);
        Object idValue = lostItemsTable.getModel().getValueAt(modelRow, 0);

        if (idValue == null) {
            JOptionPane.showMessageDialog(this, "Unable to get the Lost Item ID.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int lostId = Integer.parseInt(idValue.toString());
        view_lost_item detailsPage = new view_lost_item(lostId, studentUserId);
        detailsPage.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btbViewItem1ActionPerformed

    private void hideLostIdColumn() {
        int lostIdViewColumn =
            lostItemsTable.convertColumnIndexToView(0);
        if (lostIdViewColumn != -1) {
        lostItemsTable.getColumnModel().removeColumn(lostItemsTable.getColumnModel().getColumn(lostIdViewColumn));
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
    private javax.swing.JButton btbViewItem;
    private javax.swing.JButton btbViewItem1;
    private javax.swing.JButton btnClaimsRecords;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnProfile;
    private javax.swing.JButton btnReportFoundItem1;
    private javax.swing.JButton btnReportLostItem;
    private javax.swing.JButton btnReportLostItem1;
    private javax.swing.JButton btnReportLostItem2;
    private javax.swing.JButton btnViewFoundItems;
    private javax.swing.JButton btnViewLostItems;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable lostItemsTable;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
