package br.com.agence.fleet.vehicles.controller;

import br.com.agence.fleet.vehicles.domain.dto.EmployeeDTO;
import br.com.agence.fleet.vehicles.domain.response.EmployeeResponse;
import br.com.agence.fleet.vehicles.domain.port.adapter.EmployeeServicePort;
import br.com.agence.fleet.vehicles.domain.request.EmployeeRequest;
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
import java.util.List;

@RestController
@RequestMapping(ConstantsUrl.EMPLOYEE_URL)
public class EmployeeController {

    private EmployeeServicePort servicePort;

    public EmployeeController(EmployeeServicePort servicePort) {
        this.servicePort = servicePort;
    }

    @ApiOperation(value = "Create a new employee", notes = "Used to Create a new employee")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Employee created successfully"),
            @ApiResponse(code = 422, message = "Existing Employee, please provide another login to employee"),
            @ApiResponse(code = 500, message = "The requested operation could not be performed. Contact support and report the error")})
    @PostMapping()
    ResponseEntity<EmployeeDTO> createEmployee(@RequestBody EmployeeRequest request) throws NotFoundException {
        return ResponseEntity.status(HttpStatus.CREATED).body(servicePort.createEmployee(request));
    }
    
    @DeleteMapping("/{numberRegistration}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('ROLE_ADM')")
    public ResponseEntity<String> remover(@PathVariable String numberRegistration) throws NotFoundException {
        servicePort.removeEmployee(numberRegistration);
        return ResponseEntity.ok("Funcionário Removido com sucesso");
    }
    
    @ApiOperation(value = "Search All Employee", notes = "Used to Fetch Employees")
    @ApiResponses(value = {
            @ApiResponse(code = 202, message = "Search Transaction Employee"),
            @ApiResponse(code = 404, message = "There are no registered employees"),
            @ApiResponse(code = 500, message = "The requested operation could not be performed. Contact support and report the error")})
    @GetMapping("")
    ResponseEntity<List<EmployeeResponse>> getAllEmployee() {
        return ResponseEntity.status(HttpStatus.OK).body(servicePort.getAllEmployee());
    }
}
