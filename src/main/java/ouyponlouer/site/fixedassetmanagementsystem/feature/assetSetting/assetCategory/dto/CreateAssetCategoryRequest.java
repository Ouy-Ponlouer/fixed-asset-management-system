package ouyponlouer.site.fixedassetmanagementsystem.feature.assetSetting.assetCategory.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import ouyponlouer.site.fixedassetmanagementsystem.base.DepreciationCycle;
import ouyponlouer.site.fixedassetmanagementsystem.base.DepreciationMethod;
import ouyponlouer.site.fixedassetmanagementsystem.domain.assetSettingDomain.AssetGroup;

public record CreateAssetCategoryRequest(
        @NotBlank( message = "Initial is required")
        @Size( max = 10, message = "Initial must not exceed 10 characters")
        String initial,

        //----  Foreign Key ----
        @NotNull( message = "Asset group is required")
        Integer assetGroupId,

        @NotBlank( message = "Asset category name in English is required")
        @Size( max = 50, message = "Asset category name in English must not exceed 50 characters")
        String assetCategoryNameEn,

        @NotBlank( message = "Asset category name in Khmer is required")
        @Size( max = 50, message = "Asset category name in Khmer must not exceed 50 characters")
        String assetCategoryNameKh,

        @Enumerated(EnumType.STRING)
        DepreciationMethod depreciationMethod,

        @Enumerated( EnumType.STRING)
        DepreciationCycle depreciationCycle,

        @NotNull( message = "Useful life is required")
        @Positive( message = "Useful life must be positive")
        Integer usefulLife


) {
}
