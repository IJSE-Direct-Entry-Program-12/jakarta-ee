package lk.ijse.dep12.jpa.relationship.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "`order`")
@ToString(exclude = "orderDetailList")
public class Order implements Serializable {
    @Id
    private String id;
    private Date date;
    @Column(name = "customer_name")
    private String customerName;
    @OneToMany(mappedBy = "order", cascade = {CascadeType.PERSIST, CascadeType.DETACH})
    @Setter(AccessLevel.NONE)
    private List<OrderDetail> orderDetailList = new ArrayList<>();

    public Order(String id, Date date, String customerName) {
        this.id = id;
        this.date = date;
        this.customerName = customerName;
    }

    public Order(String id, Date date, String customerName, List<OrderDetail> orderDetailList) {
        if (orderDetailList != null && !orderDetailList.isEmpty()) {
            orderDetailList.stream().filter(od -> od.getOrder() == null).forEach(od -> od.setOrder(this));
            orderDetailList.forEach(od -> {
                if (od.getOrder() != this)
                    throw new IllegalStateException("The order %s is already associated with another order"
                        .formatted(od.getOrder().getId()));
            });
        }
        this.id = id;
        this.date = date;
        this.customerName = customerName;
        this.orderDetailList = orderDetailList;
    }

    @PrePersist
    public void beforePersist(){
        if (getOrderDetailList().isEmpty())
            throw new IllegalStateException("The order does not have any order details");
    }
}
