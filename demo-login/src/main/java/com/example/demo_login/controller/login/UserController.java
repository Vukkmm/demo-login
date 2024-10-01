package com.example.demo_login.controller.login;

import com.example.demo_login.dto.base.ResponseGeneral;
import com.example.demo_login.dto.request.UserRequest;
import com.example.demo_login.dto.response.UserFacadeResponse;
import com.example.demo_login.facade.UserManagementFacade;
import com.example.demo_login.message.MessageService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.demo_login.constant.CommonConstant.DEFAULT_LANGUAGE;
import static com.example.demo_login.constant.CommonConstant.LANGUAGE;
import static com.example.demo_login.constant.MessageCodeConstant.*;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {
    private final MessageService messageService;
    private final UserManagementFacade userManagementFacade;


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseGeneral<UserFacadeResponse> create(
            @Valid @RequestBody UserRequest request,
            @RequestHeader(name = LANGUAGE, defaultValue = DEFAULT_LANGUAGE) String language
    ) {
        log.info("(create) request : {}", request);
        return ResponseGeneral.ofCreated(
                messageService.getMessage(CREATE_USER, language),
                userManagementFacade.createUser(request));
    }

    @GetMapping
    public ResponseGeneral<List<UserFacadeResponse>> getList(
            @RequestHeader(name = LANGUAGE, defaultValue = DEFAULT_LANGUAGE) String language
    ) {
        log.info("(getList");

        var authentication =  SecurityContextHolder.getContext().getAuthentication();

        log.info("Username : {}", authentication.getName());
        authentication.getAuthorities().forEach(grantedAuthority ->
                log.info(grantedAuthority.getAuthority()));

        return ResponseGeneral.ofSuccess(
                messageService.getMessage(GET_LIST_USER, language),
                userManagementFacade.getList()
        );
    }

    @GetMapping("{id}")
    public ResponseGeneral<UserFacadeResponse> getUser(
            @PathVariable String id,
            @RequestHeader(name = LANGUAGE, defaultValue = DEFAULT_LANGUAGE) String language
    ) {
        log.info("(getUser) id : {}", id);
        return ResponseGeneral.ofSuccess(
                messageService.getMessage(GET_DETAIL_USER, language),
                userManagementFacade.getDetail(id)
        );
    }

    @GetMapping("/myInfo")
    private ResponseGeneral<UserFacadeResponse> getMyInfo(
            @RequestHeader(name = LANGUAGE, defaultValue = DEFAULT_LANGUAGE) String language
    ) {
        log.info("getMyInfo");
        return ResponseGeneral.ofSuccess(
                messageService.getMessage(GET_MY_INFO, language),
                userManagementFacade.getMyInfo()
        );
    }

    @PutMapping("{id}")
    private ResponseGeneral<UserFacadeResponse> update(
            @Valid @RequestBody UserRequest request,
            @PathVariable String id,
            @RequestHeader(name = LANGUAGE, defaultValue = DEFAULT_LANGUAGE) String language
    ) {
        log.info("(update) id : {}, request : {}", id, request);
        return ResponseGeneral.ofSuccess(
                messageService.getMessage(UPDATE_USER, language),
                userManagementFacade.update(id, request)
        );
    }


}
