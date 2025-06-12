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


import com.dao.ShoupiaodingdanDao;
import com.entity.ShoupiaodingdanEntity;
import com.service.ShoupiaodingdanService;
import com.entity.vo.ShoupiaodingdanVO;
import com.entity.view.ShoupiaodingdanView;

@Service("shoupiaodingdanService")
public class ShoupiaodingdanServiceImpl extends ServiceImpl<ShoupiaodingdanDao, ShoupiaodingdanEntity> implements ShoupiaodingdanService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShoupiaodingdanEntity> page = this.selectPage(
                new Query<ShoupiaodingdanEntity>(params).getPage(),
                new EntityWrapper<ShoupiaodingdanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShoupiaodingdanEntity> wrapper) {
		  Page<ShoupiaodingdanView> page =new Query<ShoupiaodingdanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<ShoupiaodingdanVO> selectListVO(Wrapper<ShoupiaodingdanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ShoupiaodingdanVO selectVO(Wrapper<ShoupiaodingdanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ShoupiaodingdanView> selectListView(Wrapper<ShoupiaodingdanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShoupiaodingdanView selectView(Wrapper<ShoupiaodingdanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
