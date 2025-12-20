package ouyponlouer.site.fixedassetmanagementsystem.mapper;
import org.mapstruct.*;
import ouyponlouer.site.fixedassetmanagementsystem.domain.companyProfileDomain.Employee;
import ouyponlouer.site.fixedassetmanagementsystem.feature.companyProfile.employee.dto.CreateEmployeeRequest;
import ouyponlouer.site.fixedassetmanagementsystem.feature.companyProfile.employee.dto.EmployeeDetailResponse;
import ouyponlouer.site.fixedassetmanagementsystem.feature.companyProfile.employee.dto.UpdateEmployeeRequest;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    // Create
    Employee fromCreateEmployeeRequest(CreateEmployeeRequest createEmployeeRequest);

    // Response
    @Mapping(target = "branchName",source = "branches.branchNameEn")
    @Mapping(target = "departmentName",source = "departments.departmentNameEn")
    @Mapping(target = "positionName",source ="positions.positionNameEn")
    @Mapping(target = "unitName",source = "units.unitNameEn")
    EmployeeDetailResponse toEmployeeDetailResponse(Employee employee);

    //Update
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Employee fromUpdateEmployeeRequest(UpdateEmployeeRequest updateEmployeeRequest, @MappingTarget Employee employee);


}
