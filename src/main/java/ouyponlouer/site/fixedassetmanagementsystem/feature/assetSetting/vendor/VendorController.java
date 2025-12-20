package ouyponlouer.site.fixedassetmanagementsystem.feature.assetSetting.vendor;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ouyponlouer.site.fixedassetmanagementsystem.feature.assetSetting.vendor.dto.CreateVendorRequest;
import ouyponlouer.site.fixedassetmanagementsystem.feature.assetSetting.vendor.dto.UpdateVendorRequest;
import ouyponlouer.site.fixedassetmanagementsystem.feature.assetSetting.vendor.dto.VendorResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/vendors")
public class VendorController {

    private final VendorService vendorService;


    //--------------------------------------------
    // Create
    //--------------------------------------------

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    VendorResponse createVendor(@Valid @RequestBody CreateVendorRequest createVendorRequest){
        return vendorService.createVendor(createVendorRequest);
    }


    //--------------------------------------------
    // Get All
    //--------------------------------------------

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    Page<VendorResponse> getAllVendors(@RequestParam(required = false,defaultValue = "1") int pageNo,
                                       @RequestParam (required = false,defaultValue = "25")int pageSize){
        return vendorService.getAllVendors(pageNo,pageSize);
    }


    //--------------------------------------------
    // Get By ID
    //--------------------------------------------

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    VendorResponse getById(@PathVariable Integer id) {
        return vendorService.getById(id);
    }


    //--------------------------------------------
    // Delete
    //--------------------------------------------

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteById(@PathVariable Integer id){
        vendorService.deleteById(id);
    }


    //--------------------------------------------
    // Update
    //--------------------------------------------
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    VendorResponse updateById(@PathVariable Integer id, @Valid @RequestBody UpdateVendorRequest updateVendorRequest){
        return vendorService.updateById(id,updateVendorRequest);
    }

}
