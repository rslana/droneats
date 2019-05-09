/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.pagamento;

/**
 *
 * @author Jonas Gomes <github.com/jjthegomes>
 */
public class FinanceiroDinheiro extends Financeiro {

    public FinanceiroDinheiro(Financeiro superior) {
        listaPagamentos.add(TipoPagamentoDinheiro.getTipoPagamentoDinheiro());
        setFinanceiroSuperior(superior);
    }

    @Override
    public String getDescricaoAgencia() {
        return "Dinheiro"; //this.getClass().getSimpleName();
    }
}
