package ouyponlouer.site.fixedassetmanagementsystem.feature.assetSetting.assetCategory;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ouyponlouer.site.fixedassetmanagementsystem.feature.assetSetting.assetCategory.dto.AssetCategoryResponse;
import ouyponlouer.site.fixedassetmanagementsystem.feature.assetSetting.assetCategory.dto.CreateAssetCategoryRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/asset-categories")
public class AssetCategoryController {

    private final AssetCategoryService assetCategoryService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    AssetCategoryResponse createAssetCategory(@Valid @RequestBody CreateAssetCategoryRequest createAssetCategoryRequest) {
        return assetCategoryService.createAssetCategory(createAssetCategoryRequest);
    }
}
