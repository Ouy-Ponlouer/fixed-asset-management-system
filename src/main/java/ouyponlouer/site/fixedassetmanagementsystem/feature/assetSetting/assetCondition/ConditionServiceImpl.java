package ouyponlouer.site.fixedassetmanagementsystem.feature.assetSetting.assetCondition;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ouyponlouer.site.fixedassetmanagementsystem.domain.assetSettingDomain.Condition;
import ouyponlouer.site.fixedassetmanagementsystem.feature.assetSetting.assetCondition.dto.ConditionResponse;
import ouyponlouer.site.fixedassetmanagementsystem.feature.assetSetting.assetCondition.dto.CreateConditionRequest;
import ouyponlouer.site.fixedassetmanagementsystem.feature.assetSetting.assetCondition.dto.UpdateConditionRequest;
import ouyponlouer.site.fixedassetmanagementsystem.mapper.ConditionMapper;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class ConditionServiceImpl implements ConditionService {

    private final ConditionRepository conditionRepository;
    private final ConditionMapper conditionMapper;


    //--------------------------------------------
    // Create
    //--------------------------------------------

    @Override
    public ConditionResponse create(CreateConditionRequest createConditionRequest) {

        // Validate
        if(conditionRepository.existsByConditionNameEn(createConditionRequest.conditionNameEn()))
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,"Condition Name EN already exist"
            );

        // Validate
        if(conditionRepository.existsByConditionNameKh(createConditionRequest.conditionNameKh()))
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,"Condition Name Kh already exist"
            );

        Condition condition=conditionMapper.fromCreateConditionRequest(createConditionRequest);
        condition.setCreateAt(LocalDate.now());
        conditionRepository.save(condition);

        return conditionMapper.toConditionResponse(condition);
    }


    //--------------------------------------------
    // Get All
    //--------------------------------------------

    @Override
    public Page<ConditionResponse> getAll(int pageNo, int pageSize) {

        Sort sort=Sort.by(Sort.Direction.DESC,"id");
        PageRequest pageRequest=PageRequest.of(pageNo-1,pageSize,sort);
        Page<Condition> conditionPage=conditionRepository.findAll(pageRequest);

        return conditionPage.map(conditionMapper::toConditionResponse);
    }


    //--------------------------------------------
    // Get By ID
    //--------------------------------------------
    @Override
    public ConditionResponse getById(Integer id) {
        Condition condition =conditionRepository
                .findById(id)
                .orElseThrow(()->new ResponseStatusException(
                        HttpStatus.NOT_FOUND,"Condition not found"
                ));

        return conditionMapper.toConditionResponse(condition);
    }


    //--------------------------------------------
    // Delete
    //--------------------------------------------

    @Override
    public void deleteById(Integer id) {

        Condition condition =conditionRepository
                .findById(id)
                .orElseThrow(()->new ResponseStatusException(
                        HttpStatus.NOT_FOUND,"Condition not found"
                ));
        conditionRepository.delete(condition);
    }


    //--------------------------------------------
    // Update
    //--------------------------------------------

    @Override
    public ConditionResponse updateById(Integer id, UpdateConditionRequest updateConditionRequest) {
        Condition condition=conditionRepository
                .findById(id)
                .orElseThrow(()->new ResponseStatusException(
                        HttpStatus.NOT_FOUND,"Condition not found"
                ));

        // Validate conflict name en

        if(!condition.getConditionNameEn().equals(updateConditionRequest.conditionNameEn()))
            if(conditionRepository.existsByConditionNameEn(updateConditionRequest.conditionNameEn()))
                throw new ResponseStatusException(
                        HttpStatus.CONFLICT,"Condition Name EN already exist"
                );

        // Validate conflict name kh
        if(!condition.getConditionNameKh().equals(updateConditionRequest.conditionNameKh()))
            if(conditionRepository.existsByConditionNameKh(updateConditionRequest.conditionNameKh()))
                throw new ResponseStatusException(
                        HttpStatus.CONFLICT,"Condition Name Kh already exist"
                );

        condition=conditionMapper.fromUpdateConditionRequest(updateConditionRequest,condition);
        condition.setCreateAt(LocalDate.now());

        return conditionMapper.toConditionResponse(condition);
    }


}
