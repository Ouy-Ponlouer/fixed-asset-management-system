package ouyponlouer.site.fixedassetmanagementsystem.feature.assetSetting.movementType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ouyponlouer.site.fixedassetmanagementsystem.domain.assetSettingDomain.MovementType;

@Repository
public interface MovementTypeRepository extends JpaRepository<MovementType,Integer> {

    // Native SQL
    @Query(value = "SELECT EXISTS (SELECT * FROM movement_types WHERE movement_type_en=?1)",nativeQuery = true)
    boolean existsByNameEn(String movementTypeEn);

    @Query(value = "SELECT EXISTS (SELECT * FROM movement_types WHERE movement_type_kh=?1)",nativeQuery = true)
    boolean existsByNameKh(String movementTypeKh);

}
