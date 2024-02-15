package test;

import org.springframework.integration.file.DefaultFileNameGenerator;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;

public class CustomFileNameGenerator extends DefaultFileNameGenerator {
    @Override
    public String generateFileName(Message<?> message) {
        MessageHeaders headers = message.getHeaders();
        String originalFileName = headers.get("file_name", String.class);
        if (originalFileName != null) {
            return originalFileName.replaceAll("\\.xml$", ".json");
        } else {
            return "test.json";
        }
    }
}
