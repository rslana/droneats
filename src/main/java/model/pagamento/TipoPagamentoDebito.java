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
public class TipoPagamentoDebito implements TipoPagamento {

    private static TipoPagamentoDebito tipoPagamentoDebito = new TipoPagamentoDebito();

    public static TipoPagamentoDebito getTipoPagamentoDebito() {
        return tipoPagamentoDebito;
    }

}