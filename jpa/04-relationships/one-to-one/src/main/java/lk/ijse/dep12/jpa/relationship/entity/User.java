package lk.ijse.dep12.jpa.relationship.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "\"user\"")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    @Id
    private String nic;
    private String name;
    private String address;
    private Date dob;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @JoinColumn(name = "partner_nic", referencedColumnName = "nic")
    @OneToOne
    private User partner;
    private Date date;

    public User(String nic, String name, String address, Date dob, Gender gender) {
        this.nic = nic;
        this.name = name;
        this.address = address;
        this.dob = dob;
        this.gender = gender;
    }

    public enum Gender {
        MALE, FEMALE
    }
}
