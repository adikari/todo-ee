package au.com.subash.session;

import au.com.subash.entity.Appuser;
import javax.ejb.Local;

/**
 *
 * @author subash
 */
@Local
public interface UserFacadeLocal {

  /**
   * Get user by id
   *
   * @param id User id
   * @return Logged in user
   */
  Appuser getUser(int id);

  /**
   * Get user by email
   *
   * @param email User email
   * @return Logged in user
   */
  Appuser getUserByEmail(String email);
}
