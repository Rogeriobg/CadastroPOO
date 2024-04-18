/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastropoo;

import java.io.IOException;
import model.PessoaFisica;
import model.PessoaFisicaRepo;
import model.PessoaJuridica;
import model.PessoaJuridicaRepo;

public class Main {
    public static void main(String[] args) {
        PessoaFisicaRepo repo1 = new PessoaFisicaRepo();
        repo1.inserir(new PessoaFisica(1, "João", "123.456.789-10", 30));
        repo1.inserir(new PessoaFisica(2, "Maria", "987.654.321-00", 25));
        repo1.inserir(new PessoaFisica(3, "Ricardo", "957.614.371-56", 45));
        
        try {
            repo1.persistir("pessoasFisicas.dat");

            PessoaFisicaRepo repo2 = new PessoaFisicaRepo();
            repo2.recuperar("pessoasFisicas.dat");
            for (PessoaFisica pessoa : repo2.getPessoasFisicas()) {
                pessoa.exibir();
            }
        } catch (IOException | ClassNotFoundException e) {
           
        }

        PessoaJuridicaRepo repo3 = new PessoaJuridicaRepo();
        repo3.inserir(new PessoaJuridica(1, "Empresa A", "123456789"));
        repo3.inserir(new PessoaJuridica(2, "Empresa B", "987654321"));
        try {
            repo3.persistir("pessoasJuridicas.dat");

            PessoaJuridicaRepo repo4 = new PessoaJuridicaRepo();
            repo4.recuperar("pessoasJuridicas.dat");
            for (PessoaJuridica pessoa : repo4.getPessoasJuridicas()) {
                pessoa.exibir();
            }
        } catch (IOException | ClassNotFoundException e) {
           
        }
    }
}