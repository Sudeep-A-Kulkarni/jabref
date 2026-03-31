package org.jabref.logic.importer;

import java.util.List;

import org.jabref.model.entry.BibEntry;

public interface UrlBasedFetcher extends WebFetcher {
    List<BibEntry> fetchEntryFromUrl(String url) throws FetcherException;
}
