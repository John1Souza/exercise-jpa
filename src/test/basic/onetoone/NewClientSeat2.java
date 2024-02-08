package test.basic;

import infra.DAO;
import model.onetoone.Seat;
import model.onetoone.Client;

public class NewClientSeat1 {
    public static void main(String[] args) {
        Seat seat = new Seat("4D");   
        Client client = new Client("Mary Doe", seat);

        DAO<Client> dao = new DAO<>(Client.class);

        dao.addAtomicTransaction(client);
    }
}