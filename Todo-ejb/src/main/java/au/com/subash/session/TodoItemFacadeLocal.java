/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.subash.session;

import au.com.subash.entity.Todoitem;
import javax.ejb.Local;

/**
 *
 * @author subash
 */
@Local
public interface TodoItemFacadeLocal {
    boolean update(Todoitem item);
}
