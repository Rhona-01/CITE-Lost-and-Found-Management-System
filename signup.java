
package cite_lostandfounddepartment_system;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement ;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import org.mindrot.jbcrypt.BCrypt;


public class signup extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(signup.class.getName());


    public signup() {
        initComponents();
        
        this.setResizable(true);
        this.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        fullName = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        btnSignUp = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        username = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        student_id = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        chkShowPassword = new javax.swing.JCheckBox();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        phone = new javax.swing.JTextField();
        address = new javax.swing.JTextField();
        password = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(21, 82, 82));

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("LOST AND FOUND");

        jLabel8.setBackground(new java.awt.Color(0, 0, 0));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("MANAGEMENT SYSTEM");

        jLabel10.setBackground(new java.awt.Color(0, 0, 0));
        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("CITE Department");

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setIcon(new javax.swing.ImageIcon("C:\\Users\\abbyg\\OneDrive\\Pictures\\icons\\system logo big.png")); // NOI18N

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jPanel4.setBackground(new java.awt.Color(204, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 204), 5));
        jPanel4.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.setPreferredSize(new java.awt.Dimension(586, 554));

        jLabel18.setBackground(new java.awt.Color(124, 249, 249));
        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 51, 51));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Sign Up");
        jLabel18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel18.setOpaque(true);

        jLabel19.setFont(new java.awt.Font("Microsoft YaHei", 0, 20)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 0, 0));
        jLabel19.setText("Full Name");

        fullName.setBackground(new java.awt.Color(204, 255, 255));
        fullName.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        fullName.setForeground(new java.awt.Color(0, 0, 0));
        fullName.addActionListener(this::fullNameActionPerformed);

        jLabel20.setFont(new java.awt.Font("Microsoft YaHei", 0, 20)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 0, 0));
        jLabel20.setText("Password");

        btnSignUp.setBackground(new java.awt.Color(124, 249, 249));
        btnSignUp.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnSignUp.setForeground(new java.awt.Color(0, 51, 51));
        btnSignUp.setText("Sign Up");
        btnSignUp.addActionListener(this::btnSignUpActionPerformed);

        jLabel21.setFont(new java.awt.Font("Microsoft YaHei", 0, 20)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 0, 0));
        jLabel21.setText("Already have an account?");

        btnLogin.setBackground(new java.awt.Color(124, 249, 249));
        btnLogin.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(0, 51, 51));
        btnLogin.setText("Login");
        btnLogin.addActionListener(this::btnLoginActionPerformed);

        username.setBackground(new java.awt.Color(204, 255, 255));
        username.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        username.setForeground(new java.awt.Color(0, 0, 0));
        username.addActionListener(this::usernameActionPerformed);

        jLabel22.setFont(new java.awt.Font("Microsoft YaHei", 0, 20)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 0, 0));
        jLabel22.setText("Student ID");

        student_id.setBackground(new java.awt.Color(204, 255, 255));
        student_id.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        student_id.setForeground(new java.awt.Color(0, 0, 0));

        email.setBackground(new java.awt.Color(204, 255, 255));
        email.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        email.setForeground(new java.awt.Color(0, 0, 0));

        jLabel23.setFont(new java.awt.Font("Microsoft YaHei", 0, 20)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 0, 0));
        jLabel23.setText("Email");

        jLabel24.setFont(new java.awt.Font("Microsoft YaHei", 0, 20)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(0, 0, 0));
        jLabel24.setText("Username");

        chkShowPassword.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        chkShowPassword.setForeground(new java.awt.Color(0, 0, 0));
        chkShowPassword.setText("Show Password");
        chkShowPassword.addActionListener(this::chkShowPasswordActionPerformed);

        jLabel25.setFont(new java.awt.Font("Microsoft YaHei", 0, 20)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(0, 0, 0));
        jLabel25.setText("Phone");

        jLabel26.setFont(new java.awt.Font("Microsoft YaHei", 0, 20)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(0, 0, 0));
        jLabel26.setText("Address");

        phone.setBackground(new java.awt.Color(204, 255, 255));
        phone.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        phone.setForeground(new java.awt.Color(0, 0, 0));
        phone.addActionListener(this::phoneActionPerformed);

        address.setBackground(new java.awt.Color(204, 255, 255));
        address.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        address.setForeground(new java.awt.Color(0, 0, 0));
        address.addActionListener(this::addressActionPerformed);

        password.setBackground(new java.awt.Color(204, 255, 255));
        password.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        password.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 100, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addGap(18, 18, 18)
                                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(204, 204, 204))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(chkShowPassword)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel23)
                                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel22)
                                                .addComponent(jLabel19))
                                            .addComponent(jLabel24)
                                            .addComponent(jLabel25)
                                            .addComponent(jLabel26)
                                            .addComponent(jLabel20))
                                        .addGap(54, 54, 54)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(student_id, javax.swing.GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE)
                                            .addComponent(fullName)
                                            .addComponent(username)
                                            .addComponent(phone)
                                            .addComponent(address, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(email)
                                            .addComponent(password)))
                                    .addComponent(btnSignUp, javax.swing.GroupLayout.PREFERRED_SIZE, 622, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(134, 134, 134))))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addComponent(fullName, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(student_id, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23)
                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(phone, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addComponent(chkShowPassword)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSignUp, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLogin)
                    .addComponent(jLabel21))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 446, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 876, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12)
                        .addGap(34, 34, 34)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 669, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fullNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fullNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fullNameActionPerformed

    private void btnSignUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignUpActionPerformed
    String fN, sID, eM, uN, pW, no, add;

