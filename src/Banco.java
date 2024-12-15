import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;


public class Banco {

    int ID;
    String CPF;
    String userName;
    String password;
    double cash = 0;
    boolean contaExist = false;

    BancoDB DB = new BancoDB();
    Connection conexao = DB.connectToDataBase();

    Banco(int ID) {
        this.ID = ID;

    }

    void exibir() {
        System.out.println("ID: " + ID);
        System.out.println("CPF: " + CPF);
        System.out.println("userName: " + userName);
        System.out.println("password" + password);
        System.out.println("cash: " + cash);

    }

    void criarConta() throws SQLException {

        if(contaExist == false) {

            //getInfo
            Scanner regName = new Scanner(System.in);
            Scanner regCPF = new Scanner(System.in);
            Scanner regPassword = new Scanner(System.in);
            Scanner regSaldoInicial = new Scanner(System.in);

            System.out.println("Registre seu nome: ");
            userName = regName.nextLine();
            System.out.println("digite seu CPF: ");
            CPF = regCPF.nextLine();
            if(CPF.length() != 11) {
                while(true) {
                    System.out.println("digite seu CPF novamente, o valor é maior ou menor do que o limite de caracteres: ");
                    CPF = regCPF.nextLine();
                    if(CPF.length() == 11) {
                        break;
                    }
                }
            }
            System.out.println("digite sua senha: ");
            password = regPassword.nextLine();
            System.out.println("digite o seu saldo inicial para começar  [ R$ ]: ");
            cash = regSaldoInicial.nextDouble();

            //database area


            DB.insertData(ID , CPF , userName ,password , cash , conexao);


            System.out.println("obrigado pelo cadastro! A seguir estará suas informações");
            exibir();
            contaExist = true;

        } else {
            System.out.println("você já possui uma conta");
        }

    }

    void deletarConta() throws SQLException {
        if(contaExist = false) {
            System.out.println("você não possui uma conta para deletar");
        }
        else {
            Scanner deleteWay = new Scanner(System.in);
            System.out.println("escreva sua senha:  ");
            String verificação = deleteWay.nextLine();
            DB.deleteData(verificação , conexao);

        }

    }

    public static void main(String[] args) {


        }
    }
