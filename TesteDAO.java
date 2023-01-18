package com.contas;

import java.sql.SQLException;
import java.util.Scanner;

public class TesteDAO {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Scanner entrada = new Scanner(System.in);
        ContasDAO inserir = new ContasDAO();
        Contas conta1 = new Contas();
      
        int op = 0;
        do{
            System.out.println("\n-----MENU----- \n1- INSERIR \n2- EXIBIR DADOS \n3- APAGAR \n4- ATUALIZAR \n5 - SAIR\n--------------");
            op = entrada.nextInt();

            switch(op){
                case 1:
                        entrada.nextLine();
                        System.out.println("\ninforme o tipo de conta: ");
                        String descricao = entrada.nextLine();
                        System.out.println("informe o preço da conta: ");
                        double conta = entrada.nextDouble();
            
                            conta1.setDescricaoConta(descricao);
                            conta1.setprecoConta(conta);
                            inserir.salvarContas(conta1);
                    break;
                case 2:
                        //vizualizar TODOS registros
                        for(Contas exibir: ContasDAO.getContas()){
                            System.out.println("------\nID Contas: "+exibir.getIdConta()+"\nTipo de Conta: "+exibir.getDescricaoConta()+"\nPreço: "+exibir.getprecoConta()+"\nTotal a pagar: "+exibir.gettotalConta());
                        }
                    break;
                case 3:
                        //apagar registro pelo id
                        entrada.nextLine();
                        System.out.println("\ninforme o id do registro que deseja remover: ");
                        int removeId = entrada.nextInt();

                            ContasDAO apagar = new ContasDAO();
                            apagar.apagarRegistro(removeId);
                    break;
                case 4:
                        //atualizar Registros
                        Contas atualizado = new Contas();
                        entrada.nextLine();
                        System.out.println("\ninforme a nova conta: ");
                        String novaconta = entrada.nextLine();
                        System.out.println("\ninforme o preço atualizado: ");
                        double novopreco = entrada.nextDouble();
                        System.out.println("\ninforme o id do registro que deseja atualizar: ");
                        int novoid = entrada.nextInt();
  
                            atualizado.setDescricaoConta(novaconta);
                            atualizado.setprecoConta(novopreco);
                            atualizado.setIdConta(novoid);
  
                            ContasDAO.atualizarContas(atualizado);
                    break;
                case 5:
                        System.out.println("operação encerrada");
                    break;
            }

        }while(op!=5);

    }
}
