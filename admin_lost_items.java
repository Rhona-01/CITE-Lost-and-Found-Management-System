
package cite_lostandfounddepartment_system;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JOptionPane;
import java.sql.SQLException;




public class admin_lost_items extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(admin_lost_items.class.getName());
    private int AdminUserId;
    private String AdminFullName;
    
    private int currentPage = 0;
    private final int itemsPerPage = 4;
    private List<LostItem> lostItems = new java.util.ArrayList<>();
    private java.util.List<LostItem> filteredLostItems =
            new java.util.ArrayList<>();
    
        private final String DB_URL =
            "jdbc:mysql://localhost:3306/cite_lostandfounddepartment_system";

    private final String DB_USER = "root";
    private final String DB_PASSWORD = "";

    private JTextField txtSearch;
    private JComboBox<String> cmbCategory;
    private JComboBox2<String> cmbStatus;
    

    
public admin_lost_items(int AdminUserId, String AdminFullName) {
    initComponents();

    this.AdminUserId = AdminUserId;
    this.AdminFullName = AdminFullName;
    
    pnlLostTable.setLayout(new java.awt.GridLayout(0, 2, 10, 10));
    
    jComboBox.addItem("Select Category...");
    jComboBox.addItem("Electronics");
    jComboBox.addItem("Clothing");
    jComboBox.addItem("Personal Items");
    jComboBox.addItem("Accessories");
    
    JPanel paginationPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10));
    paginationPanel.setBackground(new Color(204, 255, 255));
    
    JButton btnPrevious = new JButton("< Previous");
    JButton btnNext = new JButton("Next >");
    
    btnPrevious.setPreferredSize(new Dimension(120, 40));
    btnNext.setPreferredSize(new Dimension(120, 40));
    
    paginationPanel.add(btnPrevious);
    paginationPanel.add(btnNext);

    setResizable(true);
    setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
    setLocationRelativeTo(null);

    loadLostItemsCount();
    displayCurrentPage();
    setLocationRelativeTo(null);
        setVisible(true);

}

    private Connection getConnection()
            throws Exception {

        String url = "jdbc:mysql://localhost:3306/" + "cite_lostandfounddepartment_system";
        String username = "root";
        String password = "";

        Class.forName("com.mysql.cj.jdbc.Driver");

        return DriverManager.getConnection(url, username, password);
    }

   



private void showPage() {

 
    pnlLostTable.removeAll();

    if (lostItems == null || lostItems.isEmpty()) {
        pnlLostTable.revalidate();
        pnlLostTable.repaint();
        return;
    }

    int start = currentPage * itemsPerPage;
    int end = Math.min(start + itemsPerPage, lostItems.size());

    
    for (int i = start; i < end; i++) {

        LostItem item = lostItems.get(i);

        createLostItemCard(
            item.getLostId(),
            item.getItemName(),
            item.getCategory(),
            item.getDateLost(),
            item.getLocationLost(),
            item.getReportedBy(),
            item.getImageData(),
            item.getStatus()
        );
    }


    pnlLostTable.revalidate();
    pnlLostTable.repaint();
    
    btnPrevious.setEnabled(currentPage > 0);
    btnNext.setEnabled(end < lostItems.size());
}

