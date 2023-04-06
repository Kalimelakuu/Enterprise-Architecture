package edu.miu.EALab2_B;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Repository;
import org.springframework.util.StopWatch;


import java.time.LocalDate;
import java.time.LocalDateTime;

@Aspect
@Repository
public class EmailSenderAspect {

    @After("execution(* edu.miu.EALab2_B.EmailSender.sendEmail(String, String)) && args(address, message)")
    public void afterSendEmail(JoinPoint joinPoint, String address, String message) {


        /// A
        System.out.println();
        System.out.println(LocalDateTime.now() + " method=sendEmail");


        /// B
        System.out.println();
        System.out.println(LocalDateTime.now() + " method= " + joinPoint.getSignature().getName() + " address = " + address + " ,message = " + message ) ;

        /// C
        System.out.println();
        IEmailSender emailSender = (EmailSender) joinPoint.getTarget();
        String outgoingMailServer = emailSender.getOutgoingMailServer();
        System.out.println(LocalDateTime.now() + " method= " + joinPoint.getSignature().getName() + " address = " + address + " ,message = " + message + ", outgoingMailServer=" + outgoingMailServer);



    }

    @Around("execution(* edu.miu.EALab2_B.EmailSender.sendEmail(String, String)) ")
    public Object profile (ProceedingJoinPoint call) throws Throwable{
        StopWatch sw = new StopWatch();
        sw.start(call.getSignature().getName());
        Object retVal = call.proceed();
        sw.stop();

        long totaltime = sw.getLastTaskTimeMillis();
// print the time to the console
        System.out.println("The total time is : " + totaltime);

        return retVal;
    }

}

