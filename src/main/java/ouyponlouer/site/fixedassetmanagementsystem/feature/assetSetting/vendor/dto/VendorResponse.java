package ouyponlouer.site.fixedassetmanagementsystem.feature.assetSetting.vendor.dto;

public record VendorResponse(
        Integer id,
        String vendorNameEn,
        String vendorNameKh,
        String address,
        String phoneNumber,
        String email
) {
}
