References: 
    + https://runestone.academy/ns/books/published/cppds/LinearLinked/ImplementinganOrderedList.html - for detecting last and first nodes.

Description:
    + Ordered Country Sorter algorithm.
    + To use the country sorter, write the name of a .csv file with country data inside (in this case, it is CountryDataset.csv) for the first argument. Then, for the second argument, write the number of countries you want to display for highest and lowest amounts of a category. Then, write down the category in double quotation marks ("") to filter out countries you want displayed.
    + For example: java CountrySorterList CountryDataset.csv 5 "Population Total" will give you:
        Lowest:
        1. Tuvalu 0.01
        2. Palau 0.02
        3. British Virgin Islands 0.03
        4. Gibraltar 0.03
        5. Liechtenstein 0.04
        ------
        Highest:
        1. China 1364.8
        2. India 1294.75
        3. United States 318.37
        4. Indonesia 254.95
        5. Brazil 202.69
    + The program will exit once the statistics are displayed.

Discussion:
    + Using the CountryComparator class will allow us to make comparisons between two objects without having to call a method of either objects, reducing the amount of computation needed.

