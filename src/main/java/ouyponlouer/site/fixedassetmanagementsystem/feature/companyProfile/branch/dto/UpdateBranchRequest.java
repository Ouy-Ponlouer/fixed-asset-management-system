package ouyponlouer.site.fixedassetmanagementsystem.feature.companyProfile.branch.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.Date;

public record UpdateBranchRequest(
        @Size(max =50,message ="Initial must be less than 50")
        @NotBlank(message = "Initial is required")
        String initial,

        @Size(max =20,message ="Branch code must be less than 20")
        @NotBlank(message = "Branch code is required")
        String branchCode,

        @Size(max = 50,message ="company name must be less than 50")
        @NotBlank(message = "name is required")
        String companyName,

        @Size(max = 50,message ="Branch Name En must be less than 50")
        @NotBlank(message = "Branch Name En is required")
        String branchNameEn,

        @Size(max = 50,message ="Branch Name Kh must be less than 50")
        @NotBlank(message = "Branch Name Kh is required")
        String branchNameKh,

        @Size(max = 50,message ="Address must be less than 50")
        @NotBlank(message = "Address is required")
        String address,

        String email,

        @Size(max = 15,message ="phone number less than 15")
//        @NotBlank(message = "phone number is required")
        String phoneNumber,
        String website,
        String description,

        @JsonFormat(pattern ="yyy-MM-dd" )
        LocalDate startDate
) {


}
