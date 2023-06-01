package factory;

import model.Cigarra;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CigarraDAO {
    private Connection connection;


    public CigarraDAO() throws SQLException {
        this.connection = ConnectionFactory.getConnection();
    }

    public void inserir(Cigarra cigarra) {
        String sql = "INSERT INTO CIGARRAS (CIGARRA_ID, CIGARRA_NOME) VALUES (?, ?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, cigarra.getId());
            stmt.setString(2, cigarra.getNome());
            stmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Cigarra cigarra) {
        String sql = "UPDATE CIGARRAS SET NOME CIGARRA_NOME = ? WHERE CIGARRA_ID = ?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, cigarra.getNome());
            stmt.setInt(2, cigarra.getId());
            stmt.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deletar(Cigarra cigarra) {
        String sql = "DELETE FROM CIGARRAS WHERE CIGARRA_ID = ?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, cigarra.getId());
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Cigarra> getAll() {
        List<Cigarra> cigarras = new ArrayList<>();
        String sql = "SELECT CIGARRA_ID, CIGARRA_NOME FROM CIGARRAS";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int codigo = rs.getInt("CIGARRA_ID");
                String nome = rs.getString("CIGARRA_NOME");

                Cigarra cigarra = new Cigarra(nome, codigo);
                cigarras.add(cigarra);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return cigarras;
    }
}



