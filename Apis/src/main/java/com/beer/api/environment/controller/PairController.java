package com.beer.api.environment.controller;

import com.beer.api.environment.bean.PairDTO;
import com.beer.api.environment.request.PairRequest;
import com.beer.api.environment.service.PairService;
import com.billbear.common.base.Preconditions;
import com.billbear.common.base.response.ResponseData;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.util.List;

@Path("/pair")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Tag(name = "Pair 管理器 APIs")
public class PairController {
    @Inject
    PairService pairService;

    @GET
    @Path("/{key}")
    @Operation(summary = "获取Key信息")
    public ResponseData<PairDTO> getKey(@PathParam("key") String key) {
        return ResponseData.SUCCESS(pairService.getKey(key));
    }

    @GET
    @Path("/list")
    @Operation(summary = "获取配置列表")
    public ResponseData<List<PairDTO>> getList() {
        return ResponseData.SUCCESS(pairService.getList());
    }

    @GET
    @Path("/list/{keyword}")
    @Operation(summary = "获取配置列表(过滤)")
    public ResponseData<List<PairDTO>> getListByKeyWord(@PathParam("keyword") String keyword) {
        return ResponseData.SUCCESS(pairService.getListByKeyWord(keyword));
    }

    @PUT
    @Operation(summary = "创建配置")
    public ResponseData<PairDTO> save(PairRequest request) {
        Preconditions.checkNotEmpty(request.getKey(), request.getValue(), request.getDescription());
        return ResponseData.SUCCESS(pairService.save(request));
    }

    @DELETE
    @Operation(summary = "删除配置")
    public ResponseData<Boolean> removeByKey(@QueryParam("key") String key) {
        return ResponseData.SUCCESS(pairService.removeByKey(key));
    }
}
