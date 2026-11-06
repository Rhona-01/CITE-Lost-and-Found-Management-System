
package cite_lostandfounddepartment_system;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.DriverManager;
import java.sql.Statement ;
import java.sql.PreparedStatement;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;


public class homeframe extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(homeframe.class.getName());
    
    private int studentUserId;
    
    
    private void colorStatusColumn() {
        
        tblRecentReports.getColumnModel().getColumn(2).setCellRenderer(new DefaultTableCellRenderer() {

            @Override
            public java.awt.Component getTableCellRendererComponent(javax.swing.JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                java.awt.Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                cell.setBackground(java.awt.Color.WHITE);
                cell.setForeground(java.awt.Color.BLACK);
                cell.setFont(new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 16));

                if ("Claimed".equals(value)) {

                    cell.setBackground(new java.awt.Color(120, 220, 120));
                    cell.setForeground(java.awt.Color.BLACK);
                    cell.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 16));

                } else if ("Pending".equals(value)) {

                    cell.setBackground(new java.awt.Color(190, 225, 120));
                    cell.setForeground(java.awt.Color.BLACK);
                    cell.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 16));

                } else if ("Rejected".equals(value)) {

                    cell.setBackground(new java.awt.Color(102, 102, 102));
                    cell.setForeground(java.awt.Color.WHITE);
                    cell.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 16));

                } else if ("Lost".equals(value)) {

                    cell.setBackground(new java.awt.Color(225, 69, 69));
                    cell.setForeground(java.awt.Color.BLACK);
                    cell.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 16));

                } else if ("Found".equals(value)) {

                    cell.setBackground(new java.awt.Color(0, 204, 153));
                    cell.setForeground(java.awt.Color.BLACK);
                    cell.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 16));
                    
                    } else if ("Returned".equals(value)) {

                    cell.setBackground(new java.awt.Color(153,204,255));
                    cell.setForeground(java.awt.Color.BLACK);
                    cell.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 16));
                }

                return cell;
            }
        }
    );
        
        
        tblMyClaims.getColumnModel().getColumn(2).setCellRenderer(new DefaultTableCellRenderer() {

            @Override
            public java.awt.Component getTableCellRendererComponent(javax.swing.JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

                java.awt.Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                cell.setBackground(java.awt.Color.WHITE);
                cell.setForeground(java.awt.Color.BLACK);
                cell.setFont(new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 16));

                if ("Claimed".equals(value)) {

                    cell.setBackground(new java.awt.Color(120, 220, 120));
                    cell.setForeground(java.awt.Color.BLACK);
                    cell.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 16));

                } else if ("Pending".equals(value)) {

                    cell.setBackground(new java.awt.Color(190, 225, 120));
                    cell.setForeground(java.awt.Color.BLACK);
                    cell.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 16));

                } else if ("Rejected".equals(value)) {

                    cell.setBackground(new java.awt.Color(102, 102, 102));
                    cell.setForeground(java.awt.Color.WHITE);
                    cell.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 16));
                }

                return cell;
            }
        }
    );
}

    public homeframe(int userId) {
        initComponents();
         this.studentUserId = userId;
         setLocationRelativeTo(null);
        
        this.setResizable(true);
        this.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
        
        tblRecentReports.getTableHeader().setBackground(new java.awt.Color(114, 191, 191));
        tblRecentReports.getTableHeader().setForeground(new java.awt.Color(0, 51, 51));
        tblRecentReports.getTableHeader().setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 16));
        
        tblMyClaims.getTableHeader().setBackground(new java.awt.Color(114, 191, 191));
        tblMyClaims.getTableHeader().setForeground(new java.awt.Color(0, 51, 51));
        tblMyClaims.getTableHeader().setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 16));
        
        loadDashboardCounts();
        loadRecentReports();
        colorStatusColumn();
        loadMyClaims();
        loadStudentName();
        loadPendingClaimsCount();
        
    }
    
        private void loadDashboardCounts() {
    try {
        Connection conn = DBConnection.connect();
        if (conn == null) {
            JOptionPane.showMessageDialog(this, "Unable to connect to the database.", "Database Error",JOptionPane.ERROR_MESSAGE);
        return;
        }
        String lostSQL = "SELECT COUNT(*) FROM tbl_lost_items";
        java.sql.Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(lostSQL);
        if (rs.next()) {
            int lostCount = rs.getInt(1);
            lblLostCount.setText(String.valueOf(lostCount));
        }
        rs.close();
        String foundSQL = "SELECT COUNT(*) FROM tbl_found_items";
        rs = st.executeQuery(foundSQL);
        if (rs.next()) {
            int foundCount = rs.getInt(1);
            lblFoundCount.setText(String.valueOf(foundCount));
        }
        rs.close();
        String claimsSQL = "SELECT COUNT(*) FROM tbl_claims";
        rs = st.executeQuery(claimsSQL);
        if (rs.next()) {
            int claimsCount = rs.getInt(1);
            lblClaimsCount.setText(String.valueOf(claimsCount));
        }

        rs.close();
        st.close();
        conn.close();

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Database Error: " + e.getMessage(),"Database Error", JOptionPane.ERROR_MESSAGE);
    }
    }
        
 private void loadRecentReports() {

         String query;

    try {

        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/cite_lostandfounddepartment_system";
        String user = "root";
        String pass = "";

        Connection con = DriverManager.getConnection(url, user, pass);
        Statement st = con.createStatement();

        query = "SELECT item_name, 'Lost' AS type, date_lost AS report_date, status "
                + "FROM tbl_lost_items "
                + "UNION ALL "
                + "SELECT item_name, 'Found' AS type, date_found AS report_date, status "
                + "FROM tbl_found_items "
                + "UNION ALL "
                + "SELECT f.item_name, 'Claim' AS type, c.claim_date AS report_date, c.status "
                + "FROM tbl_claims c "
                + "JOIN tbl_found_items f ON c.found_id = f.found_id "
                + "ORDER BY report_date DESC "
                + "LIMIT 10";

        ResultSet rs = st.executeQuery(query);

        DefaultTableModel model = (DefaultTableModel) tblRecentReports.getModel();
        model.setRowCount(0);
        while (rs.next()) {
            model.addRow(new Object[]{
                rs.getString("item_name"),
                rs.getDate("report_date"),
                rs.getString("status")
            });
        }

        rs.close();
        st.close();
        con.close();

    } catch (Exception e) {

        JOptionPane.showMessageDialog(this,"Error: " + e.getMessage());
    
}
}
 
 private void loadMyClaims() {

    String sql = "SELECT c.claim_id, f.item_name, c.claim_date, c.status "
               + "FROM tbl_claims c "
               + "INNER JOIN tbl_found_items f ON c.found_id = f.found_id "
               + "WHERE c.student_user_id = ? "
               + "ORDER BY c.claim_date DESC";

    try {
        Connection conn = DBConnection.connect();

        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setInt(1, studentUserId);

        ResultSet rs = pst.executeQuery();

        javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) tblMyClaims.getModel();

        model.setRowCount(0);

        while (rs.next()) {

            model.addRow(new Object[] {
                rs.getString("item_name"),
                rs.getDate("claim_date"),
                rs.getString("status")
            });
        }

        rs.close();
        pst.close();
        conn.close();

    } catch (SQLException e) {

        JOptionPane.showMessageDialog(this, "Unable to load claims: " + e.getMessage(), "Database Error",JOptionPane.ERROR_MESSAGE);
    }
}
 
 private void loadStudentName() {

    String sql = "SELECT full_name FROM tbl_users WHERE user_id = ?";

    try {
        Connection conn = DBConnection.connect();

        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setInt(1, studentUserId);

        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            String fullName = rs.getString("full_name");

            lblWelcome.setText("Welcome, " + fullName + "!");
        }

        rs.close();
        pst.close();
        conn.close();

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Unable to load student name: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
    }
}
 private void loadPendingClaimsCount() {

    String sql = "SELECT COUNT(*) AS pending_count "
               + "FROM tbl_claims "
               + "WHERE student_user_id = ? "
               + "AND status = 'Pending'";

    try {
        Connection conn = DBConnection.connect();

        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setInt(1, studentUserId);

        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            int pendingCount = rs.getInt("pending_count");

            lblPendingCount.setText(String.valueOf(pendingCount));
        }

        rs.close();
        pst.close();
        conn.close();

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this,"Error loading pending claims: " + e.getMessage());
    }
}
  

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnHome = new javax.swing.JButton();
        btnViewLostItems = new javax.swing.JButton();
        btnClaimsRecords = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        lblLostCount = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel19 = new javax.swing.JLabel();
        lblFoundCount = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        jLabel23 = new javax.swing.JLabel();
        lblClaimsCount = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblRecentReports = new javax.swing.JTable();
        lblWelcome = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jPanel24 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jSeparator9 = new javax.swing.JSeparator();
        jLabel31 = new javax.swing.JLabel();
        lblPendingCount = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        qckReportLostItem = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        qckReportFoundItem = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jPanel5 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        qckViewLostItem = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jPanel8 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        qckViewFoundItems = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblMyClaims = new javax.swing.JTable();
        jLabel34 = new javax.swing.JLabel();
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

        jPanel6.setBackground(new java.awt.Color(204, 255, 255));

        jPanel3.setBackground(new java.awt.Color(204, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.setForeground(new java.awt.Color(0, 0, 0));

        jLabel9.setIcon(new javax.swing.ImageIcon("C:\\Users\\abbyg\\OneDrive\\Pictures\\icons\\lost items report.png")); // NOI18N

        jSeparator5.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator5.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator5.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("LOST ITEMS");

        lblLostCount.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblLostCount.setForeground(new java.awt.Color(0, 0, 0));
        lblLostCount.setText("12");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Total lost items reports.");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(lblLostCount)
                    .addComponent(jLabel3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblLostCount, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(21, 21, 21))
        );

        jPanel7.setBackground(new java.awt.Color(204, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel18.setIcon(new javax.swing.ImageIcon("C:\\Users\\abbyg\\OneDrive\\Pictures\\icons\\found items.png")); // NOI18N

        jSeparator7.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator7.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator7.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 0, 0));
        jLabel19.setText("FOUND ITEMS");

        lblFoundCount.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblFoundCount.setForeground(new java.awt.Color(0, 0, 0));
        lblFoundCount.setText("8");

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 0, 0));
        jLabel21.setText("Total found items reports.");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addComponent(lblFoundCount)
                    .addComponent(jLabel21))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel7Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel19)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblFoundCount, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel21))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel18)))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        jPanel9.setBackground(new java.awt.Color(204, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel9.setForeground(new java.awt.Color(0, 0, 0));

        jLabel22.setIcon(new javax.swing.ImageIcon("C:\\Users\\abbyg\\OneDrive\\Pictures\\icons\\claim item.png")); // NOI18N

        jSeparator8.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator8.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator8.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 0, 0));
        jLabel23.setText("ITEMS RETURNED");

        lblClaimsCount.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblClaimsCount.setForeground(new java.awt.Color(0, 0, 0));
        lblClaimsCount.setText("5");

        jLabel27.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(0, 0, 0));
        jLabel27.setText("Total item claims.");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23)
                    .addComponent(lblClaimsCount)
                    .addComponent(jLabel27))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel23)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblClaimsCount, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel27))))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel22)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane2.setBackground(new java.awt.Color(21, 82, 82));

        tblRecentReports.setBackground(new java.awt.Color(255, 255, 255));
        tblRecentReports.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        tblRecentReports.setForeground(new java.awt.Color(0, 0, 0));
        tblRecentReports.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item", "Date", "Status"
            }
        ));
        tblRecentReports.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tblRecentReports.setGridColor(new java.awt.Color(0, 0, 0));
        tblRecentReports.setRowHeight(60);
        tblRecentReports.setShowGrid(true);
        jScrollPane2.setViewportView(tblRecentReports);
        if (tblRecentReports.getColumnModel().getColumnCount() > 0) {
            tblRecentReports.getColumnModel().getColumn(0).setPreferredWidth(150);
        }

        lblWelcome.setBackground(new java.awt.Color(0, 0, 0));
        lblWelcome.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblWelcome.setForeground(new java.awt.Color(0, 0, 0));
        lblWelcome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblWelcome.setText("Welcome, Student!");

        jLabel28.setBackground(new java.awt.Color(0, 0, 0));
        jLabel28.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(0, 0, 0));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("CITE Department Lost and Found Management System");

        jLabel29.setBackground(new java.awt.Color(0, 0, 0));
        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(0, 0, 0));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("Student");

        jPanel24.setBackground(new java.awt.Color(204, 255, 255));
        jPanel24.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel30.setBackground(new java.awt.Color(147, 150, 55));
        jLabel30.setForeground(new java.awt.Color(153, 153, 0));
        jLabel30.setIcon(new javax.swing.ImageIcon("C:\\Users\\abbyg\\OneDrive\\Pictures\\icons\\pending items.png")); // NOI18N

        jSeparator9.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator9.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator9.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel31.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(0, 0, 0));
        jLabel31.setText("PENDING CLAIMS");

        lblPendingCount.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblPendingCount.setForeground(new java.awt.Color(0, 0, 0));
        lblPendingCount.setText("0");

        jLabel32.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(0, 0, 0));
        jLabel32.setText("Total item claims.");

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel30)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPendingCount)
                            .addComponent(jLabel32))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel31)
                        .addContainerGap())))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel24Layout.createSequentialGroup()
                                .addComponent(jLabel31)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblPendingCount, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel32))))
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel30)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel33.setBackground(new java.awt.Color(124, 249, 249));
        jLabel33.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(0, 0, 0));
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel33.setText(" Recent Reports");
        jLabel33.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel33.setOpaque(true);

        jLabel37.setBackground(new java.awt.Color(124, 249, 249));
        jLabel37.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(0, 0, 0));
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel37.setText(" Quick Actions");
        jLabel37.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel37.setOpaque(true);

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Report Lost Item");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Report something that you lost.");

        qckReportLostItem.setBackground(new java.awt.Color(204, 255, 255));
        qckReportLostItem.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        qckReportLostItem.setForeground(new java.awt.Color(0, 0, 0));
        qckReportLostItem.setText(">");
        qckReportLostItem.setBorder(null);
        qckReportLostItem.addActionListener(this::qckReportLostItemActionPerformed);

        jLabel5.setIcon(new javax.swing.ImageIcon("C:\\Users\\abbyg\\OneDrive\\Pictures\\icons\\manage lost items.png")); // NOI18N

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                .addComponent(qckReportLostItem)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(qckReportLostItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(204, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Report Found Item");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Report something that you found.");

        qckReportFoundItem.setBackground(new java.awt.Color(204, 255, 255));
        qckReportFoundItem.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        qckReportFoundItem.setForeground(new java.awt.Color(0, 0, 0));
        qckReportFoundItem.setText(">");
        qckReportFoundItem.setBorder(null);
        qckReportFoundItem.addActionListener(this::qckReportFoundItemActionPerformed);

        jLabel8.setIcon(new javax.swing.ImageIcon("C:\\Users\\abbyg\\OneDrive\\Pictures\\icons\\manage lost items.png")); // NOI18N

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6))
                .addGap(122, 122, 122)
                .addComponent(qckReportFoundItem)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(qckReportFoundItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(204, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("View Lost Items");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Report something that you lost.");

        qckViewLostItem.setBackground(new java.awt.Color(204, 255, 255));
        qckViewLostItem.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        qckViewLostItem.setForeground(new java.awt.Color(0, 0, 0));
        qckViewLostItem.setText(">");
        qckViewLostItem.setBorder(null);
        qckViewLostItem.addActionListener(this::qckViewLostItemActionPerformed);

        jLabel15.setIcon(new javax.swing.ImageIcon("C:\\Users\\abbyg\\OneDrive\\Pictures\\icons\\manage lost items.png")); // NOI18N

        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(qckViewLostItem)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(qckViewLostItem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11))
                    .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        jPanel8.setBackground(new java.awt.Color(204, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("View Found Items");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setText("Report something that you lost.");

        qckViewFoundItems.setBackground(new java.awt.Color(204, 255, 255));
        qckViewFoundItems.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        qckViewFoundItems.setForeground(new java.awt.Color(0, 0, 0));
        qckViewFoundItems.setText(">");
        qckViewFoundItems.setBorder(null);
        qckViewFoundItems.addActionListener(this::qckViewFoundItemsActionPerformed);

        jLabel20.setIcon(new javax.swing.ImageIcon("C:\\Users\\abbyg\\OneDrive\\Pictures\\icons\\manage lost items.png")); // NOI18N

        jSeparator6.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(jLabel16))
                .addGap(123, 123, 123)
                .addComponent(qckViewFoundItems)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(qckViewFoundItems, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel17)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jSeparator6, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        jScrollPane3.setBackground(new java.awt.Color(21, 82, 82));

        tblMyClaims.setBackground(new java.awt.Color(255, 255, 255));
        tblMyClaims.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        tblMyClaims.setForeground(new java.awt.Color(0, 0, 0));
        tblMyClaims.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item Name", "Date Submitted", "Status"
            }
        ));
        tblMyClaims.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tblMyClaims.setGridColor(new java.awt.Color(0, 0, 0));
        tblMyClaims.setRowHeight(60);
        tblMyClaims.setShowGrid(true);
        jScrollPane3.setViewportView(tblMyClaims);
        if (tblMyClaims.getColumnModel().getColumnCount() > 0) {
            tblMyClaims.getColumnModel().getColumn(0).setPreferredWidth(170);
        }

        jLabel34.setBackground(new java.awt.Color(124, 249, 249));
        jLabel34.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(0, 0, 0));
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel34.setText(" My Claims");
        jLabel34.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel34.setOpaque(true);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel28)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
                                    .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 544, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel34, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 544, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(lblWelcome)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel29))
                            .addComponent(jLabel37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(262, 262, 262))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblWelcome)
                    .addComponent(jLabel29))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(16, 18, Short.MAX_VALUE))
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
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 1118, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addComponent(btnClaimsRecords, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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

    private void qckReportLostItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qckReportLostItemActionPerformed
        reportlostitemsframe reportlostItems = new reportlostitemsframe(studentUserId);
        reportlostItems.setLocationRelativeTo(this);
        reportlostItems.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_qckReportLostItemActionPerformed

    private void qckReportFoundItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qckReportFoundItemActionPerformed
        reportfounditem reportfoundItem = new reportfounditem(studentUserId);
        reportfoundItem.setLocationRelativeTo(this);
        reportfoundItem.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_qckReportFoundItemActionPerformed

    private void qckViewLostItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qckViewLostItemActionPerformed
       viewlostitems viewlostItemsPage = new viewlostitems(studentUserId);
       viewlostItemsPage.setLocationRelativeTo(this);
       viewlostItemsPage.setVisible(true);
       this.dispose();

    }//GEN-LAST:event_qckViewLostItemActionPerformed

    private void qckViewFoundItemsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qckViewFoundItemsActionPerformed
       viewfounditems viewfoundItemsPage = new viewfounditems(studentUserId);
       viewfoundItemsPage.setLocationRelativeTo(this);
       viewfoundItemsPage.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_qckViewFoundItemsActionPerformed

    private void btnProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProfileActionPerformed
    profileframe profile = new profileframe(studentUserId);
    profile.setLocationRelativeTo(this);
    profile.setVisible(true);
    }//GEN-LAST:event_btnProfileActionPerformed

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new homeframe(1).setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClaimsRecords;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnProfile;
    private javax.swing.JButton btnReportFoundItem1;
    private javax.swing.JButton btnReportLostItem1;
    private javax.swing.JButton btnViewFoundItems;
    private javax.swing.JButton btnViewLostItems;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JLabel lblClaimsCount;
    private javax.swing.JLabel lblFoundCount;
    private javax.swing.JLabel lblLostCount;
    private javax.swing.JLabel lblPendingCount;
    private javax.swing.JLabel lblWelcome;
    private javax.swing.JButton qckReportFoundItem;
    private javax.swing.JButton qckReportLostItem;
    private javax.swing.JButton qckViewFoundItems;
    private javax.swing.JButton qckViewLostItem;
    private javax.swing.JTable tblMyClaims;
    private javax.swing.JTable tblRecentReports;
    // End of variables declaration//GEN-END:variables

}
