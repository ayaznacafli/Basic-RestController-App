package com.ayaz.actuator;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class UserAppInfo {

    @Setter
    @Getter
    private Map<String,Object> healthDetails;

}
