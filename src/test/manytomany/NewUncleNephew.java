package test.manytomany;

import model.manytomany.Nephew;
import model.manytomany.Uncle;

public class NewUncleNephew {
    public static void main (String[] args){
        Uncle aunt = new Uncle("Mary");
        Uncle uncle = new Uncle("John");

        Nephew nephew = new Nephew("Davi");
        Nephew niece = new Nephew("Ana");

        aunt.getNephews().add(nephew);
        nephew.getUncle().add(nephew);

        aunt.getNephews().add(niece);
        nephew.getUncle().add(niece);

        uncle.getNephews().add(nephew);
        nephew.getUncle().add(nephew);

        uncle.getNephews().add(niece);
        nephew.getUncle().add(niece);

        DAO<Object> dao = new DAO<>();

        dao.openTransaction()
            .addTransaction(niece)
            .addTransaction(uncle)
            .addTransaction(nephew)
            .addTransaction(aunt)
            .closeTransaction()
            .closeDAO();
    }
}