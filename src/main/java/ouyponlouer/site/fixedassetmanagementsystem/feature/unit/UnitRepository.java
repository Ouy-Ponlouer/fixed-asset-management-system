package ouyponlouer.site.fixedassetmanagementsystem.feature.unit;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ouyponlouer.site.fixedassetmanagementsystem.domain.Unit;

import java.util.Optional;

@Repository
public interface UnitRepository extends JpaRepository<Unit,Integer> {

    //JPQL
    @Query("""
            SELECT exists (SELECT u FROM 
            Unit as u 
            WHERE  u.unitNameEn=?1 )  
    """)
    boolean existsByUnitNameEn(String unitNameEn);


    // Check name kh
    @Query("""
            SELECT exists (SELECT u FROM 
            Unit as u 
            WHERE  u.unitNameKh=?1 )  
    """)
    boolean existsByUnitNameKh(String unitNameKh);


    // find Id


    @Override
    Optional<Unit> findById(Integer integer);
}
