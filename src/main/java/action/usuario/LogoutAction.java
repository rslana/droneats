package action.usuario;

import controller.Action;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author raj
 */
public class LogoutAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response,HttpSession session) {
        try {
            session.invalidate();
            response.sendRedirect("/droneats/");

        } catch (IOException ex) {
        }
    }
}
