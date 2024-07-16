package lk.ijse.dep12.jpa.relationship.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.sql.Date;

@ToString(exclude = "account")
@Data
@NoArgsConstructor
@Entity
@Table(name = "customer")
public class Customer implements Serializable {
    @Id
    private String nic;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String address;
    private String contact;
    private Date dob;
    @OneToOne(mappedBy = "customer", cascade = CascadeType.PERSIST)
    @Setter(AccessLevel.NONE)
    private Account account;

    public Customer(String nic, String firstName, String lastName,
                    String address, String contact, Date dob) {
        this.nic = nic;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.contact = contact;
        this.dob = dob;
    }

    public Customer(String nic, String firstName, String lastName, String address,
                    String contact, Date dob, Account account) {
        if (account != null && account.getCustomer() == null) account.setCustomer(this);
        if (account != null && account.getCustomer() != this)
            throw new IllegalStateException("Account is already associated with another customer");
        this.nic = nic;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.contact = contact;
        this.dob = dob;
        this.account = account;
    }
}
