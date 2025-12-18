package ouyponlouer.site.fixedassetmanagementsystem.feature.position;

import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import ouyponlouer.site.fixedassetmanagementsystem.feature.department.dto.CreateDepartmentRequest;
import ouyponlouer.site.fixedassetmanagementsystem.feature.position.dto.CreatePositionRequest;
import ouyponlouer.site.fixedassetmanagementsystem.feature.position.dto.PositionDetailResponse;
import ouyponlouer.site.fixedassetmanagementsystem.feature.position.dto.UpdatePositionRequest;

public interface PositionService {


    // Create
    PositionDetailResponse createPosition(CreatePositionRequest createPositionRequest);

    // Get All
    Page<PositionDetailResponse> getAllPosition(int pageNo, int pageSize);

    // Get By Id
    PositionDetailResponse getPositionById(int id);

    // Delete
    void deletePosition(int id);

    // Update
    PositionDetailResponse updatePositionById(int id,UpdatePositionRequest updatePositionRequest);
}
