package lk.ijse.dep12.jpa.query.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "`order`")
public class Order implements Serializable {
    @Id
    private String id;
    private Date date;
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    @ManyToOne
    private Customer customer;
    @JoinColumn(name = "username", referencedColumnName = "username")
    @ManyToOne
    private User user;
}
