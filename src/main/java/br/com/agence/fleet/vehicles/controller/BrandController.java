package br.com.agence.fleet.vehicles.controller;

import br.com.agence.fleet.vehicles.domain.dto.BrandDTO;
import br.com.agence.fleet.vehicles.domain.dto.EmployeeDTO;
import br.com.agence.fleet.vehicles.domain.port.adapter.BrandServicePort;
import br.com.agence.fleet.vehicles.domain.port.adapter.EmployeeServicePort;
import br.com.agence.fleet.vehicles.domain.request.BrandRequest;
import br.com.agence.fleet.vehicles.domain.request.EmployeeRequest;
import br.com.agence.fleet.vehicles.domain.response.EmployeeResponse;
import br.com.agence.fleet.vehicles.infra.util.ConstantsUrl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping(ConstantsUrl.BRAND_URL)
public class BrandController {

    private BrandServicePort servicePort;

    public BrandController(BrandServicePort servicePort) {
        this.servicePort = servicePort;
    }

    @ApiOperation(value = "Create a new Brand", notes = "Used to Create a new Brand")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Brand created successfully"),
            @ApiResponse(code = 422, message = "Existing Brand, please provide another CNPJ to Brand"),
            @ApiResponse(code = 500, message = "The requested operation could not be performed. Contact support and report the error")})
    @PostMapping()
    ResponseEntity<BrandDTO> createBrand(@RequestBody BrandRequest request) throws NotFoundException, ParseException {
        return ResponseEntity.status(HttpStatus.CREATED).body(servicePort.createBrand(request));
    }
    
    @DeleteMapping("/{document}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('ROLE_ADM')")
    public ResponseEntity<String> removeBrand(@PathVariable String document) throws NotFoundException {
        servicePort.removeBrand(document);
        return ResponseEntity.ok("Marca Removida com sucesso");
    }
    
    @ApiOperation(value = "Search All Brand", notes = "Used to Fetch Brand")
    @ApiResponses(value = {
            @ApiResponse(code = 202, message = "Search Transaction Brand"),
            @ApiResponse(code = 404, message = "There are no registered Brands"),
            @ApiResponse(code = 500, message = "The requested operation could not be performed. Contact support and report the error")})
    @GetMapping("")
    ResponseEntity<List<BrandDTO>> getAllBrand(){
        return ResponseEntity.status(HttpStatus.OK).body(servicePort.getAllBrand());
    }
}
