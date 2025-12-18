package ouyponlouer.site.fixedassetmanagementsystem.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false,unique = true,length = 30)
    private String departmentNameEn;

    @Column(nullable = false,unique = true,length = 30)
    private String departmentNameKh;

    private LocalDate createAt;

}
