## Scheduled Task

ref: https://www.baeldung.com/spring-scheduled-tasks

### Enable Support for Scheduling

```java
@Configuration
@EnableScheduling
public class Application {
    ...
}
```

### Schedule mode

```java
//Schedule a Task at Fixed Delay
//he duration between the end of last execution and the start of next execution is fixed

@Scheduled(fixedDelay = 1000)
public void scheduleFixedDelayTask() {
    System.out.println(
      "Fixed delay task - " + System.currentTimeMillis() / 1000);
}



//Schedule a Task at a Fixed Rate
//the task execution doesn’t wait for the completion of the previous execution
@Scheduled(fixedRate = 1000)
public void scheduleFixedRateTask() {
    System.out.println(
      "Fixed rate task - " + System.currentTimeMillis() / 1000);
}


//Schedule a Task with Initial Delay
//The task will be executed a first time after the initialDelay value – and it will continue to be executed according to the fixedDelay.
@Scheduled(fixedDelay = 1000, initialDelay = 1000)
public void scheduleFixedRateWithInitialDelayTask() {
  
    long now = System.currentTimeMillis() / 1000;
    System.out.println(
      "Fixed rate task with one second initial delay - " + now);
}


//Schedule a Task using Cron Expressions
@Scheduled(cron = "0 15 10 15 * ?")
public void scheduleTaskUsingCronExpression() {
  
    long now = System.currentTimeMillis() / 1000;
    System.out.println(
      "schedule tasks using cron jobs - " + now);
}

//make use of Spring Expressions to externalize the configuration of the tasks – and we’ll store these in properties files:
@Scheduled(fixedDelayString = "${fixedDelay.in.milliseconds}")
@Scheduled(fixedRateString = "${fixedRate.in.milliseconds}")
@Scheduled(cron = "${cron.expression}")

```

