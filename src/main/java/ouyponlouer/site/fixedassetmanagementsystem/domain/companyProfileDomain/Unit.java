package ouyponlouer.site.fixedassetmanagementsystem.domain.companyProfileDomain;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="units")
public class Unit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false,unique = true)
    private String unitNameEn;

    @Column (nullable = false,unique = true)
    private String unitNameKh;

    private LocalDate createAt;
}
