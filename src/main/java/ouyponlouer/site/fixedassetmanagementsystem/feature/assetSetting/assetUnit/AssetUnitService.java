package ouyponlouer.site.fixedassetmanagementsystem.feature.assetSetting.assetUnit;

import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import ouyponlouer.site.fixedassetmanagementsystem.feature.assetSetting.assetUnit.dto.AssetUnitResponse;
import ouyponlouer.site.fixedassetmanagementsystem.feature.assetSetting.assetUnit.dto.CreateAssetUnitRequest;
import ouyponlouer.site.fixedassetmanagementsystem.feature.assetSetting.assetUnit.dto.UpdateAssetUnitRequest;

public interface AssetUnitService {

 // Create
    AssetUnitResponse createAssetUnit(@Valid CreateAssetUnitRequest createAssetUnitRequest);

    //Get All
    Page<AssetUnitResponse> getAllAssetUnit(int pageNo, int pageSize);

    //Get By ID
    AssetUnitResponse getById(Integer id);

    // Delete By ID
    void deleteById(Integer id);

    // Update By ID
    AssetUnitResponse updateById(Integer id, @Valid UpdateAssetUnitRequest updateAssetUnitRequest);
}
