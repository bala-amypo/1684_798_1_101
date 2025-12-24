// package com.example.demo.controller;

// import com.example.demo.model.PredictionRule;
// import com.example.demo.service.PredictionService;
// import io.swagger.v3.oas.annotations.Operation;
// import io.swagger.v3.oas.annotations.tags.Tag;
// import lombok.RequiredArgsConstructor;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// import java.time.LocalDate;
// import java.util.List;

// @RestController
// @RequestMapping("/api/predict")
// @RequiredArgsConstructor
// @Tag(name = "Prediction Management", description = "APIs for predictions and rules")
// public class PredictionController {

//     private final PredictionService predictionService;

//     @GetMapping("/restock-date/{stockRecordId}")
//     @Operation(summary = "Predict restock date for a stock record")
//     public ResponseEntity<LocalDate> predictRestockDate(@PathVariable Long stockRecordId) {
//         LocalDate predictedDate = predictionService.predictRestockDate(stockRecordId);
//         return ResponseEntity.ok(predictedDate);
//     }

//     @PostMapping("/rules")
//     @Operation(summary = "Create a new prediction rule")
//     public ResponseEntity<PredictionRule> createRule(@RequestBody PredictionRule rule) {
//         PredictionRule createdRule = predictionService.createRule(rule);
//         return ResponseEntity.status(HttpStatus.CREATED).body(createdRule);
//     }

//     @GetMapping("/rules")
//     @Operation(summary = "Get all prediction rules")
//     public ResponseEntity<List<PredictionRule>> getAllRules() {
//         List<PredictionRule> rules = predictionService.getAllRules();
//         return ResponseEntity.ok(rules);
//     }
// }