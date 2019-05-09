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
public class TipoPagamentoCredito implements TipoPagamento {
    
    private static TipoPagamentoCredito tipoPagamentoCredito = new TipoPagamentoCredito();

    public static TipoPagamentoCredito getTipoPagamentoCredito() {
        return tipoPagamentoCredito;
    }
}
