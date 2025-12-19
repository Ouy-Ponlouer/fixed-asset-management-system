package ouyponlouer.site.fixedassetmanagementsystem.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ouyponlouer.site.fixedassetmanagementsystem.domain.companyProfileDomain.Position;
import ouyponlouer.site.fixedassetmanagementsystem.feature.position.dto.CreatePositionRequest;
import ouyponlouer.site.fixedassetmanagementsystem.feature.position.dto.PositionDetailResponse;
import ouyponlouer.site.fixedassetmanagementsystem.feature.position.dto.UpdatePositionRequest;

@Mapper(componentModel = "spring")
public interface PositionMapper {

    Position fromCreatePositionRequest(CreatePositionRequest createPositionRequest);

    PositionDetailResponse toPositionDetailResponse(Position position);

    // Update
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE) // it will ignore if it has no value
    Position fromUpdatePositionRequest(UpdatePositionRequest updatePositionRequest,@MappingTarget Position position);
}
