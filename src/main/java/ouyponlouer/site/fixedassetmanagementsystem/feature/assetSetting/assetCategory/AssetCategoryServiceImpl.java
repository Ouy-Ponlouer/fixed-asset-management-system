package ouyponlouer.site.fixedassetmanagementsystem.feature.assetSetting.assetCategory;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ouyponlouer.site.fixedassetmanagementsystem.domain.assetSettingDomain.AssetCategory;
import ouyponlouer.site.fixedassetmanagementsystem.domain.assetSettingDomain.AssetGroup;
import ouyponlouer.site.fixedassetmanagementsystem.feature.assetSetting.assetCategory.dto.AssetCategoryResponse;
import ouyponlouer.site.fixedassetmanagementsystem.feature.assetSetting.assetCategory.dto.CreateAssetCategoryRequest;
import ouyponlouer.site.fixedassetmanagementsystem.feature.assetSetting.assetGroup.AssetGroupRepository;
import ouyponlouer.site.fixedassetmanagementsystem.mapper.assetSettingMapper.AssetCategoryMapper;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class AssetCategoryServiceImpl implements  AssetCategoryService {

    private final AssetCategoryRepository assetCategoryRepository;
    private final AssetCategoryMapper assetCategoryMapper;
    private final AssetGroupRepository assetGroupRepository;


    //--------------------------------------------
    // Create
    //--------------------------------------------

    @Override
    public AssetCategoryResponse createAssetCategory(CreateAssetCategoryRequest createAssetCategoryRequest) {

        // Validate initial
        if( assetCategoryRepository.existsByInitial(createAssetCategoryRequest.initial()))
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT," Initial already exists"
            );

        // Validate asset category name en
        if( assetCategoryRepository.existsByAssetCategoryNameEn(createAssetCategoryRequest.assetCategoryNameEn()))
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT," Asset Category name en already exists"
            );

        // Validate asset category name en
        if( assetCategoryRepository.existsByAssetCategoryNameKh(createAssetCategoryRequest.assetCategoryNameKh()))
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT," Asset Category name kh already exists"
            );

        // Validate Asset group
        AssetGroup assetGroup= assetGroupRepository.findById(createAssetCategoryRequest.groupId())
                .orElseThrow(()->new ResponseStatusException(
                        HttpStatus.NOT_FOUND," Asset Group not found"
                ));

        AssetCategory assetCategory = assetCategoryMapper.fromCreateAssetCategoryRequest(createAssetCategoryRequest);
        assetCategory.setAssetGroups(assetGroup);
        assetCategory.setCreateAt(LocalDate.now());

        assetCategoryRepository.save(assetCategory);

        return assetCategoryMapper.toAssetCategoryResponse(assetCategory);
    }
}
