package ouyponlouer.site.fixedassetmanagementsystem.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ouyponlouer.site.fixedassetmanagementsystem.domain.assetSettingDomain.Condition;
import ouyponlouer.site.fixedassetmanagementsystem.feature.assetSetting.assetCondition.dto.ConditionResponse;
import ouyponlouer.site.fixedassetmanagementsystem.feature.assetSetting.assetCondition.dto.CreateConditionRequest;
import ouyponlouer.site.fixedassetmanagementsystem.feature.assetSetting.assetCondition.dto.UpdateConditionRequest;

@Mapper(componentModel = "spring")
public interface ConditionMapper {

    // Create
    Condition fromCreateConditionRequest (CreateConditionRequest createConditionRequest);

    // Response
    ConditionResponse toConditionResponse(Condition condition);

    //Update
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Condition fromUpdateConditionRequest(UpdateConditionRequest updateConditionRequest, @MappingTarget Condition condition);
}
