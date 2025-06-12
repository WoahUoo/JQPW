package com.controller;

import java.util.Arrays;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.annotation.IgnoreAuth;

import com.entity.MenpiaoleixingEntity;
import com.entity.view.MenpiaoleixingView;

import com.service.MenpiaoleixingService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;

/**
 * 门票类型
 * 后端接口
 * @author 
 * @email 
 * @date 2025-03-10 20:31:16
 */
@RestController
@RequestMapping("/menpiaoleixing")
public class MenpiaoleixingController {
    @Autowired
    private MenpiaoleixingService menpiaoleixingService;




    



    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,MenpiaoleixingEntity menpiaoleixing,
		HttpServletRequest request){
        EntityWrapper<MenpiaoleixingEntity> ew = new EntityWrapper<MenpiaoleixingEntity>();

		PageUtils page = menpiaoleixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, menpiaoleixing), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,MenpiaoleixingEntity menpiaoleixing, 
		HttpServletRequest request){
        EntityWrapper<MenpiaoleixingEntity> ew = new EntityWrapper<MenpiaoleixingEntity>();

		PageUtils page = menpiaoleixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, menpiaoleixing), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( MenpiaoleixingEntity menpiaoleixing){
       	EntityWrapper<MenpiaoleixingEntity> ew = new EntityWrapper<MenpiaoleixingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( menpiaoleixing, "menpiaoleixing")); 
        return R.ok().put("data", menpiaoleixingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(MenpiaoleixingEntity menpiaoleixing){
        EntityWrapper< MenpiaoleixingEntity> ew = new EntityWrapper< MenpiaoleixingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( menpiaoleixing, "menpiaoleixing")); 
		MenpiaoleixingView menpiaoleixingView =  menpiaoleixingService.selectView(ew);
		return R.ok("查询门票类型成功").put("data", menpiaoleixingView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        MenpiaoleixingEntity menpiaoleixing = menpiaoleixingService.selectById(id);
        return R.ok().put("data", menpiaoleixing);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        MenpiaoleixingEntity menpiaoleixing = menpiaoleixingService.selectById(id);
        return R.ok().put("data", menpiaoleixing);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody MenpiaoleixingEntity menpiaoleixing, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(menpiaoleixing);
        menpiaoleixingService.insert(menpiaoleixing);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody MenpiaoleixingEntity menpiaoleixing, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(menpiaoleixing);
        menpiaoleixingService.insert(menpiaoleixing);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody MenpiaoleixingEntity menpiaoleixing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(menpiaoleixing);
        menpiaoleixingService.updateById(menpiaoleixing);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        menpiaoleixingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
