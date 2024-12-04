package view;

import java.util.Set;

public class ViewUtility {

    /**
     * GetAuthorString for ViewUtility.
     * @param authors authors
     * @return Set of String
     */
    public static String getAuthorString(Set<String> authors) {
        String authorsStr = "";
        final int maxAuthorNum = 2;

        int countAuthorNum = 0;
        for (String author: authors) {
            if (countAuthorNum >= maxAuthorNum) {
                break;
            }

            authorsStr += author;
            if (countAuthorNum < maxAuthorNum - 2) {
                authorsStr += ", ";
            }
            else if (countAuthorNum < maxAuthorNum - 1) {
                if (maxAuthorNum > authors.size()) {
                    authorsStr += " and ";
                }
                else {
                    authorsStr += ", ";
                }
            }
            countAuthorNum += 1;
        }

        if (authors.size() > maxAuthorNum) {
            authorsStr += " and more";
        }
        return authorsStr;
    }
}
