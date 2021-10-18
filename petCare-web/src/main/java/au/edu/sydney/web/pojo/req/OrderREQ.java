package au.edu.sydney.web.pojo.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiParam;
import lombok.Data;

/**
 * @author Chris
 * @date 2021-10-01 20:22
 * @description
 */
@Data
@ApiModel(value="OrderREQ", description="order request object")
public class OrderREQ {

    @ApiParam("order id")
    Integer orderID;

    @ApiParam("Status code (1 Not started 2 Completed 3 Cancelled 4 Evaluation completed)")
    Integer code;
}
