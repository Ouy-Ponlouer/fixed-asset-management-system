package ouyponlouer.site.fixedassetmanagementsystem.feature.department;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ouyponlouer.site.fixedassetmanagementsystem.domain.Department;

import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Integer> {

    // Check ID
//    @Query(value = "SELECT exists (SELECT * FROM departments WHERE id=?1)",nativeQuery = true)
//    boolean existsById(int id);

    //Check name en
    @Query(value = "SELECT EXISTS (SELECT * FROM departments WHERE department_name_en=?1)",nativeQuery = true)
    boolean existsByNameEn(String departmentNameEn);

    //Check name en
    @Query(value = "SELECT EXISTS (SELECT * FROM departments WHERE department_name_kh=?1)",nativeQuery = true)
    boolean existsByNameKh(String departmentNameKh);


}
