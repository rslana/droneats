/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.pagamento;

import java.util.ArrayList;

/**
 *
 * @author Jonas Gomes <github.com/jjthegomes>
 */
public abstract class Financeiro {

    protected ArrayList listaPagamentos = new ArrayList();
    private Financeiro financeiroSuperior;

    public ArrayList getListaPagamentos() {
        return listaPagamentos;
    }

    public void setListaPagamentos(ArrayList listaPagamentos) {
        this.listaPagamentos = listaPagamentos;
    }

    public Financeiro getFuncionarioSuperior() {
        return financeiroSuperior;
    }

    public void setFinanceiroSuperior(Financeiro funcionarioSuperior) {
        this.financeiroSuperior = funcionarioSuperior;
    }

    public abstract String getDescricaoAgencia();

    public String fazerPagamento(Pagamento pagamento) {
        if (listaPagamentos.contains(pagamento.getTipoPagamento())) {
            return getDescricaoAgencia();
        } else if (financeiroSuperior != null) {
            return financeiroSuperior.fazerPagamento(pagamento);
        } else {
            return "Sem Pagamento";
        }
    }
}
