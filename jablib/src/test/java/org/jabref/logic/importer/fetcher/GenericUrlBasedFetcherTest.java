package org.jabref.logic.importer.fetcher;

import java.util.List;

import org.jabref.logic.importer.FetcherException;
import org.jabref.model.entry.BibEntry;
import org.jabref.model.entry.field.StandardField;
import org.jabref.model.entry.types.StandardEntryType;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GenericUrlBasedFetcherTest {

    private GenericUrlBasedFetcher fetcher;

    @BeforeEach
    void setUp() {
        fetcher = new GenericUrlBasedFetcher();
    }

    @Test
    void getNameReturnsURL() {
        assertEquals("URL",fetcher.getName());
    }

    @Test
    void performSearchWithValidUrlReturnsOneEntry() throws FetcherException {
        String url = "https://www.semanticscholar.org/paper/Logic-LangChain%3A-Translating-Natural-Language-to-Lalwani-Lunawat/2ad8dbc163ce289e23e9c02b324c82d9c2fe8190";
        List<BibEntry> results = fetcher.performSearch(url);

        assertEquals(1, results.size());
    }

    @Test
    void performSearchSetsUrlField() throws FetcherException {
        String url = "https://www.semanticscholar.org/paper/Logic-LangChain%3A-Translating-Natural-Language-to-Lalwani-Lunawat/2ad8dbc163ce289e23e9c02b324c82d9c2fe8190";
        List<BibEntry> results = fetcher.performSearch(url);

        assertEquals(url, results.get(0).getField(StandardField.URL).orElse(""));
    }

    @Test
    void performSearchCreatesMiscEntry() throws FetcherException {
        String url = "https://www.semanticscholar.org/paper/Logic-LangChain%3A-Translating-Natural-Language-to-Lalwani-Lunawat/2ad8dbc163ce289e23e9c02b324c82d9c2fe8190";
        List<BibEntry> results = fetcher.performSearch(url);

        assertEquals(StandardEntryType.Misc, results.get(0).getType());
    }

    @Test
    void performSearchWithBlankUrlReturnsEmptyList() throws FetcherException {
        List<BibEntry> results = fetcher.performSearch(" ");

        assertTrue(results.isEmpty());
    }
}
