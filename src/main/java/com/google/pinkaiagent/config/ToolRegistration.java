package com.google.pinkaiagent.config;

import com.google.pinkaiagent.tools.FileOperationTool;
import com.google.pinkaiagent.tools.PDFGenerationTool;
import com.google.pinkaiagent.tools.ResourceDownloadTool;
import com.google.pinkaiagent.tools.WebScrapingTool;
import org.springframework.ai.tool.ToolCallback;
import org.springframework.ai.tool.ToolCallbacks;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ToolRegistration {

    @Value("${search-api.api-key}")
    private String searchApiKey;

    @Bean
    public ToolCallback[] allTools() {
        FileOperationTool fileOperationTool = new FileOperationTool();
//        WebSearchTool webSearchTool = new WebSearchTool(searchApiKey);
        WebScrapingTool webScrapingTool = new WebScrapingTool();
        ResourceDownloadTool resourceDownloadTool = new ResourceDownloadTool();
//        TerminalOperationTool terminalOperationTool = new TerminalOperationTool();
        PDFGenerationTool pdfGenerationTool = new PDFGenerationTool();
        return ToolCallbacks.from(
            fileOperationTool,
//            webSearchTool,
            webScrapingTool,
            resourceDownloadTool,
//            terminalOperationTool,
            pdfGenerationTool
        );
    }
}
