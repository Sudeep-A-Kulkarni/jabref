<<<<<<< HEAD
package org.jabref.logic.importer.fetcher;

import java.util.List;
import java.util.Locale;

import org.jabref.logic.importer.FetcherException;
import org.jabref.logic.util.URLUtil;
import org.jabref.logic.util.strings.StringUtil;
=======

package org.jabref.logic.importer.fetcher;

import java.util.List;

import org.jabref.logic.importer.FetcherException;
import org.jabref.logic.importer.UrlBasedFetcher;
>>>>>>> origin/main
import org.jabref.model.entry.BibEntry;
import org.jabref.model.entry.field.StandardField;
import org.jabref.model.entry.types.StandardEntryType;

<<<<<<< HEAD
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
=======
public class GenericUrlBasedFetcher implements UrlBasedFetcher {

    @Override
    public String getName() {
        return "URL";
    }

    @Override
    public List<BibEntry> performSearch(String url) throws FetcherException {
        if (url.isBlank()) {
            return List.of();
        }

        String trimmedUrl = url.trim();

        BibEntry entry = new BibEntry(StandardEntryType.Misc).withField(StandardField.URL, trimmedUrl);
        return List.of(entry);
    }
>>>>>>> origin/main
}
