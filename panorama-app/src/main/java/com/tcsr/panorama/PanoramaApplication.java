package com.tcsr.panorama;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * @author tangzhong
 * @date   2025-08-28 15:00
 * @since  V1.0.0.0
 */
@SpringBootApplication(scanBasePackages = "com.tcsr")
public class PanoramaApplication {

    public static void main(String[] args) {
        SpringApplication.run(PanoramaApplication.class, args);
    }

}