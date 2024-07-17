package lk.ijse.dep12.jpa.relationship.entity;

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
@Table(name = "\"user\"")
public class User implements Serializable {
    @Id
    private String nic;
    private String name;
    private String address;
    private Date dob;
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @OneToOne
    @JoinTable(name = "partner",
    joinColumns = @JoinColumn(name = "user1_nic", referencedColumnName = "nic"),
    inverseJoinColumns = @JoinColumn(name = "user2_nic", referencedColumnName = "nic"))
    private User partner;

    public User(String nic, String name, String address, Date dob, Gender gender) {
        this.nic = nic;
        this.name = name;
        this.address = address;
        this.dob = dob;
        this.gender = gender;
    }

    public static enum Gender {
        MALE, FEMALE
    }
}
