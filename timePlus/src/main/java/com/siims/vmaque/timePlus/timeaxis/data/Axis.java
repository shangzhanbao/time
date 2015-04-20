package com.siims.vmaque.timePlus.timeaxis.data;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.GenericGenerator;

import com.siims.framework.base.BaseData;
import com.siims.vmaque.timePlus.timecomment.data.Comment;
import com.siims.vmaque.timePlus.timenode.data.Node;

/**
 * 时光轴实体类信息
 * @author lgm
 * @since vmaque2.1
 */
@Entity
@Table(name="TIME_AXIS")
public class Axis implements BaseData{
		
	/**
	 * 描述：主键id<br>
	 * 类型：varchar2(32)<br>
	 * 字段名称：t_id<br>
	 * 可否为空：否<br>
	 */
	@Id
	@GeneratedValue(generator = "hibernate-uuid")
	@GenericGenerator(name = "hibernate-uuid", strategy = "uuid")
	@Column(name = "T_AXIS_ID", length = 32, nullable = false)
	private String id;
	
	/**
	 * 描述：该时光轴的点赞数<br>
	 * 类型：number(12)<br>
	 * 字段名称：t_praise_num<br>
	 * 可否为空：否<br>
	 * 默认：0<br>
	 */
	@Column(name="T_PRAISE_NUM")
	private Integer praiseNum;
	
	/**
	 * 描述：时光轴名字<br>
	 * 类型：varchar2(32)<br>
	 * 字段名称：t_name<br>
	 * 可否为空：否<br>
	 */
	@Column(name="T_AXIS_NAME",length=512)
	private String name;
	
	/**
	 * 描述：时光轴的广告语<br>
	 * 类型：varchar2(32)<br>
	 * 字段名称：t_advertisement<br>
	 * 可否为空：否<br>
	 */
	@Column(name="T_AXIS_ADVERTISEMENT", length=512)
	private String advertisement;
	
	/**
	 * 描述：时光轴所描述的商品的id<br>
	 * 类型：varchar2(32)<br>
	 * 字段名称：t_goods_id<br>
	 * 可否为空：否<br>
	 */
	@Column(name="T_GOODS_ID",length=32)
	private String goodsId;
	
	/**
	 * 描述：时光轴对应的pc端的url<br>
	 * 类型：varchar2(32)<br>
	 * 字段名称：t_url_computer<br>
	 * 可否为空：否<br>
	 * 默认：空<br>
	 */
	@Column(name="T_URL_COMPUTER", length=256)
	private String urlComputer;
	
	/**
	 * 描述：时光轴的mobile端的url<br>
	 * 类型：varchar2(32)<br>
	 * 字段名称：t_url_phone<br>
	 * 可否为空：否<br>
	 * 默认：空<br>
	 */
	@Column(name="T_URL_PHONE", length=256)
	private String urlPhone;
	
	/**
	 * 描述：该时光轴是否已经被发布<br>
	 * 类型：varchar2(1)<br>
	 * 字段名称：t_is_published<br>
	 * 可否为空：否<br>
	 * 默认：0<br>
	 */
	@Column(name="T_IS_PUBLISHED", length=32)
	private String isPublished;
	
	/**
	 * 描述：该时光轴被浏览过的次数<br>
	 * 类型：number(12)<br>
	 * 字段名称：t_visit_num<br>
	 * 可否为空：否<br>
	 * 默认：0<br>
	 */
	@Column(name="T_AXIS_VISIT_NUM")
	private Integer visitNum;
	
	/**
	 * 描述：创建该时光轴的用户的id<br>
	 * 类型：varchar2(32)<br>
	 * 字段名称：t_user_id<br>
	 * 可否为空：否<br>
	 */
	@Column(name="T_USER_ID", length=32)
	private String userId;
	
	@Column(name="T_AXIS_TIME")
	private Date time;
	
	/**
	 * 描述：该时光轴所拥有的节点的集合<br>
	 * 类型：时光轴点集合<br>
	 * 可否为空：否<br>
	 * 排序：默认按照其创建时间点排序
	 */
	@OneToMany(targetEntity=Node.class, fetch=FetchType.EAGER)
	@JoinColumn(name="T_AXIS_ID", referencedColumnName="T_AXIS_ID")
	@Cascade(CascadeType.ALL)
	@OrderBy("T_NODE_TIME")
	private Set<Node> nodes = new HashSet<Node>();
	
	public Axis() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Axis(String name, String advertisement, String userId) {
		super();
		this.name = name;
		this.advertisement = advertisement;
		this.goodsId="";
		this.isPublished="0";
		this.praiseNum=0;
		this.time = new Date();
		this.urlComputer="";
		this.urlPhone="";
		this.userId="";
		this.visitNum=0;
	}



	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public void setId(String id) {
		// TODO Auto-generated method stub
		this.id = id;
	}

	public Integer getPraiseNum() {
		return praiseNum;
	}

	public void setPraiseNum(Integer praiseNum) {
		this.praiseNum = praiseNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdvertisement() {
		return advertisement;
	}

	public void setAdvertisement(String advertisement) {
		this.advertisement = advertisement;
	}

	public String getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	public String getUrlComputer() {
		return urlComputer;
	}

	public void setUrlComputer(String urlComputer) {
		this.urlComputer = urlComputer;
	}

	public String getUrlPhone() {
		return urlPhone;
	}

	public void setUrlPhone(String urlPhone) {
		this.urlPhone = urlPhone;
	}

	public String getIsPublished() {
		return isPublished;
	}

	public void setIsPublished(String isPublished) {
		this.isPublished = isPublished;
	}

	public Integer getVisitNum() {
		return visitNum;
	}

	public void setVisitNum(Integer visitNum) {
		this.visitNum = visitNum;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Set<Node> getNodes() {
		return nodes;
	}

	public void setNodes(Set<Node> nodes) {
		this.nodes = nodes;
	}
}