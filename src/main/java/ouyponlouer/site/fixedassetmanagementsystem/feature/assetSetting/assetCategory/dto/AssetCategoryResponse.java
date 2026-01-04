package ouyponlouer.site.fixedassetmanagementsystem.feature.assetSetting.assetCategory.dto;

import ouyponlouer.site.fixedassetmanagementsystem.base.DepreciationCycle;
import ouyponlouer.site.fixedassetmanagementsystem.base.DepreciationMethod;
import ouyponlouer.site.fixedassetmanagementsystem.domain.assetSettingDomain.AssetGroup;

import java.time.LocalDate;
import java.util.List;

public record AssetCategoryResponse(
        Integer id,
        String code,
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
