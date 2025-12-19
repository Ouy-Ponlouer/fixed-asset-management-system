package ouyponlouer.site.fixedassetmanagementsystem.feature.employee;

import org.hibernate.metamodel.internal.EmbeddableInstantiatorPojoIndirecting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ouyponlouer.site.fixedassetmanagementsystem.domain.companyProfileDomain.Employee;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    Optional<Employee> findByCode(String code);
}
