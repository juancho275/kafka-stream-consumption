package co.com.spike.spring.cloud.stream.kafka_stream_consumption.dto.streamdto;


import co.com.spike.spring.cloud.stream.kafka_stream_consumption.serdes.util.NullToDoubleDeserializer;
import co.com.spike.spring.cloud.stream.kafka_stream_consumption.serdes.util.NullToIntegerDeserializer;
import co.com.spike.spring.cloud.stream.kafka_stream_consumption.serdes.util.NullToLongDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import lombok.Setter;


@Setter
public class MovementsAttentionsPointsConsultation {
    @JsonProperty("CDMOVIMIENTO")
    @JsonDeserialize(using = NullToLongDeserializer.class)
    private Long idMovimiento;

    @JsonProperty("CDPUNTO_ATENCION")
    private String idPuntoAtencion;

    @JsonProperty("CDVEHICULO")
    private String idVehiculo;

    @JsonProperty("VRPAGADO")
    @JsonDeserialize(using = NullToDoubleDeserializer.class)
    private Double valorPagado;

    @JsonProperty("CDTARIFA_PTO_AT")
    @JsonDeserialize(using = NullToLongDeserializer.class)
    private Long idTarifaPuntoAtencion;

    @JsonProperty("FEINICIO_MVTO")
    private String fechaInicioMovimiento;

    @JsonProperty("FEFIN_MVTO")
    private String fechaFinMovimiento;

    @JsonProperty("CDTIPO_MVTO")
    @JsonDeserialize(using = NullToIntegerDeserializer.class)
    private int idTipoMovimiento;

    @JsonProperty("DSSENTIDO")
    private String descripcionSentido;

    @JsonProperty("CDNUMERO_TRANSACCION")
    private String idNumeroTransaccion;

    @JsonProperty("CDFACTURA")
    @JsonDeserialize(using = NullToLongDeserializer.class)
    private Long idFactura;

    @JsonProperty("CDCARRIL")
    private String idCarril;

    @JsonProperty("SNMANUAL")
    private String esManual;

    @JsonProperty("SNPROCESADO")
    private String esProcesado;

    @JsonProperty("CDCIERRE")
    @JsonDeserialize(using = NullToLongDeserializer.class)
    private Long idCierre;

    @JsonProperty("SNAJUSTADO")
    private String esAjustado;

    @JsonProperty("CDUSUARIO_INGRESA")
    @JsonDeserialize(using = NullToLongDeserializer.class)
    private Long idUsuarioIngresa;

    @JsonProperty("FEINGRESA")
    private String fechaIngresa;

    @JsonProperty("CDUSUARIO_MODIFICA")
    @JsonDeserialize(using = NullToLongDeserializer.class)
    private Long idUsuarioModifica;

    @JsonProperty("FEMODIFICA")
    private String fechaModifica;

    @JsonProperty("VRVALOR_IVA")
    @JsonDeserialize(using = NullToLongDeserializer.class)
    private Long valorIva;

    @JsonProperty("CDITEM")
    @JsonDeserialize(using = NullToLongDeserializer.class)
    private Long idItem;

    @JsonProperty("CDFACTURA2")
    @JsonDeserialize(using = NullToLongDeserializer.class)
    private Long idFactura2;

    @JsonProperty("CDPOS")
    private String idPos;

    @JsonProperty("CDTIPOEJE")
    @JsonDeserialize(using = NullToLongDeserializer.class)
    private Integer idTipoEje;

    @JsonProperty("VRNUM_EJES")
    @JsonDeserialize(using = NullToLongDeserializer.class)
    private Long numEjes;

    @JsonProperty("SNCONCILIO")
    private String esConciliado;

    @JsonProperty("CDDETALLE_LOTE_CONCI")
    @JsonDeserialize(using = NullToLongDeserializer.class)
    private Long idDetalleLoteConciliacion;

    @JsonProperty("SNAJUSTE_PAGADO")
    private String esAjustePagado;

    @JsonProperty("FECONTABLE")
    private String fechaContable;

    @JsonProperty("CDDETALLE_CIERRE_USUARIO")
    @JsonDeserialize(using = NullToLongDeserializer.class)
    private Long idDetalleCierreUsuario;

    @JsonProperty("FEAPLICACION")
    private String fechaAplicacion;

    @JsonProperty("DSNRO_TAG")
    private String numeroTag;

    @JsonProperty("CDNUMERO_TRANSACCION_EXTERNA")
    private String idNumeroTransaccionExterna;

    @JsonProperty("CDNRO_TRANS_REF_EXT")
    private String idNumeroTransRefExterna;

    @JsonProperty("CDAJUSTE_FLYPASS")
    private String idAjusteFlypass;

    @JsonProperty("DSCATEGORIA")
    private String categoria;

    @JsonProperty("CDCONTROL_MVTO_EXT")
    @JsonDeserialize(using = NullToLongDeserializer.class)
    private Long idControlMovimientoExterno;

    @JsonProperty("CDCENTRO_COSTOS_USUARIO")
    @JsonDeserialize(using = NullToLongDeserializer.class)
    private Long idCentroCostosUsuario;

    @JsonProperty("CDMVTO_CTA_BANCO")
    @JsonDeserialize(using = NullToLongDeserializer.class)
    private Long idMovimientoCuentaBanco;

    @JsonProperty("CDTIPO_PAGO")
    @JsonDeserialize(using = NullToLongDeserializer.class)
    private long idTipoPago;

