package model.type;
import interfaces.Inseto;
import model.InsectMember;

public class Grilo extends InsectMember implements Inseto {


    public Grilo(String nome, int id) {
        super(nome, id);
    }


    @Override
    public void emitirSom() {
        System.out.println("Cri-cri (" + getNome() + ")");
    }


}
