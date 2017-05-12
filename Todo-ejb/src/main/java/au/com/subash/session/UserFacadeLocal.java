package au.com.subash.session;

import au.com.subash.entity.Appuser;
import au.com.subash.entity.Todolist;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author subash
 */
@Local
public interface UserFacadeLocal {

  /**
   * Get lists for a user
   * @return
   */
  List<Todolist> getTodolists(String user);

  /**
   * Get currently logged in user
   *
   * @return Logged in user
   */
  Appuser getUser(String email);
}
