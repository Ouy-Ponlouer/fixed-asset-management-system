package ouyponlouer.site.fixedassetmanagementsystem.domain.assetSettingDomain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "asset_units")
public class AssetUnit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false,unique = true)
    private String assetUnitNameEn;

    @Column(nullable = false,unique = true)
    private String assetUnitNameKh;

    private LocalDate createAt;
}
