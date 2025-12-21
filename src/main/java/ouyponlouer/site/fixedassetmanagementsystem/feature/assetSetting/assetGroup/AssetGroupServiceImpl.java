package ouyponlouer.site.fixedassetmanagementsystem.feature.assetSetting.assetGroup;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ouyponlouer.site.fixedassetmanagementsystem.domain.assetSettingDomain.AssetGroup;
import ouyponlouer.site.fixedassetmanagementsystem.feature.assetSetting.assetGroup.dto.AssetGroupResponse;
import ouyponlouer.site.fixedassetmanagementsystem.feature.assetSetting.assetGroup.dto.CreateAssetGroupRequest;
import ouyponlouer.site.fixedassetmanagementsystem.feature.assetSetting.assetGroup.dto.UpdateAssetGroupRequest;
import ouyponlouer.site.fixedassetmanagementsystem.mapper.assetSettingMapper.AssetGroupMapper;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class AssetGroupServiceImpl implements AssetGroupService {

    private final AssetGroupRepository assetGroupRepository;
    private final AssetGroupMapper assetGroupMapper;

    //--------------------------------------------
    // Create Asset Group
    //--------------------------------------------

    @Override
    public AssetGroupResponse createAssetGroup(CreateAssetGroupRequest createAssetGroupRequest) {

        // Validate Min Price <= Max Price
        if(createAssetGroupRequest.minPrice().compareTo(createAssetGroupRequest.maxPrice())>0)
            throw new ResponseStatusException(
                    org.springframework.http.HttpStatus.BAD_REQUEST,
                    "Min Price cannot be greater than Max Price"
            );

        // I'm not validate unique field
        AssetGroup assetGroup=assetGroupMapper.fronCreateAssetGroupRequest(createAssetGroupRequest);
        assetGroup.setCreateAt(LocalDate.now());
        assetGroupRepository.save(assetGroup);

        return assetGroupMapper.toAssetGroupResponse(assetGroup);
    }


    //--------------------------------------------
    // Delete Asset Group
    //--------------------------------------------

    @Override
    public void deleteById(Integer id) {
        AssetGroup assetGroup=assetGroupRepository.findById(id).orElseThrow(
                ()->new ResponseStatusException(
                        org.springframework.http.HttpStatus.NOT_FOUND,
                        "Asset Group Not Found"
                )
        );

        assetGroupRepository.delete(assetGroup);
    }

    @Override
    public AssetGroupResponse getById(Integer id) {
        AssetGroup assetGroup=assetGroupRepository.findById(id).orElseThrow(
                ()->new ResponseStatusException(
                        org.springframework.http.HttpStatus.NOT_FOUND,
                        "Asset Group Not Found"
                )
        );
        return assetGroupMapper.toAssetGroupResponse(assetGroup);
    }


    //--------------------------------------------
    // Get All Asset Groups
    //--------------------------------------------
    @Override
    public Page<AssetGroupResponse> getAll(int pageNo, int pageSize) {

        Sort sort= Sort.by(Sort.Direction.DESC,"id");
        PageRequest pageRequest=PageRequest.of(pageNo-1,pageSize,sort);
        Page<AssetGroup> assetGroupPage=assetGroupRepository.findAll(pageRequest);

        return assetGroupPage.map(assetGroupMapper::toAssetGroupResponse);
    }


    //--------------------------------------------
    // Update
    //--------------------------------------------

    @Override
    public AssetGroupResponse updateById(Integer id, UpdateAssetGroupRequest updateAssetGroupRequest) {
        AssetGroup assetGroup=assetGroupRepository.findById(id).orElseThrow(
                ()->new ResponseStatusException(
                        org.springframework.http.HttpStatus.NOT_FOUND,
                        "Asset Group Not Found"
                )
        );
        assetGroupMapper.fromUpdateAssetGroupRequest(updateAssetGroupRequest,assetGroup);
        assetGroup.setCreateAt(LocalDate.now());
        assetGroupRepository.save(assetGroup);
        return assetGroupMapper.toAssetGroupResponse(assetGroup);
    }
}
