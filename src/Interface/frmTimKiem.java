/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DucCanh
 */
public class frmTimKiem extends javax.swing.JFrame {

    /**
     * Creates new form frmTimKiem
     */
    public frmTimKiem() {
        initComponents();
    }
     private DefaultTableModel dtm;
    private DefaultTableModel dtmMark;
    ArrayList<BangDiem> listbdiem = null;

    public frmTimKiem()
    {
        initComponents();
        dtm = new DefaultTableModel();
        dtmMark = new DefaultTableModel();

        // Tìm sinh viên theo mã lớp
        dtm.addColumn("Mã sinh viên");
        dtm.addColumn("Họ tên");
        dtm.addColumn("Hệ đào tạo");
        dtm.addColumn("Giới tính");
        dtm.addColumn("Ngày sinh");
        dtm.addColumn("Địa chỉ");
        dtm.addColumn("Số điện thoại");
        dtm.addColumn("Mã lớp");
        tblSinhVien_MaLop.setModel(dtm);

        // Tìm điểm theo mã sinh viên
        dtmMark.addColumn("Mã sinh viên");
        dtmMark.addColumn("Mã môn học");
        dtmMark.addColumn("Lần thi");
        dtmMark.addColumn("Hệ số");
        dtmMark.addColumn("Điểm");
        dtmMark.addColumn("Trạng thái");
        tblDiem_MaSV.setModel(dtmMark);
    }
    
