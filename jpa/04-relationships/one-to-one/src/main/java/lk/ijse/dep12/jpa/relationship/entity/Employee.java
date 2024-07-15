package lk.ijse.dep12.jpa.relationship.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.*;

import java.io.Serializable;

@ToString(exclude = "spouse")
@Data
@NoArgsConstructor
@Entity
@Table(name = "employee")
public class Employee implements Serializable {
    @Id
    private String id;
    private String name;
    private String address;
    private String contact;
    @OneToOne(mappedBy = "employee")
    @Setter(AccessLevel.NONE)
    private Spouse spouse;

//    public void setSpouse(Spouse spouse) {
//        spouse.setEmployee(this);
//        this.spouse = spouse;
//    }

    public Employee(String id, String name, String address, String contact) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.contact = contact;
    }

    public Employee(String id, String name, String address, String contact, Spouse spouse) {
        if (spouse != null && spouse.getEmployee() != this)
            throw new IllegalStateException("Spouse is already associated with another employee");
        this.id = id;
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.spouse = spouse;
    }
}
