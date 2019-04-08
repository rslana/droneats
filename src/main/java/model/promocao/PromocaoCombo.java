package model.promocao;

/**
 *
 * @author raj
 */
public class PromocaoCombo implements Promocao {

    @Override
    public int obterDesconto() {
        return 10;
    }

    @Override
    public String obterPromocao() {
        return "Promoção Combo";
    }

    @Override
    public String obterClasse() {
        return this.getClass().getSimpleName();
    }
}
