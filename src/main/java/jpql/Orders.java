package jpql;

import javax.persistence.*;

@Entity
public class Orders {
    @Id
    @GeneratedValue
    private Long id;
    private int orderAmount;

    @Embedded //Adress 임베디드 자료형을 가져온다는뜻
    private Adress adress;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(int orderAmount) {
        this.orderAmount = orderAmount;
    }

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
