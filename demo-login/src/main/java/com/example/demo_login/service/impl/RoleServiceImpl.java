package com.example.demo_login.service.impl;

import com.example.demo_login.dto.request.RoleRequest;
import com.example.demo_login.dto.response.PermissionResponse;
import com.example.demo_login.dto.response.RoleResponse;
import com.example.demo_login.entity.login.Permission;
import com.example.demo_login.entity.login.Role;
import com.example.demo_login.repository.PermissionRepository;
import com.example.demo_login.repository.RoleRepository;
import com.example.demo_login.service.RoleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@RequiredArgsConstructor
@Service
@Slf4j
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;
    private final PermissionRepository permissionRepository;


    @Override
    public RoleResponse create(RoleRequest request) {
        log.info("(create) request : {}", request);

        var role = new Role();
        role.setName(request.getName());
        role.setDescription(request.getDescription());
        var permissions = permissionRepository.findAllById(request.getPermissions());

        role.setPermissions(new HashSet<>(permissions));

        roleRepository.save(role);

        return toRoleResponse(role);
    }

    private RoleResponse toRoleResponse(Role role) {
        log.debug("(toRoleResponse) role : {}", role);

        var response = role.getPermissions();
        Set<PermissionResponse> set = new HashSet<>();
        for (Permission p : response
             ) {
            PermissionResponse permission = new PermissionResponse(p.getName(), role.getDescription());
            set.add(permission);
        }
        return new RoleResponse(
                role.getName(),
                role.getDescription(),
                set
        );
    }
}
