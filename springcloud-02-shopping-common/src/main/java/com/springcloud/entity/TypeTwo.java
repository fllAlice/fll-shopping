package com.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * TYPE_TWO
 * 
 * @author 方琳琳
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TypeTwo {
	/**
	 * 类型二编号
	 */
	private Integer typeTwoId;

	/**
	 * 类型二名称
	 */
	private String typeTwoName;

	/**
	 * 类型一编号
	 */
	private Integer typeOneId;

	/**
	 *备注ע
	 */
	private String typeTwoRemark;

}