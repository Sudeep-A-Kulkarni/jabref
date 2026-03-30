package org.jabref.logic.importer;

import java.util.List;

import org.jabref.logic.importer.FetcherException;
import org.jabref.model.entry.BibEntry;

public interface UrlBasedFetcher extends WebFetcher {
    List<BibEntry> performSearch(String url) throws FetcherException;
}
