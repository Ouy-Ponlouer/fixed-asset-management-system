package ouyponlouer.site.fixedassetmanagementsystem.feature.assetSetting.assetUnit;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ouyponlouer.site.fixedassetmanagementsystem.domain.assetSettingDomain.AssetUnit;

@Repository
public interface AssetUnitRepository extends JpaRepository<AssetUnit,Integer> {

    boolean existsByAssetUnitNameEn(String assetUnitNameEn);

    boolean existsByAssetUnitNameKh(String assetUnitNameKh);


}
