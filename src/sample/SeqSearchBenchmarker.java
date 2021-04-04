package sample;

public class SeqSearchBenchmarker
{

    public static int Searcher(int[] array, int value) {

        int index;
        int position;
        boolean found;

        index = 0;

        // Stores the default values position and found.
        position = -1;
        found = false;

        // Searches the array.
        while (!found && index < array.length)
        {
            if (array[index] == value)
            {
                found = true;
                position = index + 1;
            }
            index++;
        }

        // Returns the found element's position, or -1 if not found.

        return position;

    }
}