package ouyponlouer.site.fixedassetmanagementsystem.feature.assetSetting.assetCategory;

import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;
import ouyponlouer.site.fixedassetmanagementsystem.feature.assetSetting.assetCategory.dto.AssetCategoryResponse;
import ouyponlouer.site.fixedassetmanagementsystem.feature.assetSetting.assetCategory.dto.CreateAssetCategoryRequest;
import ouyponlouer.site.fixedassetmanagementsystem.feature.assetSetting.assetCategory.dto.UpdateAssetCategoryRequest;


public interface AssetCategoryService {

    AssetCategoryResponse createAssetCategory(@Valid CreateAssetCategoryRequest createAssetCategoryRequest);

    Page<AssetCategoryResponse> getAll(int pageNo, int pageSize);
    // Get By ID
    AssetCategoryResponse getById(Integer id);

    //Get by Code
    AssetCategoryResponse getByCode(String code);

    // Delete By ID
    void deleteById(Integer id);

    // update by id
    AssetCategoryResponse updateById(Integer id, @Valid UpdateAssetCategoryRequest updateAssetCategoryRequest);
}
