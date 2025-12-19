package ouyponlouer.site.fixedassetmanagementsystem.feature.employee.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateEmployeeRequest(
    String code,
    @Size(max = 20,message = "Employee Name En must be less than 20")
    @NotBlank(message = "Employee Name En is required")
    String employeeNameEn,

    @Size(max = 20,message = "Employee Name Kh must be less than 20")
    @NotBlank(message = "Employee Name Kh is required")
    String employeeNameKh,

    @Size(max = 6,message = "Gender must be less than 6")
    @NotBlank(message = "Gender is required")
    String gender,

    @Size(max = 20,message = "Branch Name must be less than 20")
    @NotBlank(message = "Branch Name is required")
    String branchName,

    @Size(max = 20,message = "Department Name must be less than 20")
    @NotBlank(message = "Department Name is required")
    String departmentName,

    @Size(max = 20,message = "Position Name must be less than 20")
    @NotBlank(message = "Position Name is required")
    String positionName,

    @Size(max = 20,message = "Unit Name must be less than 20")
    @NotBlank(message = "Unit Name is required")
    String unitName

) {
}
