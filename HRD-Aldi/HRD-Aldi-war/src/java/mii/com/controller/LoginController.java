/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.com.controller;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import mii.hrd.bean.AkunSessionBeanLocal;
import org.springframework.stereotype.Controller;

/**
 *
 * @author Rinaldi
 */
@Controller
public class LoginController {
    AkunSessionBeanLocal akunSessionBean = lookupAkunSessionBeanLocal();

    private AkunSessionBeanLocal lookupAkunSessionBeanLocal() {
        try {
            Context c = new InitialContext();
            return (AkunSessionBeanLocal) c.lookup("java:global/HRD-Aldi/HRD-Aldi-ejb/AkunSessionBean!mii.hrd.bean.AkunSessionBeanLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
}
