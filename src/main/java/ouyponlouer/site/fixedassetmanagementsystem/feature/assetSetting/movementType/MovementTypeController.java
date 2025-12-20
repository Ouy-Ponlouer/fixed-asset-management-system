package ouyponlouer.site.fixedassetmanagementsystem.feature.assetSetting.movementType;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ouyponlouer.site.fixedassetmanagementsystem.feature.assetSetting.movementType.dto.CreateMovementTypeRequest;
import ouyponlouer.site.fixedassetmanagementsystem.feature.assetSetting.movementType.dto.MovementTypeResponse;
import ouyponlouer.site.fixedassetmanagementsystem.feature.assetSetting.movementType.dto.UpdateMovementTypeRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/movement-types")
public class MovementTypeController {

    private final MovementTypeService movementTypeService;


    //--------------------------------------------
    // Create
    //--------------------------------------------

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    MovementTypeResponse create(@Valid @RequestBody CreateMovementTypeRequest createMovementTypeRequest){
        return movementTypeService.create(createMovementTypeRequest);
    }


    //--------------------------------------------
    // Get All
    //--------------------------------------------

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    Page<MovementTypeResponse> getAll(@RequestParam (required = false, defaultValue = "1") int pageNo,
                                         @RequestParam (required = false, defaultValue = "25") int pageSize){
        return movementTypeService.getAll(pageNo,pageSize);
    }


    //--------------------------------------------
    // Get By ID
    //--------------------------------------------

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    MovementTypeResponse getById(@PathVariable Integer id) {
        return movementTypeService.getById(id);
    }


    //--------------------------------------------
    // Delete By ID
    //--------------------------------------------

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteById(@PathVariable Integer id){
        movementTypeService.deleteById(id);
    }


    //--------------------------------------------
    // Update By ID
    //--------------------------------------------

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    MovementTypeResponse updateById(@PathVariable Integer id,
                                    @Valid @RequestBody UpdateMovementTypeRequest updateMovementTypeRequest) {
        return movementTypeService.updateById(id, updateMovementTypeRequest);
    }

}
