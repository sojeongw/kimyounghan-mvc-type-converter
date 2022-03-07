package hello.typeconverter.typeconverter.converter;

import converter.IntegerToStringConverter;
import converter.IpPortToStringConverter;
import converter.StringToIntegerConverter;
import converter.StringToIpPortConverter;
import org.junit.jupiter.api.Test;
import org.springframework.core.convert.support.DefaultConversionService;
import type.IpPort;

import static org.assertj.core.api.Assertions.assertThat;

public class ConversionServiceTest {

    @Test
    void conversionService() {
        // 만들어 둔 컨버터를 등록한다.
        DefaultConversionService conversionService = new DefaultConversionService();

        conversionService.addConverter(new IntegerToStringConverter());
        conversionService.addConverter(new StringToIntegerConverter());
        conversionService.addConverter(new IpPortToStringConverter());
        conversionService.addConverter(new StringToIpPortConverter());

        Integer result = conversionService.convert("10", Integer.class);
        assertThat(result).isEqualTo(10);

        IpPort ipPort = conversionService.convert("127.0.0.1:8080", IpPort.class);
        assertThat(ipPort).isEqualTo(new IpPort("127.0.0.1", 8080));

        String ipPortString = conversionService.convert(new IpPort("127.0.0.1", 8080), String.class);
        assertThat(ipPortString).isEqualTo("127.0.0.1:8080");
    }
}
