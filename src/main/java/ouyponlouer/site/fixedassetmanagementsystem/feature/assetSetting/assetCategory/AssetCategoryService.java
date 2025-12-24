package ouyponlouer.site.fixedassetmanagementsystem.feature.assetSetting.assetCategory;

import jakarta.validation.Valid;
import org.springframework.stereotype.Repository;
import ouyponlouer.site.fixedassetmanagementsystem.feature.assetSetting.assetCategory.dto.AssetCategoryResponse;
import ouyponlouer.site.fixedassetmanagementsystem.feature.assetSetting.assetCategory.dto.CreateAssetCategoryRequest;


public interface AssetCategoryService {

    AssetCategoryResponse createAssetCategory(@Valid CreateAssetCategoryRequest createAssetCategoryRequest);
}
