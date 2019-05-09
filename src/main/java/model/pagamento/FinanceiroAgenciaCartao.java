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
public class FinanceiroAgenciaCartao extends Financeiro {

    public FinanceiroAgenciaCartao(Financeiro superior) {
        listaPagamentos.add(TipoPagamentoCredito.getTipoPagamentoCredito());
        setFinanceiroSuperior(superior);
    }

    @Override
    public String getDescricaoAgencia() {
        return "Cartao"; //this.getClass().getSimpleName();
    }
}
