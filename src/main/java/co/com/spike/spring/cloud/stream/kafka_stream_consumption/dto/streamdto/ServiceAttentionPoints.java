package co.com.spike.spring.cloud.stream.kafka_stream_consumption.dto.streamdto;


import co.com.spike.spring.cloud.stream.kafka_stream_consumption.serdes.util.NullToBigDecimalDeserializer;
import co.com.spike.spring.cloud.stream.kafka_stream_consumption.serdes.util.NullToLongDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class ServiceAttentionPoints {

    @JsonProperty("CDPUNTO_ATENCION_SER")
    private Integer attentionPointServiceId;

    @JsonProperty("CDEMPRESA")
    private Integer companyService;

    @JsonProperty("DSPUNTO_ATENCION")
    private String attentionPointNameService;

    @JsonProperty("CDTIPO_PUNTO")
    private Integer pointTypeService;

    @JsonProperty("CDCIUDAD")
    private Integer cityService;

    @JsonProperty("DSDIRECCION")
    private String addressService;

    @JsonProperty("DSNOMBRE_CONTACTO")
    private String contactNameService;

    @JsonProperty("DSTELEFONO_CONTACTO")
    private String contactPhoneService;

    @JsonProperty("DSCELULAR_CONTACTO")
    private String contactCellphoneService;

    @JsonProperty("CDESTADO")
    private Integer stateService;

    @JsonProperty("CDCODIGO")
    private String code;

    @JsonProperty("CDUSUARIO_INGRESA")
    @JsonDeserialize(using = NullToLongDeserializer.class)
    private Long userEntered;

    @JsonProperty("FEINGRESA")
    private String enterDate;

    @JsonProperty("CDUSUARIO_MODIFICA")
    @JsonDeserialize(using = NullToLongDeserializer.class)
    private Long userModified;

    @JsonProperty("FEMODIFICA")
    private String modificationDate;

    @JsonProperty("SALDO_MINIMO_TRANSACCION")
    private BigDecimal minimumPayment;

    @JsonProperty("SNEXPONESERVICIO")
    private String isExposeService;

    @JsonProperty("DSENDPOINT")
    private String endpoint;

    @JsonProperty("SNCIFRADO")
    private String isEncryption;

    @JsonProperty("CDAUTORIZACION")
    private String authorization;

    @JsonProperty("VRCOMISION_PYP")
    private Long commissionRechargeAutomatic;

    @JsonProperty("VRCOMISION_SALDO")
    private Long commissionRechargeManual;

    @JsonProperty("SNNOTIFICA_INGRESO_USUARIOS")
    private String isUserEntryNotification;

    @JsonProperty("SNNOTIFICA_ACTIVAR_DEB_AUT_MEN")
    private String isUserDebitAutomaticActivationNotification;

    @JsonProperty("SNVALIDA_OTP")
    private String isOtpValidation;

    @JsonProperty("CDTERCERO")
    private String thirdParty;

    @JsonProperty("SNMANEJAPP")
    private String isAppManagement;

    @JsonProperty("SNPILOTO")
    private String isPilot;

    @JsonProperty("VRCOBRO_MAXIMO")
    @JsonDeserialize(using = NullToBigDecimalDeserializer.class)
    private BigDecimal maximumPayment;

    @JsonProperty("SNMONITOREA")
    private String isMonitoring;

    @JsonProperty("SNFIONNA")
    private String isFionna;

    @JsonProperty("VRENVIO_PAGO_AUTOMATICO")
    @JsonDeserialize(using = NullToLongDeserializer.class)
    private Long automaticPaymentSending;

    @JsonProperty("NMDIAS_CERRAR_MVTO")
    @JsonDeserialize(using = NullToLongDeserializer.class)
    private Integer daysToCloseMovement;

    @JsonProperty("DSCONTRASENA")
    private String password;

    @JsonProperty("CDORIGEN")
    private Integer origin;

    @JsonProperty("CDCITYPARKING")
    @JsonDeserialize(using = NullToLongDeserializer.class)
    private Integer cityParking;

    @JsonProperty("SNSINCRONIZADO_QUEUE")
    private String isQueueSynchronized;

    @JsonProperty("CDPTO_AT_SER_IDS_TERCEROS")
    @JsonDeserialize(using = NullToLongDeserializer.class)
    private Integer thirdPartyAttentionPointIds;

    @JsonProperty("DSUSUARIO_AUTORIZACION")
    private String authorizationUser;

    @JsonProperty("SNPAGO_EN_LINEA")
    private String isOnlinePayment;
}