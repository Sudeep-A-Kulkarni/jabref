package org.jabref.logic.importer.fetcher;

import java.util.List;
import java.util.Optional;

import org.jabref.logic.importer.FetcherException;
import org.jabref.model.entry.BibEntry;
import org.jabref.model.entry.field.StandardField;
import org.jabref.model.entry.types.StandardEntryType;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GenericUrlBasedFetcherTest {

    private static final String TEST_URL = "https://gi-radar.de/397-coding-unterstuetzung-im-lauf-der-zeit/";

    private GenericUrlBasedFetcher fetcher;

    @BeforeEach
    void setUp() {
        fetcher = new GenericUrlBasedFetcher();
    }

    @Test
    void getNameReturnsURL() {
<<<<<<< HEAD
        assertEquals("Generic URL Fetcher", fetcher.getName());
    }

    @Test
    void fetchEntryFromUrlWithValidUrlCreatesCorrectEntry() throws FetcherException {
        List<BibEntry> results = fetcher.fetchEntryFromUrl(TEST_URL);

        assertEquals(1, results.size());

        BibEntry entry = results.get(0);
        assertEquals(Optional.of(TEST_URL), entry.getField(StandardField.URL));
        assertEquals(StandardEntryType.Misc, entry.getType());
=======
        assertEquals("URL", fetcher.getName());
    }

    @Test
    void performSearchWithValidUrlReturnsOneEntry() throws FetcherException {
        List<BibEntry> results = fetcher.performSearch(TEST_URL);
        assertEquals(1, results.size());
    }

    @Test
    void performSearchSetsUrlField() throws FetcherException {
        List<BibEntry> results = fetcher.performSearch(TEST_URL);
        assertEquals(Optional.of(TEST_URL), results.get(0).getField(StandardField.URL));
    }

    @Test
    void performSearchCreatesMiscEntry() throws FetcherException {
        List<BibEntry> results = fetcher.performSearch(TEST_URL);
        assertEquals(StandardEntryType.Misc, results.get(0).getType());
>>>>>>> origin/main
    }

    @Test
    void performSearchWithBlankUrlReturnsEmptyList() throws FetcherException {
<<<<<<< HEAD
        List<BibEntry> results = fetcher.fetchEntryFromUrl("   ");
=======
        List<BibEntry> results = fetcher.performSearch("   ");
>>>>>>> origin/main
        assertTrue(results.isEmpty());
    }

    @Test
    void performSearchTrimsUrl() throws FetcherException {
<<<<<<< HEAD
        List<BibEntry> results = fetcher.fetchEntryFromUrl("  " + TEST_URL + "  ");
=======
        List<BibEntry> results = fetcher.performSearch("  " + TEST_URL + "  ");
>>>>>>> origin/main
        assertEquals(Optional.of(TEST_URL), results.get(0).getField(StandardField.URL));
    }
}
