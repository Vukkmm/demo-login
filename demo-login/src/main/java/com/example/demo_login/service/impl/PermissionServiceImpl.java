package com.example.demo_login.service.impl;

import com.example.demo_login.dto.request.PermissionRequest;
import com.example.demo_login.dto.response.AccountResponse;
import com.example.demo_login.dto.response.PermissionResponse;
import com.example.demo_login.entity.login.Account;
import com.example.demo_login.entity.login.Permission;
import com.example.demo_login.repository.PermissionRepository;
import com.example.demo_login.service.PermissionService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class PermissionServiceImpl implements PermissionService {
    private final PermissionRepository repository;

    @Transactional
    @Override
    public PermissionResponse create(PermissionRequest request) {
        log.info("(create) request : {}", request);
        Permission permission = new Permission(request.getName(), request.getDescription());
        repository.save(permission);
        return new PermissionResponse(
                permission.getName(),
                permission.getDescription()
        );
    }

    @Override
    public List<PermissionResponse> getList() {
        log.info("(getList)");
        List<Permission> list = repository.findAll();
        List<PermissionResponse> listResponse = new ArrayList<>();
        for (Permission p : list
        ) {
            PermissionResponse response = getPermissionResponse(p);
            listResponse.add(response);
        }
        return listResponse;

    }

    private PermissionResponse getPermissionResponse(Permission permission) {
        log.debug("(getPermissionResponse) permission : {}", permission);
        return new PermissionResponse(
                permission.getName(),
                permission.getDescription()
        );
    }
}
