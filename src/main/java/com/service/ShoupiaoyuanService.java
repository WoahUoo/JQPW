package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ShoupiaoyuanEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ShoupiaoyuanVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ShoupiaoyuanView;


/**
 * 售票员
 *
 * @author 
 * @email 
 * @date 2025-03-10 20:31:16
 */
public interface ShoupiaoyuanService extends IService<ShoupiaoyuanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShoupiaoyuanVO> selectListVO(Wrapper<ShoupiaoyuanEntity> wrapper);
   	
   	ShoupiaoyuanVO selectVO(@Param("ew") Wrapper<ShoupiaoyuanEntity> wrapper);
   	
   	List<ShoupiaoyuanView> selectListView(Wrapper<ShoupiaoyuanEntity> wrapper);
   	
   	ShoupiaoyuanView selectView(@Param("ew") Wrapper<ShoupiaoyuanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShoupiaoyuanEntity> wrapper);

   	

}

