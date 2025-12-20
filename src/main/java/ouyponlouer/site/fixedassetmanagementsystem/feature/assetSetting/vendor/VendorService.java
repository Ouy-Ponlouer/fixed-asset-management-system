package ouyponlouer.site.fixedassetmanagementsystem.feature.assetSetting.vendor;

import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import ouyponlouer.site.fixedassetmanagementsystem.feature.assetSetting.vendor.dto.CreateVendorRequest;
import ouyponlouer.site.fixedassetmanagementsystem.feature.assetSetting.vendor.dto.UpdateVendorRequest;
import ouyponlouer.site.fixedassetmanagementsystem.feature.assetSetting.vendor.dto.VendorResponse;

public interface VendorService {

   // Create
    VendorResponse createVendor(@Valid CreateVendorRequest createVendorRequest);

    // Get All
    Page<VendorResponse> getAllVendors(int pageNo, int pageSize);

    // Get By ID
    VendorResponse getById(Integer id);

    // Delete By ID
    void deleteById(Integer id);

    // Update By ID
    VendorResponse updateById(Integer id, @Valid UpdateVendorRequest updateVendorRequest);
}
