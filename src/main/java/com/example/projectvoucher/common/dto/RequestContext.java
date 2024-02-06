package com.example.projectvoucher.common.dto;

import com.example.projectvoucher.common.type.RequesterType;

public record RequestContext(RequesterType requesterType,
                             String requesterId) {
}
