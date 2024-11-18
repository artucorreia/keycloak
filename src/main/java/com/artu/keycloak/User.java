package com.artu.keycloak;

public record User(String password, String clientId, String grantType, String username) { }