
package cite_lostandfounddepartment_system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.SQLException;


public class admin_edit_profile extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(admin_edit_profile.class.getName());
    
    private int AdminUserId;
    private String AdminFullName;
    private admin_profile parentProfile;
    
        private final String url = "jdbc:mysql://localhost:3306/cite_lostandfounddepartment_system";
    private final String dbUser = "root";
    private final String dbPassword = "";



    public admin_edit_profile(admin_profile parentProfile, int AdminUserId, String AdminFullName) {
        initComponents();

            this.AdminUserId = AdminUserId;
    this.AdminFullName = AdminFullName;
    this.parentProfile = parentProfile;
        
        setLocationRelativeTo(null);
        
        loadUserData();
        
    }
private void loadUserData() {

    String sql = "SELECT full_name, username, email, phone, address "
               + "FROM tbl_users WHERE user_id = ?";

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");

        try (Connection con =
                DriverManager.getConnection(url, dbUser, dbPassword);
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setInt(1, AdminUserId);

            try (ResultSet rs = pst.executeQuery()) {

                if (rs.next()) {
                    txtFullName.setText(rs.getString("full_name"));
                    txtUsername.setText(rs.getString("username"));
                    txtEmail.setText(rs.getString("email"));
                    txtPhone.setText(rs.getString("phone"));
                    txtAddress.setText(rs.getString("address"));

                    // Leave password blank.
                    txtNewPassword.setText("");

                } else {
                    JOptionPane.showMessageDialog(
                            this, "Student account not found.");
                }
            }
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(
                this,
                "Unable to load profile: " + e.getMessage(),
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
        jLabel15 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtFullName = new javax.swing.JTextField();
        txtUsername = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtPhone = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        txtNewPassword = new javax.swing.JPasswordField();
        btnSave = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        chkNewPassword = new javax.swing.JCheckBox();
        chkConfirmPassword = new javax.swing.JCheckBox();
        btnCancel = new javax.swing.JButton();
        txtConfirmPassword = new javax.swing.JPasswordField();

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
        jLabel37.setText("EDIT PROFILE");
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
        jLabel11.setText("New Password:");

        jLabel16.setBackground(new java.awt.Color(124, 249, 249));
        jLabel16.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText(" Security");
        jLabel16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));
        jLabel16.setOpaque(true);

        txtFullName.setBackground(new java.awt.Color(255, 255, 255));
        txtFullName.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        txtFullName.setForeground(new java.awt.Color(0, 0, 0));
        txtFullName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));

        txtUsername.setBackground(new java.awt.Color(255, 255, 255));
        txtUsername.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        txtUsername.setForeground(new java.awt.Color(0, 0, 0));
        txtUsername.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));

        txtEmail.setBackground(new java.awt.Color(255, 255, 255));
        txtEmail.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        txtEmail.setForeground(new java.awt.Color(0, 0, 0));
        txtEmail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));

        txtPhone.setBackground(new java.awt.Color(255, 255, 255));
        txtPhone.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        txtPhone.setForeground(new java.awt.Color(0, 0, 0));
        txtPhone.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));

        txtAddress.setBackground(new java.awt.Color(255, 255, 255));
        txtAddress.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        txtAddress.setForeground(new java.awt.Color(0, 0, 0));
        txtAddress.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));

        txtNewPassword.setBackground(new java.awt.Color(255, 255, 255));
        txtNewPassword.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        txtNewPassword.setForeground(new java.awt.Color(0, 0, 0));
        txtNewPassword.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));
        txtNewPassword.addActionListener(this::txtNewPasswordActionPerformed);

        btnSave.setBackground(new java.awt.Color(124, 249, 249));
        btnSave.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        btnSave.setForeground(new java.awt.Color(0, 0, 0));
        btnSave.setText("Save");
        btnSave.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));
        btnSave.addActionListener(this::btnSaveActionPerformed);

        jLabel3.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Full Name:");

        jLabel4.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Username:");

        jLabel5.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Email:");

        jLabel17.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setText("Confirm Password:");

        chkNewPassword.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        chkNewPassword.addActionListener(this::chkNewPasswordActionPerformed);

        chkConfirmPassword.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        chkConfirmPassword.addActionListener(this::chkConfirmPasswordActionPerformed);

        btnCancel.setBackground(new java.awt.Color(124, 249, 249));
        btnCancel.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        btnCancel.setForeground(new java.awt.Color(0, 0, 0));
        btnCancel.setText("Cancel");
        btnCancel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));
        btnCancel.addActionListener(this::btnCancelActionPerformed);

        txtConfirmPassword.setBackground(new java.awt.Color(255, 255, 255));
        txtConfirmPassword.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        txtConfirmPassword.setForeground(new java.awt.Color(0, 0, 0));
        txtConfirmPassword.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9))
                        .addGap(11, 11, 11))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addGap(41, 41, 41)))
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel17)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnCancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(6, 6, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtNewPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtConfirmPassword, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chkNewPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chkConfirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtUsername, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 512, Short.MAX_VALUE)
                            .addComponent(txtFullName, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEmail))
                        .addGap(46, 46, 46))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtFullName, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNewPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(chkNewPassword, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(chkConfirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtConfirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(163, 163, 163)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 209, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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

    private void txtNewPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNewPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNewPasswordActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed

           String fullName = txtFullName.getText().trim();
    String username = txtUsername.getText().trim();
    String email = txtEmail.getText().trim();
    String phone = txtPhone.getText().trim();
    String address = txtAddress.getText().trim();

    String newPassword = new String(txtNewPassword.getPassword());
    String confirmPassword = new String(txtConfirmPassword.getPassword());

    // Basic validation
    if (fullName.isEmpty() ||
        username.isEmpty() ||
        email.isEmpty()) {

        JOptionPane.showMessageDialog(
            this,
            "Please fill in Full Name, Username, and Email.",
            "Missing Information",
            JOptionPane.WARNING_MESSAGE
        );
        return;
    }

    // Check password confirmation only if a new password was entered
    if (!newPassword.isEmpty()) {

        if (!newPassword.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(
                this,
                "New password and confirm password do not match.",
                "Password Error",
                JOptionPane.WARNING_MESSAGE
            );
            return;
        }
    }

    try {

        Connection conn = DBConnection.connect();

        String sql;

        PreparedStatement pst;

        // If password was NOT changed
        if (newPassword.isEmpty()) {

            sql = "UPDATE tbl_users SET "
                    + "full_name = ?, "
                    + "username = ?, "
                    + "email = ?, "
                    + "phone = ?, "
                    + "address = ? "
                    + "WHERE user_id = ?";

            pst = conn.prepareStatement(sql);

            pst.setString(1, fullName);
            pst.setString(2, username);
            pst.setString(3, email);
            pst.setString(4, phone);
            pst.setString(5, address);
            pst.setInt(6, AdminUserId);

        } else {

            // If password WAS changed
            sql = "UPDATE tbl_users SET "
                    + "full_name = ?, "
                    + "username = ?, "
                    + "email = ?, "
                    + "phone = ?, "
                    + "address = ?, "
                    + "password = ? "
                    + "WHERE user_id = ?";

            pst = conn.prepareStatement(sql);

            pst.setString(1, fullName);
            pst.setString(2, username);
            pst.setString(3, email);
            pst.setString(4, phone);
            pst.setString(5, address);
            pst.setString(6, newPassword);
            pst.setInt(7, AdminUserId);
        }

        int rowsUpdated = pst.executeUpdate();

        if (rowsUpdated > 0) {

            JOptionPane.showMessageDialog(
                this,
                "Profile updated successfully!",
                "Success",
                JOptionPane.INFORMATION_MESSAGE
            );

            pst.close();
            conn.close();

            // Return to Admin Profile
            admin_profile profile = new admin_profile(
                AdminUserId,
                fullName
            );

            profile.setLocationRelativeTo(null);
            profile.setVisible(true);

            this.dispose();

        } else {

            JOptionPane.showMessageDialog(
                this,
                "Unable to update profile. User account was not found.",
                "Update Failed",
                JOptionPane.ERROR_MESSAGE
            );

            pst.close();
            conn.close();
        }

    } catch (SQLException e) {

        JOptionPane.showMessageDialog(
            this,
            "Database Error: " + e.getMessage(),
            "Database Error",
            JOptionPane.ERROR_MESSAGE
        );
    }

    }//GEN-LAST:event_btnSaveActionPerformed

    private void chkNewPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkNewPasswordActionPerformed
        if (chkNewPassword.isSelected()) {
            txtNewPassword.setEchoChar((char) 0);
        } else {
            txtNewPassword.setEchoChar('•');
        }
    }//GEN-LAST:event_chkNewPasswordActionPerformed

    private void chkConfirmPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkConfirmPasswordActionPerformed
        if (chkConfirmPassword.isSelected()) {
            txtConfirmPassword.setEchoChar((char) 0);
        } else {
            txtConfirmPassword.setEchoChar('•');
        }
    }//GEN-LAST:event_chkConfirmPasswordActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
           admin_profile profile = new admin_profile(AdminUserId, AdminFullName);
    profile.setLocationRelativeTo(null);
    profile.setVisible(true);
    }//GEN-LAST:event_btnCancelActionPerformed


    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> {
        javax.swing.JOptionPane.showMessageDialog(null,"Please open Edit Profile through the Student Profile page.");
    });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnHome4;
    private javax.swing.JButton btnLogout4;
    private javax.swing.JButton btnProfile;
    private javax.swing.JButton btnReports;
    private javax.swing.JButton btnReports1;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnStudentReports;
    private javax.swing.JButton btnViewFoundItems;
    private javax.swing.JButton btnViewLostItems4;
    private javax.swing.JCheckBox chkConfirmPassword;
    private javax.swing.JCheckBox chkNewPassword;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JPasswordField txtConfirmPassword;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFullName;
    private javax.swing.JPasswordField txtNewPassword;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
