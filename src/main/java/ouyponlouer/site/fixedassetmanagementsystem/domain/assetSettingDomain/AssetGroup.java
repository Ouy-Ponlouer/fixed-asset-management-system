package ouyponlouer.site.fixedassetmanagementsystem.domain.assetSettingDomain;


import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "asset_groups")
public class AssetGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false,unique = false,length = 20)
    private String assetGroupNameEn;

    @Column(nullable = false,unique = false, length = 20)
    private String assetGroupNameKh;

    @Size(min=3, max=3, message="Currency must be a 3-letter ISO code")
    @Pattern(regexp = "[A-Z]{3}")
    @Column(nullable = false,length = 3,columnDefinition = "CHAR(3)")
    private String currency;

    @Column(nullable = false)
    private BigDecimal minPrice;

    @Column(nullable = false)
    private BigDecimal maxPrice;

    @Column(nullable = false)
    private LocalDate createAt;

}
