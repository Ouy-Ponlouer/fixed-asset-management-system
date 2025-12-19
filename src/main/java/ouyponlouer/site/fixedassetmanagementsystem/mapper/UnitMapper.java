package ouyponlouer.site.fixedassetmanagementsystem.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ouyponlouer.site.fixedassetmanagementsystem.domain.Unit;
import ouyponlouer.site.fixedassetmanagementsystem.feature.unit.dto.CreateUnitRequest;
import ouyponlouer.site.fixedassetmanagementsystem.feature.unit.dto.UnitDetailResponse;
import ouyponlouer.site.fixedassetmanagementsystem.feature.unit.dto.UpdateUnitRequest;

@Mapper(componentModel = "spring")
public interface UnitMapper {

    // create
    Unit fromCreateUnitRequest(CreateUnitRequest createUnitRequest);

    // Response
    UnitDetailResponse toUnitDetailResponse(Unit unit);

    // Update
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Unit fromUpdateUnitRequest (UpdateUnitRequest updateUnitRequest,@MappingTarget Unit unit);

}
