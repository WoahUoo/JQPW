package com.entity.view;

import com.entity.ShoupiaodingdanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;


/**
 * 售票订单
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2025-03-10 20:31:16
 */
@TableName("shoupiaodingdan")
public class ShoupiaodingdanView  extends ShoupiaodingdanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ShoupiaodingdanView(){
	}
 
 	public ShoupiaodingdanView(ShoupiaodingdanEntity shoupiaodingdanEntity){
 	try {
			BeanUtils.copyProperties(this, shoupiaodingdanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
