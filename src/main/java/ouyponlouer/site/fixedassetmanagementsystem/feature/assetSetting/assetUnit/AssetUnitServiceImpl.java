package ouyponlouer.site.fixedassetmanagementsystem.feature.assetSetting.assetUnit;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ouyponlouer.site.fixedassetmanagementsystem.domain.assetSettingDomain.AssetUnit;
import ouyponlouer.site.fixedassetmanagementsystem.feature.assetSetting.assetUnit.dto.AssetUnitResponse;
import ouyponlouer.site.fixedassetmanagementsystem.feature.assetSetting.assetUnit.dto.CreateAssetUnitRequest;
import ouyponlouer.site.fixedassetmanagementsystem.feature.assetSetting.assetUnit.dto.UpdateAssetUnitRequest;
import ouyponlouer.site.fixedassetmanagementsystem.mapper.assetSettingMapper.AssetUnitMapper;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class AssetUnitServiceImpl implements AssetUnitService {
    private final AssetUnitRepository assetUnitRepository;
    private final AssetUnitMapper assetUnitMapper;


    //--------------------------------------------
    // Create
    //--------------------------------------------

    @Override
    public AssetUnitResponse createAssetUnit(CreateAssetUnitRequest createAssetUnitRequest) {

        if(assetUnitRepository.existsByAssetUnitNameEn(createAssetUnitRequest.assetUnitNameEn()))
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,"Asset Unit Name En already exist"
            );
        if(assetUnitRepository.existsByAssetUnitNameKh(createAssetUnitRequest.assetUnitNameKh()))
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,"Asset Unit Name Kh already exist"
            );

        AssetUnit assetUnit =assetUnitMapper.fromCreateAssetUnitRequest(createAssetUnitRequest);
        assetUnit.setCreateAt(LocalDate.now());

        return assetUnitMapper.toAssetUnitResponse(assetUnitRepository.save(assetUnit));
    }


    //--------------------------------------------
    // Get All
    //--------------------------------------------

    @Override
    public Page<AssetUnitResponse> getAllAssetUnit(int pageNo, int pageSize) {

        Sort sort = Sort.by(Sort.Direction.DESC,"id");
        PageRequest pageRequest=PageRequest.of(pageNo-1,pageSize,sort);
        Page<AssetUnit> assetUnitPage=assetUnitRepository.findAll(pageRequest);

        return assetUnitPage.map(assetUnitMapper::toAssetUnitResponse);
    }


    //--------------------------------------------
    // Get By Id
    //--------------------------------------------

    @Override
    public AssetUnitResponse getById(Integer id) {

        AssetUnit assetUnit=assetUnitRepository.findById(id).orElseThrow(
                ()->new ResponseStatusException(
                        HttpStatus.NOT_FOUND,"Asset Unit not found"
                )
        );

        return assetUnitMapper.toAssetUnitResponse(assetUnit);
    }


    //--------------------------------------------
    // Delete By Id
    //--------------------------------------------

    @Override
    public void deleteById(Integer id) {

        AssetUnit assetUnit=assetUnitRepository.findById(id).orElseThrow(
                ()->new ResponseStatusException(
                        HttpStatus.NOT_FOUND,"Asset Unit not found"
                )
        );

        assetUnitRepository.delete(assetUnit);
    }


    //--------------------------------------------
    // Update By Id
    //--------------------------------------------

    @Override
    public AssetUnitResponse updateById(Integer id, UpdateAssetUnitRequest updateAssetUnitRequest) {

        AssetUnit assetUnit=assetUnitRepository.findById(id).orElseThrow(
                ()->new ResponseStatusException(
                        HttpStatus.NOT_FOUND,"Asset Unit not found"
                )
        );

        // Validate Unique
        if(!assetUnit.getAssetUnitNameEn().equals(updateAssetUnitRequest.assetUnitNameEn()))
            if(assetUnitRepository.existsByAssetUnitNameEn(updateAssetUnitRequest.assetUnitNameEn()))
                throw new ResponseStatusException(
                        HttpStatus.CONFLICT,"Asset Unit Name En already exist"
                );

        // Validate Unique
        if(!assetUnit.getAssetUnitNameKh().equals(updateAssetUnitRequest.assetUnitNameKh()))
            if(assetUnitRepository.existsByAssetUnitNameKh(updateAssetUnitRequest.assetUnitNameKh()))
                throw new ResponseStatusException(
                        HttpStatus.CONFLICT,"Asset Unit Name Kh already exist"
                );

        assetUnit =assetUnitMapper.fromUpdateAssetUnitRequest(updateAssetUnitRequest,assetUnit);
        assetUnit.setCreateAt(assetUnit.getCreateAt());

        return assetUnitMapper.toAssetUnitResponse(assetUnitRepository.save(assetUnit));
    }


}
