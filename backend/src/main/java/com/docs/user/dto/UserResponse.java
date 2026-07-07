package com.docs.user.dto;

import java.util.UUID;

public record UserResponse(UUID id , String firstName , String email) {
}
