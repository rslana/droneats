package model.promocao;

/**
 *
 * @author raj
 */
public class PromocaoUnitario implements Promocao {

    @Override
    public int obterDesconto() {
        return 5;
    }

    @Override
    public String obterPromocao() {
        return "Promoção Unitário";
    }
    
    @Override
    public String obterClasse() {
        return this.getClass().getSimpleName();
    }
}
