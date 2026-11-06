
package cite_lostandfounddepartment_system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.SQLException;


public class editprofileframe extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(editprofileframe.class.getName());
    
    private int studentUserId;
    private profileframe parentProfile;
    
    private final String url = "jdbc:mysql://localhost:3306/cite_lostandfounddepartment_system";
    private final String dbUser = "root";
    private final String dbPassword = "";
    

    
    public editprofileframe(int userId, profileframe parent) {
        
        initComponents();
        
        this.studentUserId = userId;
        this.parentProfile = parent;
        
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

            pst.setInt(1, studentUserId);

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

        btnEditProfile = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btnHome = new javax.swing.JButton();
        btnViewLostItems = new javax.swing.JButton();
        btnClaimsRecords = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
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
        btnViewFoundItems = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        btnReportLostItem1 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        btnReportFoundItem1 = new javax.swing.JButton();
        btnProfile = new javax.swing.JButton();

        btnEditProfile.setBackground(new java.awt.Color(124, 249, 249));
        btnEditProfile.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        btnEditProfile.setForeground(new java.awt.Color(0, 0, 0));
        btnEditProfile.setText("Edit Profile");
        btnEditProfile.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));

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
                        .addGap(0, 208, Short.MAX_VALUE)))
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
                    .addComponent(btnViewLostItems, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnReportFoundItem1, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                    .addComponent(btnHome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnReportLostItem1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLogout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnClaimsRecords, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator2)
                    .addComponent(btnProfile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel13)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1370, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 693, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
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

    private void txtNewPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNewPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNewPasswordActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed

    String fullName = txtFullName.getText().trim();
    String usernameValue = txtUsername.getText().trim();
    String emailValue = txtEmail.getText().trim();
    String phoneValue = txtPhone.getText().trim();
    String addressValue = txtAddress.getText().trim();

    char[] newChars = txtNewPassword.getPassword();
    char[] confirmChars = txtConfirmPassword.getPassword();

    String newPassword = new String(newChars);
    String confirmPassword = new String(confirmChars);

    boolean changingPassword = !newPassword.isEmpty()
            || !confirmPassword.isEmpty();

    if (fullName.isEmpty() || usernameValue.isEmpty()
            || emailValue.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please complete all required fields.");
        return;
    }

    if (!emailValue.matches("^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$")) {
        JOptionPane.showMessageDialog(this, "Please enter a valid email address.");
        return;
    }

    if (changingPassword) {
        if (newPassword.isEmpty() || confirmPassword.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Complete both password fields.");
            return;
        }

        if (newPassword.length() < 8) {
            JOptionPane.showMessageDialog(this, "New password must be at least 8 characters.");
            return;
        }

        if (!newPassword.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(this, "The new passwords do not match.");
            return;
        }
    }

    String url = "jdbc:mysql://localhost:3306/cite_lostandfounddepartment_system";
    String selectSql = "SELECT password FROM tbl_users WHERE user_id = ?";
    String updateProfileSql = "UPDATE tbl_users SET full_name = ?, username = ?, "
        + "email = ?, phone = ?, address = ? WHERE user_id = ?";

    String updatePasswordSql = "UPDATE tbl_users SET password = ? WHERE user_id = ?";

    String currentPassword = "";

    if (changingPassword) {
        javax.swing.JPasswordField currentField = new javax.swing.JPasswordField();

        int choice = JOptionPane.showConfirmDialog(this,new Object[] {"Enter your current password:", currentField}, "Verify Your Identity", JOptionPane.OK_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE);

        if (choice != JOptionPane.OK_OPTION) {
            return;
        }

        currentPassword = new String(currentField.getPassword());

        if (currentPassword.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Current password is required.");
            return;
        }
    }

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");

        try (Connection con = DriverManager.getConnection(url, "root", "")) {

            if (changingPassword) {
                String storedHash;
                
                try (PreparedStatement pst = con.prepareStatement(selectSql)) {

                    pst.setInt(1, studentUserId);

                    try (ResultSet rs = pst.executeQuery()) {
                        if (!rs.next()) {
                            JOptionPane.showMessageDialog(this, "Student account not found."); 
                            return;
                        }

                        storedHash = rs.getString("password");
                    }
                }

                if (storedHash == null
                        || !org.mindrot.jbcrypt.BCrypt.checkpw(
                                currentPassword, storedHash)) {
                    JOptionPane.showMessageDialog(this, "Current password is incorrect.");
                    return;
                }
            }

            con.setAutoCommit(false);

            try {
                try (PreparedStatement pst =
                        con.prepareStatement(updateProfileSql)) {

                    pst.setString(1, fullName);
                    pst.setString(2, usernameValue);
                    pst.setString(3, emailValue);
                    pst.setString(4, phoneValue);
                    pst.setString(5, addressValue);
                    pst.setInt(6, studentUserId);

                    pst.executeUpdate();
                }

                if (changingPassword) {
                    String newHash = org.mindrot.jbcrypt.BCrypt.hashpw(newPassword,org.mindrot.jbcrypt.BCrypt.gensalt(12));
                    try (PreparedStatement pst = con.prepareStatement(updatePasswordSql)) {

                        pst.setString(1, newHash);
                        pst.setInt(2, studentUserId);
                        pst.executeUpdate();
                    }
                }

                con.commit();

            } catch (Exception e) {
                con.rollback();
                throw e;
            }

            JOptionPane.showMessageDialog(this, changingPassword? "Profile and password updated successfully!" : "Profile updated successfully!");
            if (parentProfile != null) {
                parentProfile.loadProfileData();
            }

            dispose();
        }

    } catch (java.sql.SQLIntegrityConstraintViolationException e) {
        JOptionPane.showMessageDialog(
                this, "That username or email is already in use.");

    } catch (Exception e) {
        JOptionPane.showMessageDialog(
                this,
                "Unable to save changes: " + e.getMessage(),
                "Database Error",
                JOptionPane.ERROR_MESSAGE);
        e.printStackTrace();

    } finally {
        java.util.Arrays.fill(newChars, '\0');
        java.util.Arrays.fill(confirmChars, '\0');
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
    profileframe profile = new profileframe(studentUserId);
    profile.setLocationRelativeTo(this);
    profile.setVisible(true);
    }//GEN-LAST:event_btnCancelActionPerformed

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(() -> {
        javax.swing.JOptionPane.showMessageDialog(null,"Please open Edit Profile through the Student Profile page.");
    });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnClaimsRecords;
    private javax.swing.JButton btnEditProfile;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnProfile;
    private javax.swing.JButton btnReportFoundItem1;
    private javax.swing.JButton btnReportLostItem1;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnViewFoundItems;
    private javax.swing.JButton btnViewLostItems;
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
    private javax.swing.JPanel jPanel1;
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
