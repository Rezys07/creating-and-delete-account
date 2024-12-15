import java.sql.SQLException;

public class testeBanco {
    public static void main(String[] args) throws SQLException {
        Banco conta1 = new Banco((int)(Math.random() * 1000000));
        conta1.contaExist = false;


        conta1.criarConta();
        conta1.deletarConta();
    }
}
