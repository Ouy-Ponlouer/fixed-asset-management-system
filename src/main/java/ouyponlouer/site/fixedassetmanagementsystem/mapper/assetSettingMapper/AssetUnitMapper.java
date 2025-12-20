package ouyponlouer.site.fixedassetmanagementsystem.mapper.assetSettingMapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ouyponlouer.site.fixedassetmanagementsystem.domain.assetSettingDomain.AssetUnit;
import ouyponlouer.site.fixedassetmanagementsystem.feature.assetSetting.assetUnit.dto.AssetUnitResponse;
import ouyponlouer.site.fixedassetmanagementsystem.feature.assetSetting.assetUnit.dto.CreateAssetUnitRequest;
import ouyponlouer.site.fixedassetmanagementsystem.feature.assetSetting.assetUnit.dto.UpdateAssetUnitRequest;

@Mapper(componentModel = "spring")
public interface AssetUnitMapper {

    //Create
    AssetUnit fromCreateAssetUnitRequest(CreateAssetUnitRequest createAssetUnitRequest);

    // Response
    AssetUnitResponse toAssetUnitResponse(AssetUnit assetUnit);

    // Update
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    AssetUnit fromUpdateAssetUnitRequest(UpdateAssetUnitRequest updateAssetUnitRequest, @MappingTarget AssetUnit assetUnit);
}
