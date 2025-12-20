package ouyponlouer.site.fixedassetmanagementsystem.feature.companyProfile.employee;

import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import ouyponlouer.site.fixedassetmanagementsystem.feature.companyProfile.employee.dto.CreateEmployeeRequest;
import ouyponlouer.site.fixedassetmanagementsystem.feature.companyProfile.employee.dto.EmployeeDetailResponse;
import ouyponlouer.site.fixedassetmanagementsystem.feature.companyProfile.employee.dto.UpdateEmployeeRequest;

public interface EmployeeService {

    // Create
    EmployeeDetailResponse createEmployee( CreateEmployeeRequest createEmployeeRequest);

    // Get All Employee
    Page<EmployeeDetailResponse> getAllEmployee(int pageNo, int pageSize);

    // Get By Code
    EmployeeDetailResponse getEmployeeByCode(String code);

    // Get By ID
    EmployeeDetailResponse getEmployeeById(Integer id);
    // Delete
    void deleteById(Integer id);

    // Update
    EmployeeDetailResponse updateById(Integer id, @Valid UpdateEmployeeRequest updateEmployeeRequest);


}
