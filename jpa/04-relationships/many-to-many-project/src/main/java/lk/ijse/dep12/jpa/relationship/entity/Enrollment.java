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
@Table(name = "enrollment")
@IdClass(EnrollmentPK.class)
public class Enrollment implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private Student student;

    @Id
    @ManyToOne
    @JoinColumn(name = "course_code", referencedColumnName = "code")
    private Course course;

    private Date date;
    @Column(name = "registered_by")
    private String registeredBy;
}
