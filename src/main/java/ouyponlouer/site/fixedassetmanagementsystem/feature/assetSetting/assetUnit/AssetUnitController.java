package ouyponlouer.site.fixedassetmanagementsystem.feature.assetSetting.assetUnit;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ouyponlouer.site.fixedassetmanagementsystem.feature.assetSetting.assetUnit.dto.AssetUnitResponse;
import ouyponlouer.site.fixedassetmanagementsystem.feature.assetSetting.assetUnit.dto.CreateAssetUnitRequest;
import ouyponlouer.site.fixedassetmanagementsystem.feature.assetSetting.assetUnit.dto.UpdateAssetUnitRequest;
import ouyponlouer.site.fixedassetmanagementsystem.feature.companyProfile.unit.dto.CreateUnitRequest;
import ouyponlouer.site.fixedassetmanagementsystem.feature.companyProfile.unit.dto.UnitDetailResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/asset-units")
public class AssetUnitController {
    private final AssetUnitService assetUnitService;



    //--------------------------------------------
    // Create
    //--------------------------------------------

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    AssetUnitResponse createAssetUnit(@Valid @RequestBody CreateAssetUnitRequest createAssetUnitRequest){
        return assetUnitService.createAssetUnit(createAssetUnitRequest);
    }


    //--------------------------------------------
    // Get All
    //--------------------------------------------

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    Page<AssetUnitResponse> getAllAssetUnit(@RequestParam(required = false,defaultValue = "1") int pageNo,
                                       @RequestParam (required = false,defaultValue = "25")int pageSize){
        return assetUnitService.getAllAssetUnit(pageNo,pageSize);
    }


    //--------------------------------------------
    // Get By ID
    //--------------------------------------------

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    AssetUnitResponse getById(@PathVariable Integer id) {
        return assetUnitService.getById(id);
    }


    //--------------------------------------------
    // Delete
    //--------------------------------------------

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteById(@PathVariable Integer id){
        assetUnitService.deleteById(id);
    }


    //--------------------------------------------
    // Update
    //--------------------------------------------

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    AssetUnitResponse updateById(@PathVariable Integer id, @Valid @RequestBody UpdateAssetUnitRequest updateAssetUnitRequest){
        return assetUnitService.updateById(id,updateAssetUnitRequest);
    }

}
