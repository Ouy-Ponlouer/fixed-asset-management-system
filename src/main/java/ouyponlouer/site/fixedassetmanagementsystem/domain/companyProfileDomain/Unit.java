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
@Table(name="units")
public class Unit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false,unique = true,length = 20)
    private String unitNameEn;

    @Column (nullable = false,unique = true,length = 20)
    private String unitNameKh;

    private LocalDate createAt;

    // On Position has many employee
    @OneToMany(mappedBy = "units")// by directional association, it tells JPA that don't create new table I had created column on table Employee, and Employee depend on Position
    private List<Employee> employees;

}
