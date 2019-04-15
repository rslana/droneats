package model.pedidoestado;

/**
 *
 * @author raj
 */
public class PedidoEstadoFactory {
    public static PedidoEstado create(String pedidoEstado) {
        PedidoEstado pedidoEstadoObject;
        String nomeClasse = "model.pedidoestado.PedidoEstado" + pedidoEstado;
        Class classe;
        Object objeto;
        try {
            classe = Class.forName(nomeClasse);
            objeto = classe.newInstance();

        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            return null;
        }
        if (!(objeto instanceof PedidoEstado)) {
            return null;
        }
        pedidoEstadoObject = (PedidoEstado) objeto;
        return pedidoEstadoObject;
    }
}
