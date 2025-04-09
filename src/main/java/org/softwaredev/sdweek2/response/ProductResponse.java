package org.softwaredev.sdweek2.response;

import lombok.Builder;

@Builder
public record ProductResponse(String id, String name,double price) {}
