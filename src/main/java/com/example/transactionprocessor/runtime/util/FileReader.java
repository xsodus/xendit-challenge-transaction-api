package com.example.transactionprocessor.runtime.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.springframework.stereotype.Component;

@Component
public class FileReader {

    /**
     * Returns file contents as a string under the resources/requests folder.
     *
     * @param requestSubPath Path to the file from resources/requests folder
     * @return File contents as a string
     */
    public String getRequest(String requestSubPath) {
        return getFile("requests/" + requestSubPath);
    }

    /**
     * Returns file contents as a string under the rescources/requests folder.
     *
     * @param responseSubPath Path to the file from resources/responses folder
     * @return File contents as a string
     */
    public String getResponse(String responseSubPath) {
        return getFile("responses/" + responseSubPath);
    }

    /**
     * Returns file contents as a string under the rescources folder.
     *
     * @param fullPath Path to the file from resources folder
     * @return File contents as a string
     */
    public String getClasspathResource(String fullPath) {
        return getFile(fullPath);
    }

    public String getFile(String path) {
        try (
                var inputStream = getClass().getClassLoader().getResourceAsStream(path);
                BufferedReader buffReader = new BufferedReader(new InputStreamReader(inputStream));
        ) {

            String line;
            StringBuilder stringBuffer = new StringBuilder();
            while ((line = buffReader.readLine()) != null) {
                stringBuffer.append(line);
            }

            return stringBuffer.toString();
        } catch (IOException | NullPointerException ex) {
            throw new IllegalArgumentException("Could not read file " + path);
        }
    }
}
