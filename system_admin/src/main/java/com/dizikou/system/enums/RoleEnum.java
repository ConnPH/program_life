package com.dizikou.system.enums;

import java.util.HashMap;
import java.util.Map;

public enum RoleEnum {

    STUDENT("1", "STUDENT"),
    ADMIN("3", "ADMIN");

    String code;
    String name;

    RoleEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    private static final Map<String, RoleEnum> keyMap = new HashMap<>();

    static {
        for (RoleEnum item : RoleEnum.values()) {
            keyMap.put(item.getCode(), item);
        }
    }

    public static RoleEnum fromCode(String code) {
        return keyMap.get(code);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoleName() {
        return "ROLE_" + name;
    }

}
