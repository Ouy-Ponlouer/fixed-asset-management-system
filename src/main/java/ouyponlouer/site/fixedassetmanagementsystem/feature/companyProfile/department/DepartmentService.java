package ouyponlouer.site.fixedassetmanagementsystem.feature.companyProfile.department;

import org.springframework.data.domain.Page;
import ouyponlouer.site.fixedassetmanagementsystem.feature.companyProfile.department.dto.CreateDepartmentRequest;
import ouyponlouer.site.fixedassetmanagementsystem.feature.companyProfile.department.dto.DepartmentDetailResponse;
import ouyponlouer.site.fixedassetmanagementsystem.feature.companyProfile.department.dto.UpdateDepartmentRequest;

public interface DepartmentService {

    // Create Department
    DepartmentDetailResponse createDepartment(CreateDepartmentRequest createDepartmentRequest);

    // Get All Department
    Page<DepartmentDetailResponse> getAllDepartment(int pageNo, int pageSize);

    // Get Department By Id
    DepartmentDetailResponse getDepartmentById(int id);

    // Delete Department By Id
    void deleteDepartmentById(int id);

    // Update By ID
    DepartmentDetailResponse updateDepartmentById(int id,UpdateDepartmentRequest updateDepartmentRequest);
}
