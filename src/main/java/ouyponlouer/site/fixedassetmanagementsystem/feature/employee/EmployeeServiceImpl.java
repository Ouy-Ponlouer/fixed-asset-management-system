package ouyponlouer.site.fixedassetmanagementsystem.feature.employee;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ouyponlouer.site.fixedassetmanagementsystem.domain.companyProfileDomain.*;
import ouyponlouer.site.fixedassetmanagementsystem.feature.branch.BranchRepository;
import ouyponlouer.site.fixedassetmanagementsystem.feature.department.DepartmentRepository;
import ouyponlouer.site.fixedassetmanagementsystem.feature.employee.dto.CreateEmployeeRequest;
import ouyponlouer.site.fixedassetmanagementsystem.feature.employee.dto.EmployeeDetailResponse;
import ouyponlouer.site.fixedassetmanagementsystem.feature.employee.dto.UpdateEmployeeRequest;
import ouyponlouer.site.fixedassetmanagementsystem.feature.position.PositionRepository;
import ouyponlouer.site.fixedassetmanagementsystem.feature.position.dto.PositionDetailResponse;
import ouyponlouer.site.fixedassetmanagementsystem.feature.unit.UnitRepository;
import ouyponlouer.site.fixedassetmanagementsystem.mapper.EmployeeMapper;

import java.time.LocalDate;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;
    private final BranchRepository branchRepository;
    private final DepartmentRepository departmentRepository;
    private final PositionRepository positionRepository;
    private final UnitRepository unitRepository;



    //--------------------------------------------
    // Create
    //--------------------------------------------

    @Override
    public EmployeeDetailResponse createEmployee(CreateEmployeeRequest createEmployeeRequest) {

        // Validate branch
        Branch branch = branchRepository
                .findByBranchNameEn(createEmployeeRequest.branchName())
                .orElseThrow(()->new ResponseStatusException(
                        HttpStatus.NOT_FOUND,"Branch doesn't exist"
                ));


      // Validate Department
        Department department=departmentRepository
                .findByDepartmentNameEn(createEmployeeRequest.departmentName())
                .orElseThrow(()->new ResponseStatusException(
                        HttpStatus.NOT_FOUND,"Department doesn't exist"
                ));


        // Validate Position
        Position position=positionRepository
                .findByPositionNameEn(createEmployeeRequest.positionName())
                .orElseThrow(()->new ResponseStatusException(
                        HttpStatus.NOT_FOUND,"Position doesn't exist"
                ));


        //Validate Unit
        Unit unit=unitRepository
                .findByUnitNameEn(createEmployeeRequest.unitName())
                .orElseThrow(()->new ResponseStatusException(
                        HttpStatus.NOT_FOUND,"Unit doesn't exist"
                ));


        // Map request to entity
        Employee employee =employeeMapper.fromCreateEmployeeRequest(createEmployeeRequest);

        // Set relationships
        employee.setBranches(branch);
        employee.setDepartments(department);
        employee.setPositions(position);
        employee.setUnits(unit);
        employee.setCreateAt(LocalDate.now());
        employee.setCode(UUID.randomUUID().toString().substring(0, 8).toUpperCase());

        // First save: generates ID, code is still null (now allowed)
        Employee savedEmployee = employeeRepository.save(employee);

        // Now generate the real code using the generated ID
        savedEmployee.setCode(branch.getInitial() + "-" + savedEmployee.getId());

        // Second save: updates the code
        Employee finalEmployee = employeeRepository.save(savedEmployee);

        return employeeMapper.toEmployeeDetailResponse(finalEmployee);
    }


    //--------------------------------------------
    // Get
    //--------------------------------------------

    @Override
    public Page<EmployeeDetailResponse> getAllEmployee(int pageNo, int pageSize) {
        Sort sort=Sort.by(Sort.Direction.DESC,"id");
        PageRequest pageRequest=PageRequest.of(pageNo-1,pageSize,sort);
        Page<Employee> employeePage=employeeRepository.findAll(pageRequest);

        return employeePage.map(employeeMapper::toEmployeeDetailResponse);
    }


    //--------------------------------------------
    // Get By Code
    //--------------------------------------------

    @Override
    public EmployeeDetailResponse getEmployeeByCode(String code) {

        Employee employee=employeeRepository
                .findByCode(code)
                .orElseThrow(()->new ResponseStatusException(
                        HttpStatus.NOT_FOUND,"Employee doesn't exist"
                ));
        return employeeMapper.toEmployeeDetailResponse(employee);
    }


    //--------------------------------------------
    // Get By ID
    //--------------------------------------------

    @Override
    public EmployeeDetailResponse getEmployeeById(Integer id) {
        Employee employee=employeeRepository
                .findById(id)
                .orElseThrow(()->new ResponseStatusException(
                        HttpStatus.NOT_FOUND,"Employee doesn't exist"
                ));
        return employeeMapper.toEmployeeDetailResponse(employee);
    }


    //--------------------------------------------
    // Delete
    //--------------------------------------------

    @Override
    public void deleteById(Integer id) {
        Employee employee=employeeRepository
                .findById(id)
                .orElseThrow(()->new ResponseStatusException(
                        HttpStatus.NOT_FOUND,"Employee doesn't exist"
                ));
        employeeRepository.delete(employee);
    }


    //--------------------------------------------
    // Update
    //--------------------------------------------

    @Override
    public EmployeeDetailResponse updateById(Integer id, UpdateEmployeeRequest updateEmployeeRequest) {

        // Validate Employee
        Employee employee=employeeRepository
                .findById(id)
                .orElseThrow(()->new ResponseStatusException(
                        HttpStatus.NOT_FOUND,"Employee doesn't exist"
                ));


        // Validate branch
        Branch branch = branchRepository
                .findByBranchNameEn(updateEmployeeRequest.branchName())
                .orElseThrow(()->new ResponseStatusException(
                        HttpStatus.NOT_FOUND,"Branch doesn't exist"
                ));


        // Validate Department
        Department department=departmentRepository
                .findByDepartmentNameEn(updateEmployeeRequest.departmentName())
                .orElseThrow(()->new ResponseStatusException(
                        HttpStatus.NOT_FOUND,"Department doesn't exist"
                ));


        // Validate Position
        Position position=positionRepository
                .findByPositionNameEn(updateEmployeeRequest.positionName())
                .orElseThrow(()->new ResponseStatusException(
                        HttpStatus.NOT_FOUND,"Position doesn't exist"
                ));


        //Validate Unit
        Unit unit=unitRepository
                .findByUnitNameEn(updateEmployeeRequest.unitName())
                .orElseThrow(()->new ResponseStatusException(
                        HttpStatus.NOT_FOUND,"Unit doesn't exist"
                ));

        employee=employeeMapper.fromUpdateEmployeeRequest(updateEmployeeRequest,employee);

        // Set relationships
        employee.setBranches(branch);
        employee.setDepartments(department);
        employee.setPositions(position);
        employee.setUnits(unit);
        employee.setCreateAt(employee.getCreateAt());
        employee.setCode(employee.getCode());

        employeeRepository.save(employee);

        return employeeMapper.toEmployeeDetailResponse(employee);
    }
}
