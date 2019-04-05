package model.pedidoestado;

/**
 *
 * @author raj
 */
public class PedidoEstadoFactory {
    public static PedidoEstado create(String pedidoEstado) {
        PedidoEstado pedidoEstadoObject = null;
        String nomeClasse = "model.pedidoestado.PedidoEstado" + pedidoEstado;
        Class classe = null;
        Object objeto = null;
        try {
            classe = Class.forName(nomeClasse);
            objeto = classe.newInstance();

        } catch (Exception e) {
            return null;
        }
        if (!(objeto instanceof PedidoEstado)) {
            return null;
        }
        pedidoEstadoObject = (PedidoEstado) objeto;
        return pedidoEstadoObject;
    }
}
