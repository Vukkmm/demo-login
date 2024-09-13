package com.example.demo_login.service.impl;

import com.example.demo_login.dto.request.FullNameRequest;
import com.example.demo_login.dto.response.FullNameResponse;
import com.example.demo_login.entity.login.FullName;
import com.example.demo_login.exception.login.FullNameNotFoundException;
import com.example.demo_login.repository.FullNameRepository;
import com.example.demo_login.service.FullNameService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class FullNameServiceImpl implements FullNameService {
    private final FullNameRepository fullNameRepository;

    @Transactional
    @Override
    public FullNameResponse create(String firstName, String lastName) {
        log.info("(create) firstName : {}, lastName : {} ", firstName, lastName);
        FullName fullName = new FullName(firstName, lastName);
        fullNameRepository.save(fullName);
        return new FullNameResponse(
                fullName.getId(),
                fullName.getFirstName(),
                fullName.getLastName()
        );
    }

    @Transactional
    @Override
    public void UpdateByIndex(String id, String firstName, String lastName) {
        log.info("(updateByUserId) id :{}, firstName : {}, lastName : {}", id, firstName, lastName);
        fullNameRepository.updateFullNameByUserId(id, firstName, lastName);
    }

    @Override
    public FullNameResponse detail(String id) {
        log.info("(detail) id : {}", id);
        this.find(id);
        return fullNameRepository.detail(id);
    }

    private FullName find(String id) {
        log.debug("(find) {}", id);
        FullName fullName = fullNameRepository.findById(id).orElseThrow(FullNameNotFoundException::new);
        if(fullName.isDeleted()) {
            throw new FullNameNotFoundException();
        }
        return fullName;
    }


}
