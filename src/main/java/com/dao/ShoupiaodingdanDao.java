package com.dao;

import com.entity.ShoupiaodingdanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ShoupiaodingdanVO;
import com.entity.view.ShoupiaodingdanView;


/**
 * 售票订单
 * 
 * @author 
 * @email 
 * @date 2025-03-10 20:31:16
 */
public interface ShoupiaodingdanDao extends BaseMapper<ShoupiaodingdanEntity> {
	
	List<ShoupiaodingdanVO> selectListVO(@Param("ew") Wrapper<ShoupiaodingdanEntity> wrapper);
	
	ShoupiaodingdanVO selectVO(@Param("ew") Wrapper<ShoupiaodingdanEntity> wrapper);
	
	List<ShoupiaodingdanView> selectListView(@Param("ew") Wrapper<ShoupiaodingdanEntity> wrapper);

	List<ShoupiaodingdanView> selectListView(Pagination page,@Param("ew") Wrapper<ShoupiaodingdanEntity> wrapper);

	
	ShoupiaodingdanView selectView(@Param("ew") Wrapper<ShoupiaodingdanEntity> wrapper);
	

}
