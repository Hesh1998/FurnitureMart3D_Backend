package com.example.FurnitureMart3D_Backend.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;


// Model class for products added by sellers
@Document @Data @AllArgsConstructor @NoArgsConstructor
public class Product {
    private int userId; // Seller id
    private int itemId;
    private String itemName;

    // Location
    private String living;
    private String dining;
    private String bedroom;
    private String office;
    private String outdoor;
    private String other;

    // Item type
    private String chair;
    private String table;
    private String sofa;
    private String cupboard;
    private String bed;
    private String bench;
    private String bookcase;
    private String desk;
    private String otherT;

    // Category
    private String classy;
    private String antique;
    private String traditional;
    private String modern;
    private String contemporary;
    private String transitional;
    private String coastal;
    private String minimalist;

    private String condition;
    private String description;
    private String dimensions;
    private int stockQuantity; // Total available stock
    private int inOrder; // No. of items ordered, but order not yet complete
    private int totalSold; // Total sold items (order completed)
    private double price;

    // Delivery fee and arrival time(days) for each district
    private double deliveryColombo;
    private int arrivalColombo;
    private double deliveryGampaha;
    private int arrivalGampaha;
    private double deliveryKalutara;
    private int arrivalKalutara;
    private double deliveryKandy;
    private int arrivalKandy;
    private double deliveryMatale;
    private int arrivalMatale;
    private double deliveryNuwaraEliya;
    private int arrivalNuwaraEliya;
    private double deliveryGalle;
    private int arrivalGalle;
    private double deliveryMatara;
    private int arrivalMatara;
    private double deliveryHambantota;
    private int arrivalHambantota;
    private double deliveryJaffna;
    private int arrivalJaffna;
    private double deliveryKilinochchi;
    private int arrivalKilinochchi;
    private double deliveryMannar;
    private int arrivalMannar;
    private double deliveryVavuniya;
    private int arrivalVavuniya;
    private double deliveryMullaitivu;
    private int arrivalMullaitivu;
    private double deliveryBatticallo;
    private int arrivalBatticallo;
    private double deliveryAmpara;
    private int arrivalAmpara;
    private double deliveryTrincomalee;
    private int arrivalTrincomalee;
    private double deliveryKurunegala;
    private int arrivalKurunegala;
    private double deliveryPuttalam;
    private int arrivalPuttalam;
    private double deliveryAnuradhapura;
    private int arrivalAnuradhapura;
    private double deliveryPolonnaruwa;
    private int arrivalPolonnaruwa;
    private double deliveryBadulla;
    private int arrivalBadulla;
    private double deliveryMoneragala;
    private int arrivalMoneragala;
    private double deliveryRatnapura;
    private int arrivalRatnapura;
    private double deliveryKegalle;
    private int arrivalKegalle;

    // Material details
    private String material;
    private String materialDescription;
    private String subMaterials;
    private String subMaterialsDescription;
    private String clr1;
    private String clr1Img;
    private String clr2;
    private String clr2Img;
    private String clr3;
    private String clr3Img;

    // Additional graphics
    private String add1Img;
    private String add2Img;
    private String vid1;
}
