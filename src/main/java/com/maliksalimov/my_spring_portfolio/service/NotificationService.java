package com.maliksalimov.my_spring_portfolio.service;

import com.maliksalimov.my_spring_portfolio.model.Investment;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    @Async("taskExecutor")
    public void scheduleNotification(Investment investment) {
        try {
            Thread.sleep(120000); // 2 minutes
            System.out.println("=".repeat(60));
            System.out.println("📢 NOTIFICATION: Investment Alert!");
            System.out.println("   Investment: " + investment.getName());
            System.out.println("   Amount: $" + String.format("%,.2f", investment.getAmount()));
            System.out.println("   Created 2 minutes ago at: " + investment.getCreatedAt());
            System.out.println("=".repeat(60));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Notification scheduling interrupted");
        }
    }
}
