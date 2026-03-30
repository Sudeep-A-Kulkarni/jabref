package org.jabref.logic.importer.fetcher;

import java.util.Collections;
import java.util.List;

import org.jabref.logic.importer.FetcherException;
import org.jabref.logic.importer.UrlBasedFetcher;
import org.jabref.logic.util.URLUtil;
import org.jabref.logic.util.strings.StringUtil;
import org.jabref.model.entry.BibEntry;
import org.jabref.model.entry.field.StandardField;
import org.jabref.model.entry.types.StandardEntryType;

public class GenericUrlBasedFetcher implements UrlBasedFetcher {

    @Override
    public List<BibEntry> performSearch(String url) throws FetcherException {
        if (StringUtil.isBlank(url)) {
            return Collections.emptyList();
        }

        String normalizedUrl = url.trim();
        if (!normalizedUrl.toLowerCase().startsWith("http://") && !normalizedUrl.toLowerCase().startsWith("https://")) {
            normalizedUrl = "https://" + normalizedUrl;
        }

        if (!URLUtil.isValidHttpUrl(normalizedUrl)) {
            throw new FetcherException("Invalid URL: " + normalizedUrl);
        }

        // Create a new @Misc entry and set the URL field
        BibEntry entry = new BibEntry(StandardEntryType.Misc);
        entry.setField(StandardField.URL, normalizedUrl);

        return Collections.singletonList(entry);
    }

    @Override
    public String getName() {
        return "Generic URL Fetcher";
    }
}
