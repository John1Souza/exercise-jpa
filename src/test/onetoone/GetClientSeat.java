package test.onetoone;

import infra.DAO;
import model.onetoone.Client;

public class GetClientSeat {
    public static void main(String[] args) {
        //DAO<Client> dao = new DAO<>(Client.class);
        DAO<Client> daoClient = new DAO<>(Client.class);

        Client client = daoClient.getByID(1L);
        System.out.println(client.getSeat().getName());
        daoClient.cloese();

        DAO<Seat> daoSeat = new DAO<>(Seat.class);

        Seat seat = daoSeat.getByID(4L);
        System.out.println(seat.getClient().getName());

        
        daoSeat.cloese();
    }
}