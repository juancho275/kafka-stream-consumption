package co.com.spike.spring.cloud.stream.kafka_stream_consumption.dto.streamdto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Vehicles {
    @JsonProperty("CDVEHICULO")
    private Integer vehicleId;

    @JsonProperty("CDUSUARIO")
    private Integer userId;

    @JsonProperty("DSPLACA")
    private String plate;

    @JsonProperty("CDCONFIGURACION")
    private Integer configurationId;

    @JsonProperty("CDMARCA")
    private Integer brandId;

    @JsonProperty("CDCOLOR")
    private Integer colorId;

    @JsonProperty("CDTIPO_MATRICULA")
    private Integer registrationTypeId;

    @JsonProperty("NMNRO_MATRICULA")
    private String registrationNumber;

    @JsonProperty("DSNOMBRE_MATRICULA")
    private String registrationName;

    @JsonProperty("SNPAZ_Y_SALVO")
    private String peaceAndSafe;

    @JsonProperty("SNROBADO")
    private String stolen;

    @JsonProperty("CDESTADO")
    private Integer statusId;

    @JsonProperty("FESUSPENSION")
    private String suspensionDate;

    @JsonProperty("FELIBERACION")
    private String releaseDate;

    @JsonProperty("SNEXENTO")
    private String exempt;

    @JsonProperty("CDUSUARIO_INGRESA")
    private Integer userIngressId;

    @JsonProperty("FEINGRESA")
    private String ingressDate;

    @JsonProperty("CDUSUARIO_MODIFICA")
    private Integer userModifyId;

    @JsonProperty("FEMODIFICA")
    private String modifyDate;

    @JsonProperty("FEACTIVACION")
    private String activationDate;

    @JsonProperty("CDMARCAS_SERIES")
    private String brandSeries;

    @JsonProperty("FEVENCIMIENTO_SOAT")
    private String soatExpiryDate;

    @JsonProperty("DSMODELO")
    private String model;

    @JsonProperty("FEULTIMA_ACTUALIZACION")
    private String lastUpdateDate;

    @JsonProperty("SNSOAT_CARGADO")
    private String soatLoaded;

    @JsonProperty("CDCENTRO_COSTOS_USUARIO")
    private String userCostCenterId;

    @JsonProperty("DSCORREO")
    private String email;

    @JsonProperty("NMINTENTOS_ASIGNAR_TAG")
    private Integer assignTagAttempts;

    @JsonProperty("SNVALIDADO_RUNT")
    private String runtValidated;

    @JsonProperty("FEULTIMA_VALIDACION_RUNT")
    private String lastRuntValidationDate;

    @JsonProperty("SNPEND_EXTRA_VALIDACION_CONFIG")
    private String pendingExtraConfigValidation;

    @JsonProperty("CDENVIO_PARQUEOO")
    private String sendParkId;

    @JsonProperty("SNVEHICULO_NO_IDENTIFICADO")
    private String snVehiculoNoIdentificado;

    public Vehicles() {
    }
}
