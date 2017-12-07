import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException {
        int op = 0;
        Scanner ler = new Scanner(System.in);
        Pessoa p = new Pessoa();

        do {
            System.out.println("---------- CADASTRO ----------");
            System.out.println("1 - Adicionar Pessoa;");
            System.out.println("2 - Listar Pessoas;");
            System.out.println("3 - Alterar Pessoas;");
            System.out.println("4 - Deletar Pessoas;");
            System.out.println("0 - Sair");
            System.out.println("---------- -------- ----------");
            System.out.println("ESCOLHA UMA DAS OPÇÕES:");
            op = ler.nextInt();

            switch (op){
                case 1:{
                    p.CadastrarPessoa();
                    break;
                }
                case 2:{
                    p.ListaPessoa();
                    break;
                }
                case 3:{
                    p.AlterarPessoa();
                    break;
                }
                case 4:{
                    p.DeletarPessoas();
                    break;
                }
                case 0:{
                    System.out.println("Programa Encerrado.");
                    break;
                }
            }
        }while (op!=0);
    }

}
