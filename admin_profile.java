
package cite_lostandfounddepartment_system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import org.mindrot.jbcrypt.BCrypt;
import javax.swing.JPasswordField;
import java.sql.SQLException;


public class admin_profile extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(admin_profile.class.getName());
    
      private void loadProfile() {

    String sql = "SELECT user_id, full_name, username, email, role, "
               + "account_status, phone, address, date_registered "
               + "FROM tbl_users "
               + "WHERE user_id = ? AND role = 'Admin'";

    try {

        Connection conn = DBConnection.connect();
        PreparedStatement pst = conn.prepareStatement(sql);

        pst.setInt(1, AdminUserId);

        ResultSet rs = pst.executeQuery();

        if (rs.next()) {

            lblUserId.setText(String.valueOf(rs.getInt("user_id")));
            lblFullName.setText(rs.getString("full_name"));
            lblUsername.setText(rs.getString("username"));
            lblEmail.setText(rs.getString("email"));
            lblRole.setText(rs.getString("role"));
            lblAccountStatus.setText(rs.getString("account_status"));

            if (rs.getTimestamp("date_registered") != null) {
                java.text.SimpleDateFormat dateFormat =
                        new java.text.SimpleDateFormat("MM/dd/yyyy");

                lblDateRegistered.setText(
                        dateFormat.format(rs.getTimestamp("date_registered"))
                );
            } else {
                lblDateRegistered.setText("N/A");
            }

            String phone = rs.getString("phone");
            lblPhone.setText(
                    phone != null && !phone.isEmpty() ? phone : "N/A"
            );

            String address = rs.getString("address");
            lblAddress.setText(
                    address != null && !address.isEmpty() ? address : "N/A"
            );

            // Never display the actual password
            lblPassword.setText("********");

        } else {

            JOptionPane.showMessageDialog(
                    this,
                    "Admin profile not found.",
                    "Profile",
                    JOptionPane.WARNING_MESSAGE
            );
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
}
    
    private int AdminUserId;
    private String AdminFullName;



    public admin_profile(int AdminUserId, String fullName) {
        initComponents();
        
        this.AdminUserId = AdminUserId;
        this.AdminFullName = fullName;

        setLocationRelativeTo(null);
        
        loadProfile();
    }
    
  private void changeAdminPassword() {

    JPasswordField currentField = new JPasswordField();
    JPasswordField newField = new JPasswordField();
    JPasswordField confirmField = new JPasswordField();

    Object[] fields = {
        "Current password:", currentField,
        "New password:", newField,
        "Confirm new password:", confirmField
    };

    int choice = JOptionPane.showConfirmDialog(
        this,
        fields,
        "Change Password",
        JOptionPane.OK_CANCEL_OPTION,
        JOptionPane.PLAIN_MESSAGE
    );

    if (choice != JOptionPane.OK_OPTION) {
        return;
    }

    String currentPassword = new String(currentField.getPassword());
    String newPassword = new String(newField.getPassword());
    String confirmPassword = new String(confirmField.getPassword());

    if (currentPassword.isEmpty()
            || newPassword.isEmpty()
            || confirmPassword.isEmpty()) {
        JOptionPane.showMessageDialog(
            this, "Please complete all password fields.");
        return;
    }

    if (newPassword.length() < 8) {
        JOptionPane.showMessageDialog(
            this, "Your new password must be at least 8 characters.");
        return;
    }

    if (!newPassword.equals(confirmPassword)) {
        JOptionPane.showMessageDialog(
            this, "The new passwords do not match.");
        return;
    }

    String selectSql =
        "SELECT password FROM tbl_users WHERE user_id = ?";

    String updateSql =
        "UPDATE tbl_users SET password = ? WHERE user_id = ?";

    String url =
        "jdbc:mysql://localhost:3306/cite_lostandfounddepartment_system";

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");

        try (Connection con =
                java.sql.DriverManager.getConnection(url, "root", "");
             PreparedStatement selectPst =
                con.prepareStatement(selectSql)) {

            selectPst.setInt(1, AdminUserId);

            try (ResultSet rs = selectPst.executeQuery()) {

                if (!rs.next()) {
                    JOptionPane.showMessageDialog(
                        this, "Student account not found.");
                    return;
                }

                String storedHash = rs.getString("password");

                if (storedHash == null
                        || !BCrypt.checkpw(currentPassword, storedHash)) {
                    JOptionPane.showMessageDialog(
                        this, "Your current password is incorrect.");
                    return;
                }
            }

            String newHash = BCrypt.hashpw(
                newPassword, BCrypt.gensalt(12));

            try (PreparedStatement updatePst =
                    con.prepareStatement(updateSql)) {

                updatePst.setString(1, newHash);
                updatePst.setInt(2, AdminUserId);

                int rows = updatePst.executeUpdate();

                if (rows > 0) {
                    JOptionPane.showMessageDialog(
                        this, "Password changed successfully!");
                } else {
                    JOptionPane.showMessageDialog(
                        this, "Password was not changed.");
                }
            }
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(
            this,
            "Unable to change password: " + e.getMessage(),
            "Database Error",
            JOptionPane.ERROR_MESSAGE);
        e.printStackTrace();
    }
  }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel17 = new javax.swing.JPanel();
        btnHome4 = new javax.swing.JButton();
        btnViewLostItems4 = new javax.swing.JButton();
        btnLogout4 = new javax.swing.JButton();
        btnViewFoundItems = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        btnStudentReports = new javax.swing.JButton();
        btnReports = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        btnReports1 = new javax.swing.JButton();
        btnProfile = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnEditProfile = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblUserId = new javax.swing.JLabel();
        lblFullName = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblRole = new javax.swing.JLabel();
        lblAccountStatus = new javax.swing.JLabel();
        lblDateRegistered = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lblPhone = new javax.swing.JLabel();
        lblAddress = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        btnEditProfile1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel17.setBackground(new java.awt.Color(0, 102, 102));
        jPanel17.setAutoscrolls(true);

        btnHome4.setBackground(new java.awt.Color(0, 100, 100));
        btnHome4.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        btnHome4.setForeground(new java.awt.Color(255, 255, 255));
        btnHome4.setIcon(new javax.swing.ImageIcon("C:\\Users\\abbyg\\OneDrive\\Pictures\\icons\\home.png")); // NOI18N
        btnHome4.setText("Dashboard");
        btnHome4.setBorder(null);
        btnHome4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnHome4.addActionListener(this::btnHome4ActionPerformed);

        btnViewLostItems4.setBackground(new java.awt.Color(0, 102, 102));
        btnViewLostItems4.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        btnViewLostItems4.setForeground(new java.awt.Color(255, 255, 255));
        btnViewLostItems4.setIcon(new javax.swing.ImageIcon("C:\\Users\\abbyg\\OneDrive\\Pictures\\icons\\view lost items.png")); // NOI18N
        btnViewLostItems4.setText("Lost Items");
        btnViewLostItems4.setBorder(null);
        btnViewLostItems4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnViewLostItems4.addActionListener(this::btnViewLostItems4ActionPerformed);

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

        btnStudentReports.setBackground(new java.awt.Color(0, 102, 102));
        btnStudentReports.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        btnStudentReports.setForeground(new java.awt.Color(255, 255, 255));
        btnStudentReports.setIcon(new javax.swing.ImageIcon("C:\\Users\\abbyg\\OneDrive\\Pictures\\icons\\view found items.png")); // NOI18N
        btnStudentReports.setText("Claims");
        btnStudentReports.setBorder(null);
        btnStudentReports.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnStudentReports.addActionListener(this::btnStudentReportsActionPerformed);

        btnReports.setBackground(new java.awt.Color(0, 102, 102));
        btnReports.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        btnReports.setForeground(new java.awt.Color(255, 255, 255));
        btnReports.setIcon(new javax.swing.ImageIcon("C:\\Users\\abbyg\\OneDrive\\Pictures\\icons\\users.png")); // NOI18N
        btnReports.setText("Users");
        btnReports.setBorder(null);
        btnReports.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnReports.addActionListener(this::btnReportsActionPerformed);

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

        btnReports1.setBackground(new java.awt.Color(0, 102, 102));
        btnReports1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        btnReports1.setForeground(new java.awt.Color(255, 255, 255));
        btnReports1.setIcon(new javax.swing.ImageIcon("C:\\Users\\abbyg\\OneDrive\\Pictures\\icons\\claims.png")); // NOI18N
        btnReports1.setText("Reports");
        btnReports1.setBorder(null);
        btnReports1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnReports1.addActionListener(this::btnReports1ActionPerformed);

        btnProfile.setBackground(new java.awt.Color(0, 102, 102));
        btnProfile.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        btnProfile.setForeground(new java.awt.Color(255, 255, 255));
        btnProfile.setIcon(new javax.swing.ImageIcon("C:\\Users\\abbyg\\OneDrive\\Pictures\\icons\\claims.png")); // NOI18N
        btnProfile.setText("Profile");
        btnProfile.setBorder(null);
        btnProfile.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnProfile.addActionListener(this::btnProfileActionPerformed);

        jPanel6.setBackground(new java.awt.Color(204, 255, 255));

        jLabel37.setBackground(new java.awt.Color(124, 249, 249));
        jLabel37.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(0, 0, 0));
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setText("MY PROFILE");
        jLabel37.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel37.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel37.setOpaque(true);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));

        jLabel1.setBackground(new java.awt.Color(124, 249, 249));
        jLabel1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("  Account Information");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));
        jLabel1.setOpaque(true);

        btnEditProfile.setBackground(new java.awt.Color(124, 249, 249));
        btnEditProfile.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        btnEditProfile.setForeground(new java.awt.Color(0, 0, 0));
        btnEditProfile.setText("Edit Profile");
        btnEditProfile.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));
        btnEditProfile.addActionListener(this::btnEditProfileActionPerformed);

        jLabel2.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("User ID:");

        jLabel3.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Full Name:");

        jLabel4.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Username:");

        jLabel5.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Email:");

        jLabel6.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Role:");

        jLabel7.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Account Status:");

        jLabel8.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Date Registered:");

        lblUserId.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        lblUserId.setForeground(new java.awt.Color(0, 0, 0));
        lblUserId.setText("11111");

        lblFullName.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        lblFullName.setForeground(new java.awt.Color(0, 0, 0));
        lblFullName.setText("Name");

        lblUsername.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        lblUsername.setForeground(new java.awt.Color(0, 0, 0));
        lblUsername.setText("Username");

        lblEmail.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        lblEmail.setForeground(new java.awt.Color(0, 0, 0));
        lblEmail.setText("Email");

        lblRole.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        lblRole.setForeground(new java.awt.Color(0, 0, 0));
        lblRole.setText("Role");

        lblAccountStatus.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        lblAccountStatus.setForeground(new java.awt.Color(0, 0, 0));
        lblAccountStatus.setText("Status");

        lblDateRegistered.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        lblDateRegistered.setForeground(new java.awt.Color(0, 0, 0));
        lblDateRegistered.setText("Date ");

        jLabel15.setBackground(new java.awt.Color(124, 249, 249));
        jLabel15.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText(" Contact Information");
        jLabel15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));
        jLabel15.setOpaque(true);

        jLabel9.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Phone Number:");

        jLabel10.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Address:");

        jLabel11.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Password:");

        jLabel16.setBackground(new java.awt.Color(124, 249, 249));
        jLabel16.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText(" Security");
        jLabel16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));
        jLabel16.setOpaque(true);

        lblPhone.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        lblPhone.setForeground(new java.awt.Color(0, 0, 0));
        lblPhone.setText("1111111");

        lblAddress.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        lblAddress.setForeground(new java.awt.Color(0, 0, 0));
        lblAddress.setText("Address");

        lblPassword.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        lblPassword.setForeground(new java.awt.Color(0, 0, 0));
        lblPassword.setText("*********");

        btnEditProfile1.setBackground(new java.awt.Color(124, 249, 249));
        btnEditProfile1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        btnEditProfile1.setForeground(new java.awt.Color(0, 0, 0));
        btnEditProfile1.setText("Change Password");
        btnEditProfile1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));
        btnEditProfile1.addActionListener(this::btnEditProfile1ActionPerformed);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 586, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(170, 170, 170)
                                .addComponent(lblUserId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel11))
                                .addGap(103, 103, 103)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblFullName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblUsername, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblRole, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblAccountStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblDateRegistered, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblPhone)
                                            .addComponent(lblAddress)
                                            .addComponent(lblPassword))
                                        .addGap(0, 0, Short.MAX_VALUE))))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEditProfile1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUserId)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblFullName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblUsername)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblEmail)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblRole))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAccountStatus)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDateRegistered)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(lblPhone))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(lblAddress))
                .addGap(18, 18, 18)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(lblPassword))
                .addGap(4, 4, 4)
                .addComponent(btnEditProfile1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(163, 163, 163)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(161, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                                .addComponent(btnViewLostItems4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnHome4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jSeparator2)
                                .addComponent(btnLogout4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel14)
                                .addComponent(btnReports1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(btnReports, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnViewFoundItems, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnStudentReports, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addComponent(btnHome4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnViewLostItems4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnViewFoundItems, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnStudentReports, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnReports, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnReports1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLogout4, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void btnHome4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHome4ActionPerformed
        admin_homepage home = new admin_homepage(AdminUserId, AdminFullName);
        home.setLocationRelativeTo(null);
        home.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnHome4ActionPerformed

    private void btnViewLostItems4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewLostItems4ActionPerformed
        admin_lost_items lost = new admin_lost_items(AdminUserId, AdminFullName);
        lost.setLocationRelativeTo(null);
        lost.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnViewLostItems4ActionPerformed

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

    private void btnStudentReportsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStudentReportsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnStudentReportsActionPerformed

    private void btnReportsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnReportsActionPerformed

    private void btnReports1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReports1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnReports1ActionPerformed

    private void btnProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProfileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnProfileActionPerformed

    private void btnEditProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditProfileActionPerformed
        admin_edit_profile edit = new admin_edit_profile(this, AdminUserId, AdminFullName);
        edit.setLocationRelativeTo(this);
        edit.setVisible(true);
        this.dispose();
   
    }//GEN-LAST:event_btnEditProfileActionPerformed

    private void btnEditProfile1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditProfile1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditProfile1ActionPerformed


    public static void main(String args[]) {

java.awt.EventQueue.invokeLater(() -> new profileframe(1).setVisible(true));
    }
                

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditProfile;
    private javax.swing.JButton btnEditProfile1;
    private javax.swing.JButton btnHome4;
    private javax.swing.JButton btnLogout4;
    private javax.swing.JButton btnProfile;
    private javax.swing.JButton btnReports;
    private javax.swing.JButton btnReports1;
    private javax.swing.JButton btnStudentReports;
    private javax.swing.JButton btnViewFoundItems;
    private javax.swing.JButton btnViewLostItems4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblAccountStatus;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblDateRegistered;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblFullName;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JLabel lblRole;
    private javax.swing.JLabel lblUserId;
    private javax.swing.JLabel lblUsername;
    // End of variables declaration//GEN-END:variables

    void loadProfileData() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
