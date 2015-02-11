/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao.i;

import java.util.List;

/**
 *
 * @author emam
 */
public interface dao<T> {
public String Presist(T o);
public String remove(int id);
public List<T> FindAll();
public List<T> FindByParentId(int parentID);
public String update(T o);
}
