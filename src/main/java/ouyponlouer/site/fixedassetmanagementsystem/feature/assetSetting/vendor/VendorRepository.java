package ouyponlouer.site.fixedassetmanagementsystem.feature.assetSetting.vendor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ouyponlouer.site.fixedassetmanagementsystem.domain.assetSettingDomain.Vendor;

@Repository
public interface VendorRepository extends JpaRepository<Vendor,Integer> {


    @Query(value = "SELECT EXISTS (SELECT * FROM vendors as v WHERE v.email = ?1)", nativeQuery = true)
    boolean existsByEmail(String email);

    @Query(value = "SELECT EXISTS (SELECT * FROM vendors as v WHERE v.phone_number = ?1)", nativeQuery = true)
    boolean existsBYPhoneNumber(String phoneNumber);

}
