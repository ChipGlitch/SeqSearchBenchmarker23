package sample;

public class BinarySearchBenchmarker {

    public static int Searcher(int[] array, int value) {

        int first;
        int last;
        int middle;
        int position;
        boolean found;

        // Initialize values.

        first = 0;
        last = array.length - 1;

        // Stores the default values position and found.
        position = -1;
        found = false;

        // Searches the array.
        while (!found && first <= last) {
            // Midpoint calculation.
            middle = (first + last) / 2;

            // Check to see if value is found at the midpoint.
            if (array[middle] == value) {
                found = true;
                position = middle;
            }
            // Else if the value is in the upper half.
            else if (array[middle] > value)
                last = middle + 1;
        }

        // Returns the found element's position, or -1 if not found.

        return position;
    }
}
