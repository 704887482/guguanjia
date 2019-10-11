package cn.nyse.mapper;

import org.springframework.util.StringUtils;

import java.util.Map;

public class QualificationProvider {


    /**
     * 动态sql
     * @param params
     * @return
     */
    public String selectByCondition(Map<String,Object> params){
        StringBuilder sb = new StringBuilder("SELECT " +
                "qu.id, " +
                "qu.type, " +
                "qu.`check`, " +
                "qu.description, " +
                "qu.update_date, " +
                "qu.create_date, " +
                "uploadUser.name upload_username, " +
                "sysUser.name sys_username " +
                "FROM " +
                "qualification AS qu " +
                "left join  " +
                "sys_user uploadUser " +
                "on " +
                "qu.upload_user_id=uploadUser.id " +
                "left join " +
                "sys_user sysUser " +
                "on " +
                "qu.check_user_id=sysUser.id " +
                "where qu.del_flag='0' ");
        //取出map中的条件参数keytype，如果存在并且  对应的valu不为null和''
        if(params.containsKey("type")&& !StringUtils.isEmpty(params.get("type"))){
            sb.append("and qu.type=#{type} ");
        }
        if(params.containsKey("check")&& !StringUtils.isEmpty(params.get("check"))){
            sb.append("and qu.`check`=#{check} ");
        }
        if(params.containsKey("startDate")&& !StringUtils.isEmpty(params.get("startDate"))){
            sb.append("and qu.create_date>=#{startDate} ");
        }
        if(params.containsKey("endDate")&& !StringUtils.isEmpty(params.get("endDate"))){
            sb.append("and qu.create_date<=#{endDate} ");
        }
        return sb.toString();
    }
}
