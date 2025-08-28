package com.example.ticketing.domain.reservation.entity;

public enum ReservationStatus {
    AVAILABLE, // 이용 가능
    RESERVED, // 현재 결재 등의 이유로 예약 중
    SOLD, // 판매 완료
    CANCELLED // 취소
}
