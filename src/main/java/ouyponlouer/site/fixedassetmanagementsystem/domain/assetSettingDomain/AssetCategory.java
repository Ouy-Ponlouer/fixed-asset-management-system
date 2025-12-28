package ouyponlouer.site.fixedassetmanagementsystem.domain.assetSettingDomain;

import jakarta.persistence.*;
import jdk.jfr.Enabled;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ouyponlouer.site.fixedassetmanagementsystem.base.DepreciationCycle;
import ouyponlouer.site.fixedassetmanagementsystem.base.DepreciationMethod;

import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name="asset_categories")
public class AssetCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false,length = 20, unique = true)
//    private String initial;
//
//    @Column(nullable = false,length = 50)
//    private String assetCategoryNameEn;
//
//    @Column(nullable = false,length = 50)
//    private String assetCategoryNameKh;

//    @Enumerated(EnumType.STRING)
    private DepreciationMethod depreciationMethod;

//    @Enumerated( EnumType.STRING)
    private DepreciationCycle depreciationCycle;

    private Integer usefulLife;
    private LocalDate createAt;


    // one asset category, many asset category
    @ManyToOne(fetch = FetchType.LAZY,optional = false) // fetch only necessary data
    @JoinColumn(name = "asset_group_id",nullable = false)
    private AssetGroup assetGroups;



    @Column(nullable = false,length = 20, unique = true)
    private String initial;

    @Column(nullable = false,length = 50)
    private String assetCategoryNameEn;

    @Column(nullable = false,length = 50)
    private String assetCategoryNameKh;



}
