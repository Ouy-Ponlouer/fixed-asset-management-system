package ouyponlouer.site.fixedassetmanagementsystem.feature.companyProfile.position;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ouyponlouer.site.fixedassetmanagementsystem.feature.companyProfile.position.dto.CreatePositionRequest;
import ouyponlouer.site.fixedassetmanagementsystem.feature.companyProfile.position.dto.PositionDetailResponse;
import ouyponlouer.site.fixedassetmanagementsystem.feature.companyProfile.position.dto.UpdatePositionRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/positions")
public class PositionController {

    private final PositionService positionService;


    //--------------------------------------------
    // Create
    //--------------------------------------------

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    PositionDetailResponse createPosition(@Valid @RequestBody CreatePositionRequest createPositionRequest) {
        return positionService.createPosition(createPositionRequest);
    }


    //--------------------------------------------
    // Get All
    //--------------------------------------------

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    Page<PositionDetailResponse> getAllPositions(@RequestParam (required = false,defaultValue ="1") int pageNo,
                                                 @RequestParam (required = false,defaultValue = "25")int pageSize) {
        return  positionService.getAllPosition(pageNo,pageSize);

    }


    //--------------------------------------------
    // Get By ID
    //--------------------------------------------

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    PositionDetailResponse getPosition(@PathVariable int id) {
        return positionService.getPositionById(id);
    }


    //--------------------------------------------
    // Delete
    //--------------------------------------------

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deletePosition(@PathVariable int id) {
        positionService.deletePosition(id);
    }


    //--------------------------------------------
    // Update
    //--------------------------------------------
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    PositionDetailResponse updatePosition(@PathVariable int id, @Valid @RequestBody UpdatePositionRequest updatePositionRequest) {
        return positionService.updatePositionById(id,updatePositionRequest);
    }

}
