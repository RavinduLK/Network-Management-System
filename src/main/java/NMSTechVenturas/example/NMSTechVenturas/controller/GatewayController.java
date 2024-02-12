package NMSTechVenturas.example.NMSTechVenturas.controller;

import NMSTechVenturas.example.NMSTechVenturas.model.Device;
import NMSTechVenturas.example.NMSTechVenturas.model.Gateway;
import NMSTechVenturas.example.NMSTechVenturas.services.GatewayService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v2/")
public class GatewayController {
    private final GatewayService gatewayService;

    public GatewayController(GatewayService gatewayService) {
        this.gatewayService = gatewayService;
    }

    @PostMapping("/gateways")
    public Gateway createGateway(@RequestBody Gateway gateway) {
        return gatewayService.createGateway(gateway);
    }

    @GetMapping("/gateways")
    public List<Gateway> getAllGateways() {
        return gatewayService.getAllGateways();
    }

    @DeleteMapping("/gateways/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteGateway(@PathVariable Long id) {
        boolean deleted = false;
        deleted = gatewayService.deleteGateway(id);
        Map<String,Boolean> response = new HashMap<>();
        response.put("deleted",deleted);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/gateways/{id}")
    public ResponseEntity<Gateway> getGatewayById(@PathVariable Long id) {
        Gateway gateway = null;
        gateway = gatewayService.getGatewayById(id);
        return ResponseEntity.ok(gateway);
    }

    @PutMapping("/gateways/{id}")
    public ResponseEntity<Gateway> updateGateway(@PathVariable Long id, @RequestBody Gateway gateway) {
        gateway = gatewayService.updateGateway(id, gateway);
        return ResponseEntity.ok(gateway);
    }

    @PatchMapping("/gateways/{id}")
    public ResponseEntity<Gateway> nameUpdateGateway(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
        Gateway updatedGateway = gatewayService.nameUpdateGateway(id, updates);
        return ResponseEntity.ok(updatedGateway);
    }

}
