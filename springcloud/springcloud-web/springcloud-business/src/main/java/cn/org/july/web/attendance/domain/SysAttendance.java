package cn.org.july.web.attendance.domain;

import cn.org.july.web.common.base.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 打卡记录表 sys_attendance
 * 
 * @author null
 * @date 2019-06-23
 */
public class SysAttendance extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主建 */
	private Integer id;
	/** 考勤编号 */
	private String attendanceNo;
	/** 考勤名称 */
	private String attendanceName;
	/** 下班打卡时间 */
	private Date clockEndTime;
	/** 上班打卡时间 */
	private Date clockStartTime;
	/** 项目编号 */
	private String projectNumber;
	/** 餐补 */
	private String subsidizedMeals;
	/** 交通补助 */
	private String traffic;
	/** 调休 */
	private String paidLeave;
	/** 用户id */
	private Integer userId;
	/** 考勤名称 */
	private String userName;

	public void setId(Integer id) 
	{
		this.id = id;
	}

	public Integer getId() 
	{
		return id;
	}
	public void setAttendanceNo(String attendanceNo) 
	{
		this.attendanceNo = attendanceNo;
	}

	public String getAttendanceNo() 
	{
		return attendanceNo;
	}
	public void setAttendanceName(String attendanceName) 
	{
		this.attendanceName = attendanceName;
	}

	public String getAttendanceName() 
	{
		return attendanceName;
	}
	public void setClockEndTime(Date clockEndTime) 
	{
		this.clockEndTime = clockEndTime;
	}

	public Date getClockEndTime() 
	{
		return clockEndTime;
	}
	public void setClockStartTime(Date clockStartTime) 
	{
		this.clockStartTime = clockStartTime;
	}

	public Date getClockStartTime() 
	{
		return clockStartTime;
	}
	public void setProjectNumber(String projectNumber) 
	{
		this.projectNumber = projectNumber;
	}

	public String getProjectNumber() 
	{
		return projectNumber;
	}
	public void setSubsidizedMeals(String subsidizedMeals) 
	{
		this.subsidizedMeals = subsidizedMeals;
	}

	public String getSubsidizedMeals() 
	{
		return subsidizedMeals;
	}
	public void setTraffic(String traffic) 
	{
		this.traffic = traffic;
	}

	public String getTraffic() 
	{
		return traffic;
	}
	public void setPaidLeave(String paidLeave) 
	{
		this.paidLeave = paidLeave;
	}

	public String getPaidLeave() 
	{
		return paidLeave;
	}
	public void setUserId(Integer userId) 
	{
		this.userId = userId;
	}

	public Integer getUserId() 
	{
		return userId;
	}
	public void setUserName(String userName) 
	{
		this.userName = userName;
	}

	public String getUserName() 
	{
		return userName;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("attendanceNo", getAttendanceNo())
            .append("attendanceName", getAttendanceName())
            .append("clockEndTime", getClockEndTime())
            .append("clockStartTime", getClockStartTime())
            .append("projectNumber", getProjectNumber())
            .append("subsidizedMeals", getSubsidizedMeals())
            .append("traffic", getTraffic())
            .append("paidLeave", getPaidLeave())
            .append("userId", getUserId())
            .append("userName", getUserName())
            .toString();
    }
}
