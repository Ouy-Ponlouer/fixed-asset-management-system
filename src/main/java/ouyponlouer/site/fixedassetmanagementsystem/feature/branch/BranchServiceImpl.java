package ouyponlouer.site.fixedassetmanagementsystem.feature.branch;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ouyponlouer.site.fixedassetmanagementsystem.domain.Branch;
import ouyponlouer.site.fixedassetmanagementsystem.feature.branch.dto.BranchDetailResponse;
import ouyponlouer.site.fixedassetmanagementsystem.feature.branch.dto.BranchRequest;
import ouyponlouer.site.fixedassetmanagementsystem.feature.branch.dto.UpdateBranchRequest;
import ouyponlouer.site.fixedassetmanagementsystem.mapper.BranchMapper;
@Service
@RequiredArgsConstructor
public class BranchServiceImpl implements BranchService {

    private final BranchRepository branchRepository;
    private final BranchMapper branchMapper;


    //--------------------------------------------------------//
    //----================== Add Branch ================------//
    //--------------------------------------------------------//

    @Override
    public void addBranch(BranchRequest branchRequest) {

        // Validate Branch code
        if(branchRepository.existsByBranchCode(branchRequest.branchCode()))
            throw new ResponseStatusException(HttpStatus.CONFLICT,"Branch code already exists");

        // Validate name kh
        if(branchRepository.existsByBranchNameKh(branchRequest.branchNameKh()))
            throw new ResponseStatusException(HttpStatus.CONFLICT,"Branch name Kh already exists");

        // Validate name en
        if(branchRepository.existsByBranchNameEn(branchRequest.branchNameEn()))
            throw new ResponseStatusException(HttpStatus.CONFLICT,"Branch name en already exists");


        // Validate email
        if(branchRepository.existsByEmail(branchRequest.email()))
            throw new ResponseStatusException(HttpStatus.CONFLICT,"Email already exists");

//         Validate Phone number
        if(branchRepository.existsByPhoneNumber(branchRequest.phoneNumber()))
            throw new ResponseStatusException(HttpStatus.CONFLICT,"Phone number already exists");

        Branch branch = branchMapper.fromBranchRequest(branchRequest);
        branch.setIsActive(false);
//        branch.setStartDate(Lo);

        branchRepository.save(branch);

    }


    //--------------------------------------------------------//
    //----================ Get All Branch ===============-----//
    //--------------------------------------------------------//

    @Override
    public Page<BranchDetailResponse> getAll(int pageNo, int pageSize) {

        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        PageRequest pageRequest=PageRequest.of(pageNo-1,pageSize,sort);
        Page<Branch> branchPage = branchRepository.findAll(pageRequest);

        return branchPage.map(branchMapper::toBranchDetailResponse);
    }


    //--------------------------------------------------------//
    //----================= Update ======================-----//
    //--------------------------------------------------------//

    @Override
    public BranchDetailResponse updateBranchById(int id, UpdateBranchRequest updateBranchRequest) {

        Branch branch=branchRepository
                .findById(id)
                .orElseThrow(()->new ResponseStatusException
                        (HttpStatus.NOT_FOUND,"Branch doesn't exist"));


        // check if new branch code is difference from current one
        if(!updateBranchRequest.branchCode().equals(branch.getBranchCode()))
            if(branchRepository.existsByBranchCode(updateBranchRequest.branchCode())) // check branch code exist in other or not
                throw new ResponseStatusException(HttpStatus.CONFLICT,"Branch code already exists");


        // check if new branch name kh is difference from current one
        if(!updateBranchRequest.branchNameKh().equals(branch.getBranchNameKh()))
            if(branchRepository.existsByBranchNameKh(updateBranchRequest.branchNameKh())) // check branch name kh exist in other or not
                throw new ResponseStatusException(HttpStatus.CONFLICT,"Branch name Kh already exists");


        // check if new branch name en is difference from current one
        if(!updateBranchRequest.branchNameEn().equals(branch.getBranchNameEn()))
            if(branchRepository.existsByBranchNameEn(updateBranchRequest.branchNameEn())) // check branch name en exist in other or not
                throw new ResponseStatusException(HttpStatus.CONFLICT,"Branch name en already exists");


        // check if new  email is difference from current one
        if(!updateBranchRequest.email().equals(branch.getEmail()))
            if(branchRepository.existsByEmail(updateBranchRequest.email())) // check email exist in other or not
                throw new ResponseStatusException(HttpStatus.CONFLICT,"Email already exists");

        // check if new Phone Number is difference from current one
        if(!updateBranchRequest.phoneNumber().equals(branch.getPhoneNumber()))
            if(branchRepository.existsByPhoneNumber(updateBranchRequest.phoneNumber())) // check Phone number exist in other or not
                throw new ResponseStatusException(HttpStatus.CONFLICT,"Phone number already exists");


        branchMapper.fromUpdateBranchRequest(updateBranchRequest,branch);
        branch.setIsActive(false);
        branchRepository.save(branch);

        return branchMapper.toBranchDetailResponse(branch);
    }


    //--------------------------------------------------------//
    //----================= Enable Branch ===============----//
    //--------------------------------------------------------//

    @Override
    public void enableBranch(int id) {
        Branch branch=branchRepository
                .findById(id)
                .orElseThrow(()->new ResponseStatusException
                        (HttpStatus.NOT_FOUND," Branch doesn't exist"));

        branch.setIsActive(true);
        branchRepository.save(branch);
    }


    //--------------------------------------------------------//
    //----================= Disable Branch ===============----//
    //--------------------------------------------------------//

    @Override
    public void disableBranch(int id) {
        Branch branch=branchRepository
                .findById(id)
                .orElseThrow(()->new ResponseStatusException
                        (HttpStatus.NOT_FOUND," Branch doesn't exist"));

        branch.setIsActive(false);
        branchRepository.save(branch);

    }


    //--------------------------------------------------------//
    //----================= Get Branch By Id =============----//
    //--------------------------------------------------------//

    @Override
    public BranchDetailResponse getBranchByid(int id) {
        Branch branch=branchRepository
                .findById(id)
                .orElseThrow(()->new ResponseStatusException
                        (HttpStatus.NOT_FOUND," Branch doesn't exist"));

        return branchMapper.toBranchDetailResponse(branch);
    }


    //--------------------------------------------------------//
    //----=============== Get Branch By Code =============----//
    //--------------------------------------------------------//

    @Override
    public BranchDetailResponse getBranchByCode(String code) {

        Branch branch=branchRepository
                .findByBranchCode(code)
                .orElseThrow(()->new ResponseStatusException(
                        HttpStatus.NOT_FOUND," Branch doesn't exist"
                ));

        return branchMapper.toBranchDetailResponse(branch);
    }


    //--------------------------------------------------------//
    //----=============== Get Branch By Code =============----//
    //--------------------------------------------------------//

    @Override
    public void deleteById(int id) {
        Branch branch=branchRepository
                .findById(id)
                .orElseThrow(()->new ResponseStatusException
                        (HttpStatus.NOT_FOUND," Branch doesn't exist"));

        branchRepository.delete(branch);
    }
}
