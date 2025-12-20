package ouyponlouer.site.fixedassetmanagementsystem.feature.assetSetting.assetCondition;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ouyponlouer.site.fixedassetmanagementsystem.feature.assetSetting.assetCondition.dto.ConditionResponse;
import ouyponlouer.site.fixedassetmanagementsystem.feature.assetSetting.assetCondition.dto.CreateConditionRequest;
import ouyponlouer.site.fixedassetmanagementsystem.feature.assetSetting.assetCondition.dto.UpdateConditionRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/conditions")
public class ConditionController {

    private final ConditionService conditionService;


    //--------------------------------------------
    // Create
    //--------------------------------------------

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    ConditionResponse create(@Valid @RequestBody CreateConditionRequest createConditionRequest){
        return conditionService.create(createConditionRequest);
    }


    //--------------------------------------------
    // Get All
    //--------------------------------------------

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    Page<ConditionResponse> getAll(@RequestParam(required = false,defaultValue = "1") int pageNo,
                                   @RequestParam (required = false,defaultValue = "25")int pageSize){
        return conditionService.getAll(pageNo,pageSize);
    }


    //--------------------------------------------
    // Get By ID
    //--------------------------------------------

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    ConditionResponse getById(@PathVariable Integer id){
        return conditionService.getById(id);
    }


    //--------------------------------------------
    // Delete
    //--------------------------------------------

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteById(@PathVariable Integer id){
        conditionService.deleteById(id);
    }


    //--------------------------------------------
    // Update By ID
    //--------------------------------------------

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    ConditionResponse updateById(@PathVariable Integer id, @Valid @RequestBody UpdateConditionRequest updateConditionRequest){
        return conditionService.updateById(id,updateConditionRequest);
    }
}
