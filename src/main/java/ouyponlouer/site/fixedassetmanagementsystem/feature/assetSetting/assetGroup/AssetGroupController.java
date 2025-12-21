package ouyponlouer.site.fixedassetmanagementsystem.feature.assetSetting.assetGroup;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ouyponlouer.site.fixedassetmanagementsystem.feature.assetSetting.assetGroup.dto.AssetGroupResponse;
import ouyponlouer.site.fixedassetmanagementsystem.feature.assetSetting.assetGroup.dto.CreateAssetGroupRequest;
import ouyponlouer.site.fixedassetmanagementsystem.feature.assetSetting.assetGroup.dto.UpdateAssetGroupRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/asset-groups")
public class AssetGroupController {
    private final AssetGroupService assetGroupService;


    //--------------------------------------------
    // Create
    //--------------------------------------------

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    AssetGroupResponse createAssetGroup(@Valid @RequestBody CreateAssetGroupRequest createAssetGroupRequest){
        return assetGroupService.createAssetGroup(createAssetGroupRequest);
    }


    //--------------------------------------------
    // Delete
    //--------------------------------------------

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    void deleteById(@PathVariable Integer id) {
        assetGroupService.deleteById(id);
    }


    //--------------------------------------------
    // Get By ID
    //--------------------------------------------

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    AssetGroupResponse getById(@PathVariable Integer id) {
        return assetGroupService.getById(id);
    }


    //--------------------------------------------
    // Get all
    //--------------------------------------------

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    Page<AssetGroupResponse> getAll(@RequestParam (required = false,defaultValue = "1") int pageNo,
                                    @RequestParam (required = false,defaultValue = "25") int pageSize){
        return assetGroupService.getAll(pageNo,pageSize);
    }


    //--------------------------------------------
    // Update
    //--------------------------------------------

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    AssetGroupResponse updateById(@PathVariable Integer id, @Valid @RequestBody UpdateAssetGroupRequest updateAssetGroupRequest){
        return assetGroupService.updateById(id,updateAssetGroupRequest);
    }

}
