/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proccess.MonHoc;

import java.util.ArrayList;

/**
 *
 * @author 84378
 */
public interface IMonHocDAO {
    public ArrayList<MonHoc> getAll();
    public ArrayList<MonHoc> findByIDMonHoc(String mamh);
    public MonHoc addNew(MonHoc mh);
    public MonHoc updateByID(MonHoc mh);
    public ArrayList<MonHoc> CheckID(String mamh);
}
