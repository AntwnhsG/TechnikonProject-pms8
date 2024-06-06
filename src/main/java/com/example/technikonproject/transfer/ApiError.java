package com.example.technikonproject.transfer;

public record ApiError(Integer status, String message, String path) {
}
