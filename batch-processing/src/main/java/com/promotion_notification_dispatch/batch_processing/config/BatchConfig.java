package com.promotion_notification_dispatch.batch_processing.config;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;

import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class BatchConfig {
}

/**
 * Correct way in Spring Batch 6
 * --> Spring Boot will auto-create:
 * 01-JobRepository
 * 02-JobLauncher
 * 03-JobExplorer
 * 04-PlatformTransactionManager
 */