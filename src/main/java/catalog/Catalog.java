package catalog;

import java.util.ArrayList;
import java.util.List;

public class Catalog {

    List<CatalogItem> catalogItems = new ArrayList<>();

    public void addItem(CatalogItem catalogItem) {
        catalogItems.add(catalogItem);
    }

    public double averagePageNumberOver(int over) {
        if (over < 1) {
            throw new IllegalArgumentException("Page number must be positive");
        }
        double sum = 0.0;
        int divider = 0;
        for (CatalogItem catalogItem : catalogItems) {
            if (catalogItem.numberOfPagesAtOneItem() > over) {
                divider++;
                sum += catalogItem.numberOfPagesAtOneItem();
            }
        }
        if (divider == 0) {
            throw new IllegalArgumentException("No page");
        }
        return sum / divider;
    }

    public void deleteItemByRegistrationNumber(String delete) {
        List<CatalogItem> toRemove = new ArrayList<>();
        for (CatalogItem catalogItem : catalogItems) {
            if (catalogItem.getRegistrationNumber().equals(delete)) {
                toRemove.add(catalogItem);
            }
        }
        catalogItems.removeAll(toRemove);
    }

    public List<CatalogItem> findByCriteria(SearchCriteria searchCriteria) {
        List<CatalogItem> items = new ArrayList<>();
        for (CatalogItem catalogItem : catalogItems) {
            if (hasTitleOrContributor(catalogItem, searchCriteria)) {
                items.add(catalogItem);
            }
        }
        return items;
    }

    private boolean hasTitleOrContributor(CatalogItem catalogItem, SearchCriteria searchCriteria) {
        return catalogItem.getContributors().contains(searchCriteria.getContributor())
                || catalogItem.getTitles().contains(searchCriteria.getTitle());
    }

    public int getAllPageNumber() {
        int sum = 0;
        for (CatalogItem catalogItem : catalogItems) {
            sum += catalogItem.numberOfPagesAtOneItem();
        }
        return sum;
    }

    public int getFullLength() {
        int sum = 0;
        for (CatalogItem catalogItem : catalogItems) {
            sum += catalogItem.fullLengthAtOneItem();
        }
        return sum;
    }

    public List<CatalogItem> getAudioLibraryItems() {
        List<CatalogItem> audio = new ArrayList<>();
        for (CatalogItem catalogItem : catalogItems) {
            if (catalogItem.hasAudioFeature()) {
                audio.add(catalogItem);
            }
        }
        return audio;
    }

    public List<CatalogItem> getPrintedLibraryItems() {
        List<CatalogItem> print = new ArrayList<>();
        for (CatalogItem catalogItem : catalogItems) {
            if (catalogItem.hasPrintedFeature()) {
                print.add(catalogItem);
            }
        }
        return print;
    }

}
