package Interface;

<<<<<<< HEAD
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
=======
import Proccess.Check;
import Proccess.BangDiem.BangDiem;
import Proccess.BangDiem.IBangDiemDAO;
import Proccess.Lop.Lop;
import Proccess.Lop.ILopDAO;
import Proccess.SinhVien.SinhVien;
import Proccess.SinhVien.ISinhVienDAO;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.net.ssl.SSLException;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import org.json.JSONObject;
>>>>>>> remotes/origin/hirus

public class frmTimKiem extends javax.swing.JPanel
{
    private DefaultTableModel dtm;
    private DefaultTableModel dtmMark;
    private DefaultTableModel dtmAnh;
    ArrayList<BangDiem> listbdiem = null;
    private final static int CONNECT_TIME_OUT = 30000;
    private final static int READ_OUT_TIME = 50000;
    private static String boundaryString = getBoundary();

    public frmTimKiem()
    {
        initComponents();
        dtm = new DefaultTableModel();
        dtmMark = new DefaultTableModel();
        dtmAnh = new DefaultTableModel();

        // Tìm sinh viên theo mã lớp
        dtm.addColumn("Mã sinh viên");
        dtm.addColumn("Họ tên");
        dtm.addColumn("Hệ đào tạo");
        dtm.addColumn("Giới tính");
        dtm.addColumn("Ngày sinh");
        dtm.addColumn("Địa chỉ");
        dtm.addColumn("Số điện thoại");
        dtm.addColumn("Mã lớp");
        dtm.addColumn("Ảnh");
        tblSinhVien_MaLop.setModel(dtm);

        // Tìm điểm theo mã sinh viên
        dtmMark.addColumn("Mã sinh viên");
        dtmMark.addColumn("Mã môn học");
        dtmMark.addColumn("Lần thi");
        dtmMark.addColumn("Hệ số");
        dtmMark.addColumn("Điểm");
        dtmMark.addColumn("Trạng thái");
        tblDiem_MaSV.setModel(dtmMark);
        
        //Theo anh
        dtmAnh.addColumn("Mã sinh viên");
        dtmAnh.addColumn("Họ tên");
        dtmAnh.addColumn("Hệ đào tạo");
        dtmAnh.addColumn("Giới tính");
        dtmAnh.addColumn("Ngày sinh");
        dtmAnh.addColumn("Địa chỉ");
        dtmAnh.addColumn("Số điện thoại");
        dtmAnh.addColumn("Mã lớp");
        dtmAnh.addColumn("Ảnh");
        tblSinhVien_Anh.setModel(dtmAnh);
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
        Object[] objectData = {sv.getMasv(), sv.getHotensv(), sv.getHedaotao(), gioitinh, date, sv.getDiachi(), sv.getSdt(), sv.getMalop(), sv.getAnh()};
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
     private DefaultTableModel dtm;
    private DefaultTableModel dtmMark;
    ArrayList<BangDiem> listbdiem = null;

    public frmTimKiem()
    {
        initComponents();
        dtm = new DefaultTableModel();
        dtmMark = new DefaultTableModel();

<<<<<<< HEAD
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

=======
>>>>>>> remotes/origin/hirus
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
<<<<<<< HEAD
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
=======
    
    public void timkiemAnh()
    {
        String anh = txtAnh.getText();
        while (dtmAnh.getRowCount() > 0)
        {
            dtmAnh.removeRow(0);
        }
        try
        {
            ISinhVienDAO sinhVienDAO = (ISinhVienDAO) Class.forName("Proccess.SinhVien.SinhVienDAO").newInstance();
            ArrayList<SinhVien> list = sinhVienDAO.findByIDAnh(anh);
            for (SinhVien sv : list)
            {
                dtmAnh.addRow(toObjectData(sv));
            }
        }
        catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex)
        {
            Logger.getLogger(frmThongKe.class.getName()).log(Level.SEVERE, null, ex);
        }

        Check c = new Check();
        if (!c.checkSpace(anh) || !c.check(anh))
        {
            JOptionPane.showMessageDialog(this, "Lỗi", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
            txtAnh.selectAll();
            txtAnh.requestFocus();
        }
        else if (dtmAnh.getRowCount() == 0)
        {
            JOptionPane.showMessageDialog(this, "Không tìm thấy sinh viên này!", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
            txtAnh.selectAll();
            txtAnh.requestFocus();
        }
    }
    
>>>>>>> remotes/origin/hirus
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

<<<<<<< HEAD
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
=======
        jButton1 = new javax.swing.JButton();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
>>>>>>> remotes/origin/hirus
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSinhVien_MaLop = new javax.swing.JTable();
        txtMaLop = new javax.swing.JTextField();
        btnTimkiemSV = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
<<<<<<< HEAD
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
=======
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
>>>>>>> remotes/origin/hirus
        jScrollPane3 = new javax.swing.JScrollPane();
        tblDiem_MaSV = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtMaSV = new javax.swing.JTextField();
        btnTimkiemDiem = new javax.swing.JButton();
<<<<<<< HEAD

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

=======
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblSinhVien_Anh = new javax.swing.JTable();
        txtAnh = new javax.swing.JTextField();
        btnTimkiemAnh = new javax.swing.JButton();
        lblAnhChon = new javax.swing.JLabel();
        btnChonAnh = new javax.swing.JButton();
        lblAnhSv = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tblSinhVien_MaLop.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblSinhVien_MaLop.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã sinh viên", "Họ tên", "Hệ đào tạo", "Giới tính", "Ngày sinh", "Địa chỉ", "Số điện thoại", "Mã lớp", "Ảnhl"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(347, 347, 347)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtMaLop, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnTimkiemSV)
                .addGap(0, 254, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaLop, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(btnTimkiemSV, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Tìm Sinh viên theo Mã lớp", jPanel1);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

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

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(304, 304, 304)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtMaSV, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnTimkiemDiem)
                .addGap(0, 262, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaSV, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimkiemDiem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(40, 40, 40)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Tìm Điểm theo Mã sinh viên", jPanel2);

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tblSinhVien_Anh.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblSinhVien_Anh.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã sinh viên", "Họ tên", "Hệ đào tạo", "Giới tính", "Ngày sinh", "Địa chỉ", "Số điện thoại", "Mã lớp", "Ảnh"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

>>>>>>> remotes/origin/hirus
            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
<<<<<<< HEAD
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
=======
        tblSinhVien_Anh.setRowHeight(25);
        tblSinhVien_Anh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSinhVien_AnhMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblSinhVien_Anh);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 885, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 481, Short.MAX_VALUE)
                .addContainerGap())
        );

        txtAnh.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtAnh.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAnhKeyReleased(evt);
            }
        });

        btnTimkiemAnh.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnTimkiemAnh.setForeground(new java.awt.Color(51, 102, 255));
        btnTimkiemAnh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/search-2.png"))); // NOI18N
        btnTimkiemAnh.setText(" Tìm kiếm");
        btnTimkiemAnh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimkiemAnhActionPerformed(evt);
            }
        });

        btnChonAnh.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnChonAnh.setForeground(new java.awt.Color(51, 102, 255));
        btnChonAnh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/search-2.png"))); // NOI18N
        btnChonAnh.setText("Chọn ảnh");
        btnChonAnh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonAnhActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(lblAnhChon, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblAnhSv, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(86, 86, 86)
                        .addComponent(btnChonAnh)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnTimkiemAnh)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lblAnhChon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblAnhSv, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTimkiemAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnChonAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Tìm Sinh viên theo ảnh", jPanel6);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
