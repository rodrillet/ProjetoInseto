package model.type;

import interfaces.Inseto;
import model.InsectMember;

public class Cigarra extends InsectMember implements Inseto {

    public Cigarra(String nome, int id){
        super(nome, id);
    }

    @Override
    public void emitirSom() {
        System.out.println("sis-sis" + super.getNome());
    }
}
