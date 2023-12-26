package com.example.librarymanagementbackend;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
    @GetMapping("/")
    @ResponseBody
    public ResponseEntity<JsonNode> get() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode json = mapper.readTree("[\n" +
                "  {\n" +
                "    \"author\": \"Chinua Achebe\",\n" +
                "    \"country\": \"Nigeria\",\n" +
                "    \"imageLink\": \"images/things-fall-apart.jpg\",\n" +
                "    \"language\": \"English\",\n" +
                "    \"link\": \"https://en.wikipedia.org/wiki/Things_Fall_Apart\\n\",\n" +
                "    \"pages\": 209,\n" +
                "    \"title\": \"Things Fall Apart\",\n" +
                "    \"year\": 1958\n" +
                "  },\n" +
                "  {\n" +
                "    \"author\": \"Hans Christian Andersen\",\n" +
                "    \"country\": \"Denmark\",\n" +
                "    \"imageLink\": \"images/fairy-tales.jpg\",\n" +
                "    \"language\": \"Danish\",\n" +
                "    \"link\": \"https://en.wikipedia.org/wiki/Fairy_Tales_Told_for_Children._First_Collection.\\n\",\n" +
                "    \"pages\": 784,\n" +
                "    \"title\": \"Fairy tales\",\n" +
                "    \"year\": 1836\n" +
                "  },\n" +
                "  {\n" +
                "    \"author\": \"Dante Alighieri\",\n" +
                "    \"country\": \"Italy\",\n" +
                "    \"imageLink\": \"images/the-divine-comedy.jpg\",\n" +
                "    \"language\": \"Italian\",\n" +
                "    \"link\": \"https://en.wikipedia.org/wiki/Divine_Comedy\\n\",\n" +
                "    \"pages\": 928,\n" +
                "    \"title\": \"The Divine Comedy\",\n" +
                "    \"year\": 1315\n" +
                "  }\n" +
                "]");
        return ResponseEntity.ok(json);
    }

    @GetMapping("/")
    @ResponseBody
    public ResponseEntity<JsonNode> get() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode json = mapper.readTree("[\n" +
                "  {\n" +
                "    \"author\": \"Chinua Achebe\",\n" +
                "    \"country\": \"Nigeria\",\n" +
                "    \"imageLink\": \"images/things-fall-apart.jpg\",\n" +
                "    \"language\": \"English\",\n" +
                "    \"link\": \"https://en.wikipedia.org/wiki/Things_Fall_Apart\\n\",\n" +
                "    \"pages\": 209,\n" +
                "    \"title\": \"Things Fall Apart\",\n" +
                "    \"year\": 1958\n" +
                "  },\n" +
                "  {\n" +
                "    \"author\": \"Hans Christian Andersen\",\n" +
                "    \"country\": \"Denmark\",\n" +
                "    \"imageLink\": \"images/fairy-tales.jpg\",\n" +
                "    \"language\": \"Danish\",\n" +
                "    \"link\": \"https://en.wikipedia.org/wiki/Fairy_Tales_Told_for_Children._First_Collection.\\n\",\n" +
                "    \"pages\": 784,\n" +
                "    \"title\": \"Fairy tales\",\n" +
                "    \"year\": 1836\n" +
                "  },\n" +
                "  {\n" +
                "    \"author\": \"Dante Alighieri\",\n" +
                "    \"country\": \"Italy\",\n" +
                "    \"imageLink\": \"images/the-divine-comedy.jpg\",\n" +
                "    \"language\": \"Italian\",\n" +
                "    \"link\": \"https://en.wikipedia.org/wiki/Divine_Comedy\\n\",\n" +
                "    \"pages\": 928,\n" +
                "    \"title\": \"The Divine Comedy\",\n" +
                "    \"year\": 1315\n" +
                "  }\n" +
                "]");
        return ResponseEntity.ok(json);
    }

    @GetMapping("/")
    @ResponseBody
    public ResponseEntity<JsonNode> get() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode json = mapper.readTree("[\n" +
                "  {\n" +
                "    \"author\": \"Chinua Achebe\",\n" +
                "    \"country\": \"Nigeria\",\n" +
                "    \"imageLink\": \"images/things-fall-apart.jpg\",\n" +
                "    \"language\": \"English\",\n" +
                "    \"link\": \"https://en.wikipedia.org/wiki/Things_Fall_Apart\\n\",\n" +
                "    \"pages\": 209,\n" +
                "    \"title\": \"Things Fall Apart\",\n" +
                "    \"year\": 1958\n" +
                "  },\n" +
                "  {\n" +
                "    \"author\": \"Hans Christian Andersen\",\n" +
                "    \"country\": \"Denmark\",\n" +
                "    \"imageLink\": \"images/fairy-tales.jpg\",\n" +
                "    \"language\": \"Danish\",\n" +
                "    \"link\": \"https://en.wikipedia.org/wiki/Fairy_Tales_Told_for_Children._First_Collection.\\n\",\n" +
                "    \"pages\": 784,\n" +
                "    \"title\": \"Fairy tales\",\n" +
                "    \"year\": 1836\n" +
                "  },\n" +
                "  {\n" +
                "    \"author\": \"Dante Alighieri\",\n" +
                "    \"country\": \"Italy\",\n" +
                "    \"imageLink\": \"images/the-divine-comedy.jpg\",\n" +
                "    \"language\": \"Italian\",\n" +
                "    \"link\": \"https://en.wikipedia.org/wiki/Divine_Comedy\\n\",\n" +
                "    \"pages\": 928,\n" +
                "    \"title\": \"The Divine Comedy\",\n" +
                "    \"year\": 1315\n" +
                "  }\n" +
                "]");
        return ResponseEntity.ok(json);
    }
}