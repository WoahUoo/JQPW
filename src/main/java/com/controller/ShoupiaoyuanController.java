package com.controller;

import java.util.Arrays;
import java.util.Map;
import java.util.Date;
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

import com.entity.ShoupiaoyuanEntity;
import com.entity.view.ShoupiaoyuanView;

import com.service.ShoupiaoyuanService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;

/**
 * 售票员
 * 后端接口
 * @author 
 * @email 
 * @date 2025-03-10 20:31:16
 */
@RestController
@RequestMapping("/shoupiaoyuan")
public class ShoupiaoyuanController {
    @Autowired
    private ShoupiaoyuanService shoupiaoyuanService;




    
	@Autowired
	private TokenService tokenService;
	
	/**
	 * 登录
	 */
	@IgnoreAuth
	@RequestMapping(value = "/login")
	public R login(String username, String password, String captcha, HttpServletRequest request) {
		ShoupiaoyuanEntity u = shoupiaoyuanService.selectOne(new EntityWrapper<ShoupiaoyuanEntity>().eq("shoupiaoyuanzhanghao", username));
		if(u==null || !u.getMima().equals(password)) {
			return R.error("账号或密码不正确");
		}
		
		String token = tokenService.generateToken(u.getId(), username,"shoupiaoyuan",  "售票员" );
		return R.ok().put("token", token);
	}


	
	/**
     * 注册
     */
	@IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody ShoupiaoyuanEntity shoupiaoyuan){
    	//ValidatorUtils.validateEntity(shoupiaoyuan);
    	ShoupiaoyuanEntity u = shoupiaoyuanService.selectOne(new EntityWrapper<ShoupiaoyuanEntity>().eq("shoupiaoyuanzhanghao", shoupiaoyuan.getShoupiaoyuanzhanghao()));
		if(u!=null) {
			return R.error("注册售票员已存在");
		}
		Long uId = new Date().getTime();
		shoupiaoyuan.setId(uId);
        shoupiaoyuanService.insert(shoupiaoyuan);
        return R.ok();
    }

	
	/**
	 * 退出
	 */
	@RequestMapping("/logout")
	public R logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return R.ok("退出成功");
	}
	
	/**
     * 获取售票员的session售票员信息
     */
    @RequestMapping("/session")
    public R getCurrUser(HttpServletRequest request){
    	Long id = (Long)request.getSession().getAttribute("userId");
        ShoupiaoyuanEntity u = shoupiaoyuanService.selectById(id);
        return R.ok().put("data", u);
    }
    
    /**
     * 密码重置
     */
    @IgnoreAuth
	@RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request){
    	ShoupiaoyuanEntity u = shoupiaoyuanService.selectOne(new EntityWrapper<ShoupiaoyuanEntity>().eq("shoupiaoyuanzhanghao", username));
    	if(u==null) {
    		return R.error("账号不存在");
    	}
        u.setMima("123456");
        shoupiaoyuanService.updateById(u);
        return R.ok("密码已重置为：123456");
    }



    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ShoupiaoyuanEntity shoupiaoyuan,
		HttpServletRequest request){
        EntityWrapper<ShoupiaoyuanEntity> ew = new EntityWrapper<ShoupiaoyuanEntity>();

		PageUtils page = shoupiaoyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shoupiaoyuan), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ShoupiaoyuanEntity shoupiaoyuan, 
		HttpServletRequest request){
        EntityWrapper<ShoupiaoyuanEntity> ew = new EntityWrapper<ShoupiaoyuanEntity>();

		PageUtils page = shoupiaoyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shoupiaoyuan), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ShoupiaoyuanEntity shoupiaoyuan){
       	EntityWrapper<ShoupiaoyuanEntity> ew = new EntityWrapper<ShoupiaoyuanEntity>();
      	ew.allEq(MPUtil.allEQMapPre( shoupiaoyuan, "shoupiaoyuan")); 
        return R.ok().put("data", shoupiaoyuanService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ShoupiaoyuanEntity shoupiaoyuan){
        EntityWrapper< ShoupiaoyuanEntity> ew = new EntityWrapper< ShoupiaoyuanEntity>();
 		ew.allEq(MPUtil.allEQMapPre( shoupiaoyuan, "shoupiaoyuan")); 
		ShoupiaoyuanView shoupiaoyuanView =  shoupiaoyuanService.selectView(ew);
		return R.ok("查询售票员成功").put("data", shoupiaoyuanView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ShoupiaoyuanEntity shoupiaoyuan = shoupiaoyuanService.selectById(id);
        return R.ok().put("data", shoupiaoyuan);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ShoupiaoyuanEntity shoupiaoyuan = shoupiaoyuanService.selectById(id);
        return R.ok().put("data", shoupiaoyuan);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ShoupiaoyuanEntity shoupiaoyuan, HttpServletRequest request){
        if(shoupiaoyuanService.selectCount(new EntityWrapper<ShoupiaoyuanEntity>().eq("shoupiaoyuanzhanghao", shoupiaoyuan.getShoupiaoyuanzhanghao()))>0) {
            return R.error("售票员账号已存在");
        }
    	shoupiaoyuan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shoupiaoyuan);
    	ShoupiaoyuanEntity u = shoupiaoyuanService.selectOne(new EntityWrapper<ShoupiaoyuanEntity>().eq("shoupiaoyuanzhanghao", shoupiaoyuan.getShoupiaoyuanzhanghao()));
		if(u!=null) {
			return R.error("售票员已存在");
		}
		shoupiaoyuan.setId(new Date().getTime());
        shoupiaoyuanService.insert(shoupiaoyuan);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ShoupiaoyuanEntity shoupiaoyuan, HttpServletRequest request){
        if(shoupiaoyuanService.selectCount(new EntityWrapper<ShoupiaoyuanEntity>().eq("shoupiaoyuanzhanghao", shoupiaoyuan.getShoupiaoyuanzhanghao()))>0) {
            return R.error("售票员账号已存在");
        }
    	shoupiaoyuan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shoupiaoyuan);
    	ShoupiaoyuanEntity u = shoupiaoyuanService.selectOne(new EntityWrapper<ShoupiaoyuanEntity>().eq("shoupiaoyuanzhanghao", shoupiaoyuan.getShoupiaoyuanzhanghao()));
		if(u!=null) {
			return R.error("售票员已存在");
		}
		shoupiaoyuan.setId(new Date().getTime());
        shoupiaoyuanService.insert(shoupiaoyuan);
        return R.ok();
    }



     /**
     * 获取售票员密保
     */
    @RequestMapping("/security")
    @IgnoreAuth
    public R security(@RequestParam String username){
        ShoupiaoyuanEntity shoupiaoyuan = shoupiaoyuanService.selectOne(new EntityWrapper<ShoupiaoyuanEntity>().eq("shoupiaoyuanzhanghao", username));
        return R.ok().put("data", shoupiaoyuan);
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @IgnoreAuth
    public R update(@RequestBody ShoupiaoyuanEntity shoupiaoyuan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shoupiaoyuan);
        if(shoupiaoyuanService.selectCount(new EntityWrapper<ShoupiaoyuanEntity>().ne("id", shoupiaoyuan.getId()).eq("shoupiaoyuanzhanghao", shoupiaoyuan.getShoupiaoyuanzhanghao()))>0) {
            return R.error("售票员账号已存在");
        }
        shoupiaoyuanService.updateById(shoupiaoyuan);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        shoupiaoyuanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