    @JsonProperty("CDPAGO_EMPRESA")
    @JsonDeserialize(using = NullToLongDeserializer.class)
    private Long idPagoEmpresa;

    @JsonProperty("SNCOMISION_PROCESADA")
    private String esComisionProcesada;

    @JsonProperty("CDMVTO_CTA_COMISION")
    @JsonDeserialize(using = NullToLongDeserializer.class)
    private Long idMovimientoCuentaComision;

    @JsonProperty("DSCATEGORIA_DETEC_AUTO")
    private String categoriaDeteccionAutomatica;

    @JsonProperty("CDTIPO_LECTURA")
    @JsonDeserialize(using = NullToLongDeserializer.class)
    private long idTipoLectura;

    @JsonProperty("CDOPERADOR")
    @JsonDeserialize(using = NullToLongDeserializer.class)
    private Long idOperador;

    @JsonProperty("DSESTACION")
    private String estacion;

    @JsonProperty("DSPLACA_OCR")
    private String placaOcr;

    @JsonProperty("CDCONCILIACION")
    @JsonDeserialize(using = NullToLongDeserializer.class)
    private Long idConciliacion;

    @JsonProperty("CDMODALIDAD_PAGO_MVTO")
    @JsonDeserialize(using = NullToLongDeserializer.class)
    private long idModalidadPagoMovimiento;

    @JsonProperty("CDLISTA_MINISTERIO")
    @JsonDeserialize(using = NullToLongDeserializer.class)
    private Long idListaMinisterio;

    @JsonProperty("CDUSUARIO")
    @JsonDeserialize(using = NullToLongDeserializer.class)
    private Long idUsuario;

    public Long getIdMovimiento() {
        return idMovimiento;
    }

    public String getIdPuntoAtencion() {
        return idPuntoAtencion;
    }

    public String getIdVehiculo() {
        return idVehiculo;
    }

    public Double getValorPagado() {
        return valorPagado;
    }

    public Long getIdTarifaPuntoAtencion() {
        return idTarifaPuntoAtencion;
    }

    public String getFechaInicioMovimiento() {
        return fechaInicioMovimiento;
    }

    public String getFechaFinMovimiento() {
        return fechaFinMovimiento;
    }

    public int getIdTipoMovimiento() {
        return idTipoMovimiento;
    }

    public String getDescripcionSentido() {
        return descripcionSentido;
    }

    public String getIdNumeroTransaccion() {
        return idNumeroTransaccion;
    }

    public Long getIdFactura() {
        return idFactura;
    }

    public String getIdCarril() {
        return idCarril;
    }

    public String getEsManual() {
        return esManual;
    }

    public String getEsProcesado() {
        return esProcesado;
    }

    public Long getIdCierre() {
        return idCierre;
    }

    public String getEsAjustado() {
        return esAjustado;
    }

    public Long getIdUsuarioIngresa() {
        return idUsuarioIngresa;
    }

    public String getFechaIngresa() {
        return fechaIngresa;
    }

    public Long getIdUsuarioModifica() {
        return idUsuarioModifica;
    }

    public String getFechaModifica() {
        return fechaModifica;
    }

    public Long getValorIva() {
        return valorIva;
    }

    public Long getIdItem() {
        return idItem;
    }

    public Long getIdFactura2() {
        return idFactura2;
    }

    public String getIdPos() {
        return idPos;
    }

    public Integer getIdTipoEje() {
        return idTipoEje;
    }

    public Long getNumEjes() {
        return numEjes;
    }

    public String getEsConciliado() {
        return esConciliado;
    }

    public Long getIdDetalleLoteConciliacion() {
        return idDetalleLoteConciliacion;
    }

    public String getEsAjustePagado() {
        return esAjustePagado;
    }

    public String getFechaContable() {
        return fechaContable;
    }

    public Long getIdDetalleCierreUsuario() {
        return idDetalleCierreUsuario;
    }

    public String getFechaAplicacion() {
        return fechaAplicacion;
    }

    public String getNumeroTag() {
        return numeroTag;
    }

    public String getIdNumeroTransaccionExterna() {
        return idNumeroTransaccionExterna;
    }

    public String getIdNumeroTransRefExterna() {
        return idNumeroTransRefExterna;
    }

    public String getIdAjusteFlypass() {
        return idAjusteFlypass;
    }

    public String getCategoria() {
        return categoria;
    }

    public Long getIdControlMovimientoExterno() {
        return idControlMovimientoExterno;
    }

    public Long getIdCentroCostosUsuario() {
        return idCentroCostosUsuario;
    }

    public Long getIdMovimientoCuentaBanco() {
        return idMovimientoCuentaBanco;
    }

    public long getIdTipoPago() {
        return idTipoPago;
    }

    public Long getIdPagoEmpresa() {
        return idPagoEmpresa;
    }

    public String getEsComisionProcesada() {
        return esComisionProcesada;
    }

    public Long getIdMovimientoCuentaComision() {
        return idMovimientoCuentaComision;
    }

    public String getCategoriaDeteccionAutomatica() {
        return categoriaDeteccionAutomatica;
    }

    public long getIdTipoLectura() {
        return idTipoLectura;
    }

    public Long getIdOperador() {
        return idOperador;
    }

    public String getEstacion() {
        return estacion;
    }

    public String getPlacaOcr() {
        return placaOcr;
    }

    public Long getIdConciliacion() {
        return idConciliacion;
    }

    public long getIdModalidadPagoMovimiento() {
        return idModalidadPagoMovimiento;
    }

    public Long getIdListaMinisterio() {
        return idListaMinisterio;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }
}