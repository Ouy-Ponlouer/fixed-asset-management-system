package ouyponlouer.site.fixedassetmanagementsystem.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ouyponlouer.site.fixedassetmanagementsystem.domain.assetSettingDomain.MovementType;
import ouyponlouer.site.fixedassetmanagementsystem.domain.companyProfileDomain.Position;
import ouyponlouer.site.fixedassetmanagementsystem.feature.assetSetting.movementType.dto.CreateMovementTypeRequest;
import ouyponlouer.site.fixedassetmanagementsystem.feature.assetSetting.movementType.dto.MovementTypeResponse;
import ouyponlouer.site.fixedassetmanagementsystem.feature.assetSetting.movementType.dto.UpdateMovementTypeRequest;


@Mapper(componentModel = "spring")
public interface MovementTypeMapper {

    MovementType fromCreateMovementTypeRequest(CreateMovementTypeRequest createMovementTypeRequest);


    MovementTypeResponse toMovementTypeResponse(MovementType movementType);

    // Update
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE) // it will ignore if it has no value
    MovementType fromUpdatePositionRequest(UpdateMovementTypeRequest updateMovementTypeRequest, @MappingTarget MovementType movementType);
}
