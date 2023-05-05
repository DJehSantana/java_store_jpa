package br.com.challenge.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal value;
    private LocalDate createdAt = LocalDate.now();

    @ManyToOne
    private Client client;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItens> itens = new ArrayList<>();


    public Order() {}

    public Order(Client client ) {
        this.client = client;
    }

    //recebe o item e
    public void setItens(OrderItens item) {
        item.setOrder(this);
        this.itens.add(item);
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

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Order{" +
                "value=" + value +
                ", createdAt=" + createdAt +
                ", client=" + client +
                ", itens=" + itens +
                '}';
    }
}
