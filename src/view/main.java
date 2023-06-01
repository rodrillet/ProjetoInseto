package view;

import factory.CigarraDAO;
import factory.ConnectionFactory;
import factory.GriloDAO;
import model.Cigarra;
import model.Grilo;

import java.sql.Connection;
import java.sql.SQLException;

public class main {
    public static void main(String args[]) throws SQLException {


        GriloDAO griloDAO = new GriloDAO();
        CigarraDAO cigarraDAO = new CigarraDAO();

        Grilo grilinho = new Grilo("Grilão", 1);
        griloDAO.inserir(grilinho);

        Cigarra cigarrinha = new Cigarra("Cigarrinha", 1);
        cigarraDAO.deletar(cigarrinha);
    }
}