try {
    Class.forName("com.mysql.cj.jdbc.Driver");

    String url = "jdbc:mysql://localhost:3306/cite_lostandfounddepartment_system";
    String user = "root";
    String pass = "";

    Connection con = DriverManager.getConnection(url, user, pass);

    if (fullName.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Full Name is required!");
    } else if (student_id.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Student ID is required!");
    } else if (email.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Email is required!");
    } else if (phone.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Phone number is required!");
    } else if (address.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Address is required!");
    } else if (username.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Username is required!");
    } else if (password.getText().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Password is required!");
    } else {
        fN = fullName.getText().trim();
        sID = student_id.getText().trim();
        eM = email.getText().trim();
        no = phone.getText().trim();
        add = address.getText().trim();
        uN = username.getText().trim();
        pW = BCrypt.hashpw(password.getText(), BCrypt.gensalt(12));

        String sql = "INSERT INTO tbl_users "
                   + "(full_name, student_id, email, username, password, phone, address) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, fN);
            pst.setString(2, sID);
            pst.setString(3, eM);
            pst.setString(4, uN);
            pst.setString(5, pW);
            pst.setString(6, no);
            pst.setString(7, add);

            pst.executeUpdate();
        }

        JOptionPane.showMessageDialog(
            this,
            "Account created successfully!",
            "Success",
            JOptionPane.INFORMATION_MESSAGE
        );

        // Open the login screen after signup.
        login loginFrame = new login();
        loginFrame.setLocationRelativeTo(null);
        loginFrame.setVisible(true);
        this.dispose();
    }

    con.close();

} catch (Exception e) {
    JOptionPane.showMessageDialog(
        this,
        "Error creating account: " + e.getMessage(),
        "Signup Error",
        JOptionPane.ERROR_MESSAGE
    );
}

    }//GEN-LAST:event_btnSignUpActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        login loginPage = new login();
        loginPage.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnLoginActionPerformed

    private void usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameActionPerformed

    private void chkShowPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkShowPasswordActionPerformed
            if (chkShowPassword.isSelected()) {
        password.setEchoChar((char) 0);
    } else {
        password.setEchoChar('•');
    }
    }//GEN-LAST:event_chkShowPasswordActionPerformed

    private void phoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phoneActionPerformed

    private void addressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addressActionPerformed


    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> new signup().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField address;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnSignUp;
    private javax.swing.JCheckBox chkShowPassword;
    private javax.swing.JTextField email;
    private javax.swing.JTextField fullName;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPasswordField password;
    private javax.swing.JTextField phone;
    private javax.swing.JTextField student_id;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables

}
