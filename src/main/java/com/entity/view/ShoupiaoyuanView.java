package com.entity.view;

import com.entity.ShoupiaoyuanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;


/**
 * 售票员
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2025-03-10 20:31:16
 */
@TableName("shoupiaoyuan")
public class ShoupiaoyuanView  extends ShoupiaoyuanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ShoupiaoyuanView(){
	}
 
 	public ShoupiaoyuanView(ShoupiaoyuanEntity shoupiaoyuanEntity){
 	try {
			BeanUtils.copyProperties(this, shoupiaoyuanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
