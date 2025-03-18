package co.com.spike.spring.cloud.stream.kafka_stream_consumption.dto.streamdto;


import co.com.spike.spring.cloud.stream.kafka_stream_consumption.serdes.util.NullToIntegerDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdjustmentFlypass {
    @JsonProperty("CDAJUSTE")
    private long cdAjuste;

    @JsonProperty("CDPUNTO_ATENCION")
    private String cdPuntoAtencion;

    @JsonProperty("DSPLACA")
    private String dsPlaca;

    @JsonProperty("CDNUMERO_TRANSACCION")
    private String cdNumeroTransaccion;

    @JsonProperty("FEMOVIMIENTO")
    private String feMovimiento;

    @JsonProperty("DSSENTIDO")
    private String dsSentido;

    @JsonProperty("DSCATEGORIA")
    private String dsCategoria;

    @JsonProperty("DSSUBCATEGORIA")
    private String dsSubcategoria;

    @JsonProperty("VRPAGADO")
    private double vrPagado;

    @JsonProperty("CDTIPO_AJUSTE")
    @JsonDeserialize(using = NullToIntegerDeserializer.class)
    private Integer cdTipoAjuste;

    @JsonProperty("DSUSUARIO_AJUSTE")
    private String dsUsuarioAjuste;

    @JsonProperty("FEINGRESA_AJUSTE")
    private String feIngresaAjuste;

    @JsonProperty("SNPROCESADO")
    private String snProcesado;

    @JsonProperty("CDAJUSTE_FLYPASS")
    private long cdAjusteFlypass;

    @JsonProperty("FECONTABLE")
    private String feContable;

    @JsonProperty("CDUSUARIO_INGRESA")
    private int cdUsuarioIngresa;

    @JsonProperty("CDNUMERO_TRANSACCION_EXTERNA")
    private String cdNumeroTransaccionExterna;

    @JsonProperty("CDNRO_TRANS_REF_EXT")
    private String cdNroTransRefExt;

    @JsonProperty("CDMOTIVO_AJUSTE")
    private String cdMotivoAjuste;

    @JsonProperty("CDTIPO_OPERACION")
    private String cdTipoOperacion;

    @JsonProperty("CDOPERADOR")
    private String cdOperador;

    @JsonProperty("CDESTADO")
    private String cdEstado;

}
