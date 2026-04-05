package org.jabref.logic.importer.fetcher;

import java.util.List;
import java.util.Locale;

import org.jabref.logic.importer.FetcherException;
import org.jabref.logic.util.URLUtil;
import org.jabref.logic.util.strings.StringUtil;
import org.jabref.model.entry.BibEntry;
import org.jabref.model.entry.field.StandardField;
import org.jabref.model.entry.types.StandardEntryType;

public class GenericUrlBasedFetcher {

    public List<BibEntry> fetchEntryFromUrl(String url) throws FetcherException {
        if (StringUtil.isBlank(url)) {
            return List.of();
        }

        String normalizedUrl = url.trim();
        String lower = normalizedUrl.toLowerCase(Locale.ROOT);

        if (!lower.startsWith("http://") && !lower.startsWith("https://")) {
            normalizedUrl = "https://" + normalizedUrl;
        }

        if (!URLUtil.isValidHttpUrl(normalizedUrl)) {
            throw new FetcherException("Invalid URL: " + normalizedUrl);
        }

        BibEntry entry = new BibEntry(StandardEntryType.Misc).withField(StandardField.URL, normalizedUrl);

        return List.of(entry);
    }

    public String getName() {
        return "Generic URL Fetcher";
    }
}
