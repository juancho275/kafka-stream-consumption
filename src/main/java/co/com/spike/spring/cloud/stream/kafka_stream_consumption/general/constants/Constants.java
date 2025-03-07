package co.com.spike.spring.cloud.stream.kafka_stream_consumption.general.constants;

public class Constants {

    private Constants() {
        throw new IllegalStateException("Utility class");
    }

    public static final String TRANSACTION_TYPE = "CONSUMPTION";

    public static final String POCKET_NAME = "COP";
    public static final String CURRENCY_CODE = "Global";
    public static final String POCKET_ID = "1";
    public static final String EVENT_TYPE = "I";
    public static final String EVENT_NAME = "DEBIT_CONSUMPTION";
    public static final String DOMAIN_ENTITY = "WALLET";
    public static final String ORIGIN = "CONSUMPTION";
    public static final String TEXT_VALOR = " POR UN VALOR DE ";
    public static final String TEXT_TOLL = " POR EL PEAJE ";
    public static final String FLY_KEY_TYPE = "PLATE";


}
