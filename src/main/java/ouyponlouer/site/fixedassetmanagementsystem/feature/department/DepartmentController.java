package ouyponlouer.site.fixedassetmanagementsystem.feature.department;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ouyponlouer.site.fixedassetmanagementsystem.domain.Department;
import ouyponlouer.site.fixedassetmanagementsystem.feature.department.dto.CreateDepartmentRequest;
import ouyponlouer.site.fixedassetmanagementsystem.feature.department.dto.DepartmentDetailResponse;
import ouyponlouer.site.fixedassetmanagementsystem.feature.department.dto.UpdateDepartmentRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/departments")
public class DepartmentController {

    private final DepartmentService departmentService;


    //------------------------------------------------
    // Create Department
    //------------------------------------------------

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    DepartmentDetailResponse createDepartment(@Valid @RequestBody CreateDepartmentRequest createDepartmentRequest) {
       return departmentService.createDepartment(createDepartmentRequest);

    }


    //------------------------------------------------
    // Get
    //------------------------------------------------

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    Page<DepartmentDetailResponse> getAllDepartment(@RequestParam (required = false,defaultValue = "1")int pageNo,
                                                    @RequestParam(required = false,defaultValue = "25")int pageSize) {

        return departmentService.getAllDepartment(pageNo,pageSize);
    }


    //------------------------------------------------
    // Get By ID
    //------------------------------------------------

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    DepartmentDetailResponse getDepartmentById(@PathVariable int id) {
        return departmentService.getDepartmentById(id);
    }


    //------------------------------------------------
    // Delete
    //------------------------------------------------

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteDepartmentById(@PathVariable int id) {
        departmentService.deleteDepartmentById(id);
    }


    //------------------------------------------------
    // Update
    //------------------------------------------------

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    DepartmentDetailResponse updateDepartmentById(@PathVariable int id,@Valid @RequestBody UpdateDepartmentRequest updateDepartmentRequest) {
        return departmentService.updateDepartmentById(id,updateDepartmentRequest);
    }



}
