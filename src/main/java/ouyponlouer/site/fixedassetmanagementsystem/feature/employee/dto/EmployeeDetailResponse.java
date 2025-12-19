package ouyponlouer.site.fixedassetmanagementsystem.feature.employee.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record EmployeeDetailResponse(
        Integer id,
        String code,
        String employeeNameEn,
        String employeeNameKh,
        String gender,
        String branchName,
        String departmentName,
        String positionName,
        String unitName

) {
}
