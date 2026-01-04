package ouyponlouer.site.fixedassetmanagementsystem.feature.assetSetting.assetCategory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ouyponlouer.site.fixedassetmanagementsystem.domain.assetSettingDomain.AssetCategory;
import ouyponlouer.site.fixedassetmanagementsystem.feature.assetSetting.assetCategory.dto.AssetCategoryResponse;

import java.util.Optional;

@Repository
public interface AssetCategoryRepository extends JpaRepository<AssetCategory, Integer> {

    @Query(value = "SELECT EXISTS (SELECT * FROM asset_categories WHERE asset_category_name_en = ?1)", nativeQuery = true)
    Boolean existsByAssetCategoryNameEn(String assetCategoryNameEn);

    @Query(value = "SELECT EXISTS (SELECT * FROM asset_categories WHERE asset_category_name_kh = ?1)", nativeQuery = true)
    Boolean existsByAssetCategoryNameKh(String assetCategoryNameKh);

    @Query(value = "SELECT EXISTS (SELECT * FROM asset_categories WHERE initial = ?1)", nativeQuery = true)
    Boolean existsByInitial(String initial);

    Optional<AssetCategory> findByCode(String code);
//    AssetCategory findByCode(String code);


    // Your existing existsBy... methods remain unchanged

//    @Query("SELECT new ouyponlouer.site.fixedassetmanagementsystem.feature.assetSetting.assetCategory.dto.AssetCategoryResponse(" +
//            "ac.id, " +
//            "ac.initial, " +
//            "ac.assetCategoryNameEn, " +
//            "ac.assetCategoryNameKh, " +
//            "ag.id, " +
//            "ag.assetGroupNameEn, " +  // or ag.assetGroupNameKh if preferred
//            "ac.depreciationMethod, " +
//            "ac.depreciationCycle, " +
//            "ac.usefulLife, " +
//            "ac.createdAt" +
//            ") " +
//            "FROM AssetCategory ac " +
//            "JOIN ac.assetGroup ag")
//    Page<AssetCategoryResponse> findAllWithGroupProjected(Pageable pageable);


}
