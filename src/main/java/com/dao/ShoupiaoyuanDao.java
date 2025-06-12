package com.dao;

import com.entity.ShoupiaoyuanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ShoupiaoyuanVO;
import com.entity.view.ShoupiaoyuanView;


/**
 * 售票员
 * 
 * @author 
 * @email 
 * @date 2025-03-10 20:31:16
 */
public interface ShoupiaoyuanDao extends BaseMapper<ShoupiaoyuanEntity> {
	
	List<ShoupiaoyuanVO> selectListVO(@Param("ew") Wrapper<ShoupiaoyuanEntity> wrapper);
	
	ShoupiaoyuanVO selectVO(@Param("ew") Wrapper<ShoupiaoyuanEntity> wrapper);
	
	List<ShoupiaoyuanView> selectListView(@Param("ew") Wrapper<ShoupiaoyuanEntity> wrapper);

	List<ShoupiaoyuanView> selectListView(Pagination page,@Param("ew") Wrapper<ShoupiaoyuanEntity> wrapper);

	
	ShoupiaoyuanView selectView(@Param("ew") Wrapper<ShoupiaoyuanEntity> wrapper);
	

}
