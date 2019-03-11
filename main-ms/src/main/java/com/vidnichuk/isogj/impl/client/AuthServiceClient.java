package com.vidnichuk.isogj.impl.client;

import com.vidnichuk.isogj.api.dto.model.AuthUserDto;
import com.vidnichuk.isogj.api.dto.model.UserDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "oauth-ms")
public interface AuthServiceClient {

    @RequestMapping(method = RequestMethod.POST, value = "/users/create", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    void createUser(AuthUserDto user);

}
