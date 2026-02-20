package com.example.clinic.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Profile;

/**
 * Enables Redis caching layer.
 */
@Configuration
@EnableCaching
@Profile({"dev", "prod"})
public class RedisConfig {
}