>>>>>>> remotes/origin/hirus
        );
    }// </editor-fold>//GEN-END:initComponents

<<<<<<< HEAD
    private void txtMaLopKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMaLopKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            timkiem();
        }
    }//GEN-LAST:event_txtMaLopKeyReleased
=======
    private void btnTimkiemDiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimkiemDiemActionPerformed
        timKiemDiem();
    }//GEN-LAST:event_btnTimkiemDiemActionPerformed

    private void txtMaSVKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMaSVKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            timKiemDiem();
        }
    }//GEN-LAST:event_txtMaSVKeyReleased
>>>>>>> remotes/origin/hirus

    private void btnTimkiemSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimkiemSVActionPerformed
        timkiem();
    }//GEN-LAST:event_btnTimkiemSVActionPerformed

<<<<<<< HEAD
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
=======
    private void txtMaLopKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMaLopKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            timkiem();
        }
    }//GEN-LAST:event_txtMaLopKeyReleased

    private void btnChonAnhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonAnhActionPerformed
        // TODO add your handling code here:
        String filePath;
        JFileChooser chon = new JFileChooser();
        FileFilter ft = new FileNameExtensionFilter("Image Files", "jpg", "png", "jpeg");
        chon.addChoosableFileFilter(ft);
        chon.showOpenDialog(null);
        File f = chon.getSelectedFile();

        filePath = f.getAbsolutePath();

        BufferedImage img = null;
