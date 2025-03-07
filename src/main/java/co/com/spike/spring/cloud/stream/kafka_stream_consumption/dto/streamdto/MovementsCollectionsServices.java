package co.com.spike.spring.cloud.stream.kafka_stream_consumption.dto.streamdto;


import co.com.spike.spring.cloud.stream.kafka_stream_consumption.serdes.util.NullToDoubleDeserializer;
import co.com.spike.spring.cloud.stream.kafka_stream_consumption.serdes.util.NullToIntegerDeserializer;
import co.com.spike.spring.cloud.stream.kafka_stream_consumption.serdes.util.NullToLongDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;


@Getter
public class MovementsCollectionsServices {
    @JsonProperty("CDMVTO_COBRO_SERVICIO")
    @JsonDeserialize(using = NullToLongDeserializer.class)
    private Long idMvtoCobroServicio;

    @JsonProperty("CDVEHICULO")
    private String idVehiculo;

    @JsonProperty("DSPLACA_OCR")
    private String dsPlacaOcr;

    @JsonProperty("FECOBRO")
    private String feCobro;

    @JsonProperty("FECONTABLE")
    private String feContable;

    @JsonProperty("CDNUMERO_TRANSACCION_EXTERNA")
    private String cdNumeroTransaccionExterna;

    @JsonProperty("CDPUNTO_ATENCION_SER")
    private String cdPuntoAtencionSer;

    @JsonProperty("NMFACTURA_EXTERNA")
    private String nmFacturaExterna;

    @JsonProperty("DSRESOLUCION_FACTURA")
    private String dsResolucionFactura;

    @JsonProperty("VRCOBRO")
    @JsonDeserialize(using = NullToDoubleDeserializer.class)
    private Double vrCobro;

    @JsonProperty("VRIMPUESTO")
    @JsonDeserialize(using = NullToDoubleDeserializer.class)
    private Double vrImpuesto;

    @JsonProperty("CDTIPO_LECTURA")
    @JsonDeserialize(using = NullToIntegerDeserializer.class)
    private Integer cdTipoLectura;

    @JsonProperty("FEULTIMA_ACTUALIZACION")
    private String feUltimaActualizacion;

    @JsonProperty("DSCODIGO_LISTA")
    private String dsCodigoLista;

    @JsonProperty("SNDISCREPANCIA_PLACA")
    private String snDiscrepanciaPlaca;

    @JsonProperty("SNPROCESADO")
    private String snProcesado;

    @JsonProperty("FEAPLICACION")
    private String feAplicacion;

    @JsonProperty("CDUSUARIO_INGRESA")
    @JsonDeserialize(using = NullToLongDeserializer.class)
    private Long cdUsuarioIngresa;

    @JsonProperty("FEINGRESA")
    private String feIngresa;

    @JsonProperty("CDUSUARIO_MODIFICA")
    @JsonDeserialize(using = NullToLongDeserializer.class)
    private Long cdUsuarioModifica;

    @JsonProperty("FEMODIFICA")
    private String feModifica;

    @JsonProperty("CDESTADO")
    @JsonDeserialize(using = NullToIntegerDeserializer.class)
    private Integer cdEstado;

    @JsonProperty("CDAJUSTES_COBRO_SERVICIOS")
    @JsonDeserialize(using = NullToLongDeserializer.class)
    private Long cdAjustesCobroServicios;

    @JsonProperty("CDFACTURA")
    @JsonDeserialize(using = NullToLongDeserializer.class)
    private Long cdFactura;

    @JsonProperty("CDITEM")
    private Long cdItem;

    @JsonProperty("CDCENTRO_COSTOS_USUARIO")
    @JsonDeserialize(using = NullToLongDeserializer.class)
    private Long cdCentroCostosUsuario;

    @JsonProperty("CDDETALLE_CIERRE_USUARIO")
    @JsonDeserialize(using = NullToLongDeserializer.class)
    private Long cdDetalleCierreUsuario;

    @JsonProperty("CDNUMERO_TRANSACCION")
    private String cdNumeroTransaccion;

    @JsonProperty("SNAJUSTADO")
    private String snAjustado;

    @JsonProperty("CDTIPO_PAGO")
    @JsonDeserialize(using = NullToIntegerDeserializer.class)
    private Integer cdTipoPago;

    @JsonProperty("CDTIPO_MVTO")
    @JsonDeserialize(using = NullToIntegerDeserializer.class)
    private Integer cdTipoMvto;

    @JsonProperty("CDMVTO_CTA_BANCO")
    @JsonDeserialize(using = NullToLongDeserializer.class)
    private Long cdMvtoCtaBanco;

    @JsonProperty("CDCODIGO_AUTORIZACION")
    @JsonDeserialize(using = NullToLongDeserializer.class)
    private Long cdCodigoAutorizacion;

    @JsonProperty("CDMVTO_CTA_DEVOLUCION")
    @JsonDeserialize(using = NullToLongDeserializer.class)
    private Long cdMvtoCtaDevolucion;

    @JsonProperty("CDCONCILIACION")
    @JsonDeserialize(using = NullToLongDeserializer.class)
    private Long cdConciliacion;

    @JsonProperty("CDLISTA_PARQUEADERO")
    @JsonDeserialize(using = NullToLongDeserializer.class)
    private Long cdListaParqueadero;

    @JsonProperty("CDMVTO_CTA_COMISION")
    @JsonDeserialize(using = NullToLongDeserializer.class)
    private Long cdMvtoCtaComision;

    @JsonProperty("SNACTIVAR_DEB_MENSU_NOTIFICADO")
    private String snActivarDebMensuNotificado;

    @JsonProperty("SNBIENVENIDA_NOTIFICADO")
    private String snBienvenidaNotificado;

    @JsonProperty("SNCOBRO_MENSUALIDAD_NOTIFICADO")
    private String snCobroMensualidadNotificado;

    @JsonProperty("SNMANDATO_FACTURA")
    private String snMandatoFactura;

    @JsonProperty("VRCOBRO_COMISION")
    @JsonDeserialize(using = NullToLongDeserializer.class)
    private Long vrCobroComision;

    @JsonProperty("VRCOBRO_TOTAL")
    @JsonDeserialize(using = NullToLongDeserializer.class)
    private Long vrCobroTotal;

    @JsonProperty("VRCOMISION_SERVICIO_FLYPASS")
    @JsonDeserialize(using = NullToLongDeserializer.class)
    private Long vrComisionServicioFlypass;

    @JsonProperty("SNREGISTRO_NIFI")
    private String snRegistroNifi;

}
