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
@Table(name="positions")
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true, length = 20)
    private String positionNameEn;

    @Column(nullable = false, unique = true, length = 20)
    private String positionNameKh;

    private LocalDate createAt;

    // On Position has many employee
    @OneToMany(mappedBy = "positions") // by directional association, it tells JPA that don't create new table I had created column on table Employee, and Employee depend on Position
    private List<Employee> employees;
}