private void loadLostItemsCount() {

    lostItems.clear();

    String sql = "SELECT l.lost_id, l.item_name, l.category, "
        + "l.location_lost, l.date_lost, l.status, "
        + "l.reported_by, u.full_name, l.image_path "
        + "FROM tbl_lost_items l "
        + "LEFT JOIN tbl_users u ON l.reported_by = u.user_id "
        + "ORDER BY l.lost_id DESC";

    try {

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cite_lostandfounddepartment_system", "root", "");

        PreparedStatement pst = conn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();

        while (rs.next()) {

            int lostId = rs.getInt("lost_id");

            String itemName = rs.getString("item_name");
            String category = rs.getString("category");
            String dateLost = rs.getString("date_lost");
            String locationLost = rs.getString("location_lost");
            
            String reportedBy = rs.getString("full_name");
            if (reportedBy == null || reportedBy.trim().isEmpty()) {
                reportedBy = "Unknown";
            }
            
            String status = rs.getString("status");

            byte[] imageData = null;

            String imagePath = rs.getString("image_path");

            if (imagePath != null && !imagePath.isEmpty()) {

                try {

                    java.io.File file = new java.io.File(imagePath);

                    if (file.exists()) {
                        imageData = java.nio.file.Files.readAllBytes(file.toPath());
                    }

                } catch (Exception e) {
                    System.out.println("Could not load image: " + e.getMessage());
                }
            }

            LostItem item = new LostItem(
                lostId,
                itemName,
                category,
                dateLost,
                locationLost,
                reportedBy,
                status,
                imageData
            );

            lostItems.add(item);
        }

        rs.close();
        pst.close();
        conn.close();

        filteredLostItems.clear();
        filteredLostItems.addAll(lostItems);

    } catch (Exception e) {

        JOptionPane.showMessageDialog(
            this,
            "Error loading lost items:\n" + e.getMessage(),
            "Database Error",
            JOptionPane.ERROR_MESSAGE
        );
    }
}

    private void displayCurrentPage() {

        pnlLostTable.removeAll();

    int start = currentPage * itemsPerPage;

    int end = Math.min(
        start + itemsPerPage,
        filteredLostItems.size()
    );

    for (int i = start; i < end; i++) {

        LostItem item = filteredLostItems.get(i);

        createLostItemCard(
            item.getLostId(),
            item.getItemName(),
            item.getCategory(),
            item.getDateLost(),
            item.getLocationLost(),
            item.getReportedBy(),
            item.getImageData(),
            item.getStatus()
        );
    }

    pnlLostTable.revalidate();
    pnlLostTable.repaint();

    updatePaginationButtons();
}

    private void updatePaginationButtons() {

         int totalPages = (int) Math.ceil(
        (double) filteredLostItems.size() / itemsPerPage
    );

    if (totalPages == 0) {
        totalPages = 1;
    }

    btnPrevious.setEnabled(currentPage > 0);

    btnNext.setEnabled(
        currentPage < totalPages - 1
    );
}


    
    private void createLostItemCard(
            int lostId,
            String itemName,
            String category,
            String dateLost,
            String locationLost,
            String reportedBy,
            byte[] imageData,
            String status) {

        JPanel card = new JPanel(new BorderLayout( 10, 5));
        card.setBackground(Color.WHITE);
        
        card.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)),
                BorderFactory.createEmptyBorder(10,10,10,10)));
        card.setPreferredSize(new Dimension(470, 215));

        JLabel lblImage = new JLabel();
        
        lblImage.setHorizontalAlignment( SwingConstants.CENTER);

        lblImage.setVerticalAlignment(SwingConstants.CENTER);
        lblImage.setPreferredSize(new Dimension(150, 150));
        
        if (imageData != null&& imageData.length > 0) {
            
            ImageIcon icon = new ImageIcon(imageData);
            Image image = icon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
            lblImage.setIcon(new ImageIcon(image));

        } else {
            lblImage.setText("No Image");
            lblImage.setFont(new Font("Segoe UI",Font.PLAIN,14));
        }

        card.add(lblImage, BorderLayout.WEST);

        JPanel infoPanel = new JPanel();
        infoPanel.setBackground(Color.WHITE);
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));

        JLabel lblName = new JLabel( itemName);
        lblName.setFont(new Font( "Segoe UI", Font.BOLD, 18));

        JLabel lblCategory =new JLabel("Category: " + category);
        lblCategory.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        JLabel lblDate = new JLabel("Date Lost: " + dateLost);
        lblDate.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        JLabel lblLocation = new JLabel("Location: " + locationLost);
        lblLocation.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        JLabel lblReportedBy = new JLabel("Reported By: " + reportedBy);
        lblReportedBy.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        JLabel lblStatus = new JLabel("Status: " + status);
        lblStatus.setFont(new Font("Segoe UI", Font.BOLD, 14));

        infoPanel.add(lblName);

        infoPanel.add(Box.createVerticalStrut(5));
        infoPanel.add(lblCategory);
        infoPanel.add(Box.createVerticalStrut(3));
        infoPanel.add(lblDate);
        infoPanel.add(Box.createVerticalStrut(3));
        infoPanel.add(lblLocation);
        infoPanel.add(Box.createVerticalStrut(3));
        infoPanel.add(lblReportedBy);
        infoPanel.add(Box.createVerticalStrut(3));
        infoPanel.add(lblStatus);
        card.add(infoPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 0));

        buttonPanel.setBackground(Color.WHITE);

        JButton btnView = new JButton("VIEW");
        btnView.setFont(new Font("Segoe UI", Font.BOLD, 13));

        btnView.setFocusPainted(false);

        btnView.setPreferredSize(new Dimension(80, 35));
        btnView.addActionListener( e -> {
            
            try {
                admin_lost_item_detail detail = new admin_lost_item_detail(lostId);
                detail.setLocationRelativeTo(this);
                detail.setVisible(true);
            
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Unable to open item details:\n"  + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
        );

        buttonPanel.add(btnView);
        card.add(buttonPanel, BorderLayout.SOUTH);
        pnlLostTable.add(card);
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
        jTextField = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        pnlLostTable = new javax.swing.JPanel();
        jComboBox = new javax.swing.JComboBox<>();
        jLabel54 = new javax.swing.JLabel();
        btnPrevious = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();

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
        jLabel4.setText("MANAGE LOST REPORTS");
        jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel4.setOpaque(true);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Search:");

        jTextField.setBackground(new java.awt.Color(255, 255, 255));
        jTextField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextField.setForeground(new java.awt.Color(0, 0, 0));
        jTextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButton1.setBackground(new java.awt.Color(153, 204, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("SEARCH");
        jButton1.addActionListener(this::jButton1ActionPerformed);

        pnlLostTable.setBackground(new java.awt.Color(255, 255, 255));
        pnlLostTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        pnlLostTable.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout pnlLostTableLayout = new javax.swing.GroupLayout(pnlLostTable);
        pnlLostTable.setLayout(pnlLostTableLayout);
        pnlLostTableLayout.setHorizontalGroup(
            pnlLostTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 947, Short.MAX_VALUE)
        );
        pnlLostTableLayout.setVerticalGroup(
            pnlLostTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 435, Short.MAX_VALUE)
        );

        jComboBox.setBackground(new java.awt.Color(255, 255, 255));
        jComboBox.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jComboBox.setForeground(new java.awt.Color(0, 0, 0));
        jComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Category...", "Electronics", "School Supplies", "Personal Items", "Clothing", "Bags", "Accessories", "Documents", "Others", " " }));
        jComboBox.addActionListener(this::jComboBoxActionPerformed);

        jLabel54.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(0, 0, 0));
        jLabel54.setText("Category:");

        btnPrevious.setBackground(new java.awt.Color(255, 255, 255));
        btnPrevious.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnPrevious.setForeground(new java.awt.Color(0, 0, 0));
        btnPrevious.setText("< Previous");
        btnPrevious.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnPrevious.addActionListener(this::btnPreviousActionPerformed);

        btnNext.setBackground(new java.awt.Color(255, 255, 255));
        btnNext.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnNext.setForeground(new java.awt.Color(0, 0, 0));
        btnNext.setText("Next  >");
        btnNext.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnNext.addActionListener(this::btnNextActionPerformed);

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel21Layout.createSequentialGroup()
                                .addGap(130, 130, 130)
                                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel54))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField)
                                    .addComponent(jComboBox, 0, 540, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel21Layout.createSequentialGroup()
                                .addGap(106, 106, 106)
                                .addComponent(pnlLostTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel21Layout.createSequentialGroup()
                                .addGap(417, 417, 417)
                                .addComponent(btnPrevious, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(53, 53, 53)
                                .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 62, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(jButton1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox)
                    .addComponent(jLabel54))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlLostTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPrevious, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
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
                .addGap(22, 22, 22))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        String search = jTextField.getText().trim();

        pnlLostTable.removeAll();

        String sql = "SELECT l.lost_id, l.item_name, l.category, "
        + "l.location_lost, l.date_lost, l.status, "
        + "l.reported_by, u.full_name, l.image_path "
        + "FROM tbl_lost_items l "
        + "LEFT JOIN tbl_users u ON l.reported_by = u.user_id "
        + "ORDER BY l.lost_id DESC";

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

                    java.text.SimpleDateFormat dateFormat =
                    new java.text.SimpleDateFormat("MM/dd/yyyy");

                    dateLost = dateFormat.format(rs.getDate("date_lost"));
                }

                String reportedBy = rs.getString("reported_by");

                if (reportedBy == null) {
                    reportedBy = "Unknown";
                }

                String status = rs.getString("status");

                byte[] imageData = rs.getBytes("image_path");

                createLostItemCard(
                    lostId,
                    itemName,
                    category,
                    dateLost,
                    locationLost,
                    reportedBy,
                    imageData,
                    status
                );
            }

            rs.close();
            pst.close();
            conn.close();

            pnlLostTable.revalidate();
            pnlLostTable.repaint();

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(
                this,
                "Database Error: " + e.getMessage(),
                "Database Error",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxActionPerformed
        String selectedCategory =
        jComboBox.getSelectedItem().toString();

        filteredLostItems.clear();

        if (selectedCategory.equals("Select Category...")) {

            filteredLostItems.addAll(lostItems);

        } else {

            for (LostItem item : lostItems) {

                if (item.getCategory().equalsIgnoreCase(selectedCategory)) {

                    filteredLostItems.add(item);
                }
            }
        }

        currentPage = 0;

        displayCurrentPage();
    }//GEN-LAST:event_jComboBoxActionPerformed

    private void btnPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreviousActionPerformed
        if (currentPage > 0) {
            currentPage--;
            displayCurrentPage();
        }
    }//GEN-LAST:event_btnPreviousActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        int totalPages = (int) Math.ceil((double) lostItems.size() / itemsPerPage);

        if (currentPage < totalPages - 1) {
            currentPage++;
            displayCurrentPage();

        }
    }//GEN-LAST:event_btnNextActionPerformed


    public static void main(String args[]) {

        
        java.awt.EventQueue.invokeLater(() -> {
            admin_lost_items frame = new admin_lost_items(1, "Jaycee Bryce");
            frame.setVisible(true);

        });
   
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClaims;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnLogout4;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrevious;
    private javax.swing.JButton btnProfile;
    private javax.swing.JButton btnReports;
    private javax.swing.JButton btnUsers;
    private javax.swing.JButton btnViewFoundItems;
    private javax.swing.JButton btnViewLostItems;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTextField;
    private javax.swing.JPanel pnlLostTable;
    // End of variables declaration//GEN-END:variables
}
