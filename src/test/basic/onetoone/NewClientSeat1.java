package test.basic;

import infra.DAO;
import model.onetoone.Seat;
import model.onetoone.Client;

public class NewClientSeat1 {
    public static void main(String[] args) {
        Seat seat = new Seat("16C");   
        Client client = new Client("John Doe", seat);

        DAO<Object> dao = new DAO<>();

        dao.openTransaction()
            .addTransaction(seat)
            .addTransaction(client)
            .closeTransaction()
            .close()
    }
}