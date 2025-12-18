package ouyponlouer.site.fixedassetmanagementsystem.feature.department.dto;

import java.time.LocalDate;

public record DepartmentDetailResponse (

        Integer id,
        String departmentNameEn,
        String departmentNameKh,
        LocalDate createAt
) {
}
