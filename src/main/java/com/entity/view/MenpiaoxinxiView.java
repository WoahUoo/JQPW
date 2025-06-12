package com.entity.view;

import com.entity.MenpiaoxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;


/**
 * 门票信息
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2025-03-10 20:31:16
 */
@TableName("menpiaoxinxi")
public class MenpiaoxinxiView  extends MenpiaoxinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public MenpiaoxinxiView(){
	}
 
 	public MenpiaoxinxiView(MenpiaoxinxiEntity menpiaoxinxiEntity){
 	try {
			BeanUtils.copyProperties(this, menpiaoxinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
