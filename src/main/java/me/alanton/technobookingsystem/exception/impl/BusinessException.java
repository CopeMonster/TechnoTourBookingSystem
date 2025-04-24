package me.alanton.technobookingsystem.exception.impl;

import lombok.Getter;
import me.alanton.technobookingsystem.exception.policy.BusinessExceptionPolicy;
import org.springframework.http.HttpStatus;

@Getter
public class BusinessException extends RuntimeException implements BusinessExceptionPolicy {
    private final String code;
    private final String message;
    private final HttpStatus status;

    public BusinessException(BusinessExceptionReason reason) {
        this(reason, null, (Object[]) null);
    }

    public BusinessException(BusinessExceptionReason reason,
                             HttpStatus overridingHttpStatus) {
        this(reason, overridingHttpStatus, (Object[]) null);

    }

    public BusinessException(BusinessExceptionReason reason, Object... args) {
        this(reason, null, args);
    }

    public BusinessException(BusinessExceptionReason reason,
                             HttpStatus overridingHttpStatus,
                             Object... args) {
        this.code = reason.getCode();

        this.message = (args == null || args.length == 0) ?
                reason.getMessage() : String.format(reason.getMessage(), args);

        this.status = overridingHttpStatus == null ? reason.getStatus() : overridingHttpStatus;
    }
}