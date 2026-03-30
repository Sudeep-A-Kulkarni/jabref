
package org.jabref.logic.importer.fetcher;

import java.util.List;

import org.jabref.logic.importer.FetcherException;
import org.jabref.logic.importer.UrlBasedFetcher;
import org.jabref.logic.l10n.Localization;
import org.jabref.model.entry.BibEntry;
import org.jabref.model.entry.field.StandardField;
import org.jabref.model.entry.types.StandardEntryType;

public class GenericUrlBasedFetcher implements UrlBasedFetcher {

    @Override
    public String getName() {
        return Localization.lang("URL");
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
}
