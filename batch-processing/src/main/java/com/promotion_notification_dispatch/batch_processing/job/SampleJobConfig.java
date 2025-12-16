package com.promotion_notification_dispatch.batch_processing.job;

import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.Step;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.infrastructure.repeat.RepeatStatus;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.batch.core.job.Job;

@Configuration
public class SampleJobConfig {

    @Bean
    public Job helloWorldJob(JobRepository jobRepository, Step helloStep) {
        return new JobBuilder("helloWorldJob", jobRepository)
                .start(helloStep) // tells Spring Batch that helloStep is part of helloWorldJob.
                .build();
    }

    @Bean
    public Step helloStep(JobRepository jobRepository) {
        return new StepBuilder("helloStep", jobRepository)
                .tasklet((contribution, chunkContext) -> {
                    System.out.println("✅ HELLO SPRING BATCH – IT WORKS!");
                    return RepeatStatus.FINISHED;
                })
                .build();
    }
}