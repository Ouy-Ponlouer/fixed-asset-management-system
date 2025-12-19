package ouyponlouer.site.fixedassetmanagementsystem.feature.unit;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ouyponlouer.site.fixedassetmanagementsystem.feature.unit.dto.CreateUnitRequest;
import ouyponlouer.site.fixedassetmanagementsystem.feature.unit.dto.UnitDetailResponse;
import ouyponlouer.site.fixedassetmanagementsystem.feature.unit.dto.UpdateUnitRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/units")
public class UnitController {

    private final UnitService unitService;


    //--------------------------------------------
    // Create
    //--------------------------------------------

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    UnitDetailResponse createUnit(@Valid @RequestBody CreateUnitRequest createUnitRequest){
        return unitService.createUnit(createUnitRequest);
    }


    //--------------------------------------------
    // Get all
    //--------------------------------------------

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    Page<UnitDetailResponse> getAllUnit(@RequestParam (required = false,defaultValue = "1")int pageNo,
                    @RequestParam(required = false,defaultValue = "25")int pageSize){
        return unitService.getAllUnit(pageNo,pageSize);
    }


    //--------------------------------------------
    // Get by id
    //--------------------------------------------

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    UnitDetailResponse getUnitById(@PathVariable int id){
        return unitService.getUnitById(id);
    }


    //--------------------------------------------
    // Delete
    //--------------------------------------------

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteUnitById(@PathVariable int id){
        unitService.deleteUnitById(id);
    }


    //--------------------------------------------
    // Update
    //--------------------------------------------

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    UnitDetailResponse updateUnitById(@PathVariable int id, @Valid @RequestBody UpdateUnitRequest updateUnitRequest){
        return unitService.updateUnitById(id,updateUnitRequest);
    }

}
