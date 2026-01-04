package ouyponlouer.site.fixedassetmanagementsystem.feature.assetSetting.assetCategory;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ouyponlouer.site.fixedassetmanagementsystem.base.DepreciationMethod;
import ouyponlouer.site.fixedassetmanagementsystem.domain.assetSettingDomain.AssetCategory;
import ouyponlouer.site.fixedassetmanagementsystem.domain.assetSettingDomain.AssetGroup;
import ouyponlouer.site.fixedassetmanagementsystem.feature.assetSetting.assetCategory.dto.AssetCategoryResponse;
import ouyponlouer.site.fixedassetmanagementsystem.feature.assetSetting.assetCategory.dto.CreateAssetCategoryRequest;
import ouyponlouer.site.fixedassetmanagementsystem.feature.assetSetting.assetCategory.dto.UpdateAssetCategoryRequest;
import ouyponlouer.site.fixedassetmanagementsystem.feature.assetSetting.assetGroup.AssetGroupRepository;
import ouyponlouer.site.fixedassetmanagementsystem.mapper.assetSettingMapper.AssetCategoryMapper;

import java.time.LocalDate;
import java.util.UUID;

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
        AssetGroup assetGroup= assetGroupRepository.findById(createAssetCategoryRequest.assetGroupId())
                .orElseThrow(()->new ResponseStatusException(
                        HttpStatus.NOT_FOUND," Asset Group not found"
                ));

        AssetCategory assetCategory = assetCategoryMapper.fromCreateAssetCategoryRequest(createAssetCategoryRequest);
        assetCategory.setAssetGroup(assetGroup);
        assetCategory.setCreatedAt(LocalDate.now());
        assetCategory.setCode(UUID.randomUUID().toString()); // temporary code to avoid null value
        assetCategoryRepository.save(assetCategory);

        assetCategory.setCode("00"+assetCategory.getId());
        assetCategoryRepository.save(assetCategory);

        return assetCategoryMapper.toAssetCategoryResponse(assetCategory);
    }


    //--------------------------------------------
    // Get All with Pagination
    //--------------------------------------------

    @Override
    public Page<AssetCategoryResponse> getAll(int pageNo, int pageSize) {
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        PageRequest pageRequest = PageRequest.of(pageNo - 1, pageSize, sort);
//        return assetCategoryRepository.findAllWithGroupProjected(pageRequest);
        Page<AssetCategory> assetCategoryPage = assetCategoryRepository.findAll(pageRequest);
        return assetCategoryPage.map(assetCategoryMapper::toAssetCategoryResponse);
    }



    //--------------------------------------------
    // Get By Id
    //--------------------------------------------

    @Override
    public AssetCategoryResponse getById(Integer id) {

        AssetCategory assetCategory= assetCategoryRepository.findById(id)
                .orElseThrow(()->new ResponseStatusException(
                        HttpStatus.NOT_FOUND," Asset Category not found"
                ));

        return assetCategoryMapper.toAssetCategoryResponse( assetCategory);
    }


    //--------------------------------------------
    // Get By code
    //--------------------------------------------

    @Override
    public AssetCategoryResponse getByCode(String code) {

        AssetCategory assetCategory = assetCategoryRepository
                .findByCode( code)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, " Asset Category not found"
                ));

        return assetCategoryMapper.toAssetCategoryResponse(assetCategory);
    }


    //--------------------------------------------
    // Delete By Id
    //--------------------------------------------

    @Override
    public void deleteById(Integer id) {
        AssetCategory assetCategory= assetCategoryRepository.findById(id)
                .orElseThrow(()->new ResponseStatusException(
                        HttpStatus.NOT_FOUND," Asset Category not found"
                ));
        assetCategoryRepository.delete(assetCategory);
    }


    //--------------------------------------------
    // Update By Id
    //--------------------------------------------

    @Override
    public AssetCategoryResponse updateById(Integer id, UpdateAssetCategoryRequest updateAssetCategoryRequest) {

        AssetCategory assetCategory= assetCategoryRepository.findById(id)
                .orElseThrow(()->new ResponseStatusException(
                        HttpStatus.NOT_FOUND," Asset Category not found"
                ));

        // Validate initial
        if(!updateAssetCategoryRequest.initial().equals(assetCategory.getInitial()))
            if( assetCategoryRepository.existsByInitial(updateAssetCategoryRequest.initial()))
                throw new ResponseStatusException(
                        HttpStatus.CONFLICT," Initial already exists"
                );


        // Validate asset category name en
        if(!updateAssetCategoryRequest.assetCategoryNameEn().equals(assetCategory.getAssetCategoryNameEn()))
            if( assetCategoryRepository.existsByAssetCategoryNameEn(updateAssetCategoryRequest.assetCategoryNameEn()))
                throw new ResponseStatusException(
                        HttpStatus.CONFLICT," Asset Category name en already exists"
                );

        // Validate asset category name kh
        if(!updateAssetCategoryRequest.assetCategoryNameKh().equals(assetCategory.getAssetCategoryNameKh()) )
            if( assetCategoryRepository.existsByAssetCategoryNameKh(updateAssetCategoryRequest.assetCategoryNameKh()))
                throw new ResponseStatusException(
                        HttpStatus.CONFLICT," Asset Category name kh already exists"
                );

        // Validate Asset group
        AssetGroup assetGroup= assetGroupRepository.findById(updateAssetCategoryRequest.assetGroupId())
                .orElseThrow(()->new ResponseStatusException(
                        HttpStatus.NOT_FOUND," Asset Group not found"
                ));


        assetCategoryMapper.fromUpdateAssetCategoryRequest(updateAssetCategoryRequest, assetCategory);
//        assetCategory.setAssetGroup(assetGroup);
        assetCategoryRepository.save(assetCategory);
        return assetCategoryMapper.toAssetCategoryResponse(assetCategory);
    }
}

