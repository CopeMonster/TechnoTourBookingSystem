package me.alanton.technobookingsystem.controller;

import lombok.RequiredArgsConstructor;
import me.alanton.technobookingsystem.dto.response.BookingResponseDTO;
import me.alanton.technobookingsystem.entity.BookingRequestEntity;
import me.alanton.technobookingsystem.service.BookingService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/admin/booking-tour")
@PreAuthorize("hasRole('ADMIN')")
@RequiredArgsConstructor
public class AdminBookingController {
    private final BookingService bookingService;

    @GetMapping("/{bookingId}")
    public ResponseEntity<BookingResponseDTO> getBookingRequestById(@PathVariable Long bookingId) {
        BookingResponseDTO bookingResponseDTO =
                bookingService.getBookingRequest(bookingId);

        return ResponseEntity.ok(bookingResponseDTO);
    }

    @GetMapping
    public ResponseEntity<Page<BookingResponseDTO>> getAllBookingRequests(Pageable pageable) {
        Page<BookingResponseDTO> bookingResponseDTOS =
                bookingService.getAllBookingRequests(pageable);

        return ResponseEntity.ok(bookingResponseDTOS);
    }

    @PutMapping("/{bookingId}")
    public ResponseEntity<BookingResponseDTO> updateStatus(
            @PathVariable Long bookingId,
            @RequestParam BookingRequestEntity.RequestStatus status) {
        BookingResponseDTO bookingResponseDTO = bookingService.updateStatus(bookingId, status);

        return ResponseEntity.ok(bookingResponseDTO);
    }
}
