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
public class TipoPagamentoBoleto implements TipoPagamento {

    private static TipoPagamentoBoleto tipoPagamentoBoleto = new TipoPagamentoBoleto();

    public static TipoPagamentoBoleto getTipoPagamentoBoleto() {
        return tipoPagamentoBoleto;
    }
}
