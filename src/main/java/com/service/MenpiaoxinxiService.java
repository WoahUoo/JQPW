package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.MenpiaoxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.MenpiaoxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.MenpiaoxinxiView;


/**
 * 门票信息
 *
 * @author 
 * @email 
 * @date 2025-03-10 20:31:16
 */
public interface MenpiaoxinxiService extends IService<MenpiaoxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<MenpiaoxinxiVO> selectListVO(Wrapper<MenpiaoxinxiEntity> wrapper);
   	
   	MenpiaoxinxiVO selectVO(@Param("ew") Wrapper<MenpiaoxinxiEntity> wrapper);
   	
   	List<MenpiaoxinxiView> selectListView(Wrapper<MenpiaoxinxiEntity> wrapper);
   	
   	MenpiaoxinxiView selectView(@Param("ew") Wrapper<MenpiaoxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<MenpiaoxinxiEntity> wrapper);

   	

}

