package br.com.challenge.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "order_itens")
public class OrderItens {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal value;
    private int amount;

    @ManyToOne
    private Order order;
    @ManyToOne
    private Product product;

    public OrderItens() {}

    public OrderItens(int amount, Order order, Product product) {
        this.amount = amount;
        this.order = order;
        this.product = product;
        this.value = product.getValue();
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
