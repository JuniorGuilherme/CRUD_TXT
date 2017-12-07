import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Pessoa implements Comparable<Pessoa> {
    private int idPessoa;
    private String nome;
    private static int contadorPessoa=-1;
    private static ArrayList<Pessoa> listaPessoa = new ArrayList<Pessoa>();


    public Pessoa(String nome) {
        contadorPessoa++;
        this.idPessoa=contadorPessoa;
        this.nome = nome;
    }

    //AutoIncrement
    public Pessoa (){
        contadorPessoa++;
        this.idPessoa=contadorPessoa;
    }

    public int getIdPessoa() {
        return idPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }



    public static void CadastrarPessoa(){
        Scanner ler = new Scanner(System.in);
        String nome;
        System.out.println("Informe o nome da Pessoa:");
        nome=ler.nextLine();
        Pessoa p = new Pessoa(nome);
        listaPessoa.add(p);
    }

    public static boolean VerificaLista(){
        if (listaPessoa.isEmpty()){
            System.out.println("A lista está vazia!");
            return true;
        }
        else {
            return false;
        }
    }

    public static void ListaPessoa() throws IOException{
        if (VerificaLista()==true){
            System.out.println("Nenhuma Pessoa cadastrada!");
        }
        FileWriter arquivo = new FileWriter("ARQUIVO.txt");
        PrintWriter salvaArq = new PrintWriter(arquivo);
        String dados = "";
        Collections.sort(listaPessoa);
        salvaArq.println("--------- Cadastro de Pessoas --------- ");
        for (int i=0; i<listaPessoa.size(); i++){
            Pessoa p = listaPessoa.get(i);
            salvaArq.printf("ID: %d\n" +
                    "Nome: %s\n", p.getIdPessoa(), p.getNome()+
                    "\n---------------------------------------");

            dados += "\nCODIGO: " +p.getIdPessoa() + "\n" +
                    "NOME: " +p.getNome()+ "\n" +
                    "------------------------------";
        }
        salvaArq.close();
        System.out.println(dados);
    }

    public static void AlteraListaPessoa() throws IOException{
        if (VerificaLista()==true){
            System.out.println("Nenhuma Pessoa cadastrada!");
        }
        FileWriter arquivo = new FileWriter("ARQUIVO.txt");
        PrintWriter salvaArq = new PrintWriter(arquivo);
        String dados = "";
        salvaArq.println("--------- PESSOAS CADASTRADAS --------- ");
        for (int i=0; i<listaPessoa.size(); i++){
            Pessoa p = listaPessoa.get(i);
            salvaArq.printf("ID: %d\n" +
                    "Nome: %s\n", p.getIdPessoa(), p.getNome()+
                    "\n---------------------------------------");
        }
        salvaArq.close();
        System.out.println(dados);
    }

    public static void AlterarPessoa() throws IOException {
        Scanner ler = new Scanner(System.in);
        String nomePessoaPesquisa;

        if (VerificaLista()==true){
            System.out.println("Não existem dados para alterar!");
        }

        System.out.println("Nome que deseja pesquisar: ");
        nomePessoaPesquisa=ler.nextLine();
        for (int i =0; i<listaPessoa.size(); i++){
            Pessoa p = listaPessoa.get(i);
            if (nomePessoaPesquisa.equalsIgnoreCase(p.getNome())){
                String novoNome;
                System.out.println("Digite o novo nome da Pessoa: ");
                novoNome=ler.nextLine();
                p.setNome(novoNome);
                System.out.println("Nome da pessoa alterado com sucesso!");
                AlteraListaPessoa();
                break;

            }

        }

    }

    public static void DeletarPessoas() throws IOException {
        Scanner ler = new Scanner(System.in);
        String nomePessoaPesquisa;

        if (VerificaLista()==true){
            System.out.println("Não há pessoas nesta lista, impossível deletar!");
        }
        System.out.println("Nome que deseja pesquisar: ");
        nomePessoaPesquisa=ler.nextLine();
        for (int i =0; i<listaPessoa.size(); i++){
            Pessoa p = listaPessoa.get(i);
            if (nomePessoaPesquisa.equalsIgnoreCase(p.getNome())){
                listaPessoa.remove(i);
                System.out.println("Cadastro de pessoa DELETADO com sucesso!");
                AlteraListaPessoa();
                break;
            }

        }
    }

    @Override
    public int compareTo(Pessoa p) {
        return this.getNome().compareToIgnoreCase(p.getNome());
    }
}
