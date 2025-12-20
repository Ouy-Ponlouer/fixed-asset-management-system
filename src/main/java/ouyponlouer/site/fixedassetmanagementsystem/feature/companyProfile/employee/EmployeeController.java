package ouyponlouer.site.fixedassetmanagementsystem.feature.companyProfile.employee;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ouyponlouer.site.fixedassetmanagementsystem.feature.companyProfile.employee.dto.CreateEmployeeRequest;
import ouyponlouer.site.fixedassetmanagementsystem.feature.companyProfile.employee.dto.EmployeeDetailResponse;
import ouyponlouer.site.fixedassetmanagementsystem.feature.companyProfile.employee.dto.UpdateEmployeeRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/employees")
public class EmployeeController {

    private final EmployeeService employeeService;


    //--------------------------------------------
    // Create
    //--------------------------------------------

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    EmployeeDetailResponse createEmployee(@Valid @RequestBody CreateEmployeeRequest createEmployeeRequest){
        return employeeService.createEmployee(createEmployeeRequest);
    }


    //--------------------------------------------
    // Get All
    //--------------------------------------------

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    Page<EmployeeDetailResponse> getAllEmployee(@RequestParam(required = false,defaultValue = "1")int pageNo,
                                                @RequestParam(required = false,defaultValue = "25")int pageSize){
        return employeeService.getAllEmployee(pageNo,pageSize);
    }


    //--------------------------------------------
    // Get By code
    //--------------------------------------------

    @GetMapping("/code/{code}")
    @ResponseStatus(HttpStatus.OK)
    EmployeeDetailResponse getEmployeeByCode(@PathVariable String code){
        return  employeeService.getEmployeeByCode(code);
    }



    //--------------------------------------------
    // Get By ID
    //--------------------------------------------

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    EmployeeDetailResponse getEmployeeById(@PathVariable Integer id){
        return  employeeService.getEmployeeById(id);
    }


    //--------------------------------------------
    // Delete
    //--------------------------------------------

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteEmployeeById(@PathVariable Integer id){
        employeeService.deleteById(id);
    }


    //--------------------------------------------
    // Update
    //--------------------------------------------

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    EmployeeDetailResponse updateById(@PathVariable Integer id, @Valid @RequestBody UpdateEmployeeRequest updateEmployeeRequest){
        return  employeeService.updateById(id,updateEmployeeRequest);
    }



}
