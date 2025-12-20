package ouyponlouer.site.fixedassetmanagementsystem.feature.assetSetting.vendor.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateVendorRequest(

        @Size(max = 20, message = "Vendor name in English must not exceed 20 characters")
        @NotBlank( message = "Vendor name in English is required")
        String vendorNameEn,

        @Size(max = 20, message = "Vendor name in Khmer must not exceed 20 characters")
        @NotBlank( message = "Vendor name in Khmer is required")
        String vendorNameKh,

        @Size(max = 100, message = "Address must not exceed 100 characters")
        @NotBlank( message = "Address is required")
        String address,

        @Size(max = 15, message = "Phone number must not exceed 15 characters")
        @NotBlank( message = "Phone number is required")
        String phoneNumber,

        @Size(max = 50, message = "Email must not exceed 50 characters")
        @NotBlank( message = "Email is required")
        @Email(message = "Email should be valid")
        String email
) {
}
