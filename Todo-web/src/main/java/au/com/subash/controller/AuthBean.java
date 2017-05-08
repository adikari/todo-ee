package au.com.subash.controller;

import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Subash Adhikari
 */
@Named(value = "authBean")
@SessionScoped
public class AuthBean implements Serializable {

    public void logout() throws IOException, ServletException {
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        HttpServletRequest request = (HttpServletRequest) ec.getRequest();

        request.logout();

        HttpSession session = (HttpSession) ec.getSession(false);
        session.invalidate();

        ec.redirect("http://" + request.getHeader("Host") + request.getContextPath());  
    }

}
