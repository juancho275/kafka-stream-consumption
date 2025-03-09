package co.com.spike.spring.cloud.stream.kafka_stream_consumption.dto.streamdto;


import co.com.spike.spring.cloud.stream.kafka_stream_consumption.serdes.util.NullToIntegerDeserializer;
import co.com.spike.spring.cloud.stream.kafka_stream_consumption.serdes.util.NullToLongDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;

@Getter
public class AttentionPoint {

    @JsonProperty("CDPUNTO_ATENCION")
    @JsonDeserialize(using = NullToIntegerDeserializer.class)
    private Integer attentionPointId;

    @JsonProperty("CDEMPRESA")
    @JsonDeserialize(using = NullToIntegerDeserializer.class)
    private Integer company;

    @JsonProperty("DSPUNTO_ATENCION")
    private String attentionPointName;

    @JsonProperty("CDTIPO_PUNTO")
    @JsonDeserialize(using = NullToIntegerDeserializer.class)
    private Integer pointType;

    @JsonProperty("CDCIUDAD")
    @JsonDeserialize(using = NullToIntegerDeserializer.class)
    private Integer city;

    @JsonProperty("DSDIRECCION")
    private String address;

    @JsonProperty("DSNOMBRE_CONTACTO")
    private String contactName;

    @JsonProperty("DSTELEFONO_CONTACTO")
    private String contactPhone;

    @JsonProperty("DSCELULAR_CONTACTO")
    private String contactCellphone;

    @JsonProperty("CDESTADO")
    @JsonDeserialize(using = NullToIntegerDeserializer.class)
    private Integer state;

    @JsonProperty("CDCODIGO")
    private String code;

    @JsonProperty("DSNOMBRE_NODO")
    private String nodeName;

    @JsonProperty("CDUSUARIO_INGRESA")
    private Long userEntered;

    @JsonProperty("FEINGRESA")
    private String enterDate;

    @JsonProperty("CDUSUARIO_MODIFICA")
    @JsonDeserialize(using = NullToLongDeserializer.class)
    private Long userModified;

    @JsonProperty("FEMODIFICA")
    private String modificationDate;

    @JsonProperty("HORA_CORTE")
    private String cutoffTime;

    @JsonProperty("NMMINIMO_PASOS")
    @JsonDeserialize(using = NullToIntegerDeserializer.class)
    private Integer minimumSteps;

    @JsonProperty("CDTIPO_SINCRONIZACION")
    @JsonDeserialize(using = NullToIntegerDeserializer.class)
    private Integer synchronizationType;

    @JsonProperty("CDPUNTO_ATENCION_EXTERNO")
    private String externalAttentionPoint;

    @JsonProperty("DSESTACION")
    private String station;

    @JsonProperty("SNVISIBLE")
    private String isVisible;

    @JsonProperty("SNCERT_TERCERO")
    private String isThirdPartyCertified;

    @JsonProperty("DSNOMBRE_MOSTRAR")
    private String displayableName;

    @JsonProperty("CDOPERADOR")
    @JsonDeserialize(using = NullToIntegerDeserializer.class)
    private Integer operatorId;

    @JsonProperty("SNSINCRONIZADO_QUEUE")
    private String isQueueSynchronized;
}