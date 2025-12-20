package ouyponlouer.site.fixedassetmanagementsystem.mapper.companyProfileMapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ouyponlouer.site.fixedassetmanagementsystem.domain.companyProfileDomain.Branch;
import ouyponlouer.site.fixedassetmanagementsystem.feature.companyProfile.branch.dto.BranchDetailResponse;
import ouyponlouer.site.fixedassetmanagementsystem.feature.companyProfile.branch.dto.BranchRequest;
import ouyponlouer.site.fixedassetmanagementsystem.feature.companyProfile.branch.dto.UpdateBranchRequest;

@Mapper(componentModel = "spring")
public interface BranchMapper {


    // Add
    Branch fromBranchRequest(BranchRequest branchRequest);

    // Get
    BranchDetailResponse toBranchDetailResponse(Branch branch);

    // Update
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)// if it has no value it will ignore
    void fromUpdateBranchRequest(UpdateBranchRequest updateBranchRequest, @MappingTarget Branch branch);  //@MappingTarget tells MapStruct to update the existing entity instead of creating a new one.
}
