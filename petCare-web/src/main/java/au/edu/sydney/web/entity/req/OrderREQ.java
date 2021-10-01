package au.edu.sydney.web.entity.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiParam;
import lombok.Data;

/**
 * @author Chris
 * @date 2021-10-01 20:22
 * @description
 */
@Data
@ApiModel(value="OrderREQ", description="订单请求对象")
public class OrderREQ {

    @ApiParam("订单id")
    Integer orderID;

    @ApiParam("状态码 1 未开始 2 已完成 3  已取消")
    Integer code;
}
