package com.dao;

import com.entity.MenpiaoxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.MenpiaoxinxiVO;
import com.entity.view.MenpiaoxinxiView;


/**
 * 门票信息
 * 
 * @author 
 * @email 
 * @date 2025-03-10 20:31:16
 */
public interface MenpiaoxinxiDao extends BaseMapper<MenpiaoxinxiEntity> {
	
	List<MenpiaoxinxiVO> selectListVO(@Param("ew") Wrapper<MenpiaoxinxiEntity> wrapper);
	
	MenpiaoxinxiVO selectVO(@Param("ew") Wrapper<MenpiaoxinxiEntity> wrapper);
	
	List<MenpiaoxinxiView> selectListView(@Param("ew") Wrapper<MenpiaoxinxiEntity> wrapper);

	List<MenpiaoxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<MenpiaoxinxiEntity> wrapper);

	
	MenpiaoxinxiView selectView(@Param("ew") Wrapper<MenpiaoxinxiEntity> wrapper);
	

}
