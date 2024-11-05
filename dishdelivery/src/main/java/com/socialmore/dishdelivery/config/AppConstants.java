package com.socialmore.dishdelivery.config;

public class AppConstants {
    public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 100;

    public static final Long APP_USER = 1001L;
    public static final String[] PUBLIC_URLS = {"/auth/**", "/v3/api-docs", "/v2/api-docs",
    "/swagger-resources/**", "/swagger-ui/**", "/webjars/**"};
}
