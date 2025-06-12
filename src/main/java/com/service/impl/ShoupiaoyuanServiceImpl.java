package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.ShoupiaoyuanDao;
import com.entity.ShoupiaoyuanEntity;
import com.service.ShoupiaoyuanService;
import com.entity.vo.ShoupiaoyuanVO;
import com.entity.view.ShoupiaoyuanView;

@Service("shoupiaoyuanService")
public class ShoupiaoyuanServiceImpl extends ServiceImpl<ShoupiaoyuanDao, ShoupiaoyuanEntity> implements ShoupiaoyuanService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShoupiaoyuanEntity> page = this.selectPage(
                new Query<ShoupiaoyuanEntity>(params).getPage(),
                new EntityWrapper<ShoupiaoyuanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShoupiaoyuanEntity> wrapper) {
		  Page<ShoupiaoyuanView> page =new Query<ShoupiaoyuanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<ShoupiaoyuanVO> selectListVO(Wrapper<ShoupiaoyuanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ShoupiaoyuanVO selectVO(Wrapper<ShoupiaoyuanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ShoupiaoyuanView> selectListView(Wrapper<ShoupiaoyuanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShoupiaoyuanView selectView(Wrapper<ShoupiaoyuanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
