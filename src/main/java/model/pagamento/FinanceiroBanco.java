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
public class FinanceiroBanco extends Financeiro {

    public FinanceiroBanco(Financeiro superior) {
        listaPagamentos.add(TipoPagamentoBoleto.getTipoPagamentoBoleto());
        listaPagamentos.add(TipoPagamentoDebito.getTipoPagamentoDebito());

        setFinanceiroSuperior(superior);
    }

    @Override
    public String getDescricaoAgencia() {
        return "Banco"; //this.getClass().getSimpleName();
    }
}