>>>>>>> remotes/origin/hirus
        try {
            img = ImageIO.read(new File(filePath));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        ImageIcon imageIcon = new ImageIcon(new ImageIcon(filePath).getImage().getScaledInstance(lblAnhChon.getWidth(), lblAnhChon.getHeight(), Image.SCALE_SMOOTH));
        lblAnhChon.setIcon(imageIcon);

        byte[] buff2 = null;
        String ss = null;
        double confidence = 0;
        ArrayList<Double> arr = new ArrayList<Double>();
        ArrayList<File> arrS = new ArrayList<File>();

        File file1 = new File(filePath);
        byte[] buff1 = getBytesFromFile(file1);

        File file2 = new File(System.getProperty("user.dir")+"/src/SVImages/");
        String contents[] = file2.list();
        for(int i=0; i<contents.length; i++) {
            File s = new File (System.getProperty("user.dir")+"/src/SVImages/"+contents[i]);
            arrS.add(s);
            buff2 = getBytesFromFile(s);

            String url = "https://api-us.faceplusplus.com/facepp/v3/compare";
            HashMap<String, String> map = new HashMap<>();
            HashMap<String, byte[]> byteMap = new HashMap<>();
            map.put("api_key", "kVLL9LCGF1RKRKQXbLZpWlUlPIyDlQRe");
            map.put("api_secret", "eDKvqufaNDaxldd0nCYs7zzdi6kF80Ev");

            byteMap.put("image_file1", buff1);
            byteMap.put("image_file2", buff2);

            try {
                byte[] bacd = post(url, map, byteMap);
                String jsonStr = new String(bacd);

                JSONObject obj = new JSONObject(jsonStr);
                confidence = obj.getDouble("confidence");
                arr.add(confidence);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        int dem = 0;
        double max = arr.get(0);
        for (int i = 0; i < arr.size(); i++)
        {
            if (max < arr.get(i))
            {
                max = arr.get(i);
                dem = i;
            }
        }
        File a = arrS.get(dem);
        txtAnh.setText(a.toString());
    }//GEN-LAST:event_btnChonAnhActionPerformed

    private void btnTimkiemAnhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimkiemAnhActionPerformed
        // TODO add your handling code here:
        timkiemAnh();

    }//GEN-LAST:event_btnTimkiemAnhActionPerformed

    private void txtAnhKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAnhKeyReleased
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            timkiemAnh();
        }
    }//GEN-LAST:event_txtAnhKeyReleased

    private void tblSinhVien_AnhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSinhVien_AnhMouseClicked
        // TODO add your handling code here:
        ImageIcon imageIcon = new ImageIcon(new ImageIcon(tblSinhVien_Anh.getValueAt(tblSinhVien_Anh.getSelectedRow(), 8).toString()).getImage().getScaledInstance(lblAnhSv.getWidth(), lblAnhSv.getHeight(), Image.SCALE_SMOOTH));
        lblAnhSv.setIcon(imageIcon);
    }//GEN-LAST:event_tblSinhVien_AnhMouseClicked
    
    protected static byte[] post(String url, HashMap<String, String> map, HashMap<String, byte[]> fileMap) throws Exception {
        HttpURLConnection conne;
        URL url1 = new URL(url);
        conne = (HttpURLConnection) url1.openConnection();
        conne.setDoOutput(true);
        conne.setUseCaches(false);
        conne.setRequestMethod("POST");
        conne.setConnectTimeout(CONNECT_TIME_OUT);
        conne.setReadTimeout(READ_OUT_TIME);
        conne.setRequestProperty("accept", "*/*");
        conne.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundaryString);
        conne.setRequestProperty("connection", "Keep-Alive");
        conne.setRequestProperty("user-agent", "Mozilla/4.0 (compatible;MSIE 6.0;Windows NT 5.1;SV1)");
        DataOutputStream obos = new DataOutputStream(conne.getOutputStream());
        Iterator iter = map.entrySet().iterator();
        while(iter.hasNext()){
            Map.Entry<String, String> entry = (Map.Entry) iter.next();
            String key = entry.getKey();
            String value = entry.getValue();
            obos.writeBytes("--" + boundaryString + "\r\n");
            obos.writeBytes("Content-Disposition: form-data; name=\"" + key
                    + "\"\r\n");
            obos.writeBytes("\r\n");
            obos.writeBytes(value + "\r\n");
        }
        if(fileMap != null && fileMap.size() > 0){
            Iterator fileIter = fileMap.entrySet().iterator();
            while(fileIter.hasNext()){
                Map.Entry<String, byte[]> fileEntry = (Map.Entry<String, byte[]>) fileIter.next();
                obos.writeBytes("--" + boundaryString + "\r\n");
                obos.writeBytes("Content-Disposition: form-data; name=\"" + fileEntry.getKey()
                        + "\"; filename=\"" + encode(" ") + "\"\r\n");
                obos.writeBytes("\r\n");
                obos.write(fileEntry.getValue());
                obos.writeBytes("\r\n");
            }
        }
        obos.writeBytes("--" + boundaryString + "--" + "\r\n");
        obos.writeBytes("\r\n");
        obos.flush();
        obos.close();
        InputStream ins = null;
        int code = conne.getResponseCode();
        try{
            if(code == 200){
                ins = conne.getInputStream();
            }else{
                ins = conne.getErrorStream();
            }
        }catch (SSLException e){
            e.printStackTrace();
            return new byte[0];
        }
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buff = new byte[4096];
        int len;
        while((len = ins.read(buff)) != -1){
            baos.write(buff, 0, len);
        }
        byte[] bytes = baos.toByteArray();
        ins.close();
        return bytes;
    }
    private static String getBoundary() {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for(int i = 0; i < 32; ++i) {
            sb.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789_-".charAt(random.nextInt("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789_".length())));
        }
        return sb.toString();
    }
    private static String encode(String value) throws Exception{
        return URLEncoder.encode(value, "UTF-8");
    }
    
    public static byte[] getBytesFromFile(File f) {
        if (f == null) {
            return null;
        }
        try {
            FileInputStream stream = new FileInputStream(f);
            ByteArrayOutputStream out = new ByteArrayOutputStream(1000);
            byte[] b = new byte[1000];
            int n;
            while ((n = stream.read(b)) != -1)
                out.write(b, 0, n);
            stream.close();
            out.close();
            return out.toByteArray();
        } catch (IOException e) {
        }
        return null;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
<<<<<<< HEAD
    private javax.swing.JButton btnTimkiemDiem;
    private javax.swing.JButton btnTimkiemSV;
=======
    private javax.swing.JButton btnChonAnh;
    private javax.swing.JButton btnTimkiemAnh;
    private javax.swing.JButton btnTimkiemDiem;
    private javax.swing.JButton btnTimkiemSV;
    private javax.swing.JButton jButton1;
>>>>>>> remotes/origin/hirus
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
<<<<<<< HEAD
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblDiem_MaSV;
    private javax.swing.JTable tblSinhVien_MaLop;
=======
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JLabel lblAnhChon;
    private javax.swing.JLabel lblAnhSv;
    private javax.swing.JTable tblDiem_MaSV;
    private javax.swing.JTable tblSinhVien_Anh;
    private javax.swing.JTable tblSinhVien_MaLop;
    private javax.swing.JTextField txtAnh;
>>>>>>> remotes/origin/hirus
    private javax.swing.JTextField txtMaLop;
    private javax.swing.JTextField txtMaSV;
    // End of variables declaration//GEN-END:variables
}
