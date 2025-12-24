package ouyponlouer.site.fixedassetmanagementsystem.mapper.assetSettingMapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ouyponlouer.site.fixedassetmanagementsystem.domain.assetSettingDomain.AssetCategory;
import ouyponlouer.site.fixedassetmanagementsystem.feature.assetSetting.assetCategory.dto.AssetCategoryResponse;
import ouyponlouer.site.fixedassetmanagementsystem.feature.assetSetting.assetCategory.dto.CreateAssetCategoryRequest;
import ouyponlouer.site.fixedassetmanagementsystem.feature.assetSetting.assetCategory.dto.UpdateAssetCategoryRequest;
import ouyponlouer.site.fixedassetmanagementsystem.feature.assetSetting.assetUnit.dto.CreateAssetUnitRequest;

@Mapper(componentModel = "spring")
public interface AssetCategoryMapper {

    // Create
    AssetCategory fromCreateAssetCategoryRequest(CreateAssetCategoryRequest createAssetCategoryRequest);

    //Response
     AssetCategoryResponse toAssetCategoryResponse(AssetCategory assetCategory);

     // update
    @BeanMapping( nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    AssetCategory fromUpdateAssetCategoryRequest(UpdateAssetCategoryRequest updateAssetCategoryRequest, @MappingTarget AssetCategory assetCategory);


}
