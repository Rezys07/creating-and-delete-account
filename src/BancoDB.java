import java.sql.*;

public class BancoDB {



    public Connection connectToDataBase() {
        return industryConnection.getConexao();
    }




    public void insertData(int ID , String CPF, String userName , String password , double cash , Connection conexao) throws SQLException {
        String sql = """
                INSERT INTO usuarios(ID, userName , CPF , password , cash)
                VALUES (? , ? , ? , ? , ?)
                """;

        PreparedStatement stmt = conexao.prepareStatement(sql);

        stmt.setInt(1 ,ID);
        stmt.setString(2 , userName);
        stmt.setString(3 , CPF);
        stmt.setString(4 , password);
        stmt.setDouble(5 , cash);

        stmt.execute();




    }

    public void deleteData(String password ,Connection conexao) throws SQLException {
        String sql = """
                DELETE FROM usuarios WHERE password = ?;
                """;
        PreparedStatement stmt =  conexao.prepareStatement(sql);
        stmt.setString(1 , password);

        if(stmt.executeUpdate() > 0) {
            System.out.println("conta deletada com sucesso!");
        }
        else {
            System.out.println("a senha está incorreta ou a mesma nem ao menos existe!");
        }

        conexao.close();

    }



}
