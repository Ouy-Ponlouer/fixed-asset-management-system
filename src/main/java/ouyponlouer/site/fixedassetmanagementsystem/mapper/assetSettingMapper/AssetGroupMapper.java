package ouyponlouer.site.fixedassetmanagementsystem.mapper.assetSettingMapper;

import org.mapstruct.*;
import ouyponlouer.site.fixedassetmanagementsystem.domain.assetSettingDomain.AssetGroup;
import ouyponlouer.site.fixedassetmanagementsystem.feature.assetSetting.assetGroup.dto.AssetGroupResponse;
import ouyponlouer.site.fixedassetmanagementsystem.feature.assetSetting.assetGroup.dto.CreateAssetGroupRequest;
import ouyponlouer.site.fixedassetmanagementsystem.feature.assetSetting.assetGroup.dto.UpdateAssetGroupRequest;

@Mapper(componentModel = "spring")
public interface AssetGroupMapper {

    // create
    AssetGroup fronCreateAssetGroupRequest(CreateAssetGroupRequest createAssetGroupRequest);

    // Response
    AssetGroupResponse toAssetGroupResponse(AssetGroup assetGroup);
    // update
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    AssetGroup fromUpdateAssetGroupRequest(UpdateAssetGroupRequest updateAssetGroupRequest, @MappingTarget AssetGroup assetGroup);



}
