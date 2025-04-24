package me.alanton.technobookingsystem.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "booking_requests")
@EntityListeners(AuditingEntityListener.class)
public class BookingRequestEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private String email;

    @Column(name = "first_name", nullable = false)
    private String firstname;

    @Column(name = "last_name", nullable = false)
    private String lastname;

    @Column(nullable = false)
    private String department;

    @Column(name = "booking_date", nullable = false)
    private LocalDate bookingDate;

    @Column(name = "booking_time", nullable = false)
    private LocalDateTime bookingTime;

    @Column(name = "guest_information", columnDefinition = "TEXT", nullable = false)
    private String guestInformation;

    @Column(name = "need_guide", nullable = false)
    private boolean needGuide;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RequestStatus status;

    @CreatedDate
    @Column(name = "craeted_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    public enum RequestStatus {
        PENDING,
        APPROVED,
        REJECTED
    }
}
