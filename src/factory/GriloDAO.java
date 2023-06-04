package factory;

import com.sun.source.tree.TryTree;
import model.Grilo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GriloDAO {
    private Connection connection;


    public GriloDAO() throws SQLException {
        this.connection = ConnectionFactory.getConnection();
    }

    public void inserir(Grilo grilo) {
        String sql = "INSERT INTO GRILOS (GRILO_ID, GRILO_NOME) VALUES (?, ?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, grilo.getId());
            stmt.setString(2, grilo.getNome());
            stmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Grilo grilo) {
        String sql = "UPDATE GRILOS SET GRILO_NOME = ? WHERE GRILO_ID = ?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, grilo.getNome());
            stmt.setInt(2, grilo.getId());
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deletar(Grilo grilo) {
        String sql = "DELETE FROM GRILOS WHERE GRILO_ID = ?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, grilo.getId());
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Grilo> getAll() {
        List<Grilo> grilos = new ArrayList<>();
        String sql = "SELECT grilo_id, grilo_nome FROM GRILOS";

        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("grilo_id");
                String nome = rs.getString("grilo_nome");

                Grilo grilo = new Grilo(nome, id);
                grilos.add(grilo);
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao buscar os grilos do banco de dados", ex);
        }

        return grilos;
    }

}


