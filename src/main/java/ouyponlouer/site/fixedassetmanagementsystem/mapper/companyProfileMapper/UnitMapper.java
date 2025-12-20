package ouyponlouer.site.fixedassetmanagementsystem.mapper.companyProfileMapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ouyponlouer.site.fixedassetmanagementsystem.domain.companyProfileDomain.Unit;
import ouyponlouer.site.fixedassetmanagementsystem.feature.companyProfile.unit.dto.CreateUnitRequest;
import ouyponlouer.site.fixedassetmanagementsystem.feature.companyProfile.unit.dto.UnitDetailResponse;
import ouyponlouer.site.fixedassetmanagementsystem.feature.companyProfile.unit.dto.UpdateUnitRequest;

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
