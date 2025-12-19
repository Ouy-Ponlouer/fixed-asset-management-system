package ouyponlouer.site.fixedassetmanagementsystem.domain.companyProfileDomain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "branches")
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 20)
    private String initial;

    @Column(nullable = false,length = 20)
    private String companyName;

    @Column(nullable = false, length = 20)
    private String branchCode;

    @Column(nullable = false, length = 20,unique = true)
    private String branchNameEn;

    @Column(nullable = false,length = 30,unique = true)
    private String branchNameKh;

    @Column(nullable = false,length = 50,unique = true)
    private String email;

    @Column(nullable = true,length = 100)
    private String address;

    @Column( nullable = true,length = 15)
    private String phoneNumber;

    private LocalDate startDate;
    private String website;
    private String description;
    private Boolean isActive;

    // One Branch has many employee
    @OneToMany(mappedBy = "branches") // by directional association, it tells JPA that don't create new table I had created column on table Employee, and Employee depend on Position
    private List<Employee> employees;

}
