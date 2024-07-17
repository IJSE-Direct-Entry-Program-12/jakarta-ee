package lk.ijse.dep12.jpa.relationship.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@ToString(exclude = "orders")
@Table(name = "customer")
public class Customer implements Serializable {
    @Id
    private String contact;
    private String name;
    private String address;
    @OneToMany(mappedBy = "customer", cascade = {CascadeType.PERSIST, CascadeType.DETACH})
    @Setter(AccessLevel.NONE)
    private List<Order> orders = new ArrayList<>();

    public Customer(String contact, String name, String address) {
        this.contact = contact;
        this.name = name;
        this.address = address;
    }

    public Customer(String contact, String name, String address, List<Order> orders) {
        if (orders != null && !orders.isEmpty()) {
            orders.stream().filter(order -> order.getCustomer() == null)
                    .forEach(order -> order.setCustomer(this));
        }
        if (orders != null && !orders.isEmpty()) {
            orders.forEach(order -> {
                if (order.getCustomer() != this)
                    throw new IllegalStateException("An order:%s is already associated with another customer"
                            .formatted(order.getId()));
            });
        }
        this.contact = contact;
        this.name = name;
        this.address = address;
        this.orders = orders;
    }

    @PrePersist
    public void beforePersist(){
        System.out.println("Before Persist");
    }

    @PostPersist
    public void afterPersist(){
        System.out.println("After Persist");
    }

    @PreUpdate
    public void beforeUpdate(){
        System.out.println("Before Update");
    }

    @PostUpdate
    public void afterUpdate(){
        System.out.println("After update");
    }
}
