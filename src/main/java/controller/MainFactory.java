package controller;

/**
 *
 * @author raj
 */
public class MainFactory {
    public static Object create(String action) {
        Object actionObject;
        String nomeClasse = action;
        Class classe;
        Object objeto;
        try {
            classe = Class.forName(nomeClasse);
            objeto = classe.newInstance();

        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            return null;
        }
        if (!(objeto instanceof Object)) {
            return null;
        }
        actionObject = (Object) objeto;
        return actionObject;
    }
}
