//package com.springboot.admin.service;
//
//import com.springboot.admin.dao.CronMapper;
//import org.apache.ibatis.annotations.Mapper;
//import org.apache.ibatis.annotations.Select;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.scheduling.annotation.SchedulingConfigurer;
//import org.springframework.scheduling.config.ScheduledTaskRegistrar;
//import org.springframework.scheduling.support.CronTrigger;
//import org.springframework.util.StringUtils;
//
//import java.time.LocalDateTime;
//
//@Configuration
//@EnableScheduling
//public class CompleteScheduleConfig implements SchedulingConfigurer {
//
//    @Autowired
//    private UserService userService;
//
//    @Autowired
//    @SuppressWarnings("all")
//    CronMapper cronMapper;
//
//    /**
//     * 执行定时任务.
//     */
//    @Override
//    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
//        taskRegistrar.addTriggerTask(
//                //1.添加任务内容(Runnable)
//                //System.out.println("User表记录数量" + userService.getCounts())
//                () -> {
//                    System.out.print("执行定时任务: " + LocalDateTime.now().toLocalTime());
//                    System.out.print("=====");
//                    System.out.println("User表记录数量" + userService.getCounts());
//                },
//                //2.设置执行周期(Trigger)
//                triggerContext -> {
//                    //2.1 从数据库获取执行周期
//                    String cron = cronMapper.getCron();
//                    //2.2 合法性校验.
//                    if (StringUtils.isEmpty(cron)) {
//                        // Omitted Code ..
//                    }
//                    //2.3 返回执行周期(Date)
//                    return new CronTrigger(cron).nextExecutionTime(triggerContext);
//                }
//        );
//    }
//
//}
