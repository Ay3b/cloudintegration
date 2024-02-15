package test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.nio.file.Files;
import java.nio.file.Paths;

@Component
public class XmlToJsonTransformer {

    public Message<?> transformXmlToJson(Message<String> xmlMessage) throws Exception {
        String xmlFilePath = xmlMessage.getPayload();
        byte[] xmlData = Files.readAllBytes(Paths.get(xmlFilePath));

        XmlMapper xmlMapper = new XmlMapper();
        JsonNode node = xmlMapper.readTree(xmlData);
        ObjectMapper jsonMapper = new ObjectMapper();
        String json = jsonMapper.writeValueAsString(node);

        return MessageBuilder.withPayload(json)
                .copyHeadersIfAbsent(xmlMessage.getHeaders())
                .setHeader("file_name", xmlMessage.getHeaders().get("file_name").toString().replaceAll("\\.xml$", ".json"))
                .build();
    }
}
