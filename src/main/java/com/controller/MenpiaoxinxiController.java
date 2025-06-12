package com.controller;

import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.annotation.IgnoreAuth;

import com.entity.MenpiaoxinxiEntity;
import com.entity.view.MenpiaoxinxiView;

import com.service.MenpiaoxinxiService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.service.StoreupService;

/**
 * 门票信息
 * 后端接口
 * @author 
 * @email 
 * @date 2025-03-10 20:31:16
 */
@RestController
@RequestMapping("/menpiaoxinxi")
public class MenpiaoxinxiController {
    @Autowired
    private MenpiaoxinxiService menpiaoxinxiService;

    @Autowired
    private StoreupService storeupService;



    



    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,MenpiaoxinxiEntity menpiaoxinxi,
		HttpServletRequest request){
        EntityWrapper<MenpiaoxinxiEntity> ew = new EntityWrapper<MenpiaoxinxiEntity>();

		PageUtils page = menpiaoxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, menpiaoxinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,MenpiaoxinxiEntity menpiaoxinxi, 
		HttpServletRequest request){
        EntityWrapper<MenpiaoxinxiEntity> ew = new EntityWrapper<MenpiaoxinxiEntity>();

		PageUtils page = menpiaoxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, menpiaoxinxi), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( MenpiaoxinxiEntity menpiaoxinxi){
       	EntityWrapper<MenpiaoxinxiEntity> ew = new EntityWrapper<MenpiaoxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( menpiaoxinxi, "menpiaoxinxi")); 
        return R.ok().put("data", menpiaoxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(MenpiaoxinxiEntity menpiaoxinxi){
        EntityWrapper< MenpiaoxinxiEntity> ew = new EntityWrapper< MenpiaoxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( menpiaoxinxi, "menpiaoxinxi")); 
		MenpiaoxinxiView menpiaoxinxiView =  menpiaoxinxiService.selectView(ew);
		return R.ok("查询门票信息成功").put("data", menpiaoxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        MenpiaoxinxiEntity menpiaoxinxi = menpiaoxinxiService.selectById(id);
		menpiaoxinxi.setClicktime(new Date());
		menpiaoxinxiService.updateById(menpiaoxinxi);
        menpiaoxinxi = menpiaoxinxiService.selectView(new EntityWrapper<MenpiaoxinxiEntity>().eq("id", id));
        return R.ok().put("data", menpiaoxinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        MenpiaoxinxiEntity menpiaoxinxi = menpiaoxinxiService.selectById(id);
		menpiaoxinxi.setClicktime(new Date());
		menpiaoxinxiService.updateById(menpiaoxinxi);
        menpiaoxinxi = menpiaoxinxiService.selectView(new EntityWrapper<MenpiaoxinxiEntity>().eq("id", id));
        return R.ok().put("data", menpiaoxinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody MenpiaoxinxiEntity menpiaoxinxi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(menpiaoxinxi);
        menpiaoxinxiService.insert(menpiaoxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody MenpiaoxinxiEntity menpiaoxinxi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(menpiaoxinxi);
        menpiaoxinxiService.insert(menpiaoxinxi);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody MenpiaoxinxiEntity menpiaoxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(menpiaoxinxi);
        menpiaoxinxiService.updateById(menpiaoxinxi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        menpiaoxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,MenpiaoxinxiEntity menpiaoxinxi, HttpServletRequest request,String pre){
        EntityWrapper<MenpiaoxinxiEntity> ew = new EntityWrapper<MenpiaoxinxiEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicktime");
        params.put("order", "desc");
		PageUtils page = menpiaoxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, menpiaoxinxi), params), params));
        return R.ok().put("data", page);
    }










}
