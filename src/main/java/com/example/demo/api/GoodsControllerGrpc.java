package com.example.demo.api;

import com.example.demo.service.impl.GoodsService;
import com.example.demo.service.model.*;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@GrpcService
public class GoodsControllerGrpc extends goodsServiceGrpc.goodsServiceImplBase {
    private final GoodsService goodsService;

    @Autowired
    public GoodsControllerGrpc(GoodsService goodsService) {
        this.goodsService = goodsService;
    }

    @Override
    public void addShower(addShowerRequest request, StreamObserver<addShowerResponse> responseObserver) {
        goodsService.add(new Shower(request.getShower().getNumber(), request.getShower().getFree()));
        addShowerResponse response = addShowerResponse.newBuilder().build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void deleteShower(deleteShowerRequest request, StreamObserver<deleteShowerResponse> responseObserver) {
        goodsService.deleteShower(UUID.fromString(request.getId()));
        deleteShowerResponse response = deleteShowerResponse.newBuilder().build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void getAllShowers(getAllShowersRequest request, StreamObserver<getAllShowersResponse> responseObserver) {
        List<Shower> showers = goodsService.getShowers().findAll();

        List<getShowerResponse> showerResponses = new ArrayList<>();
        for (Shower shower : showers) {
            getShowerResponse showerResponse= getShowerResponse.newBuilder()
                    .setId(shower.getId().toString())
                    .setNumber(shower.getNumber())
                    .setFree(false)
                    .build();
            showerResponses.add(showerResponse);
        }
        getAllShowersResponse response = getAllShowersResponse.newBuilder().addAllShower(showerResponses).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}