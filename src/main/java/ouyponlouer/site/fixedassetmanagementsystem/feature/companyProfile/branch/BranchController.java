package ouyponlouer.site.fixedassetmanagementsystem.feature.companyProfile.branch;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ouyponlouer.site.fixedassetmanagementsystem.feature.companyProfile.branch.dto.BranchRequest;
import ouyponlouer.site.fixedassetmanagementsystem.feature.companyProfile.branch.dto.BranchDetailResponse;
import ouyponlouer.site.fixedassetmanagementsystem.feature.companyProfile.branch.dto.UpdateBranchRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/branches")
public class BranchController {

    private final BranchService branchService;


    //----=============== Add Branch =============----//
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    void addBranch(@Valid @RequestBody BranchRequest branchRequest) {
        branchService.addBranch(branchRequest);
    }


    //----=============== Get Branch ===============----//

    @GetMapping
    Page<BranchDetailResponse> getAll(@RequestParam(required = false,defaultValue = "1") int pageNo,
                                      @RequestParam (required = false,defaultValue = "25")int pageSize) {

        return branchService.getAll(pageNo,pageSize);
    }


    //-----=============== Edit Branch ============-----//

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    BranchDetailResponse updateBranchById( @PathVariable int id, @Valid @RequestBody UpdateBranchRequest updateBranchRequest) {
        return branchService.updateBranchById(id,updateBranchRequest);
    }


    //----============== Enable Branch =============-----///

    @PutMapping("/{id}/enable")
    @ResponseStatus(HttpStatus.OK)
    public void enableBranchById(@PathVariable int id) {
        branchService.enableBranch(id);
    }


    //----============== Disable Branch =============-----//

    @PutMapping("/{id}/disable")
    @ResponseStatus(HttpStatus.OK)
    public void disableBranchById(@PathVariable int id) {
        branchService.disableBranch(id);
    }


    //----============== Find By Id =============-----//
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    BranchDetailResponse findBranchById(@PathVariable int id) {
        return branchService.getBranchByid(id);
    }


    //----============== Find By Code =============-----//

    @GetMapping("/code/{code}")
    @ResponseStatus(HttpStatus.OK)
    BranchDetailResponse findBranchByCode(@PathVariable String code) {
        return branchService.getBranchByCode(code);
    }


    //----============= Delete Branch ============-------//
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBranchById(@PathVariable int id) {
        branchService.deleteById(id);
    }

}