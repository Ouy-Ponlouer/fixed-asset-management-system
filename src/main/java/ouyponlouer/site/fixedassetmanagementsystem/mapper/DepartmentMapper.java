package ouyponlouer.site.fixedassetmanagementsystem.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ouyponlouer.site.fixedassetmanagementsystem.domain.companyProfileDomain.Department;
import ouyponlouer.site.fixedassetmanagementsystem.feature.companyProfile.department.dto.CreateDepartmentRequest;
import ouyponlouer.site.fixedassetmanagementsystem.feature.companyProfile.department.dto.DepartmentDetailResponse;
import ouyponlouer.site.fixedassetmanagementsystem.feature.companyProfile.department.dto.UpdateDepartmentRequest;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {

    // Response
    DepartmentDetailResponse toDepartmentDetailResponse(Department department);

    // Create
    Department fromDepartmentRequest(CreateDepartmentRequest createDepartmentRequest);

    // Update
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Department froUpdateDepartmentRequest(UpdateDepartmentRequest updateDepartmentRequest,@MappingTarget Department department);
}
