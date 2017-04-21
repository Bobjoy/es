/**
 * Copyright (c) 2005-2012 https://github.com/zhangkaitao
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.sishuok.es.personal.calendar.service;

import com.sishuok.es.common.service.BaseService;
import com.sishuok.es.personal.calendar.entity.Calendar;
import com.sishuok.es.personal.calendar.repository.CalendarRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.Date;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 13-2-4 下午3:01
 * <p>Version: 1.0
 */
@Service
public class CalendarService extends BaseService<Calendar, Long> {

    private CalendarRepository getCalendarRepository() {
        return (CalendarRepository) baseRepository;
    }

    public void copyAndRemove(Calendar calendar) {
        delete(calendar);

        Calendar copyCalendar = new Calendar();
        BeanUtils.copyProperties(calendar, copyCalendar);
        copyCalendar.setId(null);
        save(copyCalendar);
    }

    //2013 10 11   10-20   -3 > now
    //     10 11  10-19
    public Long countRecentlyCalendar(Long userId, Integer interval) {
        Date nowDate = new Date();

        java.util.Calendar calendar = java.util.Calendar.getInstance();
        calendar.set(java.util.Calendar.HOUR_OF_DAY, 0);
        calendar.set(java.util.Calendar.MINUTE, 0);
        calendar.set(java.util.Calendar.SECOND, 0);
        Date nowTime = new Time(calendar.getTimeInMillis());

        return getCalendarRepository().countRecentlyCalendar(userId, nowDate, nowTime, interval);
    }
}
