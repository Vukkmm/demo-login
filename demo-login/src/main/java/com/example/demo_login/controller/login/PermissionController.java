package com.example.demo_login.controller.login;

import com.example.demo_login.dto.base.ResponseGeneral;
import com.example.demo_login.dto.request.PermissionRequest;
import com.example.demo_login.dto.response.PermissionResponse;
import com.example.demo_login.message.MessageService;
import com.example.demo_login.service.PermissionService;
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
@RequestMapping("api/v1/permissions")
public class PermissionController {
    private  final MessageService messageService;
    private final PermissionService service;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseGeneral<PermissionResponse> create(
            @Valid @RequestBody PermissionRequest request,
            @RequestHeader(name = LANGUAGE, defaultValue = DEFAULT_LANGUAGE) String language

    ) {
        log.info("(create) request : {}", request);
        return ResponseGeneral.ofCreated(
                messageService.getMessage(CREATE_PERMISSION, language),
                service.create(request)
        );
    }

    @GetMapping
    public  ResponseGeneral<List<PermissionResponse>> getList(
            @RequestHeader(name = LANGUAGE, defaultValue = DEFAULT_LANGUAGE) String language
    ) {
        log.info("(getList");
        return ResponseGeneral.ofSuccess(
                messageService.getMessage(GET_LIST_PERMISSION, language),
                service.getList()
        );
    }

//    @DeleteMapping("{name}")
//    public  ResponseGeneral<?> delete() {
//
//    }



}
