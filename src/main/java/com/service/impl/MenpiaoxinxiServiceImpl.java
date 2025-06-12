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


import com.dao.MenpiaoxinxiDao;
import com.entity.MenpiaoxinxiEntity;
import com.service.MenpiaoxinxiService;
import com.entity.vo.MenpiaoxinxiVO;
import com.entity.view.MenpiaoxinxiView;

@Service("menpiaoxinxiService")
public class MenpiaoxinxiServiceImpl extends ServiceImpl<MenpiaoxinxiDao, MenpiaoxinxiEntity> implements MenpiaoxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<MenpiaoxinxiEntity> page = this.selectPage(
                new Query<MenpiaoxinxiEntity>(params).getPage(),
                new EntityWrapper<MenpiaoxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<MenpiaoxinxiEntity> wrapper) {
		  Page<MenpiaoxinxiView> page =new Query<MenpiaoxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<MenpiaoxinxiVO> selectListVO(Wrapper<MenpiaoxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public MenpiaoxinxiVO selectVO(Wrapper<MenpiaoxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<MenpiaoxinxiView> selectListView(Wrapper<MenpiaoxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public MenpiaoxinxiView selectView(Wrapper<MenpiaoxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
