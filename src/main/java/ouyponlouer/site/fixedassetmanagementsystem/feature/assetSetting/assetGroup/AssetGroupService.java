package ouyponlouer.site.fixedassetmanagementsystem.feature.assetSetting.assetGroup;

import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import ouyponlouer.site.fixedassetmanagementsystem.feature.assetSetting.assetGroup.dto.AssetGroupResponse;
import ouyponlouer.site.fixedassetmanagementsystem.feature.assetSetting.assetGroup.dto.CreateAssetGroupRequest;
import ouyponlouer.site.fixedassetmanagementsystem.feature.assetSetting.assetGroup.dto.UpdateAssetGroupRequest;

public interface AssetGroupService {


    AssetGroupResponse createAssetGroup(@Valid CreateAssetGroupRequest createAssetGroupRequest);

    void deleteById(Integer id);

    AssetGroupResponse getById(Integer id);

    Page<AssetGroupResponse> getAll(int pageNo, int pageSize);

    AssetGroupResponse updateById(Integer id, @Valid UpdateAssetGroupRequest updateAssetGroupRequest);
}
