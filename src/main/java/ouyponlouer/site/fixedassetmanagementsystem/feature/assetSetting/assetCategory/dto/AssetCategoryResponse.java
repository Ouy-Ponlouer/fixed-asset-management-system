package ouyponlouer.site.fixedassetmanagementsystem.feature.assetSetting.assetCategory.dto;

import ouyponlouer.site.fixedassetmanagementsystem.base.DepreciationCycle;
import ouyponlouer.site.fixedassetmanagementsystem.base.DepreciationMethod;

import java.time.LocalDate;

public record AssetCategoryResponse(
        Integer id,
        String initial,

        String assetCategoryNameEn,
        String assetCategoryNameKh,

        Integer assetGroupId,
        String assetGroupName,

        DepreciationMethod depreciationMethod,
        DepreciationCycle depreciationCycle,

        Integer usefulLife,
        LocalDate createdAt

) {
}
