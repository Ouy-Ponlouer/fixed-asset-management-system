package ouyponlouer.site.fixedassetmanagementsystem.feature.assetSetting.depreciation.dto;


import java.util.List;

public record DepreciationOptionsResponse(
        List<EnumOption> depreciation_methods,
        List<EnumOption> depreciation_cycles
) {
}
