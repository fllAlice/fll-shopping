package com.springcloud.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orders implements java.io.Serializable{
	
	private static final long serialVersionUID = -7062202476855677873L;

	/**
	 * 订单编号
	 */
	private Integer orderId;

	/**
	 * 当前订单的用户信息
	 */
	private Users user;

    /**
     * 收货人姓名，如果省略认为用户表中的用户姓名
     */
    private String receiverName;

    /**
     * 收货人电话，如果省略认为用户表中的用户电话
     */
    private String receiverTel;

    /**
     * 收货人地址，如果省略认为用户表中的用户地址
     */
    private String receiverAddr;

    /**
     * 下单时间，默认为当前时间
     */
    private Date orderTime;

    /**
     * 订单总额
     */
    private Double orderTotal;

    /**
     * 订单状态：0待付款，1待发货，2待收货，3已付款，4已退货
     */
    private Integer orderStatus;

    /**
         * 查询条件：定单开始时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date orderDateMin;
    
    /**
        * 查询条件：定单终止时间
   */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date orderDateMax;
    
    /**
     * 查询条件：起始年月
     */
    private String startMonth;
    
    /**
     * 查询条件：终止年月
     */
    private String endMonth;
    
    /**
     * 统计结果的年月
     */
    private String orderMonth;
    
    /**
     * 统计结果的销售额
     */
    private Double orderPrice;
}