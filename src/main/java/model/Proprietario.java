package model;

import javax.servlet.http.HttpSession;

/**
 *
 * @author raj
 */
public class Proprietario extends Usuario {

    public static boolean isLoggedIn(HttpSession session) {
        return session.getAttribute("usuario") instanceof Proprietario;
    }

    @Override
    public String getTipo() {
        return "Proprietario";
    }
}
