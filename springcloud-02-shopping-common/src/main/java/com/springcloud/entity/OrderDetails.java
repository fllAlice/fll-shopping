package com.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetails implements java.io.Serializable {
   
	private static final long serialVersionUID = -5575089304535953058L;
	
	/**
	 * 
	 */
	private Integer orderDetailId;

	/**
	 * 
	 */
    private Integer orderId;

	/**
	 * 
	 */
    private Integer goodsId;

	/**
	 * 
	 */
    private String goodsName;

	/**
	 * 
	 */
    private Double goodsFinalPrice;

	/**
	 * 
	 */
    private Integer goodsFinalNum;

   
}