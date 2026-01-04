package ouyponlouer.site.fixedassetmanagementsystem.feature.assetSetting.assetCategory;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ouyponlouer.site.fixedassetmanagementsystem.feature.assetSetting.assetCategory.dto.AssetCategoryResponse;
import ouyponlouer.site.fixedassetmanagementsystem.feature.assetSetting.assetCategory.dto.CreateAssetCategoryRequest;
import ouyponlouer.site.fixedassetmanagementsystem.feature.assetSetting.assetCategory.dto.UpdateAssetCategoryRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/asset-categories")
public class AssetCategoryController {

    private final AssetCategoryService assetCategoryService;



    //--------------------------------------------
    // Create
    //--------------------------------------------

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    AssetCategoryResponse createAssetCategory(@Valid @RequestBody CreateAssetCategoryRequest createAssetCategoryRequest) {
        return assetCategoryService.createAssetCategory(createAssetCategoryRequest);
    }



    //--------------------------------------------
    // Get
    //--------------------------------------------

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    Page<AssetCategoryResponse> getAll( @RequestParam(required = false,defaultValue ="1")int pageNo,
                                        @RequestParam(required = false,defaultValue = "25") int pageSize){
        return assetCategoryService.getAll( pageNo, pageSize);
    }


    //--------------------------------------------
    // Get By ID
    //--------------------------------------------

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    AssetCategoryResponse getById(@PathVariable Integer id){
        return assetCategoryService.getById(id);
    }


    //--------------------------------------------
    // Get By Code
    //--------------------------------------------

    @GetMapping("code/{code}")
    @ResponseStatus(HttpStatus.OK)
    AssetCategoryResponse getById(@PathVariable String code){
        return assetCategoryService.getByCode(code);
    }



    //--------------------------------------------
    // Delete
    //--------------------------------------------

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteById(@PathVariable Integer id){
        assetCategoryService.deleteById(id);
    }


    //--------------------------------------------
    // Edit
    //--------------------------------------------

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    AssetCategoryResponse updateById(@PathVariable Integer id,
                                      @Valid @RequestBody UpdateAssetCategoryRequest updateAssetCategoryRequest){
        return assetCategoryService.updateById(id, updateAssetCategoryRequest);

    }
}