    private static Object[] toObjectData(SinhVien sv)
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String date = dateFormat.format(sv.getNgaysinh());
        boolean flag = sv.isGioitinh();
        String gioitinh;
        if (flag == true)
            gioitinh = "Nam";
        else
            gioitinh = "Nữ";
        Object[] objectData = {sv.getMasv(), sv.getHotensv(), sv.getHedaotao(), gioitinh, date, sv.getDiachi(), sv.getSdt(), sv.getMalop()};
        return objectData;
    }
    
    public static Object[] toOjectBd(BangDiem bd)
    {
        boolean flag = bd.isTrangthai();
        String trangthai;
        if (flag == true)
            trangthai = "Bật";
        else
            trangthai = "Tắt";
        Object[] objects = {bd.getMasv(), bd.getMamh(), bd.getLanthi(), bd.getHeso(), bd.getDiem(), trangthai};
        return objects;
    }

    public void timkiem()
    {
        String malop = txtMaLop.getText();
        while (dtm.getRowCount() > 0)
        {
            dtm.removeRow(0);
        }
        try
        {
            ISinhVienDAO sinhVienDAO = (ISinhVienDAO) Class.forName("Proccess.SinhVien.SinhVienDAO").newInstance();
            ArrayList<SinhVien> list = sinhVienDAO.findByIDLop(malop);
            for (SinhVien sv : list)
            {
                dtm.addRow(toObjectData(sv));
            }
        }
        catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex)
        {
            Logger.getLogger(frmThongKe.class.getName()).log(Level.SEVERE, null, ex);
        }

        Check c = new Check();
        if (!c.checkSpace(malop) || !c.check(malop))
        {
            JOptionPane.showMessageDialog(this, "Lỗi nhập mã lớp", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
            txtMaLop.selectAll();
            txtMaLop.requestFocus();
        }
        else if (dtm.getRowCount() == 0)
        {
            JOptionPane.showMessageDialog(this, "Không tìm thấy lớp này hoặc lớp này không có sinh viên", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
            txtMaLop.selectAll();
            txtMaLop.requestFocus();
        }
    }

    public void timKiemDiem()
    {
        String masv = txtMaSV.getText();
        while (dtmMark.getRowCount() > 0)
        {
            dtmMark.removeRow(0);
        }
        try
        {        
            IBangDiemDAO bangDiemDAO = (IBangDiemDAO) Class.forName("Proccess.BangDiem.BangDiemDAO").newInstance();
            ArrayList<BangDiem> listbd = bangDiemDAO.findByIDSinhVien(masv);
            for (BangDiem bd : listbd)
            {
                dtmMark.addRow(toOjectBd(bd));
            }
        }
        catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex)
        {
            Logger.getLogger(frmTimKiem.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Check c = new Check();
        if (!c.checkSpace(masv) || !c.check(masv))
        {
            JOptionPane.showMessageDialog(this, "Lỗi nhập mã sinh viên", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
            txtMaSV.selectAll();
            txtMaSV.requestFocus();
        }        
        else if (dtmMark.getRowCount() == 0)
        {
            JOptionPane.showMessageDialog(this, "Không tìm thấy sinh viên này hoặc sinh viên này không có điểm", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
            txtMaSV.selectAll();
            txtMaSV.requestFocus();
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSinhVien_MaLop = new javax.swing.JTable();
        txtMaLop = new javax.swing.JTextField();
        btnTimkiemSV = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblDiem_MaSV = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtMaSV = new javax.swing.JTextField();
        btnTimkiemDiem = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tblSinhVien_MaLop.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblSinhVien_MaLop.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã sinh viên", "Họ tên", "Hệ đào tạo", "Giới tính", "Ngày sinh", "Địa chỉ", "Số điện thoại", "Mã lớp"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSinhVien_MaLop.setRowHeight(25);
        jScrollPane2.setViewportView(tblSinhVien_MaLop);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE)
                .addContainerGap())
        );

        txtMaLop.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtMaLop.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMaLopKeyReleased(evt);
            }
        });

        btnTimkiemSV.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnTimkiemSV.setForeground(new java.awt.Color(51, 102, 255));
        btnTimkiemSV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/search-2.png"))); // NOI18N
        btnTimkiemSV.setText(" Tìm kiếm");
        btnTimkiemSV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimkiemSVActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 102, 255));
        jLabel1.setText("Mã lớp");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(347, 347, 347)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtMaLop, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnTimkiemSV)
                .addGap(0, 274, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaLop, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(btnTimkiemSV, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Tìm Sinh viên theo Mã lớp", jPanel2);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tblDiem_MaSV.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblDiem_MaSV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã sinh viên", "Mã môn học", "Lần thi", "Hệ số", "Điểm", "Trạng thái"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Float.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDiem_MaSV.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblDiem_MaSV.setRowHeight(25);
        jScrollPane3.setViewportView(tblDiem_MaSV);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 102, 255));
        jLabel2.setText("Mã sinh viên");

        txtMaSV.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtMaSV.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMaSVKeyReleased(evt);
            }
        });

        btnTimkiemDiem.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnTimkiemDiem.setForeground(new java.awt.Color(51, 102, 255));
        btnTimkiemDiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/search-2.png"))); // NOI18N
        btnTimkiemDiem.setText(" Tìm kiếm");
        btnTimkiemDiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimkiemDiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(304, 304, 304)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtMaSV, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnTimkiemDiem)
                .addGap(0, 282, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaSV, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimkiemDiem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(40, 40, 40)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Tìm Điểm theo Mã sinh viên", jPanel4);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 986, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 728, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtMaLopKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMaLopKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            timkiem();
        }
    }//GEN-LAST:event_txtMaLopKeyReleased

    private void btnTimkiemSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimkiemSVActionPerformed
        timkiem();
    }//GEN-LAST:event_btnTimkiemSVActionPerformed

    private void txtMaSVKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMaSVKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            timKiemDiem();
        }
    }//GEN-LAST:event_txtMaSVKeyReleased

    private void btnTimkiemDiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimkiemDiemActionPerformed
        timKiemDiem();
    }//GEN-LAST:event_btnTimkiemDiemActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmTimKiem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmTimKiem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmTimKiem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmTimKiem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmTimKiem().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTimkiemDiem;
    private javax.swing.JButton btnTimkiemSV;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblDiem_MaSV;
    private javax.swing.JTable tblSinhVien_MaLop;
    private javax.swing.JTextField txtMaLop;
    private javax.swing.JTextField txtMaSV;
    // End of variables declaration//GEN-END:variables
}
