package ouyponlouer.site.fixedassetmanagementsystem.feature.branch.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.Date;

public record BranchDetailResponse(
        String id,
        String initial,
        String branchCode,
        String companyName,
        String branchNameEn,
        String branchNameKh,
        String address,
        String email,
        String phoneNumber,
        String website,
        String description,
        LocalDate startDate
) {
}
