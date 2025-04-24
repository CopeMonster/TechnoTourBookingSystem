package me.alanton.technobookingsystem.controller;

import lombok.RequiredArgsConstructor;
import me.alanton.technobookingsystem.dto.request.BookingRequestDTO;
import me.alanton.technobookingsystem.dto.response.BookingResponseDTO;
import me.alanton.technobookingsystem.service.BookingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/booking-tour")
@RequiredArgsConstructor
public class BookingController {
    private final BookingService bookingService;

    @PostMapping("/submit")
    public ResponseEntity<BookingResponseDTO> submit(
            @RequestBody BookingRequestDTO requestDTO
            ) {
        BookingResponseDTO bookingResponseDTO = bookingService.submit(requestDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(bookingResponseDTO);
    }
}
