package ouyponlouer.site.fixedassetmanagementsystem.feature.assetSetting.assetCategory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ouyponlouer.site.fixedassetmanagementsystem.domain.assetSettingDomain.AssetCategory;

@Repository
public interface AssetCategoryRepository extends JpaRepository<AssetCategory, Integer> {

    @Query(value = "SELECT EXISTS (SELECT * FROM asset_categories WHERE asset_category_name_en = ?1)", nativeQuery = true)
    Boolean existsByAssetCategoryNameEn(String assetCategoryNameEn);

    @Query(value = "SELECT EXISTS (SELECT * FROM asset_categories WHERE asset_category_name_kh = ?1)", nativeQuery = true)
    Boolean existsByAssetCategoryNameKh(String assetCategoryNameKh);

    @Query(value = "SELECT EXISTS (SELECT * FROM asset_categories WHERE initial = ?1)", nativeQuery = true)
    Boolean existsByInitial(String initial);


}
