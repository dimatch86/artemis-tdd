package ru.gorchanyuk.artemis.tdd.config;

import org.junit.jupiter.api.Test;
import org.springframework.jms.support.converter.MarshallingMessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class ConverterConfigurationTest {

    private final ConverterConfiguration configuration = new ConverterConfiguration();

    @Test
    void testGetMessageConverter() {
        Marshaller marshaller = mock(Jaxb2Marshaller.class);

        MessageConverter converter = configuration.getMessageConverter(marshaller);

        assertInstanceOf(MarshallingMessageConverter.class, converter);
    }

    @Test
    void testGetMarshaller(){

        Marshaller marshaller = configuration.getMarshaller();

        assertInstanceOf(Jaxb2Marshaller.class, marshaller);
        String[] packagesToScan = ((Jaxb2Marshaller) marshaller).getPackagesToScan();
        assertNotNull(packagesToScan);
        assertEquals("ru.gorchanyuk.artemis.tdd.dto", packagesToScan[0]);
    }
}
