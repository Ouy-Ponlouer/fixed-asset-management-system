package ouyponlouer.site.fixedassetmanagementsystem.feature.companyProfile.unit;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ouyponlouer.site.fixedassetmanagementsystem.domain.companyProfileDomain.Unit;
import ouyponlouer.site.fixedassetmanagementsystem.feature.companyProfile.unit.dto.CreateUnitRequest;
import ouyponlouer.site.fixedassetmanagementsystem.feature.companyProfile.unit.dto.UnitDetailResponse;
import ouyponlouer.site.fixedassetmanagementsystem.feature.companyProfile.unit.dto.UpdateUnitRequest;
import ouyponlouer.site.fixedassetmanagementsystem.mapper.UnitMapper;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class UnitServiceImpl implements UnitService {

    private final UnitRepository unitRepository;
    private final UnitMapper unitMapper;


    //--------------------------------------------
    // Create
    //--------------------------------------------

    @Override
    public UnitDetailResponse createUnit(CreateUnitRequest createUnitRequest) {

        // Check uit name en
        if(unitRepository.existsByUnitNameEn(createUnitRequest.unitNameEn()))
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,"Unit doesn't exist"
            );

        // Check Unit name Kh
        if(unitRepository.existsByUnitNameKh(createUnitRequest.unitNameKh()))
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,"Unit doesn't exist"
            );

        Unit unit = unitMapper.fromCreateUnitRequest(createUnitRequest);
        unit.setCreateAt(LocalDate.now());

        unitRepository.save(unit);
        return unitMapper.toUnitDetailResponse(unit);
    }


    //--------------------------------------------
    // Get all
    //--------------------------------------------

    @Override
    public Page<UnitDetailResponse> getAllUnit(int pageNo, int pageSize) {
        Sort sort=Sort.by(Sort.Direction.DESC,"id");
        PageRequest pageRequest=PageRequest.of(pageNo-1,pageSize,sort);
        Page<Unit> unitPage=unitRepository.findAll(pageRequest);

        return unitPage.map(unitMapper::toUnitDetailResponse);
    }


    //--------------------------------------------
    // Get Unit By ID
    //--------------------------------------------

    @Override
    public UnitDetailResponse getUnitById(int id) {

        Unit unit =unitRepository
                .findById(id)
                .orElseThrow(()->new ResponseStatusException(
                        HttpStatus.NOT_FOUND,"Unit doesn't exit"
                ));

        return unitMapper.toUnitDetailResponse(unit);
    }


    //--------------------------------------------
    // Delete
    //--------------------------------------------

    @Override
    public void deleteUnitById(int id) {
        Unit unit =unitRepository
                .findById(id)
                .orElseThrow(()->new ResponseStatusException(
                        HttpStatus.NOT_FOUND,"Unit doesn't exit"
                ));
        unitRepository.delete(unit);
    }


    //--------------------------------------------
    // Update
    //--------------------------------------------
    @Override
    public UnitDetailResponse updateUnitById(int id, UpdateUnitRequest updateUnitRequest) {

        Unit unit =unitRepository
                .findById(id)
                .orElseThrow(()->new ResponseStatusException(
                        HttpStatus.NOT_FOUND,"Unit doesn't exit"
                ));

        // Check uit name en
        if(!unit.getUnitNameEn().equals(updateUnitRequest.unitNameEn()))
            if(unitRepository.existsByUnitNameEn(updateUnitRequest.unitNameEn()))
                throw new ResponseStatusException(
                        HttpStatus.NOT_FOUND,"Unit name en doesn't exist"
                );

        // Check Unit name Kh
        if(!unit.getUnitNameKh().equals(updateUnitRequest.unitNameKh()))
            if(unitRepository.existsByUnitNameKh(updateUnitRequest.unitNameKh()))
                throw new ResponseStatusException(
                        HttpStatus.NOT_FOUND,"Unit name kh doesn't exist"
                );

        unit=unitMapper.fromUpdateUnitRequest(updateUnitRequest,unit);
        unit.setCreateAt(unit.getCreateAt());
        unitRepository.save(unit);

        return unitMapper.toUnitDetailResponse(unit);
    }
}
