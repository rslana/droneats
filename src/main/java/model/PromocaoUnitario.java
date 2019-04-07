/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author ariel
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
    
}
