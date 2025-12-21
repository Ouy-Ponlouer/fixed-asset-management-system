package ouyponlouer.site.fixedassetmanagementsystem.feature.assetSetting.assetGroup;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ouyponlouer.site.fixedassetmanagementsystem.domain.assetSettingDomain.AssetGroup;

@Repository
public interface AssetGroupRepository extends JpaRepository<AssetGroup,Integer> {

}
