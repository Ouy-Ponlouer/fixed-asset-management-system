package ouyponlouer.site.fixedassetmanagementsystem.domain.assetSettingDomain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="vendors")
public class Vendor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false,length = 20)
    private String vendorNameEn;

    @Column(nullable = false,length = 20)
    private String vendorNameKh;

    @Column(nullable = false,unique = true,length = 50)
    @Email
    private String email;

    @Column(nullable = false,unique = true,length = 15)
    private String phoneNumber;

    @Column(nullable = false,length = 100)
    private String address;

    private LocalDate createAt;




}
