package ouyponlouer.site.fixedassetmanagementsystem.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

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

    @Column(nullable = false,length = 50)
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

//    @Column(nullable = false)
    private LocalDate startDate;
    private String website;
    private String description;
    private Boolean isActive;

}
