package cn.nyse.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "user_bound_device")
public class UserBoundDevice {
    @Id
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "device_id")
    private String deviceId;

    /**
     * 设备类型:01;Android;02:IOS
     */
    @Column(name = "device_type")
    private Integer deviceType;

    /**
     * 推送消息平台分配的ID
     */
    @Column(name = "channel_id")
    private String channelId;

    /**
     * 是否推送消息:0:不推送;1:推送,默认1
     */
    @Column(name = "push_switch")
    private Integer pushSwitch;

    /**
     * 数据创建时间,在数据新增时设置
     */
    @Column(name = "create_date")
    private Date createDate;

    /**
     * 数据修改时间,在数据新增时和修改时设置
     */
    @Column(name = "update_date")
    private Date updateDate;

    /**
     * 删除标记（0：正常；1：删除；2：审核；）
     */
    @Column(name = "del_flag")
    private String delFlag;

    /**
     * 数据创建用户,默认sys
     */
    @Column(name = "create_by")
    private String createBy;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return user_id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * @return device_id
     */
    public String getDeviceId() {
        return deviceId;
    }

    /**
     * @param deviceId
     */
    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId == null ? null : deviceId.trim();
    }

    /**
     * 获取设备类型:01;Android;02:IOS
     *
     * @return device_type - 设备类型:01;Android;02:IOS
     */
    public Integer getDeviceType() {
        return deviceType;
    }

    /**
     * 设置设备类型:01;Android;02:IOS
     *
     * @param deviceType 设备类型:01;Android;02:IOS
     */
    public void setDeviceType(Integer deviceType) {
        this.deviceType = deviceType;
    }

    /**
     * 获取推送消息平台分配的ID
     *
     * @return channel_id - 推送消息平台分配的ID
     */
    public String getChannelId() {
        return channelId;
    }

    /**
     * 设置推送消息平台分配的ID
     *
     * @param channelId 推送消息平台分配的ID
     */
    public void setChannelId(String channelId) {
        this.channelId = channelId == null ? null : channelId.trim();
    }

    /**
     * 获取是否推送消息:0:不推送;1:推送,默认1
     *
     * @return push_switch - 是否推送消息:0:不推送;1:推送,默认1
     */
    public Integer getPushSwitch() {
        return pushSwitch;
    }

    /**
     * 设置是否推送消息:0:不推送;1:推送,默认1
     *
     * @param pushSwitch 是否推送消息:0:不推送;1:推送,默认1
     */
    public void setPushSwitch(Integer pushSwitch) {
        this.pushSwitch = pushSwitch;
    }

    /**
     * 获取数据创建时间,在数据新增时设置
     *
     * @return create_date - 数据创建时间,在数据新增时设置
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 设置数据创建时间,在数据新增时设置
     *
     * @param createDate 数据创建时间,在数据新增时设置
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 获取数据修改时间,在数据新增时和修改时设置
     *
     * @return update_date - 数据修改时间,在数据新增时和修改时设置
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * 设置数据修改时间,在数据新增时和修改时设置
     *
     * @param updateDate 数据修改时间,在数据新增时和修改时设置
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 获取删除标记（0：正常；1：删除；2：审核；）
     *
     * @return del_flag - 删除标记（0：正常；1：删除；2：审核；）
     */
    public String getDelFlag() {
        return delFlag;
    }

    /**
     * 设置删除标记（0：正常；1：删除；2：审核；）
     *
     * @param delFlag 删除标记（0：正常；1：删除；2：审核；）
     */
    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }

    /**
     * 获取数据创建用户,默认sys
     *
     * @return create_by - 数据创建用户,默认sys
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * 设置数据创建用户,默认sys
     *
     * @param createBy 数据创建用户,默认sys
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }
}