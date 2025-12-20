package ouyponlouer.site.fixedassetmanagementsystem.feature.assetSetting.vendor;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ouyponlouer.site.fixedassetmanagementsystem.domain.assetSettingDomain.Vendor;
import ouyponlouer.site.fixedassetmanagementsystem.feature.assetSetting.vendor.dto.CreateVendorRequest;
import ouyponlouer.site.fixedassetmanagementsystem.feature.assetSetting.vendor.dto.UpdateVendorRequest;
import ouyponlouer.site.fixedassetmanagementsystem.feature.assetSetting.vendor.dto.VendorResponse;
import ouyponlouer.site.fixedassetmanagementsystem.mapper.assetSettingMapper.VendorMapper;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class VendorServiceImpl implements VendorService {

    private final VendorRepository vendorRepository;
    private final VendorMapper vendorMapper;


    //--------------------------------------------
    // Create
    //--------------------------------------------

    @Override
    public VendorResponse createVendor(CreateVendorRequest createVendorRequest) {

        // Validate Email
        if(vendorRepository.existsByEmail(createVendorRequest.email()))
            throw new ResponseStatusException(HttpStatus.CONFLICT,"Vendor Email already exist");

        // Validate Phone Number
        if(vendorRepository.existsBYPhoneNumber(createVendorRequest.phoneNumber()))
            throw new ResponseStatusException(HttpStatus.CONFLICT,"Vendor Phone Number already exist");

        // Create Vendor
        Vendor vendor=vendorMapper.fromCreateVendorRequest(createVendorRequest);
        vendor.setCreateAt(LocalDate.now());
        vendorRepository.save(vendor);

        return vendorMapper.toVendorResponse(vendor);
    }


    //--------------------------------------------
    // Get All
    //--------------------------------------------

    @Override
    public Page<VendorResponse> getAllVendors(int pageNo, int pageSize) {
        Sort sort=Sort.by(Sort.Direction.DESC,"id");
        PageRequest pageRequest=PageRequest.of(pageNo-1,pageSize,sort);
        Page<Vendor> vendorPage=vendorRepository.findAll(pageRequest);

        return vendorPage.map( vendorMapper::toVendorResponse );
    }


    //--------------------------------------------
    // Get By ID
    //--------------------------------------------

    @Override
    public VendorResponse getById(Integer id) {
        Vendor vendor=vendorRepository.findById(id)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Vendor not found"));
        return vendorMapper.toVendorResponse(vendor);
    }


    //--------------------------------------------
    // Delete By ID
    //--------------------------------------------

    @Override
    public void deleteById(Integer id) {
        Vendor vendor=vendorRepository.findById(id)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Vendor not found"));
        vendorRepository.delete(vendor);
    }


    //--------------------------------------------
    // Update By ID
    //--------------------------------------------

    @Override
    public VendorResponse updateById(Integer id, UpdateVendorRequest updateVendorRequest) {
        Vendor vendor = vendorRepository.findById(id)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Vendor not found"));

        // Validate Email
        if(!vendor.getEmail().equals(updateVendorRequest.email()))
            if(vendorRepository.existsByEmail(updateVendorRequest.email()))
                throw new ResponseStatusException(HttpStatus.CONFLICT,"Vendor Email already exist");

        // Validate Phone Number
        if(!vendor.getPhoneNumber().equals(updateVendorRequest.phoneNumber()))
            if(vendorRepository.existsBYPhoneNumber(updateVendorRequest.phoneNumber()))
                throw new ResponseStatusException(HttpStatus.CONFLICT,"Vendor Phone Number already exist");

        // Update Vendor
        vendorMapper.fromUpdateVendorRequest(updateVendorRequest, vendor);
        vendor.setCreateAt(vendor.getCreateAt());
        vendorRepository.save(vendor);

        return vendorMapper.toVendorResponse(vendor);
    }
}
