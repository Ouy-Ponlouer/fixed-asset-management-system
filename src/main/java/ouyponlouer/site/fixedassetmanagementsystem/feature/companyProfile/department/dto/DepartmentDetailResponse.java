package ouyponlouer.site.fixedassetmanagementsystem.feature.companyProfile.department.dto;

import java.time.LocalDate;

public record DepartmentDetailResponse (

        Integer id,
        String departmentNameEn,
        String departmentNameKh,
        LocalDate createAt
) {
}
