package test.onetomany;

import infra.DAO;
import model.onetomany.Order;


public class NewOrder {
    public static void main(String[] args){
        DAO<Object> dao = new DAO<>;

        Order order = new Order();
        Product product = new Product("Refrigerator", 2789.99);
        OrderItem item = new OrderItem(order, product);

        dao.openTransaction()
            .addTransaction(product)
            .addTransaction(order)
            .addTransaction(item)
            .closeTransaction()
            .closeDAO();
    }
}