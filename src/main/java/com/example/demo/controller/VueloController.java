package com.example.demo.controller;

import com.example.demo.domain.Vuelo;
import com.example.demo.exception.VueloNotFoundException;
import com.example.demo.service.VueloService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.Set;

import static com.example.demo.controller.Response.NOT_FOUND;


@RequestMapping("/vuelos")
@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class VueloController {

    @Autowired
    private VueloService vueloService;

    @Operation(summary = "Obtiene el listado de vuelos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Listado de vuelos",
                    content = @Content(array = @ArraySchema(schema =
                    @Schema(implementation = Vuelo.class)))),
    })
    @GetMapping("/origen")
    public ResponseEntity<Set<Vuelo>> getVuelos(@RequestParam(value = "origen", defaultValue = "") String origen) {
        Set<Vuelo> vuelos = null;
        if (origen.equals(""))
            vuelos = vueloService.findAll();
        else
            vuelos = vueloService.findByOrigen(origen);

        return new ResponseEntity<>(vuelos, HttpStatus.OK);
    }
    @Operation(summary = "Obtiene un vuelo determinado por destino")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Existe el destino del vuelo", content = @Content(schema = @Schema(implementation =
                    Vuelo.class))),
            @ApiResponse(responseCode = "404", description = "El vuelo no existe", content = @Content(schema = @Schema(implementation =
                    Response.class)))
    })


    @GetMapping("/destino")
    public ResponseEntity<Set<Vuelo>> getVuelosByDestino(@RequestParam(value = "destino", defaultValue = "") String destino) {
        Set<Vuelo> vuelos = null;
        if (!destino.equals(""))
            vuelos = vueloService.findByDestino(destino);

        return new ResponseEntity<>(vuelos, HttpStatus.OK);
    }



    @Operation(summary = "Obtiene un vuelo determinado por companyia")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Existe los numescalas del vuelo", content = @Content(schema = @Schema(implementation =
                    Vuelo.class))),
            @ApiResponse(responseCode = "404", description = "El vuelo no existe", content = @Content(schema = @Schema(implementation =
                    Response.class)))
    })


    @GetMapping("/companyia")
    public ResponseEntity<Set<Vuelo>> getVuelosByCompanyia(@RequestParam(value = "companyia", defaultValue = "") String companyia) {
        Set<Vuelo> vuelos = null;
        if (!companyia.equals(""))
            vuelos = vueloService.findByCompanyia(companyia);

        return new ResponseEntity<>(vuelos, HttpStatus.OK);
    }



    @Operation(summary = "Obtiene un vuelo determinado por su precio")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Existe los numescalas del vuelo", content = @Content(schema = @Schema(implementation =
                    Vuelo.class))),
            @ApiResponse(responseCode = "404", description = "El vuelo no existe", content = @Content(schema = @Schema(implementation =
                    Response.class)))
    })

    @GetMapping("/precio")
    public ResponseEntity<Set<Vuelo>> getVuelosByPrecio(@RequestParam(value = "precio", defaultValue = "") float precio) {
        Set<Vuelo> vuelos = null;
        if (precio!=0)
            vuelos = vueloService.findByPrecio(precio);

        return new ResponseEntity<>(vuelos, HttpStatus.OK);
    }

    @Operation(summary = "Obtiene un vuelo determinado por su fecha inicio")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Existe los numescalas del vuelo", content = @Content(schema = @Schema(implementation =
                    Vuelo.class))),
            @ApiResponse(responseCode = "404", description = "El vuelo no existe", content = @Content(schema = @Schema(implementation =
                    Response.class)))
    })

    @GetMapping("/fechainicio")
    public ResponseEntity<Set<Vuelo>> getVuelosByFechaInicio(@RequestParam(value = "fechainicio", defaultValue = "") String fechainicio){
        Set<Vuelo> vuelos = null;

        if (!fechainicio.equals("")) {
            vuelos = vueloService.findByFechainicio(fechainicio);

        }

        return new ResponseEntity<>(vuelos, HttpStatus.OK);
    }

    @Operation(summary = "Obtiene un vuelo determinado por su fecha fin")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Existe los numescalas del vuelo", content = @Content(schema = @Schema(implementation =
                    Vuelo.class))),
            @ApiResponse(responseCode = "404", description = "El vuelo no existe", content = @Content(schema = @Schema(implementation =
                    Response.class)))
    })

    @GetMapping("/fechafin")
    public ResponseEntity<Set<Vuelo>> getVuelosByfechafin(@RequestParam(value = "fechafin", defaultValue = "") String fechafin){
        Set<Vuelo> vuelos = null;

        if (!fechafin.equals("")) {
            vuelos = vueloService.findByfechafin(fechafin);
        }


        return new ResponseEntity<>(vuelos, HttpStatus.OK);
    }

    @Operation(summary = "Obtiene un vuelo determinado por id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Existe el destino del vuelo", content = @Content(schema = @Schema(implementation =
                    Vuelo.class))),
            @ApiResponse(responseCode = "404", description = "El vuelo no existe", content = @Content(schema = @Schema(implementation =
                    Response.class)))
    })



    @GetMapping("/{id}")
    public ResponseEntity<Vuelo> getVuelo(@PathVariable long id) {
        Vuelo vuelo = vueloService.findById(id)
                .orElseThrow(() -> new VueloNotFoundException(id));

        return new ResponseEntity<>(vuelo, HttpStatus.OK);
    }
    @Operation(summary = "Anyade un vuelo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Listado de vuelos",
                    content = @Content(array = @ArraySchema(schema =
                    @Schema(implementation = Vuelo.class)))),
    })

    @PostMapping("/vuelosAdd")
    public ResponseEntity<Vuelo> addVuelo(@RequestBody Vuelo vuelo) {
        Vuelo addedVuelo = vueloService.addVuelo(vuelo);
        return new ResponseEntity<>(addedVuelo, HttpStatus.OK);
    }


    @Operation(summary = "Obtiene un vuelo y lo modifica")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Existe el destino del vuelo", content = @Content(schema = @Schema(implementation =
                    Vuelo.class))),
            @ApiResponse(responseCode = "404", description = "El vuelo no existe", content = @Content(schema = @Schema(implementation =
                    Response.class)))
    })


    @PutMapping("/vuelosmodificar/{id}")
    public ResponseEntity<Vuelo> modifyVuelo(@PathVariable long id, @RequestBody Vuelo newVuelo) {
        Vuelo product = vueloService.modifyVuelo(id, newVuelo);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }



    @Operation(summary = "Elimina un vuelo por la id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Existe el destino del vuelo", content = @Content(schema = @Schema(implementation =
                    Vuelo.class))),
            @ApiResponse(responseCode = "404", description = "El vuelo no existe", content = @Content(schema = @Schema(implementation =
                    Response.class)))
    })


    @DeleteMapping("/vuelosDelete/{id}")
    public ResponseEntity<com.example.demo.controller.Response> deleteVuelo(@PathVariable long id) {
        vueloService.deleteVuelo(id);
        return new ResponseEntity<>(com.example.demo.controller.Response.noErrorResponse(), HttpStatus.OK);
    }


    @Operation(summary = "Elimina todos los vuelos por destino")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Existe el destino del vuelo", content = @Content(schema = @Schema(implementation =
                    Vuelo.class))),
            @ApiResponse(responseCode = "404", description = "El vuelo no existe", content = @Content(schema = @Schema(implementation =
                    Response.class)))
    })


    @DeleteMapping("/vuelosDelete/destino")
    public ResponseEntity<com.example.demo.controller.Response> deleteByDestino(@RequestParam(value = "destino", defaultValue = "") String destino) {
        vueloService.deleteByDestino(destino);
        return new ResponseEntity<>(com.example.demo.controller.Response.noErrorResponse(), HttpStatus.OK);
    }



    @ExceptionHandler(VueloNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<com.example.demo.controller.Response> handleException(VueloNotFoundException pnfe) {
        com.example.demo.controller.Response response = com.example.demo.controller.Response.errorResonse(NOT_FOUND, pnfe.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }





}