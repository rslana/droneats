package controller;

/**
 *
 * @author raj
 */
public class ActionFactory {

    public static Action create(String action, String route) {
        Action actionObject;
        String nomeClasse = "action." + route + "." + action + "Action";
        Class classe;
        Object objeto;
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
