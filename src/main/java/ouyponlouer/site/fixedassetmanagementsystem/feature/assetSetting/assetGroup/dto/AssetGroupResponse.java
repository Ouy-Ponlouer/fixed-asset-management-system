package ouyponlouer.site.fixedassetmanagementsystem.feature.assetSetting.assetGroup.dto;

import java.math.BigDecimal;

public record AssetGroupResponse (
        Integer id,
        String assetGroupNameEn,
        String assetGroupNameKh,
        String currency,
        BigDecimal minPrice,
        BigDecimal maxPrice
){
}
