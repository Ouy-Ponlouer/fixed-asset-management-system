package ouyponlouer.site.fixedassetmanagementsystem.feature.assetSetting.movementType;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ouyponlouer.site.fixedassetmanagementsystem.domain.assetSettingDomain.MovementType;
import ouyponlouer.site.fixedassetmanagementsystem.feature.assetSetting.movementType.dto.CreateMovementTypeRequest;
import ouyponlouer.site.fixedassetmanagementsystem.feature.assetSetting.movementType.dto.MovementTypeResponse;
import ouyponlouer.site.fixedassetmanagementsystem.feature.assetSetting.movementType.dto.UpdateMovementTypeRequest;
import ouyponlouer.site.fixedassetmanagementsystem.mapper.assetSettingMapper.MovementTypeMapper;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class MovementTypeServiceImpl implements MovementTypeService{

    private final MovementTypeRepository movementTypeRepository;
    private final MovementTypeMapper movementTypeMapper;

    //--------------------------------------------
    // Create
    //--------------------------------------------

    @Override
    public MovementTypeResponse create(CreateMovementTypeRequest createMovementTypeRequest) {

        if(movementTypeRepository.existsByNameEn(createMovementTypeRequest.movementTypeEn()))
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,"Movement Type En already exist"
            );

        if(movementTypeRepository.existsByNameKh(createMovementTypeRequest.movementTypeKh()))
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,"Movement Type Kh already exist"
            );

        MovementType movementType=movementTypeMapper.fromCreateMovementTypeRequest(createMovementTypeRequest);
        movementType.setCreateAt(LocalDate.now());

        movementTypeRepository.save(movementType);

        return movementTypeMapper.toMovementTypeResponse(movementType);
    }


    //--------------------------------------------
    // Get All
    //--------------------------------------------

    @Override
    public Page<MovementTypeResponse> getAll(int pageNo, int pageSize) {

        Sort sort=Sort.by(Sort.Direction.DESC,"id");
        PageRequest pageRequest=PageRequest.of(pageNo-1,pageSize,sort);
        Page<MovementType> movementTypePage=movementTypeRepository.findAll(pageRequest);

        return movementTypePage.map(movementTypeMapper::toMovementTypeResponse);
    }


    //--------------------------------------------
    // Get All
    //--------------------------------------------

    @Override
    public MovementTypeResponse getById(Integer id) {

        MovementType movementType=movementTypeRepository
                .findById(id)
                .orElseThrow(()->new ResponseStatusException(
                        HttpStatus.NOT_FOUND,"Movement Type doesn't exist"
                ));
        return movementTypeMapper.toMovementTypeResponse(movementType);
    }


    //--------------------------------------------
    // Delete By ID
    //--------------------------------------------

    @Override
    public void deleteById(Integer id) {
        MovementType movementType=movementTypeRepository
                .findById(id)
                .orElseThrow(()->new ResponseStatusException(
                        HttpStatus.NOT_FOUND,"Movement Type doesn't exist"
                ));
        movementTypeRepository.delete(movementType);
    }


    //--------------------------------------------
    // Update By ID
    //--------------------------------------------

    @Override
    public MovementTypeResponse updateById(Integer id, UpdateMovementTypeRequest updateMovementTypeRequest) {
      MovementType movementType=movementTypeRepository
              .findById(id)
              .orElseThrow(()->new ResponseStatusException(
                      HttpStatus.NOT_FOUND,"Movement Type doesn't exist"
              ));

    // Validate unique fields
        if(!movementType.getMovementTypeEn().equals(updateMovementTypeRequest.movementTypeEn()))
            if(movementTypeRepository.existsByNameEn(updateMovementTypeRequest.movementTypeEn()))
                throw new ResponseStatusException(
                        HttpStatus.CONFLICT,"Movement Type En already exist"
                );

    // Validate unique fields
        if(!movementType.getMovementTypeKh().equals(updateMovementTypeRequest.movementTypeKh()))
            if(movementTypeRepository.existsByNameKh(updateMovementTypeRequest.movementTypeKh()))
                throw new ResponseStatusException(
                        HttpStatus.CONFLICT,"Movement Type Kh already exist"
                );

        movementType.setMovementTypeEn(updateMovementTypeRequest.movementTypeEn());
        movementType.setMovementTypeKh(updateMovementTypeRequest.movementTypeKh());
        movementTypeRepository.save(movementType);

        return movementTypeMapper.toMovementTypeResponse(movementType);
    }
}
