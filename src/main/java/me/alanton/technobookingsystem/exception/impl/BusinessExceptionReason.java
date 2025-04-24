package me.alanton.technobookingsystem.exception.impl;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum BusinessExceptionReason {
    BOOKING_REQUEST_NOT_FOUND("Booking request not found", HttpStatus.NOT_FOUND);

    private final String code = this.getClass().getSimpleName();
    private final String message;
    private final HttpStatus status;
}