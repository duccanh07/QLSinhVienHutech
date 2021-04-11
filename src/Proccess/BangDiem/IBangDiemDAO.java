/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proccess.BangDiem;

import java.util.ArrayList;

/**
 *
 * @author HONGGAM
 */
public interface IBangDiemDAO {
    public ArrayList<BangDiem> getAll();
    public ArrayList<BangDiem> findByIDSinhVien(String masv);
    public ArrayList<BangDiem> findByIDMonHoc(String mamh);
    public BangDiem addNew(BangDiem bd);
    public BangDiem updateByID(BangDiem bd);
    public boolean CheckID(String masv, String mamh, int lanthi);
    public ArrayList<BangDiem> findMaSV();
    public ArrayList<BangDiem> findMaMH(String masv);
    public ArrayList<BangDiem> loaddiem(String masv, String mamh);
}
