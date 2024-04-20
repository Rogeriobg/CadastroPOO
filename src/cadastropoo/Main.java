/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastropoo;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import model.PessoaFisicaRepo;
import model.PessoaFisica;
import model.PessoaJuridica;
import model.PessoaJuridicaRepo;

public class Main {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PessoaFisicaRepo repoFisica = new PessoaFisicaRepo();
        PessoaJuridicaRepo repoJuridica = new PessoaJuridicaRepo();

        int opcao = -1;
        do {
            System.out.println("Selecione uma opção:");
            System.out.println("1 - Incluir");
            System.out.println("2 - Alterar");
            System.out.println("3 - Excluir");
            System.out.println("4 - Exibir pelo ID");
            System.out.println("5 - Exibir todos");
            System.out.println("6 - Salvar dados");
            System.out.println("7 - Recuperar dados");
            System.out.println("0 - Finalizar");

            try {
                opcao = Integer.parseInt(reader.readLine());
                switch (opcao) {
                    case 1:
                        System.out.println("Selecione o tipo (F - Pessoa Física, J - Pessoa Jurídica):");
                        String tipo = reader.readLine().toUpperCase();
                        if (tipo.equals("F")) {
                            System.out.println("Digite o ID:");
                            int idFisica = Integer.parseInt(reader.readLine());
                            System.out.println("Digite o nome:");
                            String nomeFisica = reader.readLine();
                            System.out.println("Digite o CPF:");
                            String cpf = reader.readLine();
                            System.out.println("Digite a idade:");
                            int idade = Integer.parseInt(reader.readLine());

                            repoFisica.inserir(new PessoaFisica(idFisica, nomeFisica, cpf, idade));
                            System.out.println("Pessoa Física incluída com sucesso.");
                        } else if (tipo.equals("J")) {
                            System.out.println("Digite o ID:");
                            int idJuridica = Integer.parseInt(reader.readLine());
                            System.out.println("Digite o nome:");
                            String nomeJuridica = reader.readLine();
                            System.out.println("Digite o CNPJ:");
                            String cnpj = reader.readLine();

                            repoJuridica.inserir(new PessoaJuridica(idJuridica, nomeJuridica, cnpj));
                            System.out.println("Pessoa Jurídica incluída com sucesso.");
                        } else {
                            System.out.println("Opção inválida.");
                        }
                        break;
                    case 2:
                        System.out.println("Selecione o tipo (F - Pessoa Física, J - Pessoa Jurídica):");
                        String tipoAlteracao = reader.readLine().toUpperCase();
                        if (tipoAlteracao.equals("F")) {
                            System.out.println("Digite o ID da Pessoa Física que deseja alterar:");
                            int idPessoaFisica = Integer.parseInt(reader.readLine());
                            PessoaFisica pessoaFisica = repoFisica.buscarPorId(idPessoaFisica);
                            if (pessoaFisica != null) {

                                System.out.println("Dados atuais da Pessoa Física:");
                                pessoaFisica.exibir();

                                System.out.println("Digite os novos dados da Pessoa Física:");

                                repoFisica.atualizar(pessoaFisica);
                                System.out.println("Pessoa Física atualizada com sucesso.");
                            } else {
                                System.out.println("Pessoa Física com o ID fornecido não encontrada.");
                            }
                        } else if (tipoAlteracao.equals("J")) {
                            System.out.println("Digite o ID da Pessoa Jurídica que deseja alterar:");
                            int idPessoaJuridica = Integer.parseInt(reader.readLine());
                            PessoaJuridica pessoaJuridica = repoJuridica.buscarPorId(idPessoaJuridica);
                            if (pessoaJuridica != null) {

                                System.out.println("Dados atuais da Pessoa Jurídica:");
                                pessoaJuridica.exibir();

                                System.out.println("Digite os novos dados da Pessoa Jurídica:");

                                repoJuridica.atualizar(pessoaJuridica);
                                System.out.println("Pessoa Jurídica atualizada com sucesso.");
                            } else {
                                System.out.println("Pessoa Jurídica com o ID fornecido não encontrada.");
                            }
                        } else {
                            System.out.println("Opção inválida.");
                        }
                        break;
                    case 3:
                        System.out.println("Selecione o tipo (F - Pessoa Física, J - Pessoa Jurídica):");
                        String tipoExclusao = reader.readLine().toUpperCase();
                        if (tipoExclusao.equals("F")) {
                            System.out.println("Digite o ID da Pessoa Física que deseja excluir:");
                            int idPessoaFisica = Integer.parseInt(reader.readLine());
                            PessoaFisica pessoaFisica = repoFisica.buscarPorId(idPessoaFisica);
                            if (pessoaFisica != null) {
                                repoFisica.remover(pessoaFisica);
                                System.out.println("Pessoa Física excluída com sucesso.");
                            } else {
                                System.out.println("Pessoa Física com o ID fornecido não encontrada.");
                            }
                        } else if (tipoExclusao.equals("J")) {
                            System.out.println("Digite o ID da Pessoa Jurídica que deseja excluir:");
                            int idPessoaJuridica = Integer.parseInt(reader.readLine());
                            PessoaJuridica pessoaJuridica = repoJuridica.buscarPorId(idPessoaJuridica);
                            if (pessoaJuridica != null) {
                                repoJuridica.remover(pessoaJuridica);
                                System.out.println("Pessoa Jurídica excluída com sucesso.");
                            } else {
                                System.out.println("Pessoa Jurídica com o ID fornecido não encontrada.");
                            }
                        } else {
                            System.out.println("Opção inválida.");
                        }
                        break;
                    case 4:
                        System.out.println("Selecione o tipo (F - Pessoa Física, J - Pessoa Jurídica):");
                        String tipoExibicaoId = reader.readLine().toUpperCase();
                        if (tipoExibicaoId.equals("F")) {
                            System.out.println("Digite o ID da Pessoa Física que deseja exibir:");
                            int idPessoaFisica = Integer.parseInt(reader.readLine());
                            PessoaFisica pessoaFisica = repoFisica.buscarPorId(idPessoaFisica);
                            if (pessoaFisica != null) {
                                pessoaFisica.exibir();
                            } else {
                                System.out.println("Pessoa Física com o ID fornecido não encontrada.");
                            }
                        } else if (tipoExibicaoId.equals("J")) {
                            System.out.println("Digite o ID da Pessoa Jurídica que deseja exibir:");
                            int idPessoaJuridica = Integer.parseInt(reader.readLine());
                            PessoaJuridica pessoaJuridica = repoJuridica.buscarPorId(idPessoaJuridica);
                            if (pessoaJuridica != null) {
                                pessoaJuridica.exibir();
                            } else {
                                System.out.println("Pessoa Jurídica com o ID fornecido não encontrada.");
                            }
                        } else {
                            System.out.println("Opção inválida.");
                        }
                        break;
                    case 5:
                        System.out.println("Selecione o tipo (F - Pessoa Física, J - Pessoa Jurídica):");
                        String tipoExibicaoTodos = reader.readLine().toUpperCase();
                        if (tipoExibicaoTodos.equals("F")) {
                            List<PessoaFisica> pessoasFisicas = repoFisica.getPessoasFisicas();
                            for (PessoaFisica pessoa : pessoasFisicas) {
                                pessoa.exibir();
                            }
                        } else if (tipoExibicaoTodos.equals("J")) {
                            List<PessoaJuridica> pessoasJuridicas = repoJuridica.getPessoasJuridicas();
                            for (PessoaJuridica pessoa : pessoasJuridicas) {
                                pessoa.exibir();
                            }
                        } else {
                            System.out.println("Opção inválida.");
                        }
                        break;
                    case 6:
                        System.out.println("Digite o prefixo para os arquivos de salvamento:");
                        String prefixoSalvamento = reader.readLine();
                        try {
                            repoFisica.salvar(prefixoSalvamento + ".fisica.bin");
                            repoJuridica.salvar(prefixoSalvamento + ".juridica.bin");
                            System.out.println("Dados salvos com sucesso.");
                        } catch (IOException e) {
                            System.out.println("Erro ao salvar os dados: " + e.getMessage());
                        }
                        break;
                    case 7:
                        System.out.println("Digite o prefixo para os arquivos de recuperação:");
                        String prefixoRecuperacao = reader.readLine();
                        try {
                            repoFisica.recuperar(prefixoRecuperacao + ".fisica.bin");
                            repoJuridica.recuperar(prefixoRecuperacao + ".juridica.bin");
                            System.out.println("Dados recuperados com sucesso.");
                        } catch (IOException | ClassNotFoundException e) {
                            System.out.println("Erro ao recuperar os dados: " + e.getMessage());
                        }
                    case 0:
                        System.out.println("Finalizando...");
                        break;
                    default:
                        System.out.println("Opção inválida.");
                        break;
                }
            } catch (IOException | NumberFormatException e) {
                System.out.println("Erro ao ler entrada do teclado.");
            }
        } while (opcao != 0);
    }
}
