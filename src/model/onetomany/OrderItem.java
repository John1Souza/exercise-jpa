package model.onetomany;

import javax.persistence.ManyToOne;

@Entity
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Order order;

    @ManyToOne
    private Product product;

    private int quantity;
    private Double price;

    public OrderItem(){

    }

    public OrderItem(Order order, Product product, int quantity){
        super();
        this.setOrder(order);
        this.setProduct(product);
        this.setQuantity(quantity);
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public Order getOrder(){
        return order;
    }

    public void setOrder(Order order){
        this.order = order;
    }

    public Product getProduct(){
        return product;
    }

    public void setProduct(Product product){
        this.product = product;
        if(product != null && this.price == null){
            this.setPrice(product.getPrice());
        }
    }

    public int getQuantity(){
        return quantity;
    }

    public void setOrder(int quantity){
        this.quantity = quantity;
    }

    public Double getPrice(){
        return price;
    }

    public void setPrice(Double price){
        this.price = price;
    }
}