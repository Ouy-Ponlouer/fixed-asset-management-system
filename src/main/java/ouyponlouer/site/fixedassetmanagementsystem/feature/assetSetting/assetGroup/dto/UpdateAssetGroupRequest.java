package ouyponlouer.site.fixedassetmanagementsystem.feature.assetSetting.assetGroup.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record UpdateAssetGroupRequest(

        @Size(max = 20, message = "Asset group name in English must not exceed 20 characters")
        @NotBlank( message = "Asset group name in English is required")
        String assetGroupNameEn,

        @Size(max = 20, message = "Asset group name in Khmer must not exceed 20 characters")
        @NotBlank( message = "Asset group name in Khmer is required")
        String assetGroupNameKh,

        @Size(min=3,max = 3, message = "Currency must be a 3-letter ISO code")
        @NotBlank( message = "Currency is required")
        String currency,

        @Positive( message = "Minimum price must be positive")
        @NotNull( message = "Minimum price is required")

        BigDecimal minPrice,

        @Positive(message =  "Maximum price must be positive")
        @NotNull( message = "Maximum price is required")
        BigDecimal maxPrice
) {
}
