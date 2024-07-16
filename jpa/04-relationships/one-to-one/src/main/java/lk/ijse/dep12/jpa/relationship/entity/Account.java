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
@Table(name = "account")
public class Account implements Serializable {
    @Id
    private String number;
    private String type;
    private BigDecimal balance;
    @JoinColumn(name = "customer_nic", referencedColumnName = "nic")
    @OneToOne(cascade = CascadeType.PERSIST)
    private Customer customer;
    @Column(name = "open_date")
    private Date openDate;
    private String username;
}
