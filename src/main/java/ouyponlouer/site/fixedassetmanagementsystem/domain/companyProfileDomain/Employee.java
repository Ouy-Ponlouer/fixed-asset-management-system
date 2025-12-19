package ouyponlouer.site.fixedassetmanagementsystem.domain.companyProfileDomain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
//@Table(name = "employees")
//@Table(name = "assets")
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String code;

    @Column(nullable = false,length = 20)
    private String employeeNameEn;

    @Column(nullable = false)
    private String employeeNameKh;

    @Column(nullable = false)
    private String gender;

    private LocalDate createAt;

    // Many Employee belong to one branch
    @ManyToOne
    private Branch branches;

    // Many Employee belong to one Department
    @ManyToOne
    private Department departments;

    // Many Employee belong to one position
    @ManyToOne
    private Position positions;

    // Many Employee belong to one unit
    @ManyToOne
    private Unit units;

}
