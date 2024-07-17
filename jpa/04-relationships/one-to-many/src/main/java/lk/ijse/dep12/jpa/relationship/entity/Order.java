package lk.ijse.dep12.jpa.relationship.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "\"order\"")
public class Order implements Serializable {
    @Id
    private String id;
    private Date date;
    private BigDecimal total;
    @JoinColumn(name = "customer_contact", referencedColumnName = "contact")
    @ManyToOne
    private Customer customer;
}
