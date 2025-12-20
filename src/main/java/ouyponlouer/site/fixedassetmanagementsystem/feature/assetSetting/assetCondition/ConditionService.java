package ouyponlouer.site.fixedassetmanagementsystem.feature.assetSetting.assetCondition;

import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import ouyponlouer.site.fixedassetmanagementsystem.feature.assetSetting.assetCondition.dto.ConditionResponse;
import ouyponlouer.site.fixedassetmanagementsystem.feature.assetSetting.assetCondition.dto.CreateConditionRequest;
import ouyponlouer.site.fixedassetmanagementsystem.feature.assetSetting.assetCondition.dto.UpdateConditionRequest;

public interface ConditionService {

    // Create
    ConditionResponse create(@Valid CreateConditionRequest createConditionRequest);

    //Get All
    Page<ConditionResponse> getAll(int pageNo, int pageSize);

    // Get By ID
    ConditionResponse getById(Integer id);

    // Delete By ID
    void deleteById(Integer id);

    // Update By ID
    ConditionResponse updateById(Integer id, @Valid UpdateConditionRequest updateConditionRequest);
}
