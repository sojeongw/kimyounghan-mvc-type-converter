package hello.typeconverter.typeconverter.converter;

import hello.typeconverter.converter.IntegerToStringConverter;
import hello.typeconverter.converter.IpPortToStringConverter;
import hello.typeconverter.converter.StringToIntegerConverter;
import hello.typeconverter.converter.StringToIpPortConverter;
import org.junit.jupiter.api.Test;
import hello.typeconverter.type.IpPort;

import static org.assertj.core.api.Assertions.*;

class ConverterTest {

    @Test
    void stringToIpPort() {
        StringToIpPortConverter converter = new StringToIpPortConverter();

        String source = "127.0.0.1:8080";
        IpPort result = converter.convert(source);

        assertThat(result).isEqualTo(new IpPort("127.0.0.1", 8080));
    }
    @Test
    void ipPortToString() {
        IpPortToStringConverter converter = new IpPortToStringConverter();

        IpPort source = new IpPort("127.0.0.1", 8080);
        String result = converter.convert(source);

        assertThat(result).isEqualTo("127.0.0.1:8080");
    }

    @Test
    void stringToInteger() {
        StringToIntegerConverter converter = new StringToIntegerConverter();
        Integer result = converter.convert("10");
        assertThat(result).isEqualTo(10);
    }

    @Test
    void integerToString() {
        IntegerToStringConverter converter = new IntegerToStringConverter();
        String result = converter.convert(10);
        assertThat(result).isEqualTo("10");
    }
}
