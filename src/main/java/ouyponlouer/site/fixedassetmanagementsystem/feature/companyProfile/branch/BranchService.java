package ouyponlouer.site.fixedassetmanagementsystem.feature.companyProfile.branch;

import org.springframework.data.domain.Page;
import ouyponlouer.site.fixedassetmanagementsystem.feature.companyProfile.branch.dto.BranchDetailResponse;
import ouyponlouer.site.fixedassetmanagementsystem.feature.companyProfile.branch.dto.BranchRequest;
import ouyponlouer.site.fixedassetmanagementsystem.feature.companyProfile.branch.dto.UpdateBranchRequest;

public interface BranchService {

   // add new branch
    void addBranch(BranchRequest branchRequest);

    // Get All Branch
    Page<BranchDetailResponse> getAll(int pageNo, int pageSize);

    // Update Branch
    BranchDetailResponse updateBranchById(int id, UpdateBranchRequest updateBranchRequest);

    // Enable Branch
    void enableBranch(int id);

    // Disable Branch
    void disableBranch(int id);

    // Get Branch by Id
    BranchDetailResponse getBranchByid(Integer id);

    // Get Branch By Code
    BranchDetailResponse getBranchByCode(String code);
    // Delete By Id
    void deleteById(int id);
}
