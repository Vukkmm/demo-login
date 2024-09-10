package com.example.demo_login.service.impl;

import com.example.demo_login.dto.request.FullNameRequest;
import com.example.demo_login.entity.login.FullName;
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
    public FullName save(FullNameRequest request) {
        log.info("(save) request:{}", request);
        return fullNameRepository.save(
                new FullName(
                        request.getFirstName(),
                        request.getLastName()));
    }

    @Transactional
    @Override
    public void UpdateByIndex(FullNameRequest fullNameRequest) {
        log.info("(updateByUserId) fullNameRequest:{}", fullNameRequest);
        fullNameRepository.updateFullNameByUserId(
                fullNameRequest);
    }


}
