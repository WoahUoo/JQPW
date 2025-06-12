package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 门票信息
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2025-03-10 20:31:16
 */
@TableName("menpiaoxinxi")
public class MenpiaoxinxiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public MenpiaoxinxiEntity() {
		
	}
	
	public MenpiaoxinxiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
    @TableId(type = IdType.AUTO)
    private Long id;
	/**
	 * 门票名称
	 */
					
	private String menpiaomingcheng;
	
	/**
	 * 封面
	 */
					
	private String fengmian;
	
	/**
	 * 门票类型
	 */
					
	private String menpiaoleixing;
	
	/**
	 * 票价
	 */
					
	private Integer piaojia;
	
	/**
	 * 开放时间
	 */
					
	private String kaifangshijian;
	
	/**
	 * 游玩须知
	 */
					
	private String youwanxuzhi;
	
	/**
	 * 注意事项
	 */
					
	private String zhuyishixiang;
	
	/**
	 * 门票简介
	 */
					
	private String menpiaojianjie;
	
	/**
	 * 最近点击时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date clicktime;
	

	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：门票名称
	 */
	public void setMenpiaomingcheng(String menpiaomingcheng) {
		this.menpiaomingcheng = menpiaomingcheng;
	}
	/**
	 * 获取：门票名称
	 */
	public String getMenpiaomingcheng() {
		return menpiaomingcheng;
	}
	/**
	 * 设置：封面
	 */
	public void setFengmian(String fengmian) {
		this.fengmian = fengmian;
	}
	/**
	 * 获取：封面
	 */
	public String getFengmian() {
		return fengmian;
	}
	/**
	 * 设置：门票类型
	 */
	public void setMenpiaoleixing(String menpiaoleixing) {
		this.menpiaoleixing = menpiaoleixing;
	}
	/**
	 * 获取：门票类型
	 */
	public String getMenpiaoleixing() {
		return menpiaoleixing;
	}
	/**
	 * 设置：票价
	 */
	public void setPiaojia(Integer piaojia) {
		this.piaojia = piaojia;
	}
	/**
	 * 获取：票价
	 */
	public Integer getPiaojia() {
		return piaojia;
	}
	/**
	 * 设置：开放时间
	 */
	public void setKaifangshijian(String kaifangshijian) {
		this.kaifangshijian = kaifangshijian;
	}
	/**
	 * 获取：开放时间
	 */
	public String getKaifangshijian() {
		return kaifangshijian;
	}
	/**
	 * 设置：游玩须知
	 */
	public void setYouwanxuzhi(String youwanxuzhi) {
		this.youwanxuzhi = youwanxuzhi;
	}
	/**
	 * 获取：游玩须知
	 */
	public String getYouwanxuzhi() {
		return youwanxuzhi;
	}
	/**
	 * 设置：注意事项
	 */
	public void setZhuyishixiang(String zhuyishixiang) {
		this.zhuyishixiang = zhuyishixiang;
	}
	/**
	 * 获取：注意事项
	 */
	public String getZhuyishixiang() {
		return zhuyishixiang;
	}
	/**
	 * 设置：门票简介
	 */
	public void setMenpiaojianjie(String menpiaojianjie) {
		this.menpiaojianjie = menpiaojianjie;
	}
	/**
	 * 获取：门票简介
	 */
	public String getMenpiaojianjie() {
		return menpiaojianjie;
	}
	/**
	 * 设置：最近点击时间
	 */
	public void setClicktime(Date clicktime) {
		this.clicktime = clicktime;
	}
	/**
	 * 获取：最近点击时间
	 */
	public Date getClicktime() {
		return clicktime;
	}


}
