package xeredi.argo.proceso;

import java.io.File;
import java.util.Comparator;

// TODO: Auto-generated Javadoc
/**
 * The Class FiledateComparator.
 */
public final class FiledateComparator implements Comparator<File> {

    /**
     * {@inheritDoc}
     */
    @Override
    public int compare(final File file1, final File file2) {
        if (file1.lastModified() > file2.lastModified()) {
            return 1;
        }

        if (file2.lastModified() > file1.lastModified()) {
            return -1;
        }

        return 0;
    }

}
