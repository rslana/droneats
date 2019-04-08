package model.promocao;

/**
 *
 * @author raj
 */
public class PromocaoFactory {
    public static Promocao create(String promocao) {
        Promocao promocaoObject;
        String nomeClasse = "model.promocao." + promocao;
        Class classe;
        Object objeto;
        try {
            classe = Class.forName(nomeClasse);
            objeto = classe.newInstance();

        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            return null;
        }
        if (!(objeto instanceof Promocao)) {
            return null;
        }
        promocaoObject = (Promocao) objeto;
        return promocaoObject;
    }
}
