
package cite_lostandfounddepartment_system;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class admin_reports extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(admin_reports.class.getName());
    
    private int AdminUserId;
    private String AdminFullName;

    public admin_reports(int userId, String fullName) {
        initComponents();
        
        tblReports.setModel(new DefaultTableModel(
    new Object[][] {},
    new String[] {
        "ID",
        "Item Name",
        "Type",
        "Date",
        "Location",
        "Status"
    }
) {
    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
});
        
        setResizable(true);
        setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        
        loadSummary();
        loadReports();
    }
    
    private void loadReports() {

    String selectedReport = cmbReportType.getSelectedItem().toString();

    DefaultTableModel model =
        (DefaultTableModel) tblReports.getModel();

    model.setRowCount(0);

    try {

        Connection conn = DBConnection.connect();

        if (selectedReport.equals("Lost Items")) {

            String sql = "SELECT lost_id, item_name, category, date_lost, "
                       + "location_lost, status "
                       + "FROM tbl_lost_items "
                       + "ORDER BY lost_id DESC";

            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                model.addRow(new Object[]{
                    rs.getInt("lost_id"),
                    rs.getString("item_name"),
                    "Lost Item",
                    rs.getDate("date_lost"),
                    rs.getString("location_lost"),
                    rs.getString("status")
                });
            }

            rs.close();
            pst.close();

        } else if (selectedReport.equals("Found Items")) {

            String sql = "SELECT found_id, item_name, category, date_found, "
                       + "location_found, status "
                       + "FROM tbl_found_items "
                       + "ORDER BY found_id DESC";

            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                model.addRow(new Object[]{
                    rs.getInt("found_id"),
                    rs.getString("item_name"),
                    "Found Item",
                    rs.getDate("date_found"),
                    rs.getString("location_found"),
                    rs.getString("status")
                });
            }

            rs.close();
            pst.close();

        } else if (selectedReport.equals("Claims")) {

            String sql = "SELECT claim_id, claimant_name, claim_date, status "
                       + "FROM tbl_claims "
                       + "ORDER BY claim_id DESC";

            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                model.addRow(new Object[]{
                    rs.getInt("claim_id"),
                    rs.getString("claimant_name"),
                    "Claim",
                    rs.getDate("claim_date"),
                    "",
                    rs.getString("status")
                });
            }

            rs.close();
            pst.close();

        } else {

            // All Reports
            loadAllReports(model, conn);
        }

        conn.close();

        JOptionPane.showMessageDialog(
            this,
            "Report generated successfully.",
            "Report",
            JOptionPane.INFORMATION_MESSAGE
        );

    } catch (SQLException e) {

        JOptionPane.showMessageDialog(
            this,
            "Database Error: " + e.getMessage(),
            "Database Error",
            JOptionPane.ERROR_MESSAGE
        );
    }

    }
    
    private void loadAllReports(DefaultTableModel model, Connection conn) {

    try {

        // =========================
        // LOST ITEMS
        // =========================

        String lostSql =
                "SELECT lost_id, item_name, category, date_lost, "
              + "location_lost, status "
              + "FROM tbl_lost_items "
              + "ORDER BY lost_id DESC";

        PreparedStatement lostPst = conn.prepareStatement(lostSql);
        ResultSet lostRs = lostPst.executeQuery();

        while (lostRs.next()) {

            model.addRow(new Object[]{
                lostRs.getInt("lost_id"),
                lostRs.getString("item_name"),
                "Lost Item",
                lostRs.getDate("date_lost"),
                lostRs.getString("location_lost"),
                lostRs.getString("status")
            });
        }

        lostRs.close();
        lostPst.close();


        // =========================
        // FOUND ITEMS
        // =========================

        String foundSql =
                "SELECT found_id, item_name, category, date_found, "
              + "location_found, status "
              + "FROM tbl_found_items "
              + "ORDER BY found_id DESC";

        PreparedStatement foundPst = conn.prepareStatement(foundSql);
        ResultSet foundRs = foundPst.executeQuery();

        while (foundRs.next()) {

            model.addRow(new Object[]{
                foundRs.getInt("found_id"),
                foundRs.getString("item_name"),
                "Found Item",
                foundRs.getDate("date_found"),
                foundRs.getString("location_found"),
                foundRs.getString("status")
            });
        }

        foundRs.close();
        foundPst.close();


        // =========================
        // CLAIMS
        // =========================

        String claimSql =
                "SELECT claim_id, claimant_name, claim_date, status "
              + "FROM tbl_claims "
              + "ORDER BY claim_id DESC";

        PreparedStatement claimPst = conn.prepareStatement(claimSql);
        ResultSet claimRs = claimPst.executeQuery();

        while (claimRs.next()) {

            model.addRow(new Object[]{
                claimRs.getInt("claim_id"),
                claimRs.getString("claimant_name"),
                "Claim",
                claimRs.getDate("claim_date"),
                "",
                claimRs.getString("status")
            });
        }

        claimRs.close();
        claimPst.close();

    } catch (SQLException e) {

        JOptionPane.showMessageDialog(
                this,
                "Error loading all reports: " + e.getMessage(),
                "Database Error",
                JOptionPane.ERROR_MESSAGE
        );
    }
}
    
    private void loadSummary() {

    try {

        Connection conn = DBConnection.connect();

        /*
         * LOST ITEMS
         */

        String sql =
                "SELECT COUNT(*) FROM tbl_lost_items";

        PreparedStatement pst =
                conn.prepareStatement(sql);

        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            lblLostItems.setText(
                    String.valueOf(rs.getInt(1))
            );
        }

        rs.close();
        pst.close();


        /*
         * FOUND ITEMS
         */

        sql =
                "SELECT COUNT(*) FROM tbl_found_items";

        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();

        if (rs.next()) {
            lblFoundItems.setText(
                    String.valueOf(rs.getInt(1))
            );
        }

        rs.close();
        pst.close();


        /*
         * APPROVED CLAIMS
         */

        sql =
                "SELECT COUNT(*) FROM tbl_claims "
                + "WHERE status = 'Approved'";

        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();

        if (rs.next()) {
            lblApprovedClaims.setText(
                    String.valueOf(rs.getInt(1))
            );
        }

        rs.close();
        pst.close();


        /*
         * REJECTED CLAIMS
         */

        sql =
                "SELECT COUNT(*) FROM tbl_claims "
                + "WHERE status = 'Rejected'";

        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();

        if (rs.next()) {
            lblRejectedClaims.setText(
                    String.valueOf(rs.getInt(1))
            );
        }

        rs.close();
        pst.close();


        /*
         * UNCLAIMED ITEMS
         */

        sql =
                "SELECT COUNT(*) FROM tbl_found_items "
                + "WHERE status = 'Found'";

        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();

        if (rs.next()) {
            lblUnclaimedItems.setText(
                    String.valueOf(rs.getInt(1))
            );
        }

        rs.close();
        pst.close();

        conn.close();

    }
    catch (SQLException e) {

        JOptionPane.showMessageDialog(
                this,
                "Database Error: " + e.getMessage(),
                "Database Error",
                JOptionPane.ERROR_MESSAGE
        );
    }
}
    
    private void loadClaimsByStatus(
        Connection conn,
        DefaultTableModel model,
        String status,
        String dateFrom,
        String dateTo) throws SQLException {

    String sql =
            "SELECT c.claim_id, "
            + "f.item_name, "
            + "c.claim_date, "
            + "f.location_found, "
            + "c.status "
            + "FROM tbl_claims c "
            + "LEFT JOIN tbl_found_items f "
            + "ON c.found_id = f.found_id "
            + "WHERE c.status = ? ";

    if (!dateFrom.isEmpty() && !dateTo.isEmpty()) {
        sql += "AND c.claim_date BETWEEN ? AND ? ";
    }

    sql += "ORDER BY c.claim_date DESC";

    PreparedStatement pst =
            conn.prepareStatement(sql);

    int parameter = 1;

    pst.setString(parameter++, status);

    if (!dateFrom.isEmpty() && !dateTo.isEmpty()) {

        pst.setString(parameter++, convertDate(dateFrom));
        pst.setString(parameter++, convertDate(dateTo));
    }

    ResultSet rs = pst.executeQuery();

    while (rs.next()) {

        model.addRow(new Object[]{
            rs.getInt("claim_id"),
            rs.getString("item_name"),
            "Claim",
            formatDate(rs.getDate("claim_date")),
            rs.getString("location_found"),
            rs.getString("status")
        });
    }

    rs.close();
    pst.close();
}
    
    private String convertDate(String date) {

    try {

        SimpleDateFormat inputFormat =
                new SimpleDateFormat("MM/dd/yyyy");

        inputFormat.setLenient(false);

        SimpleDateFormat sqlFormat =
                new SimpleDateFormat("yyyy-MM-dd");

        Date parsedDate =
                inputFormat.parse(date);

        return sqlFormat.format(parsedDate);

    }
    catch (Exception e) {

        throw new IllegalArgumentException(
                "Please enter dates using MM/DD/YYYY."
        );
    }
}
 
    private String formatDate(java.sql.Date date) {

    if (date == null) {
        return "";
    }

    SimpleDateFormat format =
            new SimpleDateFormat("MM/dd/yyyy");

    return format.format(date);
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
        jPanel21 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        cmbReportType = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        lblLostItems = new javax.swing.JLabel();
        lblFoundItems = new javax.swing.JLabel();
        lblApprovedClaims = new javax.swing.JLabel();
        lblRejectedClaims = new javax.swing.JLabel();
        lblUnclaimedItems = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblReports = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        txtDateTo = new javax.swing.JLabel();
        txtDateFrom = new javax.swing.JLabel();

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

        jPanel21.setBackground(new java.awt.Color(204, 255, 255));

        jLabel4.setBackground(new java.awt.Color(124, 249, 249));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("LOST AND FOUND REPORTS");
        jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel4.setOpaque(true);

        jLabel11.setBackground(new java.awt.Color(124, 249, 249));
        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel11.setText("   Filter Reports");
        jLabel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel11.setOpaque(true);

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("Date From:");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("Date To:");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setText("Report Type:");

        cmbReportType.setBackground(new java.awt.Color(255, 255, 255));
        cmbReportType.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cmbReportType.setForeground(new java.awt.Color(0, 0, 0));
        cmbReportType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All Reports", "Lost Items", "Found Items", "Claims", " " }));
        cmbReportType.addActionListener(this::cmbReportTypeActionPerformed);

        jButton1.setBackground(new java.awt.Color(153, 204, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("GENERATE REPORT");
        jButton1.addActionListener(this::jButton1ActionPerformed);

        jLabel18.setBackground(new java.awt.Color(124, 249, 249));
        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 0, 0));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel18.setText("   Summary");
        jLabel18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel18.setOpaque(true);

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 0, 0));
        jLabel19.setText("Lost Items Reported:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Found Items Reported:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Claims Approved:");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Claims Rejected:");

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 0, 0));
        jLabel21.setText("Unclaimed Items:");

        lblLostItems.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblLostItems.setForeground(new java.awt.Color(0, 0, 0));
        lblLostItems.setText("0");

        lblFoundItems.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblFoundItems.setForeground(new java.awt.Color(0, 0, 0));
        lblFoundItems.setText("0");

        lblApprovedClaims.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblApprovedClaims.setForeground(new java.awt.Color(0, 0, 0));
        lblApprovedClaims.setText("0");

        lblRejectedClaims.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblRejectedClaims.setForeground(new java.awt.Color(0, 0, 0));
        lblRejectedClaims.setText("0");

        lblUnclaimedItems.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblUnclaimedItems.setForeground(new java.awt.Color(0, 0, 0));
        lblUnclaimedItems.setText("0");

        jLabel20.setBackground(new java.awt.Color(124, 249, 249));
        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 0, 0));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel20.setText("   Report Results");
        jLabel20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel20.setOpaque(true);

        tblReports.setBackground(new java.awt.Color(255, 255, 255));
        tblReports.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        tblReports.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        tblReports.setForeground(new java.awt.Color(0, 0, 0));
        tblReports.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Item Name", "Type", "Date", "Location", "Status"
            }
        ));
        tblReports.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tblReports.setGridColor(new java.awt.Color(0, 0, 0));
        tblReports.setRowHeight(80);
        tblReports.setSelectionForeground(new java.awt.Color(114, 191, 191));
        tblReports.setShowGrid(true);
        jScrollPane5.setViewportView(tblReports);
        tblReports.getTableHeader().setBackground(new java.awt.Color(0,51,51));
        tblReports.getTableHeader().setFont(
            new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 18)
        );

        jButton2.setBackground(new java.awt.Color(232, 239, 255));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 0, 0));
        jButton2.setText("EXPORT TO PDF");

        jButton16.setBackground(new java.awt.Color(232, 239, 255));
        jButton16.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jButton16.setForeground(new java.awt.Color(0, 0, 0));
        jButton16.setText("EXPORT TO EXCEL");
        jButton16.addActionListener(this::jButton16ActionPerformed);

        jButton17.setBackground(new java.awt.Color(232, 239, 255));
        jButton17.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jButton17.setForeground(new java.awt.Color(0, 0, 0));
        jButton17.setText("PRINT REPORT");

        txtDateTo.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        txtDateTo.setForeground(new java.awt.Color(0, 0, 0));
        txtDateTo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtDateTo.setText("10/15/2026");

        txtDateFrom.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        txtDateFrom.setForeground(new java.awt.Color(0, 0, 0));
        txtDateFrom.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtDateFrom.setText("09/23/2026");

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 1109, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel15)
                        .addGap(18, 18, 18)
                        .addComponent(txtDateFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel16)
                        .addGap(18, 18, 18)
                        .addComponent(txtDateTo, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel17)
                        .addGap(18, 18, 18)
                        .addComponent(cmbReportType, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addGap(101, 101, 101)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblApprovedClaims, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFoundItems, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLostItems, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblUnclaimedItems, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRejectedClaims, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31))
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5)
                .addContainerGap())
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel17)
                                .addComponent(txtDateTo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel16)
                                .addComponent(txtDateFrom)
                                .addComponent(jLabel15))
                            .addComponent(cmbReportType)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel18)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(lblLostItems))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(lblFoundItems))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(lblApprovedClaims)))
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGap(193, 193, 193)
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(lblRejectedClaims))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(lblUnclaimedItems))))
                .addGap(18, 18, 18)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
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
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLogout4, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jPanel21, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void cmbReportTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbReportTypeActionPerformed
        loadReports();
    }//GEN-LAST:event_cmbReportTypeActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        loadSummary();
        loadReports();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton16ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> {
            admin_reports frame = new admin_reports(1, "Jaycee Bryce");
            frame.setVisible(true);

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
    private javax.swing.JComboBox<String> cmbReportType;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton2;
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
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblApprovedClaims;
    private javax.swing.JLabel lblFoundItems;
    private javax.swing.JLabel lblLostItems;
    private javax.swing.JLabel lblRejectedClaims;
    private javax.swing.JLabel lblUnclaimedItems;
    private javax.swing.JTable tblReports;
    private javax.swing.JLabel txtDateFrom;
    private javax.swing.JLabel txtDateTo;
    // End of variables declaration//GEN-END:variables
}
