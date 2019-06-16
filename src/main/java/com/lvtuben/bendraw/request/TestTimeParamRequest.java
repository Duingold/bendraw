package com.lvtuben.bendraw.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lvtuben.bendraw.annotion.CheckTimeParam;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description:
 * @author: Bryce
 * @date: 2019/6/12
 * @version: 1.0
 */
@Data
@CheckTimeParam(startTime = "startTime",endTime = "endTime",message = "开始时间必须比结束时间早")
public class TestTimeParamRequest implements Serializable{
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date endTime;
}
