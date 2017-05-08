package au.com.subash.session;

import au.com.subash.entity.Appuser;
import au.com.subash.entity.Todolist;
import java.security.Principal;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author subash
 */
@Stateless
@LocalBean
public class UserFacade implements UserFacadeLocal {
    
    @PersistenceContext(unitName = "au.com.subash_Todo-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;
    
    @Resource
    private SessionContext ctx;
    
    private Appuser user;
    
    @Override
    public Appuser getUser() {
        if (user == null) {
            Principal principal = ctx.getCallerPrincipal();
            
            if (principal != null) {
                TypedQuery<Appuser> query = em.createNamedQuery("Appuser.findByEmail", Appuser.class);
                query.setParameter("email", principal.getName());
                return query.getSingleResult();
            }
        }
        
        return user;
    }

    @Override
    public List<Todolist> getTodolists() {
        return getUser().getTodolistList();
    }
}
