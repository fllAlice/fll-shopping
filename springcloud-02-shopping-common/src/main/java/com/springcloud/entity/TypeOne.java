package com.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * TYPE_ONE���Ӧ��ʵ���࣬���ڱ������һ��һ�������Ϣ
 * 
 * @author 类型一编号
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TypeOne {
	/**
	 * 类型一名称
	 */
	private Integer typeOneId;

	/**
	 *  类型一名称
	 */
	private String typeOneName;

	/**
	 *  序号
	 */
	private Integer typeOneNum;

	/**
	 * 备注
	 */
	private String typeOneRemark;

}