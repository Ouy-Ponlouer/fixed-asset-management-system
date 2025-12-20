package ouyponlouer.site.fixedassetmanagementsystem.mapper.assetSettingMapper;

import org.mapstruct.*;
import ouyponlouer.site.fixedassetmanagementsystem.domain.assetSettingDomain.Vendor;
import ouyponlouer.site.fixedassetmanagementsystem.feature.assetSetting.vendor.dto.CreateVendorRequest;
import ouyponlouer.site.fixedassetmanagementsystem.feature.assetSetting.vendor.dto.UpdateVendorRequest;
import ouyponlouer.site.fixedassetmanagementsystem.feature.assetSetting.vendor.dto.VendorResponse;

@Mapper(componentModel = "spring")
public interface VendorMapper {

    // Create
    Vendor fromCreateVendorRequest(CreateVendorRequest createVendorRequest);

    // Response
    VendorResponse toVendorResponse(Vendor vendor);

    // Update
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Vendor fromUpdateVendorRequest(UpdateVendorRequest updateVendorRequest, @MappingTarget Vendor vendor);

}
