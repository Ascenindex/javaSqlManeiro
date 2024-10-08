package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    private static final String URL = "jdbc:mysql://localhost:3306/UsuariosBD"; // URL com o server aberto, porta e banco de dados
    private static final String USER = "root";
    private static final String PASSWORD = "neorothos2303";

    public static void main(String[] args) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexão estabelecida com sucesso!");
        } catch (SQLException e){
            System.out.println("Erro ou conectar ao banco de dados");
        }

        defineIdUser(connection);
        deleteAllUsers(connection);
        createUser(connection, "Felippi", "ascendino@gmail.com");
        showUser(connection);
        editUser(connection, 1, "Felipe", "ascendino@gmail.com");
        showUser(connection);

    }



    public static void createUser(Connection connectio, String nome, String email) {
        String sql = "insert into usuarios (nome, email) values (?, ?)";
        try (PreparedStatement pstmt = connectio.prepareStatement(sql)) {
            pstmt.setString(1, nome);
            pstmt.setString(2, email);
            pstmt.executeUpdate();
            System.out.println("Usuario criado");

        } catch (SQLException e) {
            System.out.println("Erro ao criar usuario mano: " + e.getMessage());
        }
    }
    
    public static void showUser(Connection connection) {
        String sql = "select * from usuarios";

        try (Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            boolean userExist = false;


            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                System.out.println("ID: "+id+ "Nome: " + nome + ", Email: " + email);
                userExist = true;
            }

            if (!userExist) {
                System.out.println("Nenhum user foi encontrado!");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao mostrar usuarios: " + e.getMessage());
        }
    }
    
    public static void deleteAllUsers(Connection connection) {
        String sql = "delete from usuarios";
        try (Statement stmt = connection.createStatement()) {
            stmt.executeUpdate(sql);
            System.out.println("Todos os usuarios foram deletados");
        } catch (SQLException e) {
            System.out.println("Erro ao deletar todos os usuarios: " + e.getMessage());
        }
    }

    public static void editUser(Connection connection, int id, String nome, String email) {
        String sql = "update usuarios set nome = ?, email = ? where id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, nome);
            pstmt.setString(2, email);
            pstmt.setInt(3, id);
            pstmt.executeUpdate();
            System.out.println("Usuario editado");
        } catch (SQLException e) {
            System.out.println("Erro ao editar usuario: " + e.getMessage());
        }
    }

    public static void defineIdUser(Connection connection) {
        String sql = "alter table usuarios auto_increment = 1";
        try (Statement stmt = connection.createStatement()) {
            stmt.executeUpdate(sql);
            System.out.println("Resetado os ids com sucessos");
        } catch (SQLException e) {
            System.out.println("Erro ao resetar os ids: " + e.getMessage());
        }
    }

    

}
