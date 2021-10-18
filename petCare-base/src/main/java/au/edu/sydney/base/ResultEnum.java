package au.edu.sydney.base;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author king
 * @date 2021-09-14 19:11
 */
@Getter
@AllArgsConstructor
public enum ResultEnum {

    // success
    SUCCESS(200, "success"),
    // fail
    ERROR(999, "fail");

    private Integer code;

    public String desc;

    public Integer getCode() {
        return this.code;
    }

    public String getDesc() {
        return this.desc;
    }

}

