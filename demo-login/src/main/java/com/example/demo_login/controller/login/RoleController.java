package com.example.demo_login.controller.login;

import com.example.demo_login.dto.base.ResponseGeneral;
import com.example.demo_login.dto.request.PermissionRequest;
import com.example.demo_login.dto.request.RoleRequest;
import com.example.demo_login.dto.response.PermissionResponse;
import com.example.demo_login.dto.response.RoleResponse;
import com.example.demo_login.message.MessageService;
import com.example.demo_login.service.PermissionService;
import com.example.demo_login.service.RoleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.demo_login.constant.CommonConstant.DEFAULT_LANGUAGE;
import static com.example.demo_login.constant.CommonConstant.LANGUAGE;
import static com.example.demo_login.constant.MessageCodeConstant.*;

@RequiredArgsConstructor
@RestController
@Slf4j
@RequestMapping("api/v1/roles")
public class RoleController {
    private  final MessageService messageService;
    private final RoleService service;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseGeneral<RoleResponse> create(
            @Valid @RequestBody RoleRequest request,
            @RequestHeader(name = LANGUAGE, defaultValue = DEFAULT_LANGUAGE) String language

    ) {
        log.info("(create) request : {}", request);
        return ResponseGeneral.ofCreated(
                messageService.getMessage(CREATE_ROLE, language),
                service.create(request)
        );
    }

    @GetMapping
    public  ResponseGeneral<List<RoleResponse>> getList(
            @RequestHeader(name = LANGUAGE, defaultValue = DEFAULT_LANGUAGE) String language
    ) {
        log.info("(getList");
        return ResponseGeneral.ofSuccess(
                messageService.getMessage(GET_LIST_ROLE, language),
                service.getList()
        );
    }
//
//    @DeleteMapping("{name}")
//    public  ResponseGeneral<Boolean> delete(
//            @PathVariable String name,
//            @RequestHeader(name = LANGUAGE, defaultValue = DEFAULT_LANGUAGE) String language
//
//    ) {
//        log.info("(delete) name : {}", name);
//        service.delete(name);
//        return ResponseGeneral.ofSuccess(
//                messageService.getMessage(DELETE_PERMISSION, language)
//        );
//    }



}
