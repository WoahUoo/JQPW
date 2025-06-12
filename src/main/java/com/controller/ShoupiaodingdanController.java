package com.controller;

import java.util.Arrays;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.annotation.IgnoreAuth;

import com.entity.ShoupiaodingdanEntity;
import com.entity.view.ShoupiaodingdanView;

import com.service.ShoupiaodingdanService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;

/**
 * 售票订单
 * 后端接口
 * @author 
 * @email 
 * @date 2025-03-10 20:31:16
 */
@RestController
@RequestMapping("/shoupiaodingdan")
public class ShoupiaodingdanController {
    @Autowired
    private ShoupiaodingdanService shoupiaodingdanService;




    



    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ShoupiaodingdanEntity shoupiaodingdan,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("shoupiaoyuan")) {
			shoupiaodingdan.setShoupiaoyuanzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ShoupiaodingdanEntity> ew = new EntityWrapper<ShoupiaodingdanEntity>();

		PageUtils page = shoupiaodingdanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shoupiaodingdan), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ShoupiaodingdanEntity shoupiaodingdan, 
		HttpServletRequest request){
        EntityWrapper<ShoupiaodingdanEntity> ew = new EntityWrapper<ShoupiaodingdanEntity>();

		PageUtils page = shoupiaodingdanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shoupiaodingdan), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ShoupiaodingdanEntity shoupiaodingdan){
       	EntityWrapper<ShoupiaodingdanEntity> ew = new EntityWrapper<ShoupiaodingdanEntity>();
      	ew.allEq(MPUtil.allEQMapPre( shoupiaodingdan, "shoupiaodingdan")); 
        return R.ok().put("data", shoupiaodingdanService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ShoupiaodingdanEntity shoupiaodingdan){
        EntityWrapper< ShoupiaodingdanEntity> ew = new EntityWrapper< ShoupiaodingdanEntity>();
 		ew.allEq(MPUtil.allEQMapPre( shoupiaodingdan, "shoupiaodingdan")); 
		ShoupiaodingdanView shoupiaodingdanView =  shoupiaodingdanService.selectView(ew);
		return R.ok("查询售票订单成功").put("data", shoupiaodingdanView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ShoupiaodingdanEntity shoupiaodingdan = shoupiaodingdanService.selectById(id);
        return R.ok().put("data", shoupiaodingdan);
    }
//    @IgnoreAuth
//    @RequestMapping("/zhifu/{id}")
//    public R zhifu(@PathVariable("id") Long id){
//        System.out.println("支付");
//        ShoupiaodingdanEntity shoupiaodingdan = shoupiaodingdanService.selectById(id);
//        shoupiaodingdan.setIspay("已支付");
//        shoupiaodingdanService.updateById(shoupiaodingdan);
//        return R.ok();
//    }
@IgnoreAuth
@GetMapping(value = "/zhifu/{id}", produces = "text/html;charset=UTF-8")
public String zhifu(@PathVariable("id") Long id) {
    ShoupiaodingdanEntity shoupiaodingdan = shoupiaodingdanService.selectById(id);
    shoupiaodingdan.setIspay("已支付");
    shoupiaodingdanService.updateById(shoupiaodingdan);

    return "<!DOCTYPE html>" +
            "<html>" +
            "<head>" +
            "    <meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>" +
            "    <title>支付成功</title>" +
            "    <style>" +
            "        body { text-align: center; padding: 50px; }" +
            "        h1 { color: #4CAF50; font-size: 36px; }" +
            "    </style>" +
            "</head>" +
            "<body>" +
            "    <h1>✅ 支付成功</h1>" +
            "</body>" +
            "</html>";
}

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ShoupiaodingdanEntity shoupiaodingdan = shoupiaodingdanService.selectById(id);
        return R.ok().put("data", shoupiaodingdan);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ShoupiaodingdanEntity shoupiaodingdan, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(shoupiaodingdan);
        shoupiaodingdanService.insert(shoupiaodingdan);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ShoupiaodingdanEntity shoupiaodingdan, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(shoupiaodingdan);
        shoupiaodingdanService.insert(shoupiaodingdan);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ShoupiaodingdanEntity shoupiaodingdan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shoupiaodingdan);
        shoupiaodingdanService.updateById(shoupiaodingdan);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        shoupiaodingdanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }















}
