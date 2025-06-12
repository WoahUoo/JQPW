package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ShoupiaodingdanEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ShoupiaodingdanVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ShoupiaodingdanView;


/**
 * 售票订单
 *
 * @author 
 * @email 
 * @date 2025-03-10 20:31:16
 */
public interface ShoupiaodingdanService extends IService<ShoupiaodingdanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShoupiaodingdanVO> selectListVO(Wrapper<ShoupiaodingdanEntity> wrapper);
   	
   	ShoupiaodingdanVO selectVO(@Param("ew") Wrapper<ShoupiaodingdanEntity> wrapper);
   	
   	List<ShoupiaodingdanView> selectListView(Wrapper<ShoupiaodingdanEntity> wrapper);
   	
   	ShoupiaodingdanView selectView(@Param("ew") Wrapper<ShoupiaodingdanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShoupiaodingdanEntity> wrapper);

   	

}

