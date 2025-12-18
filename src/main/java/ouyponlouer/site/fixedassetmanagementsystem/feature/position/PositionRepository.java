package ouyponlouer.site.fixedassetmanagementsystem.feature.position;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ouyponlouer.site.fixedassetmanagementsystem.domain.Position;

import java.util.Optional;

@Repository
public interface PositionRepository extends JpaRepository<Position,Integer> {

    Optional<Position> findById(int id);

    // Native SQL
    @Query(value = "SELECT EXISTS (SELECT * FROM positions WHERE position_name_en=?1)",nativeQuery = true)
    boolean existsByNameEn(String positionNameEn);

    @Query(value = "SELECT EXISTS (SELECT * FROM positions WHERE position_name_kh=?1)",nativeQuery = true)
    boolean existsByNameKh(String positionNameKh);


}
