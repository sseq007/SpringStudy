package jpabook.jpashop.repository.order.query;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class OrderItemQueryDto {

    @JsonIgnore
    private Long orderid;
    private String itemName;
    private int orderPrice;
    private int count;

    public OrderItemQueryDto(Long orderid, String itemName, int orderPrice, int count) {
        this.orderid = orderid;
        this.itemName = itemName;
        this.orderPrice = orderPrice;
        this.count = count;
    }
}
