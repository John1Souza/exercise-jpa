package basic.test;

public class NewProduct {
  public static void main(String[] args){
    Product product = new Product("Pen", 7.45);
    
    DAO<Product> dao = new DAO<>(Product.class);
    dao.openTransaction().addTransaction(product).closeTransaction().close();
    //dao.addAtomicTransaction(product).close();

    System.out.println("Product ID: " + product.getId());
  }
}
