package co.com.spike.spring.cloud.stream.kafka_stream_consumption.dto.streamdto;


import co.com.spike.spring.cloud.stream.kafka_stream_consumption.serdes.util.NullToIntegerDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;

@Getter
public class ServiceChargeAdjustment {
    @JsonProperty("CDAJUSTES_COBRO_SERVICIOS")
    private String cdAjustesCobroServicios;

    @JsonProperty("CDNUMERO_TRANSACCION_EXTERNA")
    private String cdNumeroTransaccionExterna;

    @JsonProperty("CDPUNTO_ATENCION_SER")
    private int cdPuntoAtencionSer;

    @JsonProperty("CDMOTIVO_CANCELACION")
    private String cdMotivoCancelacion;

    @JsonProperty("CDTIPO_AJUSTE")
    @JsonDeserialize(using = NullToIntegerDeserializer.class)
    private Integer cdTipoAjuste;

    @JsonProperty("SNPROCESADO")
    private String snProcesado;

    @JsonProperty("VRPAGADO")
    private double vrPagado;

    @JsonProperty("DSOBSERVACION")
    private String dsObservacion;

    @JsonProperty("CDUSUARIO_INGRESA")
    private int cdUsuarioIngresa;

    @JsonProperty("FEINGRESA")
    private String feIngresa;

    @JsonProperty("CDUSUARIO_MODIFICA")
    private String cdUsuarioModifica;

    @JsonProperty("FEMODIFICA")
    private String feModifica;

    @JsonProperty("CDNUMERO_TRANSACCION")
    private String cdNumeroTransaccion;

    @JsonProperty("SNAJUSTE_CONCILIACION")
    private String snAjusteConciliacion;

    @JsonProperty("CDTIPO_PERSONA")
    private String cdTipoPersona;

    @JsonProperty("DSCATEGORIA")
    private String dsCategoria;

}
