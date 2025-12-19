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
@Table(name="departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false,unique = true,length = 20)
    private String departmentNameEn;

    @Column(nullable = false,unique = true,length = 20)
    private String departmentNameKh;

    private LocalDate createAt;

    // On Position has many employee
    @OneToMany(mappedBy = "departments") // by directional association, it tells JPA that don't create new table I had created column on table Employee, and Employee depend on Position
    private List<Employee> employees;

}
