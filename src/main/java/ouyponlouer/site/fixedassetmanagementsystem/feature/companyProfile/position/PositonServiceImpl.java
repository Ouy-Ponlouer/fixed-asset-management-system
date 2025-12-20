package ouyponlouer.site.fixedassetmanagementsystem.feature.companyProfile.position;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ouyponlouer.site.fixedassetmanagementsystem.domain.companyProfileDomain.Position;
import ouyponlouer.site.fixedassetmanagementsystem.feature.companyProfile.position.dto.CreatePositionRequest;
import ouyponlouer.site.fixedassetmanagementsystem.feature.companyProfile.position.dto.PositionDetailResponse;
import ouyponlouer.site.fixedassetmanagementsystem.feature.companyProfile.position.dto.UpdatePositionRequest;
import ouyponlouer.site.fixedassetmanagementsystem.mapper.companyProfileMapper.PositionMapper;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class PositonServiceImpl implements PositionService {

    private final PositionRepository positionRepository;
    private final PositionMapper positionMapper;

    //--------------------------------------------
    // Create
    //--------------------------------------------

    @Override
    public PositionDetailResponse createPosition(CreatePositionRequest createPositionRequest) {

        // Check Position Name En
        if(positionRepository.existsByNameEn(createPositionRequest.positionNameEn()))
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,"Position Name En already exists"
            );

        // Check Position Name Kh
        if(positionRepository.existsByNameKh(createPositionRequest.positionNameKh()))
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,"Position Name Kh already exists"
            );

        Position position = positionMapper.fromCreatePositionRequest(createPositionRequest);
        position.setCreateAt(LocalDate.now());
        positionRepository.save(position);

        return positionMapper.toPositionDetailResponse(position);
    }


    //--------------------------------------------
    // Get All
    //--------------------------------------------

    @Override
    public Page<PositionDetailResponse> getAllPosition(int pageNo, int pageSize) {

        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        PageRequest pageRequest = PageRequest.of(pageNo-1, pageSize, sort);
        Page<Position> positionPage=positionRepository.findAll(pageRequest);

        return positionPage.map(positionMapper::toPositionDetailResponse);
    }


    //--------------------------------------------
    // Get by Id
    //--------------------------------------------

    @Override
    public PositionDetailResponse getPositionById(int id) {

        Position position=positionRepository
                .findById(id)
                .orElseThrow(()->new ResponseStatusException(
                        HttpStatus.NOT_FOUND,"Position Doesn't Exist"
                ));

        return positionMapper.toPositionDetailResponse(position);
    }


    //--------------------------------------------
    // Delete
    //--------------------------------------------

    @Override
    public void deletePosition(int id) {
        Position position=positionRepository
                .findById(id)
                .orElseThrow(()->new ResponseStatusException(
                        HttpStatus.NOT_FOUND,"Position Doesn't Exist"
                ));

        positionRepository.delete(position);
    }


    //--------------------------------------------
    // Update
    //--------------------------------------------
    @Override
    public PositionDetailResponse updatePositionById(int id, UpdatePositionRequest updatePositionRequest) {

        Position position=positionRepository
                .findById(id)
                .orElseThrow(()->new ResponseStatusException(
                        HttpStatus.NOT_FOUND,"Position Doesn't Exist"
                ));

        // Check Position Name En
        if(!position.getPositionNameEn().equals(updatePositionRequest.positionNameEn()))
            if(positionRepository.existsByNameEn(updatePositionRequest.positionNameEn()))
                throw new ResponseStatusException(
                        HttpStatus.CONFLICT,"Position Name En already exists"
                );

        // Check Position Name Kh
        if(!position.getPositionNameKh().equals(updatePositionRequest.positionNameKh()))
            if(positionRepository.existsByNameKh(updatePositionRequest.positionNameKh()))
                throw new ResponseStatusException(
                        HttpStatus.CONFLICT,"Position Name Kh already exists"
                );

        positionMapper.fromUpdatePositionRequest(updatePositionRequest, position);
        position.setCreateAt(position.getCreateAt());
        positionRepository.save(position);

        return positionMapper.toPositionDetailResponse(position);
    }
}
