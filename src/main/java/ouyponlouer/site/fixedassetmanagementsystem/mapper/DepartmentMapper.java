package ouyponlouer.site.fixedassetmanagementsystem.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ouyponlouer.site.fixedassetmanagementsystem.domain.Branch;
import ouyponlouer.site.fixedassetmanagementsystem.domain.Department;
import ouyponlouer.site.fixedassetmanagementsystem.feature.department.dto.CreateDepartmentRequest;
import ouyponlouer.site.fixedassetmanagementsystem.feature.department.dto.DepartmentDetailResponse;
import ouyponlouer.site.fixedassetmanagementsystem.feature.department.dto.UpdateDepartmentRequest;

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
