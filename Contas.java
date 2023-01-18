package com.contas;

import java.util.Date;

public class Contas {

    private int idConta;
    private String descricaoConta;
    private double precoConta;
        public Contas() {

        }
        public Contas(int id, String descricao, double preco) {
            this.idConta = id;
            this.descricaoConta = descricao;
            this.precoConta = preco;
        }
    
        public int getIdConta() {
            return idConta;
        }
    
        public void setIdConta(int idConta) {
            this.idConta = idConta;
        }
        
        public String getDescricaoConta() {
            return descricaoConta;
        }
        
        public void setDescricaoConta(String descricaoConta) {
            this.descricaoConta = descricaoConta;
        }

        public double getprecoConta(){
            return precoConta;
        }

        public void setprecoConta(double novoPreco){
            this.precoConta = novoPreco;
        }
        
        public double gettotalConta(){
            double total = 0;
            total += precoConta;
            return total;
        }

        
}
