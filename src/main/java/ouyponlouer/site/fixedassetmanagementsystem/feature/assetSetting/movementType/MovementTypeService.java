package ouyponlouer.site.fixedassetmanagementsystem.feature.assetSetting.movementType;

import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import ouyponlouer.site.fixedassetmanagementsystem.feature.assetSetting.movementType.dto.CreateMovementTypeRequest;
import ouyponlouer.site.fixedassetmanagementsystem.feature.assetSetting.movementType.dto.MovementTypeResponse;
import ouyponlouer.site.fixedassetmanagementsystem.feature.assetSetting.movementType.dto.UpdateMovementTypeRequest;

public interface MovementTypeService {

    // Create
    MovementTypeResponse create(@Valid CreateMovementTypeRequest createMovementTypeRequest);

    // Get All
    Page<MovementTypeResponse> getAll(int pageNo, int pageSize);

    // Get By ID
    MovementTypeResponse getById(Integer id);

    // Delete By ID
    void deleteById(Integer id);

    // Update By ID
    MovementTypeResponse updateById(Integer id, @Valid UpdateMovementTypeRequest updateMovementTypeRequest);
}
