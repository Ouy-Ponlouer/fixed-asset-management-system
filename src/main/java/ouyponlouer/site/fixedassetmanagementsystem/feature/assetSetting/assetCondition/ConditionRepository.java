package ouyponlouer.site.fixedassetmanagementsystem.feature.assetSetting.assetCondition;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ouyponlouer.site.fixedassetmanagementsystem.domain.assetSettingDomain.Condition;

@Repository
public interface ConditionRepository extends JpaRepository<Condition,Integer> {

    // JPQL: Check Name En
    @Query("""
            SELECT EXISTS (SELECT c FROM 
            Condition as c WHERE c.conditionNameEn=?1)
    """)
    boolean existsByConditionNameEn(String conditionNameEn);


    // JPQL: Check Name Kh
    @Query("""
        SELECT EXISTS (SELECT c FROM
     Condition as c WHERE c.conditionNameKh=?1)
    """)
    boolean existsByConditionNameKh(String conditionNameKh);

}
