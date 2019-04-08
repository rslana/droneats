package controller;

/**
 *
 * @author raj
 */
public class ActionFactory {

    public static Action create(String action, String route) {
        Action actionObject = null;
        String nomeClasse = "action." + route + "." + action + "Action";
        Class classe = null;
        Object objeto = null;
        try {
            classe = Class.forName(nomeClasse);
            objeto = classe.newInstance();

        } catch (Exception e) {
            return null;
        }
        if (!(objeto instanceof Action)) {
            return null;
        }
        actionObject = (Action) objeto;
        return actionObject;
    }
}
