package ouyponlouer.site.fixedassetmanagementsystem.feature.unit;

import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import ouyponlouer.site.fixedassetmanagementsystem.feature.unit.dto.CreateUnitRequest;
import ouyponlouer.site.fixedassetmanagementsystem.feature.unit.dto.UnitDetailResponse;
import ouyponlouer.site.fixedassetmanagementsystem.feature.unit.dto.UpdateUnitRequest;

public interface UnitService {

    // create
    UnitDetailResponse createUnit( CreateUnitRequest createUnitRequest);

    // Get all
    Page<UnitDetailResponse> getAllUnit(int pageNo, int pageSize);

    // Get Unit By Id
    UnitDetailResponse getUnitById(int id);

    // Delete
    void deleteUnitById(int id);

    // Update
    UnitDetailResponse updateUnitById(int id, @Valid UpdateUnitRequest updateUnitRequest);
}
