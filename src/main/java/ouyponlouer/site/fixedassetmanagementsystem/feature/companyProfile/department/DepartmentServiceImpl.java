package ouyponlouer.site.fixedassetmanagementsystem.feature.companyProfile.department;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ouyponlouer.site.fixedassetmanagementsystem.domain.companyProfileDomain.Department;
import ouyponlouer.site.fixedassetmanagementsystem.feature.companyProfile.department.dto.CreateDepartmentRequest;
import ouyponlouer.site.fixedassetmanagementsystem.feature.companyProfile.department.dto.DepartmentDetailResponse;
import ouyponlouer.site.fixedassetmanagementsystem.feature.companyProfile.department.dto.UpdateDepartmentRequest;
import ouyponlouer.site.fixedassetmanagementsystem.mapper.companyProfileMapper.DepartmentMapper;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final DepartmentMapper departmentMapper;

    //-----------------------------------------------------
    // Create Department
    //-----------------------------------------------------

    @Override
    public DepartmentDetailResponse createDepartment(CreateDepartmentRequest createDepartmentRequest) {

        // Check Department name en
        if(departmentRepository.existsByNameEn(createDepartmentRequest.departmentNameEn()))
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,"Department Name En already exists"
            );

        // Check Department name en
        if(departmentRepository.existsByNameKh(createDepartmentRequest.departmentNameKh()))
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,"Department Name En already exists"
            );

        Department department= departmentMapper.fromDepartmentRequest(createDepartmentRequest);
        department.setCreateAt(LocalDate.now());
        departmentRepository.save(department);

        return departmentMapper.toDepartmentDetailResponse(department);
    }


    //-----------------------------------------------------
    // Get All Department
    //-----------------------------------------------------

    @Override
    public Page<DepartmentDetailResponse> getAllDepartment(int pageNo, int pageSize) {

        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        PageRequest pageRequest=PageRequest.of(pageNo-1,pageSize,sort);
        Page<Department> departmentPage=departmentRepository.findAll(pageRequest);

        return departmentPage.map(departmentMapper::toDepartmentDetailResponse);
    }


    //-----------------------------------------------------
    // Get Department By ID
    //-----------------------------------------------------

    @Override
    public DepartmentDetailResponse getDepartmentById(int id) {

        Department department=departmentRepository
                .findById(id)
                .orElseThrow(()->new ResponseStatusException
                        (HttpStatus.NOT_FOUND,"Department Not Found"));

        return departmentMapper.toDepartmentDetailResponse(department);
    }


    //-----------------------------------------------------
    // Get Department By ID
    //-----------------------------------------------------

    @Override
    public void deleteDepartmentById(int id) {

        Department department=departmentRepository
                .findById(id)
                .orElseThrow(()->new ResponseStatusException
                        (HttpStatus.NOT_FOUND,"Department Not Found"));

        departmentRepository.delete(department);
    }

    @Override
    public DepartmentDetailResponse updateDepartmentById(int id,UpdateDepartmentRequest updateDepartmentRequest) {
        Department department=departmentRepository
                .findById(id)
                .orElseThrow(()->new ResponseStatusException
                        (HttpStatus.NOT_FOUND,"Department Not Found"));

        // Check if name en already exist
        if(!updateDepartmentRequest.departmentNameEn().equals(department.getDepartmentNameEn()))
            if(departmentRepository.existsByNameEn(updateDepartmentRequest.departmentNameEn()))
                throw new ResponseStatusException(
                        HttpStatus.CONFLICT,"Department Name En already exists"
                );

        // Check if name en already exist
        if(!updateDepartmentRequest.departmentNameKh().equals(department.getDepartmentNameKh()))
            if(departmentRepository.existsByNameKh(updateDepartmentRequest.departmentNameKh()))
                throw new ResponseStatusException(
                        HttpStatus.CONFLICT,"Department Name Kh already exists"
                );

        departmentMapper.froUpdateDepartmentRequest(updateDepartmentRequest,department);
        department.setCreateAt(department.getCreateAt());
        departmentRepository.save(department);

        return departmentMapper.toDepartmentDetailResponse(department);
    }
}
