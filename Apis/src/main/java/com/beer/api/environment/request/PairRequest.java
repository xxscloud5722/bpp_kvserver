package com.beer.api.environment.request;

import lombok.Data;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Data
public class PairRequest {
    @Schema(description = "键值Key")
    private String key;
    @Schema(description = "键值Value")
    private String value;
    @Schema(description = "键值描述")
    private String description;
}
