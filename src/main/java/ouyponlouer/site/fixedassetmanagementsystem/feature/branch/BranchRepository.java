package ouyponlouer.site.fixedassetmanagementsystem.feature.branch;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ouyponlouer.site.fixedassetmanagementsystem.domain.companyProfileDomain.Branch;

import java.util.Optional;

@Repository
public interface BranchRepository extends JpaRepository<Branch,Integer> {

    // Native SQL
    @Query(value = "SELECT EXISTS(SELECT * FROM branches WHERE branch_code=?1)",nativeQuery = true)
    boolean existsByBranchCode(String branchCode);

    // select branch name en
    @Query(value = "SELECT EXISTS (select * FROM branches WHERE branch_name_en=?1)",nativeQuery = true)
    boolean existsByBranchNameEn(String branchNameEn);

    // select branch name kh
    @Query(value = "SELECT EXISTS (select * FROM branches WHERE branch_name_kh=?1)",nativeQuery = true)
    boolean existsByBranchNameKh(String branchNameKh);

    // select email
    @Query(value = "SELECT EXISTS (select * FROM branches WHERE email=?1)",nativeQuery = true)
    boolean existsByEmail(String email);

    // select phone number
    @Query(value = "SELECT EXISTS (select * FROM branches WHERE phone_number=?1)",nativeQuery = true)
    boolean existsByPhoneNumber(String phoneNumber);


    Optional<Branch> findById(Integer id);
    Optional<Branch> findByBranchCode(String branchCode);

    //SELECT b FROM Branch b WHERE b.branchNameEn = ?1
    Optional<Branch> findByBranchNameEn(String branchNameEn);


}
